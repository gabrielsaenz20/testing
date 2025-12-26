package br.com.rory.electro.database.migrations;

import android.database.sqlite.SQLiteDatabase;
import br.com.rory.electro.database.c;
import com.rory.electro.NativeLoader;

/* loaded from: classes.dex */
public class Version10 implements c {
    static {
        NativeLoader.classesInit0(3);
    }

    @Override // br.com.rory.electro.database.c
    public native void onUpgrade(SQLiteDatabase sQLiteDatabase);
}
