package br.com.rory.electro;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.InputDeviceCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import br.com.rory.electro.d.a.a.a;
import br.com.rory.electro.d.a.a.b;
import br.com.rory.electro.f.e;
import com.rory.electro.NativeLoader;
import java.util.List;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class MainActivity extends a {
    br.com.rory.electro.d.a.a.a a;
    List<b> b;
    TextView c;
    ProgressBar d;
    RecyclerView e;
    LinearLayout f;
    LinearLayout g;
    TextView h;

    /* renamed from: br.com.rory.electro.MainActivity$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Button a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ TextView c;
        final /* synthetic */ ProgressBar d;

        /* renamed from: br.com.rory.electro.MainActivity$1$1, reason: invalid class name and collision with other inner class name */
        class RunnableC00021 implements Runnable {
            static {
                NativeLoader.classesInit0(280);
            }

            RunnableC00021() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        /* renamed from: br.com.rory.electro.MainActivity$1$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ Bitmap a;
            final /* synthetic */ String b;

            static {
                NativeLoader.classesInit0(282);
            }

            AnonymousClass2(Bitmap bitmap, String str) {
                this.a = bitmap;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        /* renamed from: br.com.rory.electro.MainActivity$1$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            static {
                NativeLoader.classesInit0(283);
            }

            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        /* renamed from: br.com.rory.electro.MainActivity$1$4, reason: invalid class name */
        class AnonymousClass4 implements Runnable {
            static {
                NativeLoader.classesInit0(284);
            }

            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(256);
        }

        AnonymousClass1(Button button, ImageView imageView, TextView textView, ProgressBar progressBar) {
            this.a = button;
            this.b = imageView;
            this.c = textView;
            this.d = progressBar;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.MainActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ Runnable a;

        static {
            NativeLoader.classesInit0(InputDeviceCompat.SOURCE_KEYBOARD);
        }

        AnonymousClass2(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* renamed from: br.com.rory.electro.MainActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        static {
            NativeLoader.classesInit0(272);
        }

        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* renamed from: br.com.rory.electro.MainActivity$4, reason: invalid class name */
    class AnonymousClass4 implements a.InterfaceC0013a {

        /* renamed from: br.com.rory.electro.MainActivity$4$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ int a;

            /* renamed from: br.com.rory.electro.MainActivity$4$1$1, reason: invalid class name and collision with other inner class name */
            class RunnableC00031 implements Runnable {
                static {
                    NativeLoader.classesInit0(android.support.design.R.styleable.AppCompatTheme_windowFixedWidthMinor);
                }

                RunnableC00031() {
                }

                @Override // java.lang.Runnable
                public native void run();
            }

            static {
                NativeLoader.classesInit0(366);
            }

            AnonymousClass1(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(273);
        }

        AnonymousClass4() {
        }

        @Override // br.com.rory.electro.d.a.a.a.InterfaceC0013a
        public native void a(int i);
    }

    /* renamed from: br.com.rory.electro.MainActivity$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ MainActivity a;

        /* renamed from: br.com.rory.electro.MainActivity$5$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            static {
                NativeLoader.classesInit0(387);
            }

            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(267);
        }

        AnonymousClass5(MainActivity mainActivity) {
            this.a = mainActivity;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.MainActivity$6, reason: invalid class name */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ boolean a;

        static {
            NativeLoader.classesInit0(269);
        }

        AnonymousClass6(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.MainActivity$7, reason: invalid class name */
    class AnonymousClass7 implements Runnable {

        /* renamed from: br.com.rory.electro.MainActivity$7$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            static {
                NativeLoader.classesInit0(431);
            }

            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        /* renamed from: br.com.rory.electro.MainActivity$7$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            static {
                NativeLoader.classesInit0(432);
            }

            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(262);
        }

        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(428);
    }

    private native void a();

    public static native void a(Activity activity);

    /* JADX INFO: Access modifiers changed from: private */
    public native void a(boolean z);

    private native void b();

    private native void c();

    private native void d();

    /* JADX INFO: Access modifiers changed from: private */
    public native void e();

    private native void f();

    private native void g();

    @m
    public native void onCheckIfInitializing(br.com.rory.electro.f.a aVar);

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected native void onDestroy();

    @m
    public native void onRefreshUserListEvent(e eVar);

    @Override // br.com.rory.electro.a, android.support.v4.app.FragmentActivity, android.app.Activity
    protected native void onResume();
}
