package br.com.rory.electro.l.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class r implements a {
    private static final String a = "r";

    static {
        NativeLoader.classesInit0(231);
    }

    private native void a(br.com.rory.electro.k.a.d dVar, JSONArray jSONArray);

    private native String b();

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
