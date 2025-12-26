package br.com.rory.electro.l.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ak implements a {
    private static String a = "";
    private static int b;
    private static boolean[] c;
    private static FileOutputStream d;
    private static File e;
    private static boolean f;
    private static boolean g;
    private static long h;

    static {
        NativeLoader.classesInit0(337);
    }

    private native String a(String str);

    private native void a(br.com.rory.electro.k.a.d dVar);

    private native void a(br.com.rory.electro.k.a.d dVar, String str);

    private native void a(br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);

    private static native String b();

    private native void b(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);

    private native void b(br.com.rory.electro.k.a.d dVar);

    private native void b(br.com.rory.electro.k.a.d dVar, String str);

    private native void b(br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);

    private native boolean b(String str);

    private native void c();

    private native void c(br.com.rory.electro.k.a.d dVar);

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
