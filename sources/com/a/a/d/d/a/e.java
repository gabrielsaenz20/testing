package com.a.a.d.d.a;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class e extends d {
    public e(com.a.a.d.b.a.c cVar) {
        super(cVar);
    }

    @Override // com.a.a.d.d.a.d
    protected Bitmap a(com.a.a.d.b.a.c cVar, Bitmap bitmap, int i, int i2) {
        Bitmap bitmapA = cVar.a(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        Bitmap bitmapA2 = r.a(bitmapA, bitmap, i, i2);
        if (bitmapA != null && bitmapA != bitmapA2 && !cVar.a(bitmapA)) {
            bitmapA.recycle();
        }
        return bitmapA2;
    }

    @Override // com.a.a.d.g
    public String a() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }
}
