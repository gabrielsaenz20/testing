package br.com.rory.electro.c.a.a;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.TransportMediator;
import com.rory.electro.NativeLoader;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class f {
    private Context a;
    private g b;
    private ExecutorService c;
    private Handler d;
    private String g;
    private String h;
    private MediaExtractor i;
    private MediaCodec j;
    private MediaFormat k;
    private MediaExtractor m;
    private MediaCodec n;
    private MediaFormat o;
    private ExecutorService q;
    private AtomicBoolean e = new AtomicBoolean(false);
    private AtomicBoolean f = new AtomicBoolean(false);
    private int l = -1;
    private int p = -1;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private int u = 0;
    private int v = 0;
    private long w = 0;
    private int x = 0;
    private int y = 0;
    private int z = 30;
    private long A = 0;
    private int B = -1;
    private boolean C = false;
    private boolean D = false;
    private long E = 0;
    private long F = 0;
    private long G = 0;

    /* renamed from: br.com.rory.electro.c.a.a.f$1, reason: invalid class name */
    class AnonymousClass1 implements ThreadFactory {
        static {
            NativeLoader.classesInit0(52);
        }

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public native Thread newThread(Runnable runnable);
    }

    /* renamed from: br.com.rory.electro.c.a.a.f$2, reason: invalid class name */
    class AnonymousClass2 implements ThreadFactory {
        static {
            NativeLoader.classesInit0(54);
        }

        AnonymousClass2() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public native Thread newThread(Runnable runnable);
    }

    /* renamed from: br.com.rory.electro.c.a.a.f$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        static {
            NativeLoader.classesInit0(56);
        }

        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.f$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        static {
            NativeLoader.classesInit0(57);
        }

        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(TransportMediator.KEYCODE_MEDIA_PAUSE);
    }

    public f(Context context, String str) {
        this.a = context;
        this.h = str == null ? "default" : str;
        this.d = new Handler(Looper.getMainLooper());
        c();
    }

    private native String a(int i);

    private native void a(int i, int i2);

    private native void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, long j);

    private native void a(boolean z);

    private native void a(byte[] bArr, long j);

    private native byte[] a(byte[] bArr, int i, int i2);

    private native byte[] a(byte[] bArr, int i, int i2, int i3, int i4);

    private native void c();

    private native void d();

    private native boolean e();

    private native boolean f();

    private native boolean g();

    private native void h();

    private native void i();

    /* JADX INFO: Access modifiers changed from: private */
    public native void j();

    /* JADX INFO: Access modifiers changed from: private */
    public native void k();

    private native void l();

    private native void m();

    public native void a();

    public native void a(g gVar);

    public native boolean a(String str);

    public native void b();
}
