package br.com.rory.electro.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.b.a.b;
import com.b.a.c;
import com.b.a.d;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class a {
    private static a a;
    private c b;
    private Context d;
    private Handler c = new Handler(Looper.getMainLooper());
    private Runnable e = new Runnable() { // from class: br.com.rory.electro.a.a.a.2
        static {
            NativeLoader.classesInit0(288);
        }

        @Override // java.lang.Runnable
        public native void run();
    };

    /* renamed from: br.com.rory.electro.a.a.a$1, reason: invalid class name */
    class AnonymousClass1 implements b {
        static {
            NativeLoader.classesInit0(290);
        }

        AnonymousClass1() {
        }

        @Override // com.b.a.b
        public native String a(byte[] bArr);
    }

    static {
        NativeLoader.classesInit0(338);
    }

    private a(Context context) {
        this.d = context.getApplicationContext();
    }

    public static native int a();

    public static native synchronized a a(Context context);

    private native d a(String str, String str2);

    public static native String b();

    private native b d();

    private native void e();

    private native void f();

    public native String a(String str);

    public native void c();
}
