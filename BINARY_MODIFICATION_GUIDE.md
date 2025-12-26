# Native Library Structure and Server Address Modification

## Overview

This document explains where the server addresses are located in the native `.so` libraries, their structure, and whether/how they can be modified.

## Server Addresses Location

The server addresses are hardcoded as **string literals** in the native library `libelectropkg.so`. They are stored in the **read-only data section** (`.rodata`) of the ELF binary.

### Library Information

**File:** `resources/lib/arm64-v8a/libelectropkg.so`
- **Type:** ELF 64-bit LSB shared object
- **Architecture:** ARM aarch64 (64-bit ARM)
- **Size:** 904 KB (925,696 bytes)
- **Format:** Dynamically linked library
- **State:** Stripped (debug symbols removed)
- **Build ID:** 40772a3c25c0a22ff45bcacb3b3492ea82669cd0

### Server Address Locations (Hex Offsets)

Found using `strings -t x` and `readelf`:

```
Offset (Hex)  | String Content
--------------|---------------------------------------------------------
0x108cd       | "Failed to connect to electro.app.br" (error message)
0x1d767       | "electro.app.br" (main domain)
0x1ebcb       | "http://crash.electro.app.br:8080/report"
0x1ebfc       | "https://electro.app.br/app-log/"
0x1f6d9       | "nl.electro.app.br" (Netherlands server)
```

These offsets are in the `.rodata` section (read-only data):

```
Section: .rodata
Offset in .rodata:
  [  4d95]  "Failed to connect to electro.app.br"
  [ 11c2f]  "electro.app.br"
  [ 13093]  "http://crash.electro.app.br:8080/report"
  [ 130c4]  "https://electro.app.br/app-log/"
  [ 13ba1]  "nl.electro.app.br"
```

## Binary Structure Visualization

### Hex Dump Example

Here's what the crash reporting URL looks like in the binary (at offset 0x1ebcb):

```
Offset      Hex Values                                    ASCII
---------------------------------------------------------------------------
0001ebc0    ... 68 74 74 70 3a 2f 2f 63 72 61 73 68 2e  ...http://crash.
0001ebd0    65 6c 65 63 74 72 6f 2e 61 70 70 2e 62 72  electro.app.br
0001ebe0    3a 38 30 38 30 2f 72 65 70 6f 72 74 00 68  :8080/report.h
0001ebf0    74 74 70 73 3a 2f 2f 00 68 74 74 70 73 3a  ttps://.https:
0001ec00    2f 2f 65 6c 65 63 74 72 6f 2e 61 70 70 2e  //electro.app.
0001ec10    62 72 2f 61 70 70 2d 6c 6f 67 2f 00        br/app-log/.
```

**Breakdown:**
- `68 74 74 70` = "http"
- `3a 2f 2f` = "://"
- `63 72 61 73 68 2e 65 6c 65 63 74 72 6f` = "crash.electro"
- `2e 61 70 70 2e 62 72` = ".app.br"
- `3a 38 30 38 30` = ":8080"
- `2f 72 65 70 6f 72 74` = "/report"
- `00` = null terminator

### ELF Structure

```
┌─────────────────────────────────────┐
│        ELF Header                    │  - Identifies file as ELF
│        (Magic: 7f 45 4c 46)         │  - Specifies ARM64 architecture
└─────────────────────────────────────┘
           ↓
┌─────────────────────────────────────┐
│      Program Headers                 │  - Describes memory segments
│      (LOAD, DYNAMIC, etc.)          │  - Runtime loading info
└─────────────────────────────────────┘
           ↓
┌─────────────────────────────────────┐
│      .text Section                   │  - Executable code
│      (Native C++ functions)         │  - JNI implementations
└─────────────────────────────────────┘
           ↓
┌─────────────────────────────────────┐
│      .rodata Section                 │  ← **SERVER ADDRESSES HERE**
│      (Read-only data)               │  - String literals
│                                      │  - Constants
│   - "electro.app.br"                │  - Cannot be changed at runtime
│   - "crash.electro.app.br:8080"    │
│   - "https://electro.app.br/..."   │
│   - "nl.electro.app.br"             │
└─────────────────────────────────────┘
           ↓
┌─────────────────────────────────────┐
│      .data Section                   │  - Initialized writable data
│      (Mutable global variables)     │
└─────────────────────────────────────┘
           ↓
┌─────────────────────────────────────┐
│      .dynamic Section                │  - Dynamic linking info
│      (Dependencies, symbols)        │
└─────────────────────────────────────┘
           ↓
┌─────────────────────────────────────┐
│      Section Headers                 │  - Describes all sections
└─────────────────────────────────────┘
```

## Can Server Addresses Be Modified?

### Short Answer: **Yes, but with significant effort and risks**

