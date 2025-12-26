package com.a.a.d.d.d;

import android.graphics.Bitmap;
import com.a.a.b.a;

/* loaded from: classes.dex */
class a implements a.InterfaceC0020a {
    private final com.a.a.d.b.a.c a;

    public a(com.a.a.d.b.a.c cVar) {
        this.a = cVar;
    }

    @Override // com.a.a.b.a.InterfaceC0020a
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.a.b(i, i2, config);
    }

    @Override // com.a.a.b.a.InterfaceC0020a
    public void a(Bitmap bitmap) {
        if (this.a.a(bitmap)) {
            return;
        }
        bitmap.recycle();
    }
}
