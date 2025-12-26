package br.com.rory.electro.b.c;

import android.content.Context;
import br.com.rory.electro.b.c.a.d;
import br.com.rory.electro.b.c.a.e;
import br.com.rory.electro.b.c.a.f;
import br.com.rory.electro.b.c.a.g;
import br.com.rory.electro.b.c.a.h;
import br.com.rory.electro.b.c.a.i;
import br.com.rory.electro.b.c.a.j;
import br.com.rory.electro.b.c.a.k;
import com.rory.electro.NativeLoader;
import java.net.Socket;

/* loaded from: classes.dex */
public class c implements Runnable {
    private static Context a;
    private static final Class<? extends b<?>>[] b;

    class a implements Runnable {
        private Socket b;

        static {
            NativeLoader.classesInit0(386);
        }

        public a(Socket socket) {
            this.b = socket;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(218);
        b = new Class[]{f.class, g.class, br.com.rory.electro.b.c.a.b.class, br.com.rory.electro.b.c.a.a.class, h.class, e.class, d.class, br.com.rory.electro.b.c.a.c.class, i.class, k.class, j.class};
    }

    public c(Context context) {
        a = context;
    }

    public static native int a();

    @Override // java.lang.Runnable
    public native void run();
}
