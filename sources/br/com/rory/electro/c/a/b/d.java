package br.com.rory.electro.c.a.b;

import android.view.Surface;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class d {
    private final a a = new a();
    private final g b;

    static {
        NativeLoader.classesInit0(37);
    }

    public d(Surface surface) {
        this.b = new g(this.a, surface);
    }

    public native a a();

    public native void a(long j);

    public native void b();

    public native void c();

    public native void d();
}
