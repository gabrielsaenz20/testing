package com.a.a.d.b.b;

import android.annotation.SuppressLint;
import com.a.a.d.b.b.h;
import com.a.a.d.b.l;

/* loaded from: classes.dex */
public class g extends com.a.a.j.e<com.a.a.d.c, l<?>> implements h {
    private h.a a;

    public g(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.j.e
    public int a(l<?> lVar) {
        return lVar.c();
    }

    @Override // com.a.a.d.b.b.h
    public /* synthetic */ l a(com.a.a.d.c cVar) {
        return (l) super.c(cVar);
    }

    @Override // com.a.a.d.b.b.h
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (i >= 60) {
            a();
        } else if (i >= 40) {
            b(b() / 2);
        }
    }

    @Override // com.a.a.d.b.b.h
    public void a(h.a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.j.e
    public void a(com.a.a.d.c cVar, l<?> lVar) {
        if (this.a != null) {
            this.a.b(lVar);
        }
    }

    @Override // com.a.a.d.b.b.h
    public /* bridge */ /* synthetic */ l b(com.a.a.d.c cVar, l lVar) {
        return (l) super.b((g) cVar, (com.a.a.d.c) lVar);
    }
}
