package com.a.a.e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class m {
    private final Set<com.a.a.h.b> a = Collections.newSetFromMap(new WeakHashMap());
    private final List<com.a.a.h.b> b = new ArrayList();
    private boolean c;

    public void a() {
        this.c = true;
        for (com.a.a.h.b bVar : com.a.a.j.h.a(this.a)) {
            if (bVar.f()) {
                bVar.e();
                this.b.add(bVar);
            }
        }
    }

    public void a(com.a.a.h.b bVar) {
        this.a.add(bVar);
        if (this.c) {
            this.b.add(bVar);
        } else {
            bVar.b();
        }
    }

    public void b() {
        this.c = false;
        for (com.a.a.h.b bVar : com.a.a.j.h.a(this.a)) {
            if (!bVar.g() && !bVar.i() && !bVar.f()) {
                bVar.b();
            }
        }
        this.b.clear();
    }

    public void b(com.a.a.h.b bVar) {
        this.a.remove(bVar);
        this.b.remove(bVar);
    }

    public void c() {
        Iterator it = com.a.a.j.h.a(this.a).iterator();
        while (it.hasNext()) {
            ((com.a.a.h.b) it.next()).d();
        }
        this.b.clear();
    }

    public void d() {
        for (com.a.a.h.b bVar : com.a.a.j.h.a(this.a)) {
            if (!bVar.g() && !bVar.i()) {
                bVar.e();
                if (this.c) {
                    this.b.add(bVar);
                } else {
                    bVar.b();
                }
            }
        }
    }
}
