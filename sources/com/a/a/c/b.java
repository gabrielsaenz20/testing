package com.a.a.c;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
class b {
    int a;
    int c;
    int j;
    int k;
    int l;
    int p;
    private int r;
    private int s;
    private byte[] t;
    private int u;
    private int v;
    private int w;
    int b = 12;
    int d = 4096;
    int[] e = new int[5003];
    int[] f = new int[5003];
    int g = 5003;
    int h = 0;
    boolean i = false;
    int m = 0;
    int n = 0;
    int[] o = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] q = new byte[256];

    b(int i, int i2, byte[] bArr, int i3) {
        this.r = i;
        this.s = i2;
        this.t = bArr;
        this.u = Math.max(2, i3);
    }

    private int a() {
        if (this.v == 0) {
            return -1;
        }
        this.v--;
        byte[] bArr = this.t;
        int i = this.w;
        this.w = i + 1;
        return bArr[i] & 255;
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.q;
        int i = this.p;
        this.p = i + 1;
        bArr[i] = b;
        if (this.p >= 254) {
            c(outputStream);
        }
    }

    void a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.e[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        this.j = i;
        int i2 = 0;
        this.i = false;
        this.a = this.j;
        this.c = b(this.a);
        this.k = 1 << (i - 1);
        this.l = this.k + 1;
        this.h = this.k + 2;
        this.p = 0;
        int iA = a();
        for (int i3 = this.g; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.g;
        a(i5);
        b(this.k, outputStream);
        while (true) {
            int iA2 = a();
            if (iA2 == -1) {
                b(iA, outputStream);
                b(this.l, outputStream);
                return;
            }
            int i6 = (iA2 << this.b) + iA;
            int i7 = (iA2 << i4) ^ iA;
            if (this.e[i7] == i6) {
                iA = this.f[i7];
            } else {
                if (this.e[i7] >= 0) {
                    int i8 = i5 - i7;
                    if (i7 == 0) {
                        i8 = 1;
                    }
                    do {
                        i7 -= i8;
                        if (i7 < 0) {
                            i7 += i5;
                        }
                        if (this.e[i7] == i6) {
                            iA = this.f[i7];
                            break;
                        }
                    } while (this.e[i7] >= 0);
                }
                b(iA, outputStream);
                if (this.h < this.d) {
                    int[] iArr = this.f;
                    int i9 = this.h;
                    this.h = i9 + 1;
                    iArr[i7] = i9;
                    this.e[i7] = i6;
                } else {
                    a(outputStream);
                }
                iA = iA2;
            }
        }
    }

    void a(OutputStream outputStream) throws IOException {
        a(this.g);
        this.h = this.k + 2;
        this.i = true;
        b(this.k, outputStream);
    }

    final int b(int i) {
        return (1 << i) - 1;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.m &= this.o[this.n];
        if (this.n > 0) {
            this.m |= i << this.n;
        } else {
            this.m = i;
        }
        int i2 = this.n + this.a;
        while (true) {
            this.n = i2;
            if (this.n < 8) {
                break;
            }
            a((byte) (this.m & 255), outputStream);
            this.m >>= 8;
            i2 = this.n - 8;
        }
        if (this.h > this.c || this.i) {
            if (this.i) {
                int i3 = this.j;
                this.a = i3;
                this.c = b(i3);
                this.i = false;
            } else {
                this.a++;
                this.c = this.a == this.b ? this.d : b(this.a);
            }
        }
        if (i == this.l) {
            while (this.n > 0) {
                a((byte) (this.m & 255), outputStream);
                this.m >>= 8;
                this.n -= 8;
            }
            c(outputStream);
        }
    }

    void b(OutputStream outputStream) throws IOException {
        outputStream.write(this.u);
        this.v = this.r * this.s;
        this.w = 0;
        a(this.u + 1, outputStream);
        outputStream.write(0);
    }

    void c(OutputStream outputStream) throws IOException {
        if (this.p > 0) {
            outputStream.write(this.p);
            outputStream.write(this.q, 0, this.p);
            this.p = 0;
        }
    }
}
