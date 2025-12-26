package com.a.a.d.d.f;

import android.graphics.Bitmap;
import com.a.a.d.b.l;
import com.a.a.d.d.a.j;

/* loaded from: classes.dex */
public class a implements c<com.a.a.d.d.e.a, com.a.a.d.d.b.b> {
    private final c<Bitmap, j> a;

    public a(c<Bitmap, j> cVar) {
        this.a = cVar;
    }

    @Override // com.a.a.d.d.f.c
    public l<com.a.a.d.d.b.b> a(l<com.a.a.d.d.e.a> lVar) {
        com.a.a.d.d.e.a aVarB = lVar.b();
        l<Bitmap> lVarB = aVarB.b();
        return lVarB != null ? this.a.a(lVarB) : aVarB.c();
    }

    @Override // com.a.a.d.d.f.c
    public String a() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
