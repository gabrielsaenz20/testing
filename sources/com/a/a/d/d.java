package com.a.a.d;

import com.a.a.d.b.l;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class d<T> implements g<T> {
    private final Collection<? extends g<T>> a;
    private String b;

    @SafeVarargs
    public d(g<T>... gVarArr) {
        if (gVarArr.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.a = Arrays.asList(gVarArr);
    }

    @Override // com.a.a.d.g
    public l<T> a(l<T> lVar, int i, int i2) {
        Iterator<? extends g<T>> it = this.a.iterator();
        l<T> lVar2 = lVar;
        while (it.hasNext()) {
            l<T> lVarA = it.next().a(lVar2, i, i2);
            if (lVar2 != null && !lVar2.equals(lVar) && !lVar2.equals(lVarA)) {
                lVar2.d();
            }
            lVar2 = lVarA;
        }
        return lVar2;
    }

    @Override // com.a.a.d.g
    public String a() {
        if (this.b == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<? extends g<T>> it = this.a.iterator();
            while (it.hasNext()) {
                sb.append(it.next().a());
            }
            this.b = sb.toString();
        }
        return this.b;
    }
}
