package br.com.rory.electro.i;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public class k {
    private static final ScheduledExecutorService a;

    static {
        NativeLoader.classesInit0(414);
        a = Executors.newScheduledThreadPool(1);
    }

    public static native long a(String str, int i);

    public static native void a(Context context, br.com.rory.electro.common.a<String> aVar);

    public static native void a(Context context, String str);
}
