package com.a.a.d.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
class m {
    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper(), new a());

    private static class a implements Handler.Callback {
        private a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((l) message.obj).d();
            return true;
        }
    }

    m() {
    }

    public void a(l<?> lVar) {
        com.a.a.j.h.a();
        if (this.a) {
            this.b.obtainMessage(1, lVar).sendToTarget();
            return;
        }
        this.a = true;
        lVar.d();
        this.a = false;
    }
}
