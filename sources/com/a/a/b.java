package com.a.a;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.a.a.d.c.l;
import com.a.a.e.m;
import com.a.a.j;
import java.io.InputStream;

/* loaded from: classes.dex */
public class b<ModelType> extends a<ModelType> {
    private final l<ModelType, InputStream> g;
    private final l<ModelType, ParcelFileDescriptor> h;
    private final j.c i;

    b(Class<ModelType> cls, l<ModelType, InputStream> lVar, l<ModelType, ParcelFileDescriptor> lVar2, Context context, g gVar, m mVar, com.a.a.e.g gVar2, j.c cVar) {
        super(context, cls, a(gVar, lVar, lVar2, com.a.a.d.d.e.a.class, com.a.a.d.d.b.b.class, null), gVar, mVar, gVar2);
        this.g = lVar;
        this.h = lVar2;
        this.i = cVar;
    }

    private static <A, Z, R> com.a.a.g.e<A, com.a.a.d.c.g, Z, R> a(g gVar, l<A, InputStream> lVar, l<A, ParcelFileDescriptor> lVar2, Class<Z> cls, Class<R> cls2, com.a.a.d.d.f.c<Z, R> cVar) {
        if (lVar == null && lVar2 == null) {
            return null;
        }
        if (cVar == null) {
            cVar = gVar.a(cls, cls2);
        }
        return new com.a.a.g.e<>(new com.a.a.d.c.f(lVar, lVar2), cVar, gVar.b(com.a.a.d.c.g.class, cls));
    }

    public f<ModelType> h() {
        return (f) this.i.a(new f(this, this.g, this.i));
    }
}
