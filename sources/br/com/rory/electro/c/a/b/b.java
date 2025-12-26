package br.com.rory.electro.c.a.b;

import com.rory.electro.NativeLoader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes.dex */
public class b {
    private static final float[] a;
    private static final float[] e;
    private static final float[] f;
    private final f b = new f();
    private final FloatBuffer c = ByteBuffer.allocateDirect(e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private final FloatBuffer d;

    static {
        NativeLoader.classesInit0(27);
        a = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        e = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    }

    public b() {
        this.c.put(e).position(0);
        this.d = ByteBuffer.allocateDirect(f.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.d.put(f).position(0);
    }

    public native void a(int i, float[] fArr);
}
