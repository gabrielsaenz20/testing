package com.a.a.d.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.a.a.d.c.l;
import com.a.a.d.c.m;
import com.a.a.d.c.n;

/* loaded from: classes.dex */
public class c extends n<ParcelFileDescriptor> implements b<Integer> {

    public static class a implements m<Integer, ParcelFileDescriptor> {
        @Override // com.a.a.d.c.m
        public l<Integer, ParcelFileDescriptor> a(Context context, com.a.a.d.c.c cVar) {
            return new c(context, cVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.a.a.d.c.m
        public void a() {
        }
    }

    public c(Context context, l<Uri, ParcelFileDescriptor> lVar) {
        super(context, lVar);
    }
}
