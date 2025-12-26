package br.com.rory.electro.b.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import okhttp3.MediaType;
import okhttp3.Request;

/* loaded from: classes.dex */
public class a {

    /* renamed from: br.com.rory.electro.b.a.a$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(92);
        }

        AnonymousClass1(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(148);
    }

    public static native String a(Context context);

    public static native String a(Context context, int i);

    public static native String a(Context context, br.com.rory.electro.b.a.a.a aVar);

    public static native String a(Context context, String str);

    public static native String a(Context context, boolean z);

    public static native String b(Context context);

    public static native String b(Context context, int i);

    private static native String b(Context context, br.com.rory.electro.b.a.a.a aVar);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String b(Context context, Request request);

    /* JADX INFO: Access modifiers changed from: private */
    public static native MediaType b();

    public static native String c(Context context);

    public static native String d(Context context);

    public static native String e(Context context);

    public static native void f(Context context);

    public static native String g(Context context);

    public static native String h(Context context);

    public static native Integer i(Context context);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String k(Context context);
}
