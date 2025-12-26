package br.com.rory.electro.common;

import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class MOG2Utils {

    public static class a {
        private long a;
        private int b = 0;
        private int c = 0;
        private boolean d = false;

        static {
            NativeLoader.classesInit0(415);
        }

        public a() {
            this.a = -1L;
            this.a = MOG2Utils.createMOG2Instance();
        }

        public native float a(byte[] bArr);

        public native void a();

        public native void a(float f);

        public native boolean a(int i, int i2);

        public native boolean a(byte[] bArr, byte[] bArr2);

        public native int b(byte[] bArr);

        public native void b(float f);

        public native void c(float f);

        protected native void finalize();
    }

    static {
        System.loadLibrary("native-lib");
    }

    public static native boolean applyMOG2(long j, byte[] bArr, byte[] bArr2);

    public static native void applyShadowFilter(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3);

    public static native long createMOG2Instance();

    public static native void destroyMOG2Instance(long j);

    public static native float getForegroundPercentage(long j, byte[] bArr);

    public static native int getMotionVerticalCenter(long j, byte[] bArr);

    public static native boolean initializeMOG2(long j, int i, int i2);

    public static native void setBackgroundRatio(long j, float f);

    public static native void setLearningRate(long j, float f);

    public static native void setVarThreshold(long j, float f);
}
