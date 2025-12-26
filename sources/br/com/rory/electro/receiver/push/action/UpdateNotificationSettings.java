package br.com.rory.electro.receiver.push.action;

import android.content.Context;
import com.rory.electro.NativeLoader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class UpdateNotificationSettings implements PushAction {
    static {
        NativeLoader.classesInit0(184);
    }

    private static native String getTag();

    @Override // br.com.rory.electro.receiver.push.action.PushAction
    public native void execute(Context context, JSONObject jSONObject);
}
