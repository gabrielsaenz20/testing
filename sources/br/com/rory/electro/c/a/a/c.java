package br.com.rory.electro.c.a.a;

import android.content.Context;
import br.com.rory.electro.c.a.d;
import com.rory.electro.NativeLoader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public class c implements d.a {
    private Context a;
    private br.com.rory.electro.c.a.d b;
    private d c;
    private ExecutorService d;
    private String g;
    private int e = 1;
    private boolean f = false;
    private final Object h = new Object();

    /* renamed from: br.com.rory.electro.c.a.a.c$1, reason: invalid class name */
    class AnonymousClass1 implements ThreadFactory {
        static {
            NativeLoader.classesInit0(84);
        }

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public native Thread newThread(Runnable runnable);
    }

    /* renamed from: br.com.rory.electro.c.a.a.c$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ byte[] a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ long e;

        static {
            NativeLoader.classesInit0(85);
        }

        AnonymousClass2(byte[] bArr, int i, int i2, int i3, long j) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = j;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(115);
    }

    public c(Context context, String str) {
        this.a = context;
        this.g = str == null ? "default" : str;
        this.b = br.com.rory.electro.c.a.d.a(context);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void a(byte[] bArr, int i, int i2, int i3, long j);

    private native void g();

    @Override // br.com.rory.electro.c.a.d.a
    public native String a();

    public native void a(int i);

    public native void a(d dVar);

    @Override // br.com.rory.electro.c.a.d.a
    public native void a(byte[] bArr, int i, int i2, int i3, int i4, long j);

    @Override // br.com.rory.electro.c.a.d.a
    public native int b();

    @Override // br.com.rory.electro.c.a.d.a
    public native int c();

    public native void d();

    public native void e();

    public native void f();
}
