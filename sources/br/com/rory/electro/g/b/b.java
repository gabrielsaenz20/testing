package br.com.rory.electro.g.b;

import com.rory.electro.NativeLoader;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class b {
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    private static int e;
    private ByteBuffer f;
    private int g;
    private int h = 0;

    public static class a {
        public final String a;
        public final Object b;

        public a(String str, Object obj) {
            this.a = str;
            this.b = obj;
        }
    }

    /* renamed from: br.com.rory.electro.g.b.b$b, reason: collision with other inner class name */
    public interface InterfaceC0016b {
        long a(String str);
    }

    static {
        NativeLoader.classesInit0(289);
    }

    private b(ByteBuffer byteBuffer) {
        this.f = byteBuffer;
        this.g = byteBuffer.capacity();
    }

    public static native b a(int i, int i2);

    public static native b a(byte[] bArr);

    private native void a(int i, long j);

    private native long c(int i);

    private native void d(int i);

    private native void e(int i);

    private native int f(int i);

    private native int g(int i);

    private native void n();

    public native Object a(byte b2);

    public native void a(char c2);

    public native void a(double d2);

    public native void a(float f);

    public native void a(int i);

    public native void a(long j);

    public native void a(String str);

    public native void a(short s);

    public native void a(boolean z);

    public native void a(a[] aVarArr, InterfaceC0016b interfaceC0016b);

    public native boolean a();

    public native byte b();

    public native void b(int i);

    public native void b(long j);

    public native char c();

    public native void c(long j);

    public native long d();

    public native void d(long j);

    public native double e();

    public native float f();

    public native int g();

    public native long h();

    public native long i();

    public native String j();

    public native long k();

    public native short l();

    public native byte[] m();
}
