package com.a.a.d.c.b;

import android.content.Context;
import android.net.Uri;
import com.a.a.d.c.l;
import com.a.a.d.c.m;
import com.a.a.d.c.n;
import java.io.InputStream;

/* loaded from: classes.dex */
public class e extends n<InputStream> implements d<Integer> {

    public static class a implements m<Integer, InputStream> {
        @Override // com.a.a.d.c.m
        public l<Integer, InputStream> a(Context context, com.a.a.d.c.c cVar) {
            return new e(context, cVar.a(Uri.class, InputStream.class));
        }

        @Override // com.a.a.d.c.m
        public void a() {
        }
    }

    public e(Context context, l<Uri, InputStream> lVar) {
        super(context, lVar);
    }
}
