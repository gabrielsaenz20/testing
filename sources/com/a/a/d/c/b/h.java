package com.a.a.d.c.b;

import android.content.Context;
import com.a.a.d.c.l;
import com.a.a.d.c.m;
import com.a.a.d.c.r;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes.dex */
public class h extends r<InputStream> {

    public static class a implements m<URL, InputStream> {
        @Override // com.a.a.d.c.m
        public l<URL, InputStream> a(Context context, com.a.a.d.c.c cVar) {
            return new h(cVar.a(com.a.a.d.c.d.class, InputStream.class));
        }

        @Override // com.a.a.d.c.m
        public void a() {
        }
    }

    public h(l<com.a.a.d.c.d, InputStream> lVar) {
        super(lVar);
    }
}
