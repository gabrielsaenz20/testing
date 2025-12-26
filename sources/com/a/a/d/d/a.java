package com.a.a.d.d;

import java.io.OutputStream;

/* loaded from: classes.dex */
public class a<T> implements com.a.a.d.b<T> {
    private static final a<?> a = new a<>();

    public static <T> com.a.a.d.b<T> b() {
        return a;
    }

    @Override // com.a.a.d.b
    public String a() {
        return "";
    }

    @Override // com.a.a.d.b
    public boolean a(T t, OutputStream outputStream) {
        return false;
    }
}
