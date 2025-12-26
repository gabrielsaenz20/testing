package com.a.a.h;

/* loaded from: classes.dex */
public class f implements b, c {
    private b a;
    private b b;
    private c c;

    public f() {
        this(null);
    }

    public f(c cVar) {
        this.c = cVar;
    }

    private boolean j() {
        return this.c == null || this.c.a(this);
    }

    private boolean k() {
        return this.c == null || this.c.b(this);
    }

    private boolean l() {
        return this.c != null && this.c.c();
    }

    @Override // com.a.a.h.b
    public void a() {
        this.a.a();
        this.b.a();
    }

    public void a(b bVar, b bVar2) {
        this.a = bVar;
        this.b = bVar2;
    }

    @Override // com.a.a.h.c
    public boolean a(b bVar) {
        if (j()) {
            return bVar.equals(this.a) || !this.a.h();
        }
        return false;
    }

    @Override // com.a.a.h.b
    public void b() {
        if (!this.b.f()) {
            this.b.b();
        }
        if (this.a.f()) {
            return;
        }
        this.a.b();
    }

    @Override // com.a.a.h.c
    public boolean b(b bVar) {
        return k() && bVar.equals(this.a) && !c();
    }

    @Override // com.a.a.h.c
    public void c(b bVar) {
        if (bVar.equals(this.b)) {
            return;
        }
        if (this.c != null) {
            this.c.c(this);
        }
        if (this.b.g()) {
            return;
        }
        this.b.d();
    }

    @Override // com.a.a.h.c
    public boolean c() {
        return l() || h();
    }

    @Override // com.a.a.h.b
    public void d() {
        this.b.d();
        this.a.d();
    }

    @Override // com.a.a.h.b
    public void e() {
        this.a.e();
        this.b.e();
    }

    @Override // com.a.a.h.b
    public boolean f() {
        return this.a.f();
    }

    @Override // com.a.a.h.b
    public boolean g() {
        return this.a.g() || this.b.g();
    }

    @Override // com.a.a.h.b
    public boolean h() {
        return this.a.h() || this.b.h();
    }

    @Override // com.a.a.h.b
    public boolean i() {
        return this.a.i();
    }
}
