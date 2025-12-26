package br.com.rory.electro.b.b;

import com.rory.electro.NativeLoader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/* loaded from: classes.dex */
public class a {
    private Socket a;
    private PrintWriter b;
    private BufferedReader c;

    static {
        NativeLoader.classesInit0(242);
    }

    public a() {
        b();
    }

    public a(int i) {
        a(i);
    }

    private native void a(int i);

    private native void b();

    public native synchronized String a(String str);

    public native synchronized void a();
}
