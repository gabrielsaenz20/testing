package br.com.rory.electro.c.a.a;

import android.content.Context;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import br.com.rory.electro.c.a.i;
import com.rory.electro.NativeLoader;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public abstract class a {
    private long A;
    private boolean B;
    private boolean C;
    private boolean D;
    private MediaCodec E;
    private AudioRecord F;
    private ExecutorService G;
    private MediaCodec.BufferInfo H;
    private MediaFormat I;
    private MediaFormat V;
    private boolean W;
    private MediaCodec X;
    private MediaCodec Y;
    private MediaFormat Z;
    protected int a;
    private volatile boolean aa;
    private int ab;
    private int ac;
    private br.com.rory.electro.c.a.b.d ad;
    private br.com.rory.electro.c.a.b.e ae;
    protected int b;
    protected int c;
    protected String d;
    protected String e;
    protected Context f;
    protected br.com.rory.electro.e.a g;
    protected boolean h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private ExecutorService s;
    private i t;
    private br.com.rory.electro.c.a.c.f u;
    private MediaCodec v;
    private MediaMuxer w;
    private boolean x;
    private int y;
    private String z;
    private volatile boolean p = false;
    private int q = 0;
    private boolean r = false;
    private long J = -1;
    private int K = -1;
    private long L = -1;
    private final Object M = new Object();
    private final ArrayDeque<C0009a> N = new ArrayDeque<>();
    private final ArrayDeque<b> O = new ArrayDeque<>();
    private final ArrayDeque<c> P = new ArrayDeque<>();
    private boolean Q = true;
    private boolean R = true;
    private long S = -1;
    private long T = -1;
    private long U = -1;

    /* renamed from: br.com.rory.electro.c.a.a.a$1, reason: invalid class name */
    class AnonymousClass1 implements br.com.rory.electro.c.a.b {
        final /* synthetic */ int[] a;
        final /* synthetic */ CountDownLatch b;
        final /* synthetic */ i c;

        static {
            NativeLoader.classesInit0(373);
        }

        AnonymousClass1(int[] iArr, CountDownLatch countDownLatch, i iVar) {
            this.a = iArr;
            this.b = countDownLatch;
            this.c = iVar;
        }

        @Override // br.com.rory.electro.c.a.b
        public native void a(i iVar, byte[] bArr, int i, int i2, int i3, int i4, int i5, long j);

        @Override // br.com.rory.electro.c.a.b
        public native void a(i iVar, byte[] bArr, int i, int i2, int i3, int i4, long j);
    }

    /* renamed from: br.com.rory.electro.c.a.a.a$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ CountDownLatch a;

        static {
            NativeLoader.classesInit0(374);
        }

        AnonymousClass2(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.a$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        static {
            NativeLoader.classesInit0(375);
        }

        AnonymousClass3(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.a$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        static {
            NativeLoader.classesInit0(376);
        }

        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.a$a, reason: collision with other inner class name */
    private static final class C0009a {
        private final byte[] a;
        private final long b;
        private final int c;

        private C0009a(byte[] bArr, long j, int i) {
            this.a = bArr;
            this.b = j;
            this.c = i;
        }

        /* synthetic */ C0009a(byte[] bArr, long j, int i, AnonymousClass1 anonymousClass1) {
            this(bArr, j, i);
        }
    }

    private static final class b {
        private final byte[] a;
        private final int b;
        private final long c;
        private final int d;

        private b(byte[] bArr, int i, long j, int i2) {
            this.a = bArr;
            this.b = i;
            this.c = j;
            this.d = i2;
        }

        /* synthetic */ b(byte[] bArr, int i, long j, int i2, AnonymousClass1 anonymousClass1) {
            this(bArr, i, j, i2);
        }
    }

    private static final class c {
        private final byte[] a;
        private final long b;
        private final int c;

        static {
            NativeLoader.classesInit0(388);
        }

        private c(byte[] bArr, long j, int i) {
            this.a = bArr;
            this.b = j;
            this.c = i;
        }

        /* synthetic */ c(byte[] bArr, long j, int i, AnonymousClass1 anonymousClass1) {
            this(bArr, j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public native int a();

        /* JADX INFO: Access modifiers changed from: private */
        public native ByteBuffer b();
    }

    static {
        NativeLoader.classesInit0(117);
    }

    private native int a(long j, boolean z);

    private native long a(long j);

    private native void a(MediaFormat mediaFormat);

    private native void a(ByteBuffer byteBuffer, int i, long j, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void a(byte[] bArr, int i, float f, int i2);

    private native boolean a(byte[] bArr, int i, long j, int i2);

    private native File b(Context context);

    /* JADX INFO: Access modifiers changed from: private */
    public native void b(String str);

    private native void b(ByteBuffer byteBuffer, int i, long j, int i2);

    private native int c(String str);

    private native void c(int i);

    private native boolean c(ByteBuffer byteBuffer, int i, long j, int i2);

    private native int d(String str);

    protected static native String d();

    private native void d(ByteBuffer byteBuffer, int i, long j, int i2);

    protected static native String e();

    private static final native String p();

    private native void q();

    private native void r();

    private native void s();

    private native long t();

    private native void u();

    private native void v();

    private native void w();

    /* JADX INFO: Access modifiers changed from: private */
    public native void x();

    private native String y();

    protected native int a(int i);

    protected abstract br.com.rory.electro.c.a.c.f a(br.com.rory.electro.c.a.c.f fVar);

    protected native File a(Context context, int i);

    protected abstract String a();

    protected native String a(Context context, int i, int i2);

    protected native String a(Context context, int i, int i2, int i3);

    protected native String a(Context context, String str);

    public native void a(Context context);

    protected native void a(String str);

    protected native int b(int i);

    protected native String b(Context context, int i, int i2);

    protected abstract boolean b();

    protected native float c();

    protected native int f();

    protected native synchronized boolean g();

    public native synchronized void h();

    protected native boolean i();

    protected native File j();

    protected abstract String k();

    protected abstract int l();

    protected abstract int m();

    protected native String n();

    protected native void o();
}
