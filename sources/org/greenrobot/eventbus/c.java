package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

/* loaded from: classes.dex */
public class c {
    public static String a = "EventBus";
    static volatile c b;
    private static final d c = new d();
    private static final Map<Class<?>, List<Class<?>>> d = new HashMap();
    private final Map<Class<?>, CopyOnWriteArrayList<q>> e;
    private final Map<Object, List<Class<?>>> f;
    private final Map<Class<?>, Object> g;
    private final ThreadLocal<a> h;
    private final h i;
    private final l j;
    private final b k;
    private final org.greenrobot.eventbus.a l;
    private final p m;
    private final ExecutorService n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final boolean t;
    private final int u;
    private final g v;

    static final class a {
        final List<Object> a = new ArrayList();
        boolean b;
        boolean c;
        q d;
        Object e;
        boolean f;

        a() {
        }
    }

    public c() {
        this(c);
    }

    c(d dVar) {
        this.h = new ThreadLocal<a>() { // from class: org.greenrobot.eventbus.c.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a initialValue() {
                return new a();
            }
        };
        this.v = dVar.a();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new ConcurrentHashMap();
        this.i = dVar.b();
        this.j = this.i != null ? this.i.a(this) : null;
        this.k = new b(this);
        this.l = new org.greenrobot.eventbus.a(this);
        this.u = dVar.j != null ? dVar.j.size() : 0;
        this.m = new p(dVar.j, dVar.h, dVar.g);
        this.p = dVar.a;
        this.q = dVar.b;
        this.r = dVar.c;
        this.s = dVar.d;
        this.o = dVar.e;
        this.t = dVar.f;
        this.n = dVar.i;
    }

    private static List<Class<?>> a(Class<?> cls) {
        List<Class<?>> arrayList;
        synchronized (d) {
            arrayList = d.get(cls);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                    arrayList.add(superclass);
                    a(arrayList, superclass.getInterfaces());
                }
                d.put(cls, arrayList);
            }
        }
        return arrayList;
    }

    public static c a() {
        c cVar;
        c cVar2 = b;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (c.class) {
            cVar = b;
            if (cVar == null) {
                cVar = new c();
                b = cVar;
            }
        }
        return cVar;
    }

    private void a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.e.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                q qVar = copyOnWriteArrayList.get(i);
                if (qVar.a == obj) {
                    qVar.c = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    private void a(Object obj, a aVar) {
        boolean zA;
        Class<?> cls = obj.getClass();
        if (this.t) {
            List<Class<?>> listA = a(cls);
            int size = listA.size();
            zA = false;
            for (int i = 0; i < size; i++) {
                zA |= a(obj, aVar, listA.get(i));
            }
        } else {
            zA = a(obj, aVar, cls);
        }
        if (zA) {
            return;
        }
        if (this.q) {
            this.v.a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.s || cls == i.class || cls == n.class) {
            return;
        }
        c(new i(this, obj));
    }

    private void a(Object obj, o oVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = oVar.c;
        q qVar = new q(obj, oVar);
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.e.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.e.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(qVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || oVar.d > copyOnWriteArrayList.get(i).b.d) {
                copyOnWriteArrayList.add(i, qVar);
                break;
            }
        }
        List<Class<?>> arrayList = this.f.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (oVar.e) {
            if (!this.t) {
                b(qVar, this.g.get(cls));
                return;
            }
            for (Map.Entry<Class<?>, Object> entry : this.g.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    b(qVar, entry.getValue());
                }
            }
        }
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    private void a(q qVar, Object obj, Throwable th) {
        if (!(obj instanceof n)) {
            if (this.o) {
                throw new e("Invoking subscriber failed", th);
            }
            if (this.p) {
                this.v.a(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + qVar.a.getClass(), th);
            }
            if (this.r) {
                c(new n(this, th, obj, qVar.a));
                return;
            }
            return;
        }
        if (this.p) {
            this.v.a(Level.SEVERE, "SubscriberExceptionEvent subscriber " + qVar.a.getClass() + " threw an exception", th);
            n nVar = (n) obj;
            this.v.a(Level.SEVERE, "Initial event " + nVar.c + " caused exception in " + nVar.d, nVar.b);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
    
        if (r2.j != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if (r5 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        r2.j.a(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(q qVar, Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        switch (qVar.b.b) {
            case POSTING:
                a(qVar, obj);
                return;
            case MAIN:
                break;
            case MAIN_ORDERED:
                break;
            case BACKGROUND:
                if (z) {
                    this.k.a(qVar, obj);
                    return;
                }
                a(qVar, obj);
                return;
            case ASYNC:
                this.l.a(qVar, obj);
                return;
            default:
                throw new IllegalStateException("Unknown thread mode: " + qVar.b.b);
        }
    }

    private boolean a(Object obj, a aVar, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.e.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<q> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            aVar.e = obj;
            aVar.d = next;
            try {
                a(next, obj, aVar.c);
                if (aVar.f) {
                    return true;
                }
            } finally {
                aVar.e = null;
                aVar.d = null;
                aVar.f = false;
            }
        }
        return true;
    }

    private void b(q qVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (obj != null) {
            a(qVar, obj, d());
        }
    }

    private boolean d() {
        return this.i == null || this.i.a();
    }

    public void a(Object obj) {
        if (org.greenrobot.eventbus.android.b.a() && !org.greenrobot.eventbus.android.b.b()) {
            throw new RuntimeException("It looks like you are using EventBus on Android, make sure to add the \"eventbus\" Android library to your dependencies.");
        }
        List<o> listA = this.m.a(obj.getClass());
        synchronized (this) {
            Iterator<o> it = listA.iterator();
            while (it.hasNext()) {
                a(obj, it.next());
            }
        }
    }

    void a(j jVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj = jVar.a;
        q qVar = jVar.b;
        j.a(jVar);
        if (qVar.c) {
            a(qVar, obj);
        }
    }

    void a(q qVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            qVar.b.a.invoke(qVar.a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            a(qVar, obj, e2.getCause());
        }
    }

    ExecutorService b() {
        return this.n;
    }

    public synchronized void b(Object obj) {
        List<Class<?>> list = this.f.get(obj);
        if (list != null) {
            Iterator<Class<?>> it = list.iterator();
            while (it.hasNext()) {
                a(obj, it.next());
            }
            this.f.remove(obj);
        } else {
            this.v.a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public g c() {
        return this.v;
    }

    public void c(Object obj) {
        a aVar = this.h.get();
        List<Object> list = aVar.a;
        list.add(obj);
        if (aVar.b) {
            return;
        }
        aVar.c = d();
        aVar.b = true;
        if (aVar.f) {
            throw new e("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                } else {
                    a(list.remove(0), aVar);
                }
            } finally {
                aVar.b = false;
                aVar.c = false;
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.u + ", eventInheritance=" + this.t + "]";
    }
}
