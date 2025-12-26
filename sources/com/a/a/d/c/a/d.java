package com.a.a.d.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.a.a.d.c.l;
import com.a.a.d.c.m;
import com.a.a.d.c.p;

/* loaded from: classes.dex */
public class d extends p<ParcelFileDescriptor> implements b<String> {

    public static class a implements m<String, ParcelFileDescriptor> {
        @Override // com.a.a.d.c.m
        public l<String, ParcelFileDescriptor> a(Context context, com.a.a.d.c.c cVar) {
            return new d(cVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.a.a.d.c.m
        public void a() {
        }
    }

    public d(l<Uri, ParcelFileDescriptor> lVar) {
        super(lVar);
    }
}
