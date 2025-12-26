package com.a.a.d.b;

import android.util.Log;

/* loaded from: classes.dex */
class i implements com.a.a.d.b.c.b, Runnable {
    private final com.a.a.i a;
    private final a b;
    private final com.a.a.d.b.a<?, ?, ?> c;
    private b d = b.CACHE;
    private volatile boolean e;

    interface a extends com.a.a.h.e {
        void b(i iVar);
    }

    private enum b {
        CACHE,
        SOURCE
    }

    public i(a aVar, com.a.a.d.b.a<?, ?, ?> aVar2, com.a.a.i iVar) {
        this.b = aVar;
        this.c = aVar2;
        this.a = iVar;
    }

    private void a(l lVar) {
        this.b.a((l<?>) lVar);
    }

    private void a(Exception exc) {
        if (!c()) {
            this.b.a(exc);
        } else {
            this.d = b.SOURCE;
            this.b.b(this);
        }
    }

    private boolean c() {
        return this.d == b.CACHE;
    }

    private l<?> d() {
        return c() ? e() : f();
    }

    private l<?> e() {
        l<?> lVarA;
        try {
            lVarA = this.c.a();
        } catch (Exception e) {
            if (Log.isLoggable("EngineRunnable", 3)) {
                Log.d("EngineRunnable", "Exception decoding result from cache: " + e);
            }
            lVarA = null;
        }
        return lVarA == null ? this.c.b() : lVarA;
    }

    private l<?> f() {
        return this.c.c();
    }

    public void a() {
        this.e = true;
        this.c.d();
    }

    @Override // com.a.a.d.b.c.b
    public int b() {
        return this.a.ordinal();
    }

    @Override // java.lang.Runnable
    public void run() {
        Exception jVar;
        if (this.e) {
            return;
        }
        l<?> lVarD = null;
        try {
            jVar = null;
            lVarD = d();
        } catch (Exception e) {
            if (Log.isLoggable("EngineRunnable", 2)) {
                Log.v("EngineRunnable", "Exception decoding", e);
            }
            jVar = e;
        } catch (OutOfMemoryError e2) {
            if (Log.isLoggable("EngineRunnable", 2)) {
                Log.v("EngineRunnable", "Out Of Memory Error decoding", e2);
            }
            jVar = new j(e2);
        }
        if (this.e) {
            if (lVarD != null) {
                lVarD.d();
            }
        } else if (lVarD == null) {
            a(jVar);
        } else {
            a(lVarD);
        }
    }
}
