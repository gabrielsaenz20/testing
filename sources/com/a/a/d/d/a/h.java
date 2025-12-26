package com.a.a.d.d.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
public class h implements com.a.a.d.e<ParcelFileDescriptor, Bitmap> {
    private final s a;
    private final com.a.a.d.b.a.c b;
    private com.a.a.d.a c;

    public h(com.a.a.d.b.a.c cVar, com.a.a.d.a aVar) {
        this(new s(), cVar, aVar);
    }

    public h(s sVar, com.a.a.d.b.a.c cVar, com.a.a.d.a aVar) {
        this.a = sVar;
        this.b = cVar;
        this.c = aVar;
    }

    @Override // com.a.a.d.e
    public com.a.a.d.b.l<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2) {
        return c.a(this.a.a(parcelFileDescriptor, this.b, i, i2, this.c), this.b);
    }

    @Override // com.a.a.d.e
    public String a() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }
}
