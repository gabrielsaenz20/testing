package com.a.a.d.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

/* loaded from: classes.dex */
public class j extends com.a.a.d.d.b.b {
    private final Rect a;
    private int b;
    private int c;
    private boolean d;
    private boolean e;
    private a f;

    static class a extends Drawable.ConstantState {
        private static final Paint d = new Paint(6);
        final Bitmap a;
        int b;
        Paint c;

        public a(Bitmap bitmap) {
            this.c = d;
            this.a = bitmap;
        }

        a(a aVar) {
            this(aVar.a);
            this.b = aVar.b;
        }

        void a() {
            if (d == this.c) {
                this.c = new Paint(6);
            }
        }

        void a(int i) {
            a();
            this.c.setAlpha(i);
        }

        void a(ColorFilter colorFilter) {
            a();
            this.c.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new j((Resources) null, this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new j(resources, this);
        }
    }

    public j(Resources resources, Bitmap bitmap) {
        this(resources, new a(bitmap));
    }

    j(Resources resources, a aVar) {
        int i;
        this.a = new Rect();
        if (aVar == null) {
            throw new NullPointerException("BitmapState must not be null");
        }
        this.f = aVar;
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
            i = i == 0 ? 160 : i;
            aVar.b = i;
        } else {
            i = aVar.b;
        }
        this.b = aVar.a.getScaledWidth(i);
        this.c = aVar.a.getScaledHeight(i);
    }

    @Override // com.a.a.d.d.b.b
    public void a(int i) {
    }

    @Override // com.a.a.d.d.b.b
    public boolean a() {
        return false;
    }

    public Bitmap b() {
        return this.f.a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.d) {
            Gravity.apply(119, this.b, this.c, getBounds(), this.a);
            this.d = false;
        }
        canvas.drawBitmap(this.f.a, (Rect) null, this.a, this.f.c);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap = this.f.a;
        return (bitmap == null || bitmap.hasAlpha() || this.f.c.getAlpha() < 255) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.e && super.mutate() == this) {
            this.f = new a(this.f);
            this.e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.d = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f.c.getAlpha() != i) {
            this.f.a(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f.a(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }
}
