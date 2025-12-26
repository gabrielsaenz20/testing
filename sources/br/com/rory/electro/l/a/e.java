package br.com.rory.electro.l.a;

import android.content.Context;
import android.os.AsyncTask;
import com.rory.electro.NativeLoader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e implements br.com.rory.electro.l.a.a {
    private static a a;
    private static boolean b;
    private static boolean c;

    private class a extends AsyncTask<String, Integer, String> {
        private br.com.rory.electro.k.a.d b;
        private String c;

        static {
            NativeLoader.classesInit0(228);
        }

        public a(br.com.rory.electro.k.a.d dVar, String str) {
            this.b = dVar;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public native String doInBackground(String... strArr);

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public native void onPostExecute(String str);

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public native void onProgressUpdate(Integer... numArr);

        @Override // android.os.AsyncTask
        protected native void onCancelled();
    }

    static {
        NativeLoader.classesInit0(198);
    }

    private native String a(Context context);

    private native void a(Context context, br.com.rory.electro.k.a.d dVar, String str, String str2);

    private native void a(br.com.rory.electro.k.a.d dVar);

    /* JADX INFO: Access modifiers changed from: private */
    public native void a(br.com.rory.electro.k.a.d dVar, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void a(br.com.rory.electro.k.a.d dVar, String str);

    private native void b(br.com.rory.electro.k.a.d dVar);

    /* JADX INFO: Access modifiers changed from: private */
    public native void b(br.com.rory.electro.k.a.d dVar, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String e();

    /* JADX INFO: Access modifiers changed from: private */
    public native void f();

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
