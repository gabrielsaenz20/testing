package br.com.rory.electro.g.b;

import br.com.rory.electro.g.b.b;
import com.rory.electro.NativeLoader;
import java.io.Closeable;

/* loaded from: classes.dex */
public class a implements Closeable {
    private br.com.rory.electro.g.a.a a;

    /* renamed from: br.com.rory.electro.g.b.a$1, reason: invalid class name */
    class AnonymousClass1 implements b.InterfaceC0016b {
        static {
            NativeLoader.classesInit0(47);
        }

        AnonymousClass1() {
        }

        @Override // br.com.rory.electro.g.b.b.InterfaceC0016b
        public native long a(String str);
    }

    /* renamed from: br.com.rory.electro.g.b.a$2, reason: invalid class name */
    class AnonymousClass2 implements b.InterfaceC0016b {
        static {
            NativeLoader.classesInit0(45);
        }

        AnonymousClass2() {
        }

        @Override // br.com.rory.electro.g.b.b.InterfaceC0016b
        public native long a(String str);
    }

    /* renamed from: br.com.rory.electro.g.b.a$a, reason: collision with other inner class name */
    public static class C0015a<T> {
        public final byte a;
        public final T b;

        public C0015a(byte b, T t) {
            this.a = b;
            this.b = t;
        }
    }

    static {
        NativeLoader.classesInit0(287);
    }

    public a(br.com.rory.electro.g.a.a aVar) {
        this.a = aVar;
        c();
    }

    private native void c();

    public native long a(long j, String str, String str2);

    public native long a(String str);

    public native C0015a<Object> a(long j, long j2, long j3, long j4, b.a... aVarArr);

    public native C0015a<Object> a(long j, long j2, long j3, b.a... aVarArr);

    public native C0015a<Object> a(long j, String str, String str2, String str3, long j2, b.a... aVarArr);

    public native C0015a<Object> a(String str, String str2, String str3, long j, b.a... aVarArr);

    public native String a(long j);

    public native String a(long j, long j2);

    public native void a();

    public native long b(String str);

    public native void b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public native void close();
}
