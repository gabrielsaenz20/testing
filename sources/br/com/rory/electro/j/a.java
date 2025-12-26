package br.com.rory.electro.j;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.security.KeyPair;
import java.security.PublicKey;

/* loaded from: classes.dex */
public class a {

    /* renamed from: br.com.rory.electro.j.a$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ KeyPair b;

        static {
            NativeLoader.classesInit0(147);
        }

        AnonymousClass1(Context context, KeyPair keyPair) {
            this.a = context;
            this.b = keyPair;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(405);
    }

    public static native String a();

    public static native String a(String str);

    public static native String a(PublicKey publicKey);

    public static native void a(Context context);

    public static native boolean b();

    public static native PublicKey c();
}
