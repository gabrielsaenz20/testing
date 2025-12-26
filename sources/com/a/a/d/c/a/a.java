package com.a.a.d.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.a.a.d.c.l;
import com.a.a.d.c.m;
import java.io.File;

/* loaded from: classes.dex */
public class a extends com.a.a.d.c.b<ParcelFileDescriptor> implements b<File> {

    /* renamed from: com.a.a.d.c.a.a$a, reason: collision with other inner class name */
    public static class C0026a implements m<File, ParcelFileDescriptor> {
        @Override // com.a.a.d.c.m
        public l<File, ParcelFileDescriptor> a(Context context, com.a.a.d.c.c cVar) {
            return new a(cVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.a.a.d.c.m
        public void a() {
        }
    }

    public a(l<Uri, ParcelFileDescriptor> lVar) {
        super(lVar);
    }
}
