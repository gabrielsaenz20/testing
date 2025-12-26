package com.a.a.j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class f extends FilterInputStream {
    private int a;

    public f(InputStream inputStream) {
        super(inputStream);
        this.a = Integer.MIN_VALUE;
    }

    private long a(long j) {
        if (this.a == 0) {
            return -1L;
        }
        return (this.a == Integer.MIN_VALUE || j <= ((long) this.a)) ? j : this.a;
    }

    private void b(long j) {
        if (this.a == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.a = (int) (this.a - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.a == Integer.MIN_VALUE ? super.available() : Math.min(this.a, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        super.mark(i);
        this.a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int i = super.read();
        b(1L);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int iA = (int) a(i2);
        if (iA == -1) {
            return -1;
        }
        int i3 = super.read(bArr, i, iA);
        b(i3);
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jA = a(j);
        if (jA == -1) {
            return -1L;
        }
        long jSkip = super.skip(jA);
        b(jSkip);
        return jSkip;
    }
}
