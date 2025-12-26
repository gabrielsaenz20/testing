package br.com.rory.electro.database.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.rory.electro.NativeLoader;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class b {
    private SQLiteDatabase a;

    static {
        NativeLoader.classesInit0(450);
    }

    public b(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    private native br.com.rory.electro.database.b.b a(Cursor cursor);

    private native String[] a();

    public native long a(br.com.rory.electro.database.b.b bVar);

    public native List<br.com.rory.electro.database.b.b> a(long j);

    public native Map<Long, Integer> a(List<br.com.rory.electro.database.b.a> list);

    public native br.com.rory.electro.database.b.b b(long j);
}
