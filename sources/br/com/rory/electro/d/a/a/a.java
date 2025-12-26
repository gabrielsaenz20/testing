package br.com.rory.electro.d.a.a;

import android.support.annotation.NonNull;
import android.support.design.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.rory.electro.NativeLoader;
import java.util.List;

/* loaded from: classes.dex */
public class a extends RecyclerView.Adapter<b> {
    private List<br.com.rory.electro.d.a.a.b> a;
    private InterfaceC0013a b;

    /* renamed from: br.com.rory.electro.d.a.a.a$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ br.com.rory.electro.d.a.a.b a;

        static {
            NativeLoader.classesInit0(R.styleable.AppCompatTheme_windowActionModeOverlay);
        }

        AnonymousClass1(br.com.rory.electro.d.a.a.b bVar) {
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* renamed from: br.com.rory.electro.d.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0013a {
        void a(int i);
    }

    public static class b extends RecyclerView.ViewHolder {
        TextView a;
        TextView b;
        Button c;

        public b(@NonNull View view) {
            super(view);
            this.a = (TextView) view.findViewById(br.com.rory.electro.R.id.userName);
            this.b = (TextView) view.findViewById(br.com.rory.electro.R.id.userEmail);
            this.c = (Button) view.findViewById(br.com.rory.electro.R.id.btnRemove);
        }
    }

    static {
        NativeLoader.classesInit0(346);
    }

    public a(List<br.com.rory.electro.d.a.a.b> list, InterfaceC0013a interfaceC0013a) {
        this.a = list;
        this.b = interfaceC0013a;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public native b onCreateViewHolder(ViewGroup viewGroup, int i);

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public native void onBindViewHolder(b bVar, int i);

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public native int getItemCount();
}
