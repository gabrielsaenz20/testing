package br.com.rory.electro.l;

import android.content.Context;
import br.com.rory.electro.c.a.a.d;
import br.com.rory.electro.c.a.a.f;
import br.com.rory.electro.c.a.a.g;
import com.rory.electro.NativeLoader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import org.json.JSONArray;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.DataChannel;
import org.webrtc.EglBase;
import org.webrtc.IceCandidate;
import org.webrtc.MediaConstraints;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.RtpSender;
import org.webrtc.SessionDescription;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
import org.webrtc.audio.JavaAudioDeviceModule;

/* loaded from: classes.dex */
public class c implements d, g {
    private static final List<String> a;
    private PeerConnectionFactory b;
    private PeerConnection c;
    private MediaConstraints d;
    private DataChannel e;
    private EglBase f;
    private SurfaceTextureHelper g;
    private VideoSource h;
    private VideoTrack i;
    private ExecutorService j;
    private br.com.rory.electro.c.a.a.c k;
    private f l;
    private br.com.rory.electro.l.b.a m;
    private Context n;
    private br.com.rory.electro.k.a.d o;
    private String p;
    private AudioSource t;
    private AudioTrack u;
    private JavaAudioDeviceModule v;
    private RtpSender w;
    private boolean q = false;
    private int r = 1;
    private boolean s = false;
    private boolean x = false;
    private boolean y = false;

    /* renamed from: br.com.rory.electro.l.c$1, reason: invalid class name */
    class AnonymousClass1 implements ThreadFactory {
        static {
            NativeLoader.classesInit0(422);
        }

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public native Thread newThread(Runnable runnable);
    }

    /* renamed from: br.com.rory.electro.l.c$2, reason: invalid class name */
    class AnonymousClass2 extends a {
        static {
            NativeLoader.classesInit0(421);
        }

        AnonymousClass2() {
        }

        @Override // br.com.rory.electro.l.a, org.webrtc.PeerConnection.Observer
        public native void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState);

        @Override // br.com.rory.electro.l.a, org.webrtc.PeerConnection.Observer
        public native void onIceCandidate(IceCandidate iceCandidate);

        @Override // br.com.rory.electro.l.a, org.webrtc.PeerConnection.Observer
        public native void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState);
    }

    /* renamed from: br.com.rory.electro.l.c$3, reason: invalid class name */
    class AnonymousClass3 extends b {
        static {
            NativeLoader.classesInit0(425);
        }

        AnonymousClass3() {
        }

        @Override // br.com.rory.electro.l.b, org.webrtc.SdpObserver
        public native void onCreateSuccess(SessionDescription sessionDescription);
    }

    /* renamed from: br.com.rory.electro.l.c$4, reason: invalid class name */
    class AnonymousClass4 extends b {
        static {
            NativeLoader.classesInit0(424);
        }

        AnonymousClass4() {
        }

        @Override // br.com.rory.electro.l.b, org.webrtc.SdpObserver
        public native void onCreateSuccess(SessionDescription sessionDescription);
    }

    /* renamed from: br.com.rory.electro.l.c$5, reason: invalid class name */
    class AnonymousClass5 implements DataChannel.Observer {
        static {
            NativeLoader.classesInit0(427);
        }

        AnonymousClass5() {
        }

        @Override // org.webrtc.DataChannel.Observer
        public native void onBufferedAmountChange(long j);

        @Override // org.webrtc.DataChannel.Observer
        public native void onMessage(DataChannel.Buffer buffer);

        @Override // org.webrtc.DataChannel.Observer
        public native void onStateChange();
    }

    /* renamed from: br.com.rory.electro.l.c$6, reason: invalid class name */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ byte[] a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ long d;

        static {
            NativeLoader.classesInit0(426);
        }

        AnonymousClass6(byte[] bArr, int i, int i2, long j) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* renamed from: br.com.rory.electro.l.c$7, reason: invalid class name */
    class AnonymousClass7 implements Runnable {
        static {
            NativeLoader.classesInit0(429);
        }

        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        NativeLoader.classesInit0(133);
        a = Arrays.asList("ARDAMS");
    }

    public c(Context context, br.com.rory.electro.k.a.d dVar, String str) {
        this.n = context;
        this.o = dVar;
        this.p = str;
        this.k = new br.com.rory.electro.c.a.a.c(context, str);
        this.k.a(this);
        this.l = new f(context, str + "_video");
        this.l.a(this);
        this.m = new br.com.rory.electro.l.b.a(this);
        a(br.com.rory.electro.i.b.a());
    }

    private native void a(EglBase eglBase);

    /* JADX INFO: Access modifiers changed from: private */
    public native void b(IceCandidate iceCandidate);

    /* JADX INFO: Access modifiers changed from: private */
    public native void b(SessionDescription sessionDescription);

    /* JADX INFO: Access modifiers changed from: private */
    public native void c(byte[] bArr, int i, int i2, long j);

    private static native String n();

    private static native String o();

    private static native String p();

    private native void q();

    private native void r();

    private native void s();

    private native void t();

    @Override // br.com.rory.electro.c.a.a.g
    public native void a();

    public native void a(int i);

    @Override // br.com.rory.electro.c.a.a.g
    public native void a(int i, int i2);

    @Override // br.com.rory.electro.c.a.a.d, br.com.rory.electro.c.a.a.g
    public native void a(String str);

    public native void a(JSONArray jSONArray);

    public native void a(IceCandidate iceCandidate);

    public native void a(SessionDescription sessionDescription);

    @Override // br.com.rory.electro.c.a.a.g
    public native void a(boolean z);

    @Override // br.com.rory.electro.c.a.a.d, br.com.rory.electro.c.a.a.g
    public native void a(byte[] bArr, int i, int i2, long j);

    @Override // br.com.rory.electro.c.a.a.g
    public native void b();

    public native void b(String str);

    @Override // br.com.rory.electro.c.a.a.g
    public native void b(byte[] bArr, int i, int i2, long j);

    public native void c();

    public native boolean c(String str);

    public native void d();

    public native boolean e();

    public native void f();

    public native void g();

    public native void h();

    public native void i();

    public native synchronized void j();

    public native synchronized void k();

    public native void l();

    public native void m();
}
