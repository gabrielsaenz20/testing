package br.com.rory.electro.activity.update;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class UpdateRequired extends AppCompatActivity {
    static {
        NativeLoader.classesInit0(442);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected native void onResume();
}
