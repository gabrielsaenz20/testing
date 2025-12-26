package com.a.a.h.a;

import com.a.a.h.a.f;

/* loaded from: classes.dex */
public class g<R> implements d<R> {
    private final f.a a;
    private c<R> b;

    g(f.a aVar) {
        this.a = aVar;
    }

    @Override // com.a.a.h.a.d
    public c<R> a(boolean z, boolean z2) {
        if (z || !z2) {
            return e.b();
        }
        if (this.b == null) {
            this.b = new f(this.a);
        }
        return this.b;
    }
}
