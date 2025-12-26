package com.a.a.j;

import android.util.Log;
import java.util.Queue;

/* loaded from: classes.dex */
public final class a {
    private static final a b = new a();
    private final Queue<byte[]> a = h.a(0);

    private a() {
    }

    public static a a() {
        return b;
    }

    public boolean a(byte[] bArr) {
        boolean z = false;
        if (bArr.length != 65536) {
            return false;
        }
        synchronized (this.a) {
            if (this.a.size() < 32) {
                z = true;
                this.a.offer(bArr);
            }
        }
        return z;
    }

    public byte[] b() {
        byte[] bArrPoll;
        synchronized (this.a) {
            bArrPoll = this.a.poll();
        }
        if (bArrPoll == null) {
            bArrPoll = new byte[65536];
            if (Log.isLoggable("ByteArrayPool", 3)) {
                Log.d("ByteArrayPool", "Created temp bytes");
            }
        }
        return bArrPoll;
    }
}
