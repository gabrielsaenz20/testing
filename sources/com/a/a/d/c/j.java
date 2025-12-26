package com.a.a.d.c;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class j implements e {
    private final Map<String, List<i>> c;
    private volatile Map<String, String> d;

    public static final class a {
        private static final String a = System.getProperty("http.agent");
        private static final Map<String, List<i>> b;
        private boolean c = true;
        private Map<String, List<i>> d = b;
        private boolean e = true;
        private boolean f = true;

        static {
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(a)) {
                map.put("User-Agent", Collections.singletonList(new b(a)));
            }
            map.put("Accept-Encoding", Collections.singletonList(new b("identity")));
            b = Collections.unmodifiableMap(map);
        }

        public j a() {
            this.c = true;
            return new j(this.d);
        }
    }

    static final class b implements i {
        private final String a;

        b(String str) {
            this.a = str;
        }

        @Override // com.a.a.d.c.i
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.c = Collections.unmodifiableMap(map);
    }

    private Map<String, String> b() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.c.entrySet()) {
            StringBuilder sb = new StringBuilder();
            List<i> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                sb.append(value.get(i).a());
                if (i != value.size() - 1) {
                    sb.append(',');
                }
            }
            map.put(entry.getKey(), sb.toString());
        }
        return map;
    }

    @Override // com.a.a.d.c.e
    public Map<String, String> a() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.c.equals(((j) obj).c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.c + '}';
    }
}
