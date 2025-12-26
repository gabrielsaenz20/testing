package com.a.a.b;

import android.support.v4.view.ViewCompat;
import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes.dex */
public class d {
    private ByteBuffer b;
    private c c;
    private final byte[] a = new byte[256];
    private int d = 0;

    private int[] a(int i) {
        int[] iArr;
        byte[] bArr = new byte[3 * i];
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = i4 + 1;
                    int i6 = i5 + 1;
                    int i7 = i2 + 1;
                    iArr[i2] = ((bArr[i3] & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                    i3 = i6;
                    i2 = i7;
                } catch (BufferUnderflowException e) {
                    e = e;
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
                    }
                    this.c.b = 1;
                    return iArr;
                }
            }
        } catch (BufferUnderflowException e2) {
            e = e2;
            iArr = null;
        }
        return iArr;
    }

    private void c() {
        this.b = null;
        Arrays.fill(this.a, (byte) 0);
        this.c = new c();
        this.d = 0;
    }

    private void d() {
        boolean z = false;
        while (!z && !o()) {
            int iM = m();
            if (iM == 33) {
                int iM2 = m();
                if (iM2 != 1) {
                    if (iM2 != 249) {
                        switch (iM2) {
                            case 255:
                                l();
                                String str = "";
                                for (int i = 0; i < 11; i++) {
                                    str = str + ((char) this.a[i]);
                                }
                                if (str.equals("NETSCAPE2.0")) {
                                    g();
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else {
                        this.c.d = new b();
                        e();
                    }
                }
                k();
            } else if (iM == 44) {
                if (this.c.d == null) {
                    this.c.d = new b();
                }
                f();
            } else if (iM != 59) {
                this.c.b = 1;
            } else {
                z = true;
            }
        }
    }

    private void e() {
        m();
        int iM = m();
        this.c.d.g = (iM & 28) >> 2;
        if (this.c.d.g == 0) {
            this.c.d.g = 1;
        }
        this.c.d.f = (iM & 1) != 0;
        int iN = n();
        if (iN < 3) {
            iN = 10;
        }
        this.c.d.i = iN * 10;
        this.c.d.h = m();
        m();
    }

    private void f() {
        b bVar;
        int[] iArrA;
        this.c.d.a = n();
        this.c.d.b = n();
        this.c.d.c = n();
        this.c.d.d = n();
        int iM = m();
        boolean z = (iM & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iM & 7) + 1);
        this.c.d.e = (iM & 64) != 0;
        if (z) {
            bVar = this.c.d;
            iArrA = a(iPow);
        } else {
            bVar = this.c.d;
            iArrA = null;
        }
        bVar.k = iArrA;
        this.c.d.j = this.b.position();
        j();
        if (o()) {
            return;
        }
        this.c.c++;
        this.c.e.add(this.c.d);
    }

    private void g() {
        do {
            l();
            if (this.a[0] == 1) {
                this.c.m = (this.a[1] & 255) | ((this.a[2] & 255) << 8);
            }
            if (this.d <= 0) {
                return;
            }
        } while (!o());
    }

    private void h() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) m());
        }
        if (!str.startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        i();
        if (!this.c.h || o()) {
            return;
        }
        this.c.a = a(this.c.i);
        this.c.l = this.c.a[this.c.j];
    }

    private void i() {
        this.c.f = n();
        this.c.g = n();
        int iM = m();
        this.c.h = (iM & 128) != 0;
        this.c.i = 2 << (iM & 7);
        this.c.j = m();
        this.c.k = m();
    }

    private void j() {
        m();
        k();
    }

    private void k() {
        int iM;
        do {
            iM = m();
            this.b.position(this.b.position() + iM);
        } while (iM > 0);
    }

    private int l() {
        this.d = m();
        int i = 0;
        if (this.d > 0) {
            int i2 = 0;
            while (i < this.d) {
                try {
                    i2 = this.d - i;
                    this.b.get(this.a, i, i2);
                    i += i2;
                } catch (Exception e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.d, e);
                    }
                    this.c.b = 1;
                }
            }
        }
        return i;
    }

    private int m() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    private int n() {
        return this.b.getShort();
    }

    private boolean o() {
        return this.c.b != 0;
    }

    public d a(byte[] bArr) {
        c();
        if (bArr == null) {
            this.b = null;
            this.c.b = 2;
            return this;
        }
        this.b = ByteBuffer.wrap(bArr);
        this.b.rewind();
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    public c b() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (o()) {
            return this.c;
        }
        h();
        if (!o()) {
            d();
            if (this.c.c < 0) {
                this.c.b = 1;
            }
        }
        return this.c;
    }
}
