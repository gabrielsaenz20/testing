package com.a.a.d.d.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;
import com.a.a.b.a;
import com.a.a.d.d.d.f;

/* loaded from: classes.dex */
public class b extends com.a.a.d.d.b.b implements f.b {
    private final Paint a;
    private final Rect b;
    private final a c;
    private final com.a.a.b.a d;
    private final f e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private boolean l;

    static class a extends Drawable.ConstantState {
        com.a.a.b.c a;
        byte[] b;
        Context c;
        com.a.a.d.g<Bitmap> d;
        int e;
        int f;
        a.InterfaceC0020a g;
        com.a.a.d.b.a.c h;
        Bitmap i;

        public a(com.a.a.b.c cVar, byte[] bArr, Context context, com.a.a.d.g<Bitmap> gVar, int i, int i2, a.InterfaceC0020a interfaceC0020a, com.a.a.d.b.a.c cVar2, Bitmap bitmap) {
            if (bitmap == null) {
                throw new NullPointerException("The first frame of the GIF must not be null");
            }
            this.a = cVar;
            this.b = bArr;
            this.h = cVar2;
            this.i = bitmap;
            this.c = context.getApplicationContext();
            this.d = gVar;
            this.e = i;
            this.f = i2;
            this.g = interfaceC0020a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new b(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    public b(Context context, a.InterfaceC0020a interfaceC0020a, com.a.a.d.b.a.c cVar, com.a.a.d.g<Bitmap> gVar, int i, int i2, com.a.a.b.c cVar2, byte[] bArr, Bitmap bitmap) {
        this(new a(cVar2, bArr, context, gVar, i, i2, interfaceC0020a, cVar, bitmap));
    }

    b(a aVar) {
        this.b = new Rect();
        this.i = true;
        this.k = -1;
        if (aVar == null) {
            throw new NullPointerException("GifState must not be null");
        }
        this.c = aVar;
        this.d = new com.a.a.b.a(aVar.g);
        this.a = new Paint();
        this.d.a(aVar.a, aVar.b);
        this.e = new f(aVar.c, this, this.d, aVar.e, aVar.f);
        this.e.a(aVar.d);
    }

    public b(b bVar, Bitmap bitmap, com.a.a.d.g<Bitmap> gVar) {
        this(new a(bVar.c.a, bVar.c.b, bVar.c.c, gVar, bVar.c.e, bVar.c.f, bVar.c.g, bVar.c.h, bitmap));
    }

    private void g() {
        this.j = 0;
    }

    private void h() {
        this.e.c();
        invalidateSelf();
    }

    private void i() {
        if (this.d.c() != 1) {
            if (this.f) {
                return;
            }
            this.f = true;
            this.e.a();
        }
        invalidateSelf();
    }

    private void j() {
        this.f = false;
        this.e.b();
    }

    @Override // com.a.a.d.d.b.b
    public void a(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i == 0 && (i = this.d.e()) == 0) {
            i = -1;
        }
        this.k = i;
    }

    @Override // com.a.a.d.d.b.b
    public boolean a() {
        return true;
    }

    public Bitmap b() {
        return this.c.i;
    }

    @Override // com.a.a.d.d.d.f.b
    @TargetApi(11)
    public void b(int i) {
        if (Build.VERSION.SDK_INT >= 11 && getCallback() == null) {
            stop();
            h();
            return;
        }
        invalidateSelf();
        if (i == this.d.c() - 1) {
            this.j++;
        }
        if (this.k == -1 || this.j < this.k) {
            return;
        }
        stop();
    }

    public com.a.a.d.g<Bitmap> c() {
        return this.c.d;
    }

    public byte[] d() {
        return this.c.b;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.h) {
            return;
        }
        if (this.l) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.b);
            this.l = false;
        }
        Bitmap bitmapD = this.e.d();
        if (bitmapD == null) {
            bitmapD = this.c.i;
        }
        canvas.drawBitmap(bitmapD, (Rect) null, this.b, this.a);
    }

    public int e() {
        return this.d.c();
    }

    public void f() {
        this.h = true;
        this.c.h.a(this.c.i);
        this.e.c();
        this.e.b();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.c.i.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.c.i.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.i = z;
        if (!z) {
            j();
        } else if (this.g) {
            i();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.g = true;
        g();
        if (this.i) {
            i();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.g = false;
        j();
        if (Build.VERSION.SDK_INT < 11) {
            h();
        }
    }
}
