package com.a.a.e;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class k implements Handler.Callback {
    private static final k c = new k();
    private volatile com.a.a.j d;
    final Map<FragmentManager, j> a = new HashMap();
    final Map<android.support.v4.app.FragmentManager, n> b = new HashMap();
    private final Handler e = new Handler(Looper.getMainLooper(), this);

    k() {
    }

    public static k a() {
        return c;
    }

    private com.a.a.j b(Context context) {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = new com.a.a.j(context.getApplicationContext(), new b(), new f());
                }
            }
        }
        return this.d;
    }

    @TargetApi(17)
    private static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @TargetApi(17)
    j a(FragmentManager fragmentManager) {
        j jVar = (j) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = this.a.get(fragmentManager);
        if (jVar2 != null) {
            return jVar2;
        }
        j jVar3 = new j();
        this.a.put(fragmentManager, jVar3);
        fragmentManager.beginTransaction().add(jVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.e.obtainMessage(1, fragmentManager).sendToTarget();
        return jVar3;
    }

    n a(android.support.v4.app.FragmentManager fragmentManager) {
        n nVar = (n) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = this.b.get(fragmentManager);
        if (nVar2 != null) {
            return nVar2;
        }
        n nVar3 = new n();
        this.b.put(fragmentManager, nVar3);
        fragmentManager.beginTransaction().add(nVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.e.obtainMessage(2, fragmentManager).sendToTarget();
        return nVar3;
    }

    @TargetApi(11)
    public com.a.a.j a(Activity activity) {
        if (com.a.a.j.h.c() || Build.VERSION.SDK_INT < 11) {
            return a(activity.getApplicationContext());
        }
        b(activity);
        return a(activity, activity.getFragmentManager());
    }

    public com.a.a.j a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.a.a.j.h.b() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return a((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return a(((ContextWrapper) context).getBaseContext());
            }
        }
        return b(context);
    }

    @TargetApi(11)
    com.a.a.j a(Context context, FragmentManager fragmentManager) {
        j jVarA = a(fragmentManager);
        com.a.a.j jVarB = jVarA.b();
        if (jVarB != null) {
            return jVarB;
        }
        com.a.a.j jVar = new com.a.a.j(context, jVarA.a(), jVarA.c());
        jVarA.a(jVar);
        return jVar;
    }

    com.a.a.j a(Context context, android.support.v4.app.FragmentManager fragmentManager) {
        n nVarA = a(fragmentManager);
        com.a.a.j jVarB = nVarA.b();
        if (jVarB != null) {
            return jVarB;
        }
        com.a.a.j jVar = new com.a.a.j(context, nVarA.a(), nVarA.c());
        nVarA.a(jVar);
        return jVar;
    }

    public com.a.a.j a(FragmentActivity fragmentActivity) {
        if (com.a.a.j.h.c()) {
            return a(fragmentActivity.getApplicationContext());
        }
        b((Activity) fragmentActivity);
        return a(fragmentActivity, fragmentActivity.getSupportFragmentManager());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Map map;
        Object objRemove;
        Object obj = null;
        boolean z = true;
        switch (message.what) {
            case 1:
                obj = (FragmentManager) message.obj;
                map = this.a;
                objRemove = map.remove(obj);
                break;
            case 2:
                obj = (android.support.v4.app.FragmentManager) message.obj;
                map = this.b;
                objRemove = map.remove(obj);
                break;
            default:
                z = false;
                objRemove = null;
                break;
        }
        if (z && objRemove == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }
}
