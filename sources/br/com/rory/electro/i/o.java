package br.com.rory.electro.i;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.rory.electro.NativeLoader;
import java.util.List;

/* loaded from: classes.dex */
public class o {
    private static o a;
    private Context b;
    private boolean e = false;
    private String f = null;
    private long g = 0;
    private Handler c = new Handler(Looper.getMainLooper());
    private Handler d = new Handler(Looper.getMainLooper());

    /* renamed from: br.com.rory.electro.i.o$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        static {
            NativeLoader.classesInit0(221);
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.i.o$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        static {
            NativeLoader.classesInit0(220);
        }

        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.i.o$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        static {
            NativeLoader.classesInit0(219);
        }

        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.i.o$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        static {
            NativeLoader.classesInit0(224);
        }

        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(419);
    }

    private o(Context context) {
        this.b = context.getApplicationContext();
    }

    public static native synchronized o a(Context context);

    public static native List<String> a();

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean e();

    /* JADX INFO: Access modifiers changed from: private */
    public native void f();

    /* JADX INFO: Access modifiers changed from: private */
    public native void g();

    /* JADX INFO: Access modifiers changed from: private */
    public native void h();

    /* JADX INFO: Access modifiers changed from: private */
    public native void i();

    /* JADX INFO: Access modifiers changed from: private */
    public native void j();

    public native String b();

    public native String c();

    public native void d();
}
