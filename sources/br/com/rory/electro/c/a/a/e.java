package br.com.rory.electro.c.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.media.TransportMediator;
import br.com.rory.electro.c.a.a.a.a;
import br.com.rory.electro.c.a.d;
import br.com.rory.electro.common.MOG2Utils;
import com.rory.electro.NativeLoader;
import java.io.File;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class e implements d.a {
    private static volatile e a;
    private static volatile boolean ap;
    private static volatile boolean aq;
    private static final Object b;
    private static final long f;
    private static final a i;
    private ScheduledFuture<?> A;
    private volatile long B;
    private volatile boolean C;
    private volatile boolean D;
    private ExecutorService E;
    private final AtomicBoolean F;
    private long G;
    private a H;
    private int I;
    private int J;
    private long K;
    private long L;
    private long M;
    private long N;
    private long O;
    private long P;
    private long Q;
    private long R;
    private boolean S;
    private final Object T;
    private byte[] U;
    private byte[] V;
    private int W;
    private int X;
    private int Y;
    private int Z;
    private int aa;
    private int ab;
    private long ac;
    private MOG2Utils.a ad;
    private byte[] ae;
    private boolean af;
    private boolean ag;
    private float ah;
    private boolean ai;
    private long aj;
    private long ak;
    private int al;
    private int am;
    private long an;
    private int ao;
    private HandlerThread c;
    private Handler d;
    private boolean e;
    private volatile boolean g;
    private int h;
    private Context j;
    private br.com.rory.electro.c.a.a.b.a k;
    private br.com.rory.electro.c.a.d l;
    private br.com.rory.electro.c.a.a.a.a m;
    private boolean n;
    private volatile boolean o;
    private br.com.rory.electro.c.a.a.c.a p;
    private ExecutorService q;
    private boolean r;
    private String s;
    private volatile boolean t;
    private ScheduledExecutorService u;
    private ScheduledFuture<?> v;
    private boolean w;
    private ScheduledExecutorService x;
    private ScheduledFuture<?> y;
    private ScheduledExecutorService z;

    /* renamed from: br.com.rory.electro.c.a.a.e$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        static {
            NativeLoader.classesInit0(6);
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$10, reason: invalid class name */
    class AnonymousClass10 implements Runnable {
        static {
            NativeLoader.classesInit0(347);
        }

        AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$11, reason: invalid class name */
    class AnonymousClass11 implements Runnable {
        static {
            NativeLoader.classesInit0(359);
        }

        AnonymousClass11() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$12, reason: invalid class name */
    class AnonymousClass12 implements Runnable {
        static {
            NativeLoader.classesInit0(358);
        }

        AnonymousClass12() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$13, reason: invalid class name */
    class AnonymousClass13 implements Runnable {
        static {
            NativeLoader.classesInit0(361);
        }

        AnonymousClass13() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$14, reason: invalid class name */
    class AnonymousClass14 implements ThreadFactory {
        static {
            NativeLoader.classesInit0(360);
        }

        AnonymousClass14() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public native Thread newThread(Runnable runnable);
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$15, reason: invalid class name */
    class AnonymousClass15 implements a.b {
        static {
            NativeLoader.classesInit0(352);
        }

        AnonymousClass15() {
        }

        @Override // br.com.rory.electro.c.a.a.a.a.b
        public native void a(String str);
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$16, reason: invalid class name */
    class AnonymousClass16 implements ThreadFactory {
        static {
            NativeLoader.classesInit0(351);
        }

        AnonymousClass16() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public native Thread newThread(Runnable runnable);
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$17, reason: invalid class name */
    class AnonymousClass17 implements ThreadFactory {
        static {
            NativeLoader.classesInit0(355);
        }

        AnonymousClass17() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public native Thread newThread(Runnable runnable);
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$18, reason: invalid class name */
    class AnonymousClass18 implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        static {
            NativeLoader.classesInit0(353);
        }

        AnonymousClass18(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$19, reason: invalid class name */
    class AnonymousClass19 implements Runnable {
        final /* synthetic */ byte[] a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ long f;

        static {
            NativeLoader.classesInit0(362);
        }

        AnonymousClass19(byte[] bArr, int i, int i2, int i3, int i4, long j) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = j;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ byte[] a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ long d;

        static {
            NativeLoader.classesInit0(8);
        }

        AnonymousClass2(byte[] bArr, int i, int i2, long j) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        static {
            NativeLoader.classesInit0(10);
        }

        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        static {
            NativeLoader.classesInit0(11);
        }

        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        static {
            NativeLoader.classesInit0(12);
        }

        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$6, reason: invalid class name */
    class AnonymousClass6 implements Runnable {
        static {
            NativeLoader.classesInit0(14);
        }

        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$7, reason: invalid class name */
    class AnonymousClass7 implements Runnable {
        static {
            NativeLoader.classesInit0(16);
        }

        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$8, reason: invalid class name */
    class AnonymousClass8 implements Comparator<File> {
        static {
            NativeLoader.classesInit0(18);
        }

        AnonymousClass8() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public native int compare(File file, File file2);
    }

    /* renamed from: br.com.rory.electro.c.a.a.e$9, reason: invalid class name */
    class AnonymousClass9 implements Runnable {
        static {
            NativeLoader.classesInit0(19);
        }

        AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    public enum a {
        LIVE_CAMERA,
        SESSION_REPLAY,
        MP4_REPLAY;

        static {
            NativeLoader.classesInit0(40);
        }

        public static native a valueOf(String str);

        public static native a[] values();
    }

    static {
        NativeLoader.classesInit0(TransportMediator.KEYCODE_MEDIA_PLAY);
        b = new Object();
        f = TimeUnit.MINUTES.toMillis(5L);
        i = a.LIVE_CAMERA;
    }

    private e() {
        this(i, 1);
    }

    private e(a aVar) {
        this(aVar, 1);
    }

    private e(a aVar, int i2) {
        this.g = false;
        this.h = -1;
        this.n = false;
        this.o = false;
        this.r = false;
        this.s = null;
        this.t = false;
        this.w = false;
        this.B = 0L;
        this.C = false;
        this.D = false;
        this.F = new AtomicBoolean(false);
        this.G = 0L;
        this.J = 0;
        this.K = 0L;
        this.L = 0L;
        this.M = 0L;
        this.N = 0L;
        this.O = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        this.S = false;
        this.T = new Object();
        this.U = null;
        this.V = null;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.aa = 0;
        this.ab = -1;
        this.ac = 0L;
        this.ad = null;
        this.ae = null;
        this.af = false;
        this.ag = true;
        this.ah = 0.0f;
        this.ai = false;
        this.aj = 0L;
        this.ak = 0L;
        this.al = 0;
        this.am = 0;
        this.an = 0L;
        this.ao = -1;
        this.H = aVar;
        this.I = i2;
    }

    private native void A();

    private native void B();

    private native void C();

    private native void D();

    /* JADX INFO: Access modifiers changed from: private */
    public native void E();

    /* JADX INFO: Access modifiers changed from: private */
    public native void F();

    /* JADX INFO: Access modifiers changed from: private */
    public native synchronized void G();

    private native boolean H();

    private native void I();

    /* JADX INFO: Access modifiers changed from: private */
    public native void J();

    private native void K();

    /* JADX INFO: Access modifiers changed from: private */
    public native void L();

    private native void M();

    private native void N();

    /* JADX INFO: Access modifiers changed from: private */
    public native void O();

    private native List<File> a(File file);

    private native void a(float f2);

    private native void a(float f2, float f3);

    private native void a(long j);

    private native void a(File file, List<File> list);

    /* JADX INFO: Access modifiers changed from: private */
    public native void a(byte[] bArr);

    private native void a(byte[] bArr, int i2, int i3);

    private native void a(byte[] bArr, int i2, int i3, String str, boolean z);

    private native boolean a(int i2, int i3);

    private native boolean a(byte[] bArr, int i2, int i3, long j);

    private native byte[] a(int i2);

    private native int b(byte[] bArr, int i2, int i3);

    public static native void b(Context context);

    /* JADX INFO: Access modifiers changed from: private */
    public native void b(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void b(byte[] bArr, int i2, int i3, int i4, int i5, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void b(byte[] bArr, int i2, int i3, long j);

    private native boolean b(File file);

    private native void c(Context context);

    private native void c(String str);

    private native void c(byte[] bArr, int i2, int i3);

    private native void c(byte[] bArr, int i2, int i3, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void d(String str);

    private native void d(byte[] bArr, int i2, int i3);

    public static native synchronized e e();

    static /* synthetic */ int n(e eVar) {
        int i2 = eVar.am;
        eVar.am = i2 + 1;
        return i2;
    }

    private static final native String p();

    private native int q();

    private native int r();

    private native long s();

    /* JADX INFO: Access modifiers changed from: private */
    public native long t();

    private native float u();

    private native float v();

    /* JADX INFO: Access modifiers changed from: private */
    public native float w();

    private native float x();

    /* JADX INFO: Access modifiers changed from: private */
    public native int y();

    private native boolean z();

    @Override // br.com.rory.electro.c.a.d.a
    public native String a();

    public native void a(Context context);

    protected native void a(String str);

    public native void a(Date date);

    public native void a(boolean z);

    @Override // br.com.rory.electro.c.a.d.a
    public native void a(byte[] bArr, int i2, int i3, int i4, int i5, long j);

    @Override // br.com.rory.electro.c.a.d.a
    public native int b();

    @Override // br.com.rory.electro.c.a.d.a
    public native int c();

    public native synchronized void d();

    public native synchronized void f();

    public native synchronized void g();

    public native int h();

    public native String i();

    public native int j();

    public native boolean k();

    public native boolean l();

    protected native boolean m();

    public native void n();

    public native void o();
}
