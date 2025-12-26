package com.a.a;

import android.graphics.Bitmap;
import java.io.InputStream;

/* loaded from: classes.dex */
public class e<ModelType> extends c<ModelType, InputStream, com.a.a.d.d.d.b, com.a.a.d.d.d.b> {
    e(com.a.a.g.f<ModelType, InputStream, com.a.a.d.d.d.b, com.a.a.d.d.d.b> fVar, Class<com.a.a.d.d.d.b> cls, c<ModelType, ?, ?, ?> cVar) {
        super(fVar, cls, cVar);
    }

    private com.a.a.d.d.d.e[] c(com.a.a.d.g<Bitmap>[] gVarArr) {
        com.a.a.d.d.d.e[] eVarArr = new com.a.a.d.d.d.e[gVarArr.length];
        for (int i = 0; i < gVarArr.length; i++) {
            eVarArr[i] = new com.a.a.d.d.d.e(gVarArr[i], this.c.a());
        }
        return eVarArr;
    }

    public e<ModelType> a() {
        return a(this.c.c());
    }

    @Override // com.a.a.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e<ModelType> b(int i, int i2) {
        super.b(i, i2);
        return this;
    }

    @Override // com.a.a.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e<ModelType> b(com.a.a.d.b.b bVar) {
        super.b(bVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.a.a.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e<ModelType> b(com.a.a.d.b<InputStream> bVar) {
        super.b((com.a.a.d.b) bVar);
        return this;
    }

    @Override // com.a.a.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e<ModelType> b(com.a.a.d.c cVar) {
        super.b(cVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.a.a.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e<ModelType> b(com.a.a.d.e<InputStream, com.a.a.d.d.d.b> eVar) {
        super.b((com.a.a.d.e) eVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.a.a.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e<ModelType> b(com.a.a.h.a.d<com.a.a.d.d.d.b> dVar) {
        super.b((com.a.a.h.a.d) dVar);
        return this;
    }

    public e<ModelType> a(ModelType modeltype) {
        super.b((e<ModelType>) modeltype);
        return this;
    }

    @Override // com.a.a.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e<ModelType> b(boolean z) {
        super.b(z);
        return this;
    }

    public e<ModelType> a(com.a.a.d.d.a.d... dVarArr) {
        return b((com.a.a.d.g<com.a.a.d.d.d.b>[]) c(dVarArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.a.a.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e<ModelType> b(com.a.a.d.g<com.a.a.d.d.d.b>... gVarArr) {
        super.b((com.a.a.d.g[]) gVarArr);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.a.a.c
    public /* synthetic */ c b(Object obj) {
        return a((e<ModelType>) obj);
    }

    public e<ModelType> b() {
        return a(this.c.d());
    }

    public e<ModelType> c() {
        super.b((com.a.a.h.a.d) new com.a.a.h.a.a());
        return this;
    }

    @Override // com.a.a.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public e<ModelType> g() {
        return (e) super.g();
    }

    @Override // com.a.a.c
    void e() {
        b();
    }

    @Override // com.a.a.c
    void f() {
        a();
    }
}
