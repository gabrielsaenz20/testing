package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.v7.widget.ActivityChooserView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ConstraintWidget {
    protected static final int ANCHOR_BASELINE = 4;
    protected static final int ANCHOR_BOTTOM = 3;
    protected static final int ANCHOR_LEFT = 0;
    protected static final int ANCHOR_RIGHT = 1;
    protected static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    protected float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    private int mDrawHeight;
    private int mDrawWidth;
    private int mDrawX;
    private int mDrawY;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    boolean mIsHeightWrapContent;
    boolean mIsWidthWrapContent;
    ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    protected ConstraintAnchor[] mListAnchors;
    protected DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    protected ConstraintWidget[] mListNextVisibleWidget;
    int mMatchConstraintDefaultHeight;
    int mMatchConstraintDefaultWidth;
    int mMatchConstraintMaxHeight;
    int mMatchConstraintMaxWidth;
    int mMatchConstraintMinHeight;
    int mMatchConstraintMinWidth;
    float mMatchConstraintPercentHeight;
    float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected int mOffsetX;
    protected int mOffsetY;
    ConstraintWidget mParent;
    ResolutionDimension mResolutionHeight;
    ResolutionDimension mResolutionWidth;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    ConstraintAnchor mRight;
    boolean mRightHasCentered;
    ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    float[] mWeight;
    int mWidth;
    private int mWrapHeight;
    private int mWrapWidth;
    protected int mX;
    protected int mY;

    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{0.0f, 0.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mListNextVisibleWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{0.0f, 0.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mListNextVisibleWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.mX = i;
        this.mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
        forceUpdateDrawPosition();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x022a A[PHI: r1 r2
  0x022a: PHI (r1v21 int) = (r1v7 int), (r1v24 int) binds: [B:162:0x0302, B:109:0x0228] A[DONT_GENERATE, DONT_INLINE]
  0x022a: PHI (r2v14 android.support.constraint.solver.SolverVariable) = (r2v4 android.support.constraint.solver.SolverVariable), (r2v17 android.support.constraint.solver.SolverVariable) binds: [B:162:0x0302, B:109:0x0228] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0304  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyConstraints(LinearSystem linearSystem, boolean z, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7, float f2, boolean z5) {
        boolean z6;
        int iMin;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        SolverVariable solverVariable3;
        int i16;
        SolverVariable solverVariable4;
        int i17;
        int i18;
        int i19;
        SolverVariable solverVariableCreateObjectVariable;
        ConstraintWidget constraintWidget;
        ConstraintAnchor.Type type;
        int i20;
        int i21;
        int i22;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int i23;
        int i24;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        int i25;
        int i26;
        int i27;
        SolverVariable solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        if (linearSystem.graphOptimizer && constraintAnchor.getResolutionNode().state == 1 && constraintAnchor2.getResolutionNode().state == 1) {
            if (LinearSystem.getMetrics() != null) {
                LinearSystem.getMetrics().resolvedWidgets++;
            }
            constraintAnchor.getResolutionNode().addResolvedValue(linearSystem);
            constraintAnchor2.getResolutionNode().addResolvedValue(linearSystem);
            if (z4 || !z) {
                return;
            }
            linearSystem.addGreaterThan(solverVariable2, solverVariableCreateObjectVariable3, 0, 6);
            return;
        }
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean zIsConnected = constraintAnchor.isConnected();
        boolean zIsConnected2 = constraintAnchor2.isConnected();
        boolean zIsConnected3 = this.mCenter.isConnected();
        int i28 = zIsConnected ? 1 : 0;
        if (zIsConnected2) {
            i28++;
        }
        if (zIsConnected3) {
            i28++;
        }
        int i29 = z3 ? 3 : i5;
        switch (dimensionBehaviour) {
            case FIXED:
            case WRAP_CONTENT:
            case MATCH_PARENT:
            default:
                z6 = false;
                break;
            case MATCH_CONSTRAINT:
                z6 = true;
                break;
        }
        int i30 = i28;
        if (this.mVisibility == 8) {
            iMin = 0;
            z6 = false;
        } else {
            iMin = i2;
        }
        if (z5) {
            if (!zIsConnected && !zIsConnected2 && !zIsConnected3) {
                linearSystem.addEquality(solverVariableCreateObjectVariable2, i);
            } else if (zIsConnected && !zIsConnected2) {
                i8 = 6;
                linearSystem.addEquality(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable4, constraintAnchor.getMargin(), 6);
            }
            i8 = 6;
        } else {
            i8 = 6;
        }
        if (z6) {
            if (i6 == -2) {
                i10 = i7;
                i9 = iMin;
            } else {
                i9 = i6;
                i10 = i7;
            }
            if (i10 == -2) {
                i10 = iMin;
            }
            if (i9 > 0) {
                i11 = 6;
                linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, i9, 6);
                iMin = Math.max(iMin, i9);
            } else {
                i11 = 6;
            }
            if (i10 > 0) {
                if (z) {
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, i10, 1);
                } else {
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, i10, i11);
                }
                iMin = Math.min(iMin, i10);
            }
            int i31 = iMin;
            int i32 = i10;
            int i33 = i29;
            if (i33 == 1) {
                if (z) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, i31, 6);
                    i12 = i33;
                    i13 = i31;
                    solverVariable3 = solverVariableCreateObjectVariable5;
                    i16 = i30;
                    solverVariable4 = solverVariableCreateObjectVariable4;
                    i17 = i32;
                    i14 = 2;
                    i19 = 3;
                    i15 = 4;
                } else {
                    if (z4) {
                        i21 = 4;
                        linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, i31, 4);
                    } else {
                        i21 = 4;
                        linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, i31, 1);
                    }
                    i15 = i21;
                    i12 = i33;
                    i13 = i31;
                    solverVariable3 = solverVariableCreateObjectVariable5;
                    i16 = i30;
                    solverVariable4 = solverVariableCreateObjectVariable4;
                    i17 = i32;
                    i14 = 2;
                    i19 = 3;
                }
                i18 = 1;
            } else if (i33 == 2) {
                if (constraintAnchor.getType() == ConstraintAnchor.Type.TOP || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                    solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                    constraintWidget = this.mParent;
                    type = ConstraintAnchor.Type.BOTTOM;
                } else {
                    solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                    constraintWidget = this.mParent;
                    type = ConstraintAnchor.Type.RIGHT;
                }
                i12 = i33;
                i15 = 4;
                i16 = i30;
                i13 = i31;
                i14 = 2;
                i18 = 1;
                i19 = 3;
                solverVariable3 = solverVariableCreateObjectVariable5;
                solverVariable4 = solverVariableCreateObjectVariable4;
                i17 = i32;
                linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, linearSystem.createObjectVariable(constraintWidget.getAnchor(type)), solverVariableCreateObjectVariable, f2));
                z6 = false;
            } else {
                i12 = i33;
                i13 = i31;
                i14 = 2;
                i15 = 4;
                solverVariable3 = solverVariableCreateObjectVariable5;
                i16 = i30;
                solverVariable4 = solverVariableCreateObjectVariable4;
                i17 = i32;
                i18 = 1;
                i19 = 3;
            }
            if (!z6 || i16 == i14 || z3) {
                i20 = i17;
            } else {
                int iMax = Math.max(i9, i13);
                i20 = i17;
                if (i20 > 0) {
                    iMax = Math.min(i20, iMax);
                }
                linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, iMax, 6);
                z6 = false;
            }
        } else {
            if (z2) {
                linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, 0, 3);
                if (i3 > 0) {
                    linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, i3, i8);
                }
                if (i4 < Integer.MAX_VALUE) {
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, i4, i8);
                }
            } else {
                linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, iMin, i8);
            }
            i9 = i6;
            solverVariable4 = solverVariableCreateObjectVariable4;
            solverVariable3 = solverVariableCreateObjectVariable5;
            i12 = i29;
            i16 = i30;
            i14 = 2;
            i18 = 1;
            i19 = 3;
            i15 = 4;
            i20 = i7;
        }
        if (!z5 || z4) {
            if (i16 >= i14 || !z) {
                return;
            }
            linearSystem.addGreaterThan(solverVariableCreateObjectVariable2, solverVariable, 0, 6);
            linearSystem.addGreaterThan(solverVariable2, solverVariableCreateObjectVariable3, 0, 6);
            return;
        }
        if (zIsConnected || zIsConnected2 || zIsConnected3) {
            i22 = 0;
            solverVariable5 = solverVariable2;
            if (!zIsConnected || zIsConnected2) {
                if (zIsConnected || !zIsConnected2) {
                    int i34 = i18;
                    int i35 = i19;
                    SolverVariable solverVariable11 = solverVariable3;
                    if (zIsConnected && zIsConnected2) {
                        if (z6) {
                            if (z && i3 == 0) {
                                linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, 0, 6);
                            }
                            if (i12 == 0) {
                                if (i20 > 0 || i9 > 0) {
                                    i26 = i34;
                                    i27 = i15;
                                } else {
                                    i27 = 6;
                                    i26 = 0;
                                }
                                solverVariable6 = solverVariable4;
                                linearSystem.addEquality(solverVariableCreateObjectVariable2, solverVariable6, constraintAnchor.getMargin(), i27);
                                linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariable11, -constraintAnchor2.getMargin(), i27);
                                if (i20 <= 0 && i9 <= 0) {
                                    i34 = 0;
                                }
                                i23 = 5;
                                i24 = i26;
                            } else {
                                int i36 = i12;
                                solverVariable6 = solverVariable4;
                                if (i36 == i34) {
                                    i24 = i34;
                                    i23 = 6;
                                } else if (i36 == i35) {
                                    int i37 = !z3 ? 6 : i15;
                                    linearSystem.addEquality(solverVariableCreateObjectVariable2, solverVariable6, constraintAnchor.getMargin(), i37);
                                    linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariable11, -constraintAnchor2.getMargin(), i37);
                                    i23 = 5;
                                    i24 = i34;
                                } else {
                                    i23 = 5;
                                    i34 = 0;
                                }
                            }
                            if (i34 == 0) {
                                solverVariable7 = solverVariable6;
                                solverVariable8 = solverVariableCreateObjectVariable3;
                                solverVariable9 = solverVariableCreateObjectVariable2;
                                linearSystem.addCentering(solverVariableCreateObjectVariable2, solverVariable6, constraintAnchor.getMargin(), f, solverVariable11, solverVariableCreateObjectVariable3, constraintAnchor2.getMargin(), i23);
                            } else {
                                solverVariable7 = solverVariable6;
                                solverVariable8 = solverVariableCreateObjectVariable3;
                                solverVariable9 = solverVariableCreateObjectVariable2;
                            }
                            if (i24 == 0) {
                                i25 = 6;
                                linearSystem.addGreaterThan(solverVariable9, solverVariable7, constraintAnchor.getMargin(), 6);
                                solverVariable10 = solverVariable8;
                                linearSystem.addLowerThan(solverVariable10, solverVariable11, -constraintAnchor2.getMargin(), 6);
                            } else {
                                solverVariable10 = solverVariable8;
                                i25 = 6;
                            }
                            if (z) {
                                i22 = 0;
                            } else {
                                i22 = 0;
                                linearSystem.addGreaterThan(solverVariable9, solverVariable, 0, i25);
                            }
                        } else {
                            solverVariable6 = solverVariable4;
                            if (z) {
                                linearSystem.addGreaterThan(solverVariableCreateObjectVariable2, solverVariable6, constraintAnchor.getMargin(), 5);
                                linearSystem.addLowerThan(solverVariableCreateObjectVariable3, solverVariable11, -constraintAnchor2.getMargin(), 5);
                            }
                            i23 = 5;
                        }
                        i24 = 0;
                        if (i34 == 0) {
                        }
                        if (i24 == 0) {
                        }
                        if (z) {
                        }
                    }
                } else {
                    linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariable3, -constraintAnchor2.getMargin(), 6);
                    if (z) {
                        linearSystem.addGreaterThan(solverVariableCreateObjectVariable2, solverVariable, 0, 5);
                    }
                }
            } else if (z) {
                linearSystem.addGreaterThan(solverVariable5, solverVariableCreateObjectVariable3, i22, 5);
            }
            solverVariable10 = solverVariableCreateObjectVariable3;
            i25 = 6;
        } else if (z) {
            i22 = 0;
            solverVariable5 = solverVariable2;
            linearSystem.addGreaterThan(solverVariable5, solverVariableCreateObjectVariable3, i22, 5);
            solverVariable10 = solverVariableCreateObjectVariable3;
            i25 = 6;
        } else {
            solverVariable10 = solverVariableCreateObjectVariable3;
            i25 = 6;
            i22 = 0;
        }
        if (z) {
            linearSystem.addGreaterThan(solverVariable2, solverVariable10, i22, i25);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addToSolver(LinearSystem linearSystem) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        boolean z5;
        boolean z6;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        LinearSystem linearSystem2;
        boolean z7;
        ConstraintWidget constraintWidget;
        float f;
        LinearSystem linearSystem3;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        boolean z8;
        boolean z9;
        ConstraintWidget constraintWidget2 = this;
        SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mLeft);
        SolverVariable solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(constraintWidget2.mRight);
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(constraintWidget2.mTop);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(constraintWidget2.mBottom);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem.createObjectVariable(constraintWidget2.mBaseline);
        if (constraintWidget2.mParent != null) {
            boolean z10 = constraintWidget2.mParent != null && constraintWidget2.mParent.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            boolean z11 = constraintWidget2.mParent != null && constraintWidget2.mParent.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
            if ((constraintWidget2.mLeft.mTarget == null || constraintWidget2.mLeft.mTarget.mTarget != constraintWidget2.mLeft) && (constraintWidget2.mRight.mTarget == null || constraintWidget2.mRight.mTarget.mTarget != constraintWidget2.mRight)) {
                z8 = false;
            } else {
                ((ConstraintWidgetContainer) constraintWidget2.mParent).addChain(constraintWidget2, 0);
                z8 = true;
            }
            if ((constraintWidget2.mTop.mTarget == null || constraintWidget2.mTop.mTarget.mTarget != constraintWidget2.mTop) && (constraintWidget2.mBottom.mTarget == null || constraintWidget2.mBottom.mTarget.mTarget != constraintWidget2.mBottom)) {
                z9 = false;
            } else {
                ((ConstraintWidgetContainer) constraintWidget2.mParent).addChain(constraintWidget2, 1);
                z9 = true;
            }
            if (z10 && constraintWidget2.mVisibility != 8 && constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mParent.mRight), solverVariableCreateObjectVariable2, 0, 1);
            }
            if (z11 && constraintWidget2.mVisibility != 8 && constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null && constraintWidget2.mBaseline == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mParent.mBottom), solverVariableCreateObjectVariable4, 0, 1);
            }
            z2 = z11;
            z3 = z8;
            z4 = z9;
            z = z10;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        int i3 = constraintWidget2.mWidth;
        if (i3 < constraintWidget2.mMinWidth) {
            i3 = constraintWidget2.mMinWidth;
        }
        int i4 = constraintWidget2.mHeight;
        if (i4 < constraintWidget2.mMinHeight) {
            i4 = constraintWidget2.mMinHeight;
        }
        boolean z12 = constraintWidget2.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z13 = constraintWidget2.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
        constraintWidget2.mResolvedDimensionRatioSide = constraintWidget2.mDimensionRatioSide;
        constraintWidget2.mResolvedDimensionRatio = constraintWidget2.mDimensionRatio;
        if (constraintWidget2.mDimensionRatio <= 0.0f || constraintWidget2.mVisibility == 8) {
            i = i3;
            i2 = i4;
            z5 = false;
        } else {
            if (constraintWidget2.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                constraintWidget2.setupDimensionRatio(z, z2, z12, z13);
            } else if (constraintWidget2.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                constraintWidget2.mResolvedDimensionRatioSide = 0;
                i3 = (int) (constraintWidget2.mResolvedDimensionRatio * constraintWidget2.mHeight);
            } else {
                if (constraintWidget2.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget2.mResolvedDimensionRatioSide = 1;
                    if (constraintWidget2.mDimensionRatioSide == -1) {
                        constraintWidget2.mResolvedDimensionRatio = 1.0f / constraintWidget2.mResolvedDimensionRatio;
                    }
                    i = i3;
                    i2 = (int) (constraintWidget2.mResolvedDimensionRatio * constraintWidget2.mWidth);
                }
                z5 = true;
            }
            i = i3;
            i2 = i4;
            z5 = true;
        }
        boolean z14 = z5 && (constraintWidget2.mResolvedDimensionRatioSide == 0 || constraintWidget2.mResolvedDimensionRatioSide == -1);
        boolean z15 = constraintWidget2.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT && (constraintWidget2 instanceof ConstraintWidgetContainer);
        boolean z16 = !constraintWidget2.mCenter.isConnected();
        if (constraintWidget2.mHorizontalResolution != 2) {
            z6 = z2;
            solverVariable = solverVariableCreateObjectVariable5;
            solverVariable2 = solverVariableCreateObjectVariable4;
            solverVariable3 = solverVariableCreateObjectVariable3;
            solverVariable4 = solverVariableCreateObjectVariable2;
            constraintWidget2.applyConstraints(linearSystem, z, constraintWidget2.mParent != null ? linearSystem.createObjectVariable(constraintWidget2.mParent.mLeft) : null, constraintWidget2.mParent != null ? linearSystem.createObjectVariable(constraintWidget2.mParent.mRight) : null, constraintWidget2.mListDimensionBehaviors[0], z15, constraintWidget2.mLeft, constraintWidget2.mRight, constraintWidget2.mX, i, constraintWidget2.mMinWidth, constraintWidget2.mMaxDimension[0], constraintWidget2.mHorizontalBiasPercent, z14, z3, constraintWidget2.mMatchConstraintDefaultWidth, constraintWidget2.mMatchConstraintMinWidth, constraintWidget2.mMatchConstraintMaxWidth, constraintWidget2.mMatchConstraintPercentWidth, z16);
            constraintWidget2 = this;
        } else {
            z6 = z2;
            solverVariable = solverVariableCreateObjectVariable5;
            solverVariable2 = solverVariableCreateObjectVariable4;
            solverVariable3 = solverVariableCreateObjectVariable3;
            solverVariable4 = solverVariableCreateObjectVariable2;
        }
        if (constraintWidget2.mVerticalResolution == 2) {
            return;
        }
        boolean z17 = constraintWidget2.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT && (constraintWidget2 instanceof ConstraintWidgetContainer);
        boolean z18 = z5 && (constraintWidget2.mResolvedDimensionRatioSide == 1 || constraintWidget2.mResolvedDimensionRatioSide == -1);
        if (constraintWidget2.mBaselineDistance <= 0) {
            solverVariable5 = solverVariable3;
            linearSystem2 = linearSystem;
        } else {
            if (constraintWidget2.mBaseline.getResolutionNode().state != 1) {
                linearSystem2 = linearSystem;
                SolverVariable solverVariable10 = solverVariable;
                solverVariable5 = solverVariable3;
                linearSystem2.addEquality(solverVariable10, solverVariable5, getBaselineDistance(), 6);
                if (constraintWidget2.mBaseline.mTarget != null) {
                    linearSystem2.addEquality(solverVariable10, linearSystem2.createObjectVariable(constraintWidget2.mBaseline.mTarget), 0, 6);
                    z7 = false;
                }
                int i5 = i2;
                SolverVariable solverVariable11 = solverVariable5;
                constraintWidget2.applyConstraints(linearSystem2, z6, constraintWidget2.mParent == null ? linearSystem2.createObjectVariable(constraintWidget2.mParent.mTop) : null, constraintWidget2.mParent == null ? linearSystem2.createObjectVariable(constraintWidget2.mParent.mBottom) : null, constraintWidget2.mListDimensionBehaviors[1], z17, constraintWidget2.mTop, constraintWidget2.mBottom, constraintWidget2.mY, i5, constraintWidget2.mMinHeight, constraintWidget2.mMaxDimension[1], constraintWidget2.mVerticalBiasPercent, z18, z4, constraintWidget2.mMatchConstraintDefaultHeight, constraintWidget2.mMatchConstraintMinHeight, constraintWidget2.mMatchConstraintMaxHeight, constraintWidget2.mMatchConstraintPercentHeight, z7);
                if (z5) {
                    constraintWidget = this;
                } else {
                    int i6 = 6;
                    constraintWidget = this;
                    if (constraintWidget.mResolvedDimensionRatioSide == 1) {
                        f = constraintWidget.mResolvedDimensionRatio;
                        i6 = 6;
                        linearSystem3 = linearSystem;
                        solverVariable6 = solverVariable2;
                        solverVariable7 = solverVariable11;
                        solverVariable8 = solverVariable4;
                        solverVariable9 = solverVariableCreateObjectVariable;
                    } else {
                        f = constraintWidget.mResolvedDimensionRatio;
                        linearSystem3 = linearSystem;
                        solverVariable6 = solverVariable4;
                        solverVariable7 = solverVariableCreateObjectVariable;
                        solverVariable8 = solverVariable2;
                        solverVariable9 = solverVariable11;
                    }
                    linearSystem3.addRatio(solverVariable6, solverVariable7, solverVariable8, solverVariable9, f, i6);
                }
                if (constraintWidget.mCenter.isConnected()) {
                    return;
                }
                linearSystem.addCenterPoint(constraintWidget, constraintWidget.mCenter.getTarget().getOwner(), (float) Math.toRadians(constraintWidget.mCircleConstraintAngle + 90.0f), constraintWidget.mCenter.getMargin());
                return;
            }
            linearSystem2 = linearSystem;
            constraintWidget2.mBaseline.getResolutionNode().addResolvedValue(linearSystem2);
            solverVariable5 = solverVariable3;
        }
        z7 = z16;
        if (constraintWidget2.mParent == null) {
        }
        if (constraintWidget2.mParent == null) {
        }
        int i52 = i2;
        SolverVariable solverVariable112 = solverVariable5;
        constraintWidget2.applyConstraints(linearSystem2, z6, constraintWidget2.mParent == null ? linearSystem2.createObjectVariable(constraintWidget2.mParent.mTop) : null, constraintWidget2.mParent == null ? linearSystem2.createObjectVariable(constraintWidget2.mParent.mBottom) : null, constraintWidget2.mListDimensionBehaviors[1], z17, constraintWidget2.mTop, constraintWidget2.mBottom, constraintWidget2.mY, i52, constraintWidget2.mMinHeight, constraintWidget2.mMaxDimension[1], constraintWidget2.mVerticalBiasPercent, z18, z4, constraintWidget2.mMatchConstraintDefaultHeight, constraintWidget2.mMatchConstraintMinHeight, constraintWidget2.mMatchConstraintMaxHeight, constraintWidget2.mMatchConstraintPercentHeight, z7);
        if (z5) {
        }
        if (constraintWidget.mCenter.isConnected()) {
        }
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void analyze(int i) {
        Optimizer.analyze(i, this);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        connect(type, constraintWidget, type2, i, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength) {
        connect(type, constraintWidget, type2, i, strength, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x01e7 A[PHI: r0 r3
  0x01e7: PHI (r0v3 android.support.constraint.solver.widgets.ConstraintAnchor) = 
  (r0v2 android.support.constraint.solver.widgets.ConstraintAnchor)
  (r0v5 android.support.constraint.solver.widgets.ConstraintAnchor)
 binds: [B:103:0x021a, B:94:0x01e5] A[DONT_GENERATE, DONT_INLINE]
  0x01e7: PHI (r3v9 android.support.constraint.solver.widgets.ConstraintAnchor) = 
  (r3v8 android.support.constraint.solver.widgets.ConstraintAnchor)
  (r3v15 android.support.constraint.solver.widgets.ConstraintAnchor)
 binds: [B:103:0x021a, B:94:0x01e5] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength, int i2) {
        ConstraintAnchor opposite;
        ConstraintAnchor anchor;
        ConstraintAnchor.Type type3;
        ConstraintAnchor anchor2;
        ConstraintAnchor anchor3;
        int i3;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintAnchor.Type type4;
        ConstraintAnchor.Strength strength2;
        int i4;
        ConstraintAnchor.Type type5;
        boolean z;
        ConstraintAnchor.Type type6;
        int i5 = 0;
        if (type == ConstraintAnchor.Type.CENTER) {
            if (type2 == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean z2 = true;
                if ((anchor4 == null || !anchor4.isConnected()) && (anchor5 == null || !anchor5.isConnected())) {
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.LEFT, 0, strength, i2);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget, ConstraintAnchor.Type.RIGHT, 0, strength, i2);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor6 == null || !anchor6.isConnected()) && (anchor7 == null || !anchor7.isConnected())) {
                    connect(ConstraintAnchor.Type.TOP, constraintWidget, ConstraintAnchor.Type.TOP, 0, strength, i2);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, ConstraintAnchor.Type.BOTTOM, 0, strength, i2);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    anchor3 = getAnchor(ConstraintAnchor.Type.CENTER);
                    type6 = ConstraintAnchor.Type.CENTER;
                } else if (z) {
                    anchor3 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                    type6 = ConstraintAnchor.Type.CENTER_X;
                } else {
                    if (!z2) {
                        return;
                    }
                    anchor3 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                    type6 = ConstraintAnchor.Type.CENTER_Y;
                }
                anchor2 = constraintWidget.getAnchor(type6);
            } else {
                if (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT) {
                    i3 = 0;
                    constraintWidget2 = this;
                    constraintWidget3 = constraintWidget;
                    type4 = type2;
                    strength2 = strength;
                    i4 = i2;
                    constraintWidget2.connect(ConstraintAnchor.Type.LEFT, constraintWidget3, type4, 0, strength2, i4);
                    type5 = ConstraintAnchor.Type.RIGHT;
                } else {
                    if (type2 != ConstraintAnchor.Type.TOP && type2 != ConstraintAnchor.Type.BOTTOM) {
                        return;
                    }
                    i3 = 0;
                    constraintWidget2 = this;
                    constraintWidget3 = constraintWidget;
                    type4 = type2;
                    strength2 = strength;
                    i4 = i2;
                    constraintWidget2.connect(ConstraintAnchor.Type.TOP, constraintWidget3, type4, 0, strength2, i4);
                    type5 = ConstraintAnchor.Type.BOTTOM;
                }
                constraintWidget2.connect(type5, constraintWidget3, type4, i3, strength2, i4);
                type3 = ConstraintAnchor.Type.CENTER;
                anchor3 = getAnchor(type3);
                anchor2 = constraintWidget.getAnchor(type2);
            }
        } else if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor8 = getAnchor(ConstraintAnchor.Type.LEFT);
            anchor2 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor9 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor8.connect(anchor2, 0, i2);
            anchor9.connect(anchor2, 0, i2);
            anchor3 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        } else {
            if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
                ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
                getAnchor(ConstraintAnchor.Type.TOP).connect(anchor10, 0, i2);
                getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor10, 0, i2);
                getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor10, 0, i2);
                return;
            }
            if (type == ConstraintAnchor.Type.CENTER_X && type2 == ConstraintAnchor.Type.CENTER_X) {
                getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0, i2);
                getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0, i2);
                type3 = ConstraintAnchor.Type.CENTER_X;
            } else {
                if (type != ConstraintAnchor.Type.CENTER_Y || type2 != ConstraintAnchor.Type.CENTER_Y) {
                    ConstraintAnchor anchor11 = getAnchor(type);
                    ConstraintAnchor anchor12 = constraintWidget.getAnchor(type2);
                    if (anchor11.isValidConnection(anchor12)) {
                        if (type == ConstraintAnchor.Type.BASELINE) {
                            ConstraintAnchor anchor13 = getAnchor(ConstraintAnchor.Type.TOP);
                            ConstraintAnchor anchor14 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                            if (anchor13 != null) {
                                anchor13.reset();
                            }
                            if (anchor14 != null) {
                                anchor14.reset();
                            }
                        } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                            ConstraintAnchor anchor15 = getAnchor(ConstraintAnchor.Type.BASELINE);
                            if (anchor15 != null) {
                                anchor15.reset();
                            }
                            ConstraintAnchor anchor16 = getAnchor(ConstraintAnchor.Type.CENTER);
                            if (anchor16.getTarget() != anchor12) {
                                anchor16.reset();
                            }
                            opposite = getAnchor(type).getOpposite();
                            anchor = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                            if (anchor.isConnected()) {
                                opposite.reset();
                                anchor.reset();
                            }
                            i5 = i;
                        } else {
                            if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                                ConstraintAnchor anchor17 = getAnchor(ConstraintAnchor.Type.CENTER);
                                if (anchor17.getTarget() != anchor12) {
                                    anchor17.reset();
                                }
                                opposite = getAnchor(type).getOpposite();
                                anchor = getAnchor(ConstraintAnchor.Type.CENTER_X);
                                if (anchor.isConnected()) {
                                }
                            }
                            i5 = i;
                        }
                        anchor11.connect(anchor12, i5, strength, i2);
                        anchor12.getOwner().connectedTo(anchor11.getOwner());
                        return;
                    }
                    return;
                }
                getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0, i2);
                getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0, i2);
                type3 = ConstraintAnchor.Type.CENTER_Y;
            }
            anchor3 = getAnchor(type3);
            anchor2 = constraintWidget.getAnchor(type2);
        }
        anchor3.connect(anchor2, 0, i2);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, 0);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, i2);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, ConstraintAnchor.Strength strength, int i2) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i, strength, i2);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public void connectedTo(ConstraintWidget constraintWidget) {
    }

    public void disconnectUnlockedWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget && constraintAnchor.getConnectionCreator() == 2) {
                constraintAnchor.reset();
            }
        }
    }

    public void disconnectWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget) {
                constraintAnchor.reset();
            }
        }
    }

    public void forceUpdateDrawPosition() {
        int i = this.mX;
        int i2 = this.mY;
        int i3 = this.mX + this.mWidth;
        int i4 = this.mY + this.mHeight;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = i4 - i2;
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (type) {
            case LEFT:
                return this.mLeft;
            case TOP:
                return this.mTop;
            case RIGHT:
                return this.mRight;
            case BOTTOM:
                return this.mBottom;
            case BASELINE:
                return this.mBaseline;
            case CENTER:
                return this.mCenter;
            case CENTER_X:
                return this.mCenterX;
            case CENTER_Y:
                return this.mCenterY;
            case NONE:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public int getDrawBottom() {
        return getDrawY() + this.mDrawHeight;
    }

    public int getDrawHeight() {
        return this.mDrawHeight;
    }

    public int getDrawRight() {
        return getDrawX() + this.mDrawWidth;
    }

    public int getDrawWidth() {
        return this.mDrawWidth;
    }

    public int getDrawX() {
        return this.mDrawX + this.mOffsetX;
    }

    public int getDrawY() {
        return this.mDrawY + this.mOffsetY;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getInternalDrawBottom() {
        return this.mDrawY + this.mDrawHeight;
    }

    public int getInternalDrawRight() {
        return this.mDrawX + this.mDrawWidth;
    }

    int getInternalDrawX() {
        return this.mDrawX;
    }

    int getInternalDrawY() {
        return this.mDrawY;
    }

    public int getLeft() {
        return getX();
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizerWrapHeight() {
        int iMax;
        int i = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            iMax = Math.max(this.mMatchConstraintMinHeight, i);
        } else if (this.mMatchConstraintMinHeight > 0) {
            iMax = this.mMatchConstraintMinHeight;
            this.mHeight = iMax;
        } else {
            iMax = 0;
        }
        return (this.mMatchConstraintMaxHeight <= 0 || this.mMatchConstraintMaxHeight >= iMax) ? iMax : this.mMatchConstraintMaxHeight;
    }

    public int getOptimizerWrapWidth() {
        int iMax;
        int i = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            iMax = Math.max(this.mMatchConstraintMinWidth, i);
        } else if (this.mMatchConstraintMinWidth > 0) {
            iMax = this.mMatchConstraintMinWidth;
            this.mWidth = iMax;
        } else {
            iMax = 0;
        }
        return (this.mMatchConstraintMaxWidth <= 0 || this.mMatchConstraintMaxWidth >= iMax) ? iMax : this.mMatchConstraintMaxWidth;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ResolutionDimension getResolutionHeight() {
        if (this.mResolutionHeight == null) {
            this.mResolutionHeight = new ResolutionDimension();
        }
        return this.mResolutionHeight;
    }

    public ResolutionDimension getResolutionWidth() {
        if (this.mResolutionWidth == null) {
            this.mResolutionWidth = new ResolutionDimension();
        }
        return this.mResolutionWidth;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public WidgetContainer getRootWidgetContainer() {
        while (this.getParent() != null) {
            this = this.getParent();
        }
        if (this instanceof WidgetContainer) {
            return (WidgetContainer) this;
        }
        return null;
    }

    protected int getRootX() {
        return this.mX + this.mOffsetX;
    }

    protected int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getWrapHeight() {
        return this.mWrapHeight;
    }

    public int getWrapWidth() {
        return this.mWrapWidth;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public boolean hasAncestor(ConstraintWidget constraintWidget) {
        ConstraintWidget parent = getParent();
        if (parent == constraintWidget) {
            return true;
        }
        if (parent == constraintWidget.getParent()) {
            return false;
        }
        while (parent != null) {
            if (parent == constraintWidget || parent == constraintWidget.getParent()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean hasBaseline() {
        return this.mBaselineDistance > 0;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public boolean isFullyResolved() {
        return this.mLeft.getResolutionNode().state == 1 && this.mRight.getResolutionNode().state == 1 && this.mTop.getResolutionNode().state == 1 && this.mBottom.getResolutionNode().state == 1;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != this.mLeft) {
            return this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight;
        }
        return true;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget == null || this.mTop.mTarget.mTarget != this.mTop) {
            return this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom;
        }
        return true;
    }

    public boolean isInsideConstraintLayout() {
        ConstraintWidget parent = getParent();
        if (parent == null) {
            return false;
        }
        while (parent != null) {
            if (parent instanceof ConstraintWidgetContainer) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isRootContainer() {
        if (this instanceof ConstraintWidgetContainer) {
            return this.mParent == null || !(this.mParent instanceof ConstraintWidgetContainer);
        }
        return false;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mWrapWidth = 0;
        this.mWrapHeight = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        this.mWeight[0] = 0.0f;
        this.mWeight[1] = 0.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMaxDimension[0] = Integer.MAX_VALUE;
        this.mMaxDimension[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMatchConstraintMaxHeight = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        if (this.mResolutionWidth != null) {
            this.mResolutionWidth.reset();
        }
        if (this.mResolutionHeight != null) {
            this.mResolutionHeight.reset();
        }
    }

    public void resetAllConstraints() {
        DimensionBehaviour dimensionBehaviour;
        DimensionBehaviour dimensionBehaviour2;
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
        if (this instanceof ConstraintWidgetContainer) {
            return;
        }
        if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (getWidth() == getWrapWidth()) {
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
            } else if (getWidth() > getMinWidth()) {
                dimensionBehaviour2 = DimensionBehaviour.FIXED;
            }
            setHorizontalDimensionBehaviour(dimensionBehaviour2);
        }
        if (getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (getHeight() == getWrapHeight()) {
                dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
            } else if (getHeight() <= getMinHeight()) {
                return;
            } else {
                dimensionBehaviour = DimensionBehaviour.FIXED;
            }
            setVerticalDimensionBehaviour(dimensionBehaviour);
        }
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() != null && (getParent() instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor != anchor5) {
            if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2 ? !(!anchor.isConnected() || anchor.getTarget() != anchor2.getTarget()) : !((constraintAnchor != anchor3 && constraintAnchor != anchor4) || !anchor3.isConnected() || anchor3.getTarget() != anchor4.getTarget())) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
        if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
            anchor.reset();
            anchor2.reset();
        }
        if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
            anchor3.reset();
            anchor4.reset();
        }
        this.mHorizontalBiasPercent = 0.5f;
        this.mVerticalBiasPercent = 0.5f;
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).reset();
        }
    }

    public void resetAnchors(int i) {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.mAnchors.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintAnchor constraintAnchor = this.mAnchors.get(i2);
            if (i == constraintAnchor.getConnectionCreator()) {
                if (constraintAnchor.isVerticalAnchor()) {
                    setVerticalBiasPercent(DEFAULT_BIAS);
                } else {
                    setHorizontalBiasPercent(DEFAULT_BIAS);
                }
                constraintAnchor.reset();
            }
        }
    }

    public void resetResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().reset();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void resolve() {
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setContainerItemSkip(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mContainerItemSkip = i;
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        solverVariableCreateObjectVariable.setName(str + ".left");
        solverVariableCreateObjectVariable2.setName(str + ".top");
        solverVariableCreateObjectVariable3.setName(str + ".right");
        solverVariableCreateObjectVariable4.setName(str + ".bottom");
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline).setName(str + ".baseline");
        }
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
        this.mHeight = i2;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0084 A[PHI: r0
  0x0084: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:45:0x0084, B:35:0x007d, B:23:0x004f, B:25:0x0055, B:27:0x0061, B:29:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDimensionRatio(String str) throws NumberFormatException {
        float fAbs;
        int i = 0;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int i2 = -1;
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i3 = 0;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (strSubstring.equalsIgnoreCase("W")) {
                i2 = 0;
            } else if (strSubstring.equalsIgnoreCase("H")) {
                i2 = 1;
            }
            i3 = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
            String strSubstring2 = str.substring(i3);
            fAbs = strSubstring2.length() > 0 ? Float.parseFloat(strSubstring2) : i;
        } else {
            String strSubstring3 = str.substring(i3, iIndexOf2);
            String strSubstring4 = str.substring(iIndexOf2 + 1);
            if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                float f = Float.parseFloat(strSubstring3);
                float f2 = Float.parseFloat(strSubstring4);
                if (f > 0.0f && f2 > 0.0f) {
                    fAbs = i2 == 1 ? Math.abs(f2 / f) : Math.abs(f / f2);
                }
            }
        }
        i = (fAbs > i ? 1 : (fAbs == i ? 0 : -1));
        if (i > 0) {
            this.mDimensionRatio = fAbs;
            this.mDimensionRatioSide = i2;
        }
    }

    public void setDrawHeight(int i) {
        this.mDrawHeight = i;
    }

    public void setDrawOrigin(int i, int i2) {
        this.mDrawX = i - this.mOffsetX;
        this.mDrawY = i2 - this.mOffsetY;
        this.mX = this.mDrawX;
        this.mY = this.mDrawY;
    }

    public void setDrawWidth(int i) {
        this.mDrawWidth = i;
    }

    public void setDrawX(int i) {
        this.mDrawX = i - this.mOffsetX;
        this.mX = this.mDrawX;
    }

    public void setDrawY(int i) {
        this.mDrawY = i - this.mOffsetY;
        this.mY = this.mDrawY;
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.mX = i;
        this.mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i5 < this.mWidth) {
            i5 = this.mWidth;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i6 < this.mHeight) {
            i6 = this.mHeight;
        }
        this.mWidth = i5;
        this.mHeight = i6;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        ConstraintAnchor constraintAnchor;
        switch (type) {
            case LEFT:
                constraintAnchor = this.mLeft;
                break;
            case TOP:
                constraintAnchor = this.mTop;
                break;
            case RIGHT:
                constraintAnchor = this.mRight;
                break;
            case BOTTOM:
                constraintAnchor = this.mBottom;
                break;
            default:
                return;
        }
        constraintAnchor.mGoneMargin = i;
    }

    public void setHeight(int i) {
        this.mHeight = i;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.mX = i;
        this.mWidth = i2 - i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.mWrapWidth);
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f >= 1.0f || this.mMatchConstraintDefaultWidth != 0) {
            return;
        }
        this.mMatchConstraintDefaultWidth = 2;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mMinHeight = i;
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mMinWidth = i;
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setOrigin(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public void setVerticalDimension(int i, int i2) {
        this.mY = i;
        this.mHeight = i2 - i;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.mWrapHeight);
        }
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f >= 1.0f || this.mMatchConstraintDefaultHeight != 0) {
            return;
        }
        this.mMatchConstraintDefaultHeight = 2;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public void setWrapHeight(int i) {
        this.mWrapHeight = i;
    }

    public void setWrapWidth(int i) {
        this.mWrapWidth = i;
    }

    public void setX(int i) {
        this.mX = i;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mMatchConstraintDefaultWidth == 0) {
            this.mMatchConstraintDefaultWidth = 3;
        }
        if (this.mMatchConstraintDefaultHeight == 0) {
            this.mMatchConstraintDefaultHeight = 3;
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z && !z2) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z && z2) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
                return;
            }
            if (this.mMatchConstraintMinWidth == 0) {
                int i = this.mMatchConstraintMinHeight;
            }
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(") wrap: (");
        sb.append(this.mWrapWidth);
        sb.append(" x ");
        sb.append(this.mWrapHeight);
        sb.append(")");
        return sb.toString();
    }

    public void updateDrawPosition() {
        int i = this.mX;
        int i2 = this.mY;
        int i3 = this.mX + this.mWidth;
        int i4 = this.mY + this.mHeight;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = i4 - i2;
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        setFrame(linearSystem.getObjectVariableValue(this.mLeft), linearSystem.getObjectVariableValue(this.mTop), linearSystem.getObjectVariableValue(this.mRight), linearSystem.getObjectVariableValue(this.mBottom));
    }

    public void updateResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().update();
        }
    }
}
