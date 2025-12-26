package com.a.a;

import android.content.Context;
import com.a.a.d.c.l;
import com.a.a.e.m;
import com.a.a.j;

/* loaded from: classes.dex */
public class d<ModelType, DataType, ResourceType> extends c<ModelType, DataType, ResourceType, ResourceType> {
    private final l<ModelType, DataType> g;
    private final Class<DataType> h;
    private final Class<ResourceType> i;
    private final j.c j;

    d(Context context, g gVar, Class<ModelType> cls, l<ModelType, DataType> lVar, Class<DataType> cls2, Class<ResourceType> cls3, m mVar, com.a.a.e.g gVar2, j.c cVar) {
        super(context, cls, a(gVar, lVar, cls2, cls3, com.a.a.d.d.f.e.b()), cls3, gVar, mVar, gVar2);
        this.g = lVar;
        this.h = cls2;
        this.i = cls3;
        this.j = cVar;
    }

    private static <A, T, Z, R> com.a.a.g.f<A, T, Z, R> a(g gVar, l<A, T> lVar, Class<T> cls, Class<Z> cls2, com.a.a.d.d.f.c<Z, R> cVar) {
        return new com.a.a.g.e(lVar, cVar, gVar.b(cls, cls2));
    }
}
