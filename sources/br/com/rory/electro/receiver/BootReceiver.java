package br.com.rory.electro.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class BootReceiver extends BroadcastReceiver {

    /* renamed from: br.com.rory.electro.receiver.BootReceiver$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(474);
        }

        AnonymousClass1(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(169);
    }

    @Override // android.content.BroadcastReceiver
    public native void onReceive(Context context, Intent intent);
}
