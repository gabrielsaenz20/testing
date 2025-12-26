package com.a.a.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class b {
    private final Context a;

    public b(Context context) {
        this.a = context;
    }

    private static a a(String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object objNewInstance = cls.newInstance();
                if (objNewInstance instanceof a) {
                    return (a) objNewInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e3);
        }
    }

    public List<a> a() throws PackageManager.NameNotFoundException {
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                for (String str : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(a(str));
                    }
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }
}
