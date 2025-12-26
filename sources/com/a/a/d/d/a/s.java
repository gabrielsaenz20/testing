package com.a.a.d.d.a;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* loaded from: classes.dex */
public class s implements com.a.a.d.d.a.a<ParcelFileDescriptor> {
    private static final a a = new a();
    private a b;
    private int c;

    static class a {
        a() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    public s() {
        this(a, -1);
    }

    s(a aVar, int i) {
        this.b = aVar;
        this.c = i;
    }

    public Bitmap a(ParcelFileDescriptor parcelFileDescriptor, com.a.a.d.b.a.c cVar, int i, int i2, com.a.a.d.a aVar) throws IOException, IllegalArgumentException {
        MediaMetadataRetriever mediaMetadataRetrieverA = this.b.a();
        mediaMetadataRetrieverA.setDataSource(parcelFileDescriptor.getFileDescriptor());
        Bitmap frameAtTime = this.c >= 0 ? mediaMetadataRetrieverA.getFrameAtTime(this.c) : mediaMetadataRetrieverA.getFrameAtTime();
        mediaMetadataRetrieverA.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    @Override // com.a.a.d.d.a.a
    public String a() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
