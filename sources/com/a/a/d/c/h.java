package com.a.a.d.c;

import android.os.ParcelFileDescriptor;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class h implements com.a.a.d.b<g> {
    private final com.a.a.d.b<InputStream> a;
    private final com.a.a.d.b<ParcelFileDescriptor> b;
    private String c;

    public h(com.a.a.d.b<InputStream> bVar, com.a.a.d.b<ParcelFileDescriptor> bVar2) {
        this.a = bVar;
        this.b = bVar2;
    }

    @Override // com.a.a.d.b
    public String a() {
        if (this.c == null) {
            this.c = this.a.a() + this.b.a();
        }
        return this.c;
    }

    @Override // com.a.a.d.b
    public boolean a(g gVar, OutputStream outputStream) {
        com.a.a.d.b bVar;
        Closeable closeableB;
        if (gVar.a() != null) {
            bVar = this.a;
            closeableB = gVar.a();
        } else {
            bVar = this.b;
            closeableB = gVar.b();
        }
        return bVar.a(closeableB, outputStream);
    }
}
