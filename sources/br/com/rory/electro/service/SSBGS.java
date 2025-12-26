package br.com.rory.electro.service;

import android.content.Context;
import android.hardware.bydauto.bodywork.AbsBYDAutoBodyworkListener;
import com.rory.electro.NativeLoader;
import java.lang.Thread;
import java.net.Socket;

/* loaded from: classes.dex */
public class SSBGS {
    private static String a;
    private static Thread b;

    /* renamed from: br.com.rory.electro.service.SSBGS$1, reason: invalid class name */
    static class AnonymousClass1 implements br.com.rory.electro.common.a<String> {
        final /* synthetic */ Context a;

        AnonymousClass1(Context context) {
            this.a = context;
        }
    }

    /* renamed from: br.com.rory.electro.service.SSBGS$2, reason: invalid class name */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context a;

        /* renamed from: br.com.rory.electro.service.SSBGS$2$1, reason: invalid class name */
        class AnonymousClass1 extends AbsBYDAutoBodyworkListener {
            static {
                NativeLoader.classesInit0(305);
            }

            AnonymousClass1() {
            }

            public native void onPowerLevelChanged(int i);
        }

        static {
            NativeLoader.classesInit0(116);
        }

        AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.service.SSBGS$3, reason: invalid class name */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(121);
        }

        AnonymousClass3(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.service.SSBGS$4, reason: invalid class name */
    static class AnonymousClass4 implements Runnable {
        static {
            NativeLoader.classesInit0(119);
        }

        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.service.SSBGS$5, reason: invalid class name */
    static class AnonymousClass5 implements Runnable {
        static {
            NativeLoader.classesInit0(125);
        }

        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.service.SSBGS$6, reason: invalid class name */
    static class AnonymousClass6 implements Runnable {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(123);
        }

        AnonymousClass6(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.service.SSBGS$7, reason: invalid class name */
    static class AnonymousClass7 implements Runnable {
        final /* synthetic */ Context a;
        private String b = null;
        private boolean c = true;

        static {
            NativeLoader.classesInit0(128);
        }

        AnonymousClass7(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    private static class a implements Runnable {
        private Socket a;
        private Context b;

        /* renamed from: br.com.rory.electro.service.SSBGS$a$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            static {
                NativeLoader.classesInit0(364);
            }

            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(379);
        }

        public a(Socket socket, Context context) {
            this.a = socket;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    private static class b implements Thread.UncaughtExceptionHandler {
        static {
            NativeLoader.classesInit0(378);
        }

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public native void uncaughtException(Thread thread, Throwable th);
    }

    static {
        NativeLoader.classesInit0(377);
    }

    public static native int a();

    public static native void a(Context context);

    public static native Context b();

    private static native void b(Context context);

    public static native String c();

    private static native void c(Context context);

    private static native void d();

    public static native void main(String[] strArr);
}
