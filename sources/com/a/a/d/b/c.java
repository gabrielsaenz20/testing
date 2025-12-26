package com.a.a.d.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import com.a.a.d.b.a;
import com.a.a.d.b.b.a;
import com.a.a.d.b.b.h;
import com.a.a.d.b.h;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class c implements h.a, com.a.a.d.b.e, h.a {
    private final Map<com.a.a.d.c, com.a.a.d.b.d> a;
    private final g b;
    private final com.a.a.d.b.b.h c;
    private final a d;
    private final Map<com.a.a.d.c, WeakReference<h<?>>> e;
    private final m f;
    private final b g;
    private ReferenceQueue<h<?>> h;

    static class a {
        private final ExecutorService a;
        private final ExecutorService b;
        private final com.a.a.d.b.e c;

        public a(ExecutorService executorService, ExecutorService executorService2, com.a.a.d.b.e eVar) {
            this.a = executorService;
            this.b = executorService2;
            this.c = eVar;
        }

        public com.a.a.d.b.d a(com.a.a.d.c cVar, boolean z) {
            return new com.a.a.d.b.d(cVar, this.a, this.b, z, this.c);
        }
    }

    private static class b implements a.InterfaceC0021a {
        private final a.InterfaceC0023a a;
        private volatile com.a.a.d.b.b.a b;

        public b(a.InterfaceC0023a interfaceC0023a) {
            this.a = interfaceC0023a;
        }

        @Override // com.a.a.d.b.a.InterfaceC0021a
        public com.a.a.d.b.b.a a() {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = this.a.a();
                    }
                    if (this.b == null) {
                        this.b = new com.a.a.d.b.b.b();
                    }
                }
            }
            return this.b;
        }
    }

    /* renamed from: com.a.a.d.b.c$c, reason: collision with other inner class name */
    public static class C0025c {
        private final com.a.a.d.b.d a;
        private final com.a.a.h.e b;

        public C0025c(com.a.a.h.e eVar, com.a.a.d.b.d dVar) {
            this.b = eVar;
            this.a = dVar;
        }

        public void a() {
            this.a.b(this.b);
        }
    }

    private static class d implements MessageQueue.IdleHandler {
        private final Map<com.a.a.d.c, WeakReference<h<?>>> a;
        private final ReferenceQueue<h<?>> b;

        public d(Map<com.a.a.d.c, WeakReference<h<?>>> map, ReferenceQueue<h<?>> referenceQueue) {
            this.a = map;
            this.b = referenceQueue;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            e eVar = (e) this.b.poll();
            if (eVar == null) {
                return true;
            }
            this.a.remove(eVar.a);
            return true;
        }
    }

    private static class e extends WeakReference<h<?>> {
        private final com.a.a.d.c a;

        public e(com.a.a.d.c cVar, h<?> hVar, ReferenceQueue<? super h<?>> referenceQueue) {
            super(hVar, referenceQueue);
            this.a = cVar;
        }
    }

    public c(com.a.a.d.b.b.h hVar, a.InterfaceC0023a interfaceC0023a, ExecutorService executorService, ExecutorService executorService2) {
        this(hVar, interfaceC0023a, executorService, executorService2, null, null, null, null, null);
    }

    c(com.a.a.d.b.b.h hVar, a.InterfaceC0023a interfaceC0023a, ExecutorService executorService, ExecutorService executorService2, Map<com.a.a.d.c, com.a.a.d.b.d> map, g gVar, Map<com.a.a.d.c, WeakReference<h<?>>> map2, a aVar, m mVar) {
        this.c = hVar;
        this.g = new b(interfaceC0023a);
        this.e = map2 == null ? new HashMap<>() : map2;
        this.b = gVar == null ? new g() : gVar;
        this.a = map == null ? new HashMap<>() : map;
        this.d = aVar == null ? new a(executorService, executorService2, this) : aVar;
        this.f = mVar == null ? new m() : mVar;
        hVar.a(this);
    }

    private h<?> a(com.a.a.d.c cVar) {
        l<?> lVarA = this.c.a(cVar);
        if (lVarA == null) {
            return null;
        }
        return lVarA instanceof h ? (h) lVarA : new h<>(lVarA, true);
    }

    private h<?> a(com.a.a.d.c cVar, boolean z) {
        h<?> hVar = null;
        if (!z) {
            return null;
        }
        WeakReference<h<?>> weakReference = this.e.get(cVar);
        if (weakReference != null) {
            hVar = weakReference.get();
            if (hVar != null) {
                hVar.e();
                return hVar;
            }
            this.e.remove(cVar);
        }
        return hVar;
    }

    private ReferenceQueue<h<?>> a() {
        if (this.h == null) {
            this.h = new ReferenceQueue<>();
            Looper.myQueue().addIdleHandler(new d(this.e, this.h));
        }
        return this.h;
    }

    private static void a(String str, long j, com.a.a.d.c cVar) {
        Log.v("Engine", str + " in " + com.a.a.j.d.a(j) + "ms, key: " + cVar);
    }

    private h<?> b(com.a.a.d.c cVar, boolean z) {
        if (!z) {
            return null;
        }
        h<?> hVarA = a(cVar);
        if (hVarA != null) {
            hVarA.e();
            this.e.put(cVar, new e(cVar, hVarA, a()));
        }
        return hVarA;
    }

    public <T, Z, R> C0025c a(com.a.a.d.c cVar, int i, int i2, com.a.a.d.a.c<T> cVar2, com.a.a.g.b<T, Z> bVar, com.a.a.d.g<Z> gVar, com.a.a.d.d.f.c<Z, R> cVar3, com.a.a.i iVar, boolean z, com.a.a.d.b.b bVar2, com.a.a.h.e eVar) {
        com.a.a.j.h.a();
        long jA = com.a.a.j.d.a();
        f fVarA = this.b.a(cVar2.b(), cVar, i, i2, bVar.a(), bVar.b(), gVar, bVar.d(), cVar3, bVar.c());
        h<?> hVarB = b(fVarA, z);
        if (hVarB != null) {
            eVar.a(hVarB);
            if (Log.isLoggable("Engine", 2)) {
                a("Loaded resource from cache", jA, fVarA);
            }
            return null;
        }
        h<?> hVarA = a(fVarA, z);
        if (hVarA != null) {
            eVar.a(hVarA);
            if (Log.isLoggable("Engine", 2)) {
                a("Loaded resource from active resources", jA, fVarA);
            }
            return null;
        }
        com.a.a.d.b.d dVar = this.a.get(fVarA);
        if (dVar != null) {
            dVar.a(eVar);
            if (Log.isLoggable("Engine", 2)) {
                a("Added to existing load", jA, fVarA);
            }
            return new C0025c(eVar, dVar);
        }
        com.a.a.d.b.d dVarA = this.d.a(fVarA, z);
        i iVar2 = new i(dVarA, new com.a.a.d.b.a(fVarA, i, i2, cVar2, bVar, gVar, cVar3, this.g, bVar2, iVar), iVar);
        this.a.put(fVarA, dVarA);
        dVarA.a(eVar);
        dVarA.a(iVar2);
        if (Log.isLoggable("Engine", 2)) {
            a("Started new load", jA, fVarA);
        }
        return new C0025c(eVar, dVarA);
    }

    @Override // com.a.a.d.b.e
    public void a(com.a.a.d.b.d dVar, com.a.a.d.c cVar) {
        com.a.a.j.h.a();
        if (dVar.equals(this.a.get(cVar))) {
            this.a.remove(cVar);
        }
    }

    public void a(l lVar) {
        com.a.a.j.h.a();
        if (!(lVar instanceof h)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((h) lVar).f();
    }

    @Override // com.a.a.d.b.e
    public void a(com.a.a.d.c cVar, h<?> hVar) {
        com.a.a.j.h.a();
        if (hVar != null) {
            hVar.a(cVar, this);
            if (hVar.a()) {
                this.e.put(cVar, new e(cVar, hVar, a()));
            }
        }
        this.a.remove(cVar);
    }

    @Override // com.a.a.d.b.b.h.a
    public void b(l<?> lVar) {
        com.a.a.j.h.a();
        this.f.a(lVar);
    }

    @Override // com.a.a.d.b.h.a
    public void b(com.a.a.d.c cVar, h hVar) {
        com.a.a.j.h.a();
        this.e.remove(cVar);
        if (hVar.a()) {
            this.c.b(cVar, hVar);
        } else {
            this.f.a(hVar);
        }
    }
}
