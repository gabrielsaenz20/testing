package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiresApi(14)
@TargetApi(14)
/* loaded from: classes.dex */
abstract class TransitionPort implements Cloneable {
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal<>();
    long mStartDelay = -1;
    long mDuration = -1;
    TimeInterpolator mInterpolator = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    ArrayList<View> mTargets = new ArrayList<>();
    ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<View> mTargetExcludes = null;
    ArrayList<Class> mTargetTypeExcludes = null;
    ArrayList<Integer> mTargetIdChildExcludes = null;
    ArrayList<View> mTargetChildExcludes = null;
    ArrayList<Class> mTargetTypeChildExcludes = null;
    TransitionSetPort mParent = null;
    ViewGroup mSceneRoot = null;
    boolean mCanRemoveViews = false;
    int mNumInstances = 0;
    boolean mPaused = false;
    ArrayList<TransitionListener> mListeners = null;
    ArrayList<Animator> mAnimators = new ArrayList<>();
    private String mName = getClass().getName();
    private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    private boolean mEnded = false;

    private static class AnimationInfo {
        String name;
        TransitionValues values;
        View view;
        WindowIdPort windowId;

        AnimationInfo(View view, String str, WindowIdPort windowIdPort, TransitionValues transitionValues) {
            this.view = view;
            this.name = str;
            this.values = transitionValues;
            this.windowId = windowIdPort;
        }
    }

