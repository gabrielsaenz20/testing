package br.com.rory.electro.activity.update;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import br.com.rory.electro.f.c;
import com.rory.electro.NativeLoader;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class LicenseExpired extends AppCompatActivity {
    private TextView a;
    private Button b;
    private ProgressBar c;
    private Handler d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private Button h;
    private ProgressBar i;

    /* renamed from: br.com.rory.electro.activity.update.LicenseExpired$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: br.com.rory.electro.activity.update.LicenseExpired$1$1, reason: invalid class name and collision with other inner class name */
        class RunnableC00061 implements Runnable {

            /* renamed from: br.com.rory.electro.activity.update.LicenseExpired$1$1$1, reason: invalid class name and collision with other inner class name */
            class RunnableC00071 implements Runnable {
                static {
                    NativeLoader.classesInit0(468);
                }

                RunnableC00071() {
                }

                @Override // java.lang.Runnable
                public native void run();
            }

            /* renamed from: br.com.rory.electro.activity.update.LicenseExpired$1$1$2, reason: invalid class name */
            class AnonymousClass2 implements Runnable {
                static {
                    NativeLoader.classesInit0(469);
                }

                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public native void run();
            }

            static {
                NativeLoader.classesInit0(365);
            }

            RunnableC00061() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(177);
        }

        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* renamed from: br.com.rory.electro.activity.update.LicenseExpired$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {

        /* renamed from: br.com.rory.electro.activity.update.LicenseExpired$2$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            static {
                NativeLoader.classesInit0(343);
            }

            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        /* renamed from: br.com.rory.electro.activity.update.LicenseExpired$2$2, reason: invalid class name and collision with other inner class name */
        class RunnableC00082 implements Runnable {
            final /* synthetic */ Bitmap a;
            final /* synthetic */ String b;

            static {
                NativeLoader.classesInit0(341);
            }

            RunnableC00082(Bitmap bitmap, String str) {
                this.a = bitmap;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        /* renamed from: br.com.rory.electro.activity.update.LicenseExpired$2$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            static {
                NativeLoader.classesInit0(340);
            }

            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        /* renamed from: br.com.rory.electro.activity.update.LicenseExpired$2$4, reason: invalid class name */
        class AnonymousClass4 implements Runnable {
            static {
                NativeLoader.classesInit0(339);
            }

            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(178);
        }

        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.activity.update.LicenseExpired$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ Runnable a;

        static {
            NativeLoader.classesInit0(179);
        }

        AnonymousClass3(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* renamed from: br.com.rory.electro.activity.update.LicenseExpired$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ c a;

        /* renamed from: br.com.rory.electro.activity.update.LicenseExpired$4$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            static {
                NativeLoader.classesInit0(383);
            }

            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public native void run();
        }

        static {
            NativeLoader.classesInit0(180);
        }

        AnonymousClass4(c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.activity.update.LicenseExpired$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        static {
            NativeLoader.classesInit0(175);
        }

        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(319);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void a();

    /* JADX INFO: Access modifiers changed from: private */
    public native void b();

    private native void c();

    /* JADX INFO: Access modifiers changed from: private */
    public native void d();

    private native void e();

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected native void onDestroy();

    @m
    public native void onPingParsed(c cVar);
}
