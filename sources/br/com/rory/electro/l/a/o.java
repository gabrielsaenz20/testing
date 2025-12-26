package br.com.rory.electro.l.a;

import android.content.Context;
import com.rory.electro.NativeLoader;
import java.io.File;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class o extends br.com.rory.electro.l.c.a {
    static {
        NativeLoader.classesInit0(208);
    }

    @Override // br.com.rory.electro.l.c.a, br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.c.a
    protected native List<File> a(Context context, Date date);

    @Override // br.com.rory.electro.l.c.a
    protected native void b(Context context, Date date);
}
