package br.com.rory.electro.service;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.io.BufferedReader;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class c {
    private static final Object a;
    private static boolean b;
    private static int c;
    private static Thread d;

    /* renamed from: br.com.rory.electro.service.c$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(96);
        }

        AnonymousClass1(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.service.c$2, reason: invalid class name */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ a b;

        static {
            NativeLoader.classesInit0(100);
        }

        AnonymousClass2(Context context, a aVar) {
            this.a = context;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.service.c$3, reason: invalid class name */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context a;

        /* renamed from: br.com.rory.electro.service.c$3$1, reason: invalid class name */
        class AnonymousClass1 implements a {
            static {
                NativeLoader.classesInit0(233);
            }

            AnonymousClass1() {
            }

            @Override // br.com.rory.electro.service.c.a
            public native void a(PrintWriter printWriter, BufferedReader bufferedReader);
        }

        static {
            NativeLoader.classesInit0(99);
        }

        AnonymousClass3(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    private interface a {
        void a(PrintWriter printWriter, BufferedReader bufferedReader);
    }

    static {
        NativeLoader.classesInit0(97);
        a = new Object();
    }

    public static native void a();

    public static native void a(Context context);

    private static native void b(Context context);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void c(Context context, a aVar);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void d(Context context, a aVar);
}
