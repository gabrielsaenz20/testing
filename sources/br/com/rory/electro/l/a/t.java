package br.com.rory.electro.l.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class t implements a {
    static {
        NativeLoader.classesInit0(234);
    }

    private native void a(br.com.rory.electro.k.a.d dVar, String str);

    private native void a(br.com.rory.electro.k.a.d dVar, String str, int i, int i2);

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
