package com.a.a.d.d.a;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class c implements com.a.a.d.b.l<Bitmap> {
    private final Bitmap a;
    private final com.a.a.d.b.a.c b;

    public c(Bitmap bitmap, com.a.a.d.b.a.c cVar) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (cVar == null) {
            throw new NullPointerException("BitmapPool must not be null");
        }
        this.a = bitmap;
        this.b = cVar;
    }

    public static c a(Bitmap bitmap, com.a.a.d.b.a.c cVar) {
        if (bitmap == null) {
            return null;
        }
        return new c(bitmap, cVar);
    }

    @Override // com.a.a.d.b.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap b() {
        return this.a;
    }

    @Override // com.a.a.d.b.l
    public int c() {
        return com.a.a.j.h.a(this.a);
    }

    @Override // com.a.a.d.b.l
    public void d() {
        if (this.b.a(this.a)) {
            return;
        }
        this.a.recycle();
    }
}
