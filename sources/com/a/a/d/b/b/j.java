package com.a.a.d.b.b;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
class j {
    private final com.a.a.j.e<com.a.a.d.c, String> a = new com.a.a.j.e<>(1000);

    j() {
    }

    public String a(com.a.a.d.c cVar) throws NoSuchAlgorithmException {
        String strB;
        synchronized (this.a) {
            strB = this.a.b((com.a.a.j.e<com.a.a.d.c, String>) cVar);
        }
        if (strB != null) {
            return strB;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            cVar.a(messageDigest);
            strB = com.a.a.j.h.a(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        synchronized (this.a) {
            this.a.b(cVar, strB);
        }
        return strB;
    }
}
