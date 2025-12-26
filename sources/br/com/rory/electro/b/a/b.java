package br.com.rory.electro.b.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: classes.dex */
public class b implements Interceptor {
    private Context a;

    static {
        NativeLoader.classesInit0(149);
    }

    public b(Context context) {
        this.a = context;
    }

    @Override // okhttp3.Interceptor
    public native Response intercept(Interceptor.Chain chain);
}
