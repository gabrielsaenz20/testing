package br.com.rory.electro.k.a;

import android.content.Context;
import android.support.v7.widget.helper.ItemTouchHelper;
import br.com.rory.electro.l.a.aa;
import br.com.rory.electro.l.a.ab;
import br.com.rory.electro.l.a.ac;
import br.com.rory.electro.l.a.ad;
import br.com.rory.electro.l.a.ae;
import br.com.rory.electro.l.a.af;
import br.com.rory.electro.l.a.ag;
import br.com.rory.electro.l.a.ah;
import br.com.rory.electro.l.a.ai;
import br.com.rory.electro.l.a.aj;
import br.com.rory.electro.l.a.ak;
import br.com.rory.electro.l.a.e;
import br.com.rory.electro.l.a.f;
import br.com.rory.electro.l.a.g;
import br.com.rory.electro.l.a.h;
import br.com.rory.electro.l.a.i;
import br.com.rory.electro.l.a.j;
import br.com.rory.electro.l.a.k;
import br.com.rory.electro.l.a.l;
import br.com.rory.electro.l.a.m;
import br.com.rory.electro.l.a.n;
import br.com.rory.electro.l.a.o;
import br.com.rory.electro.l.a.p;
import br.com.rory.electro.l.a.q;
import br.com.rory.electro.l.a.r;
import br.com.rory.electro.l.a.s;
import br.com.rory.electro.l.a.t;
import br.com.rory.electro.l.a.u;
import br.com.rory.electro.l.a.v;
import br.com.rory.electro.l.a.w;
import br.com.rory.electro.l.a.x;
import br.com.rory.electro.l.a.y;
import br.com.rory.electro.l.a.z;
import com.rory.electro.NativeLoader;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {
    private static final Map<String, Class<? extends br.com.rory.electro.l.a.a>> a;
    private Socket b;
    private Context c;
    private String d;
    private int e;
    private br.com.rory.electro.l.c f;
    private volatile boolean g = true;

    /* renamed from: br.com.rory.electro.k.a.d$1, reason: invalid class name */
    class AnonymousClass1 implements Emitter.Listener {
        final /* synthetic */ String a;

        static {
            NativeLoader.classesInit0(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        }

        AnonymousClass1(String str) {
            this.a = str;
        }

        @Override // io.socket.emitter.Emitter.Listener
        public native void call(Object... objArr);
    }

    /* renamed from: br.com.rory.electro.k.a.d$2, reason: invalid class name */
    class AnonymousClass2 implements Emitter.Listener {
        final /* synthetic */ d a;
        final /* synthetic */ String b;

        static {
            NativeLoader.classesInit0(251);
        }

        AnonymousClass2(d dVar, String str) {
            this.a = dVar;
            this.b = str;
        }

        @Override // io.socket.emitter.Emitter.Listener
        public native void call(Object... objArr);
    }

    /* renamed from: br.com.rory.electro.k.a.d$3, reason: invalid class name */
    class AnonymousClass3 implements Emitter.Listener {
        static {
            NativeLoader.classesInit0(135);
        }

        AnonymousClass3() {
        }

        @Override // io.socket.emitter.Emitter.Listener
        public native void call(Object... objArr);
    }

    /* renamed from: br.com.rory.electro.k.a.d$4, reason: invalid class name */
    class AnonymousClass4 implements Emitter.Listener {
        static {
            NativeLoader.classesInit0(136);
        }

        AnonymousClass4() {
        }

        @Override // io.socket.emitter.Emitter.Listener
        public native void call(Object... objArr);
    }

    /* renamed from: br.com.rory.electro.k.a.d$5, reason: invalid class name */
    class AnonymousClass5 implements Emitter.Listener {
        final /* synthetic */ String a;

        static {
            NativeLoader.classesInit0(138);
        }

        AnonymousClass5(String str) {
            this.a = str;
        }

        @Override // io.socket.emitter.Emitter.Listener
        public native void call(Object... objArr);
    }

    static {
        NativeLoader.classesInit0(24);
        a = new HashMap();
        a((Class<? extends br.com.rory.electro.l.a.a>) br.com.rory.electro.l.a.b.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) br.com.rory.electro.l.a.c.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) br.com.rory.electro.l.a.d.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) e.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) f.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) g.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) h.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) i.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) j.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) k.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) l.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) m.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) n.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) o.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) p.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) q.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) r.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) s.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) t.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) u.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) v.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) w.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) x.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) y.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) z.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) aa.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) ab.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) ac.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) ad.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) ae.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) af.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) ag.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) ah.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) ai.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) aj.class);
        a((Class<? extends br.com.rory.electro.l.a.a>) ak.class);
    }

    public d(Context context) {
        this.c = context;
    }

    private static native void a(Class<? extends br.com.rory.electro.l.a.a> cls);

    /* JADX INFO: Access modifiers changed from: private */
    public native void a(String str, Object obj);

    public native void a(String str);

    public native void a(String str, JSONObject jSONObject);

    public native void a(boolean z);

    public native boolean a();

    public native boolean a(JSONObject jSONObject);

    public native br.com.rory.electro.l.c b();

    public native void b(String str);

    public native void b(JSONObject jSONObject);

    public native void c(JSONObject jSONObject);
}
