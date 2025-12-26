package br.com.rory.electro.service;

import com.rory.electro.NativeLoader;
import java.net.Socket;

/* loaded from: classes.dex */
public class Loader {
    private static boolean a = true;

    /* renamed from: br.com.rory.electro.service.Loader$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        static {
            NativeLoader.classesInit0(342);
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    private static class a implements Runnable {
        private Socket a;

        static {
            NativeLoader.classesInit0(370);
        }

        public a(Socket socket) {
            this.a = socket;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(367);
    }

    public static native int a();

    public static native void main(String[] strArr);
}
