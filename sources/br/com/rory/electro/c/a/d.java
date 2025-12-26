package br.com.rory.electro.c.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/* loaded from: classes.dex */
public class d {
    private static d b;
    private static final Object c;
    private Context a;
    private br.com.rory.electro.e.a f;
    private i g;
    private ScheduledExecutorService p;
    private final List<a> d = new CopyOnWriteArrayList();
    private final Map<String, ExecutorService> e = new ConcurrentHashMap();
    private boolean h = false;
    private int i = 5;
    private int j = 0;
    private int k = 0;
    private long l = 0;
    private int m = 0;
    private boolean n = false;
    private volatile long o = 0;
    private volatile boolean q = false;

    /* renamed from: br.com.rory.electro.c.a.d$1, reason: invalid class name */
    class AnonymousClass1 implements Predicate<a> {
        final /* synthetic */ a a;

        static {
            NativeLoader.classesInit0(274);
        }

        AnonymousClass1(a aVar) {
            this.a = aVar;
        }

        @Override // java.util.function.Predicate
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public native boolean test(a aVar);
    }

    /* renamed from: br.com.rory.electro.c.a.d$2, reason: invalid class name */
    class AnonymousClass2 implements br.com.rory.electro.c.a.b {
        static {
            NativeLoader.classesInit0(275);
        }

        AnonymousClass2() {
        }

        @Override // br.com.rory.electro.c.a.b
        public native void a(i iVar, byte[] bArr, int i, int i2, int i3, int i4, int i5, long j);

        @Override // br.com.rory.electro.c.a.b
        public native void a(i iVar, byte[] bArr, int i, int i2, int i3, int i4, long j);
    }

    /* renamed from: br.com.rory.electro.c.a.d$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        static {
            NativeLoader.classesInit0(279);
        }

        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.d$4, reason: invalid class name */
    class AnonymousClass4 implements Predicate<ExecutorService> {
        static {
            NativeLoader.classesInit0(281);
        }

        AnonymousClass4() {
        }

        @Override // java.util.function.Predicate
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public native boolean test(ExecutorService executorService);
    }

    /* renamed from: br.com.rory.electro.c.a.d$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ a a;
        final /* synthetic */ byte[] b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ long g;

        static {
            NativeLoader.classesInit0(277);
        }

        AnonymousClass5(a aVar, byte[] bArr, int i, int i2, int i3, int i4, long j) {
            this.a = aVar;
            this.b = bArr;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = j;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.d$6, reason: invalid class name */
    class AnonymousClass6 implements ThreadFactory {
        final /* synthetic */ String a;

        static {
            NativeLoader.classesInit0(278);
        }

        AnonymousClass6(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public native Thread newThread(Runnable runnable);
    }

    /* renamed from: br.com.rory.electro.c.a.d$7, reason: invalid class name */
    class AnonymousClass7 implements ThreadFactory {
        static {
            NativeLoader.classesInit0(285);
        }

        AnonymousClass7() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public native Thread newThread(Runnable runnable);
    }

    /* renamed from: br.com.rory.electro.c.a.d$8, reason: invalid class name */
    class AnonymousClass8 implements Runnable {
        static {
            NativeLoader.classesInit0(286);
        }

        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    public interface a {
        String a();

        void a(byte[] bArr, int i, int i2, int i3, int i4, long j);

        int b();

        int c();
    }

    public static class b extends ThreadPoolExecutor {
        public b(ThreadFactory threadFactory) {
            super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(2), threadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());
        }
    }

    static {
        NativeLoader.classesInit0(190);
        c = new Object();
    }

    private d(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
            this.f = br.com.rory.electro.e.a.a(context);
        }
    }

    public static native d a(Context context);

    /* JADX INFO: Access modifiers changed from: private */
    public native void a(byte[] bArr, int i, int i2, int i3, int i4, long j);

    public static native boolean a();

    public static native int[] a(int i, int i2, int i3);

    public static native int b();

    public static native int c();

    public static native int d();

    private native void d(a aVar);

    public static native int e();

    private native void e(a aVar);

    private static native String h();

    private native void i();

    private native void j();

    private native void k();

    private native void l();

    private native void m();

    private native void n();

    /* JADX INFO: Access modifiers changed from: private */
    public native void o();

    private native synchronized void p();

    public native synchronized void a(a aVar);

    protected native void a(String str);

    public native synchronized void b(a aVar);

    public native synchronized void c(a aVar);

    public native synchronized void f();

    public native synchronized void g();
}