### Modification Methods

#### 1. **Binary Hex Editing** (Direct modification)

**Steps:**
1. Open `libelectropkg.so` in a hex editor
2. Navigate to the offset (e.g., 0x1ebcb for crash server)
3. Replace bytes with new URL
4. **Critical constraint:** New URL must be ≤ original length

**Example - Changing crash server:**

Original (40 bytes):
```
http://crash.electro.app.br:8080/report
```

Could change to (same length):
```
http://custom.myserver.com:8080/report
```

**Cannot change to (too long - would corrupt next string):**
```
http://my-very-long-domain-name.com:8080/report
```

**Tools:**
- `hexedit` (Linux)
- HxD (Windows)
- `010 Editor` (Cross-platform)
- `vim` with `xxd` mode

**Command Example:**
```bash
# Create backup
cp libelectropkg.so libelectropkg.so.backup

# Edit with hexedit
hexedit libelectropkg.so
# Navigate to offset 0x1ebcb
# Replace bytes carefully
# Save and exit

# Verify changes
strings libelectropkg.so | grep "crash"
```

#### 2. **Binary Patching** (Automated)

Create a patch script:

```python
#!/usr/bin/env python3
import sys

def patch_so_file(filename, offset, old_str, new_str):
    """Patch a .so file with new server address"""
    
    # Ensure new string fits in old string's space
    if len(new_str) > len(old_str):
        print(f"Error: New string ({len(new_str)} bytes) longer than old ({len(old_str)} bytes)")
        return False
    
    # Pad new string with null bytes if shorter
    new_bytes = new_str.encode('utf-8').ljust(len(old_str), b'\x00')
    
    with open(filename, 'r+b') as f:
        # Seek to offset
        f.seek(offset)
        
        # Verify old string
        old_bytes = f.read(len(old_str))
        if old_bytes != old_str.encode('utf-8'):
            print(f"Warning: Expected '{old_str}' but found '{old_bytes.decode('utf-8', errors='ignore')}'")
        
        # Write new string
        f.seek(offset)
        f.write(new_bytes)
        
    return True

# Example usage
if __name__ == "__main__":
    # Patch crash server address
    patch_so_file(
        "libelectropkg.so",
        0x1ebcb,  # Offset
        "http://crash.electro.app.br:8080/report",
        "http://custom.example.com:8080/report"
    )
    
    # Patch logging server
    patch_so_file(
        "libelectropkg.so",
        0x1ebfc,
        "https://electro.app.br/app-log/",
        "https://custom.example.com/log/"
    )
```

#### 3. **APK Modification & Re-signing**

**Complete Process:**

```bash
# 1. Decompile APK
apktool d original.apk -o decompiled/

# 2. Modify the .so file
cd decompiled/lib/arm64-v8a/
hexedit libelectropkg.so  # Make changes

# 3. Rebuild APK
cd ../../..
apktool b decompiled/ -o modified.apk

# 4. Align APK
zipalign -v 4 modified.apk modified-aligned.apk

# 5. Sign APK with your key
apksigner sign --ks my-release-key.jks \
    --ks-key-alias my-key-alias \
    --out modified-signed.apk \
    modified-aligned.apk

# 6. Install on device
adb install modified-signed.apk
```

#### 4. **Runtime Hooking** (No binary modification)

Use frameworks like Frida or Xposed to intercept and redirect:

**Frida Script Example:**

```javascript
// Hook native string functions
Interceptor.attach(Module.findExportByName(null, "fopen"), {
    onEnter: function(args) {
        var path = Memory.readUtf8String(args[0]);
        if (path.includes("electro.app.br")) {
            // Redirect to custom server
            var newPath = path.replace("electro.app.br", "custom.example.com");
            Memory.writeUtf8String(args[0], newPath);
        }
    }
});

// Hook network connections
Interceptor.attach(Module.findExportByName(null, "connect"), {
    onEnter: function(args) {
        // Intercept and redirect connections
    }
});
```

**Advantages:**
- No APK modification needed
- Can be changed dynamically
- Easier to test

**Disadvantages:**
- Requires root access
- Device-specific setup
- May not work on all ROMs

## Technical Constraints

### Why Strings Can't Be Easily Lengthened

**ELF Layout Problem:**

```
Before:
┌─────────────────────────────┐
│ "http://crash.electro.a..."│  40 bytes
├─────────────────────────────┤
│ "https://electro.app.br..."│  Next string (immediate)
└─────────────────────────────┘

After attempting to lengthen:
┌──────────────────────────────────────┐
│ "http://my-very-long-server..."      │  60 bytes
├──────────────────────────────────────┤
│ CORRUPTED - overwrote next string    │  ← PROBLEM!
└──────────────────────────────────────┘
```

**Solution:** Add string in unused space and update pointer (complex)

