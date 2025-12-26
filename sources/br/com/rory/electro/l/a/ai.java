package br.com.rory.electro.l.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ai implements a {
    private static final String a = "ai";
    private Map<String, Object> b;

    static {
        NativeLoader.classesInit0(334);
    }

    private native void a(br.com.rory.electro.k.a.d dVar, long j, long j2, JSONArray jSONArray);

    private native void a(JSONObject jSONObject, String str, Object obj);

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
