package com.a.a.d.c;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class o implements com.a.a.d.b<InputStream> {
    @Override // com.a.a.d.b
    public String a() {
        return "";
    }

    @Override // com.a.a.d.b
    public boolean a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArrB = com.a.a.j.a.a().b();
        while (true) {
            try {
                int i = inputStream.read(bArrB);
                if (i == -1) {
                    return true;
                }
                outputStream.write(bArrB, 0, i);
            } catch (IOException e) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                }
                return false;
            } finally {
                com.a.a.j.a.a().a(bArrB);
            }
        }
    }
}
