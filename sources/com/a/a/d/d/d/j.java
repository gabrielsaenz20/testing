package com.a.a.d.d.d;

import android.graphics.Bitmap;
import android.util.Log;
import com.a.a.b.a;
import com.a.a.d.b.l;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class j implements com.a.a.d.f<b> {
    private static final a a = new a();
    private final a.InterfaceC0020a b;
    private final com.a.a.d.b.a.c c;
    private final a d;

    static class a {
        a() {
        }

        public com.a.a.b.a a(a.InterfaceC0020a interfaceC0020a) {
            return new com.a.a.b.a(interfaceC0020a);
        }

        public com.a.a.b.d a() {
            return new com.a.a.b.d();
        }

        public l<Bitmap> a(Bitmap bitmap, com.a.a.d.b.a.c cVar) {
            return new com.a.a.d.d.a.c(bitmap, cVar);
        }

        public com.a.a.c.a b() {
            return new com.a.a.c.a();
        }
    }

    public j(com.a.a.d.b.a.c cVar) {
        this(cVar, a);
    }

    j(com.a.a.d.b.a.c cVar, a aVar) {
        this.c = cVar;
        this.b = new com.a.a.d.d.d.a(cVar);
        this.d = aVar;
    }

    private com.a.a.b.a a(byte[] bArr) {
        com.a.a.b.d dVarA = this.d.a();
        dVarA.a(bArr);
        com.a.a.b.c cVarB = dVarA.b();
        com.a.a.b.a aVarA = this.d.a(this.b);
        aVarA.a(cVarB, bArr);
        aVarA.a();
        return aVarA;
    }

    private l<Bitmap> a(Bitmap bitmap, com.a.a.d.g<Bitmap> gVar, b bVar) {
        l<Bitmap> lVarA = this.d.a(bitmap, this.c);
        l<Bitmap> lVarA2 = gVar.a(lVarA, bVar.getIntrinsicWidth(), bVar.getIntrinsicHeight());
        if (!lVarA.equals(lVarA2)) {
            lVarA.d();
        }
        return lVarA2;
    }

    private boolean a(byte[] bArr, OutputStream outputStream) throws IOException {
        try {
            outputStream.write(bArr);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable("GifEncoder", 3)) {
                return false;
            }
            Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", e);
            return false;
        }
    }

    @Override // com.a.a.d.b
    public String a() {
        return "";
    }

    @Override // com.a.a.d.b
    public boolean a(l<b> lVar, OutputStream outputStream) throws IOException {
        long jA = com.a.a.j.d.a();
        b bVarB = lVar.b();
        com.a.a.d.g<Bitmap> gVarC = bVarB.c();
        if (gVarC instanceof com.a.a.d.d.d) {
            return a(bVarB.d(), outputStream);
        }
        com.a.a.b.a aVarA = a(bVarB.d());
        com.a.a.c.a aVarB = this.d.b();
        if (!aVarB.a(outputStream)) {
            return false;
        }
        for (int i = 0; i < aVarA.c(); i++) {
            l<Bitmap> lVarA = a(aVarA.f(), gVarC, bVarB);
            try {
                if (!aVarB.a(lVarA.b())) {
                    return false;
                }
                aVarB.a(aVarA.a(aVarA.d()));
                aVarA.a();
                lVarA.d();
            } finally {
                lVarA.d();
            }
        }
        boolean zA = aVarB.a();
        if (Log.isLoggable("GifEncoder", 2)) {
            Log.v("GifEncoder", "Encoded gif with " + aVarA.c() + " frames and " + bVarB.d().length + " bytes in " + com.a.a.j.d.a(jA) + " ms");
        }
        return zA;
    }
}
