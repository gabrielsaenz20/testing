package com.a.a.d.d.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.a.a.d.b.l;
import com.a.a.d.d.a.j;
import com.a.a.d.d.a.k;

/* loaded from: classes.dex */
public class b implements c<Bitmap, j> {
    private final Resources a;
    private final com.a.a.d.b.a.c b;

    public b(Resources resources, com.a.a.d.b.a.c cVar) {
        this.a = resources;
        this.b = cVar;
    }

    @Override // com.a.a.d.d.f.c
    public l<j> a(l<Bitmap> lVar) {
        return new k(new j(this.a, lVar.b()), this.b);
    }

    @Override // com.a.a.d.d.f.c
    public String a() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
