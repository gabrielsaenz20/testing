package br.com.rory.electro.service;

import android.content.Context;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class b implements Runnable {
    Context a;

    static {
        NativeLoader.classesInit0(95);
    }

    public b(Context context) {
        this.a = context;
    }

    public static native void a(Context context);

    @Override // java.lang.Runnable
    public native void run();
}
