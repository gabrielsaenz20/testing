package br.com.rory.electro.c.b;

import android.content.Context;
import android.hardware.bydauto.bodywork.AbsBYDAutoBodyworkListener;
import android.hardware.bydauto.charging.AbsBYDAutoChargingListener;
import android.hardware.bydauto.gearbox.AbsBYDAutoGearboxListener;
import android.hardware.bydauto.instrument.AbsBYDAutoInstrumentListener;
import com.rory.electro.NativeLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class b {
    private static Context a;
    private static final AtomicBoolean b;
    private static final AtomicInteger c;

    /* renamed from: br.com.rory.electro.c.b.b$1, reason: invalid class name */
    class AnonymousClass1 extends AbsBYDAutoGearboxListener {
        static {
            NativeLoader.classesInit0(258);
        }

        AnonymousClass1() {
        }

        public native void onGearboxAutoModeTypeChanged(int i);
    }

    /* renamed from: br.com.rory.electro.c.b.b$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        static {
            NativeLoader.classesInit0(259);
        }

        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.b.b$3, reason: invalid class name */
    class AnonymousClass3 extends AbsBYDAutoInstrumentListener {
        static {
            NativeLoader.classesInit0(260);
        }

        AnonymousClass3() {
        }

        public native void onSafetyBeltStatusChanged(int i, int i2);
    }

    /* renamed from: br.com.rory.electro.c.b.b$4, reason: invalid class name */
    class AnonymousClass4 extends AbsBYDAutoInstrumentListener {
        AnonymousClass4() {
        }
    }

    /* renamed from: br.com.rory.electro.c.b.b$5, reason: invalid class name */
    class AnonymousClass5 extends AbsBYDAutoBodyworkListener {

        /* renamed from: br.com.rory.electro.c.b.b$5$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ int b;

            static {
                NativeLoader.classesInit0(239);
            }

            AnonymousClass1(int i, int i2) {
                this.a = i;
                this.b = i2;
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(261);
        }

        AnonymousClass5() {
        }

        public native void onAutoSystemStateChanged(int i);

        public native void onDoorStateChanged(int i, int i2);

        public native void onPowerLevelChanged(int i);
    }

    /* renamed from: br.com.rory.electro.c.b.b$6, reason: invalid class name */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ int a;

        static {
            NativeLoader.classesInit0(263);
        }

        AnonymousClass6(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.b.b$7, reason: invalid class name */
    class AnonymousClass7 implements Runnable {
        static {
            NativeLoader.classesInit0(266);
        }

        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.b.b$8, reason: invalid class name */
    class AnonymousClass8 implements Runnable {
        static {
            NativeLoader.classesInit0(268);
        }

        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.c.b.b$9, reason: invalid class name */
    class AnonymousClass9 extends AbsBYDAutoChargingListener {
        static {
            NativeLoader.classesInit0(270);
        }

        AnonymousClass9() {
        }

        public native void onChargerStateChanged(int i);

        public native void onChargingPowerChanged(double d);
    }

    static {
        NativeLoader.classesInit0(53);
        b = new AtomicBoolean(false);
        c = new AtomicInteger(0);
    }

    public b(Context context) {
        b(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void a(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void a(int i, int i2);

    public static native void a(Context context);

    public static native boolean a();

    public static native int b();

    /* JADX INFO: Access modifiers changed from: private */
    public native void b(int i);

    private native void b(Context context);

    private native void e();

    /* JADX INFO: Access modifiers changed from: private */
    public native void f();

    private native void g();

    private native void h();

    private native void i();

    /* JADX INFO: Access modifiers changed from: private */
    public native void j();
}
