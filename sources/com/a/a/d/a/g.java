package com.a.a.d.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class g<T> implements c<T> {
    private final Uri a;
    private final Context b;
    private T c;

    public g(Context context, Uri uri) {
        this.b = context.getApplicationContext();
        this.a = uri;
    }

    @Override // com.a.a.d.a.c
    public final T a(com.a.a.i iVar) {
        this.c = b(this.a, this.b.getContentResolver());
        return this.c;
    }

    @Override // com.a.a.d.a.c
    public void a() {
        if (this.c != null) {
            try {
                a((g<T>) this.c);
            } catch (IOException e) {
                if (Log.isLoggable("LocalUriFetcher", 2)) {
                    Log.v("LocalUriFetcher", "failed to close data", e);
                }
            }
        }
    }

    protected abstract void a(T t);

    protected abstract T b(Uri uri, ContentResolver contentResolver);

    @Override // com.a.a.d.a.c
    public String b() {
        return this.a.toString();
    }

    @Override // com.a.a.d.a.c
    public void c() {
    }
}
