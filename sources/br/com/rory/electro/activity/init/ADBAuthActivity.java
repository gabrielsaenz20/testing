package br.com.rory.electro.activity.init;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class ADBAuthActivity extends AppCompatActivity {

    /* renamed from: br.com.rory.electro.activity.init.ADBAuthActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(356);
        }

        AnonymousClass1(Context context) {
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    static {
        NativeLoader.classesInit0(332);
    }

    private static native String a();

    public static native boolean a(Context context);

    private static native String b();

    /* JADX INFO: Access modifiers changed from: private */
    public native void c();

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected native void onResume();
}
