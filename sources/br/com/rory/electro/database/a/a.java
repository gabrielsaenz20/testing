package br.com.rory.electro.database.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.rory.electro.NativeLoader;
import java.util.List;

/* loaded from: classes.dex */
public class a {
    private SQLiteDatabase a;

    static {
        NativeLoader.classesInit0(451);
    }

    public a(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    private native br.com.rory.electro.database.b.a a(Cursor cursor);

    private native String[] b();

    public native long a(br.com.rory.electro.database.b.a aVar);

    public native br.com.rory.electro.database.b.a a(long j);

    public native List<br.com.rory.electro.database.b.a> a(int i);

    public native void a();

    public native void a(long j, int i);

    public native void a(long j, long j2);

    public native List<br.com.rory.electro.database.b.a> b(long j);
}
