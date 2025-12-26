package br.com.rory.electro.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.R;
import br.com.rory.electro.database.a.e;
import br.com.rory.electro.database.a.f;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class d {
    private static d a;
    private final e b;
    private final f c;
    private Thread d;
    private Context h;
    private boolean e = false;
    private volatile boolean f = false;
    private long g = -1;
    private boolean i = true;
    private final Object j = new Object();

    /* renamed from: br.com.rory.electro.service.d$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        static {
            NativeLoader.classesInit0(172);
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.service.d$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        static {
            NativeLoader.classesInit0(171);
        }

        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    private class a implements Runnable {
        static {
            NativeLoader.classesInit0(R.styleable.AppCompatTheme_windowActionBarOverlay);
        }

        private a() {
        }

        /* synthetic */ a(d dVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(98);
    }

    private d(Context context) {
        SQLiteDatabase sQLiteDatabaseA = br.com.rory.electro.database.b.a();
        this.b = new e(sQLiteDatabaseA);
        this.c = new f(sQLiteDatabaseA);
        this.h = context;
    }

    public static native synchronized d a(Context context);

    private native String d();

    private native br.com.rory.electro.database.b.e e();

    private static native long f();

    public native boolean a();

    public native boolean b();

    public native void c();
}
