package com.a.a.d.d.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.a.a.d.d.a.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class f implements a<InputStream> {
    private static final Set<l.a> d = EnumSet.of(l.a.JPEG, l.a.PNG_A, l.a.PNG);
    private static final Queue<BitmapFactory.Options> e = com.a.a.j.h.a(0);
    public static final f a = new f() { // from class: com.a.a.d.d.a.f.1
        @Override // com.a.a.d.d.a.f
        protected int a(int i, int i2, int i3, int i4) {
            return Math.min(i2 / i4, i / i3);
        }

        @Override // com.a.a.d.d.a.a
        public String a() {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }
    };
    public static final f b = new f() { // from class: com.a.a.d.d.a.f.2
        @Override // com.a.a.d.d.a.f
        protected int a(int i, int i2, int i3, int i4) {
            int iCeil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            int iMax = Math.max(1, Integer.highestOneBit(iCeil));
            return iMax << (iMax >= iCeil ? 0 : 1);
        }

        @Override // com.a.a.d.d.a.a
        public String a() {
            return "AT_MOST.com.bumptech.glide.load.data.bitmap";
        }
    };
    public static final f c = new f() { // from class: com.a.a.d.d.a.f.3
        @Override // com.a.a.d.d.a.f
        protected int a(int i, int i2, int i3, int i4) {
            return 0;
        }

        @Override // com.a.a.d.d.a.a
        public String a() {
            return "NONE.com.bumptech.glide.load.data.bitmap";
        }
    };

    private int a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = i2;
        }
        int iA = (i == 90 || i == 270) ? a(i3, i2, i4, i5) : a(i2, i3, i4, i5);
        return Math.max(1, iA == 0 ? 0 : Integer.highestOneBit(iA));
    }

    private static Bitmap.Config a(InputStream inputStream, com.a.a.d.a aVar) throws IOException {
        if (aVar == com.a.a.d.a.ALWAYS_ARGB_8888 || aVar == com.a.a.d.a.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            return Bitmap.Config.ARGB_8888;
        }
        boolean z = false;
        inputStream.mark(1024);
        try {
            try {
                boolean zA = new l(inputStream).a();
                try {
                    inputStream.reset();
                } catch (IOException e2) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", e2);
                    }
                }
                z = zA;
            } catch (IOException e3) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot determine whether the image has alpha or not from header for format " + aVar, e3);
                }
            }
            return z ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        } finally {
            try {
                inputStream.reset();
            } catch (IOException e4) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot reset the input stream", e4);
                }
            }
        }
    }

    private Bitmap a(com.a.a.j.f fVar, o oVar, BitmapFactory.Options options, com.a.a.d.b.a.c cVar, int i, int i2, int i3, com.a.a.d.a aVar) throws IOException {
        Bitmap.Config configA = a(fVar, aVar);
        options.inSampleSize = i3;
        options.inPreferredConfig = configA;
        if ((options.inSampleSize == 1 || 19 <= Build.VERSION.SDK_INT) && a(fVar)) {
            double d2 = i3;
            a(options, cVar.b((int) Math.ceil(i / d2), (int) Math.ceil(i2 / d2), configA));
        }
        return b(fVar, oVar, options);
    }

    private static void a(BitmapFactory.Options options) {
        b(options);
        synchronized (e) {
            e.offer(options);
        }
    }

    @TargetApi(11)
    private static void a(BitmapFactory.Options options, Bitmap bitmap) {
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = bitmap;
        }
    }

    private static boolean a(InputStream inputStream) throws IOException {
        if (19 <= Build.VERSION.SDK_INT) {
            return true;
        }
        inputStream.mark(1024);
        try {
            try {
                boolean zContains = d.contains(new l(inputStream).b());
                try {
                    return zContains;
                } catch (IOException e2) {
                    return zContains;
                }
            } catch (IOException e3) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot determine the image type from header", e3);
                }
                try {
                    inputStream.reset();
                    return false;
                } catch (IOException e4) {
                    if (!Log.isLoggable("Downsampler", 5)) {
                        return false;
                    }
                    Log.w("Downsampler", "Cannot reset the input stream", e4);
                    return false;
                }
            }
        } finally {
            try {
                inputStream.reset();
            } catch (IOException e22) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot reset the input stream", e22);
                }
            }
        }
    }

    private static Bitmap b(com.a.a.j.f fVar, o oVar, BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            fVar.mark(5242880);
        } else {
            oVar.a();
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fVar, null, options);
        try {
            if (options.inJustDecodeBounds) {
                fVar.reset();
                return bitmapDecodeStream;
            }
        } catch (IOException e2) {
            if (Log.isLoggable("Downsampler", 6)) {
                Log.e("Downsampler", "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e2);
            }
        }
        return bitmapDecodeStream;
    }

    @TargetApi(11)
    private static synchronized BitmapFactory.Options b() {
        BitmapFactory.Options optionsPoll;
        synchronized (e) {
            optionsPoll = e.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            b(optionsPoll);
        }
        return optionsPoll;
    }

    @TargetApi(11)
    private static void b(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }

    protected abstract int a(int i, int i2, int i3, int i4);

    public Bitmap a(InputStream inputStream, com.a.a.d.b.a.c cVar, int i, int i2, com.a.a.d.a aVar) throws Throwable {
        BitmapFactory.Options options;
        Throwable th;
        Throwable th2;
        int i3;
        com.a.a.j.a aVarA = com.a.a.j.a.a();
        byte[] bArrB = aVarA.b();
        byte[] bArrB2 = aVarA.b();
        BitmapFactory.Options optionsB = b();
        o oVar = new o(inputStream, bArrB2);
        com.a.a.j.c cVarA = com.a.a.j.c.a(oVar);
        com.a.a.j.f fVar = new com.a.a.j.f(cVarA);
        try {
            cVarA.mark(5242880);
        } catch (Throwable th3) {
            th = th3;
            options = optionsB;
        }
        try {
            try {
                try {
                    int iC = new l(cVarA).c();
                    try {
                        cVarA.reset();
                    } catch (IOException e2) {
                        if (Log.isLoggable("Downsampler", 5)) {
                            Log.w("Downsampler", "Cannot reset the input stream", e2);
                        }
                    }
                    i3 = iC;
                } catch (Throwable th4) {
                    th2 = th4;
                    options = optionsB;
                    try {
                        try {
                            cVarA.reset();
                            throw th2;
                        } catch (IOException e3) {
                            if (!Log.isLoggable("Downsampler", 5)) {
                                throw th2;
                            }
                            Log.w("Downsampler", "Cannot reset the input stream", e3);
                            throw th2;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        th = th;
                        aVarA.a(bArrB);
                        aVarA.a(bArrB2);
                        cVarA.b();
                        a(options);
                        throw th;
                    }
                }
            } catch (IOException e4) {
                try {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot determine the image orientation from header", e4);
                    }
                    try {
                        cVarA.reset();
                    } catch (IOException e5) {
                        if (Log.isLoggable("Downsampler", 5)) {
                            Log.w("Downsampler", "Cannot reset the input stream", e5);
                        }
                    }
                    i3 = 0;
                } catch (Throwable th6) {
                    options = optionsB;
                    th2 = th6;
                    cVarA.reset();
                    throw th2;
                }
            }
            optionsB.inTempStorage = bArrB;
            int[] iArrA = a(fVar, oVar, optionsB);
            int i4 = iArrA[0];
            int i5 = iArrA[1];
            int i6 = i3;
            try {
                Bitmap bitmapA = a(fVar, oVar, optionsB, cVar, i4, i5, a(r.a(i3), i4, i5, i, i2), aVar);
                IOException iOExceptionA = cVarA.a();
                try {
                    if (iOExceptionA != null) {
                        throw new RuntimeException(iOExceptionA);
                    }
                    Bitmap bitmapA2 = null;
                    if (bitmapA != null) {
                        bitmapA2 = r.a(bitmapA, cVar, i6);
                        if (!bitmapA.equals(bitmapA2) && !cVar.a(bitmapA)) {
                            bitmapA.recycle();
                        }
                    }
                    aVarA.a(bArrB);
                    aVarA.a(bArrB2);
                    cVarA.b();
                    a(optionsB);
                    return bitmapA2;
                } catch (Throwable th7) {
                    th = th7;
                    options = optionsB;
                    aVarA.a(bArrB);
                    aVarA.a(bArrB2);
                    cVarA.b();
                    a(options);
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                options = optionsB;
                th = th;
                aVarA.a(bArrB);
                aVarA.a(bArrB2);
                cVarA.b();
                a(options);
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            options = optionsB;
            aVarA.a(bArrB);
            aVarA.a(bArrB2);
            cVarA.b();
            a(options);
            throw th;
        }
    }

    public int[] a(com.a.a.j.f fVar, o oVar, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        b(fVar, oVar, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }
}
