package br.com.rory.electro.database.b;

import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class c {
    private long a;
    private long b;
    private int c;
    private String d;

    static {
        NativeLoader.classesInit0(5);
    }

    public c(long j, long j2, int i, String str) {
        this.a = j;
        this.b = j2;
        this.c = i;
        this.d = str;
    }

    public native long a();

    public native int b();

    public native String c();
}
