package com.a.a.d.d.c;

import com.a.a.d.b.l;
import com.a.a.d.c.o;
import com.a.a.d.e;
import com.a.a.d.f;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class d implements com.a.a.g.b<InputStream, File> {
    private static final a a = new a();
    private final e<File, File> b = new com.a.a.d.d.c.a();
    private final com.a.a.d.b<InputStream> c = new o();

    private static class a implements e<InputStream, File> {
        private a() {
        }

        @Override // com.a.a.d.e
        public l<File> a(InputStream inputStream, int i, int i2) {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }

        @Override // com.a.a.d.e
        public String a() {
            return "";
        }
    }

    @Override // com.a.a.g.b
    public e<File, File> a() {
        return this.b;
    }

    @Override // com.a.a.g.b
    public e<InputStream, File> b() {
        return a;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<InputStream> c() {
        return this.c;
    }

    @Override // com.a.a.g.b
    public f<File> d() {
        return com.a.a.d.d.b.b();
    }
}
