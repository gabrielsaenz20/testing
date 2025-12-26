package br.com.rory.electro.c.a;

import br.com.rory.electro.c.a.d;
import com.rory.electro.NativeLoader;
import java.util.function.Predicate;

/* loaded from: classes.dex */
final /* synthetic */ class e implements Predicate {
    private final d.a a;

    static {
        NativeLoader.classesInit0(187);
    }

    e(d.a aVar) {
        this.a = aVar;
    }

    @Override // java.util.function.Predicate
    public native boolean test(Object obj);
}
