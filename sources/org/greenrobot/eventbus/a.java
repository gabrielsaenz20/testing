package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
class a implements Runnable, l {
    private final k a = new k();
    private final c b;

    a(c cVar) {
        this.b = cVar;
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        this.a.a(j.a(qVar, obj));
        this.b.b().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        j jVarA = this.a.a();
        if (jVarA == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.b.a(jVarA);
    }
}
