package br.com.rory.electro.i;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.io.File;

/* loaded from: classes.dex */
public class q {
    private static q b;
    long a = 0;
    private String c;
    private int d;
    private String e;
    private String f;
    private Context g;

    /* renamed from: br.com.rory.electro.i.q$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        static {
            NativeLoader.classesInit0(46);
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.i.q$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        static {
            NativeLoader.classesInit0(59);
        }

        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.i.q$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {

        /* renamed from: br.com.rory.electro.i.q$3$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            static {
                NativeLoader.classesInit0(91);
            }

            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(58);
        }

        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    public static class a {
        public String a;
        public int b;
        public String c;
        public String d;

        public a(String str, int i, String str2, String str3) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
        }
    }

    static {
        NativeLoader.classesInit0(417);
    }

    private q(Context context) {
        this.g = context;
    }

    public static native q a(Context context);

    public static native File b();

    private native boolean l();

    private native String m();

    /* JADX INFO: Access modifiers changed from: private */
    public native void n();

    /* JADX INFO: Access modifiers changed from: private */
    public native void o();

    private static native String p();

    private native void q();

    public native void a();

    public native void c();

    public native void d();

    public native a e();

    public native boolean f();

    public native void g();

    public native boolean h();

    public native void i();

    public native void j();

    public native void k();
}
