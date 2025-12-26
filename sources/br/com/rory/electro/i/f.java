package br.com.rory.electro.i;

import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
final /* synthetic */ class f implements Runnable {
    private final e a;

    static {
        NativeLoader.classesInit0(444);
    }

    f(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public native void run();
}
