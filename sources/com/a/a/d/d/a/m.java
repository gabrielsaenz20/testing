package com.a.a.d.d.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class m implements com.a.a.d.e<com.a.a.d.c.g, Bitmap> {
    private final com.a.a.d.e<InputStream, Bitmap> a;
    private final com.a.a.d.e<ParcelFileDescriptor, Bitmap> b;

    public m(com.a.a.d.e<InputStream, Bitmap> eVar, com.a.a.d.e<ParcelFileDescriptor, Bitmap> eVar2) {
        this.a = eVar;
        this.b = eVar2;
    }

    @Override // com.a.a.d.e
    public com.a.a.d.b.l<Bitmap> a(com.a.a.d.c.g gVar, int i, int i2) {
        com.a.a.d.b.l<Bitmap> lVarA;
        ParcelFileDescriptor parcelFileDescriptorB;
        InputStream inputStreamA = gVar.a();
        if (inputStreamA != null) {
            try {
                lVarA = this.a.a(inputStreamA, i, i2);
            } catch (IOException e) {
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", e);
                }
            }
        } else {
            lVarA = null;
        }
        return (lVarA != null || (parcelFileDescriptorB = gVar.b()) == null) ? lVarA : this.b.a(parcelFileDescriptorB, i, i2);
    }

    @Override // com.a.a.d.e
    public String a() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
