package com.a.a.d.c.b;

import android.content.Context;
import android.net.Uri;
import com.a.a.d.a.i;
import com.a.a.d.c.l;
import com.a.a.d.c.m;
import com.a.a.d.c.q;
import java.io.InputStream;

/* loaded from: classes.dex */
public class g extends q<InputStream> implements d<Uri> {

    public static class a implements m<Uri, InputStream> {
        @Override // com.a.a.d.c.m
        public l<Uri, InputStream> a(Context context, com.a.a.d.c.c cVar) {
            return new g(context, cVar.a(com.a.a.d.c.d.class, InputStream.class));
        }

        @Override // com.a.a.d.c.m
        public void a() {
        }
    }

    public g(Context context, l<com.a.a.d.c.d, InputStream> lVar) {
        super(context, lVar);
    }

    @Override // com.a.a.d.c.q
    protected com.a.a.d.a.c<InputStream> a(Context context, Uri uri) {
        return new i(context, uri);
    }

    @Override // com.a.a.d.c.q
    protected com.a.a.d.a.c<InputStream> a(Context context, String str) {
        return new com.a.a.d.a.h(context.getApplicationContext().getAssets(), str);
    }
}
