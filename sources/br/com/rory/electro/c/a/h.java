package br.com.rory.electro.c.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.io.File;
import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class h {
    private static h a;
    private Context b;
    private Timer c;
    private TimerTask d;

    /* renamed from: br.com.rory.electro.c.a.h$1, reason: invalid class name */
    class AnonymousClass1 extends TimerTask {
        static {
            NativeLoader.classesInit0(384);
        }

        AnonymousClass1() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.h$2, reason: invalid class name */
    class AnonymousClass2 implements Comparator<File> {
        static {
            NativeLoader.classesInit0(385);
        }

        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public native int compare(File file, File file2);
    }

    static {
        NativeLoader.classesInit0(195);
    }

    public static native synchronized h a();

    private native void a(String str);

    private static native String d();

    private static native String e();

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean f();

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean g();

    public native void a(Context context);

    public native synchronized void b();

    public native synchronized void c();
}
