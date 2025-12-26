package com.a.a.j;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class d {
    private static final double a;

    static {
        a = 17 <= Build.VERSION.SDK_INT ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    public static double a(long j) {
        return (a() - j) * a;
    }

    @TargetApi(17)
    public static long a() {
        return 17 <= Build.VERSION.SDK_INT ? SystemClock.elapsedRealtimeNanos() : System.currentTimeMillis();
    }
}
