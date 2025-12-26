package com.a.a.h.a;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.a.a.h.a.f;

/* loaded from: classes.dex */
public class a<T extends Drawable> implements d<T> {
    private final g<T> a;
    private final int b;
    private b<T> c;
    private b<T> d;

    /* renamed from: com.a.a.h.a.a$a, reason: collision with other inner class name */
    private static class C0029a implements f.a {
        private final int a;

        C0029a(int i) {
            this.a = i;
        }

        @Override // com.a.a.h.a.f.a
        public Animation a() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(this.a);
            return alphaAnimation;
        }
    }

    public a() {
        this(300);
    }

    public a(int i) {
        this(new g(new C0029a(i)), i);
    }

    a(g<T> gVar, int i) {
        this.a = gVar;
        this.b = i;
    }

    private c<T> a() {
        if (this.c == null) {
            this.c = new b<>(this.a.a(false, true), this.b);
        }
        return this.c;
    }

    private c<T> b() {
        if (this.d == null) {
            this.d = new b<>(this.a.a(false, false), this.b);
        }
        return this.d;
    }

    @Override // com.a.a.h.a.d
    public c<T> a(boolean z, boolean z2) {
        return z ? e.b() : z2 ? a() : b();
    }
}
