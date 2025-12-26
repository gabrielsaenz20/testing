package com.a.a.d.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.a.a.d.c.l;
import com.a.a.d.c.m;
import com.a.a.d.c.q;

/* loaded from: classes.dex */
public class e extends q<ParcelFileDescriptor> implements b<Uri> {

    public static class a implements m<Uri, ParcelFileDescriptor> {
        @Override // com.a.a.d.c.m
        public l<Uri, ParcelFileDescriptor> a(Context context, com.a.a.d.c.c cVar) {
            return new e(context, cVar.a(com.a.a.d.c.d.class, ParcelFileDescriptor.class));
        }

        @Override // com.a.a.d.c.m
        public void a() {
        }
    }

    public e(Context context, l<com.a.a.d.c.d, ParcelFileDescriptor> lVar) {
        super(context, lVar);
    }

    @Override // com.a.a.d.c.q
    protected com.a.a.d.a.c<ParcelFileDescriptor> a(Context context, Uri uri) {
        return new com.a.a.d.a.e(context, uri);
    }

    @Override // com.a.a.d.c.q
    protected com.a.a.d.a.c<ParcelFileDescriptor> a(Context context, String str) {
        return new com.a.a.d.a.d(context.getApplicationContext().getAssets(), str);
    }
}
