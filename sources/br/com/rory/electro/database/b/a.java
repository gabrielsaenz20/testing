package br.com.rory.electro.database.b;

import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class a {
    private long a;
    private long b;
    private double c;
    private double d;
    private double e;
    private double f;
    private int g;
    private int h;

    static {
        NativeLoader.classesInit0(9);
    }

    public a(long j, long j2, double d, double d2, double d3, double d4, int i, int i2) {
        this.a = j;
        this.b = j2;
        this.c = d;
        this.d = d2;
        this.e = d3;
        this.f = d4;
        this.g = i;
        this.h = i2;
    }

    public native long a();

    public native long b();

    public native double c();

    public native double d();

    public native double e();

    public native double f();

    public native int g();

    public native int h();
}
