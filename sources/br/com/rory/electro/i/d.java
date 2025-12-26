package br.com.rory.electro.i;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class d {
    private static LocationManager a;
    private static Location b;
    private static float c;

    /* renamed from: br.com.rory.electro.i.d$1, reason: invalid class name */
    static class AnonymousClass1 implements LocationListener {
        final /* synthetic */ Context a;

        static {
            NativeLoader.classesInit0(380);
        }

        AnonymousClass1(Context context) {
            this.a = context;
        }

        @Override // android.location.LocationListener
        public native void onLocationChanged(Location location);

        @Override // android.location.LocationListener
        public native void onProviderDisabled(String str);

        @Override // android.location.LocationListener
        public native void onProviderEnabled(String str);

        @Override // android.location.LocationListener
        public native void onStatusChanged(String str, int i, Bundle bundle);
    }

    static {
        NativeLoader.classesInit0(446);
    }

    private static native String a();

    public static native void a(Context context);

    public static native Location b(Context context);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void b(Context context, Location location, Location location2);

    public static native float c(Context context);

    private static native float c(Context context, Location location, Location location2);

    private static native LocationManager g(Context context);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void h(Context context);

    /* JADX INFO: Access modifiers changed from: private */
    public static native Location i(Context context);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void j(Context context);
}
