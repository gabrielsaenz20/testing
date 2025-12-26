package br.com.rory.electro;

import android.app.Application;
import android.content.Context;
import com.rory.electro.NativeLoader;

/**
 * MyApplication - Application entry point for BYD Electric Vehicle Infotainment System
 * 
 * This class is the first component to be created when the app starts.
 * It handles:
 * - Loading native libraries (libelectrolib.so, libelectropkg.so, etc.)
 * - Initializing global application state
 * - Setting up the connection to vehicle systems
 * - Configuring crash reporting and logging
 * - Initializing database connections
 * 
 * The application maintains a persistent connection to the vehicle's CAN bus
 * throughout its lifecycle to enable real-time data access.
 * 
 * Native libraries are loaded here to ensure they're available before any
 * activities or services attempt to use them.
 */
/* loaded from: classes.dex */
public class MyApplication extends Application {
    static {
        // Initialize native library loader
        // This loads the C/C++ libraries that communicate with vehicle hardware
        NativeLoader.classesInit0(80);
    }

    /**
     * Called when the application context is attached
     * This is the earliest point in the application lifecycle
     * 
     * Native implementation performs:
     * - Loading shared native libraries (.so files)
     * - Initializing JNI bridges for vehicle communication
     * - Setting up memory pools for real-time data handling
     * 
     * @param context The application context
     */
    @Override // android.content.ContextWrapper
    protected native void attachBaseContext(Context context);

    /**
     * Called when the application is starting, before any activities are created
     * 
     * Native implementation performs:
     * - Establishing connection to vehicle CAN bus
     * - Initializing camera subsystems
     * - Setting up database connections
     * - Registering for vehicle system events
     * - Starting background monitoring threads
     * - Configuring EventBus for inter-component communication
     * 
     * This ensures vehicle data is available as soon as the UI is displayed.
     */
    @Override // android.app.Application
    public native void onCreate();
}
