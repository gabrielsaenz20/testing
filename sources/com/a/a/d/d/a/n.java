package com.a.a.d.d.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class n implements com.a.a.g.b<com.a.a.d.c.g, Bitmap> {
    private final m a;
    private final com.a.a.d.e<File, Bitmap> b;
    private final com.a.a.d.f<Bitmap> c;
    private final com.a.a.d.c.h d;

    public n(com.a.a.g.b<InputStream, Bitmap> bVar, com.a.a.g.b<ParcelFileDescriptor, Bitmap> bVar2) {
        this.c = bVar.d();
        this.d = new com.a.a.d.c.h(bVar.c(), bVar2.c());
        this.b = bVar.a();
        this.a = new m(bVar.b(), bVar2.b());
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, Bitmap> a() {
        return this.b;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<com.a.a.d.c.g, Bitmap> b() {
        return this.a;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<com.a.a.d.c.g> c() {
        return this.d;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<Bitmap> d() {
        return this.c;
    }
}
