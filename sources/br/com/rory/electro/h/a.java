package br.com.rory.electro.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.rory.electro.NativeLoader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    private static a a;
    private Context b;
    private boolean d = false;
    private Handler c = new Handler(Looper.getMainLooper());

    /* renamed from: br.com.rory.electro.h.a$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        static {
            NativeLoader.classesInit0(222);
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.h.a$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        static {
            NativeLoader.classesInit0(223);
        }

        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(470);
    }

    private a(Context context) {
        this.b = context.getApplicationContext();
    }

    public static native synchronized a a(Context context);

    public static native void a(Context context, JSONObject jSONObject);

    /* JADX INFO: Access modifiers changed from: private */
    public native void a(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void d();

    /* JADX INFO: Access modifiers changed from: private */
    public native void e();

    /* JADX INFO: Access modifiers changed from: private */
    public native String f();

    public native void a();

    public native void b();

    public native void c();
}
