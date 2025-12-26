package com.a.a.d.d.e;

import android.graphics.Bitmap;
import com.a.a.d.b.l;

/* loaded from: classes.dex */
public class b implements l<a> {
    private final a a;

    public b(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.a = aVar;
    }

    @Override // com.a.a.d.b.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a b() {
        return this.a;
    }

    @Override // com.a.a.d.b.l
    public int c() {
        return this.a.a();
    }

    @Override // com.a.a.d.b.l
    public void d() {
        l<Bitmap> lVarB = this.a.b();
        if (lVarB != null) {
            lVarB.d();
        }
        l<com.a.a.d.d.d.b> lVarC = this.a.c();
        if (lVarC != null) {
            lVarC.d();
        }
    }
}
