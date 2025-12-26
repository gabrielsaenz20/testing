package com.a.a.d.b.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class f implements c {
    private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
    private final g b;
    private final Set<Bitmap.Config> c;
    private final int d;
    private final a e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    private static class b implements a {
        private b() {
        }

        @Override // com.a.a.d.b.a.f.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.a.a.d.b.a.f.a
        public void b(Bitmap bitmap) {
        }
    }

    public f(int i) {
        this(i, e(), f());
    }

    f(int i, g gVar, Set<Bitmap.Config> set) {
        this.d = i;
        this.f = i;
        this.b = gVar;
        this.c = set;
        this.e = new b();
    }

    private void b() {
        b(this.f);
    }

    private synchronized void b(int i) {
        while (this.g > i) {
            Bitmap bitmapA = this.b.a();
            if (bitmapA == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    d();
                }
                this.g = 0;
                return;
            }
            this.e.b(bitmapA);
            this.g -= this.b.c(bitmapA);
            bitmapA.recycle();
            this.k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.b.b(bitmapA));
            }
            c();
        }
    }

    private void c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            d();
        }
    }

    private void d() {
        Log.v("LruBitmapPool", "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f + "\nStrategy=" + this.b);
    }

    private static g e() {
        return Build.VERSION.SDK_INT >= 19 ? new i() : new com.a.a.d.b.a.a();
    }

    private static Set<Bitmap.Config> f() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // com.a.a.d.b.a.c
    public synchronized Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapB;
        bitmapB = b(i, i2, config);
        if (bitmapB != null) {
            bitmapB.eraseColor(0);
        }
        return bitmapB;
    }

    @Override // com.a.a.d.b.a.c
    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        b(0);
    }

    @Override // com.a.a.d.b.a.c
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 60) {
            a();
        } else if (i >= 40) {
            b(this.f / 2);
        }
    }

    @Override // com.a.a.d.b.a.c
    public synchronized boolean a(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isMutable() && this.b.c(bitmap) <= this.f && this.c.contains(bitmap.getConfig())) {
                int iC = this.b.c(bitmap);
                this.b.a(bitmap);
                this.e.a(bitmap);
                this.j++;
                this.g += iC;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.b.b(bitmap));
                }
                c();
                b();
                return true;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.c.contains(bitmap.getConfig()));
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.a.a.d.b.a.c
    @TargetApi(12)
    public synchronized Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapA;
        bitmapA = this.b.a(i, i2, config != null ? config : a);
        if (bitmapA == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.b.b(i, i2, config));
            }
            this.i++;
        } else {
            this.h++;
            this.g -= this.b.c(bitmapA);
            this.e.b(bitmapA);
            if (Build.VERSION.SDK_INT >= 12) {
                bitmapA.setHasAlpha(true);
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.b.b(i, i2, config));
        }
        c();
        return bitmapA;
    }
}
