package com.a.a.d.c.b;

import android.content.Context;
import android.net.Uri;
import com.a.a.d.c.l;
import com.a.a.d.c.m;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class c extends com.a.a.d.c.b<InputStream> implements d<File> {

    public static class a implements m<File, InputStream> {
        @Override // com.a.a.d.c.m
        public l<File, InputStream> a(Context context, com.a.a.d.c.c cVar) {
            return new c(cVar.a(Uri.class, InputStream.class));
        }

        @Override // com.a.a.d.c.m
        public void a() {
        }
    }

    public c(l<Uri, InputStream> lVar) {
        super(lVar);
    }
}
