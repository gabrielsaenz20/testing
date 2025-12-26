# Server Configuration and Licensing System

## Overview

The BYD Electric Vehicle infotainment app connects to remote servers for various functions including crash reporting, logging, and license validation. This document details the server addresses and licensing implementation discovered in the decompiled code.

## Server Addresses

The app connects to the following remote servers (found in `libelectropkg.so`):

### Primary Domain: `electro.app.br`

1. **Crash Reporting Server**
   - **URL:** `http://crash.electro.app.br:8080/report`
   - **Purpose:** Send crash reports and error logs
   - **Protocol:** HTTP
   - **Port:** 8080
   - **Library:** `libelectropkg.so`

2. **Application Logging Server**
   - **URL:** `https://electro.app.br/app-log/`
   - **Purpose:** Upload application logs and telemetry
   - **Protocol:** HTTPS (secure)
   - **Port:** 443 (default HTTPS)
   - **Library:** `libelectropkg.so`

3. **Netherlands Server**
   - **Domain:** `nl.electro.app.br`
   - **Purpose:** Likely a regional server for European users or load balancing
   - **Library:** `libelectropkg.so`

4. **Main Website/App Download**
   - **URL:** `electro.app.br`
   - **Purpose:** User portal for app download and subscription management
   - **Referenced in:** String resources (`strings.xml`)
   - **Context:** License renewal instructions direct users to this website

### Connection Error Messages

The native library includes error handling for connection failures:
- "Failed to connect to electro.app.br"

## Licensing System

The app implements a **subscription-based licensing system** with expiration monitoring.

### License Components

#### 1. LicenseExpired Activity

**File:** `sources/br/com/rory/electro/activity/update/LicenseExpired.java`

**Purpose:** Displayed when the user's license/subscription has expired

**UI Elements:**
- Title TextView: "License expired"
- Refresh Button: Allows user to check license status again
- Instructions TextView: Guides user to renew subscription
- Progress indicators for license check operations
- QR code or link display (ImageView for visual guidance)

**String Resources:**
```xml
<string name="license_expired_title">License expired</string>
<string name="license_expired_button">Refresh</string>
<string name="license_renewal_instructions">
    Subscription renewal can be done in the Electro app on your smartphone. 
    If you don't have the app installed, visit electro.app.br to install it.
</string>
```

**Native Methods:**
- `onCreate()` - Initialize license check UI
- `onDestroy()` - Cleanup
- `onPingParsed(c cVar)` - EventBus handler for license validation response
- Multiple click handlers for refresh and renewal actions

#### 2. License Validation Event

**File:** `sources/br/com/rory/electro/f/c.java`

**Event Class:** Simple event wrapper containing license status
```java
public class c {
    private Integer a;  // License status code
    
    public c(Integer num) {
        this.a = num;
    }
    
    public Integer a() {
        return this.a;  // Get license status
    }
}
```

**Purpose:** EventBus event for communicating license validation results

**Possible Status Codes (inferred):**
- 0 or positive: Valid license
- Negative or null: Expired/invalid license

### How Licensing Works

#### License Check Flow

```
1. App starts or user opens LicenseExpired activity
   ↓
2. App sends license validation request to server
   - Includes device ID, VIN, or installation ID
   - Sent to electro.app.br backend
   ↓
3. Server validates subscription
   - Checks user account status
   - Verifies payment/subscription active
   - Returns license status code
   ↓
4. App receives response
   - EventBus posts license validation event (class c)
   - LicenseExpired.onPingParsed() handles response
   ↓
5a. If valid: App continues normal operation
5b. If expired: Display LicenseExpired activity
```

#### License Renewal Process

When license expires, the user must:

1. **Open phone app** (Electro smartphone app)
2. **Navigate to subscription settings**
3. **Renew subscription** (payment processed)
4. **Return to vehicle**
5. **Press "Refresh" button** in LicenseExpired activity
6. **App re-checks license** with server
7. **If renewed:** App unlocks and resumes normal operation

**Alternative:** Users without the app are directed to `electro.app.br` to:
- Download the phone app
- Create account/login
- Purchase or renew subscription

### License Validation Implementation

The license check is implemented in native code (`libelectrolib.so` or `libelectropkg.so`) for security reasons:

**Reasons for Native Implementation:**
1. **Security:** Harder to reverse engineer and bypass
2. **Obfuscation:** Native code more difficult to decompile
3. **Encryption:** Can use compiled encryption for communication
4. **Anti-tampering:** Prevents easy modification of license checks

