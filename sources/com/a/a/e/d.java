package com.a.a.e;

import android.content.Context;
import com.a.a.e.c;

/* loaded from: classes.dex */
public class d {
    public c a(Context context, c.a aVar) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? new e(context, aVar) : new i();
    }
}
