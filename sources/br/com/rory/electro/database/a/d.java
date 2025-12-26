package br.com.rory.electro.database.a;

import android.database.sqlite.SQLiteDatabase;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class d {
    private SQLiteDatabase a;

    static {
        NativeLoader.classesInit0(448);
    }

    public d(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    private native String b();

    private native String[] c();

    public native br.com.rory.electro.database.b.d a();

    public native void a(br.com.rory.electro.database.b.d dVar);
}
