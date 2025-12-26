package com.a.a.g;

import com.a.a.d.c.l;
import java.io.File;

/* loaded from: classes.dex */
public class e<A, T, Z, R> implements f<A, T, Z, R> {
    private final l<A, T> a;
    private final com.a.a.d.d.f.c<Z, R> b;
    private final b<T, Z> c;

    public e(l<A, T> lVar, com.a.a.d.d.f.c<Z, R> cVar, b<T, Z> bVar) {
        if (lVar == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.a = lVar;
        if (cVar == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.b = cVar;
        if (bVar == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.c = bVar;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, Z> a() {
        return this.c.a();
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<T, Z> b() {
        return this.c.b();
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<T> c() {
        return this.c.c();
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<Z> d() {
        return this.c.d();
    }

    @Override // com.a.a.g.f
    public l<A, T> e() {
        return this.a;
    }

    @Override // com.a.a.g.f
    public com.a.a.d.d.f.c<Z, R> f() {
        return this.b;
    }
}
