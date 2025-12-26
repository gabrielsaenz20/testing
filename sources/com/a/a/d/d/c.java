package com.a.a.d.d;

import com.a.a.d.b.l;

/* loaded from: classes.dex */
public class c<T> implements l<T> {
    protected final T a;

    public c(T t) {
        if (t == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.a = t;
    }

    @Override // com.a.a.d.b.l
    public final T b() {
        return this.a;
    }

    @Override // com.a.a.d.b.l
    public final int c() {
        return 1;
    }

    @Override // com.a.a.d.b.l
    public void d() {
    }
}
