package br.com.rory.electro.c.a.c;

import com.rory.electro.NativeLoader;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class e {
    private static volatile boolean a;

    static {
        NativeLoader.classesInit0(67);
    }

    private static native Class<?> a(Class<?> cls);

    public static native Class<?> a(String str);

    public static native Object a(Object obj, String str, Object... objArr);

    public static native Object a(String str, String str2, Object... objArr);

    private static native Method a(Class<?> cls, String str, Object[] objArr);

    private static native void a();

    private static native boolean a(Class<?>[] clsArr, Object[] objArr);

    private static native String[] a(Object[] objArr);
}
