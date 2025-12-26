package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.transition.TransitionPort;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

@RequiresApi(14)
@TargetApi(14)
/* loaded from: classes.dex */
class FadePort extends VisibilityPort {
    private static boolean DBG = false;
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_SCREEN_X = "android:fade:screenX";
    private static final String PROPNAME_SCREEN_Y = "android:fade:screenY";
    private int mFadingMode;

    public FadePort() {
        this(3);
    }

    public FadePort(int i) {
        this.mFadingMode = i;
    }

    private void captureValues(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_X, Integer.valueOf(iArr[0]));
        transitionValues.values.put(PROPNAME_SCREEN_Y, Integer.valueOf(iArr[1]));
    }

    private Animator createAnimation(View view, float f, float f2, AnimatorListenerAdapter animatorListenerAdapter) {
        if (f == f2) {
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(null);
            }
            return null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", f, f2);
        if (DBG) {
            Log.d(LOG_TAG, "Created animator " + objectAnimatorOfFloat);
        }
        if (animatorListenerAdapter != null) {
            objectAnimatorOfFloat.addListener(animatorListenerAdapter);
        }
        return objectAnimatorOfFloat;
    }

    @Override // android.support.transition.VisibilityPort, android.support.transition.TransitionPort
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // android.support.transition.VisibilityPort
    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mFadingMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        final View view = transitionValues2.view;
        if (DBG) {
            Log.d(LOG_TAG, "Fade.onAppear: startView, startVis, endView, endVis = " + (transitionValues != null ? transitionValues.view : null) + ", " + i + ", " + view + ", " + i2);
        }
        view.setAlpha(0.0f);
        addListener(new TransitionPort.TransitionListenerAdapter() { // from class: android.support.transition.FadePort.1
            boolean mCanceled = false;
            float mPausedAlpha;

            @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
            public void onTransitionCancel(TransitionPort transitionPort) {
                view.setAlpha(1.0f);
                this.mCanceled = true;
            }

            @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
            public void onTransitionEnd(TransitionPort transitionPort) {
                if (this.mCanceled) {
                    return;
                }
                view.setAlpha(1.0f);
            }

            @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
            public void onTransitionPause(TransitionPort transitionPort) {
                this.mPausedAlpha = view.getAlpha();
                view.setAlpha(1.0f);
            }

            @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
            public void onTransitionResume(TransitionPort transitionPort) {
                view.setAlpha(this.mPausedAlpha);
            }
        });
        return createAnimation(view, 0.0f, 1.0f, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ee  */
    @Override // android.support.transition.VisibilityPort
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Animator onDisappear(final ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, final int i2) {
        final View view;
        final View view2;
        View view3;
        AnimatorListenerAdapter animatorListenerAdapter;
        if ((this.mFadingMode & 2) != 2) {
            return null;
        }
        View view4 = transitionValues != null ? transitionValues.view : null;
        View view5 = transitionValues2 != null ? transitionValues2.view : null;
        if (DBG) {
            Log.d(LOG_TAG, "Fade.onDisappear: startView, startVis, endView, endVis = " + view4 + ", " + i + ", " + view5 + ", " + i2);
        }
        if (view5 == null || view5.getParent() == null) {
            if (view5 == null) {
                if (view4 != null) {
                    if (view4.getParent() != null) {
                        if ((view4.getParent() instanceof View) && view4.getParent().getParent() == null) {
                            int id = ((View) view4.getParent()).getId();
                            if (id == -1 || viewGroup.findViewById(id) == null || !this.mCanRemoveViews) {
                                view3 = null;
                                view4 = null;
                            } else {
                                view3 = view4;
                            }
                            view2 = view3;
                            view5 = view4;
                        }
                    }
                    view5 = view4;
                }
                view5 = null;
                view = null;
                view2 = null;
                if (view2 == null) {
                    int iIntValue = ((Integer) transitionValues.values.get(PROPNAME_SCREEN_X)).intValue();
                    int iIntValue2 = ((Integer) transitionValues.values.get(PROPNAME_SCREEN_Y)).intValue();
                    int[] iArr = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    ViewCompat.offsetLeftAndRight(view2, (iIntValue - iArr[0]) - view2.getLeft());
                    ViewCompat.offsetTopAndBottom(view2, (iIntValue2 - iArr[1]) - view2.getTop());
                    ViewGroupOverlay.createFrom(viewGroup).add(view2);
                    final View view6 = view5;
                    animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: android.support.transition.FadePort.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            view6.setAlpha(1.0f);
                            if (view != null) {
                                view.setVisibility(i2);
                            }
                            if (view2 != null) {
                                ViewGroupOverlay.createFrom(viewGroup).remove(view2);
                            }
                        }
                    };
                } else {
                    if (view == null) {
                        return null;
                    }
                    view.setVisibility(0);
                    final View view7 = view5;
                    animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: android.support.transition.FadePort.3
                        boolean mCanceled = false;
                        float mPausedAlpha = -1.0f;

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            this.mCanceled = true;
                            if (this.mPausedAlpha >= 0.0f) {
                                view7.setAlpha(this.mPausedAlpha);
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (!this.mCanceled) {
                                view7.setAlpha(1.0f);
                            }
                            if (view != null && !this.mCanceled) {
                                view.setVisibility(i2);
                            }
                            if (view2 != null) {
                                ViewGroupOverlay.createFrom(viewGroup).add(view2);
                            }
                        }
                    };
                }
                return createAnimation(view5, 1.0f, 0.0f, animatorListenerAdapter);
            }
            view = null;
            if (view2 == null) {
            }
            return createAnimation(view5, 1.0f, 0.0f, animatorListenerAdapter);
        }
        if (i2 == 4 || view4 == view5) {
            view = view5;
            view2 = null;
            if (view2 == null) {
            }
            return createAnimation(view5, 1.0f, 0.0f, animatorListenerAdapter);
        }
        view5 = view4;
        view2 = view5;
        view = null;
        if (view2 == null) {
        }
        return createAnimation(view5, 1.0f, 0.0f, animatorListenerAdapter);
    }
}
