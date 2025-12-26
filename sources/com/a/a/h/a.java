package com.a.a.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.a.a.d.b.c;
import com.a.a.d.b.l;
import com.a.a.d.g;
import com.a.a.h.b.h;
import com.a.a.h.b.j;
import com.a.a.i;
import java.util.Queue;

/* loaded from: classes.dex */
public final class a<A, T, Z, R> implements b, h, e {
    private static final Queue<a<?, ?, ?, ?>> a = com.a.a.j.h.a(0);
    private l<?> A;
    private c.C0025c B;
    private long C;
    private EnumC0028a D;
    private final String b = String.valueOf(hashCode());
    private com.a.a.d.c c;
    private Drawable d;
    private int e;
    private int f;
    private int g;
    private Context h;
    private g<Z> i;
    private com.a.a.g.f<A, T, Z, R> j;
    private c k;
    private A l;
    private Class<R> m;
    private boolean n;
    private i o;
    private j<R> p;
    private d<? super A, R> q;
    private float r;
    private com.a.a.d.b.c s;
    private com.a.a.h.a.d<R> t;
    private int u;
    private int v;
    private com.a.a.d.b.b w;
    private Drawable x;
    private Drawable y;
    private boolean z;

    /* renamed from: com.a.a.h.a$a, reason: collision with other inner class name */
    private enum EnumC0028a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    private a() {
    }

    public static <A, T, Z, R> a<A, T, Z, R> a(com.a.a.g.f<A, T, Z, R> fVar, A a2, com.a.a.d.c cVar, Context context, i iVar, j<R> jVar, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, d<? super A, R> dVar, c cVar2, com.a.a.d.b.c cVar3, g<Z> gVar, Class<R> cls, boolean z, com.a.a.h.a.d<R> dVar2, int i4, int i5, com.a.a.d.b.b bVar) {
        a<A, T, Z, R> aVar = (a) a.poll();
        if (aVar == null) {
            aVar = new a<>();
        }
        aVar.b(fVar, a2, cVar, context, iVar, jVar, f, drawable, i, drawable2, i2, drawable3, i3, dVar, cVar2, cVar3, gVar, cls, z, dVar2, i4, i5, bVar);
        return aVar;
    }

    private void a(l<?> lVar, R r) {
        boolean zP = p();
        this.D = EnumC0028a.COMPLETE;
        this.A = lVar;
        if (this.q == null || !this.q.a(r, this.l, this.p, this.z, zP)) {
            this.p.a((j<R>) r, (com.a.a.h.a.c<? super j<R>>) this.t.a(this.z, zP));
        }
        q();
        if (Log.isLoggable("GenericRequest", 2)) {
            a("Resource ready in " + com.a.a.j.d.a(this.C) + " size: " + (lVar.c() * 9.5367431640625E-7d) + " fromCache: " + this.z);
        }
    }

    private void a(String str) {
        Log.v("GenericRequest", str + " this: " + this.b);
    }

