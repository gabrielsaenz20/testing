package com.a.a.c;

/* loaded from: classes.dex */
class c {
    protected int a;
    protected byte[] b;
    protected int c;
    protected int d;
    protected int[] f = new int[256];
    protected int[] g = new int[256];
    protected int[] h = new int[256];
    protected int[] i = new int[32];
    protected int[][] e = new int[256][];

    public c(byte[] bArr, int i, int i2) {
        this.b = bArr;
        this.c = i;
        this.d = i2;
        for (int i3 = 0; i3 < 256; i3++) {
            this.e[i3] = new int[4];
            int[] iArr = this.e[i3];
            int i4 = (i3 << 12) / 256;
            iArr[2] = i4;
            iArr[1] = i4;
            iArr[0] = i4;
            this.h[i3] = 256;
            this.g[i3] = 0;
        }
    }

    public int a(int i, int i2, int i3) {
        int i4 = this.f[i2];
        int i5 = i4 - 1;
        int i6 = 1000;
        int i7 = -1;
        while (true) {
            if (i4 >= 256 && i5 < 0) {
                return i7;
            }
            if (i4 < 256) {
                int[] iArr = this.e[i4];
                int i8 = iArr[1] - i2;
                if (i8 >= i6) {
                    i4 = 256;
                } else {
                    i4++;
                    if (i8 < 0) {
                        i8 = -i8;
                    }
                    int i9 = iArr[0] - i;
                    if (i9 < 0) {
                        i9 = -i9;
                    }
                    int i10 = i8 + i9;
                    if (i10 < i6) {
                        int i11 = iArr[2] - i3;
                        if (i11 < 0) {
                            i11 = -i11;
                        }
                        int i12 = i10 + i11;
                        if (i12 < i6) {
                            i7 = iArr[3];
                            i6 = i12;
                        }
                    }
                }
            }
            if (i5 >= 0) {
                int[] iArr2 = this.e[i5];
                int i13 = i2 - iArr2[1];
                if (i13 >= i6) {
                    i5 = -1;
                } else {
                    i5--;
                    if (i13 < 0) {
                        i13 = -i13;
                    }
                    int i14 = iArr2[0] - i;
                    if (i14 < 0) {
                        i14 = -i14;
                    }
                    int i15 = i13 + i14;
                    if (i15 < i6) {
                        int i16 = iArr2[2] - i3;
                        if (i16 < 0) {
                            i16 = -i16;
                        }
                        int i17 = i16 + i15;
                        if (i17 < i6) {
                            i7 = iArr2[3];
                            i6 = i17;
                        }
                    }
                }
            }
        }
    }

    protected void a(int i, int i2, int i3, int i4, int i5) {
        int i6 = i2 - i;
        if (i6 < -1) {
            i6 = -1;
        }
        int i7 = i2 + i;
        if (i7 > 256) {
            i7 = 256;
        }
        int i8 = i2 + 1;
        int i9 = i2 - 1;
        int i10 = 1;
        while (true) {
            if (i8 >= i7 && i9 <= i6) {
                return;
            }
            int i11 = i10 + 1;
            int i12 = this.i[i10];
            if (i8 < i7) {
                int i13 = i8 + 1;
                int[] iArr = this.e[i8];
                try {
                    iArr[0] = iArr[0] - (((iArr[0] - i3) * i12) / 262144);
                    iArr[1] = iArr[1] - (((iArr[1] - i4) * i12) / 262144);
                    iArr[2] = iArr[2] - (((iArr[2] - i5) * i12) / 262144);
                } catch (Exception unused) {
                }
                i8 = i13;
            }
            if (i9 > i6) {
                int i14 = i9 - 1;
                int[] iArr2 = this.e[i9];
                try {
                    iArr2[0] = iArr2[0] - (((iArr2[0] - i3) * i12) / 262144);
                    iArr2[1] = iArr2[1] - (((iArr2[1] - i4) * i12) / 262144);
                    iArr2[2] = iArr2[2] - ((i12 * (iArr2[2] - i5)) / 262144);
                } catch (Exception unused2) {
                }
                i10 = i11;
                i9 = i14;
            } else {
                i10 = i11;
            }
        }
    }