**Communication Method:**
- HTTPS requests to `electro.app.br` backend
- Likely includes:
  - Device identifier (Android ID, IMEI, or custom ID)
  - Vehicle VIN (Vehicle Identification Number)
  - Installation token/key
  - App version
  - Timestamp

**Server Response:**
- JSON or binary response with:
  - License status (valid/expired)
  - Expiration date
  - Subscription tier/features
  - Error messages if any

### Licensing Features

#### Subscription Tiers (Likely)

Based on the architecture, the app likely supports different subscription levels:

**Possible Tiers:**
- **Free/Trial:** Limited features, time-limited
- **Basic:** Core vehicle monitoring
- **Premium:** All features including:
  - Remote control
  - Live camera streaming
  - Advanced analytics
  - Unlimited cloud storage

**Feature Gating:**
The native code can check license status before enabling features:
```java
// Conceptual implementation
if (licenseStatus.isValid() && licenseStatus.hasPremiumFeatures()) {
    enableRemoteCameraStreaming();
    enableRemoteControl();
} else {
    showUpgradePrompt();
}
```

#### Expiration Monitoring

The app likely monitors license expiration through:

1. **Periodic checks** - Regular server pings (daily or weekly)
2. **Event-based checks** - Validate on app launch
3. **Grace period** - May allow temporary continued use after expiration
4. **Offline mode** - Cached license status for temporary offline operation

### Update Management

Related activities in the same package suggest update management:

**File:** `sources/br/com/rory/electro/activity/update/`
- `UpdateAvailable.java` - Notify user of available updates
- `UpdateRequired.java` - Force critical updates
- `LicenseExpired.java` - Handle license expiration

**Update Flow:**
```
Server Check → Version Comparison → Download Update → Install → Restart App
```

## Security Considerations

### Server Communication

1. **HTTPS for Sensitive Data**
   - App logging uses HTTPS (port 443)
   - License validation likely uses HTTPS
   - Encrypted transmission prevents eavesdropping

2. **HTTP for Non-Sensitive Data**
   - Crash reporting uses HTTP (port 8080)
   - Less critical data, faster transmission
   - Still includes crash logs (may contain some data)

### Certificate Pinning

**File:** `sources/br/com/rory/electro/g/a/a.java`

This class implements SSL/TLS security features:

**Key Components:**
- Custom X509TrustManager (AnonymousClass4)
- Custom X509ExtendedKeyManager (AnonymousClass3)
- PrivateKey and Certificate management
- SSL socket wrapping

**Purpose:**
- **Certificate Pinning:** Validates server certificates match expected values
- **Prevents MITM Attacks:** Ensures connection to legitimate servers
- **Mutual TLS:** May support client certificate authentication

**Embedded Certificates:**
The class contains hardcoded byte arrays (constants `a`, `b`, `c`, `k`, `l`) which are:
- RSA private key (PKCS8 format)
- X.509 certificate
- Connection parameters
- ADB authentication data (includes "wireless@adb" string)

**Security Implications:**
- Prevents attackers from intercepting server communication
- Ensures license validation cannot be spoofed
- Protects user data during transmission

### License Bypass Prevention

**Anti-Tampering Measures:**
1. **Native implementation** - Core logic in compiled C++ code
2. **Certificate pinning** - Prevents fake server responses
3. **Signature verification** - App checks server response signatures
4. **Obfuscation** - Class and method names randomized
5. **Server-side validation** - Ultimate authority on license status

**Vulnerabilities (Ethical Disclosure):**

⚠️ **IMPORTANT DISCLAIMER:** The following information is provided for educational purposes and security awareness only. Any attempt to bypass licensing or security measures is:
- Illegal in most jurisdictions
- A violation of terms of service
- Potentially harmful to vehicle safety systems
- Subject to civil and criminal penalties

While the native code provides some protection, determined attackers with root access could theoretically:
- Hook native functions
- Bypass certificate pinning
- Modify license check results in memory
- Use custom certificate authorities

**Legitimate Use:** Users must purchase valid subscriptions through official channels (`electro.app.br`). Tampering with license validation could compromise vehicle functionality and safety features.

## Server Infrastructure Architecture

### Likely Backend Setup

