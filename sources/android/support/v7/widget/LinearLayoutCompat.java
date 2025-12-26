package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface DividerMode {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.weight = typedArrayObtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = typedArrayObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        int i2 = tintTypedArrayObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = tintTypedArrayObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = tintTypedArrayObtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = tintTypedArrayObtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = tintTypedArrayObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = tintTypedArrayObtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = tintTypedArrayObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    private void forceUniformHeight(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, iMakeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, iMakeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int paddingRight;
        int virtualChildCount = getVirtualChildCount();
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, zIsLayoutRtl ? virtualChildAt.getRight() + layoutParams.rightMargin : (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (zIsLayoutRtl) {
                    left = virtualChildAt2.getLeft();
                    paddingRight = layoutParams2.leftMargin;
                    right = (left - paddingRight) - this.mDividerWidth;
                } else {
                    right = virtualChildAt2.getRight() + layoutParams2.rightMargin;
                }
            } else if (zIsLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth();
                paddingRight = getPaddingRight();
                right = (left - paddingRight) - this.mDividerWidth;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            drawHorizontalDivider(canvas, virtualChildAt2 == null ? (getHeight() - getPaddingBottom()) - this.mDividerHeight : virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.mOrientation == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.mBaselineAlignedChildIndex);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i = this.mGravity & android.support.design.R.styleable.AppCompatTheme_windowMinWidthMajor) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return bottom + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) != 0) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutHorizontal(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i14 = i4 - i2;
        int paddingBottom = i14 - getPaddingBottom();
        int paddingBottom2 = (i14 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i15 = this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i16 = this.mGravity & android.support.design.R.styleable.AppCompatTheme_windowMinWidthMajor;
        boolean z2 = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i15, ViewCompat.getLayoutDirection(this));
        boolean z3 = true;
        int paddingLeft = absoluteGravity != 1 ? absoluteGravity != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.mTotalLength : (((i3 - i) - this.mTotalLength) / 2) + getPaddingLeft();
        if (zIsLayoutRtl) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int childrenSkipCount = 0;
        while (childrenSkipCount < virtualChildCount) {
            int i17 = i5 + (i6 * childrenSkipCount);
            View virtualChildAt = getVirtualChildAt(i17);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i17);
                z = z3;
                i7 = paddingTop;
                i8 = virtualChildCount;
                i9 = i16;
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (z2) {
                    i10 = childrenSkipCount;
                    i8 = virtualChildCount;
                    int baseline = layoutParams.height != -1 ? virtualChildAt.getBaseline() : -1;
                    i11 = layoutParams.gravity;
                    if (i11 < 0) {
                        i11 = i16;
                    }
                    i12 = i11 & android.support.design.R.styleable.AppCompatTheme_windowMinWidthMajor;
                    i9 = i16;
                    if (i12 != 16) {
                        z = true;
                        i13 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                    } else if (i12 != 48) {
                        if (i12 != 80) {
                            i13 = paddingTop;
                        } else {
                            int measuredHeight2 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                            if (baseline != -1) {
                                measuredHeight2 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - baseline);
                            }
                            i13 = measuredHeight2;
                        }
                        z = true;
                    } else {
                        int i18 = layoutParams.topMargin + paddingTop;
                        if (baseline != -1) {
                            z = true;
                            i18 += iArr[1] - baseline;
                        } else {
                            z = true;
                        }
                        i13 = i18;
                    }
                    if (hasDividerBeforeChildAt(i17)) {
                        paddingLeft += this.mDividerWidth;
                    }
                    int i19 = layoutParams.leftMargin + paddingLeft;
                    i7 = paddingTop;
                    setChildFrame(virtualChildAt, i19 + getLocationOffset(virtualChildAt), i13, measuredWidth, measuredHeight);
                    int nextLocationOffset = i19 + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                    childrenSkipCount = i10 + getChildrenSkipCount(virtualChildAt, i17);
                    paddingLeft = nextLocationOffset;
                    childrenSkipCount++;
                    z3 = z;
                    virtualChildCount = i8;
                    i16 = i9;
                    paddingTop = i7;
                } else {
                    i10 = childrenSkipCount;
                    i8 = virtualChildCount;
                }
                i11 = layoutParams.gravity;
                if (i11 < 0) {
                }
                i12 = i11 & android.support.design.R.styleable.AppCompatTheme_windowMinWidthMajor;
                i9 = i16;
                if (i12 != 16) {
                }
                if (hasDividerBeforeChildAt(i17)) {
                }
                int i192 = layoutParams.leftMargin + paddingLeft;
                i7 = paddingTop;
                setChildFrame(virtualChildAt, i192 + getLocationOffset(virtualChildAt), i13, measuredWidth, measuredHeight);
                int nextLocationOffset2 = i192 + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                childrenSkipCount = i10 + getChildrenSkipCount(virtualChildAt, i17);
                paddingLeft = nextLocationOffset2;
                childrenSkipCount++;
                z3 = z;
                virtualChildCount = i8;
                i16 = i9;
                paddingTop = i7;
            } else {
                i7 = paddingTop;
                i8 = virtualChildCount;
                i9 = i16;
                z = true;
            }
            childrenSkipCount++;
            z3 = z;
            virtualChildCount = i8;
            i16 = i9;
            paddingTop = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutVertical(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int paddingLeft = getPaddingLeft();
        int i8 = i3 - i;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i9 = this.mGravity & android.support.design.R.styleable.AppCompatTheme_windowMinWidthMajor;
        int i10 = this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int paddingTop = i9 != 16 ? i9 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.mTotalLength : (((i4 - i2) - this.mTotalLength) / 2) + getPaddingTop();
        int childrenSkipCount = 0;
        while (childrenSkipCount < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(childrenSkipCount);
            } else {
                if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i11 = layoutParams.gravity;
                    if (i11 < 0) {
                        i11 = i10;
                    }
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this)) & 7;
                    if (absoluteGravity == 1) {
                        i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    } else if (absoluteGravity != 5) {
                        i6 = layoutParams.leftMargin + paddingLeft;
                        int i12 = i6;
                        if (hasDividerBeforeChildAt(childrenSkipCount)) {
                            paddingTop += this.mDividerHeight;
                        }
                        int i13 = paddingTop + layoutParams.topMargin;
                        setChildFrame(virtualChildAt, i12, i13 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                        int nextLocationOffset = i13 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
                        childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                        paddingTop = nextLocationOffset;
                        i7 = 1;
                    } else {
                        i5 = paddingRight - measuredWidth;
                    }
                    i6 = i5 - layoutParams.rightMargin;
                    int i122 = i6;
                    if (hasDividerBeforeChildAt(childrenSkipCount)) {
                    }
                    int i132 = paddingTop + layoutParams.topMargin;
                    setChildFrame(virtualChildAt, i122, i132 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                    int nextLocationOffset2 = i132 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
                    childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                    paddingTop = nextLocationOffset2;
                    i7 = 1;
                }
                childrenSkipCount += i7;
            }
            i7 = 1;
            childrenSkipCount += i7;
        }
    }

    void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x03bb A[PHI: r4
  0x03bb: PHI (r4v46 int) = (r4v43 int), (r4v47 int) binds: [B:169:0x03b9, B:165:0x03ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureHorizontal(int i, int i2) {
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int iMax;
        int i9;
        int baseline;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z;
        boolean z2;
        LayoutParams layoutParams;
        int i14;
        View view;
        int iMax2;
        int i15;
        boolean z3;
        int measuredHeight;
        int iMax3;
        int childrenSkipCount;
        int baseline2;
        int iMax4;
        int i16 = i;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr2 = this.mMaxAscent;
        int[] iArr3 = this.mMaxDescent;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z4 = this.mBaselineAligned;
        boolean z5 = this.mUseLargestChild;
        int i17 = 1073741824;
        boolean z6 = mode == 1073741824;
        int childrenSkipCount2 = 0;
        int i18 = 0;
        boolean z7 = false;
        int iMax5 = 0;
        int i19 = 0;
        int i20 = 0;
        boolean z8 = false;
        boolean z9 = true;
        float f = 0.0f;
        int iMax6 = Integer.MIN_VALUE;
        while (true) {
            iArr = iArr3;
            i3 = 8;
            if (childrenSkipCount2 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(childrenSkipCount2);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(childrenSkipCount2);
            } else if (virtualChildAt.getVisibility() == 8) {
                childrenSkipCount2 += getChildrenSkipCount(virtualChildAt, childrenSkipCount2);
            } else {
                if (hasDividerBeforeChildAt(childrenSkipCount2)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                f += layoutParams2.weight;
                if (mode == i17 && layoutParams2.width == 0 && layoutParams2.weight > 0.0f) {
                    if (z6) {
                        iMax4 = this.mTotalLength + layoutParams2.leftMargin + layoutParams2.rightMargin;
                    } else {
                        int i21 = this.mTotalLength;
                        iMax4 = Math.max(i21, layoutParams2.leftMargin + i21 + layoutParams2.rightMargin);
                    }
                    this.mTotalLength = iMax4;
                    if (z4) {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        i13 = childrenSkipCount2;
                        z = z5;
                        z2 = z4;
                        layoutParams = layoutParams2;
                        i14 = mode;
                        view = virtualChildAt;
                    } else {
                        i13 = childrenSkipCount2;
                        z = z5;
                        z2 = z4;
                        layoutParams = layoutParams2;
                        i14 = mode;
                        z7 = true;
                        i15 = 1073741824;
                        view = virtualChildAt;
                        if (mode2 == i15 && layoutParams.height == -1) {
                            z3 = true;
                            z8 = true;
                        } else {
                            z3 = false;
                        }
                        int i22 = layoutParams.topMargin + layoutParams.bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i22;
                        int iCombineMeasuredStates = ViewUtils.combineMeasuredStates(i20, ViewCompat.getMeasuredState(view));
                        if (z2 && (baseline2 = view.getBaseline()) != -1) {
                            int i23 = ((((layoutParams.gravity >= 0 ? this.mGravity : layoutParams.gravity) & android.support.design.R.styleable.AppCompatTheme_windowMinWidthMajor) >> 4) & (-2)) >> 1;
                            iArr2[i23] = Math.max(iArr2[i23], baseline2);
                            iArr[i23] = Math.max(iArr[i23], measuredHeight - baseline2);
                        }
                        int iMax7 = Math.max(i18, measuredHeight);
                        boolean z10 = !z9 && layoutParams.height == -1;
                        if (layoutParams.weight <= 0.0f) {
                            if (!z3) {
                                i22 = measuredHeight;
                            }
                            iMax3 = Math.max(i19, i22);
                        } else {
                            iMax3 = i19;
                            if (z3) {
                                measuredHeight = i22;
                            }
                            iMax5 = Math.max(iMax5, measuredHeight);
                        }
                        int i24 = i13;
                        childrenSkipCount = getChildrenSkipCount(view, i24) + i24;
                        i20 = iCombineMeasuredStates;
                        i18 = iMax7;
                        z9 = z10;
                        i19 = iMax3;
                        i17 = i15;
                        childrenSkipCount2 = childrenSkipCount + 1;
                        iArr3 = iArr;
                        z5 = z;
                        z4 = z2;
                        mode = i14;
                        i16 = i;
                    }
                } else {
                    if (layoutParams2.width != 0 || layoutParams2.weight <= 0.0f) {
                        i12 = Integer.MIN_VALUE;
                    } else {
                        layoutParams2.width = -2;
                        i12 = 0;
                    }
                    i13 = childrenSkipCount2;
                    int i25 = i12;
                    z = z5;
                    z2 = z4;
                    layoutParams = layoutParams2;
                    i14 = mode;
                    view = virtualChildAt;
                    measureChildBeforeLayout(virtualChildAt, i13, i16, f == 0.0f ? this.mTotalLength : 0, i2, 0);
                    if (i25 != Integer.MIN_VALUE) {
                        layoutParams.width = i25;
                    }
                    int measuredWidth = view.getMeasuredWidth();
                    if (z6) {
                        iMax2 = this.mTotalLength + layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(view);
                    } else {
                        int i26 = this.mTotalLength;
                        iMax2 = Math.max(i26, i26 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(view));
                    }
                    this.mTotalLength = iMax2;
                    if (z) {
                        iMax6 = Math.max(measuredWidth, iMax6);
                    }
                }
                i15 = 1073741824;
                if (mode2 == i15) {
                    z3 = false;
                    int i222 = layoutParams.topMargin + layoutParams.bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i222;
                    int iCombineMeasuredStates2 = ViewUtils.combineMeasuredStates(i20, ViewCompat.getMeasuredState(view));
                    if (z2) {
                        int i232 = ((((layoutParams.gravity >= 0 ? this.mGravity : layoutParams.gravity) & android.support.design.R.styleable.AppCompatTheme_windowMinWidthMajor) >> 4) & (-2)) >> 1;
                        iArr2[i232] = Math.max(iArr2[i232], baseline2);
                        iArr[i232] = Math.max(iArr[i232], measuredHeight - baseline2);
                    }
                    int iMax72 = Math.max(i18, measuredHeight);
                    if (z9) {
                        if (layoutParams.weight <= 0.0f) {
                        }
                        int i242 = i13;
                        childrenSkipCount = getChildrenSkipCount(view, i242) + i242;
                        i20 = iCombineMeasuredStates2;
                        i18 = iMax72;
                        z9 = z10;
                        i19 = iMax3;
                    }
                }
                i17 = i15;
                childrenSkipCount2 = childrenSkipCount + 1;
                iArr3 = iArr;
                z5 = z;
                z4 = z2;
                mode = i14;
                i16 = i;
            }
            childrenSkipCount = childrenSkipCount2;
            i15 = i17;
            z = z5;
            z2 = z4;
            i14 = mode;
            i17 = i15;
            childrenSkipCount2 = childrenSkipCount + 1;
            iArr3 = iArr;
            z5 = z;
            z4 = z2;
            mode = i14;
            i16 = i;
        }
        boolean z11 = z5;
        boolean z12 = z4;
        int i27 = mode;
        int iMax8 = i18;
        int i28 = iMax5;
        int i29 = i19;
        int iCombineMeasuredStates3 = i20;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (iArr2[1] != -1 || iArr2[0] != -1 || iArr2[2] != -1 || iArr2[3] != -1) {
            iMax8 = Math.max(iMax8, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z11) {
            i4 = i27;
            if (i4 == Integer.MIN_VALUE || i4 == 0) {
                this.mTotalLength = 0;
                int childrenSkipCount3 = 0;
                while (childrenSkipCount3 < virtualChildCount) {
                    View virtualChildAt2 = getVirtualChildAt(childrenSkipCount3);
                    if (virtualChildAt2 == null) {
                        this.mTotalLength += measureNullChild(childrenSkipCount3);
                    } else if (virtualChildAt2.getVisibility() == i3) {
                        childrenSkipCount3 += getChildrenSkipCount(virtualChildAt2, childrenSkipCount3);
                    } else {
                        LayoutParams layoutParams3 = (LayoutParams) virtualChildAt2.getLayoutParams();
                        if (z6) {
                            this.mTotalLength += layoutParams3.leftMargin + iMax6 + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt2);
                        } else {
                            int i30 = this.mTotalLength;
                            i11 = childrenSkipCount3;
                            this.mTotalLength = Math.max(i30, i30 + iMax6 + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt2));
                            childrenSkipCount3 = i11 + 1;
                            i3 = 8;
                        }
                    }
                    i11 = childrenSkipCount3;
                    childrenSkipCount3 = i11 + 1;
                    i3 = 8;
                }
            }
        } else {
            i4 = i27;
        }
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int iResolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumWidth()), i, 0);
        int i31 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
        if (z7 || (i31 != 0 && f > 0.0f)) {
            float f2 = this.mWeightSum > 0.0f ? this.mWeightSum : f;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.mTotalLength = 0;
            i5 = i28;
            int i32 = 0;
            int iMax9 = -1;
            while (i32 < virtualChildCount) {
                View virtualChildAt3 = getVirtualChildAt(i32);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    i7 = virtualChildCount;
                } else {
                    LayoutParams layoutParams4 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f3 = layoutParams4.weight;
                    if (f3 > 0.0f) {
                        i7 = virtualChildCount;
                        int measuredWidth2 = (int) ((i31 * f3) / f2);
                        f2 -= f3;
                        i8 = i31 - measuredWidth2;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams4.topMargin + layoutParams4.bottomMargin, layoutParams4.height);
                        if (layoutParams4.width == 0) {
                            i10 = 1073741824;
                            if (i4 == 1073741824) {
                                if (measuredWidth2 <= 0) {
                                    measuredWidth2 = 0;
                                }
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i10), childMeasureSpec);
                                iCombineMeasuredStates3 = ViewUtils.combineMeasuredStates(iCombineMeasuredStates3, ViewCompat.getMeasuredState(virtualChildAt3) & ViewCompat.MEASURED_STATE_MASK);
                            }
                        } else {
                            i10 = 1073741824;
                        }
                        measuredWidth2 = virtualChildAt3.getMeasuredWidth() + measuredWidth2;
                        if (measuredWidth2 < 0) {
                        }
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i10), childMeasureSpec);
                        iCombineMeasuredStates3 = ViewUtils.combineMeasuredStates(iCombineMeasuredStates3, ViewCompat.getMeasuredState(virtualChildAt3) & ViewCompat.MEASURED_STATE_MASK);
                    } else {
                        i7 = virtualChildCount;
                        i8 = i31;
                    }
                    if (z6) {
                        iMax = this.mTotalLength + virtualChildAt3.getMeasuredWidth() + layoutParams4.leftMargin + layoutParams4.rightMargin + getNextLocationOffset(virtualChildAt3);
                    } else {
                        int i33 = this.mTotalLength;
                        iMax = Math.max(i33, virtualChildAt3.getMeasuredWidth() + i33 + layoutParams4.leftMargin + layoutParams4.rightMargin + getNextLocationOffset(virtualChildAt3));
                    }
                    this.mTotalLength = iMax;
                    boolean z13 = mode2 != 1073741824 && layoutParams4.height == -1;
                    int i34 = layoutParams4.topMargin + layoutParams4.bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i34;
                    iMax9 = Math.max(iMax9, measuredHeight2);
                    if (!z13) {
                        i34 = measuredHeight2;
                    }
                    int iMax10 = Math.max(i5, i34);
                    if (z9) {
                        i9 = -1;
                        boolean z14 = layoutParams4.height == -1;
                        if (!z12 && (baseline = virtualChildAt3.getBaseline()) != i9) {
                            int i35 = ((((layoutParams4.gravity < 0 ? this.mGravity : layoutParams4.gravity) & android.support.design.R.styleable.AppCompatTheme_windowMinWidthMajor) >> 4) & (-2)) >> 1;
                            iArr2[i35] = Math.max(iArr2[i35], baseline);
                            iArr[i35] = Math.max(iArr[i35], measuredHeight2 - baseline);
                        }
                        i5 = iMax10;
                        z9 = z14;
                        i31 = i8;
                    } else {
                        i9 = -1;
                    }
                    if (!z12) {
                        i5 = iMax10;
                        z9 = z14;
                        i31 = i8;
                    }
                }
                i32++;
                virtualChildCount = i7;
            }
            i6 = virtualChildCount;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            iMax8 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax9 : Math.max(iMax9, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        } else {
            int iMax11 = Math.max(i28, i29);
            if (z11 && i4 != 1073741824) {
                for (int i36 = 0; i36 < virtualChildCount; i36++) {
                    View virtualChildAt4 = getVirtualChildAt(i36);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LayoutParams) virtualChildAt4.getLayoutParams()).weight > 0.0f) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(iMax6, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i5 = iMax11;
            i6 = virtualChildCount;
        }
        if (z9 || mode2 == 1073741824) {
            i5 = iMax8;
        }
        setMeasuredDimension(iResolveSizeAndState | ((-16777216) & iCombineMeasuredStates3), ViewCompat.resolveSizeAndState(Math.max(i5 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates3 << 16));
        if (z8) {
            forceUniformHeight(i6, i);
        }
    }

    int measureNullChild(int i) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x02f2 A[PHI: r6
  0x02f2: PHI (r6v23 int) = (r6v21 int), (r6v24 int) binds: [B:134:0x02f0, B:130:0x02e5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iMax;
        int i6;
        float f;
        int i7;
        int i8;
        boolean z;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        View view;
        int i14;
        int i15;
        int i16;
        LayoutParams layoutParams;
        int i17;
        int iMax2;
        int i18;
        boolean z2;
        int i19;
        int i20 = i;
        int i21 = i2;
        int i22 = 0;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i23 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        int i24 = 0;
        int iMax3 = 0;
        int childrenSkipCount = 0;
        boolean z4 = false;
        boolean z5 = false;
        int i25 = 0;
        float f2 = 0.0f;
        boolean z6 = true;
        int i26 = Integer.MIN_VALUE;
        while (childrenSkipCount < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(childrenSkipCount);
                i19 = i22;
                i13 = virtualChildCount;
                i11 = mode2;
            } else {
                int i27 = i24;
                if (virtualChildAt.getVisibility() == 8) {
                    childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                    i19 = i22;
                    i13 = virtualChildCount;
                    i11 = mode2;
                    i24 = i27;
                } else {
                    if (hasDividerBeforeChildAt(childrenSkipCount)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                    float f3 = f2 + layoutParams2.weight;
                    if (mode2 == 1073741824 && layoutParams2.height == 0 && layoutParams2.weight > 0.0f) {
                        int i28 = this.mTotalLength;
                        iMax2 = i26;
                        this.mTotalLength = Math.max(i28, layoutParams2.topMargin + i28 + layoutParams2.bottomMargin);
                        i14 = iMax3;
                        view = virtualChildAt;
                        layoutParams = layoutParams2;
                        i17 = i22;
                        i13 = virtualChildCount;
                        i11 = mode2;
                        z4 = true;
                        i15 = i25;
                        i12 = i27;
                        i16 = childrenSkipCount;
                    } else {
                        int i29 = i26;
                        if (layoutParams2.height != 0 || layoutParams2.weight <= 0.0f) {
                            i10 = Integer.MIN_VALUE;
                        } else {
                            layoutParams2.height = -2;
                            i10 = 0;
                        }
                        i11 = mode2;
                        i12 = i27;
                        int i30 = i10;
                        int i31 = childrenSkipCount;
                        i13 = virtualChildCount;
                        int i32 = iMax3;
                        int i33 = i20;
                        view = virtualChildAt;
                        i14 = i32;
                        i15 = i25;
                        i16 = childrenSkipCount;
                        int i34 = i21;
                        layoutParams = layoutParams2;
                        i17 = i22;
                        measureChildBeforeLayout(virtualChildAt, i31, i33, 0, i34, f3 == 0.0f ? this.mTotalLength : 0);
                        if (i30 != Integer.MIN_VALUE) {
                            layoutParams.height = i30;
                        }
                        int measuredHeight = view.getMeasuredHeight();
                        int i35 = this.mTotalLength;
                        this.mTotalLength = Math.max(i35, i35 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(view));
                        iMax2 = z3 ? Math.max(measuredHeight, i29) : i29;
                    }
                    if (i23 >= 0 && i23 == i16 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i16 < i23 && layoutParams.weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode != 1073741824) {
                        i18 = -1;
                        if (layoutParams.width == -1) {
                            z2 = true;
                            z5 = true;
                        }
                        int i36 = layoutParams.leftMargin + layoutParams.rightMargin;
                        int measuredWidth = view.getMeasuredWidth() + i36;
                        int iMax4 = Math.max(i12, measuredWidth);
                        int iCombineMeasuredStates = ViewUtils.combineMeasuredStates(i17, ViewCompat.getMeasuredState(view));
                        boolean z7 = !z6 && layoutParams.width == i18;
                        if (layoutParams.weight <= 0.0f) {
                            if (!z2) {
                                i36 = measuredWidth;
                            }
                            iMax3 = Math.max(i14, i36);
                        } else {
                            int i37 = i14;
                            if (z2) {
                                measuredWidth = i36;
                            }
                            int iMax5 = Math.max(i15, measuredWidth);
                            iMax3 = i37;
                            i15 = iMax5;
                        }
                        z6 = z7;
                        i24 = iMax4;
                        i19 = iCombineMeasuredStates;
                        i26 = iMax2;
                        i25 = i15;
                        childrenSkipCount = getChildrenSkipCount(view, i16) + i16;
                        f2 = f3;
                        childrenSkipCount++;
                        i22 = i19;
                        mode2 = i11;
                        virtualChildCount = i13;
                        i20 = i;
                        i21 = i2;
                    } else {
                        i18 = -1;
                    }
                    z2 = false;
                    int i362 = layoutParams.leftMargin + layoutParams.rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i362;
                    int iMax42 = Math.max(i12, measuredWidth2);
                    int iCombineMeasuredStates2 = ViewUtils.combineMeasuredStates(i17, ViewCompat.getMeasuredState(view));
                    if (z6) {
                        if (layoutParams.weight <= 0.0f) {
                        }
                        z6 = z7;
                        i24 = iMax42;
                        i19 = iCombineMeasuredStates2;
                        i26 = iMax2;
                        i25 = i15;
                        childrenSkipCount = getChildrenSkipCount(view, i16) + i16;
                        f2 = f3;
                    }
                    childrenSkipCount++;
                    i22 = i19;
                    mode2 = i11;
                    virtualChildCount = i13;
                    i20 = i;
                    i21 = i2;
                }
            }
            childrenSkipCount++;
            i22 = i19;
            mode2 = i11;
            virtualChildCount = i13;
            i20 = i;
            i21 = i2;
        }
        int i38 = i26;
        int i39 = iMax3;
        int i40 = i22;
        int i41 = virtualChildCount;
        int i42 = mode2;
        int iMax6 = i25;
        int iMax7 = i24;
        if (this.mTotalLength > 0) {
            i3 = i41;
            if (hasDividerBeforeChildAt(i3)) {
                this.mTotalLength += this.mDividerHeight;
            }
        } else {
            i3 = i41;
        }
        if (z3) {
            i4 = i42;
            if (i4 == Integer.MIN_VALUE || i4 == 0) {
                this.mTotalLength = 0;
                int childrenSkipCount2 = 0;
                while (childrenSkipCount2 < i3) {
                    View virtualChildAt2 = getVirtualChildAt(childrenSkipCount2);
                    if (virtualChildAt2 == null) {
                        this.mTotalLength += measureNullChild(childrenSkipCount2);
                    } else if (virtualChildAt2.getVisibility() == 8) {
                        childrenSkipCount2 += getChildrenSkipCount(virtualChildAt2, childrenSkipCount2);
                    } else {
                        LayoutParams layoutParams3 = (LayoutParams) virtualChildAt2.getLayoutParams();
                        int i43 = this.mTotalLength;
                        this.mTotalLength = Math.max(i43, i43 + i38 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt2));
                    }
                    childrenSkipCount2++;
                }
            }
        } else {
            i4 = i42;
        }
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        int iResolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), i2, 0);
        int i44 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
        if (z4 || (i44 != 0 && f2 > 0.0f)) {
            if (this.mWeightSum > 0.0f) {
                f2 = this.mWeightSum;
            }
            this.mTotalLength = 0;
            float f4 = f2;
            int i45 = 0;
            int iCombineMeasuredStates3 = i40;
            int i46 = i44;
            while (i45 < i3) {
                View virtualChildAt3 = getVirtualChildAt(i45);
                if (virtualChildAt3.getVisibility() == 8) {
                    f = f4;
                } else {
                    LayoutParams layoutParams4 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f5 = layoutParams4.weight;
                    if (f5 > 0.0f) {
                        int measuredHeight2 = (int) ((i46 * f5) / f4);
                        i6 = i46 - measuredHeight2;
                        f = f4 - f5;
                        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams4.leftMargin + layoutParams4.rightMargin, layoutParams4.width);
                        if (layoutParams4.height == 0) {
                            i9 = 1073741824;
                            if (i4 == 1073741824) {
                                if (measuredHeight2 <= 0) {
                                    measuredHeight2 = 0;
                                }
                                virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i9));
                                iCombineMeasuredStates3 = ViewUtils.combineMeasuredStates(iCombineMeasuredStates3, ViewCompat.getMeasuredState(virtualChildAt3) & InputDeviceCompat.SOURCE_ANY);
                            }
                        } else {
                            i9 = 1073741824;
                        }
                        measuredHeight2 = virtualChildAt3.getMeasuredHeight() + measuredHeight2;
                        if (measuredHeight2 < 0) {
                        }
                        virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i9));
                        iCombineMeasuredStates3 = ViewUtils.combineMeasuredStates(iCombineMeasuredStates3, ViewCompat.getMeasuredState(virtualChildAt3) & InputDeviceCompat.SOURCE_ANY);
                    } else {
                        i6 = i46;
                        f = f4;
                    }
                    int i47 = layoutParams4.leftMargin + layoutParams4.rightMargin;
                    int measuredWidth3 = virtualChildAt3.getMeasuredWidth() + i47;
                    iMax7 = Math.max(iMax7, measuredWidth3);
                    if (mode != 1073741824) {
                        i7 = i47;
                        i8 = -1;
                        z = layoutParams4.width == -1;
                        if (z) {
                            measuredWidth3 = i7;
                        }
                        iMax6 = Math.max(iMax6, measuredWidth3);
                        boolean z8 = !z6 && layoutParams4.width == i8;
                        int i48 = this.mTotalLength;
                        this.mTotalLength = Math.max(i48, i48 + virtualChildAt3.getMeasuredHeight() + layoutParams4.topMargin + layoutParams4.bottomMargin + getNextLocationOffset(virtualChildAt3));
                        z6 = z8;
                        i46 = i6;
                    } else {
                        i7 = i47;
                        i8 = -1;
                    }
                    if (z) {
                    }
                    iMax6 = Math.max(iMax6, measuredWidth3);
                    if (z6) {
                        int i482 = this.mTotalLength;
                        this.mTotalLength = Math.max(i482, i482 + virtualChildAt3.getMeasuredHeight() + layoutParams4.topMargin + layoutParams4.bottomMargin + getNextLocationOffset(virtualChildAt3));
                        z6 = z8;
                        i46 = i6;
                    }
                }
                i45++;
                f4 = f;
            }
            i5 = i;
            this.mTotalLength += getPaddingTop() + getPaddingBottom();
            iMax = iMax6;
            i40 = iCombineMeasuredStates3;
        } else {
            iMax = Math.max(iMax6, i39);
            if (z3 && i4 != 1073741824) {
                for (int i49 = 0; i49 < i3; i49++) {
                    View virtualChildAt4 = getVirtualChildAt(i49);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LayoutParams) virtualChildAt4.getLayoutParams()).weight > 0.0f) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i38, 1073741824));
                    }
                }
            }
            i5 = i;
        }
        if (!z6 && mode != 1073741824) {
            iMax7 = iMax;
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(iMax7 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, i40), iResolveSizeAndState);
        if (z5) {
            forceUniformWidth(i3, i2);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.mBaselineAlignedChildIndex = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & android.support.design.R.styleable.AppCompatTheme_windowMinWidthMajor) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((8388615 & this.mGravity) != i2) {
            this.mGravity = i2 | (this.mGravity & (-8388616));
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & android.support.design.R.styleable.AppCompatTheme_windowMinWidthMajor;
        if ((this.mGravity & android.support.design.R.styleable.AppCompatTheme_windowMinWidthMajor) != i2) {
            this.mGravity = i2 | (this.mGravity & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
