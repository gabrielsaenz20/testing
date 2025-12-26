package com.a.a.d.d.b;

import android.graphics.drawable.Drawable;
import com.a.a.d.b.l;

/* loaded from: classes.dex */
public abstract class a<T extends Drawable> implements l<T> {
    protected final T a;

    public a(T t) {
        if (t == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.a = t;
    }

    @Override // com.a.a.d.b.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final T b() {
        return (T) this.a.getConstantState().newDrawable();
    }
}
