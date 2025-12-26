package br.com.rory.electro.service;

import android.content.Context;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class i {

    /* renamed from: br.com.rory.electro.service.i$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ boolean b;

        static {
            NativeLoader.classesInit0(276);
        }

        AnonymousClass1(Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(102);
    }

    public static native Context a();

    public static native void a(Context context);

    private static native String b();

    public static native void main(String[] strArr);
}
