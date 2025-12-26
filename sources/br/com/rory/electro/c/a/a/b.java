package br.com.rory.electro.c.a.a;

import com.rory.electro.NativeLoader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class b extends a {
    private static b i;
    private List<Timer> j;

    /* renamed from: br.com.rory.electro.c.a.a.b$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        static {
            NativeLoader.classesInit0(390);
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.b$10, reason: invalid class name */
    class AnonymousClass10 extends TimerTask {
        final /* synthetic */ String[] a;
        final /* synthetic */ br.com.rory.electro.c.a.c.d b;

        static {
            NativeLoader.classesInit0(29);
        }

        AnonymousClass10(String[] strArr, br.com.rory.electro.c.a.c.d dVar) {
            this.a = strArr;
            this.b = dVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.b$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        static {
            NativeLoader.classesInit0(391);
        }

        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.b$3, reason: invalid class name */
    class AnonymousClass3 implements Comparator<File> {
        static {
            NativeLoader.classesInit0(392);
        }

        AnonymousClass3() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public native int compare(File file, File file2);
    }

    /* renamed from: br.com.rory.electro.c.a.a.b$4, reason: invalid class name */
    class AnonymousClass4 extends TimerTask {
        final /* synthetic */ SimpleDateFormat a;
        final /* synthetic */ br.com.rory.electro.c.a.c.d b;

        static {
            NativeLoader.classesInit0(393);
        }

        AnonymousClass4(SimpleDateFormat simpleDateFormat, br.com.rory.electro.c.a.c.d dVar) {
            this.a = simpleDateFormat;
            this.b = dVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.b$5, reason: invalid class name */
    class AnonymousClass5 extends TimerTask {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String[] c;
        final /* synthetic */ br.com.rory.electro.c.a.c.d d;
        final /* synthetic */ int e;

        static {
            NativeLoader.classesInit0(394);
        }

        AnonymousClass5(String str, String str2, String[] strArr, br.com.rory.electro.c.a.c.d dVar, int i) {
            this.a = str;
            this.b = str2;
            this.c = strArr;
            this.d = dVar;
            this.e = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.b$6, reason: invalid class name */
    class AnonymousClass6 extends TimerTask {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String[] f;
        final /* synthetic */ br.com.rory.electro.c.a.c.d g;
        final /* synthetic */ int h;

        static {
            NativeLoader.classesInit0(395);
        }

        AnonymousClass6(boolean[] zArr, String str, String str2, String str3, String str4, String[] strArr, br.com.rory.electro.c.a.c.d dVar, int i) {
            this.a = zArr;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = strArr;
            this.g = dVar;
            this.h = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.b$7, reason: invalid class name */
    class AnonymousClass7 extends TimerTask {
        final /* synthetic */ Map a;
        final /* synthetic */ String[] b;
        final /* synthetic */ br.com.rory.electro.c.a.c.d c;
        final /* synthetic */ int d;

        static {
            NativeLoader.classesInit0(396);
        }

        AnonymousClass7(Map map, String[] strArr, br.com.rory.electro.c.a.c.d dVar, int i) {
            this.a = map;
            this.b = strArr;
            this.c = dVar;
            this.d = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.b$8, reason: invalid class name */
    class AnonymousClass8 extends TimerTask {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String[] e;
        final /* synthetic */ br.com.rory.electro.c.a.c.d f;
        final /* synthetic */ int g;

        static {
            NativeLoader.classesInit0(397);
        }

        AnonymousClass8(String str, String str2, String str3, String str4, String[] strArr, br.com.rory.electro.c.a.c.d dVar, int i) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = strArr;
            this.f = dVar;
            this.g = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.a.a.b$9, reason: invalid class name */
    class AnonymousClass9 extends TimerTask {
        final /* synthetic */ String[] a;
        final /* synthetic */ br.com.rory.electro.c.a.c.d b;

        static {
            NativeLoader.classesInit0(398);
        }

        AnonymousClass9(String[] strArr, br.com.rory.electro.c.a.c.d dVar) {
            this.a = strArr;
            this.b = dVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(120);
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native String a(int i2, boolean[] zArr, String str, String str2, String str3, String str4);

    private native List<File> a(File file);

    private native void a(br.com.rory.electro.c.a.c.f fVar, String str);

    private native void a(File file, List<File> list);

    private native void b(br.com.rory.electro.c.a.c.f fVar);

    private native void b(br.com.rory.electro.c.a.c.f fVar, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void b(String str);

    private native boolean b(File file);

    private native String c(int i2);

    private native void c(br.com.rory.electro.c.a.c.f fVar);

    private native void c(br.com.rory.electro.c.a.c.f fVar, String str);

    private native void d(br.com.rory.electro.c.a.c.f fVar);

    private native void e(br.com.rory.electro.c.a.c.f fVar);

    private native void f(br.com.rory.electro.c.a.c.f fVar);

    private native void g(br.com.rory.electro.c.a.c.f fVar);

    public static native synchronized b p();

    public static native void q();

    @Override // br.com.rory.electro.c.a.a.a
    protected native br.com.rory.electro.c.a.c.f a(br.com.rory.electro.c.a.c.f fVar);

    @Override // br.com.rory.electro.c.a.a.a
    protected native String a();

    public native void a(Date date);

    @Override // br.com.rory.electro.c.a.a.a
    protected native boolean b();

    @Override // br.com.rory.electro.c.a.a.a
    protected native float c();

    @Override // br.com.rory.electro.c.a.a.a
    protected native synchronized boolean g();

    @Override // br.com.rory.electro.c.a.a.a
    protected native boolean i();

    @Override // br.com.rory.electro.c.a.a.a
    protected native String k();

    @Override // br.com.rory.electro.c.a.a.a
    protected native int l();

    @Override // br.com.rory.electro.c.a.a.a
    protected native int m();

    @Override // br.com.rory.electro.c.a.a.a
    protected native void o();

    public native boolean r();
}
