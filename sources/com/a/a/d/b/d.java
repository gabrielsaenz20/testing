package com.a.a.d.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.a.a.d.b.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
class d implements i.a {
    private static final a a = new a();
    private static final Handler b = new Handler(Looper.getMainLooper(), new b());
    private final List<com.a.a.h.e> c;
    private final a d;
    private final e e;
    private final com.a.a.d.c f;
    private final ExecutorService g;
    private final ExecutorService h;
    private final boolean i;
    private boolean j;
    private l<?> k;
    private boolean l;
    private Exception m;
    private boolean n;
    private Set<com.a.a.h.e> o;
    private i p;
    private h<?> q;
    private volatile Future<?> r;

    static class a {
        a() {
        }

        public <R> h<R> a(l<R> lVar, boolean z) {
            return new h<>(lVar, z);
        }
    }

    private static class b implements Handler.Callback {
        private b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (1 != message.what && 2 != message.what) {
                return false;
            }
            d dVar = (d) message.obj;
            if (1 == message.what) {
                dVar.b();
                return true;
            }
            dVar.c();
            return true;
        }
    }

    public d(com.a.a.d.c cVar, ExecutorService executorService, ExecutorService executorService2, boolean z, e eVar) {
        this(cVar, executorService, executorService2, z, eVar, a);
    }

    public d(com.a.a.d.c cVar, ExecutorService executorService, ExecutorService executorService2, boolean z, e eVar, a aVar) {
        this.c = new ArrayList();
        this.f = cVar;
        this.g = executorService;
        this.h = executorService2;
        this.i = z;
        this.e = eVar;
        this.d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.j) {
            this.k.d();
            return;
        }
        if (this.c.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
        this.q = this.d.a(this.k, this.i);
        this.l = true;
        this.q.e();
        this.e.a(this.f, this.q);
        for (com.a.a.h.e eVar : this.c) {
            if (!d(eVar)) {
                this.q.e();
                eVar.a(this.q);
            }
        }
        this.q.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.j) {
            return;
        }
        if (this.c.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        }
        this.n = true;
        this.e.a(this.f, (h<?>) null);
        for (com.a.a.h.e eVar : this.c) {
            if (!d(eVar)) {
                eVar.a(this.m);
            }
        }
    }

    private void c(com.a.a.h.e eVar) {
        if (this.o == null) {
            this.o = new HashSet();
        }
        this.o.add(eVar);
    }

    private boolean d(com.a.a.h.e eVar) {
        return this.o != null && this.o.contains(eVar);
    }

    void a() {
        if (this.n || this.l || this.j) {
            return;
        }
        this.p.a();
        Future<?> future = this.r;
        if (future != null) {
            future.cancel(true);
        }
        this.j = true;
        this.e.a(this, this.f);
    }

    public void a(i iVar) {
        this.p = iVar;
        this.r = this.g.submit(iVar);
    }

    @Override // com.a.a.h.e
    public void a(l<?> lVar) {
        this.k = lVar;
        b.obtainMessage(1, this).sendToTarget();
    }

    public void a(com.a.a.h.e eVar) {
        com.a.a.j.h.a();
        if (this.l) {
            eVar.a(this.q);
        } else if (this.n) {
            eVar.a(this.m);
        } else {
            this.c.add(eVar);
        }
    }

    @Override // com.a.a.h.e
    public void a(Exception exc) {
        this.m = exc;
        b.obtainMessage(2, this).sendToTarget();
    }

    @Override // com.a.a.d.b.i.a
    public void b(i iVar) {
        this.r = this.h.submit(iVar);
    }

    public void b(com.a.a.h.e eVar) {
        com.a.a.j.h.a();
        if (this.l || this.n) {
            c(eVar);
            return;
        }
        this.c.remove(eVar);
        if (this.c.isEmpty()) {
            a();
        }
    }
}
