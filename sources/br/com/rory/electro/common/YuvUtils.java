package br.com.rory.electro.common;

/* loaded from: classes.dex */
public class YuvUtils {
    static {
        System.loadLibrary("native-lib");
    }

    public static native void applyCLAHE(byte[] bArr, int i, int i2, float f, int i3);

    public static native int combineCamerasTo2x2GridNV21ToI420(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4);

    public static native void convertNV12ToI420(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void convertNV21ToI420(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native int cropNV21ToI420(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr2);

    public static native void normalizeYChannel(byte[] bArr, int i, int i2);

    public static native int rearrangeI420HalvesSideBySide(byte[] bArr, byte[] bArr2, int i, int i2);
}
