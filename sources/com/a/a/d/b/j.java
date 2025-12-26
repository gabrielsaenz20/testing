package com.a.a.d.b;

/* loaded from: classes.dex */
public class j extends Exception {
    public j(Error error) {
        super(error);
        if (error == null) {
            throw new NullPointerException("The causing error must not be null");
        }
    }

    @Override // java.lang.Throwable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Error getCause() {
        return (Error) super.getCause();
    }
}
