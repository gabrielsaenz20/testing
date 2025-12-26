package com.a.a.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a implements Closeable {
    private final File b;
    private final File c;
    private final File d;
    private final File e;
    private final int f;
    private long g;
    private final int h;
    private Writer j;
    private int l;
    private long i = 0;
    private final LinkedHashMap<String, b> k = new LinkedHashMap<>(0, 0.75f, true);
    private long m = 0;
    final ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> n = new Callable<Void>() { // from class: com.a.a.a.a.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                if (a.this.j == null) {
                    return null;
                }
                a.this.g();
                if (a.this.e()) {
                    a.this.d();
                    a.this.l = 0;
                }
                return null;
            }
        }
    };

    /* renamed from: com.a.a.a.a$a, reason: collision with other inner class name */
    public final class C0019a {
        private final b b;
        private final boolean[] c;
        private boolean d;

        private C0019a(b bVar) {
            this.b = bVar;
            this.c = bVar.f ? null : new boolean[a.this.h];
        }

        public File a(int i) {
            File fileB;
            synchronized (a.this) {
                if (this.b.g != this) {
                    throw new IllegalStateException();
                }
                if (!this.b.f) {
                    this.c[i] = true;
                }
                fileB = this.b.b(i);
                if (!a.this.b.exists()) {
                    a.this.b.mkdirs();
                }
            }
            return fileB;
        }

        public void a() {
            a.this.a(this, true);
            this.d = true;
        }

        public void b() {
            a.this.a(this, false);
        }

        public void c() {
            if (this.d) {
                return;
            }
            try {
                b();
            } catch (IOException unused) {
            }
        }
    }

    private final class b {
        File[] a;
        File[] b;
        private final String d;
        private final long[] e;
        private boolean f;
        private C0019a g;
        private long h;

        private b(String str) {
            this.d = str;
            this.e = new long[a.this.h];
            this.a = new File[a.this.h];
            this.b = new File[a.this.h];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < a.this.h; i++) {
                sb.append(i);
                this.a[i] = new File(a.this.b, sb.toString());
                sb.append(".tmp");
                this.b[i] = new File(a.this.b, sb.toString());
                sb.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length != a.this.h) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.e[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return this.a[i];
        }

        public String a() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.e) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File b(int i) {
            return this.b[i];
        }
    }

    public final class c {
        private final String b;
        private final long c;
        private final long[] d;
        private final File[] e;

        private c(String str, long j, File[] fileArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.e = fileArr;
            this.d = jArr;
        }

        public File a(int i) {
            return this.e[i];
        }
    }

    private a(File file, int i, int i2, long j) {
        this.b = file;
        this.f = i;
        this.c = new File(file, "journal");
        this.d = new File(file, "journal.tmp");
        this.e = new File(file, "journal.bkp");
        this.h = i2;
        this.g = j;
    }

    private synchronized C0019a a(String str, long j) {
        f();
        b bVar = this.k.get(str);
        if (j != -1 && (bVar == null || bVar.h != j)) {
            return null;
        }
        if (bVar == null) {
            bVar = new b(str);
            this.k.put(str, bVar);
        } else if (bVar.g != null) {
            return null;
        }
        C0019a c0019a = new C0019a(bVar);
        bVar.g = c0019a;
        this.j.append((CharSequence) "DIRTY");
        this.j.append(' ');
        this.j.append((CharSequence) str);
        this.j.append('\n');
        this.j.flush();
        return c0019a;
    }

    public static a a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, i, i2, j);
        if (aVar.c.exists()) {
            try {
                aVar.b();
                aVar.c();
                return aVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                aVar.a();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i, i2, j);
        aVar2.d();
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0019a c0019a, boolean z) {
        b bVar = c0019a.b;
        if (bVar.g != c0019a) {
            throw new IllegalStateException();
        }
        if (z && !bVar.f) {
            for (int i = 0; i < this.h; i++) {
                if (!c0019a.c[i]) {
                    c0019a.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!bVar.b(i).exists()) {
                    c0019a.b();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.h; i2++) {
            File fileB = bVar.b(i2);
            if (!z) {
                a(fileB);
            } else if (fileB.exists()) {
                File fileA = bVar.a(i2);
                fileB.renameTo(fileA);
                long j = bVar.e[i2];
                long length = fileA.length();
                bVar.e[i2] = length;
                this.i = (this.i - j) + length;
            }
        }
        this.l++;
        bVar.g = null;
        if (bVar.f || z) {
            bVar.f = true;
            this.j.append((CharSequence) "CLEAN");
            this.j.append(' ');
            this.j.append((CharSequence) bVar.d);
            this.j.append((CharSequence) bVar.a());
            this.j.append('\n');
            if (z) {
                long j2 = this.m;
                this.m = 1 + j2;
                bVar.h = j2;
            }
        } else {
            this.k.remove(bVar.d);
            this.j.append((CharSequence) "REMOVE");
            this.j.append(' ');
            this.j.append((CharSequence) bVar.d);
            this.j.append('\n');
        }
        this.j.flush();
        if (this.i > this.g || e()) {
            this.a.submit(this.n);
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void b() throws IOException {
        com.a.a.a.b bVar = new com.a.a.a.b(new FileInputStream(this.c), com.a.a.a.c.a);
        try {
            String strA = bVar.a();
            String strA2 = bVar.a();
            String strA3 = bVar.a();
            String strA4 = bVar.a();
            String strA5 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(strA) || !"1".equals(strA2) || !Integer.toString(this.f).equals(strA3) || !Integer.toString(this.h).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(bVar.a());
                    i++;
                } catch (EOFException unused) {
                    this.l = i - this.k.size();
                    if (bVar.b()) {
                        d();
                    } else {
                        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), com.a.a.a.c.a));
                    }
                    com.a.a.a.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.a.a.a.c.a(bVar);
            throw th;
        }
    }

    private void c() throws IOException {
        a(this.d);
        Iterator<b> it = this.k.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.g == null) {
                while (i < this.h) {
                    this.i += next.e[i];
                    i++;
                }
            } else {
                next.g = null;
                while (i < this.h) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        if (this.j != null) {
            this.j.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d), com.a.a.a.c.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.h));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b bVar : this.k.values()) {
                bufferedWriter.write(bVar.g != null ? "DIRTY " + bVar.d + '\n' : "CLEAN " + bVar.d + bVar.a() + '\n');
            }
            bufferedWriter.close();
            if (this.c.exists()) {
                a(this.c, this.e, true);
            }
            a(this.d, this.c, false);
            this.e.delete();
            this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), com.a.a.a.c.a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private void d(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.k.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        b bVar = this.k.get(strSubstring);
        if (bVar == null) {
            bVar = new b(strSubstring);
            this.k.put(strSubstring, bVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            bVar.f = true;
            bVar.g = null;
            bVar.a(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            bVar.g = new C0019a(bVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == "READ".length() && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return this.l >= 2000 && this.l >= this.k.size();
    }

    private void f() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        while (this.i > this.g) {
            c(this.k.entrySet().iterator().next().getKey());
        }
    }

    public synchronized c a(String str) {
        f();
        b bVar = this.k.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.f) {
            return null;
        }
        for (File file : bVar.a) {
            if (!file.exists()) {
                return null;
            }
        }
        this.l++;
        this.j.append((CharSequence) "READ");
        this.j.append(' ');
        this.j.append((CharSequence) str);
        this.j.append('\n');
        if (e()) {
            this.a.submit(this.n);
        }
        return new c(str, bVar.h, bVar.a, bVar.e);
    }

    public void a() throws IOException {
        close();
        com.a.a.a.c.a(this.b);
    }

    public C0019a b(String str) {
        return a(str, -1L);
    }

    public synchronized boolean c(String str) {
        f();
        b bVar = this.k.get(str);
        if (bVar != null && bVar.g == null) {
            for (int i = 0; i < this.h; i++) {
                File fileA = bVar.a(i);
                if (fileA.exists() && !fileA.delete()) {
                    throw new IOException("failed to delete " + fileA);
                }
                this.i -= bVar.e[i];
                bVar.e[i] = 0;
            }
            this.l++;
            this.j.append((CharSequence) "REMOVE");
            this.j.append(' ');
            this.j.append((CharSequence) str);
            this.j.append('\n');
            this.k.remove(str);
            if (e()) {
                this.a.submit(this.n);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.j == null) {
            return;
        }
        Iterator it = new ArrayList(this.k.values()).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.g != null) {
                bVar.g.b();
            }
        }
        g();
        this.j.close();
        this.j = null;
    }
}