    private static void a(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(" must not be null");
            if (str2 != null) {
                sb.append(", ");
                sb.append(str2);
            }
            throw new NullPointerException(sb.toString());
        }
    }

    private void b(l lVar) {
        this.s.a(lVar);
        this.A = null;
    }

    private void b(com.a.a.g.f<A, T, Z, R> fVar, A a2, com.a.a.d.c cVar, Context context, i iVar, j<R> jVar, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, d<? super A, R> dVar, c cVar2, com.a.a.d.b.c cVar3, g<Z> gVar, Class<R> cls, boolean z, com.a.a.h.a.d<R> dVar2, int i4, int i5, com.a.a.d.b.b bVar) {
        String str;
        Object objB;
        String str2;
        this.j = fVar;
        this.l = a2;
        this.c = cVar;
        this.d = drawable3;
        this.e = i3;
        this.h = context.getApplicationContext();
        this.o = iVar;
        this.p = jVar;
        this.r = f;
        this.x = drawable;
        this.f = i;
        this.y = drawable2;
        this.g = i2;
        this.q = dVar;
        this.k = cVar2;
        this.s = cVar3;
        this.i = gVar;
        this.m = cls;
        this.n = z;
        this.t = dVar2;
        this.u = i4;
        this.v = i5;
        this.w = bVar;
        this.D = EnumC0028a.PENDING;
        if (a2 != null) {
            a("ModelLoader", fVar.e(), "try .using(ModelLoader)");
            a("Transcoder", fVar.f(), "try .as*(Class).transcode(ResourceTranscoder)");
            a("Transformation", gVar, "try .transform(UnitTransformation.get())");
            if (bVar.a()) {
                str = "SourceEncoder";
                objB = fVar.c();
                str2 = "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)";
            } else {
                str = "SourceDecoder";
                objB = fVar.b();
                str2 = "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)";
            }
            a(str, objB, str2);
            if (bVar.a() || bVar.b()) {
                a("CacheDecoder", fVar.a(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (bVar.b()) {
                a("Encoder", fVar.d(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private void b(Exception exc) {
        if (o()) {
            Drawable drawableK = this.l == null ? k() : null;
            if (drawableK == null) {
                drawableK = l();
            }
            if (drawableK == null) {
                drawableK = m();
            }
            this.p.a(exc, drawableK);
        }
    }

    private Drawable k() {
        if (this.d == null && this.e > 0) {
            this.d = this.h.getResources().getDrawable(this.e);
        }
        return this.d;
    }

    private Drawable l() {
        if (this.y == null && this.g > 0) {
            this.y = this.h.getResources().getDrawable(this.g);
        }
        return this.y;
    }

    private Drawable m() {
        if (this.x == null && this.f > 0) {
            this.x = this.h.getResources().getDrawable(this.f);
        }
        return this.x;
    }

    private boolean n() {
        return this.k == null || this.k.a(this);
    }

    private boolean o() {
        return this.k == null || this.k.b(this);
    }

    private boolean p() {
        return this.k == null || !this.k.c();
    }

    private void q() {
        if (this.k != null) {
            this.k.c(this);
        }
    }

    @Override // com.a.a.h.b
    public void a() {
        this.j = null;
        this.l = null;
        this.h = null;
        this.p = null;
        this.x = null;
        this.y = null;
        this.d = null;
        this.q = null;
        this.k = null;
        this.i = null;
        this.t = null;
        this.z = false;
        this.B = null;
        a.offer(this);
    }

    @Override // com.a.a.h.b.h
    public void a(int i, int i2) {
        if (Log.isLoggable("GenericRequest", 2)) {
            a("Got onSizeReady in " + com.a.a.j.d.a(this.C));
        }
        if (this.D != EnumC0028a.WAITING_FOR_SIZE) {
            return;
        }
        this.D = EnumC0028a.RUNNING;
        int iRound = Math.round(this.r * i);
        int iRound2 = Math.round(this.r * i2);
        com.a.a.d.a.c<T> cVarA = this.j.e().a(this.l, iRound, iRound2);
        if (cVarA == null) {
            a(new Exception("Failed to load model: '" + this.l + "'"));
            return;
        }
        com.a.a.d.d.f.c<Z, R> cVarF = this.j.f();
        if (Log.isLoggable("GenericRequest", 2)) {
            a("finished setup for calling load in " + com.a.a.j.d.a(this.C));
        }
        this.z = true;
        this.B = this.s.a(this.c, iRound, iRound2, cVarA, this.j, this.i, cVarF, this.o, this.n, this.w, this);
        this.z = this.A != null;
        if (Log.isLoggable("GenericRequest", 2)) {
            a("finished onSizeReady in " + com.a.a.j.d.a(this.C));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.a.a.h.e
    public void a(l<?> lVar) {
        if (lVar == null) {
            a(new Exception("Expected to receive a Resource<R> with an object of " + this.m + " inside, but instead got null."));
            return;
        }
        Object objB = lVar.b();
        if (objB != null && this.m.isAssignableFrom(objB.getClass())) {
            if (n()) {
                a(lVar, (l<?>) objB);
                return;
            } else {
                b(lVar);
                this.D = EnumC0028a.COMPLETE;
                return;
            }
        }
        b(lVar);
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to receive an object of ");
        sb.append(this.m);
        sb.append(" but instead got ");
        sb.append(objB != null ? objB.getClass() : "");
        sb.append("{");
        sb.append(objB);
        sb.append("}");
        sb.append(" inside Resource{");
        sb.append(lVar);
        sb.append("}.");
        sb.append(objB != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
        a(new Exception(sb.toString()));
    }

    @Override // com.a.a.h.e
    public void a(Exception exc) {
        if (Log.isLoggable("GenericRequest", 3)) {
            Log.d("GenericRequest", "load failed", exc);
        }
        this.D = EnumC0028a.FAILED;
        if (this.q == null || !this.q.a(exc, this.l, this.p, p())) {
            b(exc);
        }
    }

    @Override // com.a.a.h.b
    public void b() {
        this.C = com.a.a.j.d.a();
        if (this.l == null) {
            a((Exception) null);
            return;
        }
        this.D = EnumC0028a.WAITING_FOR_SIZE;
        if (com.a.a.j.h.a(this.u, this.v)) {
            a(this.u, this.v);
        } else {
            this.p.a((h) this);
        }
        if (!g() && !j() && o()) {
            this.p.c(m());
        }
        if (Log.isLoggable("GenericRequest", 2)) {
            a("finished run method in " + com.a.a.j.d.a(this.C));
        }
    }

    void c() {
        this.D = EnumC0028a.CANCELLED;
        if (this.B != null) {
            this.B.a();
            this.B = null;
        }
    }

    @Override // com.a.a.h.b
    public void d() {
        com.a.a.j.h.a();
        if (this.D == EnumC0028a.CLEARED) {
            return;
        }
        c();
        if (this.A != null) {
            b(this.A);
        }
        if (o()) {
            this.p.b(m());
        }
        this.D = EnumC0028a.CLEARED;
    }

    @Override // com.a.a.h.b
    public void e() {
        d();
        this.D = EnumC0028a.PAUSED;
    }

    @Override // com.a.a.h.b
    public boolean f() {
        return this.D == EnumC0028a.RUNNING || this.D == EnumC0028a.WAITING_FOR_SIZE;
    }

    @Override // com.a.a.h.b
    public boolean g() {
        return this.D == EnumC0028a.COMPLETE;
    }

    @Override // com.a.a.h.b
    public boolean h() {
        return g();
    }

    @Override // com.a.a.h.b
    public boolean i() {
        return this.D == EnumC0028a.CANCELLED || this.D == EnumC0028a.CLEARED;
    }

    public boolean j() {
        return this.D == EnumC0028a.FAILED;
    }
}
