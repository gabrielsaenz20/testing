package com.a.a.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class a {
    private int a;
    private int b;
    private int d;
    private OutputStream h;
    private Bitmap i;
    private byte[] j;
    private byte[] k;
    private int l;
    private byte[] m;
    private boolean u;
    private Integer c = null;
    private int e = -1;
    private int f = 0;
    private boolean g = false;
    private boolean[] n = new boolean[256];
    private int o = 7;
    private int p = -1;
    private boolean q = false;
    private boolean r = true;
    private boolean s = false;
    private int t = 10;

    private void a(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.h.write((byte) str.charAt(i));
        }
    }

    private int b(int i) {
        if (this.m == null) {
            return -1;
        }
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        int length = this.m.length;
        int i2 = 0;
        int i3 = 16777216;
        int i4 = 0;
        while (i2 < length) {
            int i5 = i2 + 1;
            int i6 = iRed - (this.m[i2] & 255);
            int i7 = i5 + 1;
            int i8 = iGreen - (this.m[i5] & 255);
            int i9 = iBlue - (this.m[i7] & 255);
            int i10 = (i6 * i6) + (i8 * i8) + (i9 * i9);
            int i11 = i7 / 3;
            if (this.n[i11] && i10 < i3) {
                i3 = i10;
                i4 = i11;
            }
            i2 = i7 + 1;
        }
        return i4;
    }

    private void b() {
        int length = this.j.length;
        int i = length / 3;
        this.k = new byte[i];
        c cVar = new c(this.j, length, this.t);
        this.m = cVar.d();
        int iIntValue = 0;
        for (int i2 = 0; i2 < this.m.length; i2 += 3) {
            byte b = this.m[i2];
            int i3 = i2 + 2;
            this.m[i2] = this.m[i3];
            this.m[i3] = b;
            this.n[i2 / 3] = false;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int iA = cVar.a(this.j[i5] & 255, this.j[i6] & 255, this.j[i7] & 255);
            this.n[iA] = true;
            this.k[i4] = (byte) iA;
            i4++;
            i5 = i7 + 1;
        }
        this.j = null;
        this.l = 8;
        this.o = 7;
        if (this.c != null) {
            iIntValue = this.c.intValue();
        } else if (!this.u) {
            return;
        }
        this.d = b(iIntValue);
    }

    private void c() {
        int width = this.i.getWidth();
        int height = this.i.getHeight();
        if (width != this.a || height != this.b) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
            this.i = bitmapCreateBitmap;
        }
        int[] iArr = new int[width * height];
        this.i.getPixels(iArr, 0, width, 0, 0, width, height);
        this.j = new byte[iArr.length * 3];
        this.u = false;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = iArr[i];
            if (i4 == 0) {
                i2++;
            }
            int i5 = i3 + 1;
            this.j[i3] = (byte) (i4 & 255);
            int i6 = i5 + 1;
            this.j[i5] = (byte) ((i4 >> 8) & 255);
            this.j[i6] = (byte) ((i4 >> 16) & 255);
            i++;
            i3 = i6 + 1;
        }
        double length2 = (100 * i2) / iArr.length;
        this.u = length2 > 4.0d;
        if (Log.isLoggable("AnimatedGifEncoder", 3)) {
            Log.d("AnimatedGifEncoder", "got pixels for frame with " + length2 + "% transparent pixels");
        }
    }

    private void c(int i) throws IOException {
        this.h.write(i & 255);
        this.h.write((i >> 8) & 255);
    }

    private void d() throws IOException {
        int i;
        int i2;
        this.h.write(33);
        this.h.write(249);
        this.h.write(4);
        if (this.c != null || this.u) {
            i = 1;
            i2 = 2;
        } else {
            i2 = 0;
            i = 0;
        }
        if (this.p >= 0) {
            i2 = this.p & 7;
        }
        this.h.write((i2 << 2) | 0 | 0 | i);
        c(this.f);
        this.h.write(this.d);
        this.h.write(0);
    }

    private void e() throws IOException {
        this.h.write(44);
        c(0);
        c(0);
        c(this.a);
        c(this.b);
        if (this.r) {
            this.h.write(0);
        } else {
            this.h.write(this.o | 128);
        }
    }

    private void f() throws IOException {
        c(this.a);
        c(this.b);
        this.h.write(this.o | 240);
        this.h.write(0);
        this.h.write(0);
    }

    private void g() throws IOException {
        this.h.write(33);
        this.h.write(255);
        this.h.write(11);
        a("NETSCAPE2.0");
        this.h.write(3);
        this.h.write(1);
        c(this.e);
        this.h.write(0);
    }

    private void h() throws IOException {
        this.h.write(this.m, 0, this.m.length);
        int length = 768 - this.m.length;
        for (int i = 0; i < length; i++) {
            this.h.write(0);
        }
    }

    private void i() throws IOException {
        new b(this.a, this.b, this.k, this.l).b(this.h);
    }

    public void a(int i) {
        this.f = Math.round(i / 10.0f);
    }

    public void a(int i, int i2) {
        if (!this.g || this.r) {
            this.a = i;
            this.b = i2;
            if (this.a < 1) {
                this.a = 320;
            }
            if (this.b < 1) {
                this.b = 240;
            }
            this.s = true;
        }
    }

    public boolean a() throws IOException {
        boolean z;
        if (!this.g) {
            return false;
        }
        this.g = false;
        try {
            this.h.write(59);
            this.h.flush();
            if (this.q) {
                this.h.close();
            }
            z = true;
        } catch (IOException unused) {
            z = false;
        }
        this.d = 0;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = null;
        this.q = false;
        this.r = true;
        return z;
    }

    public boolean a(Bitmap bitmap) {
        if (bitmap == null || !this.g) {
            return false;
        }
        try {
            if (!this.s) {
                a(bitmap.getWidth(), bitmap.getHeight());
            }
            this.i = bitmap;
            c();
            b();
            if (this.r) {
                f();
                h();
                if (this.e >= 0) {
                    g();
                }
            }
            d();
            e();
            if (!this.r) {
                h();
            }
            i();
            this.r = false;
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean a(OutputStream outputStream) {
        boolean z = false;
        if (outputStream == null) {
            return false;
        }
        this.q = false;
        this.h = outputStream;
        try {
            a("GIF89a");
            z = true;
        } catch (IOException unused) {
        }
        this.g = z;
        return z;
    }
}
