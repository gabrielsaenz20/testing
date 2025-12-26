package com.a.a.d.d.d;

import android.content.Context;
import com.a.a.d.c.o;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class c implements com.a.a.g.b<InputStream, b> {
    private final i a;
    private final j b;
    private final o c = new o();
    private final com.a.a.d.d.c.c<b> d;

    public c(Context context, com.a.a.d.b.a.c cVar) {
        this.a = new i(context, cVar);
        this.d = new com.a.a.d.d.c.c<>(this.a);
        this.b = new j(cVar);
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, b> a() {
        return this.d;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<InputStream, b> b() {
        return this.a;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<InputStream> c() {
        return this.c;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<b> d() {
        return this.b;
    }
}
