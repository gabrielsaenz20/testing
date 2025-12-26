package com.a.a.d.d.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.a.a.b.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: classes.dex */
public class i implements com.a.a.d.e<InputStream, com.a.a.d.d.d.b> {
    private static final b a = new b();
    private static final a b = new a();
    private final Context c;
    private final b d;
    private final com.a.a.d.b.a.c e;
    private final a f;
    private final com.a.a.d.d.d.a g;

    static class a {
        private final Queue<com.a.a.b.a> a = com.a.a.j.h.a(0);

        a() {
        }

        public synchronized com.a.a.b.a a(a.InterfaceC0020a interfaceC0020a) {
            com.a.a.b.a aVarPoll;
            aVarPoll = this.a.poll();
            if (aVarPoll == null) {
                aVarPoll = new com.a.a.b.a(interfaceC0020a);
            }
            return aVarPoll;
        }

        public synchronized void a(com.a.a.b.a aVar) {
            aVar.g();
            this.a.offer(aVar);
        }
    }

    static class b {
        private final Queue<com.a.a.b.d> a = com.a.a.j.h.a(0);

        b() {
        }

        public synchronized com.a.a.b.d a(byte[] bArr) {
            com.a.a.b.d dVarPoll;
            dVarPoll = this.a.poll();
            if (dVarPoll == null) {
                dVarPoll = new com.a.a.b.d();
            }
            return dVarPoll.a(bArr);
        }

        public synchronized void a(com.a.a.b.d dVar) {
            dVar.a();
            this.a.offer(dVar);
        }
    }

    public i(Context context, com.a.a.d.b.a.c cVar) {
        this(context, cVar, a, b);
    }

    i(Context context, com.a.a.d.b.a.c cVar, b bVar, a aVar) {
        this.c = context.getApplicationContext();
        this.e = cVar;
        this.f = aVar;
        this.g = new com.a.a.d.d.d.a(cVar);
        this.d = bVar;
    }

    private Bitmap a(com.a.a.b.a aVar, com.a.a.b.c cVar, byte[] bArr) {
        aVar.a(cVar, bArr);
        aVar.a();
        return aVar.f();
    }

    private d a(byte[] bArr, int i, int i2, com.a.a.b.d dVar, com.a.a.b.a aVar) {
        Bitmap bitmapA;
        com.a.a.b.c cVarB = dVar.b();
        if (cVarB.a() <= 0 || cVarB.b() != 0 || (bitmapA = a(aVar, cVarB, bArr)) == null) {
            return null;
        }
        return new d(new com.a.a.d.d.d.b(this.c, this.g, this.e, com.a.a.d.d.d.b(), i, i2, cVarB, bArr, bitmapA));
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.a.a.d.e
    public d a(InputStream inputStream, int i, int i2) throws IOException {
        byte[] bArrA = a(inputStream);
        com.a.a.b.d dVarA = this.d.a(bArrA);
        com.a.a.b.a aVarA = this.f.a(this.g);
        try {
            return a(bArrA, i, i2, dVarA, aVarA);
        } finally {
            this.d.a(dVarA);
            this.f.a(aVarA);
        }
    }

    @Override // com.a.a.d.e
    public String a() {
        return "";
    }
}