    public byte[] a() {
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            iArr[this.e[i][3]] = i;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < 256) {
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            bArr[i3] = (byte) this.e[i4][0];
            int i6 = i5 + 1;
            bArr[i5] = (byte) this.e[i4][1];
            bArr[i6] = (byte) this.e[i4][2];
            i2++;
            i3 = i6 + 1;
        }
        return bArr;
    }

    protected int b(int i, int i2, int i3) {
        int i4 = -1;
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MAX_VALUE;
        int i7 = -1;
        for (int i8 = 0; i8 < 256; i8++) {
            int[] iArr = this.e[i8];
            int i9 = iArr[0] - i;
            if (i9 < 0) {
                i9 = -i9;
            }
            int i10 = iArr[1] - i2;
            if (i10 < 0) {
                i10 = -i10;
            }
            int i11 = i9 + i10;
            int i12 = iArr[2] - i3;
            if (i12 < 0) {
                i12 = -i12;
            }
            int i13 = i11 + i12;
            if (i13 < i5) {
                i4 = i8;
                i5 = i13;
            }
            int i14 = i13 - (this.g[i8] >> 12);
            if (i14 < i6) {
                i7 = i8;
                i6 = i14;
            }
            int i15 = this.h[i8] >> 10;
            int[] iArr2 = this.h;
            iArr2[i8] = iArr2[i8] - i15;
            int[] iArr3 = this.g;
            iArr3[i8] = iArr3[i8] + (i15 << 10);
        }
        int[] iArr4 = this.h;
        iArr4[i4] = iArr4[i4] + 64;
        int[] iArr5 = this.g;
        iArr5[i4] = iArr5[i4] - 65536;
        return i7;
    }

    public void b() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < 256) {
            int[] iArr = this.e[i];
            int i4 = i + 1;
            int i5 = i;
            int i6 = iArr[1];
            for (int i7 = i4; i7 < 256; i7++) {
                int[] iArr2 = this.e[i7];
                if (iArr2[1] < i6) {
                    i6 = iArr2[1];
                    i5 = i7;
                }
            }
            int[] iArr3 = this.e[i5];
            if (i != i5) {
                int i8 = iArr3[0];
                iArr3[0] = iArr[0];
                iArr[0] = i8;
                int i9 = iArr3[1];
                iArr3[1] = iArr[1];
                iArr[1] = i9;
                int i10 = iArr3[2];
                iArr3[2] = iArr[2];
                iArr[2] = i10;
                int i11 = iArr3[3];
                iArr3[3] = iArr[3];
                iArr[3] = i11;
            }
            if (i6 != i2) {
                this.f[i2] = (i3 + i) >> 1;
                while (true) {
                    i2++;
                    if (i2 >= i6) {
                        break;
                    } else {
                        this.f[i2] = i;
                    }
                }
                i3 = i;
                i2 = i6;
            }
            i = i4;
        }
        this.f[i2] = (i3 + 255) >> 1;
        for (int i12 = i2 + 1; i12 < 256; i12++) {
            this.f[i12] = 255;
        }
    }

    protected void b(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.e[i2];
        iArr[0] = iArr[0] - (((iArr[0] - i3) * i) / 1024);
        iArr[1] = iArr[1] - (((iArr[1] - i4) * i) / 1024);
        iArr[2] = iArr[2] - ((i * (iArr[2] - i5)) / 1024);
    }

    public void c() {
        int i;
        int i2 = 1509;
        if (this.c < 1509) {
            this.d = 1;
        }
        this.a = 30 + ((this.d - 1) / 3);
        byte[] bArr = this.b;
        int i3 = this.c;
        int i4 = this.c / (this.d * 3);
        int i5 = i4 / 100;
        for (int i6 = 0; i6 < 32; i6++) {
            this.i[i6] = 1024 * (((1024 - (i6 * i6)) * 256) / 1024);
        }
        if (this.c < 1509) {
            i = 3;
        } else {
            if (this.c % 499 != 0) {
                i2 = 1497;
            } else if (this.c % 491 != 0) {
                i2 = 1473;
            } else if (this.c % 487 != 0) {
                i2 = 1461;
            }
            i = i2;
        }
        int i7 = i5;
        int i8 = 2048;
        int i9 = 32;
        int i10 = 0;
        int i11 = 1024;
        int i12 = 0;
        while (i12 < i4) {
            int i13 = (bArr[i10 + 0] & 255) << 4;
            int i14 = (bArr[i10 + 1] & 255) << 4;
            int i15 = (bArr[i10 + 2] & 255) << 4;
            int iB = b(i13, i14, i15);
            b(i11, iB, i13, i14, i15);
            if (i9 != 0) {
                a(i9, iB, i13, i14, i15);
            }
            i10 += i;
            if (i10 >= i3) {
                i10 -= this.c;
            }
            i12++;
            if (i7 == 0) {
                i7 = 1;
            }
            if (i12 % i7 == 0) {
                i11 -= i11 / this.a;
                i8 -= i8 / 30;
                int i16 = i8 >> 6;
                if (i16 <= 1) {
                    i16 = 0;
                }
                for (int i17 = 0; i17 < i16; i17++) {
                    int i18 = i16 * i16;
                    this.i[i17] = (((i18 - (i17 * i17)) * 256) / i18) * i11;
                }
                i9 = i16;
            }
        }
    }

    public byte[] d() {
        c();
        e();
        b();
        return a();
    }

    public void e() {
        for (int i = 0; i < 256; i++) {
            int[] iArr = this.e[i];
            iArr[0] = iArr[0] >> 4;
            int[] iArr2 = this.e[i];
            iArr2[1] = iArr2[1] >> 4;
            int[] iArr3 = this.e[i];
            iArr3[2] = iArr3[2] >> 4;
            this.e[i][3] = i;
        }
    }
}
