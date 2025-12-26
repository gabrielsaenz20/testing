package com.a.a.d.d.d;

import android.graphics.Bitmap;
import com.a.a.d.b.l;

/* loaded from: classes.dex */
public class e implements com.a.a.d.g<b> {
    private final com.a.a.d.g<Bitmap> a;
    private final com.a.a.d.b.a.c b;

    public e(com.a.a.d.g<Bitmap> gVar, com.a.a.d.b.a.c cVar) {
        this.a = gVar;
        this.b = cVar;
    }

    @Override // com.a.a.d.g
    public l<b> a(l<b> lVar, int i, int i2) {
        b bVarB = lVar.b();
        Bitmap bitmapB = lVar.b().b();
        Bitmap bitmapB2 = this.a.a(new com.a.a.d.d.a.c(bitmapB, this.b), i, i2).b();
        return !bitmapB2.equals(bitmapB) ? new d(new b(bVarB, bitmapB2, this.a)) : lVar;
    }

    @Override // com.a.a.d.g
    public String a() {
        return this.a.a();
    }
}
