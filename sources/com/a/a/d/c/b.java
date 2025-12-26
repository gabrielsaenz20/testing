package com.a.a.d.c;

import android.net.Uri;
import java.io.File;

/* loaded from: classes.dex */
public class b<T> implements l<File, T> {
    private final l<Uri, T> a;

    public b(l<Uri, T> lVar) {
        this.a = lVar;
    }

    @Override // com.a.a.d.c.l
    public com.a.a.d.a.c<T> a(File file, int i, int i2) {
        return this.a.a(Uri.fromFile(file), i, i2);
    }
}
