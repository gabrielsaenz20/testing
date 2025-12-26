package org.greenrobot.eventbus;

/* loaded from: classes.dex */
final class k {
    private j a;
    private j b;

    k() {
    }

    synchronized j a() {
        j jVar;
        jVar = this.a;
        if (this.a != null) {
            this.a = this.a.c;
            if (this.a == null) {
                this.b = null;
            }
        }
        return jVar;
    }

    synchronized j a(int i) {
        if (this.a == null) {
            wait(i);
        }
        return a();
    }

    synchronized void a(j jVar) {
        try {
            if (jVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            if (this.b != null) {
                this.b.c = jVar;
                this.b = jVar;
            } else {
                if (this.a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.b = jVar;
                this.a = jVar;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }
}
