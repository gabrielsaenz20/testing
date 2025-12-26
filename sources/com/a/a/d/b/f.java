package com.a.a.d.b;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
class f implements com.a.a.d.c {
    private final String a;
    private final int b;
    private final int c;
    private final com.a.a.d.e d;
    private final com.a.a.d.e e;
    private final com.a.a.d.g f;
    private final com.a.a.d.f g;
    private final com.a.a.d.d.f.c h;
    private final com.a.a.d.b i;
    private final com.a.a.d.c j;
    private String k;
    private int l;
    private com.a.a.d.c m;

    public f(String str, com.a.a.d.c cVar, int i, int i2, com.a.a.d.e eVar, com.a.a.d.e eVar2, com.a.a.d.g gVar, com.a.a.d.f fVar, com.a.a.d.d.f.c cVar2, com.a.a.d.b bVar) {
        this.a = str;
        this.j = cVar;
        this.b = i;
        this.c = i2;
        this.d = eVar;
        this.e = eVar2;
        this.f = gVar;
        this.g = fVar;
        this.h = cVar2;
        this.i = bVar;
    }

    public com.a.a.d.c a() {
        if (this.m == null) {
            this.m = new k(this.a, this.j);
        }
        return this.m;
    }

    @Override // com.a.a.d.c
    public void a(MessageDigest messageDigest) {
        byte[] bArrArray = ByteBuffer.allocate(8).putInt(this.b).putInt(this.c).array();
        this.j.a(messageDigest);
        messageDigest.update(this.a.getBytes("UTF-8"));
        messageDigest.update(bArrArray);
        messageDigest.update((this.d != null ? this.d.a() : "").getBytes("UTF-8"));
        messageDigest.update((this.e != null ? this.e.a() : "").getBytes("UTF-8"));
        messageDigest.update((this.f != null ? this.f.a() : "").getBytes("UTF-8"));
        messageDigest.update((this.g != null ? this.g.a() : "").getBytes("UTF-8"));
        messageDigest.update((this.i != null ? this.i.a() : "").getBytes("UTF-8"));
    }

    @Override // com.a.a.d.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (!this.a.equals(fVar.a) || !this.j.equals(fVar.j) || this.c != fVar.c || this.b != fVar.b) {
            return false;
        }
        if ((this.f == null) ^ (fVar.f == null)) {
            return false;
        }
        if (this.f != null && !this.f.a().equals(fVar.f.a())) {
            return false;
        }
        if ((this.e == null) ^ (fVar.e == null)) {
            return false;
        }
        if (this.e != null && !this.e.a().equals(fVar.e.a())) {
            return false;
        }
        if ((this.d == null) ^ (fVar.d == null)) {
            return false;
        }
        if (this.d != null && !this.d.a().equals(fVar.d.a())) {
            return false;
        }
        if ((this.g == null) ^ (fVar.g == null)) {
            return false;
        }
        if (this.g != null && !this.g.a().equals(fVar.g.a())) {
            return false;
        }
        if ((this.h == null) ^ (fVar.h == null)) {
            return false;
        }
        if (this.h != null && !this.h.a().equals(fVar.h.a())) {
            return false;
        }
        if ((this.i == null) ^ (fVar.i == null)) {
            return false;
        }
        return this.i == null || this.i.a().equals(fVar.i.a());
    }

    @Override // com.a.a.d.c
    public int hashCode() {
        if (this.l == 0) {
            this.l = this.a.hashCode();
            this.l = (this.l * 31) + this.j.hashCode();
            this.l = (this.l * 31) + this.b;
            this.l = (this.l * 31) + this.c;
            this.l = (this.l * 31) + (this.d != null ? this.d.a().hashCode() : 0);
            this.l = (this.l * 31) + (this.e != null ? this.e.a().hashCode() : 0);
            this.l = (this.l * 31) + (this.f != null ? this.f.a().hashCode() : 0);
            this.l = (this.l * 31) + (this.g != null ? this.g.a().hashCode() : 0);
            this.l = (this.l * 31) + (this.h != null ? this.h.a().hashCode() : 0);
            this.l = (31 * this.l) + (this.i != null ? this.i.a().hashCode() : 0);
        }
        return this.l;
    }

    public String toString() {
        if (this.k == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EngineKey{");
            sb.append(this.a);
            sb.append('+');
            sb.append(this.j);
            sb.append("+[");
            sb.append(this.b);
            sb.append('x');
            sb.append(this.c);
            sb.append("]+");
            sb.append('\'');
            sb.append(this.d != null ? this.d.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            sb.append(this.e != null ? this.e.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            sb.append(this.f != null ? this.f.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            sb.append(this.g != null ? this.g.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            sb.append(this.h != null ? this.h.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            sb.append(this.i != null ? this.i.a() : "");
            sb.append('\'');
            sb.append('}');
            this.k = sb.toString();
        }
        return this.k;
    }
}
