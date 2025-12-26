package br.com.rory.electro.l.a;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.rory.electro.NativeLoader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l implements a {
    static {
        NativeLoader.classesInit0(207);
    }

    private static native int a(BitmapFactory.Options options, int i, int i2);

    private native String a(String str);

    private native void a(br.com.rory.electro.k.a.d dVar, String str, String str2);

    private static native String b();

    private native void b(br.com.rory.electro.k.a.d dVar, String str, String str2);

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
