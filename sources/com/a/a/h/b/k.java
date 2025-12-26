package com.a.a.h.b;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class k<T extends View, Z> extends com.a.a.h.b.a<Z> {
    private static boolean b;
    private static Integer c;
    protected final T a;
    private final a d;

    private static class a {
        private final View a;
        private final List<h> b = new ArrayList();
        private ViewTreeObserverOnPreDrawListenerC0030a c;
        private Point d;

        /* renamed from: com.a.a.h.b.k$a$a, reason: collision with other inner class name */
        private static class ViewTreeObserverOnPreDrawListenerC0030a implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<a> a;

            public ViewTreeObserverOnPreDrawListenerC0030a(a aVar) {
                this.a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
                }
                a aVar = this.a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        public a(View view) {
            this.a = view;
        }

        private int a(int i, boolean z) {
            if (i != -2) {
                return i;
            }
            Point pointD = d();
            return z ? pointD.y : pointD.x;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.b.isEmpty()) {
                return;
            }
            int iC = c();
            int iB = b();
            if (a(iC) && a(iB)) {
                a(iC, iB);
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.c);
                }
                this.c = null;
            }
        }

        private void a(int i, int i2) {
            Iterator<h> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(i, i2);
            }
            this.b.clear();
        }

        private boolean a(int i) {
            return i > 0 || i == -2;
        }

        private int b() {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (a(this.a.getHeight())) {
                return this.a.getHeight();
            }
            if (layoutParams != null) {
                return a(layoutParams.height, true);
            }
            return 0;
        }

        private int c() {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (a(this.a.getWidth())) {
                return this.a.getWidth();
            }
            if (layoutParams != null) {
                return a(layoutParams.width, false);
            }
            return 0;
        }

        @TargetApi(13)
        private Point d() {
            if (this.d != null) {
                return this.d;
            }
            Display defaultDisplay = ((WindowManager) this.a.getContext().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                this.d = new Point();
                defaultDisplay.getSize(this.d);
            } else {
                this.d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
            }
            return this.d;
        }

        public void a(h hVar) {
            int iC = c();
            int iB = b();
            if (a(iC) && a(iB)) {
                hVar.a(iC, iB);
                return;
            }
            if (!this.b.contains(hVar)) {
                this.b.add(hVar);
            }
            if (this.c == null) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                this.c = new ViewTreeObserverOnPreDrawListenerC0030a(this);
                viewTreeObserver.addOnPreDrawListener(this.c);
            }
        }
    }

    public k(T t) {
        if (t == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.a = t;
        this.d = new a(t);
    }

    private void a(Object obj) {
        if (c != null) {
            this.a.setTag(c.intValue(), obj);
        } else {
            b = true;
            this.a.setTag(obj);
        }
    }

    private Object g() {
        return c == null ? this.a.getTag() : this.a.getTag(c.intValue());
    }

    public T a() {
        return this.a;
    }

    @Override // com.a.a.h.b.j
    public void a(h hVar) {
        this.d.a(hVar);
    }

    @Override // com.a.a.h.b.a, com.a.a.h.b.j
    public void a(com.a.a.h.b bVar) {
        a((Object) bVar);
    }

    @Override // com.a.a.h.b.a, com.a.a.h.b.j
    public com.a.a.h.b c() {
        Object objG = g();
        if (objG == null) {
            return null;
        }
        if (objG instanceof com.a.a.h.b) {
            return (com.a.a.h.b) objG;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public String toString() {
        return "Target for: " + this.a;
    }
}
