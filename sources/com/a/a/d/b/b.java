package com.a.a.d.b;

/* loaded from: classes.dex */
public enum b {
    ALL(true, true),
    NONE(false, false),
    SOURCE(true, false),
    RESULT(false, true);

    private final boolean e;
    private final boolean f;

    b(boolean z, boolean z2) {
        this.e = z;
        this.f = z2;
    }

    public boolean a() {
        return this.e;
    }

    public boolean b() {
        return this.f;
    }
}
