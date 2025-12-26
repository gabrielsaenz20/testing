package com.a.a.d.b;

import android.util.Log;
import com.a.a.d.b.b.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
class a<A, T, Z> {
    private static final b a = new b();
    private final f b;
    private final int c;
    private final int d;
    private final com.a.a.d.a.c<A> e;
    private final com.a.a.g.b<A, T> f;
    private final com.a.a.d.g<T> g;
    private final com.a.a.d.d.f.c<T, Z> h;
    private final InterfaceC0021a i;
    private final com.a.a.d.b.b j;
    private final com.a.a.i k;
    private final b l;
    private volatile boolean m;

    /* renamed from: com.a.a.d.b.a$a, reason: collision with other inner class name */
    interface InterfaceC0021a {
        com.a.a.d.b.b.a a();
    }

    static class b {
        b() {
        }

        public OutputStream a(File file) {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }

    class c<DataType> implements a.b {
        private final com.a.a.d.b<DataType> b;
        private final DataType c;

        public c(com.a.a.d.b<DataType> bVar, DataType datatype) {
            this.b = bVar;
            this.c = datatype;
        }

        @Override // com.a.a.d.b.b.a.b
        public boolean a(File file) throws Throwable {
            OutputStream outputStream = null;
            try {
                try {
                    OutputStream outputStreamA = a.this.l.a(file);
                    try {
                        boolean zA = this.b.a(this.c, outputStreamA);
                        if (outputStreamA == null) {
                            return zA;
                        }
                        try {
                            outputStreamA.close();
                            return zA;
                        } catch (IOException unused) {
                            return zA;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        outputStream = outputStreamA;
                        if (Log.isLoggable("DecodeJob", 3)) {
                            Log.d("DecodeJob", "Failed to find file to write to disk cache", e);
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        outputStream = outputStreamA;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            }
        }
    }

    public a(f fVar, int i, int i2, com.a.a.d.a.c<A> cVar, com.a.a.g.b<A, T> bVar, com.a.a.d.g<T> gVar, com.a.a.d.d.f.c<T, Z> cVar2, InterfaceC0021a interfaceC0021a, com.a.a.d.b.b bVar2, com.a.a.i iVar) {
        this(fVar, i, i2, cVar, bVar, gVar, cVar2, interfaceC0021a, bVar2, iVar, a);
    }

    a(f fVar, int i, int i2, com.a.a.d.a.c<A> cVar, com.a.a.g.b<A, T> bVar, com.a.a.d.g<T> gVar, com.a.a.d.d.f.c<T, Z> cVar2, InterfaceC0021a interfaceC0021a, com.a.a.d.b.b bVar2, com.a.a.i iVar, b bVar3) {
        this.b = fVar;
        this.c = i;
        this.d = i2;
        this.e = cVar;
        this.f = bVar;
        this.g = gVar;
        this.h = cVar2;
        this.i = interfaceC0021a;
        this.j = bVar2;
        this.k = iVar;
        this.l = bVar3;
    }

    private l<Z> a(l<T> lVar) {
        long jA = com.a.a.j.d.a();
        l<T> lVarC = c(lVar);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transformed resource from source", jA);
        }
        b((l) lVarC);
        long jA2 = com.a.a.j.d.a();
        l<Z> lVarD = d(lVarC);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transcoded transformed from source", jA2);
        }
        return lVarD;
    }

    private l<T> a(com.a.a.d.c cVar) {
        File fileA = this.i.a().a(cVar);
        if (fileA == null) {
            return null;
        }
        try {
            l<T> lVarA = this.f.a().a(fileA, this.c, this.d);
            if (lVarA == null) {
            }
            return lVarA;
        } finally {
            this.i.a().b(cVar);
        }
    }

    private l<T> a(A a2) {
        if (this.j.a()) {
            return b((a<A, T, Z>) a2);
        }
        long jA = com.a.a.j.d.a();
        l<T> lVarA = this.f.b().a(a2, this.c, this.d);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded from source", jA);
        }
        return lVarA;
    }

    private void a(String str, long j) {
        Log.v("DecodeJob", str + " in " + com.a.a.j.d.a(j) + ", key: " + this.b);
    }

    private l<T> b(A a2) {
        long jA = com.a.a.j.d.a();
        this.i.a().a(this.b.a(), new c(this.f.c(), a2));
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Wrote source to cache", jA);
        }
        long jA2 = com.a.a.j.d.a();
        l<T> lVarA = a(this.b.a());
        if (Log.isLoggable("DecodeJob", 2) && lVarA != null) {
            a("Decoded source from cache", jA2);
        }
        return lVarA;
    }

    private void b(l<T> lVar) {
        if (lVar == null || !this.j.b()) {
            return;
        }
        long jA = com.a.a.j.d.a();
        this.i.a().a(this.b, new c(this.f.d(), lVar));
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Wrote transformed from source to cache", jA);
        }
    }

    private l<T> c(l<T> lVar) {
        if (lVar == null) {
            return null;
        }
        l<T> lVarA = this.g.a(lVar, this.c, this.d);
        if (!lVar.equals(lVarA)) {
            lVar.d();
        }
        return lVarA;
    }

    private l<Z> d(l<T> lVar) {
        if (lVar == null) {
            return null;
        }
        return this.h.a(lVar);
    }

    private l<T> e() {
        try {
            long jA = com.a.a.j.d.a();
            A a2 = this.e.a(this.k);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Fetched data", jA);
            }
            if (this.m) {
                return null;
            }
            return a((a<A, T, Z>) a2);
        } finally {
            this.e.a();
        }
    }

    public l<Z> a() {
        if (!this.j.b()) {
            return null;
        }
        long jA = com.a.a.j.d.a();
        l<T> lVarA = a((com.a.a.d.c) this.b);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded transformed from cache", jA);
        }
        long jA2 = com.a.a.j.d.a();
        l<Z> lVarD = d(lVarA);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transcoded transformed from cache", jA2);
        }
        return lVarD;
    }

    public l<Z> b() {
        if (!this.j.a()) {
            return null;
        }
        long jA = com.a.a.j.d.a();
        l<T> lVarA = a(this.b.a());
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded source from cache", jA);
        }
        return a((l) lVarA);
    }

    public l<Z> c() {
        return a((l) e());
    }

    public void d() {
        this.m = true;
        this.e.c();
    }
}
