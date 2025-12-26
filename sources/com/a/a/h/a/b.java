package com.a.a.h.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.a.a.h.a.c;

/* loaded from: classes.dex */
public class b<T extends Drawable> implements c<T> {
    private final c<T> a;
    private final int b;

    public b(c<T> cVar, int i) {
        this.a = cVar;
        this.b = i;
    }

    @Override // com.a.a.h.a.c
    public boolean a(T t, c.a aVar) {
        Drawable drawableB = aVar.b();
        if (drawableB == null) {
            this.a.a(t, aVar);
            return false;
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableB, t});
        transitionDrawable.setCrossFadeEnabled(true);
        transitionDrawable.startTransition(this.b);
        aVar.a(transitionDrawable);
        return true;
    }
}
