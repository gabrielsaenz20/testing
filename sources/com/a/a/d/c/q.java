package com.a.a.d.c;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes.dex */
public abstract class q<T> implements l<Uri, T> {
    private final Context a;
    private final l<d, T> b;

    public q(Context context, l<d, T> lVar) {
        this.a = context;
        this.b = lVar;
    }

    private static boolean a(String str) {
        return "file".equals(str) || "content".equals(str) || "android.resource".equals(str);
    }

    protected abstract com.a.a.d.a.c<T> a(Context context, Uri uri);

    protected abstract com.a.a.d.a.c<T> a(Context context, String str);

    @Override // com.a.a.d.c.l
    public final com.a.a.d.a.c<T> a(Uri uri, int i, int i2) {
        String scheme = uri.getScheme();
        if (a(scheme)) {
            if (!a.a(uri)) {
                return a(this.a, uri);
            }
            return a(this.a, a.b(uri));
        }
        if (this.b == null) {
            return null;
        }
        if ("http".equals(scheme) || "https".equals(scheme)) {
            return this.b.a(new d(uri.toString()), i, i2);
        }
        return null;
    }
}
