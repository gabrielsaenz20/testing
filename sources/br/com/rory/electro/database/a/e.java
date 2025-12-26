package br.com.rory.electro.database.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.rory.electro.NativeLoader;
import java.util.List;

/* loaded from: classes.dex */
public class e {
    private SQLiteDatabase a;

    static {
        NativeLoader.classesInit0(454);
    }

    public e(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    private native br.com.rory.electro.database.b.e a(Cursor cursor);

    private native String[] e();

    public native long a();

    public native br.com.rory.electro.database.b.e a(long j, long j2);

    public native List<br.com.rory.electro.database.b.e> a(int i);

    public native boolean a(long j);

    public native boolean a(long j, double d, double d2, int i, Double d3, Double d4, Double d5);

    public native br.com.rory.electro.database.b.e b(long j);

    public native void b();

    public native List<br.com.rory.electro.database.b.e> c();

    public native List<br.com.rory.electro.database.b.e> c(long j);

    public native br.com.rory.electro.database.b.e d();

    public native void d(long j);

    public native void e(long j);
}
