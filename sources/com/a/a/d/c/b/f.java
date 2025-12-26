package com.a.a.d.c.b;

import android.content.Context;
import android.net.Uri;
import com.a.a.d.c.l;
import com.a.a.d.c.m;
import com.a.a.d.c.p;
import java.io.InputStream;

/* loaded from: classes.dex */
public class f extends p<InputStream> implements d<String> {

    public static class a implements m<String, InputStream> {
        @Override // com.a.a.d.c.m
        public l<String, InputStream> a(Context context, com.a.a.d.c.c cVar) {
            return new f(cVar.a(Uri.class, InputStream.class));
        }

        @Override // com.a.a.d.c.m
        public void a() {
        }
    }

    public f(l<Uri, InputStream> lVar) {
        super(lVar);
    }
}
