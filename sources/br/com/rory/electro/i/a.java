package br.com.rory.electro.i;

import android.content.Context;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class a {
    static {
        NativeLoader.classesInit0(440);
    }

    private static native int a(String str, int i);

    private static native Object a(String str, Class<?>[] clsArr, Object[] objArr);

    private static native String a();

    public static native void a(Context context, boolean z);

    private static native void a(String str);
}
