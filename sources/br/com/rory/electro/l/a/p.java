package br.com.rory.electro.l.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class p implements a {
    static {
        NativeLoader.classesInit0(211);
    }

    private native String a(String str);

    private native void a(br.com.rory.electro.k.a.d dVar, String str, String str2);

    private static native String b();

    private native void b(br.com.rory.electro.k.a.d dVar, String str, String str2);

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
