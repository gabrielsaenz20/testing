package org.greenrobot.eventbus.android;

import org.greenrobot.eventbus.g;
import org.greenrobot.eventbus.h;

/* loaded from: classes.dex */
public abstract class a {
    private static final a c;
    public final g a;
    public final h b;

    static {
        c = b.a() ? b.c() : null;
    }

    public a(g gVar, h hVar) {
        this.a = gVar;
        this.b = hVar;
    }

    public static boolean a() {
        return c != null;
    }

    public static a b() {
        return c;
    }
}
