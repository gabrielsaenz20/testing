package com.a.a.d.b.b;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
final class c {
    private final Map<com.a.a.d.c, a> a = new HashMap();
    private final b b = new b();

    private static class a {
        final Lock a;
        int b;

        private a() {
            this.a = new ReentrantLock();
        }
    }

    private static class b {
        private final Queue<a> a;

        private b() {
            this.a = new ArrayDeque();
        }

        a a() {
            a aVarPoll;
            synchronized (this.a) {
                aVarPoll = this.a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        void a(a aVar) {
            synchronized (this.a) {
                if (this.a.size() < 10) {
                    this.a.offer(aVar);
                }
            }
        }
    }

    c() {
    }

    void a(com.a.a.d.c cVar) {
        a aVarA;
        synchronized (this) {
            aVarA = this.a.get(cVar);
            if (aVarA == null) {
                aVarA = this.b.a();
                this.a.put(cVar, aVarA);
            }
            aVarA.b++;
        }
        aVarA.a.lock();
    }

    void b(com.a.a.d.c cVar) {
        a aVar;
        synchronized (this) {
            aVar = this.a.get(cVar);
            if (aVar != null && aVar.b > 0) {
                int i = aVar.b - 1;
                aVar.b = i;
                if (i == 0) {
                    a aVarRemove = this.a.remove(cVar);
                    if (!aVarRemove.equals(aVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", key: " + cVar);
                    }
                    this.b.a(aVarRemove);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot release a lock that is not held, key: ");
            sb.append(cVar);
            sb.append(", interestedThreads: ");
            sb.append(aVar == null ? 0 : aVar.b);
            throw new IllegalArgumentException(sb.toString());
        }
        aVar.a.unlock();
    }
}
