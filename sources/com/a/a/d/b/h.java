package com.a.a.d.b;

import android.os.Looper;

/* loaded from: classes.dex */
class h<Z> implements l<Z> {
    private final l<Z> a;
    private final boolean b;
    private a c;
    private com.a.a.d.c d;
    private int e;
    private boolean f;

    interface a {
        void b(com.a.a.d.c cVar, h<?> hVar);
    }

    h(l<Z> lVar, boolean z) {
        if (lVar == null) {
            throw new NullPointerException("Wrapped resource must not be null");
        }
        this.a = lVar;
        this.b = z;
    }

    void a(com.a.a.d.c cVar, a aVar) {
        this.d = cVar;
        this.c = aVar;
    }

    boolean a() {
        return this.b;
    }

    @Override // com.a.a.d.b.l
    public Z b() {
        return this.a.b();
    }

    @Override // com.a.a.d.b.l
    public int c() {
        return this.a.c();
    }

    @Override // com.a.a.d.b.l
    public void d() {
        if (this.e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f = true;
        this.a.d();
    }

    void e() {
        if (this.f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        this.e++;
    }

    void f() {
        if (this.e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i = this.e - 1;
        this.e = i;
        if (i == 0) {
            this.c.b(this.d, this);
        }
    }
}
