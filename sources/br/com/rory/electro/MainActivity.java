package br.com.rory.electro;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.InputDeviceCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import br.com.rory.electro.d.a.a.a;
import br.com.rory.electro.d.a.a.b;
import br.com.rory.electro.f.e;
import com.rory.electro.NativeLoader;
import java.util.List;
import org.greenrobot.eventbus.m;

/**
 * MainActivity - Primary user interface for BYD Electric Vehicle Infotainment System
 * 
 * This activity serves as the main dashboard for displaying:
 * - Real-time vehicle information (speed, RPM, battery status, etc.)
 * - Door status indicators
 * - Camera feeds from multiple vehicle cameras
 * - Charging information
 * - Location data
 * 
 * NOTE: This is decompiled code with obfuscated names. Most business logic
 * is implemented in native C/C++ libraries (libelectrolib.so) for performance
 * and security reasons. The native methods marked below interface with the
 * vehicle's CAN bus to retrieve real-time data.
 * 
 * The app communicates with the vehicle through:
 * 1. Native JNI methods that access CAN bus data
 * 2. Android HAL (Hardware Abstraction Layer)
 * 3. Camera APIs for video feeds
 * 4. Location services for GPS data
 */
/* loaded from: classes.dex */
public class MainActivity extends a {
    // UI Components for displaying vehicle information
    br.com.rory.electro.d.a.a.a a;  // Adapter for vehicle data list
    List<b> b;                       // List of vehicle data items
    TextView c;                      // Status text view
    ProgressBar d;                   // Loading indicator
    RecyclerView e;                  // List view for displaying data
    LinearLayout f;                  // Container layout
    LinearLayout g;                  // Additional container
    TextView h;                      // Header or title text

    /* renamed from: br.com.rory.electro.MainActivity$1, reason: invalid class name */
    /**
     * Anonymous class for handling camera feed display and processing
     * Manages camera bitmap rendering and status updates
     */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Button a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ TextView c;
        final /* synthetic */ ProgressBar d;

        /* renamed from: br.com.rory.electro.MainActivity$1$1, reason: invalid class name and collision with other inner class name */
        class RunnableC00021 implements Runnable {
            static {
                NativeLoader.classesInit0(280);
            }

            RunnableC00021() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        /* renamed from: br.com.rory.electro.MainActivity$1$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ Bitmap a;
            final /* synthetic */ String b;

            static {
                NativeLoader.classesInit0(282);
            }

            AnonymousClass2(Bitmap bitmap, String str) {
                this.a = bitmap;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        /* renamed from: br.com.rory.electro.MainActivity$1$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            static {
                NativeLoader.classesInit0(283);
            }

            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        /* renamed from: br.com.rory.electro.MainActivity$1$4, reason: invalid class name */
        class AnonymousClass4 implements Runnable {
            static {
                NativeLoader.classesInit0(284);
            }

            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(256);
        }

        AnonymousClass1(Button button, ImageView imageView, TextView textView, ProgressBar progressBar) {
            this.a = button;
            this.b = imageView;
            this.c = textView;
            this.d = progressBar;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.MainActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ Runnable a;

        static {
            NativeLoader.classesInit0(InputDeviceCompat.SOURCE_KEYBOARD);
        }

        AnonymousClass2(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* renamed from: br.com.rory.electro.MainActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        static {
            NativeLoader.classesInit0(272);
        }

        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* renamed from: br.com.rory.electro.MainActivity$4, reason: invalid class name */
    class AnonymousClass4 implements a.InterfaceC0013a {

        /* renamed from: br.com.rory.electro.MainActivity$4$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ int a;

            /* renamed from: br.com.rory.electro.MainActivity$4$1$1, reason: invalid class name and collision with other inner class name */
            class RunnableC00031 implements Runnable {
                static {
                    NativeLoader.classesInit0(android.support.design.R.styleable.AppCompatTheme_windowFixedWidthMinor);
                }

                RunnableC00031() {
                }

                @Override // java.lang.Runnable
                public native void run();
            }

            static {
                NativeLoader.classesInit0(366);
            }

            AnonymousClass1(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(273);
        }

        AnonymousClass4() {
        }

        @Override // br.com.rory.electro.d.a.a.a.InterfaceC0013a
        public native void a(int i);
    }

    /* renamed from: br.com.rory.electro.MainActivity$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ MainActivity a;

        /* renamed from: br.com.rory.electro.MainActivity$5$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            static {
                NativeLoader.classesInit0(387);
            }

            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(267);
        }

        AnonymousClass5(MainActivity mainActivity) {
            this.a = mainActivity;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.MainActivity$6, reason: invalid class name */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ boolean a;

        static {
            NativeLoader.classesInit0(269);
        }

        AnonymousClass6(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.MainActivity$7, reason: invalid class name */
    class AnonymousClass7 implements Runnable {

        /* renamed from: br.com.rory.electro.MainActivity$7$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            static {
                NativeLoader.classesInit0(431);
            }

            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        /* renamed from: br.com.rory.electro.MainActivity$7$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            static {
                NativeLoader.classesInit0(432);
            }

            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(262);
        }

        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(428);
    }

    // Native method declarations - these are implemented in libelectrolib.so
    // which interfaces directly with the vehicle's CAN bus and sensors
    
    /**
     * Native method 'a()' - Likely initializes vehicle data collection
     * Establishes connection to CAN bus and starts data polling
     */
    private native void a();

    /**
     * Static helper to start MainActivity from another activity
     */
    public static native void a(Activity activity);

    /* JADX INFO: Access modifiers changed from: private */
    /**
     * Native method 'a(boolean)' - Likely controls vehicle monitoring state
     * @param z - Enable/disable flag for real-time monitoring
     */
    public native void a(boolean z);

    /**
     * Native method 'b()' - Possibly retrieves battery status
     * Returns current charge level and battery health information
     */
    private native void b();

    /**
     * Native method 'c()' - Possibly retrieves charging information
     * Returns charging status, rate, and estimated time to full charge
     */
    private native void c();

    /**
     * Native method 'd()' - Possibly retrieves door status
     * Returns status of all vehicle doors (open/closed/locked)
     */
    private native void d();

    /* JADX INFO: Access modifiers changed from: private */
    /**
     * Native method 'e()' - Possibly retrieves speed/RPM data
     * Returns current vehicle speed and motor RPM
     */
    public native void e();

    /**
     * Native method 'f()' - Possibly retrieves location data
     * Returns GPS coordinates and navigation information
     */
    private native void f();

    /**
     * Native method 'g()' - Possibly retrieves camera feed data
     * Initializes camera connections and starts video streaming
     */
    private native void g();

    /**
     * EventBus subscriber for initialization status
     * Called when the app checks if vehicle systems are still initializing
     */
    @m
    public native void onCheckIfInitializing(br.com.rory.electro.f.a aVar);

    /**
     * Activity lifecycle: onCreate
     * Initializes UI components and establishes vehicle data connections
     */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    protected native void onCreate(Bundle bundle);

    /**
     * Activity lifecycle: onDestroy
     * Cleans up vehicle data connections and releases resources
     */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected native void onDestroy();

    /**
     * EventBus subscriber for user list refresh events
     * Updates UI when vehicle user profiles are modified
     */
    @m
    public native void onRefreshUserListEvent(e eVar);

    /**
     * Activity lifecycle: onResume
     * Resumes vehicle data collection and UI updates
     */
    @Override // br.com.rory.electro.a, android.support.v4.app.FragmentActivity, android.app.Activity
    protected native void onResume();
}
