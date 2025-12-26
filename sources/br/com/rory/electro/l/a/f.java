package br.com.rory.electro.l.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f implements a {
    private static ExecutorService a = null;
    private static volatile boolean b = false;
    private static String c = "";
    private static File d;

    /* renamed from: br.com.rory.electro.l.a.f$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ br.com.rory.electro.k.a.d a;
        final /* synthetic */ String b;

        static {
            NativeLoader.classesInit0(146);
        }

        AnonymousClass1(br.com.rory.electro.k.a.d dVar, String str) {
            this.a = dVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(201);
        a = Executors.newSingleThreadExecutor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void a(br.com.rory.electro.k.a.d dVar, String str);

    public static native void b();

    /* JADX INFO: Access modifiers changed from: private */
    public native void b(br.com.rory.electro.k.a.d dVar, String str);

    public static native File c();

    public static native int d();

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
