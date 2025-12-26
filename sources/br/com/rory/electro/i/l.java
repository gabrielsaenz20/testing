package br.com.rory.electro.i;

import android.content.Context;
import android.os.PowerManager;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class l {
    private static PowerManager a;

    static {
        NativeLoader.classesInit0(416);
    }

    public static native Boolean a(Context context);

    public static native void b(Context context);

    public static native void c(Context context);

    public static native void d(Context context);

    private static native PowerManager e(Context context);
}
