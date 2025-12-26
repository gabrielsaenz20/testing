package br.com.rory.electro.l.b;

import br.com.rory.electro.l.c;
import com.rory.electro.NativeLoader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public class a {
    private final c a;
    private boolean c = false;
    private boolean d = false;
    private int e = 0;
    private int f = 0;
    private final ExecutorService b = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: br.com.rory.electro.l.b.a.1
        static {
            NativeLoader.classesInit0(183);
        }

        @Override // java.util.concurrent.ThreadFactory
        public native Thread newThread(Runnable runnable);
    });

    /* renamed from: br.com.rory.electro.l.b.a$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ long c;
        final /* synthetic */ byte[] d;

        static {
            NativeLoader.classesInit0(185);
        }

        AnonymousClass2(int i, int i2, long j, byte[] bArr) {
            this.a = i;
            this.b = i2;
            this.c = j;
            this.d = bArr;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.l.b.a$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        static {
            NativeLoader.classesInit0(186);
        }

        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.l.b.a$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        static {
            NativeLoader.classesInit0(75);
        }

        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.l.b.a$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        static {
            NativeLoader.classesInit0(76);
        }

        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(170);
    }

    public a(c cVar) {
        this.a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native String g();

    /* JADX INFO: Access modifiers changed from: private */
    public static native String h();

    /* JADX INFO: Access modifiers changed from: private */
    public static native String i();

    private native void j();

    private native void k();

    public native void a();

    public native void a(int i, int i2);

    public native void a(boolean z);

    public native void a(byte[] bArr, int i, int i2, long j);

    public native void b();

    public native void c();
}
