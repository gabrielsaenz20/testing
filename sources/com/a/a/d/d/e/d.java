package com.a.a.d.d.e;

import android.graphics.Bitmap;
import com.a.a.d.b.l;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class d implements com.a.a.d.f<a> {
    private final com.a.a.d.f<Bitmap> a;
    private final com.a.a.d.f<com.a.a.d.d.d.b> b;
    private String c;

    public d(com.a.a.d.f<Bitmap> fVar, com.a.a.d.f<com.a.a.d.d.d.b> fVar2) {
        this.a = fVar;
        this.b = fVar2;
    }

    @Override // com.a.a.d.b
    public String a() {
        if (this.c == null) {
            this.c = this.a.a() + this.b.a();
        }
        return this.c;
    }

    @Override // com.a.a.d.b
    public boolean a(l<a> lVar, OutputStream outputStream) {
        a aVarB = lVar.b();
        l<Bitmap> lVarB = aVarB.b();
        return lVarB != null ? this.a.a(lVarB, outputStream) : this.b.a(aVarB.c(), outputStream);
    }
}
