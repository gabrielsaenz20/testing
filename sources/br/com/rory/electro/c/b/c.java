package br.com.rory.electro.c.b;

import android.content.Context;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class c {

    /* renamed from: br.com.rory.electro.c.b.c$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(303);
        }

        AnonymousClass1(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.b.c$2, reason: invalid class name */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(304);
        }

        AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(55);
    }

    public static native String a(String str);

    public static native void a(Context context);

    public static native void b(Context context);

    public static native void c(Context context);
}
