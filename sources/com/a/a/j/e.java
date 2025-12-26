package com.a.a.j;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class e<T, Y> {
    private int b;
    private final int c;
    private final LinkedHashMap<T, Y> a = new LinkedHashMap<>(100, 0.75f, true);
    private int d = 0;

    public e(int i) {
        this.c = i;
        this.b = i;
    }

    private void c() {
        b(this.b);
    }

    protected int a(Y y) {
        return 1;
    }

    public void a() {
        b(0);
    }

    protected void a(T t, Y y) {
    }

    public int b() {
        return this.d;
    }

    public Y b(T t) {
        return this.a.get(t);
    }

    public Y b(T t, Y y) {
        if (a(y) >= this.b) {
            a(t, y);
            return null;
        }
        Y yPut = this.a.put(t, y);
        if (y != null) {
            this.d += a(y);
        }
        if (yPut != null) {
            this.d -= a(yPut);
        }
        c();
        return yPut;
    }

    protected void b(int i) {
        while (this.d > i) {
            Map.Entry<T, Y> next = this.a.entrySet().iterator().next();
            Y value = next.getValue();
            this.d -= a(value);
            T key = next.getKey();
            this.a.remove(key);
            a(key, value);
        }
    }

    public Y c(T t) {
        Y yRemove = this.a.remove(t);
        if (yRemove != null) {
            this.d -= a(yRemove);
        }
        return yRemove;
    }
}
