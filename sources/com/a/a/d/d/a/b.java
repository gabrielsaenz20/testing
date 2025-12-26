package com.a.a.d.d.a;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class b implements com.a.a.d.f<Bitmap> {
    private Bitmap.CompressFormat a;
    private int b;

    public b() {
        this(null, 90);
    }

    public b(Bitmap.CompressFormat compressFormat, int i) {
        this.a = compressFormat;
        this.b = i;
    }

    private Bitmap.CompressFormat a(Bitmap bitmap) {
        return this.a != null ? this.a : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // com.a.a.d.b
    public String a() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    @Override // com.a.a.d.b
    public boolean a(com.a.a.d.b.l<Bitmap> lVar, OutputStream outputStream) {
        Bitmap bitmapB = lVar.b();
        long jA = com.a.a.j.d.a();
        Bitmap.CompressFormat compressFormatA = a(bitmapB);
        bitmapB.compress(compressFormatA, this.b, outputStream);
        if (!Log.isLoggable("BitmapEncoder", 2)) {
            return true;
        }
        Log.v("BitmapEncoder", "Compressed with type: " + compressFormatA + " of size " + com.a.a.j.h.a(bitmapB) + " in " + com.a.a.j.d.a(jA));
        return true;
    }
}
