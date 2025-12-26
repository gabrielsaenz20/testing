package br.com.rory.electro.l.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d implements a {
    static {
        NativeLoader.classesInit0(199);
    }

    private native void a(br.com.rory.electro.k.a.d dVar, JSONArray jSONArray);

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
