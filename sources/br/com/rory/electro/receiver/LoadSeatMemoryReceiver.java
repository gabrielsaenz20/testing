package br.com.rory.electro.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.TransportMediator;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class LoadSeatMemoryReceiver extends BroadcastReceiver {

    /* renamed from: br.com.rory.electro.receiver.LoadSeatMemoryReceiver$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ int b;

        static {
            NativeLoader.classesInit0(TransportMediator.KEYCODE_MEDIA_RECORD);
        }

        AnonymousClass1(Context context, int i) {
            this.a = context;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(83);
    }

    public static native String a();

    @Override // android.content.BroadcastReceiver
    public native void onReceive(Context context, Intent intent);
}
