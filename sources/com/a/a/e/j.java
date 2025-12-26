package com.a.a.e;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import java.util.HashSet;

@TargetApi(11)
/* loaded from: classes.dex */
public class j extends Fragment {
    private final com.a.a.e.a a;
    private final l b;
    private com.a.a.j c;
    private final HashSet<j> d;
    private j e;

    private class a implements l {
        private a() {
        }
    }

    public j() {
        this(new com.a.a.e.a());
    }

    @SuppressLint({"ValidFragment"})
    j(com.a.a.e.a aVar) {
        this.b = new a();
        this.d = new HashSet<>();
        this.a = aVar;
    }

    private void a(j jVar) {
        this.d.add(jVar);
    }

    private void b(j jVar) {
        this.d.remove(jVar);
    }

    com.a.a.e.a a() {
        return this.a;
    }

    public void a(com.a.a.j jVar) {
        this.c = jVar;
    }

    public com.a.a.j b() {
        return this.c;
    }

    public l c() {
        return this.b;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.e = k.a().a(getActivity().getFragmentManager());
            if (this.e != this) {
                this.e.a(this);
            }
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.c();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.e != null) {
            this.e.b(this);
            this.e = null;
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        if (this.c != null) {
            this.c.a();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.a();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.b();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (this.c != null) {
            this.c.a(i);
        }
    }
}
