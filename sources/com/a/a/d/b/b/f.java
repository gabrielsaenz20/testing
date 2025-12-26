package com.a.a.d.b.b;

import android.content.Context;
import com.a.a.d.b.b.d;
import java.io.File;

/* loaded from: classes.dex */
public final class f extends d {
    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public f(final Context context, final String str, int i) {
        super(new d.a() { // from class: com.a.a.d.b.b.f.1
            @Override // com.a.a.d.b.b.d.a
            public File a() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, i);
    }
}
