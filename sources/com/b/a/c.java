package com.b.a;

import com.b.a.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class c implements Closeable {
    volatile OutputStream a;
    private Socket b;
    private volatile InputStream d;
    private volatile boolean f;
    private volatile boolean g;
    private volatile boolean h;
    private volatile boolean i;
    private volatile int j;
    private volatile d k;
    private boolean l;
    private volatile ConcurrentHashMap<Integer, f> m = new ConcurrentHashMap<>();
    private int c = 0;
    private volatile Thread e = b();

    private c() {
    }

    public static c a(Socket socket, d dVar) throws SocketException {
        c cVar = new c();
        cVar.k = dVar;
        cVar.b = socket;
        cVar.d = socket.getInputStream();
        cVar.a = socket.getOutputStream();
        socket.setTcpNoDelay(true);
        return cVar;
    }

    private boolean a(long j, TimeUnit timeUnit) {
        synchronized (this) {
            long jCurrentTimeMillis = System.currentTimeMillis() + timeUnit.toMillis(j);
            while (!this.i && this.f && jCurrentTimeMillis - System.currentTimeMillis() > 0) {
                wait(jCurrentTimeMillis - System.currentTimeMillis());
            }
            if (this.i) {
                return true;
            }
            if (this.f) {
                return false;
            }
            if (this.h) {
                throw new a();
            }
            throw new IOException("Connection failed");
        }
    }

    private Thread b() {
        return new Thread(new Runnable() { // from class: com.b.a.c.1
            /* JADX WARN: Removed duplicated region for block: B:67:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                e.a aVarA;
                f fVar;
                byte[] bArrA;
                while (!c.this.e.isInterrupted()) {
                    try {
                        aVarA = e.a.a(c.this.d);
                    } catch (Exception unused) {
                    }
                    if (e.a(aVarA)) {
                        switch (aVarA.a) {
                            case 1163086915:
                            case 1163154007:
                            case 1497451343:
                                if (this.i && (fVar = (f) c.this.m.get(Integer.valueOf(aVarA.c))) != null) {
                                    synchronized (fVar) {
                                        if (aVarA.a == 1497451343) {
                                            fVar.a(aVarA.b);
                                            fVar.b();
                                            fVar.notify();
                                        } else if (aVarA.a == 1163154007) {
                                            fVar.a(aVarA.g);
                                            fVar.a();
                                        } else if (aVarA.a == 1163086915) {
                                            this.m.remove(Integer.valueOf(aVarA.c));
                                            fVar.a(true);
                                        }
                                    }
                                    break;
                                }
                                break;
                            case 1213486401:
                                if (aVarA.b == 1) {
                                    if (!this.l) {
                                        bArrA = e.a(2, this.k.a(aVarA.g));
                                        this.l = true;
                                    } else {
                                        if (c.this.g) {
                                            c.this.h = true;
                                            throw new RuntimeException();
                                        }
                                        bArrA = e.a(3, this.k.a());
                                    }
                                    synchronized (this.a) {
                                        this.a.write(bArrA);
                                        this.a.flush();
                                    }
                                    break;
                                } else {
                                    continue;
                                }
                            case 1314410051:
                                synchronized (this) {
                                    this.j = aVarA.c;
                                    this.i = true;
                                    this.notifyAll();
                                }
                                break;
                            default:
                                continue;
                        }
                        synchronized (this) {
                            c.this.c();
                            this.notifyAll();
                            this.f = false;
                        }
                        return;
                    }
                }
                synchronized (this) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Iterator<f> it = this.m.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().close();
            } catch (IOException unused) {
            }
        }
        this.m.clear();
    }

    public f a(String str) throws ConnectException {
        int i = this.c + 1;
        this.c = i;
        if (!this.f) {
            throw new IllegalStateException("connect() must be called first");
        }
        a(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        f fVar = new f(this, i);
        this.m.put(Integer.valueOf(i), fVar);
        synchronized (this.a) {
            this.a.write(e.a(i, str));
            this.a.flush();
        }
        synchronized (fVar) {
            fVar.wait();
        }
        if (fVar.d()) {
            throw new ConnectException("Stream open actively rejected by remote peer");
        }
        return fVar;
    }

    public void a() {
        a(Long.MAX_VALUE, TimeUnit.MILLISECONDS, false);
    }

    public boolean a(long j, TimeUnit timeUnit, boolean z) {
        if (this.i) {
            throw new IllegalStateException("Already connected");
        }
        synchronized (this.a) {
            this.a.write(e.a());
            this.a.flush();
        }
        this.f = true;
        this.g = z;
        this.h = false;
        this.e.start();
        return a(j, timeUnit);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException, IOException {
        if (this.e == null) {
            return;
        }
        this.b.close();
        this.e.interrupt();
        try {
            this.e.join();
        } catch (InterruptedException unused) {
        }
    }
}
