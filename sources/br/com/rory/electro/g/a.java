package br.com.rory.electro.g;

import android.content.Context;
import android.os.AsyncTask;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class a {
    private static final int a;

    /* renamed from: br.com.rory.electro.g.a$1, reason: invalid class name */
    static class AnonymousClass1 extends AsyncTask<Void, Void, String> {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ Context e;

        static {
            NativeLoader.classesInit0(181);
        }

        AnonymousClass1(String str, int i, String str2, String str3, Context context) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public native String doInBackground(Void... voidArr);

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public native void onPostExecute(String str);
    }

    static {
        NativeLoader.classesInit0(292);
        a = br.com.rory.electro.a.a.a.a();
    }

    private static native int a(String str);

    public static native void a(Context context, String str);

    public static native void a(Context context, String str, String str2, String str3, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int b(br.com.rory.electro.g.a.a aVar, long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int b(br.com.rory.electro.g.a.a aVar, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long c(br.com.rory.electro.g.a.a aVar, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void d(br.com.rory.electro.g.a.a aVar, int i);

    private static native String h();

    private static native String i();

    /* JADX INFO: Access modifiers changed from: private */
    public static native String j();

    /* JADX INFO: Access modifiers changed from: private */
    public static native String k();

    /* JADX INFO: Access modifiers changed from: private */
    public static native String l();

    /* JADX INFO: Access modifiers changed from: private */
    public static native String m();

    /* JADX INFO: Access modifiers changed from: private */
    public static native String n();

    /* JADX INFO: Access modifiers changed from: private */
    public static native String o();

    private static native String p();

    private static native String q();

    private static native String r();

    private static native String s();

    private static native String t();

    private static native String u();

    private static native String v();

    /* JADX INFO: Access modifiers changed from: private */
    public static native String w();
}
