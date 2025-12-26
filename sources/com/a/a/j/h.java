package com.a.a.j;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public final class h {
    private static final char[] a = "0123456789abcdef".toCharArray();
    private static final char[] b = new char[64];
    private static final char[] c = new char[40];

    /* renamed from: com.a.a.j.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Bitmap.Config.values().length];

        static {
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int a(int i, int i2, Bitmap.Config config) {
        return i * i2 * a(config);
    }

    private static int a(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        switch (AnonymousClass1.a[config.ordinal()]) {
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            default:
                return 4;
        }
    }

    @TargetApi(19)
    public static int a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static String a(byte[] bArr) {
        String strA;
        synchronized (b) {
            strA = a(bArr, b);
        }
        return strA;
    }

    private static String a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr[i3] = a[i2 >>> 4];
            cArr[i3 + 1] = a[i2 & 15];
        }
        return new String(cArr);
    }

    public static <T> List<T> a(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static <T> Queue<T> a(int i) {
        return new ArrayDeque(i);
    }

    public static void a() {
        if (!b()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean a(int i, int i2) {
        return b(i) && b(i2);
    }

    public static boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean b(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static boolean c() {
        return !b();
    }
}
