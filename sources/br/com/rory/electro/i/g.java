package br.com.rory.electro.i;

import com.rory.electro.NativeLoader;
import java.util.function.Function;

/* loaded from: classes.dex */
final /* synthetic */ class g implements Function {
    static final Function a;

    static {
        NativeLoader.classesInit0(410);
        a = new g();
    }

    private g() {
    }

    @Override // java.util.function.Function
    public native Object apply(Object obj);
}
