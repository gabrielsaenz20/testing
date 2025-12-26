package br.com.rory.electro.i;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.net.Socket;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class m {
    private Context a;
    private Socket b;
    private Thread c;
    private Thread d;
    private long f = 0;
    private boolean e = false;

    /* renamed from: br.com.rory.electro.i.m$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: br.com.rory.electro.i.m$1$1, reason: invalid class name and collision with other inner class name */
        class RunnableC00171 implements Runnable {
            static {
                NativeLoader.classesInit0(363);
            }

            RunnableC00171() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(162);
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.i.m$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        static {
            NativeLoader.classesInit0(161);
        }

        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(412);
    }

    public m(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native String f();

    /* JADX INFO: Access modifiers changed from: private */
    public native String g();

    /* JADX INFO: Access modifiers changed from: private */
    public static native int h();

    /* JADX INFO: Access modifiers changed from: private */
    public native synchronized void i();

    /* JADX INFO: Access modifiers changed from: private */
    public native synchronized void j();

    /* JADX INFO: Access modifiers changed from: private */
    public native synchronized void k();

    /* JADX INFO: Access modifiers changed from: private */
    public native synchronized void l();

    public native synchronized void a();

    public native void a(String str, JSONObject jSONObject);

    public native synchronized void b();

    public native synchronized void c();
}
