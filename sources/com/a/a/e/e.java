package com.a.a.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.a.a.e.c;

/* loaded from: classes.dex */
class e implements c {
    private final Context a;
    private final c.a b;
    private boolean c;
    private boolean d;
    private final BroadcastReceiver e = new BroadcastReceiver() { // from class: com.a.a.e.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = e.this.c;
            e.this.c = e.this.a(context);
            if (z != e.this.c) {
                e.this.b.a(e.this.c);
            }
        }
    };

    public e(Context context, c.a aVar) {
        this.a = context.getApplicationContext();
        this.b = aVar;
    }

    private void a() {
        if (this.d) {
            return;
        }
        this.c = a(this.a);
        this.a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void b() {
        if (this.d) {
            this.a.unregisterReceiver(this.e);
            this.d = false;
        }
    }

    @Override // com.a.a.e.h
    public void d() {
        a();
    }

    @Override // com.a.a.e.h
    public void e() {
        b();
    }

    @Override // com.a.a.e.h
    public void f() {
    }
}
