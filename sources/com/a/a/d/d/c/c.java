package com.a.a.d.d.c;

import com.a.a.d.b.l;
import com.a.a.d.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class c<T> implements e<File, T> {
    private static final a a = new a();
    private e<InputStream, T> b;
    private final a c;

    static class a {
        a() {
        }

        public InputStream a(File file) {
            return new FileInputStream(file);
        }
    }

    public c(e<InputStream, T> eVar) {
        this(eVar, a);
    }

    c(e<InputStream, T> eVar, a aVar) {
        this.b = eVar;
        this.c = aVar;
    }

    @Override // com.a.a.d.e
    public l<T> a(File file, int i, int i2) throws Throwable {
        InputStream inputStreamA;
        try {
            inputStreamA = this.c.a(file);
        } catch (Throwable th) {
            th = th;
            inputStreamA = null;
        }
        try {
            l<T> lVarA = this.b.a(inputStreamA, i, i2);
            if (inputStreamA != null) {
                try {
                    inputStreamA.close();
                } catch (IOException unused) {
                }
            }
            return lVarA;
        } catch (Throwable th2) {
            th = th2;
            if (inputStreamA != null) {
                try {
                    inputStreamA.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    @Override // com.a.a.d.e
    public String a() {
        return "";
    }
}
