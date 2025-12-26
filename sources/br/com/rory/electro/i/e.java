package br.com.rory.electro.i;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public class e {
    private final ExecutorService a = Executors.newSingleThreadExecutor();
    private final ExecutorService b = Executors.newCachedThreadPool();
    private final Map<String, Consumer<String>> c = new ConcurrentHashMap();
    private Process d;
    private Context e;

    /* renamed from: br.com.rory.electro.i.e$1, reason: invalid class name */
    class AnonymousClass1 implements Consumer<String> {
        static {
            NativeLoader.classesInit0(401);
        }

        AnonymousClass1() {
        }

        @Override // java.util.function.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public native void accept(String str);
    }

    /* renamed from: br.com.rory.electro.i.e$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        static {
            NativeLoader.classesInit0(399);
        }

        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.i.e$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Consumer a;
        final /* synthetic */ String b;

        static {
            NativeLoader.classesInit0(400);
        }

        AnonymousClass3(Consumer consumer, String str) {
            this.a = consumer;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(443);
    }

    public e(Context context) {
        this.e = context;
        a();
    }

    static final /* synthetic */ String a(String str) {
        return "-e \"" + str.replace("\"", "\\\"") + "\"";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public native void b();

    private static native String d();

    private static native String e();

    public native void a();

    public native void a(String str, Consumer<String> consumer);
}
