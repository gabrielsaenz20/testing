package br.com.rory.electro.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public class a {
    public static boolean a;
    private Socket b;
    private CountDownLatch c;

    /* renamed from: br.com.rory.electro.a.a$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ boolean b;

        static {
            NativeLoader.classesInit0(22);
        }

        AnonymousClass1(Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(214);
    }

    public static native String a(Context context, String str, String str2);

    public static native String a(Context context, String str, String str2, String str3);

    public static native void a(Context context, boolean z);

    public static native boolean a();

    private static native String b();

    public static native boolean b(int i);

    private static native int c();

    public native void a(Context context);

    public native boolean a(int i);
}
