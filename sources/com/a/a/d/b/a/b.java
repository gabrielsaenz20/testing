package com.a.a.d.b.a;

import com.a.a.d.b.a.h;
import java.util.Queue;

/* loaded from: classes.dex */
abstract class b<T extends h> {
    private final Queue<T> a = com.a.a.j.h.a(20);

    b() {
    }

    public void a(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }

    protected abstract T b();

    protected T c() {
        T tPoll = this.a.poll();
        return tPoll == null ? (T) b() : tPoll;
    }
}
