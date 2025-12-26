package br.com.rory.electro.l.c;

import android.content.Context;
import br.com.rory.electro.k.a.d;
import com.rory.electro.NativeLoader;
import java.io.File;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class a implements br.com.rory.electro.l.a.a {

    /* renamed from: br.com.rory.electro.l.c.a$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<File> {
        static {
            NativeLoader.classesInit0(249);
        }

        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public native int compare(File file, File file2);
    }

    static {
        NativeLoader.classesInit0(143);
    }

    private native long a(String str);

    private native boolean a(Date date);

    private static native String b();

    @Override // br.com.rory.electro.l.a.a
    public abstract String a();

    protected abstract List<File> a(Context context, Date date);

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, d dVar, JSONObject jSONObject);

    protected native void b(Context context, Date date);
}
