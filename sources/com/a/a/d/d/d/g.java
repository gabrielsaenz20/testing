package com.a.a.d.d.d;

import com.a.a.d.c.l;

/* loaded from: classes.dex */
class g implements l<com.a.a.b.a, com.a.a.b.a> {

    private static class a implements com.a.a.d.a.c<com.a.a.b.a> {
        private final com.a.a.b.a a;

        public a(com.a.a.b.a aVar) {
            this.a = aVar;
        }

        @Override // com.a.a.d.a.c
        public void a() {
        }

        @Override // com.a.a.d.a.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.a.a.b.a a(com.a.a.i iVar) {
            return this.a;
        }

        @Override // com.a.a.d.a.c
        public String b() {
            return String.valueOf(this.a.d());
        }

        @Override // com.a.a.d.a.c
        public void c() {
        }
    }

    g() {
    }

    @Override // com.a.a.d.c.l
    public com.a.a.d.a.c<com.a.a.b.a> a(com.a.a.b.a aVar, int i, int i2) {
        return new a(aVar);
    }
}
