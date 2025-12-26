package br.com.rory.electro.service;

import android.content.Context;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class a {
    private static a a;
    private Context b;
    private br.com.rory.electro.database.a.a c;
    private br.com.rory.electro.database.a.b d;
    private Thread g;
    private boolean e = false;
    private final Object f = new Object();
    private boolean h = false;
    private volatile boolean i = false;
    private long j = -1;
    private volatile boolean k = false;

    /* renamed from: br.com.rory.electro.service.a$a, reason: collision with other inner class name */
    private class RunnableC0018a implements Runnable {
        static {
            NativeLoader.classesInit0(82);
        }

        private RunnableC0018a() {
        }

        private native void a(double d, double d2, String str);

        private native boolean a(double d, double d2, double d3, boolean z, boolean z2);

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(94);
        a = new a();
    }

    private a() {
    }

    public static native a a();

    public static native synchronized void a(Context context);

    public static native double b(Context context);

    private native void c(Context context);

    private native void e();

    /* JADX INFO: Access modifiers changed from: private */
    public native String f();

    /* JADX INFO: Access modifiers changed from: private */
    public static native long g();

    private static native long h();

    private native long i();

    public native boolean b();

    public native boolean c();
}
