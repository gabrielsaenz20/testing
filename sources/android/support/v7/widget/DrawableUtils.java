package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class DrawableUtils {
    public static final Rect INSETS_NONE = new Rect();
    private static final String TAG = "DrawableUtils";
    private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static Class<?> sInsetsClazz;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                sInsetsClazz = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    private DrawableUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean canSafelyMutateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2;
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (!(drawable instanceof DrawableContainer)) {
            if (drawable instanceof DrawableWrapper) {
                drawable2 = ((DrawableWrapper) drawable).getWrappedDrawable();
            } else if (drawable instanceof android.support.v7.graphics.drawable.DrawableWrapper) {
                drawable2 = ((android.support.v7.graphics.drawable.DrawableWrapper) drawable).getWrappedDrawable();
            } else {
                if (!(drawable instanceof ScaleDrawable)) {
                    return true;
                }
                drawable2 = ((ScaleDrawable) drawable).getDrawable();
            }
            return canSafelyMutateDrawable(drawable2);
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
            return true;
        }
        for (Drawable drawable3 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
            if (!canSafelyMutateDrawable(drawable3)) {
                return false;
            }
        }
        return true;
    }

    static void fixDrawable(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && VECTOR_DRAWABLE_CLAZZ_NAME.equals(drawable.getClass().getName())) {
            fixVectorDrawableTinting(drawable);
        }
    }

    private static void fixVectorDrawableTinting(Drawable drawable) {
        int[] state = drawable.getState();
        drawable.setState((state == null || state.length == 0) ? ThemeUtils.CHECKED_STATE_SET : ThemeUtils.EMPTY_STATE_SET);
        drawable.setState(state);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Rect getOpticalBounds(Drawable drawable) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        char c;
        if (sInsetsClazz != null) {
            try {
                Drawable drawableUnwrap = DrawableCompat.unwrap(drawable);
                Object objInvoke = drawableUnwrap.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(drawableUnwrap, new Object[0]);
                if (objInvoke != null) {
                    Rect rect = new Rect();
                    for (Field field : sInsetsClazz.getFields()) {
                        String name = field.getName();
                        int iHashCode = name.hashCode();
                        if (iHashCode != -1383228885) {
                            if (iHashCode != 115029) {
                                if (iHashCode != 3317767) {
                                    c = (iHashCode == 108511772 && name.equals("right")) ? (char) 2 : (char) 65535;
                                } else if (name.equals("left")) {
                                    c = 0;
                                }
                            } else if (name.equals("top")) {
                                c = 1;
                            }
                        } else if (name.equals("bottom")) {
                            c = 3;
                        }
                        switch (c) {
                            case 0:
                                rect.left = field.getInt(objInvoke);
                                break;
                            case 1:
                                rect.top = field.getInt(objInvoke);
                                break;
                            case 2:
                                rect.right = field.getInt(objInvoke);
                                break;
                            case 3:
                                rect.bottom = field.getInt(objInvoke);
                                break;
                        }
                    }
                    return rect;
                }
            } catch (Exception unused) {
                Log.e(TAG, "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return INSETS_NONE;
    }

    static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return Build.VERSION.SDK_INT >= 11 ? PorterDuff.Mode.valueOf("ADD") : mode;
            default:
                return mode;
        }
    }
}
