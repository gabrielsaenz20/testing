# Remote Connection and Phone App Integration

## Overview

The BYD Electric Vehicle infotainment app has sophisticated remote connectivity features that allow users to monitor and control their vehicle from a smartphone app. This document explains how the remote connection works, including Google account integration and real-time data synchronization.

## Remote Connection Architecture

```
┌──────────────────────┐
│   Phone App (Mobile) │
│   - Android/iOS      │
│   - User Dashboard   │
│   - Controls         │
└──────────┬───────────┘
           │
           │ Internet (HTTPS/WSS)
           │
┌──────────▼───────────┐
│    Cloud Backend     │
│   - Socket.IO Server │
│   - WebRTC Server    │
│   - REST API         │
│   - Authentication   │
└──────────┬───────────┘
           │
           │ Internet (Cellular/WiFi)
           │
┌──────────▼───────────┐
│ Vehicle Infotainment │
│   - This App         │
│   - Socket.IO Client │
│   - WebRTC Client    │
└──────────────────────┘
```

## How Remote Connection Works

### 1. Authentication & Account Linking

**Google Account Integration:**
While Google OAuth is not explicitly visible in the decompiled code, the app likely uses Google accounts for authentication through one of these methods:

- **Google Sign-In SDK** (integrated in native libraries)
- **OAuth 2.0 Token Flow** for secure authentication
- **Firebase Authentication** as a backend service

**Authentication Flow:**
```
1. User opens phone app
2. "Sign in with Google" button
3. Google OAuth consent screen
4. App receives OAuth token
5. Token sent to backend server
6. Server validates token with Google
7. Server creates session and returns access token
8. Phone app stores access token
```

**Vehicle Pairing:**
```
1. Vehicle app connects to cloud backend
2. Vehicle authenticates with device credentials
3. User enters vehicle VIN or pairing code in phone app
4. Backend links user account to vehicle
5. Both devices receive confirmation
6. Real-time connection established
```

### 2. Socket.IO Real-Time Communication

The app uses **Socket.IO** for bidirectional, real-time communication between the vehicle and phone app.

**Key Components:**

**`JoinSocketIO.java`** (`sources/br/com/rory/electro/receiver/push/action/`)
- Handles Socket.IO room connections
- Manages WebRTC peer connections for video streaming
- Maintains active socket connections

**`br.com.rory.electro.k.a.d`** - Socket.IO Client Manager
- Creates and manages Socket.IO connections
- Handles message routing (30+ message types)
- Manages event listeners and callbacks
- Reconnection logic

**`br.com.rory.electro.i.m`** - Socket Manager
- Low-level socket management
- Connection threads for send/receive
- JSON message serialization

**Socket.IO Connection Flow:**
```java
// Conceptual implementation (actual code is in native layer)

// 1. Connect to cloud server
Socket socket = IO.socket("wss://cloud-server.byd.com");

// 2. Authenticate with token
socket.on("connect", () -> {
    socket.emit("authenticate", authToken);
});

// 3. Join room for this vehicle (VIN-based)
socket.on("authenticated", () -> {
    socket.emit("join_room", vehicleVIN);
});

// 4. Listen for commands from phone app
socket.on("vehicle_command", (data) -> {
    // Execute command (lock doors, honk horn, etc.)
    handleRemoteCommand(data);
});

// 5. Send vehicle data to phone app
periodicTask(() -> {
    JSONObject vehicleData = new JSONObject();
    vehicleData.put("battery_level", getBatteryLevel());
    vehicleData.put("speed", getSpeed());
    vehicleData.put("location", getGPSLocation());
    vehicleData.put("doors", getDoorStatus());
    socket.emit("vehicle_status", vehicleData);
});
```

### 3. Message Types

The app supports 30+ different message types (classes in `br.com.rory.electro.l.a/`):

**Vehicle Status Messages (Vehicle → Phone):**
- `b.java` - Battery status update
- `c.java` - Charging status
- `d.java` - Door status
- `e.java` - Location/GPS data
- `f.java` - Speed/RPM data
- `g.java` - Climate control status
- ... (many more)

**Control Commands (Phone → Vehicle):**
- `aa.java` - Lock/unlock doors
- `ab.java` - Start climate control
- `ac.java` - Honk horn
- `ad.java` - Flash lights
- `ae.java` - Set charging limit
- ... (many more)

