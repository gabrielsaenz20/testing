package com.a.a.h.b;

import android.widget.ImageView;

/* loaded from: classes.dex */
public class d extends e<com.a.a.d.d.b.b> {
    private int b;
    private com.a.a.d.d.b.b c;

    public d(ImageView imageView) {
        this(imageView, -1);
    }

    public d(ImageView imageView, int i) {
        super(imageView);
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.h.b.e
    public void a(com.a.a.d.d.b.b bVar) {
        ((ImageView) this.a).setImageDrawable(bVar);
    }

    public void a(com.a.a.d.d.b.b bVar, com.a.a.h.a.c<? super com.a.a.d.d.b.b> cVar) {
        if (!bVar.a()) {
            float intrinsicWidth = bVar.getIntrinsicWidth() / bVar.getIntrinsicHeight();
            if (Math.abs((((ImageView) this.a).getWidth() / ((ImageView) this.a).getHeight()) - 1.0f) <= 0.05f && Math.abs(intrinsicWidth - 1.0f) <= 0.05f) {
                bVar = new i(bVar, ((ImageView) this.a).getWidth());
            }
        }
        super.a((d) bVar, (com.a.a.h.a.c<? super d>) cVar);
        this.c = bVar;
        bVar.a(this.b);
        bVar.start();
    }

    @Override // com.a.a.h.b.e, com.a.a.h.b.j
    public /* bridge */ /* synthetic */ void a(Object obj, com.a.a.h.a.c cVar) {
        a((com.a.a.d.d.b.b) obj, (com.a.a.h.a.c<? super com.a.a.d.d.b.b>) cVar);
    }

    @Override // com.a.a.h.b.a, com.a.a.e.h
    public void d() {
        if (this.c != null) {
            this.c.start();
        }
    }

    @Override // com.a.a.h.b.a, com.a.a.e.h
    public void e() {
        if (this.c != null) {
            this.c.stop();
        }
    }
}
