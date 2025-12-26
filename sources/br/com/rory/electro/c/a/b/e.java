package br.com.rory.electro.c.a.b;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class e implements SurfaceTexture.OnFrameAvailableListener {
    private final a a;
    private final g b;
    private final int c;
    private final SurfaceTexture d;
    private final Surface e;
    private final b f;
    private final float[] g = new float[16];
    private boolean h = true;
    private final Object i = new Object();
    private boolean j;

    static {
        NativeLoader.classesInit0(38);
    }

    public e(a aVar) {
        this.a = aVar == null ? new a() : aVar;
        this.b = new g(this.a, 1, 1);
        this.b.a();
        this.c = c.a();
        this.d = new SurfaceTexture(this.c);
        this.d.setOnFrameAvailableListener(this);
        this.e = new Surface(this.d);
        this.f = new b();
    }

    public native Surface a();

    public native void a(int i, int i2);

    public native void a(boolean z);

    public native boolean a(long j);

    public native void b();

    public native void b(int i, int i2);

    public native void c();

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public native void onFrameAvailable(SurfaceTexture surfaceTexture);
}
