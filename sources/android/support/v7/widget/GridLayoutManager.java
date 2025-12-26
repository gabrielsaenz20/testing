package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    View[] mSet;
    int mSpanCount;
    SpanSizeLookup mSpanSizeLookup;

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return 1;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex;
        int mSpanSize;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }
    }

    public static abstract class SpanSizeLookup {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;

        int findReferenceIndexFromCache(int i) {
            int size = this.mSpanIndexCache.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.mSpanIndexCache.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.mSpanIndexCache.size()) {
                return -1;
            }
            return this.mSpanIndexCache.keyAt(i4);
        }

        int getCachedSpanIndex(int i, int i2) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.mSpanIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanIndex = getSpanIndex(i, i2);
            this.mSpanIndexCache.put(i, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i, int i2) {
            int spanSize = getSpanSize(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int spanSize2 = getSpanSize(i5);
                i3 += spanSize2;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = spanSize2;
                }
            }
            return i3 + spanSize > i2 ? i4 + 1 : i4;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0031 -> B:19:0x0036). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0033 -> B:19:0x0036). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0035 -> B:19:0x0036). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanIndex(int i, int i2) {
            int iFindReferenceIndexFromCache;
            int spanSize;
            int spanSize2 = getSpanSize(i);
            if (spanSize2 == i2) {
                return 0;
            }
            if (!this.mCacheSpanIndices || this.mSpanIndexCache.size() <= 0 || (iFindReferenceIndexFromCache = findReferenceIndexFromCache(i)) < 0) {
                iFindReferenceIndexFromCache = 0;
                spanSize = 0;
                if (iFindReferenceIndexFromCache >= i) {
                    int spanSize3 = getSpanSize(iFindReferenceIndexFromCache);
                    spanSize += spanSize3;
                    if (spanSize == i2) {
                        spanSize = 0;
                    } else if (spanSize > i2) {
                        spanSize = spanSize3;
                    }
                    iFindReferenceIndexFromCache++;
                    if (iFindReferenceIndexFromCache >= i) {
                        if (spanSize2 + spanSize <= i2) {
                            return spanSize;
                        }
                        return 0;
                    }
                }
            } else {
                spanSize = this.mSpanIndexCache.get(iFindReferenceIndexFromCache) + getSpanSize(iFindReferenceIndexFromCache);
                iFindReferenceIndexFromCache++;
                if (iFindReferenceIndexFromCache >= i) {
                }
            }
        }

        public abstract int getSpanSize(int i);

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            this.mCacheSpanIndices = z;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(getProperties(context, attributeSet, i, i2).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = -1;
        int i6 = 0;
        if (z) {
            i4 = 1;
            i5 = i;
            i3 = 0;
        } else {
            i3 = i - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View view = this.mSet[i3];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.mSpanSize = getSpanSize(recycler, state, getPosition(view));
            layoutParams.mSpanIndex = i6;
            i6 += layoutParams.mSpanSize;
            i3 += i4;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    private void calculateItemBorders(int i) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i);
    }

    static int[] calculateItemBorders(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        boolean z = i == 1;
        int spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
        if (z) {
            while (spanIndex > 0 && anchorInfo.mPosition > 0) {
                anchorInfo.mPosition--;
                spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
            }
            return;
        }
        int itemCount = state.getItemCount() - 1;
        int i2 = anchorInfo.mPosition;
        while (i2 < itemCount) {
            int i3 = i2 + 1;
            int spanIndex2 = getSpanIndex(recycler, state, i3);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i2 = i3;
            spanIndex = spanIndex2;
        }
        anchorInfo.mPosition = i2;
    }

    private void ensureViewSet() {
        if (this.mSet == null || this.mSet.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private int getSpanGroupIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanGroupIndex(i, this.mSpanCount);
        }
        int iConvertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (iConvertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getSpanGroupIndex(iConvertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
        }
        int i2 = this.mPreLayoutSpanIndexCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iConvertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (iConvertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(iConvertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i);
        }
        int i2 = this.mPreLayoutSpanSizeCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iConvertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (iConvertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getSpanSize(iConvertPreLayoutPositionToPostLayout);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void guessMeasurement(float f, int i) {
        calculateItemBorders(Math.max(Math.round(f * this.mSpanCount), i));
    }

    private void measureChild(View view, int i, boolean z) {
        int childMeasureSpec;
        int childMeasureSpec2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i2 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i3 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = getChildMeasureSpec(spaceForSpanRange, i, i3, layoutParams.width, false);
            childMeasureSpec = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i2, layoutParams.height, true);
        } else {
            int childMeasureSpec3 = getChildMeasureSpec(spaceForSpanRange, i, i2, layoutParams.height, false);
            int childMeasureSpec4 = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i3, layoutParams.width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        measureChildWithDecorationsAndMargin(view, childMeasureSpec2, childMeasureSpec, z);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z ? shouldReMeasureChild(view, i, i2, layoutParams) : shouldMeasureChild(view, i, i2, layoutParams)) {
            view.measure(i, i2);
        }
    }

    private void updateMeasurements() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        calculateItemBorders(height - paddingTop);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int spanSize = this.mSpanCount;
        for (int i = 0; i < this.mSpanCount && layoutState.hasMore(state) && spanSize > 0; i++) {
            int i2 = layoutState.mCurrentPosition;
            layoutPrefetchRegistry.addPosition(i2, layoutState.mScrollingOffset);
            spanSize -= this.mSpanSizeLookup.getSpanSize(i2);
            layoutState.mCurrentPosition += layoutState.mItemDirection;
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3) {
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3 && getSpanIndex(recycler, state, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    int getSpaceForSpanRange(int i, int i2) {
        return (this.mOrientation == 1 && isLayoutRTL()) ? this.mCachedBorders[this.mSpanCount - i] - this.mCachedBorders[(this.mSpanCount - i) - i2] : this.mCachedBorders[i2 + i] - this.mCachedBorders[i];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x021c  */
    @Override // android.support.v7.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int paddingLeft;
        int decoratedMeasurementInOther;
        int paddingTop;
        int decoratedMeasurementInOther2;
        int decoratedMeasurementInOther3;
        int i;
        int iMakeMeasureSpec;
        int childMeasureSpec;
        boolean z;
        View next;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        boolean z2 = modeInOther != 1073741824;
        int i2 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (z2) {
            updateMeasurements();
        }
        boolean z3 = layoutState.mItemDirection == 1;
        int spanIndex = this.mSpanCount;
        if (!z3) {
            spanIndex = getSpanIndex(recycler, state, layoutState.mCurrentPosition) + getSpanSize(recycler, state, layoutState.mCurrentPosition);
        }
        int i3 = 0;
        int i4 = 0;
        while (i4 < this.mSpanCount && layoutState.hasMore(state) && spanIndex > 0) {
            int i5 = layoutState.mCurrentPosition;
            int spanSize = getSpanSize(recycler, state, i5);
            if (spanSize > this.mSpanCount) {
                throw new IllegalArgumentException("Item at position " + i5 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
            spanIndex -= spanSize;
            if (spanIndex < 0 || (next = layoutState.next(recycler)) == null) {
                break;
            }
            i3 += spanSize;
            this.mSet[i4] = next;
            i4++;
        }
        if (i4 == 0) {
            layoutChunkResult.mFinished = true;
            return;
        }
        float f = 0.0f;
        int i6 = i4;
        assignSpans(recycler, state, i4, i3, z3);
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            View view = this.mSet[i8];
            if (layoutState.mScrapList != null) {
                z = false;
                if (z3) {
                    addDisappearingView(view);
                } else {
                    addDisappearingView(view, 0);
                }
            } else if (z3) {
                addView(view);
                z = false;
            } else {
                z = false;
                addView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, modeInOther, z);
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view);
            if (decoratedMeasurement > i7) {
                i7 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther4 = (1.0f * this.mOrientationHelper.getDecoratedMeasurementInOther(view)) / ((LayoutParams) view.getLayoutParams()).mSpanSize;
            if (decoratedMeasurementInOther4 > f) {
                f = decoratedMeasurementInOther4;
            }
        }
        if (z2) {
            guessMeasurement(f, i2);
            i7 = 0;
            for (int i9 = 0; i9 < i6; i9++) {
                View view2 = this.mSet[i9];
                measureChild(view2, 1073741824, true);
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view2);
                if (decoratedMeasurement2 > i7) {
                    i7 = decoratedMeasurement2;
                }
            }
        }
        for (int i10 = 0; i10 < i6; i10++) {
            View view3 = this.mSet[i10];
            if (this.mOrientationHelper.getDecoratedMeasurement(view3) != i7) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.mDecorInsets;
                int i11 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i12 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
                if (this.mOrientation == 1) {
                    int childMeasureSpec2 = getChildMeasureSpec(spaceForSpanRange, 1073741824, i12, layoutParams.width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7 - i11, 1073741824);
                    iMakeMeasureSpec = childMeasureSpec2;
                } else {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7 - i12, 1073741824);
                    childMeasureSpec = getChildMeasureSpec(spaceForSpanRange, 1073741824, i11, layoutParams.height, false);
                }
                measureChildWithDecorationsAndMargin(view3, iMakeMeasureSpec, childMeasureSpec, true);
            }
        }
        int i13 = 0;
        layoutChunkResult.mConsumed = i7;
        if (this.mOrientation == 1) {
            if (layoutState.mLayoutDirection == -1) {
                int i14 = layoutState.mOffset;
                decoratedMeasurementInOther2 = i14;
                paddingTop = i14 - i7;
            } else {
                int i15 = layoutState.mOffset;
                paddingTop = i15;
                decoratedMeasurementInOther2 = i7 + i15;
            }
            paddingLeft = 0;
            decoratedMeasurementInOther = 0;
        } else if (layoutState.mLayoutDirection == -1) {
            int i16 = layoutState.mOffset;
            int i17 = i16 - i7;
            paddingTop = 0;
            decoratedMeasurementInOther2 = 0;
            decoratedMeasurementInOther = i16;
            paddingLeft = i17;
        } else {
            paddingLeft = layoutState.mOffset;
            decoratedMeasurementInOther = i7 + paddingLeft;
            paddingTop = 0;
            decoratedMeasurementInOther2 = 0;
        }
        while (i13 < i6) {
            View view4 = this.mSet[i13];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation != 1) {
                paddingTop = getPaddingTop() + this.mCachedBorders[layoutParams2.mSpanIndex];
                decoratedMeasurementInOther2 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingTop;
            } else if (isLayoutRTL()) {
                int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams2.mSpanIndex];
                i = paddingLeft2;
                decoratedMeasurementInOther3 = paddingLeft2 - this.mOrientationHelper.getDecoratedMeasurementInOther(view4);
                int i18 = paddingTop;
                int i19 = decoratedMeasurementInOther2;
                layoutDecoratedWithMargins(view4, decoratedMeasurementInOther3, i18, i, i19);
                if (!layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                    layoutChunkResult.mIgnoreConsumed = true;
                }
                layoutChunkResult.mFocusable |= view4.isFocusable();
                i13++;
                paddingLeft = decoratedMeasurementInOther3;
                paddingTop = i18;
                decoratedMeasurementInOther = i;
                decoratedMeasurementInOther2 = i19;
            } else {
                paddingLeft = getPaddingLeft() + this.mCachedBorders[layoutParams2.mSpanIndex];
                decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingLeft;
            }
            decoratedMeasurementInOther3 = paddingLeft;
            i = decoratedMeasurementInOther;
            int i182 = paddingTop;
            int i192 = decoratedMeasurementInOther2;
            layoutDecoratedWithMargins(view4, decoratedMeasurementInOther3, i182, i, i192);
            if (!layoutParams2.isItemRemoved()) {
                layoutChunkResult.mIgnoreConsumed = true;
            }
            layoutChunkResult.mFocusable |= view4.isFocusable();
            i13++;
            paddingLeft = decoratedMeasurementInOther3;
            paddingTop = i182;
            decoratedMeasurementInOther = i;
            decoratedMeasurementInOther2 = i192;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        super.onAnchorReady(recycler, state, anchorInfo, i);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, i);
        }
        ensureViewSet();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0 A[SYNTHETIC] */
    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int childCount;
        int i2;
        int childCount2;
        boolean z;
        View viewFindContainingItemView = findContainingItemView(view);
        View view2 = null;
        if (viewFindContainingItemView == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) viewFindContainingItemView.getLayoutParams();
        int i3 = layoutParams.mSpanIndex;
        int i4 = layoutParams.mSpanIndex + layoutParams.mSpanSize;
        if (super.onFocusSearchFailed(view, i, recycler, state) == null) {
            return null;
        }
        if ((convertFocusDirectionToLayoutDirection(i) == 1) != this.mShouldReverseLayout) {
            childCount2 = getChildCount() - 1;
            childCount = -1;
            i2 = -1;
        } else {
            childCount = getChildCount();
            i2 = 1;
            childCount2 = 0;
        }
        boolean z2 = this.mOrientation == 1 && isLayoutRTL();
        int i5 = -1;
        int iMin = 0;
        while (childCount2 != childCount) {
            View childAt = getChildAt(childCount2);
            if (childAt == viewFindContainingItemView) {
                return view2;
            }
            if (childAt.isFocusable()) {
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                int i6 = layoutParams2.mSpanIndex;
                int i7 = layoutParams2.mSpanIndex + layoutParams2.mSpanSize;
                if (i6 == i3 && i7 == i4) {
                    return childAt;
                }
                if (view2 == null) {
                    z = true;
                    if (z) {
                        i5 = layoutParams2.mSpanIndex;
                        iMin = Math.min(i7, i4) - Math.max(i6, i3);
                        view2 = childAt;
                    }
                } else {
                    int iMin2 = Math.min(i7, i4) - Math.max(i6, i3);
                    if (iMin2 <= iMin) {
                        if (iMin2 == iMin) {
                            if (z2 == (i6 > i5)) {
                            }
                            if (z) {
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    }
                }
            }
            childCount2 += i2;
        }
        return view2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int spanSize;
        int spanIndex;
        int spanSize2;
        boolean z;
        boolean z2;
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            int spanIndex2 = layoutParams2.getSpanIndex();
            spanSize = layoutParams2.getSpanSize();
            spanSize2 = 1;
            z = this.mSpanCount > 1 && layoutParams2.getSpanSize() == this.mSpanCount;
            z2 = false;
            i = spanIndex2;
            spanIndex = spanGroupIndex;
        } else {
            spanSize = 1;
            spanIndex = layoutParams2.getSpanIndex();
            spanSize2 = layoutParams2.getSpanSize();
            z = this.mSpanCount > 1 && layoutParams2.getSpanSize() == this.mSpanCount;
            z2 = false;
            i = spanGroupIndex;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, spanSize, spanIndex, spanSize2, z, z2));
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int iChooseSize;
        int iChooseSize2;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            iChooseSize2 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            iChooseSize = chooseSize(i, this.mCachedBorders[this.mCachedBorders.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            iChooseSize2 = chooseSize(i2, this.mCachedBorders[this.mCachedBorders.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setSpanCount(int i) {
        if (i == this.mSpanCount) {
            return;
        }
        this.mPendingSpanCountChange = true;
        if (i < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
        this.mSpanCount = i;
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        requestLayout();
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }
}
