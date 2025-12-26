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

/* loaded from: classes.dex */
public class MainService extends Service {
    private static boolean c;
    private static boolean d;
    private static m e;
    private static String i;
    private PowerManager.WakeLock a;
    private WifiManager.WifiLock b;
    private boolean f = false;
    private Handler g;
    private Handler h;
    private e j;

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

    public static native String a();

    public static native void a(Context context);

    public static native void a(String str);

    private native void a(boolean z, boolean z2);

    public static native void b(Context context);

    public static native boolean b();

    public static native boolean c();

    public static native String d();

    private native Notification e();

    private native void f();

    private native void g();

    private native void h();

    /* JADX INFO: Access modifiers changed from: private */
    public native void i();

    private native void j();

    /* JADX INFO: Access modifiers changed from: private */
    public native void k();

    @Override // android.app.Service
    @Nullable
    public native IBinder onBind(Intent intent);

    @Override // android.app.Service
    public native void onCreate();

    @Override // android.app.Service
    public native void onDestroy();

    @org.greenrobot.eventbus.m
    public native void onHBSInit(br.com.rory.electro.f.b bVar);

    @org.greenrobot.eventbus.m
    public native void onProvisionKeysCreated(br.com.rory.electro.f.d dVar);

    @org.greenrobot.eventbus.m
    public native void onSSBGSInit(f fVar);

    @Override // android.app.Service
    public native int onStartCommand(Intent intent, int i2, int i3);
}