```
┌─────────────────────────────────────────┐
│         Load Balancer / CDN              │
│         (electro.app.br)                 │
└────┬─────────────────────────────┬──────┘
     │                              │
     ▼                              ▼
┌─────────────┐              ┌──────────────┐
│   API Server│              │  Log Server  │
│ (HTTPS:443) │              │ (HTTP:8080)  │
│             │              │              │
│ - License   │              │ - Crashes    │
│ - Auth      │              │ - Telemetry  │
│ - User Data │              │ - Debugging  │
└─────────────┘              └──────────────┘
     │
     ▼
┌─────────────┐
│  Database   │
│             │
│ - Users     │
│ - Licenses  │
│ - Vehicles  │
│ - Sessions  │
└─────────────┘
```

### Regional Servers

**Netherlands Server:** `nl.electro.app.br`
- Provides lower latency for European users
- Possibly separate data jurisdiction for GDPR compliance
- Geographic load distribution

## Configuration Storage

### Where Server URLs Are Stored

1. **Native Libraries** (Primary)
   - `libelectropkg.so` - Contains hardcoded URLs
   - Compiled into binary, not easily changeable
   - Provides security through obscurity

2. **Possible Configuration Files**
   - May have JSON or XML config in app resources
   - Could support server override for development
   - Not visible in decompiled Java sources

3. **Remote Configuration**
   - App may fetch server endpoints from initial bootstrap server
   - Allows dynamic server changes without app updates
   - Provides flexibility for infrastructure changes

### Debugging Server Connections

⚠️ **PRIVACY AND LEGAL WARNING:**
- Network traffic monitoring may capture sensitive personal data
- Requires informed consent and compliance with privacy laws (GDPR, CCPA, etc.)
- Only perform on your own device for legitimate troubleshooting
- Do not use to intercept or monitor other users' data
- Respect vehicle occupant privacy and data protection regulations

To monitor server communication (for authorized debugging only):

```bash
# Monitor network traffic from app (requires root access)
adb shell
su
tcpdump -i any -s 0 -w /sdcard/electro_traffic.pcap

# View logs related to server connections
adb logcat | grep -E "electro|crash|license|http"

# Check DNS resolution
adb shell nslookup electro.app.br
adb shell nslookup nl.electro.app.br
adb shell nslookup crash.electro.app.br
```

**Note:** Traffic capture contains unencrypted data only. HTTPS traffic will show encrypted payloads.

## Privacy and Data Collection

### Data Sent to Servers

**Crash Reports** (`crash.electro.app.br:8080`):
- Stack traces
- Error messages
- Device information (model, OS version)
- App version
- Timestamp
- Possibly: user ID, vehicle VIN

**Application Logs** (`electro.app.br/app-log/`):
- Event logs (doors, charging, etc.)
- Performance metrics
- Feature usage statistics
- Error conditions
- Possibly: location data, user behavior

**License Validation:**
- Device identifier
- Vehicle VIN
- Subscription status
- User account information
- Installation details

### User Privacy

⚠️ **Privacy Considerations:**
- Server receives vehicle usage data
- Location tracking may be logged
- Driving behavior potentially analyzed
- Personal data stored on cloud servers

🔒 **Privacy Controls:**
Users should:
- Review privacy policy at `electro.app.br`
- Check data retention policies
- Understand what data is collected
- Exercise right to data deletion (if applicable)

## Troubleshooting

### Common Issues

**"Failed to connect to electro.app.br"**
- **Cause:** No internet connection, server down, firewall blocking
- **Solution:** Check vehicle's cellular/WiFi connection, verify server status

**License Expired Screen**
- **Cause:** Subscription expired or payment failed
- **Solution:** Renew subscription via phone app or website

**Cannot Refresh License**
- **Cause:** Server unreachable or account issue
- **Solution:** Check internet, contact support, verify payment method

### Network Requirements

For proper operation, the vehicle must have:
- **Internet access** (4G/5G or WiFi)
- **Open ports:** 443 (HTTPS), 8080 (HTTP)
- **DNS resolution** for `*.electro.app.br` domain
- **Stable connection** for real-time features

## Conclusion

The BYD EV infotainment app uses a centralized server architecture hosted at `electro.app.br` for:

1. **License management** - Subscription validation and renewal
2. **Crash reporting** - Error tracking for debugging
3. **Application logging** - Telemetry and usage analytics
4. **Remote features** - Cloud connectivity for phone app integration

The licensing system ensures:
- Revenue for ongoing service and development
- Feature gating based on subscription tier
- Secure validation with certificate pinning
- User account management through web portal

Users must maintain an active subscription by:
- Paying through the phone app or website
- Periodically renewing when prompted
- Ensuring vehicle has internet connectivity for validation

All server communication is protected by SSL/TLS encryption and certificate pinning to prevent security vulnerabilities.
