package br.com.rory.electro.i;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class s {
    private static WifiManager a;

    static {
        NativeLoader.classesInit0(423);
    }

    public static native boolean a(Context context);

    public static native void b(Context context);

    public static native String c(Context context);

    private static native WifiManager d(Context context);
}
