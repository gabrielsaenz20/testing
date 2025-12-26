package com.a.a.h.a;

import android.view.View;
import android.view.animation.Animation;
import com.a.a.h.a.c;

/* loaded from: classes.dex */
public class f<R> implements c<R> {
    private final a a;

    interface a {
        Animation a();
    }

    f(a aVar) {
        this.a = aVar;
    }

    @Override // com.a.a.h.a.c
    public boolean a(R r, c.a aVar) {
        View viewA = aVar.a();
        if (viewA == null) {
            return false;
        }
        viewA.clearAnimation();
        viewA.startAnimation(this.a.a());
        return false;
    }
}
