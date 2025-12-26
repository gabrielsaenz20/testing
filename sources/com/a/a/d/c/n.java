package com.a.a.d.c;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

/* loaded from: classes.dex */
public class n<T> implements l<Integer, T> {
    private final l<Uri, T> a;
    private final Resources b;

    public n(Context context, l<Uri, T> lVar) {
        this(context.getResources(), lVar);
    }

    public n(Resources resources, l<Uri, T> lVar) {
        this.b = resources;
        this.a = lVar;
    }

    @Override // com.a.a.d.c.l
    public com.a.a.d.a.c<T> a(Integer num, int i, int i2) {
        Uri uri;
        try {
            uri = Uri.parse("android.resource://" + this.b.getResourcePackageName(num.intValue()) + '/' + this.b.getResourceTypeName(num.intValue()) + '/' + this.b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            }
            uri = null;
        }
        if (uri != null) {
            return this.a.a(uri, i, i2);
        }
        return null;
    }
}
