package com.a.a.d.b.a;

import com.a.a.d.b.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class e<K extends h, V> {
    private final a<K, V> a = new a<>();
    private final Map<K, a<K, V>> b = new HashMap();

    private static class a<K, V> {
        a<K, V> a;
        a<K, V> b;
        private final K c;
        private List<V> d;

        public a() {
            this(null);
        }

        public a(K k) {
            this.b = this;
            this.a = this;
            this.c = k;
        }

        public V a() {
            int iB = b();
            if (iB > 0) {
                return this.d.remove(iB - 1);
            }
            return null;
        }

        public void a(V v) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(v);
        }

        public int b() {
            if (this.d != null) {
                return this.d.size();
            }
            return 0;
        }
    }

    e() {
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        aVar.b = this.a;
        aVar.a = this.a.a;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        aVar.b = this.a.b;
        aVar.a = this.a;
        c(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.a.b = aVar;
        aVar.b.a = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.b.a = aVar.a;
        aVar.a.b = aVar.b;
    }

    public V a() {
        a aVar = this.a;
        while (true) {
            aVar = aVar.b;
            if (aVar.equals(this.a)) {
                return null;
            }
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            d(aVar);
            this.b.remove(aVar.c);
            ((h) aVar.c).a();
        }
    }

    public V a(K k) {
        a<K, V> aVar = this.b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a((a<K, V>) v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.a.a; !aVar.equals(this.a); aVar = aVar.a) {
            z = true;
            sb.append('{');
            sb.append(aVar.c);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
