package br.com.rory.electro.l.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class w implements a {

    /* renamed from: br.com.rory.electro.l.a.w$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        static {
            NativeLoader.classesInit0(176);
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(235);
    }

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
