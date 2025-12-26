package br.com.rory.electro.common;

import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class d {
    private String a;
    private String b;
    private StackTraceElement[] c;
    private d d;

    static {
        NativeLoader.classesInit0(41);
    }

    public d() {
    }

    public d(Throwable th) {
        this.a = th.getClass().getName();
        this.b = th.getMessage();
        this.c = th.getStackTrace();
        if (th.getCause() != null) {
            this.d = new d(th.getCause());
        }
    }

    public static native d a(String str);

    public native Exception a();

    public native String b();
}
