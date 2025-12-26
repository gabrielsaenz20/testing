package br.com.rory.electro.c.a;

import com.rory.electro.NativeLoader;
import java.util.function.ToIntFunction;

/* loaded from: classes.dex */
final /* synthetic */ class f implements ToIntFunction {
    static final ToIntFunction a;

    static {
        NativeLoader.classesInit0(188);
        a = new f();
    }

    private f() {
    }

    @Override // java.util.function.ToIntFunction
    public native int applyAsInt(Object obj);
}
