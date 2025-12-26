package br.com.rory.electro.c.a.b;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class g {
    private final a a;
    private EGLSurface b;
    private Surface c;

    static {
        NativeLoader.classesInit0(36);
    }

    public g(a aVar, int i, int i2) {
        this.b = EGL14.EGL_NO_SURFACE;
        this.a = aVar;
        this.b = aVar.a(i, i2);
    }

    public g(a aVar, Surface surface) {
        this.b = EGL14.EGL_NO_SURFACE;
        this.a = aVar;
        this.c = surface;
        this.b = aVar.a(surface);
        if (this.b == null) {
            throw new RuntimeException("Failed to create window EGLSurface");
        }
    }

    public native void a();

    public native void a(long j);

    public native void b();

    public native void c();
}
