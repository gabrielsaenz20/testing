package br.com.rory.electro.b.c.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class g implements br.com.rory.electro.b.c.b<String> {
    private static String a;
    private static final Object b;

    static {
        NativeLoader.classesInit0(248);
        b = new Object();
    }

    public static native String b();

    @Override // br.com.rory.electro.b.c.b
    public native String a();

    public native String a(br.com.rory.electro.b.c.a aVar);

    @Override // br.com.rory.electro.b.c.b
    public native void a(Context context, PrintWriter printWriter, String str);
}
