package br.com.rory.electro.c.a;

import android.media.MediaCodec;
import br.com.rory.electro.c.a.j;
import com.rory.electro.NativeLoader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class i {
    private Method A;
    private Class<?> B;
    private Object a;
    private j.a b;
    private Method c;
    private Method d;
    private Method e;
    private Method f;
    private Method g;
    private Method h;
    private Method i;
    private Method j;
    private Method k;
    private Method l;
    private Method m;
    private Method n;
    private Method o;
    private Method p;
    private Method q;
    private Method r;
    private Method s;
    private Method t;
    private Method u;
    private Method v;
    private Method w;
    private Method x;
    private Method y;
    private Method z;

    /* renamed from: br.com.rory.electro.c.a.i$1, reason: invalid class name */
    class AnonymousClass1 implements InvocationHandler {
        final /* synthetic */ b a;

        static {
            NativeLoader.classesInit0(404);
        }

        AnonymousClass1(b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public native Object invoke(Object obj, Method method, Object[] objArr);
    }

    static {
        NativeLoader.classesInit0(191);
    }

    public i(Object obj, j.a aVar) {
        a(obj, aVar);
    }

    private native void a(Object obj, j.a aVar);

    private static native String d();

    public native void a();

    public native void a(b bVar);

    public native boolean a(int i);

    public native boolean a(int i, int i2);

    public native boolean a(MediaCodec mediaCodec, int i);

    public native boolean a(MediaCodec mediaCodec, int... iArr);

    public native boolean a(int... iArr);

    public native boolean b();

    public native boolean b(int... iArr);

    public native boolean c();
}