### String Length Limits

Current strings and their max lengths:

| Original String | Length | Max New Length |
|----------------|--------|----------------|
| `electro.app.br` | 14 | 14 bytes |
| `http://crash.electro.app.br:8080/report` | 40 | 40 bytes |
| `https://electro.app.br/app-log/` | 32 | 32 bytes |
| `nl.electro.app.br` | 18 | 18 bytes |

## Risks and Warnings

### ⚠️ Security Risks

1. **Signature Verification**
   - Modified APK won't match original signature
   - Certificate pinning may detect changes
   - May trigger anti-tampering measures

2. **Legal Implications**
   - Modifying app may violate terms of service
   - Could void warranties
   - May be illegal in some jurisdictions

3. **Safety Concerns**
   - Vehicle software controls safety-critical systems
   - Incorrect modifications could cause malfunctions
   - Data sent to wrong server may expose private information

4. **Update Issues**
   - Modified app won't receive official updates
   - May become incompatible with server APIs
   - Security patches won't be applied

### ⚠️ Technical Risks

1. **App Stability**
   - Incorrect hex edits can crash the app
   - May corrupt other data structures
   - Could cause unpredictable behavior

2. **Certificate Pinning Failure**
   - App validates `electro.app.br` certificate
   - Custom server needs matching certificate
   - Otherwise, all HTTPS requests will fail

3. **API Compatibility**
   - Custom server must implement same API
   - Must handle all message types correctly
   - Authentication tokens may not work

## Legitimate Use Cases

### When Modification Might Be Appropriate

1. **Development/Testing**
   - Testing app behavior with local server
   - Debugging network issues
   - Analyzing API structure

2. **Privacy Protection**
   - Redirecting to self-hosted server
   - Preventing data leakage
   - Network traffic analysis

3. **Research**
   - Security research
   - Reverse engineering education
   - Understanding vehicle communication

**Note:** Always comply with local laws and respect intellectual property.

## Alternative: Configuration Override

### Better Approach: Configuration File

Instead of modifying binaries, the app could be designed to:

1. **Check for config file** first: `/sdcard/electro/config.json`
2. **Use hardcoded addresses** as fallback

**Example config.json:**
```json
{
  "servers": {
    "crash_report": "https://custom.example.com:8080/report",
    "app_log": "https://custom.example.com/app-log/",
    "main": "custom.example.com",
    "regional": "eu.custom.example.com"
  },
  "certificate_pinning": false,
  "debug_mode": true
}
```

**This approach:**
- ✅ No binary modification needed
- ✅ Easy to change and test
- ✅ Maintains app signature
- ✅ Can be version-controlled
- ❌ Requires app support (not currently implemented)

## Verification After Modification

### Check Modified Strings

```bash
# Verify strings were changed
strings libelectropkg.so | grep -E "crash|electro.app"

# Compare with original
diff <(strings libelectropkg.so.backup) <(strings libelectropkg.so)

# Check file integrity
md5sum libelectropkg.so
# Should differ from original
```

### Test Modified APK

```bash
# Install on device
adb install modified-signed.apk

# Monitor logs for connection attempts
adb logcat | grep -E "electro|crash|http"

# Check if app connects to new server
adb shell
su
tcpdump -i any -nn | grep "custom.example.com"
```

## Tools Required

### For Binary Analysis
- `strings` - Extract strings from binary
- `readelf` - Analyze ELF structure
- `objdump` - Disassemble code
- `hexdump` / `xxd` - View hex content
- `file` - Identify file type

### For Modification
- `hexedit` - Interactive hex editor
- `010 Editor` - Professional hex editor
- Python with `struct` module - Automated patching
- `apktool` - APK decompile/rebuild
- `apksigner` - APK signing
- `zipalign` - APK optimization

### For Runtime Analysis
- `Frida` - Dynamic instrumentation
- `Xposed Framework` - Runtime hooks
- `tcpdump` - Network traffic capture
- `Wireshark` - Traffic analysis

## Conclusion

**Server addresses in `libelectropkg.so`:**
- ✅ Are stored as string literals in `.rodata` section
- ✅ Can be located at specific hex offsets
- ✅ Can be modified with hex editing (within length constraints)
- ⚠️ Modification requires significant technical knowledge
- ⚠️ Carries security, legal, and safety risks
- ⚠️ Modified app must be re-signed with custom certificate
- ❌ Should only be done for legitimate development/research purposes

**Recommendation:** If you need to redirect the app to custom servers, consider:
1. Setting up proxy/DNS redirect instead
2. Using runtime hooking frameworks (Frida)
3. Requesting developer to add configuration support
4. Understanding the significant risks involved in binary modification

**For research and educational purposes only.** Always comply with applicable laws and regulations.
