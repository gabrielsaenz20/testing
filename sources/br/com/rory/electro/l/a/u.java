package br.com.rory.electro.l.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class u implements a {
    static {
        NativeLoader.classesInit0(232);
    }

    private native void a(br.com.rory.electro.k.a.d dVar, String str);

    private native void a(br.com.rory.electro.k.a.d dVar, String str, int[] iArr);

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
