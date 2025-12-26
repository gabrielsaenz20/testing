package br.com.rory.electro.l.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class v implements a {

    /* renamed from: br.com.rory.electro.l.a.v$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean a;

        static {
            NativeLoader.classesInit0(159);
        }

        AnonymousClass1(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(236);
    }

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
