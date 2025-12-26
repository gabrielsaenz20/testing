package com.a.a.g;

import com.a.a.j.g;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class c {
    private static final g a = new g();
    private final Map<g, b<?, ?>> b = new HashMap();

    public <T, Z> b<T, Z> a(Class<T> cls, Class<Z> cls2) {
        b<T, Z> bVar;
        synchronized (a) {
            a.a(cls, cls2);
            bVar = (b) this.b.get(a);
        }
        return bVar == null ? d.e() : bVar;
    }

    public <T, Z> void a(Class<T> cls, Class<Z> cls2, b<T, Z> bVar) {
        this.b.put(new g(cls, cls2), bVar);
    }
}
