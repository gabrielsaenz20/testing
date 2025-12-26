package com.a.a.d.a;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public class b implements c<InputStream> {
    private final byte[] a;
    private final String b;

    public b(byte[] bArr, String str) {
        this.a = bArr;
        this.b = str;
    }

    @Override // com.a.a.d.a.c
    public void a() {
    }

    @Override // com.a.a.d.a.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InputStream a(com.a.a.i iVar) {
        return new ByteArrayInputStream(this.a);
    }

    @Override // com.a.a.d.a.c
    public String b() {
        return this.b;
    }

    @Override // com.a.a.d.a.c
    public void c() {
    }
}
