package br.com.rory.electro.c.a.b;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.rory.electro.NativeLoader;
import org.webrtc.EglBase;

/* loaded from: classes.dex */
public class a {
    private EGLDisplay a;
    private EGLContext b;
    private EGLConfig c;

    static {
        NativeLoader.classesInit0(33);
    }

    public a() {
        this(null, 0);
    }

    public a(EGLContext eGLContext, int i) {
        this.a = EGL14.EGL_NO_DISPLAY;
        this.b = EGL14.EGL_NO_CONTEXT;
        if (this.a != EGL14.EGL_NO_DISPLAY) {
            throw new IllegalStateException("EGL already set up");
        }
        eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
        this.a = EGL14.eglGetDisplay(0);
        if (this.a == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("Unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.a, iArr, 0, iArr, 1)) {
            this.a = null;
            throw new RuntimeException("Unable to initialize EGL14");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(this.a, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12352, 4, 12339, 5, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, iArr2, 0);
        if (!((!zEglChooseConfig || iArr2[0] <= 0) ? EGL14.eglChooseConfig(this.a, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 5, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, iArr2, 0) : zEglChooseConfig) || iArr2[0] <= 0) {
            EGL14.eglChooseConfig(this.a, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12352, 4, 12339, 5, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, iArr2, 0);
        }
        this.c = eGLConfigArr[0];
        this.b = EGL14.eglCreateContext(this.a, this.c, eGLContext, new int[]{12440, 2, 12344}, 0);
        if (this.b == null) {
            throw new RuntimeException("Failed to create EGL context");
        }
    }

    public native EGLContext a();

    public native EGLSurface a(int i, int i2);

    public native EGLSurface a(Surface surface);

    public native EGLDisplay b();

    public native void c();
}
