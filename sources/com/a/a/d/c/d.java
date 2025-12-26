package com.a.a.d.c;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
public class d {
    private final URL a;
    private final e b;
    private final String c;
    private String d;
    private URL e;

    public d(String str) {
        this(str, e.b);
    }

    public d(String str, e eVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + str);
        }
        if (eVar == null) {
            throw new IllegalArgumentException("Headers must not be null");
        }
        this.c = str;
        this.a = null;
        this.b = eVar;
    }

    public d(URL url) {
        this(url, e.b);
    }

    public d(URL url, e eVar) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        }
        if (eVar == null) {
            throw new IllegalArgumentException("Headers must not be null");
        }
        this.a = url;
        this.c = null;
        this.b = eVar;
    }

    private URL d() {
        if (this.e == null) {
            this.e = new URL(e());
        }
        return this.e;
    }

    private String e() {
        if (TextUtils.isEmpty(this.d)) {
            String string = this.c;
            if (TextUtils.isEmpty(string)) {
                string = this.a.toString();
            }
            this.d = Uri.encode(string, "@#&=*+-_.,:!?()/~'%");
        }
        return this.d;
    }

    public URL a() {
        return d();
    }

    public Map<String, String> b() {
        return this.b.a();
    }

    public String c() {
        return this.c != null ? this.c : this.a.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c().equals(dVar.c()) && this.b.equals(dVar.b);
    }

    public int hashCode() {
        return (31 * c().hashCode()) + this.b.hashCode();
    }

    public String toString() {
        return c() + '\n' + this.b.toString();
    }
}
