package com.a.a.h.b;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class i extends com.a.a.d.d.b.b {
    private com.a.a.d.d.b.b a;
    private a b;
    private boolean c;

    static class a extends Drawable.ConstantState {
        private final Drawable.ConstantState a;
        private final int b;

        a(Drawable.ConstantState constantState, int i) {
            this.a = constantState;
            this.b = i;
        }

        a(a aVar) {
            this(aVar.a, aVar.b);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this, null, resources);
        }
    }

    public i(com.a.a.d.d.b.b bVar, int i) {
        this(new a(bVar.getConstantState(), i), bVar, null);
    }

    i(a aVar, com.a.a.d.d.b.b bVar, Resources resources) {
        this.b = aVar;
        if (bVar == null) {
            this.a = (com.a.a.d.d.b.b) (resources != null ? aVar.a.newDrawable(resources) : aVar.a.newDrawable());
        } else {
            this.a = bVar;
        }
    }

    @Override // com.a.a.d.d.b.b
    public void a(int i) {
        this.a.a(i);
    }

    @Override // com.a.a.d.d.b.b
    public boolean a() {
        return this.a.a();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.a.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(19)
    public int getAlpha() {
        return this.a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(11)
    public Drawable.Callback getCallback() {
        return this.a.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.a.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.b.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.b.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.a.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.a.invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.a.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.c && super.mutate() == this) {
            this.a = (com.a.a.d.d.b.b) this.a.mutate();
            this.b = new a(this.b);
            this.c = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.a.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.a.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.a.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        this.a.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.a.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.a.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.a.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.a.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.a.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.a.unscheduleSelf(runnable);
    }
}
