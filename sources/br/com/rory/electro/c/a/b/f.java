package br.com.rory.electro.c.a.b;

import android.opengl.GLES20;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class f {
    private int a = c.a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    private int d = GLES20.glGetAttribLocation(this.a, "aPosition");
    private int e = GLES20.glGetAttribLocation(this.a, "aTextureCoord");
    private int b = GLES20.glGetUniformLocation(this.a, "uMVPMatrix");
    private int c = GLES20.glGetUniformLocation(this.a, "uTexMatrix");
    private int f = GLES20.glGetUniformLocation(this.a, "sTexture");

    static {
        NativeLoader.classesInit0(34);
    }

    public native void a();

    public native int b();

    public native int c();

    public native int d();

    public native int e();
}
