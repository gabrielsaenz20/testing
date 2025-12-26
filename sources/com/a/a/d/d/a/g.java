package com.a.a.d.d.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;

/* loaded from: classes.dex */
public class g implements com.a.a.g.b<ParcelFileDescriptor, Bitmap> {
    private final com.a.a.d.e<File, Bitmap> a;
    private final h b;
    private final b c = new b();
    private final com.a.a.d.b<ParcelFileDescriptor> d = com.a.a.d.d.a.b();

    public g(com.a.a.d.b.a.c cVar, com.a.a.d.a aVar) {
        this.a = new com.a.a.d.d.c.c(new q(cVar, aVar));
        this.b = new h(cVar, aVar);
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, Bitmap> a() {
        return this.a;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<ParcelFileDescriptor, Bitmap> b() {
        return this.b;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<ParcelFileDescriptor> c() {
        return this.d;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<Bitmap> d() {
        return this.c;
    }
}
