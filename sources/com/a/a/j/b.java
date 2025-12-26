package com.a.a.j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class b extends FilterInputStream {
    private final long a;
    private int b;

    b(InputStream inputStream, long j) {
        super(inputStream);
        this.a = j;
    }

    private int a(int i) throws IOException {
        if (i >= 0) {
            this.b += i;
            return i;
        }
        if (this.a - this.b <= 0) {
            return i;
        }
        throw new IOException("Failed to read all expected data, expected: " + this.a + ", but read: " + this.b);
    }

    public static InputStream a(InputStream inputStream, long j) {
        return new b(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.a - this.b, this.in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        return a(super.read());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        return a(super.read(bArr, i, i2));
    }
}
