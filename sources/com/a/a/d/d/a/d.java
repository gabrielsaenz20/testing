package com.a.a.d.d.a;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public abstract class d implements com.a.a.d.g<Bitmap> {
    private com.a.a.d.b.a.c a;

    public d(com.a.a.d.b.a.c cVar) {
        this.a = cVar;
    }

    protected abstract Bitmap a(com.a.a.d.b.a.c cVar, Bitmap bitmap, int i, int i2);

    @Override // com.a.a.d.g
    public final com.a.a.d.b.l<Bitmap> a(com.a.a.d.b.l<Bitmap> lVar, int i, int i2) {
        if (com.a.a.j.h.a(i, i2)) {
            Bitmap bitmapB = lVar.b();
            if (i == Integer.MIN_VALUE) {
                i = bitmapB.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmapB.getHeight();
            }
            Bitmap bitmapA = a(this.a, bitmapB, i, i2);
            return bitmapB.equals(bitmapA) ? lVar : c.a(bitmapA, this.a);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
