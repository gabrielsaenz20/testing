package com.a.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.a.a.e.m;

/* loaded from: classes.dex */
public class c<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    private boolean A;
    private Drawable B;
    private int C;
    protected final Class<ModelType> a;
    protected final Context b;
    protected final g c;
    protected final Class<TranscodeType> d;
    protected final m e;
    protected final com.a.a.e.g f;
    private com.a.a.g.a<ModelType, DataType, ResourceType, TranscodeType> g;
    private ModelType h;
    private com.a.a.d.c i;
    private boolean j;
    private int k;
    private int l;
    private com.a.a.h.d<? super ModelType, TranscodeType> m;
    private Float n;
    private c<?, ?, ?, TranscodeType> o;
    private Float p;
    private Drawable q;
    private Drawable r;
    private i s;
    private boolean t;
    private com.a.a.h.a.d<TranscodeType> u;
    private int v;
    private int w;
    private com.a.a.d.b.b x;
    private com.a.a.d.g<ResourceType> y;
    private boolean z;

    /* renamed from: com.a.a.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    c(Context context, Class<ModelType> cls, com.a.a.g.f<ModelType, DataType, ResourceType, TranscodeType> fVar, Class<TranscodeType> cls2, g gVar, m mVar, com.a.a.e.g gVar2) {
        this.i = com.a.a.i.a.a();
        this.p = Float.valueOf(1.0f);
        this.s = null;
        this.t = true;
        this.u = com.a.a.h.a.e.a();
        this.v = -1;
        this.w = -1;
        this.x = com.a.a.d.b.b.RESULT;
        this.y = com.a.a.d.d.d.b();
        this.b = context;
        this.a = cls;
        this.d = cls2;
        this.c = gVar;
        this.e = mVar;
        this.f = gVar2;
        this.g = fVar != null ? new com.a.a.g.a<>(fVar) : null;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        }
        if (cls != null && fVar == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    c(com.a.a.g.f<ModelType, DataType, ResourceType, TranscodeType> fVar, Class<TranscodeType> cls, c<ModelType, ?, ?, ?> cVar) {
        this(cVar.b, cVar.a, fVar, cls, cVar.c, cVar.e, cVar.f);
        this.h = cVar.h;
        this.j = cVar.j;
        this.i = cVar.i;
        this.x = cVar.x;
        this.t = cVar.t;
    }

    private com.a.a.h.b a(com.a.a.h.b.j<TranscodeType> jVar, float f, i iVar, com.a.a.h.c cVar) {
        return com.a.a.h.a.a(this.g, this.h, this.i, this.b, iVar, jVar, f, this.q, this.k, this.r, this.l, this.B, this.C, this.m, cVar, this.c.b(), this.y, this.d, this.t, this.u, this.w, this.v, this.x);
    }

    private com.a.a.h.b a(com.a.a.h.b.j<TranscodeType> jVar, com.a.a.h.f fVar) {
        if (this.o == null) {
            if (this.n == null) {
                return a(jVar, this.p.floatValue(), this.s, fVar);
            }
            com.a.a.h.f fVar2 = new com.a.a.h.f(fVar);
            fVar2.a(a(jVar, this.p.floatValue(), this.s, fVar2), a(jVar, this.n.floatValue(), a(), fVar2));
            return fVar2;
        }
        if (this.A) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (this.o.u.equals(com.a.a.h.a.e.a())) {
            this.o.u = this.u;
        }
        if (this.o.s == null) {
            this.o.s = a();
        }
        if (com.a.a.j.h.a(this.w, this.v) && !com.a.a.j.h.a(this.o.w, this.o.v)) {
            this.o.b(this.w, this.v);
        }
        com.a.a.h.f fVar3 = new com.a.a.h.f(fVar);
        com.a.a.h.b bVarA = a(jVar, this.p.floatValue(), this.s, fVar3);
        this.A = true;
        com.a.a.h.b bVarA2 = this.o.a(jVar, fVar3);
        this.A = false;
        fVar3.a(bVarA, bVarA2);
        return fVar3;
    }

    private i a() {
        return this.s == i.LOW ? i.NORMAL : this.s == i.NORMAL ? i.HIGH : i.IMMEDIATE;
    }

    private com.a.a.h.b b(com.a.a.h.b.j<TranscodeType> jVar) {
        if (this.s == null) {
            this.s = i.NORMAL;
        }
        return a(jVar, null);
    }

    public com.a.a.h.b.j<TranscodeType> a(ImageView imageView) {
        com.a.a.j.h.a();
        if (imageView == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (!this.z && imageView.getScaleType() != null) {
            switch (AnonymousClass1.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    f();
                    break;
                case 2:
                case 3:
                case 4:
                    e();
                    break;
            }
        }
        return a((c<ModelType, DataType, ResourceType, TranscodeType>) this.c.a(imageView, this.d));
    }

    public <Y extends com.a.a.h.b.j<TranscodeType>> Y a(Y y) {
        com.a.a.j.h.a();
        if (y == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        }
        if (!this.j) {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        com.a.a.h.b bVarC = y.c();
        if (bVarC != null) {
            bVarC.d();
            this.e.b(bVarC);
            bVarC.a();
        }
        com.a.a.h.b bVarB = b((com.a.a.h.b.j) y);
        y.a(bVarB);
        this.f.a(y);
        this.e.a(bVarB);
        return y;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> b(int i, int i2) {
        if (!com.a.a.j.h.a(i, i2)) {
            throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
        }
        this.w = i;
        this.v = i2;
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> b(com.a.a.d.b.b bVar) {
        this.x = bVar;
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> b(com.a.a.d.b<DataType> bVar) {
        if (this.g != null) {
            this.g.a(bVar);
        }
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> b(com.a.a.d.c cVar) {
        if (cVar == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.i = cVar;
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> b(com.a.a.d.e<DataType, ResourceType> eVar) {
        if (this.g != null) {
            this.g.a(eVar);
        }
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> b(com.a.a.h.a.d<TranscodeType> dVar) {
        if (dVar == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.u = dVar;
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> b(ModelType modeltype) {
        this.h = modeltype;
        this.j = true;
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> b(boolean z) {
        this.t = !z;
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> b(com.a.a.d.g<ResourceType>... gVarArr) {
        this.z = true;
        if (gVarArr.length == 1) {
            this.y = gVarArr[0];
            return this;
        }
        this.y = new com.a.a.d.d(gVarArr);
        return this;
    }

    void e() {
    }

    void f() {
    }

    @Override // 
    public c<ModelType, DataType, ResourceType, TranscodeType> g() {
        try {
            c<ModelType, DataType, ResourceType, TranscodeType> cVar = (c) super.clone();
            cVar.g = this.g != null ? this.g.clone() : null;
            return cVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
