package com.a.a.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public class a {
    private static final String a = "a";
    private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
    private int[] c;
    private ByteBuffer e;
    private short[] g;
    private byte[] h;
    private byte[] i;
    private byte[] j;
    private int[] k;
    private int l;
    private byte[] m;
    private InterfaceC0020a o;
    private Bitmap p;
    private boolean q;
    private int r;
    private final int[] d = new int[256];
    private final byte[] f = new byte[256];
    private c n = new c();

    /* renamed from: com.a.a.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0020a {
        Bitmap a(int i, int i2, Bitmap.Config config);

        void a(Bitmap bitmap);
    }

    public a(InterfaceC0020a interfaceC0020a) {
        this.o = interfaceC0020a;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap a(b bVar, b bVar2) {
        int i;
        int i2 = this.n.f;
        int i3 = this.n.g;
        int[] iArr = this.k;
        int i4 = 0;
        if (bVar2 == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.g > 0) {
            if (bVar2.g == 2) {
                if (!bVar.f) {
                    int i5 = this.n.l;
                    if (bVar.k != null && this.n.j == bVar.h) {
                        i5 = 0;
                    }
                    int i6 = (bVar2.b * i2) + bVar2.a;
                    int i7 = (bVar2.d * i2) + i6;
                    while (i6 < i7) {
                        int i8 = bVar2.c + i6;
                        for (int i9 = i6; i9 < i8; i9++) {
                            iArr[i9] = i5;
                        }
                        i6 += i2;
                    }
                }
            } else if (bVar2.g == 3 && this.p != null) {
                this.p.getPixels(iArr, 0, i2, 0, 0, i2, i3);
            }
        }
        a(bVar);
        int i10 = 8;
        int i11 = 1;
        int i12 = 0;
        while (i4 < bVar.d) {
            if (bVar.e) {
                if (i12 >= bVar.d) {
                    i11++;
                    switch (i11) {
                        case 2:
                            i12 = 4;
                            break;
                        case 3:
                            i10 = 4;
                            i12 = 2;
                            break;
                        case 4:
                            i12 = 1;
                            i10 = 2;
                            break;
                    }
                }
                i = i12 + i10;
            } else {
                i = i12;
                i12 = i4;
            }
            int i13 = i12 + bVar.b;
            if (i13 < this.n.g) {
                int i14 = i13 * this.n.f;
                int i15 = bVar.a + i14;
                int i16 = bVar.c + i15;
                if (this.n.f + i14 < i16) {
                    i16 = this.n.f + i14;
                }
                int i17 = bVar.c * i4;
                while (i15 < i16) {
                    int i18 = i17 + 1;
                    int i19 = this.c[this.j[i17] & 255];
                    if (i19 != 0) {
                        iArr[i15] = i19;
                    }
                    i15++;
                    i17 = i18;
                }
            }
            i4++;
            i12 = i;
        }
        if (this.q && (bVar.g == 0 || bVar.g == 1)) {
            if (this.p == null) {
                this.p = j();
            }
            this.p.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        }
        Bitmap bitmapJ = j();
        bitmapJ.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        return bitmapJ;
    }

    @TargetApi(12)
    private static void a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v20, types: [short] */
    /* JADX WARN: Type inference failed for: r2v23 */
    private void a(b bVar) {
        int i;
        short s;
        if (bVar != null) {
            this.e.position(bVar.j);
        }
        int i2 = bVar == null ? this.n.f * this.n.g : bVar.d * bVar.c;
        if (this.j == null || this.j.length < i2) {
            this.j = new byte[i2];
        }
        if (this.g == null) {
            this.g = new short[4096];
        }
        if (this.h == null) {
            this.h = new byte[4096];
        }
        if (this.i == null) {
            this.i = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int iH = h();
        int i3 = 1;
        int i4 = 1 << iH;
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        int i7 = iH + 1;
        int i8 = (1 << i7) - 1;
        for (int i9 = 0; i9 < i4; i9++) {
            this.g[i9] = 0;
            this.h[i9] = (byte) i9;
        }
        int i10 = -1;
        int i11 = i7;
        int i12 = i6;
        int i13 = i8;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        while (true) {
            if (i14 >= i2) {
                break;
            }
            int i23 = 3;
            if (i15 == 0) {
                i15 = i();
                if (i15 <= 0) {
                    this.r = 3;
                    break;
                }
                i18 = 0;
            }
            i17 += (this.f[i18] & 255) << i19;
            i18 += i3;
            i15 += i10;
            int i24 = i19 + 8;
            int i25 = i20;
            int i26 = i22;
            int i27 = i14;
            int i28 = i16;
            int i29 = i12;
            int i30 = i11;
            while (i24 >= i30) {
                int i31 = i17 & i13;
                i17 >>= i30;
                i24 -= i30;
                if (i31 != i4) {
                    if (i31 > i29) {
                        this.r = i23;
                    } else if (i31 != i5) {
                        if (i26 == -1) {
                            this.i[i21] = this.h[i31];
                            i26 = i31;
                            i25 = i26;
                            i21++;
                        } else {
                            if (i31 >= i29) {
                                i = i7;
                                this.i[i21] = (byte) i25;
                                s = i26;
                                i21++;
                            } else {
                                i = i7;
                                s = i31;
                            }
                            while (s >= i4) {
                                this.i[i21] = this.h[s];
                                s = this.g[s];
                                i21++;
                                i24 = i24;
                            }
                            int i32 = i24;
                            int i33 = this.h[s] & 255;
                            int i34 = i21 + 1;
                            int i35 = i4;
                            byte b2 = (byte) i33;
                            this.i[i21] = b2;
                            if (i29 < 4096) {
                                this.g[i29] = (short) i26;
                                this.h[i29] = b2;
                                i29++;
                                if ((i29 & i13) == 0 && i29 < 4096) {
                                    i30++;
                                    i13 += i29;
                                }
                            }
                            i21 = i34;
                            while (i21 > 0) {
                                i21--;
                                this.j[i28] = this.i[i21];
                                i27++;
                                i28++;
                            }
                            i25 = i33;
                            i26 = i31;
                            i7 = i;
                            i24 = i32;
                            i4 = i35;
                        }
                        i23 = 3;
                    }
                    i22 = i26;
                    i11 = i30;
                    i12 = i29;
                    i14 = i27;
                    i16 = i28;
                    i20 = i25;
                    i3 = 1;
                    i10 = -1;
                    i19 = i24;
                    break;
                }
                i30 = i7;
                i29 = i6;
                i13 = i8;
                i26 = -1;
                i10 = -1;
            }
            i22 = i26;
            i11 = i30;
            i12 = i29;
            i14 = i27;
            i16 = i28;
            i3 = 1;
            i20 = i25;
            i19 = i24;
            i7 = i7;
        }
        while (i16 < i2) {
            this.j[i16] = 0;
            i16++;
        }
    }

    private int h() {
        try {
            return this.e.get() & 255;
        } catch (Exception unused) {
            this.r = 1;
            return 0;
        }
    }

    private int i() {
        int iH = h();
        int i = 0;
        if (iH > 0) {
            while (i < iH) {
                int i2 = iH - i;
                try {
                    this.e.get(this.f, i, i2);
                    i += i2;
                } catch (Exception e) {
                    Log.w(a, "Error Reading Block", e);
                    this.r = 1;
                }
            }
        }
        return i;
    }

    private Bitmap j() {
        Bitmap bitmapA = this.o.a(this.n.f, this.n.g, b);
        if (bitmapA == null) {
            bitmapA = Bitmap.createBitmap(this.n.f, this.n.g, b);
        }
        a(bitmapA);
        return bitmapA;
    }

    public int a(int i) {
        if (i < 0 || i >= this.n.c) {
            return -1;
        }
        return this.n.e.get(i).i;
    }

    public void a() {
        this.l = (this.l + 1) % this.n.c;
    }

    public void a(c cVar, byte[] bArr) {
        this.n = cVar;
        this.m = bArr;
        this.r = 0;
        this.l = -1;
        this.e = ByteBuffer.wrap(bArr);
        this.e.rewind();
        this.e.order(ByteOrder.LITTLE_ENDIAN);
        this.q = false;
        Iterator<b> it = cVar.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().g == 3) {
                this.q = true;
                break;
            }
        }
        this.j = new byte[cVar.f * cVar.g];
        this.k = new int[cVar.f * cVar.g];
    }

    public int b() {
        if (this.n.c <= 0 || this.l < 0) {
            return -1;
        }
        return a(this.l);
    }

    public int c() {
        return this.n.c;
    }

    public int d() {
        return this.l;
    }

    public int e() {
        if (this.n.m == -1) {
            return 1;
        }
        if (this.n.m == 0) {
            return 0;
        }
        return this.n.m + 1;
    }

    public synchronized Bitmap f() {
        if (this.n.c <= 0 || this.l < 0) {
            if (Log.isLoggable(a, 3)) {
                Log.d(a, "unable to decode frame, frameCount=" + this.n.c + " framePointer=" + this.l);
            }
            this.r = 1;
        }
        if (this.r != 1 && this.r != 2) {
            this.r = 0;
            b bVar = this.n.e.get(this.l);
            int i = this.l - 1;
            b bVar2 = i >= 0 ? this.n.e.get(i) : null;
            this.c = bVar.k != null ? bVar.k : this.n.a;
            if (this.c == null) {
                if (Log.isLoggable(a, 3)) {
                    Log.d(a, "No Valid Color Table");
                }
                this.r = 1;
                return null;
            }
            if (bVar.f) {
                System.arraycopy(this.c, 0, this.d, 0, this.c.length);
                this.c = this.d;
                this.c[bVar.h] = 0;
            }
            return a(bVar, bVar2);
        }
        if (Log.isLoggable(a, 3)) {
            Log.d(a, "Unable to decode frame, status=" + this.r);
        }
        return null;
    }

    public void g() {
        this.n = null;
        this.m = null;
        this.j = null;
        this.k = null;
        if (this.p != null) {
            this.o.a(this.p);
        }
        this.p = null;
        this.e = null;
    }
}
