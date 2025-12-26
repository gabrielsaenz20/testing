package android.support.transition;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;

@RequiresApi(14)
@TargetApi(14)
/* loaded from: classes.dex */
abstract class VisibilityPort extends TransitionPort {
    private static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};

    private static class VisibilityInfo {
        ViewGroup endParent;
        int endVisibility;
        boolean fadeIn;
        ViewGroup startParent;
        int startVisibility;
        boolean visibilityChange;

        VisibilityInfo() {
        }
    }

    VisibilityPort() {
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0074, code lost:
    
        if (r5.endVisibility == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
    
        r5.fadeIn = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
    
        if (r5.startParent == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.visibilityChange = false;
        visibilityInfo.fadeIn = false;
        ViewGroup viewGroup = null;
        if (transitionValues != null) {
            visibilityInfo.startVisibility = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.startParent = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
        } else {
            visibilityInfo.startVisibility = -1;
            visibilityInfo.startParent = null;
        }
        if (transitionValues2 != null) {
            visibilityInfo.endVisibility = ((Integer) transitionValues2.values.get(PROPNAME_VISIBILITY)).intValue();
            viewGroup = (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT);
        } else {
            visibilityInfo.endVisibility = -1;
        }
        visibilityInfo.endParent = viewGroup;
        if (transitionValues != null && transitionValues2 != null) {
            if (visibilityInfo.startVisibility == visibilityInfo.endVisibility && visibilityInfo.startParent == visibilityInfo.endParent) {
                return visibilityInfo;
            }
            if (visibilityInfo.startVisibility != visibilityInfo.endVisibility) {
                if (visibilityInfo.startVisibility != 0) {
                }
                visibilityInfo.fadeIn = false;
            } else if (visibilityInfo.startParent != visibilityInfo.endParent) {
                if (visibilityInfo.endParent != null) {
                }
                visibilityInfo.fadeIn = false;
            }
            visibilityInfo.visibilityChange = true;
        }
        if (transitionValues == null) {
            visibilityInfo.fadeIn = true;
        } else {
            if (transitionValues2 != null) {
                return visibilityInfo;
            }
            visibilityInfo.fadeIn = false;
        }
        visibilityInfo.visibilityChange = true;
        return visibilityInfo;
    }

    @Override // android.support.transition.TransitionPort
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.support.transition.TransitionPort
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.support.transition.TransitionPort
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (visibilityChangeInfo.visibilityChange) {
            boolean z = false;
            if (this.mTargets.size() > 0 || this.mTargetIds.size() > 0) {
                View view = transitionValues != null ? transitionValues.view : null;
                View view2 = transitionValues2 != null ? transitionValues2.view : null;
                int id = view != null ? view.getId() : -1;
                int id2 = view2 != null ? view2.getId() : -1;
                if (isValidTarget(view, id) || isValidTarget(view2, id2)) {
                    z = true;
                }
            }
            if (z || visibilityChangeInfo.startParent != null || visibilityChangeInfo.endParent != null) {
                return visibilityChangeInfo.fadeIn ? onAppear(viewGroup, transitionValues, visibilityChangeInfo.startVisibility, transitionValues2, visibilityChangeInfo.endVisibility) : onDisappear(viewGroup, transitionValues, visibilityChangeInfo.startVisibility, transitionValues2, visibilityChangeInfo.endVisibility);
            }
        }
        return null;
    }

    @Override // android.support.transition.TransitionPort
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        return ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue() == 0 && ((View) transitionValues.values.get(PROPNAME_PARENT)) != null;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        return null;
    }

    public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        return null;
    }
}
