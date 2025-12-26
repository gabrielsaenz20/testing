package br.com.rory.electro.i;

import android.app.Activity;
import android.content.Context;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class r {

    /* renamed from: br.com.rory.electro.i.r$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(90);
        }

        AnonymousClass1(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.i.r$2, reason: invalid class name */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ Exception a;

        static {
            NativeLoader.classesInit0(89);
        }

        AnonymousClass2(Exception exc) {
            this.a = exc;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.i.r$3, reason: invalid class name */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ Exception a;

        static {
            NativeLoader.classesInit0(88);
        }

        AnonymousClass3(Exception exc) {
            this.a = exc;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.i.r$4, reason: invalid class name */
    static class AnonymousClass4 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        static {
            NativeLoader.classesInit0(87);
        }

        AnonymousClass4(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.i.r$5, reason: invalid class name */
    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(86);
        }

        AnonymousClass5(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(418);
    }

    public static native int a(String[] strArr, String str);

    private static native String a();

    public static native String a(Context context);

    public static native void a(long j);

    public static native void a(Context context, Activity activity);

    public static native void a(Context context, Exception exc, String str);

    public static native void a(Context context, Integer num);

    public static native void a(Exception exc);

    public static native void a(Exception exc, String str);

    public static native void a(String str, String str2);

    public static native String b(Context context);

    public static native void b(Exception exc);

    public static native void b(String str, String str2);

    public static native String c(Context context);

    public static native void d(Context context);

    public static native void e(Context context);

    public static native void f(Context context);
}
