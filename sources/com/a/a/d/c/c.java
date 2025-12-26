package com.a.a.d.c;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class c {
    private static final l c = new l() { // from class: com.a.a.d.c.c.1
        @Override // com.a.a.d.c.l
        public com.a.a.d.a.c a(Object obj, int i, int i2) {
            throw new NoSuchMethodError("This should never be called!");
        }

        public String toString() {
            return "NULL_MODEL_LOADER";
        }
    };
    private final Map<Class, Map<Class, m>> a = new HashMap();
    private final Map<Class, Map<Class, l>> b = new HashMap();
    private final Context d;

    public c(Context context) {
        this.d = context.getApplicationContext();
    }

    private <T, Y> void a(Class<T> cls, Class<Y> cls2, l<T, Y> lVar) {
        Map<Class, l> map = this.b.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.b.put(cls, map);
        }
        map.put(cls2, lVar);
    }

    private <T, Y> void b(Class<T> cls, Class<Y> cls2) {
        a(cls, cls2, c);
    }

    private <T, Y> l<T, Y> c(Class<T> cls, Class<Y> cls2) {
        Map<Class, l> map = this.b.get(cls);
        if (map != null) {
            return map.get(cls2);
        }
        return null;
    }

    private <T, Y> m<T, Y> d(Class<T> cls, Class<Y> cls2) {
        Map<Class, m> map;
        Map<Class, m> map2 = this.a.get(cls);
        m mVar = map2 != null ? map2.get(cls2) : null;
        if (mVar == null) {
            for (Class cls3 : this.a.keySet()) {
                if (cls3.isAssignableFrom(cls) && (map = this.a.get(cls3)) != null && (mVar = map.get(cls2)) != null) {
                    break;
                }
            }
        }
        return mVar;
    }

    public synchronized <T, Y> l<T, Y> a(Class<T> cls, Class<Y> cls2) {
        l<T, Y> lVarC = c(cls, cls2);
        if (lVarC != null) {
            if (c.equals(lVarC)) {
                return null;
            }
            return lVarC;
        }
        m<T, Y> mVarD = d(cls, cls2);
        if (mVarD != null) {
            lVarC = mVarD.a(this.d, this);
            a(cls, cls2, lVarC);
        } else {
            b(cls, cls2);
        }
        return lVarC;
    }

    public synchronized <T, Y> m<T, Y> a(Class<T> cls, Class<Y> cls2, m<T, Y> mVar) {
        m<T, Y> mVarPut;
        this.b.clear();
        Map<Class, m> map = this.a.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.a.put(cls, map);
        }
        mVarPut = map.put(cls2, mVar);
        if (mVarPut != null) {
            Iterator<Map<Class, m>> it = this.a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().containsValue(mVarPut)) {
                    mVarPut = null;
                    break;
                }
            }
        }
        return mVarPut;
    }
}
