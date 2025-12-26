package com.a.a.g;

import com.a.a.d.c.l;
import java.io.File;

/* loaded from: classes.dex */
public class a<A, T, Z, R> implements f<A, T, Z, R>, Cloneable {
    private final f<A, T, Z, R> a;
    private com.a.a.d.e<File, Z> b;
    private com.a.a.d.e<T, Z> c;
    private com.a.a.d.f<Z> d;
    private com.a.a.d.d.f.c<Z, R> e;
    private com.a.a.d.b<T> f;

    public a(f<A, T, Z, R> fVar) {
        this.a = fVar;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, Z> a() {
        return this.b != null ? this.b : this.a.a();
    }

    public void a(com.a.a.d.b<T> bVar) {
        this.f = bVar;
    }

    public void a(com.a.a.d.e<T, Z> eVar) {
        this.c = eVar;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<T, Z> b() {
        return this.c != null ? this.c : this.a.b();
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<T> c() {
        return this.f != null ? this.f : this.a.c();
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<Z> d() {
        return this.d != null ? this.d : this.a.d();
    }

    @Override // com.a.a.g.f
    public l<A, T> e() {
        return this.a.e();
    }

    @Override // com.a.a.g.f
    public com.a.a.d.d.f.c<Z, R> f() {
        return this.e != null ? this.e : this.a.f();
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public a<A, T, Z, R> clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
