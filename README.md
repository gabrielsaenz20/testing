# BYD Electric Vehicle Infotainment Application

## Overview

This is an Android application designed to be installed on BYD electric vehicle infotainment systems. The app provides real-time vehicle information, camera feeds, and various monitoring capabilities directly on the vehicle's Android-based infotainment display.

## Features

The application displays and monitors the following vehicle information:

### Vehicle Status Information
- **Battery Status**: Current charge level and battery health
- **Charging Information**: Charging status and rates
- **Location**: GPS coordinates and navigation data
- **Doors Status**: Real-time status of all vehicle doors (open/closed/locked)
- **Speed**: Current vehicle speed
- **RPM**: Engine/motor revolutions per minute
- **Gearbox Mode**: Current transmission mode and driving state

### Camera System
- **Multi-Camera Feed**: Real-time video feeds from multiple vehicle cameras
- **Audio Support**: Camera feeds include audio streaming capability
- **Video Processing**: Advanced video processing including:
  - YUV format conversion (NV12/NV21 to I420)
  - Multi-camera grid layout (2x2 display)
  - CLAHE (Contrast Limited Adaptive Histogram Equalization) for image enhancement
  - Motion detection using MOG2 (Mixture of Gaussians) algorithm
  - Shadow filtering and foreground detection

## How the App Gets Information from the Vehicle

The application uses multiple methods to retrieve data from the BYD vehicle:

### 1. **Native Libraries (Primary Method)**
The app relies heavily on native C/C++ libraries located in `resources/lib/arm64-v8a/`:
- `libelectrolib.so` - Main vehicle communication library
- `libelectropkg.so` - Package management and data handling
- `libnative-lib.so` - Video/audio processing and utilities

These native libraries are responsible for:
- Direct communication with vehicle's CAN bus (Controller Area Network)
- Reading vehicle sensors and actuators
- Processing raw vehicle data into usable formats
- Managing real-time data streams

### 2. **Android Hardware Abstraction Layer (HAL)**
The app interfaces with Android's HAL to access:
- Vehicle-specific hardware sensors
- Camera devices
- GPS and location services
- Audio input/output devices

### 3. **Permissions-Based Access**
The AndroidManifest.xml declares necessary permissions for:
- `ACCESS_FINE_LOCATION` - GPS data
- `RECORD_AUDIO` - Microphone for camera audio
- `WRITE_EXTERNAL_STORAGE` - Data logging
- `READ_PHONE_STATE` - System state information
- `WAKE_LOCK` - Keep system active during monitoring

### 4. **Foreground Service**
The `MainService` class runs as a foreground service that:
- Continuously monitors vehicle status
- Maintains persistent connection to vehicle systems
- Processes real-time data streams
- Handles background updates even when UI is not visible

### 5. **Boot Receiver**
The `BootReceiver` ensures the app starts automatically when the vehicle's infotainment system boots up, providing seamless integration.

## Application Architecture

### Core Components

1. **MainActivity** (`br.com.rory.electro.MainActivity`)
   - Main user interface
   - Displays vehicle information and camera feeds
   - Handles user interactions

2. **MyApplication** (`br.com.rory.electro.MyApplication`)
   - Application initialization
   - Global state management
   - Native library loading

3. **MainService** (`br.com.rory.electro.service.MainService`)
   - Background service for continuous vehicle monitoring
   - Data collection and processing
   - Event handling and notifications

4. **Vehicle Data Loggers** (`br.com.rory.electro.logs.logs/`)
   - `DoorStateChangedLog` - Tracks door state changes
   - `GearboxModeChangedLog` - Monitors transmission/gear changes
   - `MCURebootLog` - Records system reboots
   - `SeatComfortRunLog` - Logs seat adjustment activities
   - `ElectroInitLog` - Initialization events

5. **Video Processing Utilities**
   - `YuvUtils` - YUV format conversions for camera feeds
   - `MOG2Utils` - Motion detection and background subtraction

### Data Flow

```
Vehicle CAN Bus → Native Libraries → Android HAL → MainService → MainActivity → Display
                                                      ↓
                                                  Database Storage
                                                      ↓
                                                  Event Logs
```

## Technical Details

### Supported Android Version
- Minimum SDK: 25 (Android 7.1)
- Target SDK: 25

### Package Name
`br.com.rory.electro`

### Key Technologies
- **Native Development**: C/C++ for performance-critical vehicle communication
- **WebRTC**: Real-time camera streaming (`libjingle_peerconnection_so.so`)
- **TensorFlow Lite**: Machine learning for video analysis (`libtensorflowlite_jni.so`)
- **EventBus**: Event-driven architecture for component communication
- **SQLite**: Local database for storing vehicle data history

### Database
The app maintains a local SQLite database with multiple migration versions (Version 1-14), suggesting continuous development and feature additions for storing:
- Historical vehicle data
- User preferences
- Cached information
- Event logs

## Security Features

- Signature-level permissions for sensitive operations
- Secure settings access control
- Encrypted data storage
- Protected broadcast receivers
- File provider for secure file sharing

## Installation

This application is designed to be installed as a system app on BYD vehicle infotainment units running Android. It requires:
1. Android 7.1 or higher
2. System-level permissions
3. Access to vehicle hardware interfaces
4. ARM64-v8a architecture processor

## Important Notes

⚠️ **This is decompiled code** - The source files have been decompiled from an APK, resulting in:
- Obfuscated class and method names (e.g., `a.java`, `b.java`)
- Native method declarations without implementations
- Limited inline documentation

⚠️ **Vehicle Integration** - This app is specifically designed for BYD vehicle systems and requires:
- Proper CAN bus access
- Vehicle-specific hardware interfaces
- Authorized installation on the infotainment system

## License

Copyright information not available in decompiled sources. This appears to be proprietary software for BYD electric vehicles.
