package br.com.rory.electro.l.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class y implements a {

    /* renamed from: br.com.rory.electro.l.a.y$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ br.com.rory.electro.c.a.a.e a;

        static {
            NativeLoader.classesInit0(371);
        }

        AnonymousClass1(br.com.rory.electro.c.a.a.e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(237);
    }

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
