package com.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import com.a.a.d.c.a.a;
import com.a.a.d.c.a.c;
import com.a.a.d.c.a.d;
import com.a.a.d.c.a.e;
import com.a.a.d.c.b.a;
import com.a.a.d.c.b.b;
import com.a.a.d.c.b.c;
import com.a.a.d.c.b.e;
import com.a.a.d.c.b.f;
import com.a.a.d.c.b.g;
import com.a.a.d.c.b.h;
import com.a.a.d.c.l;
import com.a.a.d.c.m;
import com.a.a.d.d.a.n;
import com.a.a.d.d.a.p;
import com.a.a.e.k;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class g {
    private static volatile g a = null;
    private static boolean b = true;
    private final com.a.a.d.c.c c;
    private final com.a.a.d.b.c d;
    private final com.a.a.d.b.a.c e;
    private final com.a.a.d.b.b.h f;
    private final com.a.a.d.a g;
    private final com.a.a.d.d.a.e k;
    private final com.a.a.d.d.e.f l;
    private final com.a.a.d.d.a.i m;
    private final com.a.a.d.d.e.f n;
    private final com.a.a.d.b.d.a p;
    private final com.a.a.h.b.f h = new com.a.a.h.b.f();
    private final com.a.a.d.d.f.d i = new com.a.a.d.d.f.d();
    private final Handler o = new Handler(Looper.getMainLooper());
    private final com.a.a.g.c j = new com.a.a.g.c();

    g(com.a.a.d.b.c cVar, com.a.a.d.b.b.h hVar, com.a.a.d.b.a.c cVar2, Context context, com.a.a.d.a aVar) {
        this.d = cVar;
        this.e = cVar2;
        this.f = hVar;
        this.g = aVar;
        this.c = new com.a.a.d.c.c(context);
        this.p = new com.a.a.d.b.d.a(hVar, cVar2, aVar);
        p pVar = new p(cVar2, aVar);
        this.j.a(InputStream.class, Bitmap.class, pVar);
        com.a.a.d.d.a.g gVar = new com.a.a.d.d.a.g(cVar2, aVar);
        this.j.a(ParcelFileDescriptor.class, Bitmap.class, gVar);
        n nVar = new n(pVar, gVar);
        this.j.a(com.a.a.d.c.g.class, Bitmap.class, nVar);
        com.a.a.d.d.d.c cVar3 = new com.a.a.d.d.d.c(context, cVar2);
        this.j.a(InputStream.class, com.a.a.d.d.d.b.class, cVar3);
        this.j.a(com.a.a.d.c.g.class, com.a.a.d.d.e.a.class, new com.a.a.d.d.e.g(nVar, cVar3, cVar2));
        this.j.a(InputStream.class, File.class, new com.a.a.d.d.c.d());
        a(File.class, ParcelFileDescriptor.class, new a.C0026a());
        a(File.class, InputStream.class, new c.a());
        a(Integer.TYPE, ParcelFileDescriptor.class, new c.a());
        a(Integer.TYPE, InputStream.class, new e.a());
        a(Integer.class, ParcelFileDescriptor.class, new c.a());
        a(Integer.class, InputStream.class, new e.a());
        a(String.class, ParcelFileDescriptor.class, new d.a());
        a(String.class, InputStream.class, new f.a());
        a(Uri.class, ParcelFileDescriptor.class, new e.a());
        a(Uri.class, InputStream.class, new g.a());
        a(URL.class, InputStream.class, new h.a());
        a(com.a.a.d.c.d.class, InputStream.class, new a.C0027a());
        a(byte[].class, InputStream.class, new b.a());
        this.i.a(Bitmap.class, com.a.a.d.d.a.j.class, new com.a.a.d.d.f.b(context.getResources(), cVar2));
        this.i.a(com.a.a.d.d.e.a.class, com.a.a.d.d.b.b.class, new com.a.a.d.d.f.a(new com.a.a.d.d.f.b(context.getResources(), cVar2)));
        this.k = new com.a.a.d.d.a.e(cVar2);
        this.l = new com.a.a.d.d.e.f(cVar2, this.k);
        this.m = new com.a.a.d.d.a.i(cVar2);
        this.n = new com.a.a.d.d.e.f(cVar2, this.m);
    }

    public static <T> l<T, InputStream> a(Class<T> cls, Context context) {
        return a(cls, InputStream.class, context);
    }

    public static <T, Y> l<T, Y> a(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls != null) {
            return a(context).h().a(cls, cls2);
        }
        if (!Log.isLoggable("Glide", 3)) {
            return null;
        }
        Log.d("Glide", "Unable to load null model, setting placeholder only");
        return null;
    }

    public static g a(Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    Context applicationContext = context.getApplicationContext();
                    h hVar = new h(applicationContext);
                    List<com.a.a.f.a> listC = c(applicationContext);
                    Iterator<com.a.a.f.a> it = listC.iterator();
                    while (it.hasNext()) {
                        it.next().a(applicationContext, hVar);
                    }
                    a = hVar.a();
                    Iterator<com.a.a.f.a> it2 = listC.iterator();
                    while (it2.hasNext()) {
                        it2.next().a(applicationContext, a);
                    }
                }
            }
        }
        return a;
    }

    public static j a(FragmentActivity fragmentActivity) {
        return k.a().a(fragmentActivity);
    }

    public static void a(com.a.a.h.b.j<?> jVar) {
        com.a.a.j.h.a();
        com.a.a.h.b bVarC = jVar.c();
        if (bVarC != null) {
            bVarC.d();
            jVar.a((com.a.a.h.b) null);
        }
    }

    public static <T> l<T, ParcelFileDescriptor> b(Class<T> cls, Context context) {
        return a(cls, ParcelFileDescriptor.class, context);
    }

    public static j b(Context context) {
        return k.a().a(context);
    }

    private static List<com.a.a.f.a> c(Context context) {
        return b ? new com.a.a.f.b(context).a() : Collections.emptyList();
    }

    private com.a.a.d.c.c h() {
        return this.c;
    }

    public com.a.a.d.b.a.c a() {
        return this.e;
    }

    <Z, R> com.a.a.d.d.f.c<Z, R> a(Class<Z> cls, Class<R> cls2) {
        return this.i.a(cls, cls2);
    }

    <R> com.a.a.h.b.j<R> a(ImageView imageView, Class<R> cls) {
        return this.h.a(imageView, cls);
    }

    public void a(int i) {
        com.a.a.j.h.a();
        this.f.a(i);
        this.e.a(i);
    }

    public <T, Y> void a(Class<T> cls, Class<Y> cls2, m<T, Y> mVar) {
        m<T, Y> mVarA = this.c.a(cls, cls2, mVar);
        if (mVarA != null) {
            mVarA.a();
        }
    }

    com.a.a.d.b.c b() {
        return this.d;
    }

    <T, Z> com.a.a.g.b<T, Z> b(Class<T> cls, Class<Z> cls2) {
        return this.j.a(cls, cls2);
    }

    com.a.a.d.d.a.e c() {
        return this.k;
    }

    com.a.a.d.d.a.i d() {
        return this.m;
    }

    com.a.a.d.d.e.f e() {
        return this.l;
    }

    com.a.a.d.d.e.f f() {
        return this.n;
    }

    public void g() {
        com.a.a.j.h.a();
        this.f.a();
        this.e.a();
    }
}
