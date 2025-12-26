package com.a.a.d.b.b;

import android.util.Log;
import com.a.a.a.a;
import com.a.a.d.b.b.a;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class e implements a {
    private static e a;
    private final c b = new c();
    private final j c = new j();
    private final File d;
    private final int e;
    private com.a.a.a.a f;

    protected e(File file, int i) {
        this.d = file;
        this.e = i;
    }

    private synchronized com.a.a.a.a a() {
        if (this.f == null) {
            this.f = com.a.a.a.a.a(this.d, 1, 1, this.e);
        }
        return this.f;
    }

    public static synchronized a a(File file, int i) {
        if (a == null) {
            a = new e(file, i);
        }
        return a;
    }

    @Override // com.a.a.d.b.b.a
    public File a(com.a.a.d.c cVar) throws NoSuchAlgorithmException {
        try {
            a.c cVarA = a().a(this.c.a(cVar));
            if (cVarA != null) {
                return cVarA.a(0);
            }
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.a.a.d.b.b.a
    public void a(com.a.a.d.c cVar, a.b bVar) throws NoSuchAlgorithmException {
        String strA = this.c.a(cVar);
        this.b.a(cVar);
        try {
            try {
                a.C0019a c0019aB = a().b(strA);
                if (c0019aB != null) {
                    try {
                        if (bVar.a(c0019aB.a(0))) {
                            c0019aB.a();
                        }
                        c0019aB.c();
                    } catch (Throwable th) {
                        c0019aB.c();
                        throw th;
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
        } finally {
            this.b.b(cVar);
        }
    }

    @Override // com.a.a.d.b.b.a
    public void b(com.a.a.d.c cVar) throws NoSuchAlgorithmException {
        try {
            a().c(this.c.a(cVar));
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }
}
