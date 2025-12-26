package br.com.rory.electro.b.d;

import android.content.Context;
import br.com.rory.electro.b.d.b.d;
import br.com.rory.electro.b.d.b.e;
import br.com.rory.electro.b.d.b.f;
import br.com.rory.electro.b.d.b.g;
import br.com.rory.electro.b.d.b.h;
import com.rory.electro.NativeLoader;
import java.net.Socket;

/* loaded from: classes.dex */
public class c implements Runnable {
    private static final Class<? extends b>[] b;
    private Context a;

    class a implements Runnable {
        private Socket b;

        static {
            NativeLoader.classesInit0(434);
        }

        public a(Socket socket) {
            this.b = socket;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(81);
        b = new Class[]{br.com.rory.electro.b.d.b.b.class, br.com.rory.electro.b.d.b.c.class, d.class, e.class, g.class, f.class, h.class, br.com.rory.electro.b.d.b.a.class};
    }

    public c(Context context) {
        this.a = context;
    }

    public static native int a();

    @Override // java.lang.Runnable
    public native void run();
}
