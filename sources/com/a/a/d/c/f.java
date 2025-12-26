package com.a.a.d.c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.InputStream;

/* loaded from: classes.dex */
public class f<A> implements l<A, g> {
    private final l<A, InputStream> a;
    private final l<A, ParcelFileDescriptor> b;

    static class a implements com.a.a.d.a.c<g> {
        private final com.a.a.d.a.c<InputStream> a;
        private final com.a.a.d.a.c<ParcelFileDescriptor> b;

        public a(com.a.a.d.a.c<InputStream> cVar, com.a.a.d.a.c<ParcelFileDescriptor> cVar2) {
            this.a = cVar;
            this.b = cVar2;
        }

        @Override // com.a.a.d.a.c
        public void a() {
            if (this.a != null) {
                this.a.a();
            }
            if (this.b != null) {
                this.b.a();
            }
        }

        @Override // com.a.a.d.a.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(com.a.a.i iVar) throws Exception {
            InputStream inputStreamA;
            ParcelFileDescriptor parcelFileDescriptorA;
            if (this.a != null) {
                try {
                    inputStreamA = this.a.a(iVar);
                } catch (Exception e) {
                    if (Log.isLoggable("IVML", 2)) {
                        Log.v("IVML", "Exception fetching input stream, trying ParcelFileDescriptor", e);
                    }
                    if (this.b == null) {
                        throw e;
                    }
                }
            } else {
                inputStreamA = null;
            }
            if (this.b != null) {
                try {
                    parcelFileDescriptorA = this.b.a(iVar);
                } catch (Exception e2) {
                    if (Log.isLoggable("IVML", 2)) {
                        Log.v("IVML", "Exception fetching ParcelFileDescriptor", e2);
                    }
                    if (inputStreamA == null) {
                        throw e2;
                    }
                }
            } else {
                parcelFileDescriptorA = null;
            }
            return new g(inputStreamA, parcelFileDescriptorA);
        }

        @Override // com.a.a.d.a.c
        public String b() {
            return (this.a != null ? this.a : this.b).b();
        }

        @Override // com.a.a.d.a.c
        public void c() {
            if (this.a != null) {
                this.a.c();
            }
            if (this.b != null) {
                this.b.c();
            }
        }
    }

    public f(l<A, InputStream> lVar, l<A, ParcelFileDescriptor> lVar2) {
        if (lVar == null && lVar2 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.a = lVar;
        this.b = lVar2;
    }

    @Override // com.a.a.d.c.l
    public com.a.a.d.a.c<g> a(A a2, int i, int i2) {
        com.a.a.d.a.c<InputStream> cVarA = this.a != null ? this.a.a(a2, i, i2) : null;
        com.a.a.d.a.c<ParcelFileDescriptor> cVarA2 = this.b != null ? this.b.a(a2, i, i2) : null;
        if (cVarA == null && cVarA2 == null) {
            return null;
        }
        return new a(cVarA, cVarA2);
    }
}
