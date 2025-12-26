package com.a.a.d.c.b;

import android.content.Context;
import com.a.a.d.c.l;
import com.a.a.d.c.m;
import java.io.InputStream;

/* loaded from: classes.dex */
public class b implements d<byte[]> {
    private final String a;

    public static class a implements m<byte[], InputStream> {
        @Override // com.a.a.d.c.m
        public l<byte[], InputStream> a(Context context, com.a.a.d.c.c cVar) {
            return new b();
        }

        @Override // com.a.a.d.c.m
        public void a() {
        }
    }

    public b() {
        this("");
    }

    @Deprecated
    public b(String str) {
        this.a = str;
    }

    @Override // com.a.a.d.c.l
    public com.a.a.d.a.c<InputStream> a(byte[] bArr, int i, int i2) {
        return new com.a.a.d.a.b(bArr, this.a);
    }
}
