package br.com.rory.electro.i;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.io.File;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;
        private boolean e;
        private boolean f;
        private long g;
        private long h;
        private String i;

        static {
            NativeLoader.classesInit0(103);
        }

        public a(String str, String str2, String str3, String str4, boolean z, boolean z2, long j, long j2, String str5) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = z;
            this.f = z2;
            this.g = j;
            this.h = j2;
            this.i = str5;
        }

        public native String a();

        public native String b();

        public native long c();

        public native long d();

        public native String e();

        public native String toString();
    }

    static {
        NativeLoader.classesInit0(445);
    }

    public static native File a(Context context);

    private static native File a(Context context, String str, String str2);

    private static native File a(Context context, String str, String str2, Date date);

    public static native File a(Context context, Date date);

    public static native File a(String str);

    private static native String a();

    private static native String a(Context context, String str, boolean z);

    private static native String a(Context context, String str, boolean z, boolean z2, String str2);

    public static native String a(File file);

    public static native String a(String str, File file);

    public static native void a(File file, List<File> list);

    public static native int b(File file);

    public static native int b(String str);

    public static native File b(Context context);

    public static native File b(Context context, Date date);

    private static native String b();

    private static native String c(String str);

    public static native List<File> c(Context context, Date date);

    public static native void c(Context context);

    public static native boolean c(File file);

    private static native long d(File file);

    public static native List<a> d(Context context);

    public static native List<File> d(Context context, Date date);
}
