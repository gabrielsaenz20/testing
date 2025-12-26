package br.com.rory.electro.c.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class j {
    private static Class<?> a;
    private static Method b;
    private static Method c;
    private static Method d;
    private static Method e;
    private static Class<?> f;
    private static Method g;
    private static Method h;
    private static Class<?> i;
    private static Method j;
    private static Method k;
    private static Class<?> l;

    public enum a {
        NORMAL,
        AVM;

        static {
            NativeLoader.classesInit0(407);
        }

        public static native a valueOf(String str);

        public static native a[] values();
    }

    public static class b {
        public final i a;
        public final br.com.rory.electro.c.a.c.f b;
        public final a c;

        public b(i iVar, br.com.rory.electro.c.a.c.f fVar, a aVar) {
            this.a = iVar;
            this.b = fVar;
            this.c = aVar;
        }
    }

    static {
        NativeLoader.classesInit0(192);
        a();
    }

    public static native int a(String str);

    public static native i a(int i2, a aVar);

    public static native b a(Context context, int i2, a aVar);

    private static native void a();

    private static native void a(Context context, String str);

    public static native boolean a(int i2);
}
