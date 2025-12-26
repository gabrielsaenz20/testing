package com.a.a.d.d.e;

import android.graphics.Bitmap;
import com.a.a.d.b.l;

/* loaded from: classes.dex */
public class f implements com.a.a.d.g<a> {
    private final com.a.a.d.g<Bitmap> a;
    private final com.a.a.d.g<com.a.a.d.d.d.b> b;

    public f(com.a.a.d.b.a.c cVar, com.a.a.d.g<Bitmap> gVar) {
        this(gVar, new com.a.a.d.d.d.e(gVar, cVar));
    }

    f(com.a.a.d.g<Bitmap> gVar, com.a.a.d.g<com.a.a.d.d.d.b> gVar2) {
        this.a = gVar;
        this.b = gVar2;
    }

    @Override // com.a.a.d.g
    public l<a> a(l<a> lVar, int i, int i2) {
        l<Bitmap> lVarB = lVar.b().b();
        l<com.a.a.d.d.d.b> lVarC = lVar.b().c();
        if (lVarB != null && this.a != null) {
            l<Bitmap> lVarA = this.a.a(lVarB, i, i2);
            if (!lVarB.equals(lVarA)) {
                return new b(new a(lVarA, lVar.b().c()));
            }
        } else if (lVarC != null && this.b != null) {
            l<com.a.a.d.d.d.b> lVarA2 = this.b.a(lVarC, i, i2);
            if (!lVarC.equals(lVarA2)) {
                return new b(new a(lVar.b().b(), lVarA2));
            }
        }
        return lVar;
    }

    @Override // com.a.a.d.g
    public String a() {
        return this.a.a();
    }
}
