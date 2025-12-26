package br.com.rory.electro.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import br.com.rory.electro.c.a.a.e;
import br.com.rory.electro.f.f;
import br.com.rory.electro.i.m;
import com.rory.electro.NativeLoader;

/**
 * MainService - Core background service for continuous vehicle monitoring
 * 
 * This service runs in the foreground (with a persistent notification) to:
 * - Continuously collect real-time vehicle data from CAN bus
 * - Monitor battery status, charging state, and energy consumption
 * - Track vehicle speed, RPM, and gearbox mode
 * - Monitor door status and security systems
 * - Process camera feeds from multiple vehicle cameras
 * - Maintain GPS location tracking
 * - Handle vehicle system events and alerts
 * - Sync data with cloud services
 * 
 * The service maintains:
 * - Wake lock: Keeps CPU active for real-time data collection
 * - WiFi lock: Maintains network connection for cloud sync
 * - Foreground status: Ensures the service isn't killed by the system
 * 
 * Data Collection Methods:
 * 1. Direct CAN bus communication via native libraries
 * 2. Android HAL for standardized vehicle data
 * 3. Camera APIs for video streaming
 * 4. Location services for GPS tracking
 * 
 * The service automatically restarts if killed, ensuring continuous vehicle monitoring.
 */
/* loaded from: classes.dex */
public class MainService extends Service {
    // Service state flags
    private static boolean c;        // Service running state flag
    private static boolean d;        // Initialization complete flag
    private static m e;              // Vehicle data manager instance
    private static String i;         // Device/vehicle identifier
    
    // System locks to keep service active
    private PowerManager.WakeLock a; // Keeps CPU awake for real-time monitoring
    private WifiManager.WifiLock b;  // Maintains WiFi connection for data sync
    
    private boolean f = false;       // Internal state flag
    private Handler g;               // Handler for scheduled tasks
    private Handler h;               // Handler for delayed operations
    private e j;                     // Event processor instance

    /* renamed from: br.com.rory.electro.service.MainService$1, reason: invalid class name */
    class AnonymousClass1 implements br.com.rory.electro.common.a<String> {
        AnonymousClass1() {
        }
    }

    /* renamed from: br.com.rory.electro.service.MainService$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        static {
            NativeLoader.classesInit0(310);
        }

        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.service.MainService$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ int a;

        static {
            NativeLoader.classesInit0(312);
        }

        AnonymousClass3(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.service.MainService$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        static {
            NativeLoader.classesInit0(313);
        }

        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.service.MainService$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        static {
            NativeLoader.classesInit0(314);
        }

        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.service.MainService$6, reason: invalid class name */
    class AnonymousClass6 implements Runnable {
        static {
            NativeLoader.classesInit0(315);
        }

        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(369);
    }

    // Native method declarations - implemented in libelectrolib.so
    
    /**
     * Get vehicle identifier string
     * Returns unique ID for this vehicle (VIN or similar)
     */
    public static native String a();

    /**
     * Start service from context
     * Initializes the MainService and begins vehicle monitoring
     */
    public static native void a(Context context);

    /**
     * Set vehicle identifier
     * @param str Vehicle ID string
     */
    public static native void a(String str);

    /**
     * Configure service state with multiple flags
     * Controls various aspects of vehicle monitoring
     * @param z First state flag (possibly monitoring enabled/disabled)
     * @param z2 Second state flag (possibly data logging enabled/disabled)
     */
    private native void a(boolean z, boolean z2);

    /**
     * Stop service from context
     * Cleanly shuts down vehicle monitoring and releases resources
     */
    public static native void b(Context context);

    /**
     * Check if service is running
     * @return true if MainService is currently active
     */
    public static native boolean b();

    /**
     * Check if service is initialized
     * @return true if vehicle connection is established
     */
    public static native boolean c();

    /**
     * Get vehicle device identifier
     * @return Device or vehicle ID string
     */
    public static native String d();

    /**
     * Create foreground notification
     * Returns the persistent notification shown while service runs
     * Displays current vehicle status in notification area
     */
    private native Notification e();

    /**
     * Initialize vehicle data collection
     * Sets up CAN bus connection and starts polling sensors
     */
    private native void f();

    /**
     * Initialize camera subsystems
     * Establishes connections to vehicle cameras and starts video processing
     */
    private native void g();

    /**
     * Initialize location tracking
     * Starts GPS monitoring and location updates
     */
    private native void h();

    /* JADX INFO: Access modifiers changed from: private */
    /**
     * Process incoming vehicle data
     * Called periodically to handle new CAN bus messages
     * Updates internal state with latest vehicle information
     */
    public native void i();

    /**
     * Initialize background tasks and timers
     * Sets up periodic data collection and sync operations
     */
    private native void j();

    /* JADX INFO: Access modifiers changed from: private */
    /**
     * Cleanup and shutdown procedures
     * Releases CAN bus connection, stops cameras, saves state
     */
    public native void k();

    /**
     * Service binding - returns null as this is a started service, not bound
     */
    @Override // android.app.Service
    @Nullable
    public native IBinder onBind(Intent intent);

    /**
     * Service lifecycle: onCreate
     * Called when service is first created
     * Initializes:
     * - Native libraries
     * - Wake locks
     * - WiFi locks
     * - Event handlers
     * - Database connections
     */
    @Override // android.app.Service
    public native void onCreate();

    /**
     * Service lifecycle: onDestroy
     * Called when service is being shut down
     * Performs cleanup:
     * - Releases wake locks
     * - Closes CAN bus connection
     * - Stops camera streams
     * - Saves final state
     * - Unregisters event listeners
     */
    @Override // android.app.Service
    public native void onDestroy();

    /**
     * EventBus subscriber: Handle HBS (possibly "Host Bus System") initialization
     * Called when vehicle's HBS is ready
     */
    @org.greenrobot.eventbus.m
    public native void onHBSInit(br.com.rory.electro.f.b bVar);

    /**
     * EventBus subscriber: Handle encryption/security keys creation
     * Called when secure communication with vehicle is established
     */
    @org.greenrobot.eventbus.m
    public native void onProvisionKeysCreated(br.com.rory.electro.f.d dVar);

    /**
     * EventBus subscriber: Handle SSBGS (possibly "System Service Bus Gateway System") initialization
     * Called when vehicle's service gateway is ready
     */
    @org.greenrobot.eventbus.m
    public native void onSSBGSInit(f fVar);

    /**
     * Service lifecycle: onStartCommand
     * Called when service is started via startService()
     * 
     * Returns START_STICKY to ensure service restarts if killed
     * 
     * @param intent The intent used to start the service
     * @param i2 Flags about the start request
     * @param i3 Start ID for this specific start request
     * @return START_STICKY to auto-restart service
     */
    @Override // android.app.Service
    public native int onStartCommand(Intent intent, int i2, int i3);
}
