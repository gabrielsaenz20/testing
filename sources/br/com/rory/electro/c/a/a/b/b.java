package br.com.rory.electro.c.a.a.b;

import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class b {
    public static final a a;

    public enum a {
        LIVE_CAMERA,
        MOCK_REPLAY;

        static {
            NativeLoader.classesInit0(131);
        }

        public static native a valueOf(String str);

        public static native a[] values();
    }

    static {
        NativeLoader.classesInit0(357);
        a = a.MOCK_REPLAY;
    }

    public static native String a();

    public static native String b();
}
