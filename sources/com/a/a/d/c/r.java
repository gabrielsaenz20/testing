package com.a.a.d.c;

import java.net.URL;

/* loaded from: classes.dex */
public class r<T> implements l<URL, T> {
    private final l<d, T> a;

    public r(l<d, T> lVar) {
        this.a = lVar;
    }

    @Override // com.a.a.d.c.l
    public com.a.a.d.a.c<T> a(URL url, int i, int i2) {
        return this.a.a(new d(url), i, i2);
    }
}
