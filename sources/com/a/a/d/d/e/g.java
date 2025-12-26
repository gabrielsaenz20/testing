package com.a.a.d.d.e;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class g implements com.a.a.g.b<com.a.a.d.c.g, a> {
    private final com.a.a.d.e<File, a> a;
    private final com.a.a.d.e<com.a.a.d.c.g, a> b;
    private final com.a.a.d.f<a> c;
    private final com.a.a.d.b<com.a.a.d.c.g> d;

    public g(com.a.a.g.b<com.a.a.d.c.g, Bitmap> bVar, com.a.a.g.b<InputStream, com.a.a.d.d.d.b> bVar2, com.a.a.d.b.a.c cVar) {
        c cVar2 = new c(bVar.b(), bVar2.b(), cVar);
        this.a = new com.a.a.d.d.c.c(new e(cVar2));
        this.b = cVar2;
        this.c = new d(bVar.d(), bVar2.d());
        this.d = bVar.c();
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, a> a() {
        return this.a;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<com.a.a.d.c.g, a> b() {
        return this.b;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<com.a.a.d.c.g> c() {
        return this.d;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<a> d() {
        return this.c;
    }
}
