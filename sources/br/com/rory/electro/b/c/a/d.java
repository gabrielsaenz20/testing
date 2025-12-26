package br.com.rory.electro.b.c.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class d implements br.com.rory.electro.b.c.b<String> {

    /* renamed from: br.com.rory.electro.b.c.a.d$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(447);
        }

        AnonymousClass1(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(245);
    }

    @Override // br.com.rory.electro.b.c.b
    public native String a();

    public native String a(br.com.rory.electro.b.c.a aVar);

    @Override // br.com.rory.electro.b.c.b
    public native void a(Context context, PrintWriter printWriter, String str);
}
