package br.com.rory.electro.c.a.a.b;

import android.content.Context;
import android.support.design.R;
import br.com.rory.electro.c.a.d;
import com.rory.electro.NativeLoader;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class a implements d.a {
    private Context b;
    private int c;
    private Timer g;
    private d.a h;
    private b i;
    private File k;
    private EnumC0011a a = EnumC0011a.IDLE;
    private AtomicInteger d = new AtomicInteger(0);
    private AtomicBoolean e = new AtomicBoolean(false);
    private AtomicInteger j = new AtomicInteger(0);
    private ExecutorService f = Executors.newSingleThreadExecutor();

    /* renamed from: br.com.rory.electro.c.a.a.b.a$1, reason: invalid class name */
    class AnonymousClass1 extends TimerTask {
        static {
            NativeLoader.classesInit0(R.styleable.AppCompatTheme_windowMinWidthMinor);
        }

        AnonymousClass1() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.b.a$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ byte[] a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ long f;
        final /* synthetic */ int g;

        static {
            NativeLoader.classesInit0(R.styleable.AppCompatTheme_windowMinWidthMajor);
        }

        AnonymousClass2(byte[] bArr, int i, int i2, int i3, int i4, long j, int i5) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = j;
            this.g = i5;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.b.a$a, reason: collision with other inner class name */
    public enum EnumC0011a {
        IDLE,
        RECORDING,
        REPLAYING;

        static {
            NativeLoader.classesInit0(39);
        }

        public static native EnumC0011a valueOf(String str);

        public static native EnumC0011a[] values();
    }

    public static class b {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public long g;
        public long h;
        public String i;

        public b() {
            this.i = "1.0";
        }

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.i = "1.0";
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = System.currentTimeMillis();
        }
    }

    static {
        NativeLoader.classesInit0(354);
    }

    public a(Context context) {
        this.c = 1;
        this.b = context;
        this.c = l();
    }

    private native b a(File file);

    private native void a(File file, b bVar);

    /* JADX INFO: Access modifiers changed from: private */
    public native void a(byte[] bArr, int i, int i2, int i3, int i4, long j, int i5);

    private native boolean a(long j);

    private static native String f();

    private static native String g();

    private static native String h();

    private static native String i();

    private native void j();

    /* JADX INFO: Access modifiers changed from: private */
    public native void k();

    private native int l();

    @Override // br.com.rory.electro.c.a.d.a
    public native String a();

    @Override // br.com.rory.electro.c.a.d.a
    public native void a(byte[] bArr, int i, int i2, int i3, int i4, long j);

    public native boolean a(int i, d.a aVar);

    @Override // br.com.rory.electro.c.a.d.a
    public native int b();

    @Override // br.com.rory.electro.c.a.d.a
    public native int c();

    public native void d();

    public native void e();
}
