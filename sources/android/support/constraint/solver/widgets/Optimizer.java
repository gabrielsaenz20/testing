package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 3;
    static boolean[] flags = new boolean[3];

    /* JADX WARN: Code restructure failed: missing block: B:137:0x0288, code lost:
    
        if (r13 != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x028a, code lost:
    
        r3.dependsOn(r1, 1, r14.getResolutionHeight());
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0291, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0292, code lost:
    
        r3.dependsOn(r1, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0295, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02a2, code lost:
    
        if (r13 != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        if (r13 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
    
        r4 = r14.getWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        if (r13 != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b A[PHI: r4
  0x005b: PHI (r4v12 int) = (r4v8 int), (r4v8 int), (r4v40 int) binds: [B:59:0x011d, B:53:0x010d, B:19:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void analyze(int i, ConstraintWidget constraintWidget) {
        int width;
        constraintWidget.updateResolutionNodes();
        ResolutionAnchor resolutionNode = constraintWidget.mLeft.getResolutionNode();
        ResolutionAnchor resolutionNode2 = constraintWidget.mTop.getResolutionNode();
        ResolutionAnchor resolutionNode3 = constraintWidget.mRight.getResolutionNode();
        ResolutionAnchor resolutionNode4 = constraintWidget.mBottom.getResolutionNode();
        boolean z = (i & 8) == 8;
        if (resolutionNode.type != 4 && resolutionNode3.type != 4) {
            if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED) {
                if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                } else if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                } else if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget != null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    if (!z) {
                        width = constraintWidget.getWidth();
                        resolutionNode.dependsOn(resolutionNode3, -width);
                    }
                    resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                } else if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) {
                    resolutionNode.setType(2);
                    resolutionNode3.setType(2);
                    if (z) {
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                        resolutionNode.setOpposite(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                        resolutionNode3.setOpposite(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.setOpposite(resolutionNode3, -constraintWidget.getWidth());
                        resolutionNode3.setOpposite(resolutionNode, constraintWidget.getWidth());
                    }
                }
            } else if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget, 0)) {
                width = constraintWidget.getWidth();
                resolutionNode.setType(1);
                resolutionNode3.setType(1);
                if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                    if (z) {
                    }
                } else if (constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget != null) {
                    if (constraintWidget.mLeft.mTarget != null || constraintWidget.mRight.mTarget == null) {
                        if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) {
                            if (z) {
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                            }
                            if (constraintWidget.mDimensionRatio == 0.0f) {
                                resolutionNode.setType(3);
                                resolutionNode3.setType(3);
                                resolutionNode.setOpposite(resolutionNode3, 0.0f);
                                resolutionNode3.setOpposite(resolutionNode, 0.0f);
                            } else {
                                resolutionNode.setType(2);
                                resolutionNode3.setType(2);
                                resolutionNode.setOpposite(resolutionNode3, -width);
                                resolutionNode3.setOpposite(resolutionNode, width);
                                constraintWidget.setWidth(width);
                            }
                        }
                    } else if (z) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -width);
                    }
                } else if (z) {
                    resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                } else {
                    resolutionNode3.dependsOn(resolutionNode, width);
                }
            }
        }
        if (resolutionNode2.type == 4 || resolutionNode4.type == 4) {
            return;
        }
        if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED) {
            if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                if (z) {
                    resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                } else {
                    resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                }
                if (constraintWidget.mBaseline.mTarget != null) {
                    constraintWidget.mBaseline.getResolutionNode().setType(1);
                    resolutionNode2.dependsOn(1, constraintWidget.mBaseline.getResolutionNode(), -constraintWidget.mBaselineDistance);
                    return;
                }
                return;
            }
            if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget == null) {
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                if (z) {
                    resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                } else {
                    resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                }
                if (constraintWidget.mBaselineDistance <= 0) {
                    return;
                }
            } else if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget != null) {
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                if (z) {
                    resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                } else {
                    resolutionNode2.dependsOn(resolutionNode4, -constraintWidget.getHeight());
                }
                if (constraintWidget.mBaselineDistance <= 0) {
                    return;
                }
            } else {
                if (constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget == null) {
                    return;
                }
                resolutionNode2.setType(2);
                resolutionNode4.setType(2);
                if (z) {
                    resolutionNode2.setOpposite(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    resolutionNode4.setOpposite(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                    constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                } else {
                    resolutionNode2.setOpposite(resolutionNode4, -constraintWidget.getHeight());
                    resolutionNode4.setOpposite(resolutionNode2, constraintWidget.getHeight());
                }
                if (constraintWidget.mBaselineDistance <= 0) {
                    return;
                }
            }
        } else {
            if (constraintWidget.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || !optimizableMatchConstraint(constraintWidget, 1)) {
                return;
            }
            int height = constraintWidget.getHeight();
            resolutionNode2.setType(1);
            resolutionNode4.setType(1);
            if (constraintWidget.mTop.mTarget != null || constraintWidget.mBottom.mTarget != null) {
                if (constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget != null) {
                    if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget != null) {
                        if (z) {
                            resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                            return;
                        } else {
                            resolutionNode2.dependsOn(resolutionNode4, -height);
                            return;
                        }
                    }
                    if (constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget == null) {
                        return;
                    }
                    if (z) {
                        constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                    }
                    if (constraintWidget.mDimensionRatio == 0.0f) {
                        resolutionNode2.setType(3);
                        resolutionNode4.setType(3);
                        resolutionNode2.setOpposite(resolutionNode4, 0.0f);
                        resolutionNode4.setOpposite(resolutionNode2, 0.0f);
                        return;
                    }
                    resolutionNode2.setType(2);
                    resolutionNode4.setType(2);
                    resolutionNode2.setOpposite(resolutionNode4, -height);
                    resolutionNode4.setOpposite(resolutionNode2, height);
                    constraintWidget.setHeight(height);
                    if (constraintWidget.mBaselineDistance <= 0) {
                        return;
                    }
                }
            }
        }
        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055 A[PHI: r6 r7
  0x0055: PHI (r6v27 boolean) = (r6v2 boolean), (r6v30 boolean) binds: [B:42:0x0069, B:30:0x0053] A[DONT_GENERATE, DONT_INLINE]
  0x0055: PHI (r7v30 boolean) = (r7v2 boolean), (r7v33 boolean) binds: [B:42:0x0069, B:30:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0057 A[PHI: r6 r7
  0x0057: PHI (r6v4 boolean) = (r6v2 boolean), (r6v30 boolean) binds: [B:42:0x0069, B:30:0x0053] A[DONT_GENERATE, DONT_INLINE]
  0x0057: PHI (r7v4 boolean) = (r7v2 boolean), (r7v33 boolean) binds: [B:42:0x0069, B:30:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012e  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static boolean applyChainOptimized(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ConstraintWidget constraintWidget) {
        ConstraintWidget constraintWidget2;
        boolean z;
        boolean z2;
        boolean z3;
        float margin;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.mListDimensionBehaviors[i];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0 && constraintWidgetContainer.isRtl()) {
            constraintWidget2 = constraintWidget;
            boolean z4 = false;
            while (!z4) {
                ConstraintAnchor constraintAnchor = constraintWidget2.mListAnchors[i2 + 1].mTarget;
                if (constraintAnchor != null) {
                    constraintWidget4 = constraintAnchor.mOwner;
                    if (constraintWidget4.mListAnchors[i2].mTarget == null || constraintWidget4.mListAnchors[i2].mTarget.mOwner != constraintWidget2) {
                        constraintWidget4 = null;
                    }
                }
                if (constraintWidget4 != null) {
                    constraintWidget2 = constraintWidget4;
                } else {
                    z4 = true;
                }
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        if (i == 0) {
            z = constraintWidget2.mHorizontalChainStyle == 0;
            z2 = constraintWidget2.mHorizontalChainStyle == 1;
            z3 = constraintWidget2.mHorizontalChainStyle == 2;
        } else {
            z = constraintWidget2.mVerticalChainStyle == 0;
            z2 = constraintWidget2.mVerticalChainStyle == 1;
            if (constraintWidget2.mVerticalChainStyle == 2) {
            }
        }
        ConstraintWidget constraintWidget5 = constraintWidget;
        ConstraintWidget constraintWidget6 = null;
        ConstraintWidget constraintWidget7 = null;
        ConstraintWidget constraintWidget8 = null;
        ConstraintWidget constraintWidget9 = null;
        boolean z5 = false;
        int i3 = 0;
        int i4 = 0;
        float width = 0.0f;
        float margin2 = 0.0f;
        float f = 0.0f;
        while (!z5) {
            constraintWidget5.mListNextVisibleWidget[i] = null;
            if (constraintWidget5.getVisibility() != 8) {
                if (constraintWidget7 != null) {
                    constraintWidget7.mListNextVisibleWidget[i] = constraintWidget5;
                }
                if (constraintWidget8 == null) {
                    constraintWidget8 = constraintWidget5;
                }
                i3++;
                width += i == 0 ? constraintWidget5.getWidth() : constraintWidget5.getHeight();
                if (constraintWidget5 != constraintWidget8) {
                    width += constraintWidget5.mListAnchors[i2].getMargin();
                }
                margin2 = margin2 + constraintWidget5.mListAnchors[i2].getMargin() + constraintWidget5.mListAnchors[i2 + 1].getMargin();
                constraintWidget7 = constraintWidget5;
            }
            ConstraintAnchor constraintAnchor2 = constraintWidget5.mListAnchors[i2];
            constraintWidget5.mListNextMatchConstraintsWidget[i] = null;
            if (constraintWidget5.getVisibility() != 8 && constraintWidget5.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                i4++;
                if (i == 0) {
                    if (constraintWidget5.mMatchConstraintDefaultWidth != 0 || constraintWidget5.mMatchConstraintMinWidth != 0 || constraintWidget5.mMatchConstraintMaxWidth != 0) {
                        return false;
                    }
                } else if (constraintWidget5.mMatchConstraintDefaultHeight != 0 || constraintWidget5.mMatchConstraintMinHeight != 0 || constraintWidget5.mMatchConstraintMaxHeight != 0) {
                    return false;
                }
                f += constraintWidget5.mWeight[i];
                if (constraintWidget9 == null) {
                    constraintWidget9 = constraintWidget5;
                } else {
                    constraintWidget6.mListNextMatchConstraintsWidget[i] = constraintWidget5;
                }
                constraintWidget6 = constraintWidget5;
            }
            ConstraintAnchor constraintAnchor3 = constraintWidget5.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor3 != null) {
                constraintWidget3 = constraintAnchor3.mOwner;
                if (constraintWidget3.mListAnchors[i2].mTarget == null || constraintWidget3.mListAnchors[i2].mTarget.mOwner != constraintWidget5) {
                    constraintWidget3 = null;
                }
            }
            if (constraintWidget3 != null) {
                constraintWidget5 = constraintWidget3;
            } else {
                z5 = true;
            }
        }
        ResolutionAnchor resolutionNode = constraintWidget.mListAnchors[i2].getResolutionNode();
        int i5 = i2 + 1;
        ResolutionAnchor resolutionNode2 = constraintWidget5.mListAnchors[i5].getResolutionNode();
        if (resolutionNode.target == null || resolutionNode2.target == null) {
            return false;
        }
        if (resolutionNode.target.state != 1 && resolutionNode2.target.state != 1) {
            return false;
        }
        if (i4 > 0 && i4 != i3) {
            return false;
        }
        if (z3 || z || z2) {
            margin = constraintWidget8 != null ? constraintWidget8.mListAnchors[i2].getMargin() : 0.0f;
            if (constraintWidget7 != null) {
                margin += constraintWidget7.mListAnchors[i5].getMargin();
            }
        } else {
            margin = 0.0f;
        }
        float margin3 = resolutionNode.target.resolvedOffset;
        float f2 = resolutionNode2.target.resolvedOffset;
        float f3 = (margin3 < f2 ? f2 - margin3 : margin3 - f2) - width;
        if (i4 > 0 && i4 == i3) {
            if (constraintWidget5.getParent() != null && constraintWidget5.getParent().mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                return false;
            }
            float f4 = (f3 + width) - margin2;
            if (z) {
                f4 -= margin2 - margin;
            }
            if (z) {
                margin3 += constraintWidget8.mListAnchors[i5].getMargin();
                if (constraintWidget8.mListNextVisibleWidget[i] != null) {
                    margin3 += r1.mListAnchors[i2].getMargin();
                }
            }
            while (constraintWidget8 != null) {
                if (LinearSystem.sMetrics != null) {
                    LinearSystem.sMetrics.nonresolvedWidgets--;
                    LinearSystem.sMetrics.resolvedWidgets++;
                    LinearSystem.sMetrics.chainConnectionResolved++;
                }
                ConstraintWidget constraintWidget10 = constraintWidget8.mListNextVisibleWidget[i];
                if (constraintWidget10 != null || constraintWidget8 == constraintWidget7) {
                    float f5 = f4 / i4;
                    if (f > 0.0f) {
                        f5 = (constraintWidget8.mWeight[i] * f4) / f;
                    }
                    float margin4 = margin3 + constraintWidget8.mListAnchors[i2].getMargin();
                    constraintWidget8.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin4);
                    float f6 = margin4 + f5;
                    constraintWidget8.mListAnchors[i5].getResolutionNode().resolve(resolutionNode.resolvedTarget, f6);
                    constraintWidget8.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                    constraintWidget8.mListAnchors[i5].getResolutionNode().addResolvedValue(linearSystem);
                    margin3 = f6 + constraintWidget8.mListAnchors[i5].getMargin();
                }
                constraintWidget8 = constraintWidget10;
            }
            return true;
        }
        if (f3 < width) {
            return false;
        }
        if (z3) {
            float horizontalBiasPercent = margin3 + ((f3 - margin) * constraintWidget.getHorizontalBiasPercent());
            while (constraintWidget8 != null) {
                if (LinearSystem.sMetrics != null) {
                    LinearSystem.sMetrics.nonresolvedWidgets--;
                    LinearSystem.sMetrics.resolvedWidgets++;
                    LinearSystem.sMetrics.chainConnectionResolved++;
                }
                ConstraintWidget constraintWidget11 = constraintWidget8.mListNextVisibleWidget[i];
                if (constraintWidget11 != null || constraintWidget8 == constraintWidget7) {
                    float width2 = i == 0 ? constraintWidget8.getWidth() : constraintWidget8.getHeight();
                    float margin5 = horizontalBiasPercent + constraintWidget8.mListAnchors[i2].getMargin();
                    constraintWidget8.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin5);
                    float f7 = margin5 + width2;
                    constraintWidget8.mListAnchors[i5].getResolutionNode().resolve(resolutionNode.resolvedTarget, f7);
                    constraintWidget8.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                    constraintWidget8.mListAnchors[i5].getResolutionNode().addResolvedValue(linearSystem);
                    horizontalBiasPercent = f7 + constraintWidget8.mListAnchors[i5].getMargin();
                }
                constraintWidget8 = constraintWidget11;
            }
            return true;
        }
        if (!z && !z2) {
            return true;
        }
        if (z || z2) {
            f3 -= margin;
        }
        float f8 = f3 / (i3 + 1);
        if (z2) {
            f8 = f3 / (i3 > 1 ? i3 - 1 : 2.0f);
        }
        float margin6 = margin3 + f8;
        if (z2 && i3 > 1) {
            margin6 = constraintWidget8.mListAnchors[i2].getMargin() + margin3;
        }
        if (z && constraintWidget8 != null) {
            margin6 += constraintWidget8.mListAnchors[i2].getMargin();
        }
        while (constraintWidget8 != null) {
            if (LinearSystem.sMetrics != null) {
                LinearSystem.sMetrics.nonresolvedWidgets--;
                LinearSystem.sMetrics.resolvedWidgets++;
                LinearSystem.sMetrics.chainConnectionResolved++;
            }
            ConstraintWidget constraintWidget12 = constraintWidget8.mListNextVisibleWidget[i];
            if (constraintWidget12 != null || constraintWidget8 == constraintWidget7) {
                float width3 = i == 0 ? constraintWidget8.getWidth() : constraintWidget8.getHeight();
                constraintWidget8.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin6);
                constraintWidget8.mListAnchors[i5].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin6 + width3);
                constraintWidget8.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                constraintWidget8.mListAnchors[i5].getResolutionNode().addResolvedValue(linearSystem);
                margin6 += width3 + f8;
            }
            constraintWidget8 = constraintWidget12;
        }
        return true;
    }

    static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.mLeft.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
            constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
            constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, i);
            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, width);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.setHorizontalDimension(i, width);
        }
        if (constraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || constraintWidget.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        int i2 = constraintWidget.mTop.mMargin;
        int height = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
        constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
        constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
        linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, i2);
        linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, height);
        if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
            constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
            linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + i2);
        }
        constraintWidget.mVerticalResolution = 2;
        constraintWidget.setVerticalDimension(i2, height);
    }

    private static boolean optimizableMatchConstraint(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        if (constraintWidget.mDimensionRatio != 0.0f) {
            if (constraintWidget.mListDimensionBehaviors[i != 0 ? (char) 0 : (char) 1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            }
            return false;
        }
        if (i == 0) {
            if (constraintWidget.mMatchConstraintDefaultWidth != 0 || constraintWidget.mMatchConstraintMinWidth != 0 || constraintWidget.mMatchConstraintMaxWidth != 0) {
                return false;
            }
        } else if (constraintWidget.mMatchConstraintDefaultHeight != 0 || constraintWidget.mMatchConstraintMinHeight != 0 || constraintWidget.mMatchConstraintMaxHeight != 0) {
            return false;
        }
        return true;
    }
}
