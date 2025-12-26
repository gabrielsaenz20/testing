package com.a.a.d.b;

import java.security.MessageDigest;

/* loaded from: classes.dex */
class k implements com.a.a.d.c {
    private final String a;
    private final com.a.a.d.c b;

    public k(String str, com.a.a.d.c cVar) {
        this.a = str;
        this.b = cVar;
    }

    @Override // com.a.a.d.c
    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.a.getBytes("UTF-8"));
        this.b.a(messageDigest);
    }

    @Override // com.a.a.d.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.a.equals(kVar.a) && this.b.equals(kVar.b);
    }

    @Override // com.a.a.d.c
    public int hashCode() {
        return (31 * this.a.hashCode()) + this.b.hashCode();
    }
}
