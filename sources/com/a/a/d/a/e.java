package com.a.a.d.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* loaded from: classes.dex */
public class e extends g<ParcelFileDescriptor> {
    public e(Context context, Uri uri) {
        super(context, uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.d.a.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor b(Uri uri, ContentResolver contentResolver) {
        return contentResolver.openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.d.a.g
    public void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }
}
