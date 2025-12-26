package com.a.a.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;
import java.util.HashSet;

/* loaded from: classes.dex */
public class n extends Fragment {
    private com.a.a.j a;
    private final com.a.a.e.a b;
    private final l c;
    private final HashSet<n> d;
    private n e;

    private class a implements l {
        private a() {
        }
    }

    public n() {
        this(new com.a.a.e.a());
    }

    @SuppressLint({"ValidFragment"})
    public n(com.a.a.e.a aVar) {
        this.c = new a();
        this.d = new HashSet<>();
        this.b = aVar;
    }

    private void a(n nVar) {
        this.d.add(nVar);
    }

    private void b(n nVar) {
        this.d.remove(nVar);
    }

    com.a.a.e.a a() {
        return this.b;
    }

    public void a(com.a.a.j jVar) {
        this.a = jVar;
    }

    public com.a.a.j b() {
        return this.a;
    }

    public l c() {
        return this.c;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.e = k.a().a(getActivity().getSupportFragmentManager());
            if (this.e != this) {
                this.e.a(this);
            }
        } catch (IllegalStateException e) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.b.c();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.e != null) {
            this.e.b(this);
            this.e = null;
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (this.a != null) {
            this.a.a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.b.a();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.b.b();
    }
}
