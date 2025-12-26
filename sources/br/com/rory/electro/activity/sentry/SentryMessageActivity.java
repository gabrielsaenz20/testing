package br.com.rory.electro.activity.sentry;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class SentryMessageActivity extends AppCompatActivity {
    private BroadcastReceiver a;
    private Handler b;
    private Runnable c;
    private int d;
    private int e;
    private boolean f = false;
    private TextView g;
    private ImageView h;
    private FrameLayout i;
    private Handler j;
    private Runnable k;

    /* renamed from: br.com.rory.electro.activity.sentry.SentryMessageActivity$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        static {
            NativeLoader.classesInit0(435);
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.activity.sentry.SentryMessageActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ TextView a;
        final /* synthetic */ boolean b;

        static {
            NativeLoader.classesInit0(437);
        }

        AnonymousClass2(TextView textView, boolean z) {
            this.a = textView;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.activity.sentry.SentryMessageActivity$3, reason: invalid class name */
    class AnonymousClass3 extends BroadcastReceiver {
        static {
            NativeLoader.classesInit0(436);
        }

        AnonymousClass3() {
        }

        @Override // android.content.BroadcastReceiver
        public native void onReceive(Context context, Intent intent);
    }

    /* renamed from: br.com.rory.electro.activity.sentry.SentryMessageActivity$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ int a;

        static {
            NativeLoader.classesInit0(439);
        }

        AnonymousClass4(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.activity.sentry.SentryMessageActivity$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        static {
            NativeLoader.classesInit0(438);
        }

        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(389);
    }

    private native String a(String str);

    private native void a(int i);

    private native void a(TextView textView, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean a(String str, TextView textView, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean a(String str, TextView textView, int i, int i2);

    private static native String b();

    /* JADX INFO: Access modifiers changed from: private */
    public static native String c();

    private native void d();

    private native void e();

    private native void f();

    private native void g();

    private native void h();

    private native void i();

    private native void j();

    private native void k();

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected native void onDestroy();

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected native void onResume();

    @Override // android.app.Activity, android.view.Window.Callback
    public native void onWindowFocusChanged(boolean z);
}
