package com.a.a.d.a;

import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class a<T> implements c<T> {
    private final String a;
    private final AssetManager b;
    private T c;

    public a(AssetManager assetManager, String str) {
        this.b = assetManager;
        this.a = str;
    }

    protected abstract T a(AssetManager assetManager, String str);

    @Override // com.a.a.d.a.c
    public T a(com.a.a.i iVar) {
        this.c = a(this.b, this.a);
        return this.c;
    }

    @Override // com.a.a.d.a.c
    public void a() {
        if (this.c == null) {
            return;
        }
        try {
            a((a<T>) this.c);
        } catch (IOException e) {
            if (Log.isLoggable("AssetUriFetcher", 2)) {
                Log.v("AssetUriFetcher", "Failed to close data", e);
            }
        }
    }

    protected abstract void a(T t);

    @Override // com.a.a.d.a.c
    public String b() {
        return this.a;
    }

    @Override // com.a.a.d.a.c
    public void c() {
    }
}
