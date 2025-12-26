package com.a.a.d.a;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
public class f implements c<InputStream> {
    private static final b a = new a();
    private final com.a.a.d.c.d b;
    private final b c;
    private HttpURLConnection d;
    private InputStream e;
    private volatile boolean f;

    private static class a implements b {
        private a() {
        }

        @Override // com.a.a.d.a.f.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    interface b {
        HttpURLConnection a(URL url);
    }

    public f(com.a.a.d.c.d dVar) {
        this(dVar, a);
    }

    f(com.a.a.d.c.d dVar, b bVar) {
        this.b = dVar;
        this.c = bVar;
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            inputStream = com.a.a.j.b.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            inputStream = httpURLConnection.getInputStream();
        }
        this.e = inputStream;
        return this.e;
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.d = this.c.a(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.d.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.d.setConnectTimeout(2500);
        this.d.setReadTimeout(2500);
        this.d.setUseCaches(false);
        this.d.setDoInput(true);
        this.d.connect();
        if (this.f) {
            return null;
        }
        int responseCode = this.d.getResponseCode();
        int i2 = responseCode / 100;
        if (i2 == 2) {
            return a(this.d);
        }
        if (i2 == 3) {
            String headerField = this.d.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new IOException("Received empty or null redirect url");
            }
            return a(new URL(url, headerField), i + 1, url, map);
        }
        if (responseCode == -1) {
            throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
        }
        throw new IOException("Request failed " + responseCode + ": " + this.d.getResponseMessage());
    }

    @Override // com.a.a.d.a.c
    public void a() throws IOException {
        if (this.e != null) {
            try {
                this.e.close();
            } catch (IOException unused) {
            }
        }
        if (this.d != null) {
            this.d.disconnect();
        }
    }

    @Override // com.a.a.d.a.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InputStream a(com.a.a.i iVar) {
        return a(this.b.a(), 0, null, this.b.b());
    }

    @Override // com.a.a.d.a.c
    public String b() {
        return this.b.c();
    }

    @Override // com.a.a.d.a.c
    public void c() {
        this.f = true;
    }
}
