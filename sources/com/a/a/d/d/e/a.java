package com.a.a.d.d.e;

import android.graphics.Bitmap;
import com.a.a.d.b.l;

/* loaded from: classes.dex */
public class a {
    private final l<com.a.a.d.d.d.b> a;
    private final l<Bitmap> b;

    public a(l<Bitmap> lVar, l<com.a.a.d.d.d.b> lVar2) {
        if (lVar != null && lVar2 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (lVar == null && lVar2 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        }
        this.b = lVar;
        this.a = lVar2;
    }

    public int a() {
        return (this.b != null ? this.b : this.a).c();
    }

    public l<Bitmap> b() {
        return this.b;
    }

    public l<com.a.a.d.d.d.b> c() {
        return this.a;
    }
}
