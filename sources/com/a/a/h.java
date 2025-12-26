package com.a.a;

import android.content.Context;
import android.os.Build;
import com.a.a.d.b.b.a;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class h {
    private final Context a;
    private com.a.a.d.b.c b;
    private com.a.a.d.b.a.c c;
    private com.a.a.d.b.b.h d;
    private ExecutorService e;
    private ExecutorService f;
    private com.a.a.d.a g;
    private a.InterfaceC0023a h;

    public h(Context context) {
        this.a = context.getApplicationContext();
    }

    g a() {
        if (this.e == null) {
            this.e = new com.a.a.d.b.c.a(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f == null) {
            this.f = new com.a.a.d.b.c.a(1);
        }
        com.a.a.d.b.b.i iVar = new com.a.a.d.b.b.i(this.a);
        if (this.c == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.c = new com.a.a.d.b.a.f(iVar.b());
            } else {
                this.c = new com.a.a.d.b.a.d();
            }
        }
        if (this.d == null) {
            this.d = new com.a.a.d.b.b.g(iVar.a());
        }
        if (this.h == null) {
            this.h = new com.a.a.d.b.b.f(this.a);
        }
        if (this.b == null) {
            this.b = new com.a.a.d.b.c(this.d, this.h, this.f, this.e);
        }
        if (this.g == null) {
            this.g = com.a.a.d.a.d;
        }
        return new g(this.b, this.d, this.c, this.a, this.g);
    }
}