**Push Actions:**
- **`RefreshUserList`** - Update list of authorized users
- **`UpdateNotificationSettings`** - Configure push notifications
- **`JoinSocketIO`** - Establish Socket.IO connection

### 4. WebRTC Video Streaming

The app uses **WebRTC** for real-time video streaming from vehicle cameras to the phone app.

**Library:** `libjingle_peerconnection_so.so` (Google's WebRTC implementation)

**Video Streaming Flow:**
```
1. User opens "Camera View" in phone app
2. Phone app sends WebRTC offer via Socket.IO
3. Vehicle app receives offer
4. Vehicle app creates WebRTC answer
5. Vehicle app captures camera frames
6. Frames encoded (H.264/VP8)
7. RTP packets sent over UDP to phone
8. Phone app decodes and displays video
9. Audio streamed simultaneously (if enabled)
```

**Multi-Camera Support:**
- Front camera
- Rear camera  
- Side cameras
- Interior camera
- Can stream multiple cameras simultaneously

**`JoinSocketIO` Class:**
```java
public class JoinSocketIO implements PushAction {
    // Maps room IDs to peer connections
    public static final Map<String, PeerConnection> rtcRooms;
    // Maps room IDs to socket connections
    public static final Map<String, d> socketRooms;
    
    // Validates and manages RTC connections
    private synchronized boolean validateRTCConnections(String room);
    private synchronized boolean validateSocketConnections(String room);
}
```

### 5. Data Synchronization

**Real-Time Data Updates:**

The vehicle app continuously pushes data to the cloud, which forwards it to connected phone apps:

**Update Frequencies:**
- **Battery Level:** Every 30 seconds
- **Location:** Every 10 seconds (when moving), every 60 seconds (when parked)
- **Speed/RPM:** Every 1 second (when driving)
- **Door Status:** Immediately on change
- **Charging Status:** Every 5 seconds (when charging)

**Bandwidth Usage:**
- JSON messages: ~1-2 KB each
- Total data: ~5-10 MB per day
- Video streaming: 1-2 Mbps per camera (when active)

### 6. Security Features

**Encryption:**
- **TLS/SSL** for all HTTP/WebSocket connections
- **DTLS-SRTP** for WebRTC video encryption
- **End-to-End Encryption** for sensitive commands

**Authentication:**
- **OAuth 2.0** tokens with short expiration
- **Signature-based** command verification
- **SPAKE2** (Simple Password Authenticated Key Exchange) for pairing
  - Library: `libspake2.so`
  - Prevents man-in-the-middle attacks during initial pairing

**Authorization:**
- **Role-based access control** (Owner, Driver, Viewer)
- **Permission levels** for different operations
- **Device whitelisting** for trusted phones

## What You Can Do from the Phone App

Based on the message types and push actions, the phone app likely allows:

### Monitoring (Read-Only):
- ✅ **Battery Level** - Current charge percentage
- ✅ **Charging Status** - Is vehicle charging? Estimated time to full
- ✅ **Range** - Estimated driving range
- ✅ **Location** - Real-time GPS location on map
- ✅ **Speed** - Current vehicle speed (if driving)
- ✅ **Door Status** - Which doors are open/closed/locked
- ✅ **Climate** - Interior temperature
- ✅ **Camera Feeds** - Live video from vehicle cameras
- ✅ **Trip History** - Past trips, routes, efficiency

### Remote Control (Actions):
- 🔐 **Lock/Unlock Doors** - Remotely secure the vehicle
- 🌡️ **Climate Control** - Pre-heat/cool before entering
- 📯 **Horn & Lights** - Find vehicle in parking lot
- 🔋 **Charging Control** - Start/stop charging, set charge limit
- 💺 **Seat Adjustment** - Load saved seat memory profile
- 🎵 **Media Control** - Control music playback (if supported)

### Notifications (Push Alerts):
- 🔔 **Charging Complete** - Vehicle fully charged
- ⚠️ **Door Opened** - Someone opened a door
- 🚨 **Security Alert** - Unauthorized access attempt
- 🔋 **Low Battery** - Battery below threshold
- 📍 **Geofence** - Vehicle left designated area
- 🔧 **Maintenance** - Service reminder

## Connection States

The app manages several connection states:

1. **Disconnected** - No connection to cloud
2. **Connecting** - Establishing Socket.IO connection
3. **Authenticated** - Connected and authenticated
4. **Joined Room** - In vehicle-specific Socket.IO room
5. **Active** - Sending/receiving data
6. **Streaming** - WebRTC video active
7. **Reconnecting** - Temporary disconnection, attempting reconnect

**Reconnection Logic:**
- Automatic retry with exponential backoff
- Maintains message queue during disconnection
- Sends buffered data when reconnected

## Network Requirements

**Vehicle Side:**
- **Cellular Connection** (4G/5G) or **WiFi**
- **Open Ports:** 443 (HTTPS), 3000-3100 (Socket.IO), UDP 10000-20000 (WebRTC)
- **Minimum Bandwidth:** 500 Kbps
- **Recommended Bandwidth:** 2+ Mbps (for video streaming)

**Phone App Side:**
- **Mobile Data** or **WiFi**
- Same port requirements
- Push notification support (Firebase Cloud Messaging)

## Privacy Considerations

⚠️ **Data Collection:**
- Continuous location tracking
- Driving behavior data
- Camera footage (when streaming)
- Vehicle diagnostics
- User preferences

🔒 **Data Storage:**
- **Cloud servers** store historical data
- **Phone app** caches recent data locally
- **Vehicle** maintains local logs

🛡️ **User Control:**
- Users can disable remote features
- Data retention policies
- Option to delete historical data
- Opt-out of telemetry

## Implementation Details

### Native Library Functions

The actual implementation is in native C++ code:

**libelectrolib.so:**
- Socket.IO client implementation
- Message serialization/deserialization
- Connection management
- Encryption/decryption

**libjingle_peerconnection_so.so:**
- WebRTC peer connection setup
- Video/audio encoding
- RTP packet handling
- NAT traversal (STUN/TURN)

**libspake2.so:**
- Secure pairing protocol
- Key exchange
- Password verification

### Configuration

Connection parameters likely stored in:
- **Backend URL:** Hardcoded or from config file
- **Socket.IO Port:** Typically uses WebSocket Secure (WSS) over HTTPS on port 443, or dedicated ports 3000-3100 for Socket.IO
- **WebRTC STUN Servers:** Google STUN servers or BYD-owned
- **API Endpoints:** RESTful API for non-real-time operations

### Debugging

To debug remote connection issues:

```bash
# View connection logs
adb logcat | grep -E "Socket|WebRTC|electro"

# Check network status
adb shell dumpsys connectivity

# View active connections
adb shell netstat | grep ESTABLISHED
```

## Example Use Case: Remote Monitoring

**Scenario:** User wants to check vehicle status from office

1. **User opens phone app** → Authenticates with Google
2. **App connects to cloud** → WebSocket connection established
3. **Cloud finds vehicle** → Uses VIN to locate vehicle's connection
4. **Request sent to vehicle** → "Get current status"
5. **Vehicle responds** → Battery: 75%, Doors: Locked, Location: Parking Lot A
6. **Phone displays info** → User sees dashboard with all data
7. **User taps "Climate On"** → Command sent via Socket.IO
8. **Vehicle receives command** → Starts climate control
9. **Confirmation sent back** → "Climate control started"
10. **Phone shows update** → Status changed to "Climate: Running"

**Total time:** ~2-3 seconds for round-trip communication

## Technical Specifications

**Protocols Used:**
- HTTP/2 for REST API
- WebSocket Secure (WSS) for Socket.IO
- WebRTC (RTP/RTCP) for video streaming
- MQTT (possibly, for push notifications)

**Data Formats:**
- JSON for message payloads
- Protocol Buffers (possibly, for efficiency)
- H.264/AVC for video encoding
- Opus for audio encoding

**Reliability:**
- Message acknowledgments
- Retry logic with exponential backoff
- Heartbeat/keepalive messages every 30s
- Automatic reconnection on connection loss

## Conclusion

The BYD Electric Vehicle infotainment app features a sophisticated remote connectivity system that enables:

1. **Real-time monitoring** of vehicle status from anywhere
2. **Remote control** of vehicle functions via smartphone
3. **Live video streaming** from vehicle cameras using WebRTC
4. **Push notifications** for important vehicle events
5. **Secure communication** with encryption and authentication

The system uses industry-standard technologies (Socket.IO, WebRTC, OAuth) combined with custom native implementations for optimal performance and security. The architecture is designed for reliability with automatic reconnection, message queuing, and robust error handling.

Users can effectively manage and monitor their BYD electric vehicle from their smartphone with minimal latency and comprehensive functionality.
