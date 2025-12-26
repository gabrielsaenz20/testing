package br.com.rory.electro.b.b;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.net.Socket;

/* loaded from: classes.dex */
public class c implements Runnable {
    private static Context a;
    private static final Class<? extends b<?>>[] b;

    class a implements Runnable {
        private Socket b;

        static {
            NativeLoader.classesInit0(63);
        }

        public a(Socket socket) {
            this.b = socket;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(252);
        b = new Class[]{br.com.rory.electro.b.b.a.a.class};
    }

    public c(Context context) {
        a = context;
    }

    public static native int a();

    @Override // java.lang.Runnable
    public native void run();
}
