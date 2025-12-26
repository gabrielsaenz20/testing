package com.a.a.e;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class a implements g {
    private final Set<h> a = Collections.newSetFromMap(new WeakHashMap());
    private boolean b;
    private boolean c;

    a() {
    }

    void a() {
        this.b = true;
        Iterator it = com.a.a.j.h.a(this.a).iterator();
        while (it.hasNext()) {
            ((h) it.next()).d();
        }
    }

    @Override // com.a.a.e.g
    public void a(h hVar) {
        this.a.add(hVar);
        if (this.c) {
            hVar.f();
        } else if (this.b) {
            hVar.d();
        } else {
            hVar.e();
        }
    }

    void b() {
        this.b = false;
        Iterator it = com.a.a.j.h.a(this.a).iterator();
        while (it.hasNext()) {
            ((h) it.next()).e();
        }
    }

    void c() {
        this.c = true;
        Iterator it = com.a.a.j.h.a(this.a).iterator();
        while (it.hasNext()) {
            ((h) it.next()).f();
        }
    }
}