    private static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> add(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> remove(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public interface TransitionListener {
        void onTransitionCancel(TransitionPort transitionPort);

        void onTransitionEnd(TransitionPort transitionPort);

        void onTransitionPause(TransitionPort transitionPort);

        void onTransitionResume(TransitionPort transitionPort);

        void onTransitionStart(TransitionPort transitionPort);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class TransitionListenerAdapter implements TransitionListener {
        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionCancel(TransitionPort transitionPort) {
        }

        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionEnd(TransitionPort transitionPort) {
        }

        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionPause(TransitionPort transitionPort) {
        }

        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionResume(TransitionPort transitionPort) {
        }

        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionStart(TransitionPort transitionPort) {
        }
    }

    private void captureHierarchy(View view, boolean z) {
        TransitionValuesMaps transitionValuesMaps;
        TransitionValuesMaps transitionValuesMaps2;
        if (view == null) {
            return;
        }
        boolean z2 = view.getParent() instanceof ListView;
        if (!z2 || ((ListView) view.getParent()).getAdapter().hasStableIds()) {
            int id = -1;
            long itemIdAtPosition = -1;
            if (z2) {
                ListView listView = (ListView) view.getParent();
                itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
            } else {
                id = view.getId();
            }
            if (this.mTargetIdExcludes == null || !this.mTargetIdExcludes.contains(Integer.valueOf(id))) {
                if (this.mTargetExcludes == null || !this.mTargetExcludes.contains(view)) {
                    if (this.mTargetTypeExcludes != null && view != null) {
                        int size = this.mTargetTypeExcludes.size();
                        for (int i = 0; i < size; i++) {
                            if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                                return;
                            }
                        }
                    }
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.view = view;
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    if (z) {
                        if (z2) {
                            transitionValuesMaps = this.mStartValues;
                            transitionValuesMaps.itemIdValues.put(itemIdAtPosition, transitionValues);
                        } else {
                            this.mStartValues.viewValues.put(view, transitionValues);
                            if (id >= 0) {
                                transitionValuesMaps2 = this.mStartValues;
                                transitionValuesMaps2.idValues.put(id, transitionValues);
                            }
                        }
                    } else if (z2) {
                        transitionValuesMaps = this.mEndValues;
                        transitionValuesMaps.itemIdValues.put(itemIdAtPosition, transitionValues);
                    } else {
                        this.mEndValues.viewValues.put(view, transitionValues);
                        if (id >= 0) {
                            transitionValuesMaps2 = this.mEndValues;
                            transitionValuesMaps2.idValues.put(id, transitionValues);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        if (this.mTargetIdChildExcludes == null || !this.mTargetIdChildExcludes.contains(Integer.valueOf(id))) {
                            if (this.mTargetChildExcludes == null || !this.mTargetChildExcludes.contains(view)) {
                                if (this.mTargetTypeChildExcludes != null && view != null) {
                                    int size2 = this.mTargetTypeChildExcludes.size();
                                    for (int i2 = 0; i2 < size2; i2++) {
                                        if (this.mTargetTypeChildExcludes.get(i2).isInstance(view)) {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                    captureHierarchy(viewGroup.getChildAt(i3), z);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        return i > 0 ? z ? ArrayListManager.add(arrayList, Integer.valueOf(i)) : ArrayListManager.remove(arrayList, Integer.valueOf(i)) : arrayList;
    }

    private ArrayList<Class> excludeType(ArrayList<Class> arrayList, Class cls, boolean z) {
        return cls != null ? z ? ArrayListManager.add(arrayList, cls) : ArrayListManager.remove(arrayList, cls) : arrayList;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        return view != null ? z ? ArrayListManager.add(arrayList, view) : ArrayListManager.remove(arrayList, view) : arrayList;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> arrayMap = sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
        sRunningAnimators.set(arrayMap2);
        return arrayMap2;
    }

    private void runAnimator(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.TransitionPort.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    arrayMap.remove(animator2);
                    TransitionPort.this.mCurrentAnimators.remove(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    TransitionPort.this.mCurrentAnimators.add(animator2);
                }
            });
            animate(animator);
        }
    }

    public TransitionPort addListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    public TransitionPort addTarget(int i) {
        if (i > 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    public TransitionPort addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.TransitionPort.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                TransitionPort.this.end();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        if (this.mListeners == null || this.mListeners.size() <= 0) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.mListeners.clone();
        int size2 = arrayList.size();
        for (int i = 0; i < size2; i++) {
            ((TransitionListener) arrayList.get(i)).onTransitionCancel(this);
        }
    }

    public abstract void captureEndValues(TransitionValues transitionValues);

    public abstract void captureStartValues(TransitionValues transitionValues);

    void captureValues(ViewGroup viewGroup, boolean z) {
        TransitionValuesMaps transitionValuesMaps;
        clearValues(z);
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            captureHierarchy(viewGroup, z);
            return;
        }
        if (this.mTargetIds.size() > 0) {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                int iIntValue = this.mTargetIds.get(i).intValue();
                View viewFindViewById = viewGroup.findViewById(iIntValue);
                if (viewFindViewById != null) {
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.view = viewFindViewById;
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    if (z) {
                        this.mStartValues.viewValues.put(viewFindViewById, transitionValues);
                        if (iIntValue >= 0) {
                            transitionValuesMaps = this.mStartValues;
                            transitionValuesMaps.idValues.put(iIntValue, transitionValues);
                        }
                    } else {
                        this.mEndValues.viewValues.put(viewFindViewById, transitionValues);
                        if (iIntValue >= 0) {
                            transitionValuesMaps = this.mEndValues;
                            transitionValuesMaps.idValues.put(iIntValue, transitionValues);
                        }
                    }
                }
            }
        }
        if (this.mTargets.size() > 0) {
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                View view = this.mTargets.get(i2);
                if (view != null) {
                    TransitionValues transitionValues2 = new TransitionValues();
                    transitionValues2.view = view;
                    if (z) {
                        captureStartValues(transitionValues2);
                    } else {
                        captureEndValues(transitionValues2);
                    }
                    (z ? this.mStartValues : this.mEndValues).viewValues.put(view, transitionValues2);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void clearValues(boolean z) {
        TransitionValuesMaps transitionValuesMaps;
        if (z) {
            this.mStartValues.viewValues.clear();
            this.mStartValues.idValues.clear();
            transitionValuesMaps = this.mStartValues;
        } else {
            this.mEndValues.viewValues.clear();
            this.mEndValues.idValues.clear();
            transitionValuesMaps = this.mEndValues;
        }
        transitionValuesMaps.itemIdValues.clear();
    }

    @Override // 
    /* renamed from: clone */
    public TransitionPort mo1clone() {
        try {
            TransitionPort transitionPort = (TransitionPort) super.clone();
            try {
                transitionPort.mAnimators = new ArrayList<>();
                transitionPort.mStartValues = new TransitionValuesMaps();
                transitionPort.mEndValues = new TransitionValuesMaps();
                return transitionPort;
            } catch (CloneNotSupportedException unused) {
                return transitionPort;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f8  */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        View view;
        TransitionValues transitionValues;
        Iterator<View> it;
        TransitionValuesMaps transitionValuesMaps3 = transitionValuesMaps2;
        ArrayMap arrayMap = new ArrayMap(transitionValuesMaps3.viewValues);
        SparseArray sparseArray = new SparseArray(transitionValuesMaps3.idValues.size());
        for (int i = 0; i < transitionValuesMaps3.idValues.size(); i++) {
            sparseArray.put(transitionValuesMaps3.idValues.keyAt(i), transitionValuesMaps3.idValues.valueAt(i));
        }
        LongSparseArray longSparseArray = new LongSparseArray(transitionValuesMaps3.itemIdValues.size());
        for (int i2 = 0; i2 < transitionValuesMaps3.itemIdValues.size(); i2++) {
            longSparseArray.put(transitionValuesMaps3.itemIdValues.keyAt(i2), transitionValuesMaps3.itemIdValues.valueAt(i2));
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<View> it2 = transitionValuesMaps.viewValues.keySet().iterator();
        while (true) {
            TransitionValues transitionValues2 = null;
            if (!it2.hasNext()) {
                break;
            }
            View next = it2.next();
            if (next.getParent() instanceof ListView) {
                it = it2;
                ListView listView = (ListView) next.getParent();
                if (listView.getAdapter().hasStableIds()) {
                    long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(next));
                    TransitionValues transitionValues3 = transitionValuesMaps.itemIdValues.get(itemIdAtPosition);
                    longSparseArray.remove(itemIdAtPosition);
                    arrayList.add(transitionValues3);
                    arrayList2.add(transitionValues2);
                }
            } else {
                int id = next.getId();
                TransitionValues transitionValues4 = transitionValuesMaps.viewValues.get(next) != null ? transitionValuesMaps.viewValues.get(next) : transitionValuesMaps.idValues.get(id);
                if (transitionValuesMaps3.viewValues.get(next) != null) {
                    transitionValues2 = transitionValuesMaps3.viewValues.get(next);
                    arrayMap.remove(next);
                } else {
                    if (id != -1) {
                        TransitionValues transitionValues5 = transitionValuesMaps3.idValues.get(id);
                        for (View view2 : arrayMap.keySet()) {
                            Iterator<View> it3 = it2;
                            if (view2.getId() == id) {
                                transitionValues2 = view2;
                            }
                            it2 = it3;
                        }
                        it = it2;
                        if (transitionValues2 != null) {
                            arrayMap.remove(transitionValues2);
                        }
                        transitionValues2 = transitionValues5;
                    }
                    sparseArray.remove(id);
                    if (!isValidTarget(next, id)) {
                        arrayList.add(transitionValues4);
                        arrayList2.add(transitionValues2);
                    }
                }
                it = it2;
                sparseArray.remove(id);
                if (!isValidTarget(next, id)) {
                }
            }
            it2 = it;
        }
        int size = transitionValuesMaps.itemIdValues.size();
        for (int i3 = 0; i3 < size; i3++) {
            long jKeyAt = transitionValuesMaps.itemIdValues.keyAt(i3);
            if (isValidTarget(null, jKeyAt)) {
                TransitionValues transitionValues6 = transitionValuesMaps.itemIdValues.get(jKeyAt);
                TransitionValues transitionValues7 = transitionValuesMaps3.itemIdValues.get(jKeyAt);
                longSparseArray.remove(jKeyAt);
                arrayList.add(transitionValues6);
                arrayList2.add(transitionValues7);
            }
        }
        for (View view3 : arrayMap.keySet()) {
            int id2 = view3.getId();
            if (isValidTarget(view3, id2)) {
                TransitionValues transitionValues8 = transitionValuesMaps.viewValues.get(view3) != null ? transitionValuesMaps.viewValues.get(view3) : transitionValuesMaps.idValues.get(id2);
                TransitionValues transitionValues9 = (TransitionValues) arrayMap.get(view3);
                sparseArray.remove(id2);
                arrayList.add(transitionValues8);
                arrayList2.add(transitionValues9);
            }
        }
        int size2 = sparseArray.size();
        for (int i4 = 0; i4 < size2; i4++) {
            int iKeyAt = sparseArray.keyAt(i4);
            if (isValidTarget(null, iKeyAt)) {
                TransitionValues transitionValues10 = transitionValuesMaps.idValues.get(iKeyAt);
                TransitionValues transitionValues11 = (TransitionValues) sparseArray.get(iKeyAt);
                arrayList.add(transitionValues10);
                arrayList2.add(transitionValues11);
            }
        }
        int size3 = longSparseArray.size();
        for (int i5 = 0; i5 < size3; i5++) {
            long jKeyAt2 = longSparseArray.keyAt(i5);
            TransitionValues transitionValues12 = transitionValuesMaps.itemIdValues.get(jKeyAt2);
            TransitionValues transitionValues13 = (TransitionValues) longSparseArray.get(jKeyAt2);
            arrayList.add(transitionValues12);
            arrayList2.add(transitionValues13);
        }
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int i6 = 0;
        while (i6 < arrayList.size()) {
            TransitionValues transitionValues14 = (TransitionValues) arrayList.get(i6);
            TransitionValues transitionValues15 = (TransitionValues) arrayList2.get(i6);
            if ((transitionValues14 != null || transitionValues15 != null) && (transitionValues14 == null || !transitionValues14.equals(transitionValues15))) {
                Animator animatorCreateAnimator = createAnimator(viewGroup, transitionValues14, transitionValues15);
                if (animatorCreateAnimator != null) {
                    if (transitionValues15 != null) {
                        view = transitionValues15.view;
                        String[] transitionProperties = getTransitionProperties();
                        if (view != null && transitionProperties != null && transitionProperties.length > 0) {
                            TransitionValues transitionValues16 = new TransitionValues();
                            transitionValues16.view = view;
                            TransitionValues transitionValues17 = transitionValuesMaps3.viewValues.get(view);
                            if (transitionValues17 != null) {
                                for (int i7 = 0; i7 < transitionProperties.length; i7++) {
                                    transitionValues16.values.put(transitionProperties[i7], transitionValues17.values.get(transitionProperties[i7]));
                                }
                            }
                            int size4 = runningAnimators.size();
                            int i8 = 0;
                            while (true) {
                                if (i8 >= size4) {
                                    transitionValues = transitionValues16;
                                    break;
                                }
                                AnimationInfo animationInfo = runningAnimators.get(runningAnimators.keyAt(i8));
                                if (animationInfo.values != null && animationInfo.view == view && (((animationInfo.name == null && getName() == null) || animationInfo.name.equals(getName())) && animationInfo.values.equals(transitionValues16))) {
                                    transitionValues = transitionValues16;
                                    animatorCreateAnimator = null;
                                    break;
                                }
                                i8++;
                            }
                        }
                        if (animatorCreateAnimator == null) {
                            runningAnimators.put(animatorCreateAnimator, new AnimationInfo(view, getName(), WindowIdPort.getWindowId(viewGroup), transitionValues));
                            this.mAnimators.add(animatorCreateAnimator);
                        }
                    } else {
                        view = transitionValues14.view;
                    }
                    transitionValues = null;
                    if (animatorCreateAnimator == null) {
                    }
                }
            }
            i6++;
            transitionValuesMaps3 = transitionValuesMaps2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void end() {
        this.mNumInstances--;
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList.get(i)).onTransitionEnd(this);
                }
            }
            for (int i2 = 0; i2 < this.mStartValues.itemIdValues.size(); i2++) {
                View view = this.mStartValues.itemIdValues.valueAt(i2).view;
            }
            for (int i3 = 0; i3 < this.mEndValues.itemIdValues.size(); i3++) {
                View view2 = this.mEndValues.itemIdValues.valueAt(i3).view;
            }
            this.mEnded = true;
        }
    }

    public TransitionPort excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    public TransitionPort excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public TransitionPort excludeChildren(Class cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    public TransitionPort excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public TransitionPort excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    public TransitionPort excludeTarget(Class cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public String getName() {
        return this.mName;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public TransitionValues getTransitionValues(View view, boolean z) {
        if (this.mParent != null) {
            return this.mParent.getTransitionValues(view, z);
        }
        TransitionValuesMaps transitionValuesMaps = z ? this.mStartValues : this.mEndValues;
        TransitionValues transitionValues = transitionValuesMaps.viewValues.get(view);
        if (transitionValues != null) {
            return transitionValues;
        }
        int id = view.getId();
        if (id >= 0) {
            transitionValues = transitionValuesMaps.idValues.get(id);
        }
        if (transitionValues != null || !(view.getParent() instanceof ListView)) {
            return transitionValues;
        }
        ListView listView = (ListView) view.getParent();
        return transitionValuesMaps.itemIdValues.get(listView.getItemIdAtPosition(listView.getPositionForView(view)));
    }

    boolean isValidTarget(View view, long j) {
        if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(Integer.valueOf((int) j))) {
            return false;
        }
        if (this.mTargetExcludes != null && this.mTargetExcludes.contains(view)) {
            return false;
        }
        if (this.mTargetTypeExcludes != null && view != null) {
            int size = this.mTargetTypeExcludes.size();
            for (int i = 0; i < size; i++) {
                if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetIds.size() == 0 && this.mTargets.size() == 0) {
            return true;
        }
        if (this.mTargetIds.size() > 0) {
            for (int i2 = 0; i2 < this.mTargetIds.size(); i2++) {
                if (this.mTargetIds.get(i2).intValue() == j) {
                    return true;
                }
            }
        }
        if (view != null && this.mTargets.size() > 0) {
            for (int i3 = 0; i3 < this.mTargets.size(); i3++) {
                if (this.mTargets.get(i3) == view) {
                    return true;
                }
            }
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void pause(View view) {
        if (this.mEnded) {
            return;
        }
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        WindowIdPort windowId = WindowIdPort.getWindowId(view);
        for (int i = size - 1; i >= 0; i--) {
            AnimationInfo animationInfoValueAt = runningAnimators.valueAt(i);
            if (animationInfoValueAt.view != null && windowId.equals(animationInfoValueAt.windowId)) {
                runningAnimators.keyAt(i).cancel();
            }
        }
        if (this.mListeners != null && this.mListeners.size() > 0) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((TransitionListener) arrayList.get(i2)).onTransitionPause(this);
            }
        }
        this.mPaused = true;
    }

    void playTransition(ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        for (int size = runningAnimators.size() - 1; size >= 0; size--) {
            Animator animatorKeyAt = runningAnimators.keyAt(size);
            if (animatorKeyAt != null && (animationInfo = runningAnimators.get(animatorKeyAt)) != null && animationInfo.view != null && animationInfo.view.getContext() == viewGroup.getContext()) {
                boolean z = false;
                TransitionValues transitionValues = animationInfo.values;
                View view = animationInfo.view;
                TransitionValues transitionValues2 = this.mEndValues.viewValues != null ? this.mEndValues.viewValues.get(view) : null;
                if (transitionValues2 == null) {
                    transitionValues2 = this.mEndValues.idValues.get(view.getId());
                }
                if (transitionValues != null && transitionValues2 != null) {
                    Iterator<String> it = transitionValues.values.keySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        Object obj = transitionValues.values.get(next);
                        Object obj2 = transitionValues2.values.get(next);
                        if (obj != null && obj2 != null && !obj.equals(obj2)) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    if (animatorKeyAt.isRunning() || animatorKeyAt.isStarted()) {
                        animatorKeyAt.cancel();
                    } else {
                        runningAnimators.remove(animatorKeyAt);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues);
        runAnimators();
    }

    public TransitionPort removeListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            return this;
        }
        this.mListeners.remove(transitionListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public TransitionPort removeTarget(int i) {
        if (i > 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public TransitionPort removeTarget(View view) {
        if (view != null) {
            this.mTargets.remove(view);
        }
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                WindowIdPort windowId = WindowIdPort.getWindowId(view);
                for (int i = size - 1; i >= 0; i--) {
                    AnimationInfo animationInfoValueAt = runningAnimators.valueAt(i);
                    if (animationInfoValueAt.view != null && windowId.equals(animationInfoValueAt.windowId)) {
                        runningAnimators.keyAt(i).end();
                    }
                }
                if (this.mListeners != null && this.mListeners.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((TransitionListener) arrayList.get(i2)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void runAnimators() {
        start();
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public TransitionPort setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public TransitionPort setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    TransitionPort setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    public TransitionPort setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void start() {
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList.get(i)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            String str4 = str3;
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                if (i > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.mTargetIds.get(i);
            }
            str3 = str4;
        }
        if (this.mTargets.size() > 0) {
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargets.get(i2);
            }
        }
        return str3 + ")";
    }
}
