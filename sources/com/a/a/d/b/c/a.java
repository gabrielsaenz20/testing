package com.a.a.d.b.c;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class a extends ThreadPoolExecutor {
    private final AtomicInteger a;
    private final c b;

    /* renamed from: com.a.a.d.b.c.a$a, reason: collision with other inner class name */
    public static class ThreadFactoryC0024a implements ThreadFactory {
        int a = 0;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "fifo-pool-thread-" + this.a) { // from class: com.a.a.d.b.c.a.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws SecurityException, IllegalArgumentException {
                    Process.setThreadPriority(10);
                    super.run();
                }
            };
            this.a = this.a + 1;
            return thread;
        }
    }

    static class b<T> extends FutureTask<T> implements Comparable<b<?>> {
        private final int a;
        private final int b;

        public b(Runnable runnable, T t, int i) {
            super(runnable, t);
            if (!(runnable instanceof com.a.a.d.b.c.b)) {
                throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
            }
            this.a = ((com.a.a.d.b.c.b) runnable).b();
            this.b = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b<?> bVar) {
            int i = this.a - bVar.a;
            return i == 0 ? this.b - bVar.b : i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.a == bVar.a;
        }

        public int hashCode() {
            return (31 * this.a) + this.b;
        }
    }

    public enum c {
        IGNORE,
        LOG { // from class: com.a.a.d.b.c.a.c.1
            @Override // com.a.a.d.b.c.a.c
            protected void a(Throwable th) {
                if (Log.isLoggable("PriorityExecutor", 6)) {
                    Log.e("PriorityExecutor", "Request threw uncaught throwable", th);
                }
            }
        },
        THROW { // from class: com.a.a.d.b.c.a.c.2
            @Override // com.a.a.d.b.c.a.c
            protected void a(Throwable th) {
                super.a(th);
                throw new RuntimeException(th);
            }
        };

        protected void a(Throwable th) {
        }
    }

    public a(int i) {
        this(i, c.LOG);
    }

    public a(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory, c cVar) {
        super(i, i2, j, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.a = new AtomicInteger();
        this.b = cVar;
    }

    public a(int i, c cVar) {
        this(i, i, 0L, TimeUnit.MILLISECONDS, new ThreadFactoryC0024a(), cVar);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) throws ExecutionException, InterruptedException {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (!future.isDone() || future.isCancelled()) {
                return;
            }
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                this.b.a(e);
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new b(runnable, t, this.a.getAndIncrement());
    }
}
