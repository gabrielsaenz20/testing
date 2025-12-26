package br.com.rory.electro.a;

import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class b implements Runnable {
    private boolean a = true;

    static {
        NativeLoader.classesInit0(213);
    }

    @Override // java.lang.Runnable
    public native void run();
}
