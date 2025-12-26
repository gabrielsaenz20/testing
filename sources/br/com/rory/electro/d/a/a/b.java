package br.com.rory.electro.d.a.a;

import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class b {
    private int a;
    private String b;
    private String c;

    static {
        NativeLoader.classesInit0(348);
    }

    public b(int i, String str, String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public native int a();

    public native String b();

    public native String c();
}
