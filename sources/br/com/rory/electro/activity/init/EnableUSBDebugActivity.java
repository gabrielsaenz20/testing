package br.com.rory.electro.activity.init;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class EnableUSBDebugActivity extends AppCompatActivity {
    private TextView a;
    private CheckBox b;
    private Button c;

    /* renamed from: br.com.rory.electro.activity.init.EnableUSBDebugActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        static {
            NativeLoader.classesInit0(122);
        }

        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* renamed from: br.com.rory.electro.activity.init.EnableUSBDebugActivity$2, reason: invalid class name */
    class AnonymousClass2 implements CompoundButton.OnCheckedChangeListener {
        static {
            NativeLoader.classesInit0(124);
        }

        AnonymousClass2() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public native void onCheckedChanged(CompoundButton compoundButton, boolean z);
    }

    /* renamed from: br.com.rory.electro.activity.init.EnableUSBDebugActivity$3, reason: invalid class name */
    class AnonymousClass3 extends CountDownTimer {
        static {
            NativeLoader.classesInit0(129);
        }

        AnonymousClass3(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public native void onFinish();

        @Override // android.os.CountDownTimer
        public native void onTick(long j);
    }

    static {
        NativeLoader.classesInit0(381);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected native void onResume();
}
