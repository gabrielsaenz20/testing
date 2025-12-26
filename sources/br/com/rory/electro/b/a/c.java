package br.com.rory.electro.b.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public class c {
    private static OkHttpClient a;

    static {
        NativeLoader.classesInit0(150);
    }

    public static native OkHttpClient a(Context context);
}
