package br.com.rory.electro.database.b;

import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class d {
    private int a;
    private int b;

    static {
        NativeLoader.classesInit0(17);
    }

    public d(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public native int a();

    public native int b();
}
