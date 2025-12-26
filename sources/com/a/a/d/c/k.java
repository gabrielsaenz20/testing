package com.a.a.d.c;

import android.support.v7.widget.helper.ItemTouchHelper;
import java.util.Queue;

/* loaded from: classes.dex */
public class k<A, B> {
    private final com.a.a.j.e<a<A>, B> a;

    static final class a<A> {
        private static final Queue<a<?>> a = com.a.a.j.h.a(0);
        private int b;
        private int c;
        private A d;

        private a() {
        }

        static <A> a<A> a(A a2, int i, int i2) {
            a<A> aVar = (a) a.poll();
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.b(a2, i, i2);
            return aVar;
        }

        private void b(A a2, int i, int i2) {
            this.d = a2;
            this.c = i;
            this.b = i2;
        }

        public void a() {
            a.offer(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.c == aVar.c && this.b == aVar.b && this.d.equals(aVar.d);
        }

        public int hashCode() {
            return (31 * ((this.b * 31) + this.c)) + this.d.hashCode();
        }
    }

    public k() {
        this(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    public k(int i) {
        this.a = new com.a.a.j.e<a<A>, B>(i) { // from class: com.a.a.d.c.k.1
            protected void a(a<A> aVar, B b) {
                aVar.a();
            }

            @Override // com.a.a.j.e
            protected /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
                a((a) obj, (a<A>) obj2);
            }
        };
    }

    public B a(A a2, int i, int i2) {
        a<A> aVarA = a.a(a2, i, i2);
        B b = this.a.b((com.a.a.j.e<a<A>, B>) aVarA);
        aVarA.a();
        return b;
    }

    public void a(A a2, int i, int i2, B b) {
        this.a.b(a.a(a2, i, i2), b);
    }
}
