package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintWidget;

/* loaded from: classes.dex */
class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        int i3;
        ConstraintWidget[] constraintWidgetArr;
        if (i == 0) {
            int i4 = constraintWidgetContainer.mHorizontalChainsSize;
            constraintWidgetArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = i4;
            i2 = 0;
        } else {
            i2 = 2;
            i3 = constraintWidgetContainer.mVerticalChainsSize;
            constraintWidgetArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            ConstraintWidget constraintWidget = constraintWidgetArr[i5];
            if (!constraintWidgetContainer.optimizeFor(4) || !Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i2, constraintWidget)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, constraintWidget);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005b A[PHI: r7 r8
  0x005b: PHI (r7v40 boolean) = (r7v2 boolean), (r7v43 boolean) binds: [B:47:0x007d, B:34:0x0059] A[DONT_GENERATE, DONT_INLINE]
  0x005b: PHI (r8v32 boolean) = (r8v2 boolean), (r8v35 boolean) binds: [B:47:0x007d, B:34:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d A[PHI: r7 r8
  0x005d: PHI (r7v4 boolean) = (r7v2 boolean), (r7v43 boolean) binds: [B:47:0x007d, B:34:0x0059] A[DONT_GENERATE, DONT_INLINE]
  0x005d: PHI (r8v4 boolean) = (r8v2 boolean), (r8v35 boolean) binds: [B:47:0x007d, B:34:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ConstraintWidget constraintWidget) {
        ConstraintWidget constraintWidget2;
        boolean z;
        boolean z2;
        boolean z3;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        int i3;
        int i4;
        ConstraintWidget constraintWidget5;
        ConstraintWidget constraintWidget6;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        ConstraintAnchor constraintAnchor2;
        ConstraintWidget constraintWidget7;
        ConstraintAnchor constraintAnchor3;
        ConstraintWidget constraintWidget8;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        ConstraintWidget constraintWidget9;
        ConstraintWidget constraintWidget10;
        ConstraintWidget constraintWidget11;
        ConstraintWidget constraintWidget12;
        SolverVariable solverVariable6;
        ConstraintWidget constraintWidget13;
        int i5;
        int i6;
        boolean z4;
        ConstraintWidget constraintWidget14;
        ConstraintWidget constraintWidget15;
        ConstraintWidget constraintWidget16;
        ConstraintWidget constraintWidget17;
        ConstraintWidget constraintWidget18;
        boolean z5 = constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        SolverVariable solverVariable7 = null;
        if (i == 0 && constraintWidgetContainer.isRtl()) {
            constraintWidget2 = constraintWidget;
            boolean z6 = false;
            while (!z6) {
                ConstraintAnchor constraintAnchor5 = constraintWidget2.mListAnchors[i2 + 1].mTarget;
                if (constraintAnchor5 != null) {
                    constraintWidget18 = constraintAnchor5.mOwner;
                    if (constraintWidget18.mListAnchors[i2].mTarget == null || constraintWidget18.mListAnchors[i2].mTarget.mOwner != constraintWidget2) {
                        constraintWidget18 = null;
                    }
                }
                if (constraintWidget18 != null) {
                    constraintWidget2 = constraintWidget18;
                } else {
                    z6 = true;
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
        boolean z7 = z3;
        float f = 0.0f;
        boolean z8 = z;
        boolean z9 = z2;
        ConstraintWidget constraintWidget19 = constraintWidget;
        ConstraintWidget constraintWidget20 = null;
        ConstraintWidget constraintWidget21 = null;
        ConstraintWidget constraintWidget22 = null;
        ConstraintWidget constraintWidget23 = null;
        boolean z10 = false;
        int i7 = 0;
        while (!z10) {
            constraintWidget19.mListNextVisibleWidget[i] = solverVariable7;
            if (constraintWidget19.getVisibility() != 8) {
                if (constraintWidget23 != null) {
                    constraintWidget23.mListNextVisibleWidget[i] = constraintWidget19;
                }
                if (constraintWidget22 == null) {
                    constraintWidget22 = constraintWidget19;
                }
                constraintWidget23 = constraintWidget19;
            }
            ConstraintAnchor constraintAnchor6 = constraintWidget19.mListAnchors[i2];
            int margin = constraintAnchor6.getMargin();
            if (constraintAnchor6.mTarget == null || constraintWidget19 == constraintWidget) {
                z4 = z10;
            } else {
                z4 = z10;
                if (constraintWidget19.getVisibility() != 8) {
                    margin += constraintAnchor6.mTarget.getMargin();
                }
            }
            int i8 = margin;
            int i9 = (!z7 || constraintWidget19 == constraintWidget || constraintWidget19 == constraintWidget22) ? 1 : 6;
            if (constraintWidget19 == constraintWidget22) {
                constraintWidget15 = constraintWidget22;
                constraintWidget16 = constraintWidget23;
                constraintWidget14 = constraintWidget2;
                linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i8, 5);
            } else {
                constraintWidget14 = constraintWidget2;
                constraintWidget15 = constraintWidget22;
                constraintWidget16 = constraintWidget23;
                linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i8, 6);
            }
            linearSystem.addEquality(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i8, i9);
            solverVariable7 = null;
            constraintWidget19.mListNextMatchConstraintsWidget[i] = null;
            if (constraintWidget19.getVisibility() != 8 && constraintWidget19.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                i7++;
                f += constraintWidget19.mWeight[i];
                if (constraintWidget21 == null) {
                    constraintWidget21 = constraintWidget19;
                } else {
                    constraintWidget20.mListNextMatchConstraintsWidget[i] = constraintWidget19;
                }
                if (z5) {
                    linearSystem.addGreaterThan(constraintWidget19.mListAnchors[i2 + 1].mSolverVariable, constraintWidget19.mListAnchors[i2].mSolverVariable, 0, 6);
                }
                constraintWidget20 = constraintWidget19;
            }
            if (z5) {
                linearSystem.addGreaterThan(constraintWidget19.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, 0, 6);
            }
            ConstraintAnchor constraintAnchor7 = constraintWidget19.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor7 != null) {
                constraintWidget17 = constraintAnchor7.mOwner;
                if (constraintWidget17.mListAnchors[i2].mTarget == null || constraintWidget17.mListAnchors[i2].mTarget.mOwner != constraintWidget19) {
                    constraintWidget17 = null;
                }
            }
            if (constraintWidget17 != null) {
                constraintWidget19 = constraintWidget17;
                z10 = z4;
            } else {
                z10 = true;
            }
            constraintWidget22 = constraintWidget15;
            constraintWidget23 = constraintWidget16;
            constraintWidget2 = constraintWidget14;
        }
        ConstraintWidget constraintWidget24 = constraintWidget2;
        if (constraintWidget23 != null) {
            int i10 = i2 + 1;
            if (constraintWidget19.mListAnchors[i10].mTarget != null) {
                ConstraintAnchor constraintAnchor8 = constraintWidget23.mListAnchors[i10];
                linearSystem.addLowerThan(constraintAnchor8.mSolverVariable, constraintWidget19.mListAnchors[i10].mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 5);
            }
        }
        if (z5) {
            int i11 = i2 + 1;
            linearSystem.addGreaterThan(constraintWidgetContainer.mListAnchors[i11].mSolverVariable, constraintWidget19.mListAnchors[i11].mSolverVariable, constraintWidget19.mListAnchors[i11].getMargin(), 6);
        }
        if (i7 > 0) {
            while (constraintWidget21 != null) {
                ConstraintWidget constraintWidget25 = constraintWidget21.mListNextMatchConstraintsWidget[i];
                if (constraintWidget25 != null) {
                    float f2 = constraintWidget21.mWeight[i];
                    float f3 = constraintWidget25.mWeight[i];
                    SolverVariable solverVariable8 = constraintWidget21.mListAnchors[i2].mSolverVariable;
                    int i12 = i2 + 1;
                    SolverVariable solverVariable9 = constraintWidget21.mListAnchors[i12].mSolverVariable;
                    SolverVariable solverVariable10 = constraintWidget25.mListAnchors[i2].mSolverVariable;
                    SolverVariable solverVariable11 = constraintWidget25.mListAnchors[i12].mSolverVariable;
                    if (i == 0) {
                        i5 = constraintWidget21.mMatchConstraintDefaultWidth;
                        i6 = constraintWidget25.mMatchConstraintDefaultWidth;
                    } else {
                        i5 = constraintWidget21.mMatchConstraintDefaultHeight;
                        i6 = constraintWidget25.mMatchConstraintDefaultHeight;
                    }
                    if ((i5 == 0 || i5 == 3) && (i6 == 0 || i6 == 3)) {
                        ArrayRow arrayRowCreateRow = linearSystem.createRow();
                        arrayRowCreateRow.createRowEqualMatchDimensions(f2, f, f3, solverVariable8, solverVariable9, solverVariable10, solverVariable11);
                        linearSystem.addConstraint(arrayRowCreateRow);
                    }
                }
                constraintWidget21 = constraintWidget25;
            }
        }
        if (constraintWidget22 != null && (constraintWidget22 == constraintWidget23 || z7)) {
            ConstraintAnchor constraintAnchor9 = constraintWidget.mListAnchors[i2];
            int i13 = i2 + 1;
            ConstraintAnchor constraintAnchor10 = constraintWidget19.mListAnchors[i13];
            SolverVariable solverVariable12 = constraintWidget.mListAnchors[i2].mTarget != null ? constraintWidget.mListAnchors[i2].mTarget.mSolverVariable : solverVariable7;
            SolverVariable solverVariable13 = constraintWidget19.mListAnchors[i13].mTarget != null ? constraintWidget19.mListAnchors[i13].mTarget.mSolverVariable : solverVariable7;
            if (constraintWidget22 == constraintWidget23) {
                constraintAnchor9 = constraintWidget22.mListAnchors[i2];
                constraintAnchor10 = constraintWidget22.mListAnchors[i13];
            }
            if (solverVariable12 == null || solverVariable13 == null) {
                constraintWidget13 = constraintWidget22;
            } else {
                float f4 = i == 0 ? constraintWidget24.mHorizontalBiasPercent : constraintWidget24.mVerticalBiasPercent;
                int margin2 = constraintAnchor9.getMargin();
                if (constraintWidget23 == null) {
                    constraintWidget23 = constraintWidget19;
                }
                constraintWidget13 = constraintWidget22;
                linearSystem.addCentering(constraintAnchor9.mSolverVariable, solverVariable12, margin2, f4, solverVariable13, constraintAnchor10.mSolverVariable, constraintWidget23.mListAnchors[i13].getMargin(), 5);
            }
            constraintWidget3 = constraintWidget13;
        } else {
            if (!z8 || constraintWidget22 == null) {
                constraintWidget3 = constraintWidget22;
                if (z9 && constraintWidget3 != null) {
                    ConstraintWidget constraintWidget26 = constraintWidget3;
                    ConstraintWidget constraintWidget27 = constraintWidget26;
                    while (constraintWidget27 != null) {
                        ConstraintWidget constraintWidget28 = constraintWidget27.mListNextVisibleWidget[i];
                        if (constraintWidget27 == constraintWidget3 || constraintWidget27 == constraintWidget23 || constraintWidget28 == null) {
                            constraintWidget5 = constraintWidget27;
                            constraintWidget27 = constraintWidget28;
                        } else {
                            ConstraintWidget constraintWidget29 = constraintWidget28 == constraintWidget23 ? null : constraintWidget28;
                            ConstraintAnchor constraintAnchor11 = constraintWidget27.mListAnchors[i2];
                            SolverVariable solverVariable14 = constraintAnchor11.mSolverVariable;
                            if (constraintAnchor11.mTarget != null) {
                                SolverVariable solverVariable15 = constraintAnchor11.mTarget.mSolverVariable;
                            }
                            int i14 = i2 + 1;
                            SolverVariable solverVariable16 = constraintWidget26.mListAnchors[i14].mSolverVariable;
                            int margin3 = constraintAnchor11.getMargin();
                            int margin4 = constraintWidget27.mListAnchors[i14].getMargin();
                            if (constraintWidget29 != null) {
                                constraintAnchor2 = constraintWidget29.mListAnchors[i2];
                                constraintWidget6 = constraintWidget29;
                                solverVariable2 = constraintAnchor2.mSolverVariable;
                                solverVariable3 = constraintAnchor2.mTarget != null ? constraintAnchor2.mTarget.mSolverVariable : null;
                            } else {
                                constraintWidget6 = constraintWidget29;
                                ConstraintAnchor constraintAnchor12 = constraintWidget27.mListAnchors[i14].mTarget;
                                if (constraintAnchor12 != null) {
                                    solverVariable = constraintAnchor12.mSolverVariable;
                                    constraintAnchor = constraintAnchor12;
                                } else {
                                    constraintAnchor = constraintAnchor12;
                                    solverVariable = null;
                                }
                                solverVariable2 = solverVariable;
                                solverVariable3 = constraintWidget27.mListAnchors[i14].mSolverVariable;
                                constraintAnchor2 = constraintAnchor;
                            }
                            if (constraintAnchor2 != null) {
                                margin4 += constraintAnchor2.getMargin();
                            }
                            int i15 = margin4;
                            if (constraintWidget26 != null) {
                                margin3 += constraintWidget26.mListAnchors[i14].getMargin();
                            }
                            int i16 = margin3;
                            if (solverVariable14 == null || solverVariable16 == null || solverVariable2 == null || solverVariable3 == null) {
                                constraintWidget5 = constraintWidget27;
                                constraintWidget7 = constraintWidget6;
                            } else {
                                constraintWidget7 = constraintWidget6;
                                constraintWidget5 = constraintWidget27;
                                linearSystem.addCentering(solverVariable14, solverVariable16, i16, 0.5f, solverVariable2, solverVariable3, i15, 4);
                            }
                            constraintWidget27 = constraintWidget7;
                        }
                        constraintWidget26 = constraintWidget5;
                    }
                    ConstraintAnchor constraintAnchor13 = constraintWidget3.mListAnchors[i2];
                    ConstraintAnchor constraintAnchor14 = constraintWidget.mListAnchors[i2].mTarget;
                    int i17 = i2 + 1;
                    ConstraintAnchor constraintAnchor15 = constraintWidget23.mListAnchors[i17];
                    ConstraintAnchor constraintAnchor16 = constraintWidget19.mListAnchors[i17].mTarget;
                    if (constraintAnchor14 != null) {
                        if (constraintWidget3 != constraintWidget23) {
                            i4 = 5;
                            linearSystem.addEquality(constraintAnchor13.mSolverVariable, constraintAnchor14.mSolverVariable, constraintAnchor13.getMargin(), 5);
                        } else {
                            i4 = 5;
                            if (constraintAnchor16 != null) {
                                constraintWidget4 = constraintWidget19;
                                i3 = 5;
                                linearSystem.addCentering(constraintAnchor13.mSolverVariable, constraintAnchor14.mSolverVariable, constraintAnchor13.getMargin(), 0.5f, constraintAnchor15.mSolverVariable, constraintAnchor16.mSolverVariable, constraintAnchor15.getMargin(), 5);
                            }
                        }
                        constraintWidget4 = constraintWidget19;
                        i3 = i4;
                    } else {
                        constraintWidget4 = constraintWidget19;
                        i3 = 5;
                    }
                    if (constraintAnchor16 != null && constraintWidget3 != constraintWidget23) {
                        linearSystem.addEquality(constraintAnchor15.mSolverVariable, constraintAnchor16.mSolverVariable, -constraintAnchor15.getMargin(), i3);
                    }
                }
                constraintWidget12 = constraintWidget23;
                if ((!z8 || z9) && constraintWidget3 != null) {
                    ConstraintAnchor constraintAnchor17 = constraintWidget3.mListAnchors[i2];
                    int i18 = i2 + 1;
                    ConstraintAnchor constraintAnchor18 = constraintWidget12.mListAnchors[i18];
                    solverVariable6 = constraintAnchor17.mTarget == null ? constraintAnchor17.mTarget.mSolverVariable : null;
                    SolverVariable solverVariable17 = constraintAnchor18.mTarget == null ? constraintAnchor18.mTarget.mSolverVariable : null;
                    if (constraintWidget3 == constraintWidget12) {
                        constraintAnchor17 = constraintWidget3.mListAnchors[i2];
                        constraintAnchor18 = constraintWidget3.mListAnchors[i18];
                    }
                    if (solverVariable6 != null || solverVariable17 == null) {
                    }
                    int margin5 = constraintAnchor17.getMargin();
                    if (constraintWidget12 == null) {
                        constraintWidget12 = constraintWidget4;
                    }
                    linearSystem.addCentering(constraintAnchor17.mSolverVariable, solverVariable6, margin5, 0.5f, solverVariable17, constraintAnchor18.mSolverVariable, constraintWidget12.mListAnchors[i18].getMargin(), 5);
                    return;
                }
                return;
            }
            ConstraintWidget constraintWidget30 = constraintWidget22;
            ConstraintWidget constraintWidget31 = constraintWidget30;
            while (constraintWidget31 != null) {
                ConstraintWidget constraintWidget32 = constraintWidget31.mListNextVisibleWidget[i];
                if (constraintWidget32 != null || constraintWidget31 == constraintWidget23) {
                    ConstraintAnchor constraintAnchor19 = constraintWidget31.mListAnchors[i2];
                    SolverVariable solverVariable18 = constraintAnchor19.mSolverVariable;
                    SolverVariable solverVariable19 = constraintAnchor19.mTarget != null ? constraintAnchor19.mTarget.mSolverVariable : solverVariable7;
                    if (constraintWidget30 != constraintWidget31) {
                        constraintAnchor3 = constraintWidget30.mListAnchors[i2 + 1];
                    } else {
                        if (constraintWidget31 == constraintWidget22 && constraintWidget30 == constraintWidget31) {
                            if (constraintWidget.mListAnchors[i2].mTarget != null) {
                                constraintAnchor3 = constraintWidget.mListAnchors[i2].mTarget;
                            } else {
                                solverVariable19 = solverVariable7;
                            }
                        }
                        int margin6 = constraintAnchor19.getMargin();
                        int i19 = i2 + 1;
                        int margin7 = constraintWidget31.mListAnchors[i19].getMargin();
                        if (constraintWidget32 == null) {
                            constraintAnchor4 = constraintWidget32.mListAnchors[i2];
                            constraintWidget8 = constraintWidget32;
                            solverVariable5 = constraintAnchor4.mSolverVariable;
                            solverVariable4 = constraintAnchor4.mTarget != null ? constraintAnchor4.mTarget.mSolverVariable : null;
                        } else {
                            constraintWidget8 = constraintWidget32;
                            constraintAnchor4 = constraintWidget19.mListAnchors[i19].mTarget;
                            SolverVariable solverVariable20 = constraintAnchor4 != null ? constraintAnchor4.mSolverVariable : null;
                            solverVariable4 = constraintWidget31.mListAnchors[i19].mSolverVariable;
                            solverVariable5 = solverVariable20;
                        }
                        if (constraintAnchor4 != null) {
                            margin7 += constraintAnchor4.getMargin();
                        }
                        if (constraintWidget30 != null) {
                            margin6 += constraintWidget30.mListAnchors[i19].getMargin();
                        }
                        if (solverVariable18 != null || solverVariable19 == null || solverVariable5 == null || solverVariable4 == null) {
                            constraintWidget9 = constraintWidget31;
                            constraintWidget10 = constraintWidget22;
                            constraintWidget11 = constraintWidget8;
                        } else {
                            constraintWidget9 = constraintWidget31;
                            constraintWidget11 = constraintWidget8;
                            constraintWidget10 = constraintWidget22;
                            linearSystem.addCentering(solverVariable18, solverVariable19, constraintWidget31 == constraintWidget22 ? constraintWidget22.mListAnchors[i2].getMargin() : margin6, 0.5f, solverVariable5, solverVariable4, constraintWidget31 == constraintWidget23 ? constraintWidget23.mListAnchors[i19].getMargin() : margin7, 4);
                        }
                    }
                    solverVariable19 = constraintAnchor3.mSolverVariable;
                    int margin62 = constraintAnchor19.getMargin();
                    int i192 = i2 + 1;
                    int margin72 = constraintWidget31.mListAnchors[i192].getMargin();
                    if (constraintWidget32 == null) {
                    }
                    if (constraintAnchor4 != null) {
                    }
                    if (constraintWidget30 != null) {
                    }
                    if (solverVariable18 != null) {
                        constraintWidget9 = constraintWidget31;
                        constraintWidget10 = constraintWidget22;
                        constraintWidget11 = constraintWidget8;
                    }
                } else {
                    constraintWidget11 = constraintWidget32;
                    constraintWidget9 = constraintWidget31;
                    constraintWidget10 = constraintWidget22;
                }
                constraintWidget22 = constraintWidget10;
                constraintWidget30 = constraintWidget9;
                constraintWidget31 = constraintWidget11;
                solverVariable7 = null;
            }
            constraintWidget3 = constraintWidget22;
        }
        constraintWidget4 = constraintWidget19;
        constraintWidget12 = constraintWidget23;
        if (z8) {
        }
        ConstraintAnchor constraintAnchor172 = constraintWidget3.mListAnchors[i2];
        int i182 = i2 + 1;
        ConstraintAnchor constraintAnchor182 = constraintWidget12.mListAnchors[i182];
        if (constraintAnchor172.mTarget == null) {
        }
        if (constraintAnchor182.mTarget == null) {
        }
        if (constraintWidget3 == constraintWidget12) {
        }
        if (solverVariable6 != null) {
        }
    }
}
