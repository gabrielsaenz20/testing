package com.a.a.d.c;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes.dex */
public class p<T> implements l<String, T> {
    private final l<Uri, T> a;

    public p(l<Uri, T> lVar) {
        this.a = lVar;
    }

    private static Uri a(String str) {
        return Uri.fromFile(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0010  */
    @Override // com.a.a.d.c.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.a.a.d.a.c<T> a(String str, int i, int i2) {
        Uri uriA;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("/")) {
            uriA = a(str);
        } else {
            Uri uri = Uri.parse(str);
            if (uri.getScheme() != null) {
                uriA = uri;
            }
        }
        return this.a.a(uriA, i, i2);
    }
}
