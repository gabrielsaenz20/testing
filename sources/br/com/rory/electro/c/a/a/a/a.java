package br.com.rory.electro.c.a.a.a;

import android.content.Context;
import br.com.rory.electro.c.a.a.f;
import br.com.rory.electro.c.a.a.g;
import br.com.rory.electro.c.a.d;
import com.rory.electro.NativeLoader;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a implements g {
    private final Context a;
    private final ExecutorService b;
    private final ExecutorService c;
    private final AtomicBoolean d;
    private final AtomicBoolean e;
    private final AtomicBoolean f;
    private final Object g;
    private final Object h;
    private d.a i;
    private f j;
    private b k;
    private int l;
    private long m;
    private long n;
    private byte[] o;
    private Integer p;

    /* renamed from: br.com.rory.electro.c.a.a.a.a$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ File c;

        static {
            NativeLoader.classesInit0(72);
        }

        AnonymousClass3(int i, int i2, File file) {
            this.a = i;
            this.b = i2;
            this.c = file;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.a.a$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ byte[] b;
        final /* synthetic */ int c;

        static {
            NativeLoader.classesInit0(71);
        }

        AnonymousClass4(int i, byte[] bArr, int i2) {
            this.a = i;
            this.b = bArr;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.a.a$a, reason: collision with other inner class name */
    public static class C0010a {
        private final int a;
        private final int b;
        private final String c;

        static {
            NativeLoader.classesInit0(433);
        }

        public C0010a(int i, int i2, String str) {
            this.a = i;
            this.b = i2;
            this.c = str;
        }

        public native int a();

        public native int b();

        public native String c();
    }

    public interface b {
        void a(String str);
    }

    static {
        NativeLoader.classesInit0(324);
    }

    public a(Context context) {
        this.a = context != null ? context.getApplicationContext() : null;
        this.b = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: br.com.rory.electro.c.a.a.a.a.1
            static {
                NativeLoader.classesInit0(74);
            }

            @Override // java.util.concurrent.ThreadFactory
            public native Thread newThread(Runnable runnable);
        });
        this.c = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: br.com.rory.electro.c.a.a.a.a.2
            static {
                NativeLoader.classesInit0(73);
            }

            @Override // java.util.concurrent.ThreadFactory
            public native Thread newThread(Runnable runnable);
        });
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new Object();
        this.h = new Object();
        this.p = null;
    }

    private native void a(int i, int i2, File file);

    private native void a(File file);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean a(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native byte[] a(byte[] bArr, int i, int i2);

    private native File b(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void b(int i, int i2, File file);

    /* JADX INFO: Access modifiers changed from: private */
    public native void b(String str);

    private native long c(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native byte[] d(int i);

    private static native String f();

    private static native String g();

    private static native String h();

    /* JADX INFO: Access modifiers changed from: private */
    public static native int i();

    private static native String j();

    private static native String k();

    private native void l();

    @Override // br.com.rory.electro.c.a.a.g
    public native void a();

    @Override // br.com.rory.electro.c.a.a.g
    public native void a(int i, int i2);

    public native void a(b bVar);

    @Override // br.com.rory.electro.c.a.a.g
    public native void a(String str);

    @Override // br.com.rory.electro.c.a.a.g
    public native void a(boolean z);

    @Override // br.com.rory.electro.c.a.a.g
    public native void a(byte[] bArr, int i, int i2, long j);

    public native boolean a(int i);

    public native boolean a(d.a aVar, int i);

    public native C0010a b(int i);

    @Override // br.com.rory.electro.c.a.a.g
    public native void b();

    @Override // br.com.rory.electro.c.a.a.g
    public native void b(byte[] bArr, int i, int i2, long j);

    public native void c();

    public native void d();
}
