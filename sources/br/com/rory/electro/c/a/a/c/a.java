package br.com.rory.electro.c.a.a.c;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.support.design.R;
import br.com.rory.electro.c.a.b.d;
import br.com.rory.electro.c.a.b.e;
import br.com.rory.electro.c.a.c.f;
import br.com.rory.electro.c.a.i;
import com.rory.electro.NativeLoader;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class a {
    private C0012a[] D;
    private MediaMuxer I;
    private String L;
    private long M;
    private final Context a;
    private final br.com.rory.electro.e.a b;
    private i d;
    private f e;
    private MediaCodec f;
    private MediaFormat h;
    private MediaCodec k;
    private MediaCodec l;
    private MediaFormat m;
    private d n;
    private e o;
    private ExecutorService u;
    private BlockingQueue<b> x;
    private ExecutorService y;
    private volatile boolean g = false;
    private volatile boolean i = false;
    private volatile boolean j = false;
    private long p = -1;
    private long q = -1;
    private long r = 0;
    private int s = -1;
    private int t = -1;
    private volatile boolean v = false;
    private final Object w = new Object();
    private volatile boolean z = false;
    private volatile boolean A = false;
    private volatile boolean B = false;
    private volatile c C = c.IDLE;
    private int E = 0;
    private int F = 0;
    private boolean G = false;
    private long H = 0;
    private boolean J = false;
    private int K = -1;
    private long N = -1;
    private long O = -1;
    private long P = 0;
    private long Q = 0;
    private long R = 0;
    private long S = 0;
    private long T = 0;
    private long U = 0;
    private long V = 0;
    private volatile int W = 0;
    private final boolean c = br.com.rory.electro.c.a.d.a();

    /* renamed from: br.com.rory.electro.c.a.a.c.a$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        static {
            NativeLoader.classesInit0(144);
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.c.a$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        static {
            NativeLoader.classesInit0(145);
        }

        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.c.a$a, reason: collision with other inner class name */
    private static class C0012a {
        ByteBuffer a;
        MediaCodec.BufferInfo b = new MediaCodec.BufferInfo();
        long c;
        boolean d;

        static {
            NativeLoader.classesInit0(108);
        }

        C0012a() {
        }

        native void a();

        native void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, long j);
    }

    private static class b {
        ByteBuffer a;
        MediaCodec.BufferInfo b = new MediaCodec.BufferInfo();
        long c;
        boolean d;

        static {
            NativeLoader.classesInit0(109);
        }

        b() {
        }

        native void a();

        native void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, long j, boolean z);
    }

    private enum c {
        IDLE,
        BUFFERING,
        RECORDING;

        static {
            NativeLoader.classesInit0(R.styleable.AppCompatTheme_windowFixedWidthMajor);
        }

        public static native c valueOf(String str);

        public static native c[] values();
    }

    static {
        NativeLoader.classesInit0(255);
    }

    public a(Context context) {
        this.a = context.getApplicationContext();
        this.b = br.com.rory.electro.e.a.a(this.a);
        m();
    }

    private native int a(int i);

    private native int a(MediaCodec.BufferInfo bufferInfo);

    private static native File a(Context context);

    private native String a(Context context, String str);

    private native void a(MediaFormat mediaFormat);

    private native void a(f fVar);

    private native void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, long j);

    private native void a(C0012a[] c0012aArr);

    private native int b(String str);

    private native boolean b(C0012a[] c0012aArr);

    private native int c(String str);

    private native String c(C0012a[] c0012aArr);

    private static native String j();

    private native int k();

    private native int l();

    private native void m();

    private native void n();

    private native C0012a[] o();

    private native void p();

    private native void q();

    private native void r();

    private native void s();

    /* JADX INFO: Access modifiers changed from: private */
    public native void t();

    /* JADX INFO: Access modifiers changed from: private */
    public native void u();

    private native float v();

    protected native void a(String str);

    public native synchronized boolean a();

    public native synchronized boolean a(int i, int i2);

    public native synchronized boolean b();

    public native boolean c();

    public native String d();

    public native String e();

    public native synchronized boolean f();

    public native String g();

    public native synchronized void h();

    public native synchronized void i();
}
