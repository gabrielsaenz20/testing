package com.a.a.d.b.b;

import com.a.a.d.b.b.a;
import java.io.File;

/* loaded from: classes.dex */
public class d implements a.InterfaceC0023a {
    private final int a;
    private final a b;

    public interface a {
        File a();
    }

    public d(a aVar, int i) {
        this.a = i;
        this.b = aVar;
    }

    @Override // com.a.a.d.b.b.a.InterfaceC0023a
    public com.a.a.d.b.b.a a() {
        File fileA = this.b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.mkdirs() || (fileA.exists() && fileA.isDirectory())) {
            return e.a(fileA, this.a);
        }
        return null;
    }
}
