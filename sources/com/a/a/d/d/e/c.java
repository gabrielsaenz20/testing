package com.a.a.d.d.e;

import android.graphics.Bitmap;
import com.a.a.d.d.a.l;
import com.a.a.d.d.a.o;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class c implements com.a.a.d.e<com.a.a.d.c.g, com.a.a.d.d.e.a> {
    private static final b a = new b();
    private static final a b = new a();
    private final com.a.a.d.e<com.a.a.d.c.g, Bitmap> c;
    private final com.a.a.d.e<InputStream, com.a.a.d.d.d.b> d;
    private final com.a.a.d.b.a.c e;
    private final b f;
    private final a g;
    private String h;

    static class a {
        a() {
        }

        public InputStream a(InputStream inputStream, byte[] bArr) {
            return new o(inputStream, bArr);
        }
    }

    static class b {
        b() {
        }

        public l.a a(InputStream inputStream) {
            return new l(inputStream).b();
        }
    }

    public c(com.a.a.d.e<com.a.a.d.c.g, Bitmap> eVar, com.a.a.d.e<InputStream, com.a.a.d.d.d.b> eVar2, com.a.a.d.b.a.c cVar) {
        this(eVar, eVar2, cVar, a, b);
    }

    c(com.a.a.d.e<com.a.a.d.c.g, Bitmap> eVar, com.a.a.d.e<InputStream, com.a.a.d.d.d.b> eVar2, com.a.a.d.b.a.c cVar, b bVar, a aVar) {
        this.c = eVar;
        this.d = eVar2;
        this.e = cVar;
        this.f = bVar;
        this.g = aVar;
    }

    private com.a.a.d.d.e.a a(com.a.a.d.c.g gVar, int i, int i2, byte[] bArr) {
        return gVar.a() != null ? b(gVar, i, i2, bArr) : b(gVar, i, i2);
    }

    private com.a.a.d.d.e.a a(InputStream inputStream, int i, int i2) {
        com.a.a.d.b.l<com.a.a.d.d.d.b> lVarA = this.d.a(inputStream, i, i2);
        if (lVarA == null) {
            return null;
        }
        com.a.a.d.d.d.b bVarB = lVarA.b();
        return bVarB.e() > 1 ? new com.a.a.d.d.e.a(null, lVarA) : new com.a.a.d.d.e.a(new com.a.a.d.d.a.c(bVarB.b(), this.e), null);
    }

    private com.a.a.d.d.e.a b(com.a.a.d.c.g gVar, int i, int i2) {
        com.a.a.d.b.l<Bitmap> lVarA = this.c.a(gVar, i, i2);
        if (lVarA != null) {
            return new com.a.a.d.d.e.a(lVarA, null);
        }
        return null;
    }

    private com.a.a.d.d.e.a b(com.a.a.d.c.g gVar, int i, int i2, byte[] bArr) throws IOException {
        InputStream inputStreamA = this.g.a(gVar.a(), bArr);
        inputStreamA.mark(2048);
        l.a aVarA = this.f.a(inputStreamA);
        inputStreamA.reset();
        com.a.a.d.d.e.a aVarA2 = aVarA == l.a.GIF ? a(inputStreamA, i, i2) : null;
        return aVarA2 == null ? b(new com.a.a.d.c.g(inputStreamA, gVar.b()), i, i2) : aVarA2;
    }

    @Override // com.a.a.d.e
    public com.a.a.d.b.l<com.a.a.d.d.e.a> a(com.a.a.d.c.g gVar, int i, int i2) {
        com.a.a.j.a aVarA = com.a.a.j.a.a();
        byte[] bArrB = aVarA.b();
        try {
            com.a.a.d.d.e.a aVarA2 = a(gVar, i, i2, bArrB);
            if (aVarA2 != null) {
                return new com.a.a.d.d.e.b(aVarA2);
            }
            return null;
        } finally {
            aVarA.a(bArrB);
        }
    }

    @Override // com.a.a.d.e
    public String a() {
        if (this.h == null) {
            this.h = this.d.a() + this.c.a();
        }
        return this.h;
    }
}
