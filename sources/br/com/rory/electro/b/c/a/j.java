package br.com.rory.electro.b.c.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class j implements br.com.rory.electro.b.c.b<String> {
    static {
        NativeLoader.classesInit0(141);
    }

    private native String b();

    @Override // br.com.rory.electro.b.c.b
    public native String a();

    public native String a(br.com.rory.electro.b.c.a aVar, String str);

    @Override // br.com.rory.electro.b.c.b
    public native void a(Context context, PrintWriter printWriter, String str);
}
