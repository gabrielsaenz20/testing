package com.a.a.j;

/* loaded from: classes.dex */
public class g {
    private Class<?> a;
    private Class<?> b;

    public g() {
    }

    public g(Class<?> cls, Class<?> cls2) {
        a(cls, cls2);
    }

    public void a(Class<?> cls, Class<?> cls2) {
        this.a = cls;
        this.b = cls2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.a.equals(gVar.a) && this.b.equals(gVar.b);
    }

    public int hashCode() {
        return (31 * this.a.hashCode()) + this.b.hashCode();
    }

    public String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
    }
}
