package com.a.a;

import com.a.a.d.c.l;
import com.a.a.j;
import java.io.InputStream;

/* loaded from: classes.dex */
public class f<ModelType> extends e<ModelType> {
    private final l<ModelType, InputStream> g;
    private final j.c h;

    f(c<ModelType, ?, ?, ?> cVar, l<ModelType, InputStream> lVar, j.c cVar2) {
        super(a(cVar.c, lVar, com.a.a.d.d.d.b.class, (com.a.a.d.d.f.c) null), com.a.a.d.d.d.b.class, cVar);
        this.g = lVar;
        this.h = cVar2;
        c();
    }

    private static <A, R> com.a.a.g.e<A, InputStream, com.a.a.d.d.d.b, R> a(g gVar, l<A, InputStream> lVar, Class<R> cls, com.a.a.d.d.f.c<com.a.a.d.d.d.b, R> cVar) {
        if (lVar == null) {
            return null;
        }
        if (cVar == null) {
            cVar = gVar.a(com.a.a.d.d.d.b.class, cls);
        }
        return new com.a.a.g.e<>(lVar, cVar, gVar.b(InputStream.class, com.a.a.d.d.d.b.class));
    }
}
