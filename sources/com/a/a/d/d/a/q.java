package com.a.a.d.d.a;

import android.graphics.Bitmap;
import java.io.InputStream;

/* loaded from: classes.dex */
public class q implements com.a.a.d.e<InputStream, Bitmap> {
    private final f a;
    private com.a.a.d.b.a.c b;
    private com.a.a.d.a c;
    private String d;

    public q(com.a.a.d.b.a.c cVar, com.a.a.d.a aVar) {
        this(f.a, cVar, aVar);
    }

    public q(f fVar, com.a.a.d.b.a.c cVar, com.a.a.d.a aVar) {
        this.a = fVar;
        this.b = cVar;
        this.c = aVar;
    }

    @Override // com.a.a.d.e
    public com.a.a.d.b.l<Bitmap> a(InputStream inputStream, int i, int i2) {
        return c.a(this.a.a(inputStream, this.b, i, i2, this.c), this.b);
    }

    @Override // com.a.a.d.e
    public String a() {
        if (this.d == null) {
            this.d = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.a.a() + this.c.name();
        }
        return this.d;
    }
}
