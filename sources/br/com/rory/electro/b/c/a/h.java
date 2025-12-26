package br.com.rory.electro.b.c.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class h implements br.com.rory.electro.b.c.b<String> {

    /* renamed from: br.com.rory.electro.b.c.a.h$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String a;

        static {
            NativeLoader.classesInit0(350);
        }

        AnonymousClass1(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(139);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native String b();

    @Override // br.com.rory.electro.b.c.b
    public native String a();

    public native String a(br.com.rory.electro.b.c.a aVar, String str, Throwable th);

    @Override // br.com.rory.electro.b.c.b
    public native void a(Context context, PrintWriter printWriter, String str);
}
