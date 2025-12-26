package br.com.rory.electro.l.a;

import android.content.Context;
import android.support.design.R;
import com.rory.electro.NativeLoader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class q implements a {

    /* renamed from: br.com.rory.electro.l.a.q$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ int b;
        final /* synthetic */ br.com.rory.electro.k.a.d c;

        static {
            NativeLoader.classesInit0(R.styleable.AppCompatTheme_windowNoTitle);
        }

        AnonymousClass1(Context context, int i, br.com.rory.electro.k.a.d dVar) {
            this.a = context;
            this.b = i;
            this.c = dVar;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(210);
    }

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
