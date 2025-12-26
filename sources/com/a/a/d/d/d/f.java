package com.a.a.d.d.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.a.a.j;
import java.security.MessageDigest;
import java.util.UUID;

/* loaded from: classes.dex */
class f {
    private final b a;
    private final com.a.a.b.a b;
    private final Handler c;
    private boolean d;
    private boolean e;
    private com.a.a.c<com.a.a.b.a, com.a.a.b.a, Bitmap, Bitmap> f;
    private a g;
    private boolean h;

    static class a extends com.a.a.h.b.g<Bitmap> {
        private final Handler a;
        private final int b;
        private final long c;
        private Bitmap d;

        public a(Handler handler, int i, long j) {
            this.a = handler;
            this.b = i;
            this.c = j;
        }

        public Bitmap a() {
            return this.d;
        }

        public void a(Bitmap bitmap, com.a.a.h.a.c<? super Bitmap> cVar) {
            this.d = bitmap;
            this.a.sendMessageAtTime(this.a.obtainMessage(1, this), this.c);
        }

        @Override // com.a.a.h.b.j
        public /* bridge */ /* synthetic */ void a(Object obj, com.a.a.h.a.c cVar) {
            a((Bitmap) obj, (com.a.a.h.a.c<? super Bitmap>) cVar);
        }
    }

    public interface b {
        void b(int i);
    }

    private class c implements Handler.Callback {
        private c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                f.this.a((a) message.obj);
                return true;
            }
            if (message.what != 2) {
                return false;
            }
            com.a.a.g.a((a) message.obj);
            return false;
        }
    }

    static class d implements com.a.a.d.c {
        private final UUID a;

        public d() {
            this(UUID.randomUUID());
        }

        d(UUID uuid) {
            this.a = uuid;
        }

        @Override // com.a.a.d.c
        public void a(MessageDigest messageDigest) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.a.a.d.c
        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return ((d) obj).a.equals(this.a);
            }
            return false;
        }

        @Override // com.a.a.d.c
        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public f(Context context, b bVar, com.a.a.b.a aVar, int i, int i2) {
        this(bVar, aVar, null, a(context, aVar, i, i2, com.a.a.g.a(context).a()));
    }

    f(b bVar, com.a.a.b.a aVar, Handler handler, com.a.a.c<com.a.a.b.a, com.a.a.b.a, Bitmap, Bitmap> cVar) {
        this.d = false;
        this.e = false;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.a = bVar;
        this.b = aVar;
        this.c = handler;
        this.f = cVar;
    }

    private static com.a.a.c<com.a.a.b.a, com.a.a.b.a, Bitmap, Bitmap> a(Context context, com.a.a.b.a aVar, int i, int i2, com.a.a.d.b.a.c cVar) {
        h hVar = new h(cVar);
        g gVar = new g();
        return com.a.a.g.b(context).a(gVar, com.a.a.b.a.class).a((j.b) aVar).a(Bitmap.class).b(com.a.a.d.d.a.b()).b((com.a.a.d.e) hVar).b(true).b(com.a.a.d.b.b.NONE).b(i, i2);
    }

    private void e() {
        if (!this.d || this.e) {
            return;
        }
        this.e = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + this.b.b();
        this.b.a();
        this.f.b(new d()).a((com.a.a.c<com.a.a.b.a, com.a.a.b.a, Bitmap, Bitmap>) new a(this.c, this.b.d(), jUptimeMillis));
    }

    public void a() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.h = false;
        e();
    }

    void a(a aVar) {
        if (this.h) {
            this.c.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        a aVar2 = this.g;
        this.g = aVar;
        this.a.b(aVar.b);
        if (aVar2 != null) {
            this.c.obtainMessage(2, aVar2).sendToTarget();
        }
        this.e = false;
        e();
    }

    public void a(com.a.a.d.g<Bitmap> gVar) {
        if (gVar == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.f = this.f.b(gVar);
    }

    public void b() {
        this.d = false;
    }

    public void c() {
        b();
        if (this.g != null) {
            com.a.a.g.a(this.g);
            this.g = null;
        }
        this.h = true;
    }

    public Bitmap d() {
        if (this.g != null) {
            return this.g.a();
        }
        return null;
    }
}
