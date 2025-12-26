package com.a.a.d.b.a;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
class a implements g {
    private final b a = new b();
    private final e<C0022a, Bitmap> b = new e<>();

    /* renamed from: com.a.a.d.b.a.a$a, reason: collision with other inner class name */
    static class C0022a implements h {
        private final b a;
        private int b;
        private int c;
        private Bitmap.Config d;

        public C0022a(b bVar) {
            this.a = bVar;
        }

        @Override // com.a.a.d.b.a.h
        public void a() {
            this.a.a(this);
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.b = i;
            this.c = i2;
            this.d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0022a)) {
                return false;
            }
            C0022a c0022a = (C0022a) obj;
            return this.b == c0022a.b && this.c == c0022a.c && this.d == c0022a.d;
        }

        public int hashCode() {
            return (31 * ((this.b * 31) + this.c)) + (this.d != null ? this.d.hashCode() : 0);
        }

        public String toString() {
            return a.d(this.b, this.c, this.d);
        }
    }

    static class b extends com.a.a.d.b.a.b<C0022a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.a.a.d.b.a.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0022a b() {
            return new C0022a(this);
        }

        public C0022a a(int i, int i2, Bitmap.Config config) {
            C0022a c0022aC = c();
            c0022aC.a(i, i2, config);
            return c0022aC;
        }
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    private static String d(Bitmap bitmap) {
        return d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.a.a.d.b.a.g
    public Bitmap a() {
        return this.b.a();
    }

    @Override // com.a.a.d.b.a.g
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.b.a((e<C0022a, Bitmap>) this.a.a(i, i2, config));
    }

    @Override // com.a.a.d.b.a.g
    public void a(Bitmap bitmap) {
        this.b.a(this.a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.a.a.d.b.a.g
    public String b(int i, int i2, Bitmap.Config config) {
        return d(i, i2, config);
    }

    @Override // com.a.a.d.b.a.g
    public String b(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.a.a.d.b.a.g
    public int c(Bitmap bitmap) {
        return com.a.a.j.h.a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }
}
