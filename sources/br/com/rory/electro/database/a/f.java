package br.com.rory.electro.database.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.rory.electro.NativeLoader;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class f {
    private SQLiteDatabase a;

    static {
        NativeLoader.classesInit0(453);
    }

    public f(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    private native br.com.rory.electro.database.b.f a(Cursor cursor);

    private native String[] a();

    public native long a(br.com.rory.electro.database.b.f fVar);

    public native List<br.com.rory.electro.database.b.f> a(long j);

    public native Map<Long, Integer> a(List<br.com.rory.electro.database.b.e> list);

    public native br.com.rory.electro.database.b.f b(long j);
}
