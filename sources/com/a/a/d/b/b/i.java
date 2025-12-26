package com.a.a.d.b.b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* loaded from: classes.dex */
public class i {
    private final int a;
    private final int b;
    private final Context c;

    private static class a implements b {
        private final DisplayMetrics a;

        public a(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }

        @Override // com.a.a.d.b.b.i.b
        public int a() {
            return this.a.widthPixels;
        }

        @Override // com.a.a.d.b.b.i.b
        public int b() {
            return this.a.heightPixels;
        }
    }

    interface b {
        int a();

        int b();
    }

    public i(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new a(context.getResources().getDisplayMetrics()));
    }

    i(Context context, ActivityManager activityManager, b bVar) {
        this.c = context;
        int iA = a(activityManager);
        int iA2 = bVar.a() * bVar.b() * 4;
        int i = iA2 * 4;
        int i2 = iA2 * 2;
        int i3 = i2 + i;
        if (i3 <= iA) {
            this.b = i2;
        } else {
            int iRound = Math.round(iA / 6.0f);
            this.b = iRound * 2;
            i = iRound * 4;
        }
        this.a = i;
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculated memory cache size: ");
            sb.append(a(this.b));
            sb.append(" pool size: ");
            sb.append(a(this.a));
            sb.append(" memory class limited? ");
            sb.append(i3 > iA);
            sb.append(" max size: ");
            sb.append(a(iA));
            sb.append(" memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(" isLowMemoryDevice: ");
            sb.append(b(activityManager));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int a(ActivityManager activityManager) {
        return Math.round(activityManager.getMemoryClass() * 1024 * 1024 * (b(activityManager) ? 0.33f : 0.4f));
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.c, i);
    }

    @TargetApi(19)
    private static boolean b(ActivityManager activityManager) {
        return Build.VERSION.SDK_INT >= 19 ? activityManager.isLowRamDevice() : Build.VERSION.SDK_INT < 11;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }
}
