package com.a.a.h.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.a.a.h.a.c;

/* loaded from: classes.dex */
public abstract class e<Z> extends k<ImageView, Z> implements c.a {
    public e(ImageView imageView) {
        super(imageView);
    }

    @Override // com.a.a.h.a.c.a
    public void a(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    @Override // com.a.a.h.b.a, com.a.a.h.b.j
    public void a(Exception exc, Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    protected abstract void a(Z z);

    @Override // com.a.a.h.b.j
    public void a(Z z, com.a.a.h.a.c<? super Z> cVar) {
        if (cVar == null || !cVar.a(z, this)) {
            a((e<Z>) z);
        }
    }

    @Override // com.a.a.h.a.c.a
    public Drawable b() {
        return ((ImageView) this.a).getDrawable();
    }

    @Override // com.a.a.h.b.a, com.a.a.h.b.j
    public void b(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    @Override // com.a.a.h.b.a, com.a.a.h.b.j
    public void c(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }
}
