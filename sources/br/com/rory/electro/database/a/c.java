package br.com.rory.electro.database.a;

import android.database.sqlite.SQLiteDatabase;
import com.rory.electro.NativeLoader;
import java.util.List;

/* loaded from: classes.dex */
public class c {
    private SQLiteDatabase a;

    static {
        NativeLoader.classesInit0(449);
    }

    public c(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    private native String a();

    private native String[] b();

    public native long a(br.com.rory.electro.database.b.c cVar);

    public native List<br.com.rory.electro.database.b.c> a(long j);
}
