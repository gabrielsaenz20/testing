package com.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.a.a.e.c;
import com.a.a.e.l;
import com.a.a.e.m;

/* loaded from: classes.dex */
public class j implements com.a.a.e.h {
    private final Context a;
    private final com.a.a.e.g b;
    private final l c;
    private final m d;
    private final g e;
    private final c f;
    private a g;

    public interface a {
        <T> void a(com.a.a.c<T, ?, ?, ?> cVar);
    }

    public final class b<A, T> {
        private final com.a.a.d.c.l<A, T> b;
        private final Class<T> c;

        public final class a {
            private final A b;
            private final Class<A> c;
            private final boolean d = true;

            a(A a) {
                this.b = a;
                this.c = j.b(a);
            }

            public <Z> com.a.a.d<A, T, Z> a(Class<Z> cls) {
                com.a.a.d<A, T, Z> dVar = (com.a.a.d) j.this.f.a(new com.a.a.d(j.this.a, j.this.e, this.c, b.this.b, b.this.c, cls, j.this.d, j.this.b, j.this.f));
                if (this.d) {
                    dVar.b((com.a.a.d<A, T, Z>) this.b);
                }
                return dVar;
            }
        }

        b(com.a.a.d.c.l<A, T> lVar, Class<T> cls) {
            this.b = lVar;
            this.c = cls;
        }

        public b<A, T>.a a(A a2) {
            return new a(a2);
        }
    }

    class c {
        c() {
        }

        public <A, X extends com.a.a.c<A, ?, ?, ?>> X a(X x) {
            if (j.this.g != null) {
                j.this.g.a(x);
            }
            return x;
        }
    }

    private static class d implements c.a {
        private final m a;

        public d(m mVar) {
            this.a = mVar;
        }

        @Override // com.a.a.e.c.a
        public void a(boolean z) {
            if (z) {
                this.a.d();
            }
        }
    }

    public j(Context context, com.a.a.e.g gVar, l lVar) {
        this(context, gVar, lVar, new m(), new com.a.a.e.d());
    }

    j(Context context, final com.a.a.e.g gVar, l lVar, m mVar, com.a.a.e.d dVar) {
        this.a = context.getApplicationContext();
        this.b = gVar;
        this.c = lVar;
        this.d = mVar;
        this.e = g.a(context);
        this.f = new c();
        com.a.a.e.c cVarA = dVar.a(context, new d(mVar));
        if (com.a.a.j.h.c()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.a.a.j.1
                @Override // java.lang.Runnable
                public void run() {
                    gVar.a(j.this);
                }
            });
        } else {
            gVar.a(this);
        }
        gVar.a(cVarA);
    }

    private <T> com.a.a.b<T> a(Class<T> cls) {
        com.a.a.d.c.l lVarA = g.a(cls, this.a);
        com.a.a.d.c.l lVarB = g.b(cls, this.a);
        if (cls == null || lVarA != null || lVarB != null) {
            return (com.a.a.b) this.f.a(new com.a.a.b(cls, lVarA, lVarB, this.a, this.e, this.d, this.b, this.f));
        }
        throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call Glide#register with a ModelLoaderFactory for your custom model class");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> Class<T> b(T t) {
        if (t != null) {
            return (Class<T>) t.getClass();
        }
        return null;
    }

    public com.a.a.b<String> a(String str) {
        return (com.a.a.b) g().a((com.a.a.b<String>) str);
    }

    public <A, T> b<A, T> a(com.a.a.d.c.l<A, T> lVar, Class<T> cls) {
        return new b<>(lVar, cls);
    }

    public void a() {
        this.e.g();
    }

    public void a(int i) {
        this.e.a(i);
    }

    public void b() {
        com.a.a.j.h.a();
        this.d.a();
    }

    public void c() {
        com.a.a.j.h.a();
        this.d.b();
    }

    @Override // com.a.a.e.h
    public void d() {
        c();
    }

    @Override // com.a.a.e.h
    public void e() {
        b();
    }

    @Override // com.a.a.e.h
    public void f() {
        this.d.c();
    }

    public com.a.a.b<String> g() {
        return a(String.class);
    }
}
