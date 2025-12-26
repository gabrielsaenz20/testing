package com.a.a.d.d.a;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class p implements com.a.a.g.b<InputStream, Bitmap> {
    private final q a;
    private final com.a.a.d.d.c.c<Bitmap> d;
    private final com.a.a.d.c.o c = new com.a.a.d.c.o();
    private final b b = new b();

    public p(com.a.a.d.b.a.c cVar, com.a.a.d.a aVar) {
        this.a = new q(cVar, aVar);
        this.d = new com.a.a.d.d.c.c<>(this.a);
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, Bitmap> a() {
        return this.d;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<InputStream, Bitmap> b() {
        return this.a;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<InputStream> c() {
        return this.c;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<Bitmap> d() {
        return this.b;
    }
}
