package br.com.rory.electro.i;

import android.content.Context;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class j {

    /* renamed from: br.com.rory.electro.i.j$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(321);
        }

        AnonymousClass1(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.i.j$2, reason: invalid class name */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(323);
        }

        AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(409);
    }

    public static native void a();

    public static native void a(Context context);

    public static native void b(Context context);

    private static native String c();

    public static native void c(Context context);

    private static native String d();

    public static native void d(Context context);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String e();

    public static native void e(Context context);
}
