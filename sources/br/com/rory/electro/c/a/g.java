package br.com.rory.electro.c.a;

import com.rory.electro.NativeLoader;
import java.util.function.ToIntFunction;

/* loaded from: classes.dex */
final /* synthetic */ class g implements ToIntFunction {
    static final ToIntFunction a;

    static {
        NativeLoader.classesInit0(193);
        a = new g();
    }

    private g() {
    }

    @Override // java.util.function.ToIntFunction
    public native int applyAsInt(Object obj);
}
