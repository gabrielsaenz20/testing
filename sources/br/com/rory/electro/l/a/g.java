package br.com.rory.electro.l.a;

import android.content.Context;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.rory.electro.NativeLoader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g implements a {
    static {
        NativeLoader.classesInit0(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
    }

    @Override // br.com.rory.electro.l.a.a
    public native String a();

    @Override // br.com.rory.electro.l.a.a
    public native void a(Context context, br.com.rory.electro.k.a.d dVar, JSONObject jSONObject);
}
