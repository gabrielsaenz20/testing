package br.com.rory.electro.b.c.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class b implements br.com.rory.electro.b.c.b<String> {
    private static final String a = "b";
    private static boolean b = false;
    private static int c = 1;

    static {
        NativeLoader.classesInit0(243);
    }

    @Override // br.com.rory.electro.b.c.b
    public native String a();

    @Override // br.com.rory.electro.b.c.b
    public native void a(Context context, PrintWriter printWriter, String str);
}
