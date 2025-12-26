package com.a.a.d.d.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public final class r {
    public static int a(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    private static Bitmap.Config a(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        float width;
        float width2;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i && bitmap2.getHeight() == i2) {
            return bitmap2;
        }
        Matrix matrix = new Matrix();
        float height = 0.0f;
        if (bitmap2.getWidth() * i2 > bitmap2.getHeight() * i) {
            width = i2 / bitmap2.getHeight();
            width2 = (i - (bitmap2.getWidth() * width)) * 0.5f;
        } else {
            width = i / bitmap2.getWidth();
            height = (i2 - (bitmap2.getHeight() * width)) * 0.5f;
            width2 = 0.0f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, a(bitmap2));
        }
        a(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    public static Bitmap a(Bitmap bitmap, com.a.a.d.b.a.c cVar, int i) {
        Matrix matrix = new Matrix();
        a(i, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        int iRound = Math.round(rectF.width());
        int iRound2 = Math.round(rectF.height());
        Bitmap.Config configA = a(bitmap);
        Bitmap bitmapA = cVar.a(iRound, iRound2, configA);
        if (bitmapA == null) {
            bitmapA = Bitmap.createBitmap(iRound, iRound2, configA);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(bitmapA).drawBitmap(bitmap, matrix, new Paint(6));
        return bitmapA;
    }

    public static Bitmap a(Bitmap bitmap, com.a.a.d.b.a.c cVar, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float fMin = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int width = (int) (bitmap.getWidth() * fMin);
        int height = (int) (bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap.Config configA = a(bitmap);
        Bitmap bitmapA = cVar.a(width, height, configA);
        if (bitmapA == null) {
            bitmapA = Bitmap.createBitmap(width, height, configA);
        }
        a(bitmap, bitmapA);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i + "x" + i2);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + bitmapA.getWidth() + "x" + bitmapA.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(fMin);
            Log.v("TransformationUtils", sb.toString());
        }
        Canvas canvas = new Canvas(bitmapA);
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        return bitmapA;
    }

    static void a(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
        matrix.postScale(-1.0f, 1.0f);
    }

    @TargetApi(12)
    public static void a(Bitmap bitmap, Bitmap bitmap2) {
        if (Build.VERSION.SDK_INT < 12 || bitmap2 == null) {
            return;
        }
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
