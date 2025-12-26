package com.a.a.d.d.a;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class l {
    private static final byte[] a;
    private static final int[] b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private final c c;

    public enum a {
        GIF(true),
        JPEG(false),
        PNG_A(true),
        PNG(false),
        UNKNOWN(false);

        private final boolean f;

        a(boolean z) {
            this.f = z;
        }

        public boolean a() {
            return this.f;
        }
    }

    private static class b {
        private final ByteBuffer a;

        public b(byte[] bArr) {
            this.a = ByteBuffer.wrap(bArr);
            this.a.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.a.array().length;
        }

        public int a(int i) {
            return this.a.getInt(i);
        }

        public void a(ByteOrder byteOrder) {
            this.a.order(byteOrder);
        }

        public short b(int i) {
            return this.a.getShort(i);
        }
    }

    private static class c {
        private final InputStream a;

        public c(InputStream inputStream) {
            this.a = inputStream;
        }

        public int a() {
            return (this.a.read() & 255) | ((this.a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        }

        public int a(byte[] bArr) throws IOException {
            int length = bArr.length;
            while (length > 0) {
                int i = this.a.read(bArr, bArr.length - length, length);
                if (i == -1) {
                    break;
                }
                length -= i;
            }
            return bArr.length - length;
        }

        public long a(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long jSkip = this.a.skip(j2);
                if (jSkip <= 0) {
                    if (this.a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 -= jSkip;
            }
            return j - j2;
        }

        public short b() {
            return (short) (this.a.read() & 255);
        }

        public int c() {
            return this.a.read();
        }
    }

    static {
        byte[] bytes = new byte[0];
        try {
            bytes = "Exif\u0000\u0000".getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        a = bytes;
    }

    public l(InputStream inputStream) {
        this.c = new c(inputStream);
    }

    private static int a(int i, int i2) {
        return i + 2 + (12 * i2);
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        String str;
        StringBuilder sb;
        String str2;
        String string;
        int length = "Exif\u0000\u0000".length();
        short sB = bVar.b(length);
        if (sB == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (sB == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + ((int) sB));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.a(byteOrder);
        int iA = bVar.a(length + 4) + length;
        short sB2 = bVar.b(iA);
        for (int i = 0; i < sB2; i++) {
            int iA2 = a(iA, i);
            short sB3 = bVar.b(iA2);
            if (sB3 == 274) {
                short sB4 = bVar.b(iA2 + 2);
                if (sB4 >= 1 && sB4 <= 12) {
                    int iA3 = bVar.a(iA2 + 4);
                    if (iA3 >= 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + i + " tagType=" + ((int) sB3) + " formatCode=" + ((int) sB4) + " componentCount=" + iA3);
                        }
                        int i2 = iA3 + b[sB4];
                        if (i2 <= 4) {
                            int i3 = iA2 + 8;
                            if (i3 >= 0 && i3 <= bVar.a()) {
                                if (i2 >= 0 && i2 + i3 <= bVar.a()) {
                                    return bVar.b(i3);
                                }
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    str = "ImageHeaderParser";
                                    string = "Illegal number of bytes for TI tag data tagType=" + ((int) sB3);
                                }
                            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) sB3));
                            }
                        } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                            str = "ImageHeaderParser";
                            sb = new StringBuilder();
                            str2 = "Got byte count > 4, not orientation, continuing, formatCode=";
                            sb.append(str2);
                            sb.append((int) sB4);
                            string = sb.toString();
                        }
                    } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                        str = "ImageHeaderParser";
                        string = "Negative tiff component count";
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    str = "ImageHeaderParser";
                    sb = new StringBuilder();
                    str2 = "Got invalid format code=";
                    sb.append(str2);
                    sb.append((int) sB4);
                    string = sb.toString();
                }
                Log.d(str, string);
            }
        }
        return -1;
    }

    private static boolean a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    private byte[] d() throws IOException {
        short sB;
        int iA;
        long j;
        long jA;
        do {
            short sB2 = this.c.b();
            if (sB2 != 255) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unknown segmentId=" + ((int) sB2));
                }
                return null;
            }
            sB = this.c.b();
            if (sB == 218) {
                return null;
            }
            if (sB == 217) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return null;
            }
            iA = this.c.a() - 2;
            if (sB == 225) {
                byte[] bArr = new byte[iA];
                int iA2 = this.c.a(bArr);
                if (iA2 == iA) {
                    return bArr;
                }
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unable to read segment data, type: " + ((int) sB) + ", length: " + iA + ", actually read: " + iA2);
                }
                return null;
            }
            j = iA;
            jA = this.c.a(j);
        } while (jA == j);
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + ((int) sB) + ", wanted to skip: " + iA + ", but actually skipped: " + jA);
        }
        return null;
    }

    public boolean a() {
        return b().a();
    }

    public a b() throws IOException {
        int iA = this.c.a();
        if (iA == 65496) {
            return a.JPEG;
        }
        int iA2 = ((iA << 16) & SupportMenu.CATEGORY_MASK) | (this.c.a() & SupportMenu.USER_MASK);
        if (iA2 != -1991225785) {
            return (iA2 >> 8) == 4671814 ? a.GIF : a.UNKNOWN;
        }
        this.c.a(21L);
        return this.c.c() >= 3 ? a.PNG_A : a.PNG;
    }

    public int c() throws IOException {
        if (!a(this.c.a())) {
            return -1;
        }
        byte[] bArrD = d();
        boolean z = false;
        boolean z2 = bArrD != null && bArrD.length > a.length;
        if (z2) {
            for (int i = 0; i < a.length; i++) {
                if (bArrD[i] != a[i]) {
                    break;
                }
            }
            z = z2;
        } else {
            z = z2;
        }
        if (z) {
            return a(new b(bArrD));
        }
        return -1;
    }
}
