package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Barrier extends Helper {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private int mBarrierType = 0;
    private ArrayList<ResolutionAnchor> mNodes = new ArrayList<>(4);
    private boolean mAllowsGoneWidget = true;

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        boolean z;
        SolverVariable solverVariable;
        ConstraintAnchor constraintAnchor;
        this.mListAnchors[0] = this.mLeft;
        this.mListAnchors[2] = this.mTop;
        this.mListAnchors[1] = this.mRight;
        this.mListAnchors[3] = this.mBottom;
        for (int i = 0; i < this.mListAnchors.length; i++) {
            this.mListAnchors[i].mSolverVariable = linearSystem.createObjectVariable(this.mListAnchors[i]);
        }
        if (this.mBarrierType < 0 || this.mBarrierType >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor2 = this.mListAnchors[this.mBarrierType];
        for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
            ConstraintWidget constraintWidget = this.mWidgets[i2];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && (((this.mBarrierType == 0 || this.mBarrierType == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || ((this.mBarrierType == 2 || this.mBarrierType == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))) {
                z = true;
                break;
            }
        }
        z = false;
        if (this.mBarrierType == 0 || this.mBarrierType == 1 ? getParent().getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : getParent().getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            z = false;
        }
        for (int i3 = 0; i3 < this.mWidgetsCount; i3++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i3];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                constraintWidget2.mListAnchors[this.mBarrierType].mSolverVariable = solverVariableCreateObjectVariable;
                if (this.mBarrierType == 0 || this.mBarrierType == 2) {
                    linearSystem.addLowerBarrier(constraintAnchor2.mSolverVariable, solverVariableCreateObjectVariable, z);
                } else {
                    linearSystem.addGreaterBarrier(constraintAnchor2.mSolverVariable, solverVariableCreateObjectVariable, z);
                }
            }
        }
        if (this.mBarrierType == 0) {
            linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 6);
            if (z) {
                return;
            }
            solverVariable = this.mLeft.mSolverVariable;
            constraintAnchor = this.mParent.mRight;
        } else if (this.mBarrierType == 1) {
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 6);
            if (z) {
                return;
            }
            solverVariable = this.mLeft.mSolverVariable;
            constraintAnchor = this.mParent.mLeft;
        } else if (this.mBarrierType == 2) {
            linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 6);
            if (z) {
                return;
            }
            solverVariable = this.mTop.mSolverVariable;
            constraintAnchor = this.mParent.mBottom;
        } else {
            if (this.mBarrierType != 3) {
                return;
            }
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 6);
            if (z) {
                return;
            }
            solverVariable = this.mTop.mSolverVariable;
            constraintAnchor = this.mParent.mTop;
        }
        linearSystem.addEquality(solverVariable, constraintAnchor.mSolverVariable, 0, 5);
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void analyze(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ResolutionAnchor resolutionNode;
        if (this.mParent != null && ((ConstraintWidgetContainer) this.mParent).optimizeFor(2)) {
            switch (this.mBarrierType) {
                case 0:
                    constraintAnchor = this.mLeft;
                    break;
                case 1:
                    constraintAnchor = this.mRight;
                    break;
                case 2:
                    constraintAnchor = this.mTop;
                    break;
                case 3:
                    constraintAnchor = this.mBottom;
                    break;
                default:
                    return;
            }
            ResolutionAnchor resolutionNode2 = constraintAnchor.getResolutionNode();
            resolutionNode2.setType(5);
            if (this.mBarrierType == 0 || this.mBarrierType == 1) {
                this.mTop.getResolutionNode().resolve(null, 0.0f);
                constraintAnchor2 = this.mBottom;
            } else {
                this.mLeft.getResolutionNode().resolve(null, 0.0f);
                constraintAnchor2 = this.mRight;
            }
            constraintAnchor2.getResolutionNode().resolve(null, 0.0f);
            this.mNodes.clear();
            for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
                ConstraintWidget constraintWidget = this.mWidgets[i2];
                if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                    switch (this.mBarrierType) {
                        case 0:
                            constraintAnchor3 = constraintWidget.mLeft;
                            resolutionNode = constraintAnchor3.getResolutionNode();
                            break;
                        case 1:
                            constraintAnchor3 = constraintWidget.mRight;
                            resolutionNode = constraintAnchor3.getResolutionNode();
                            break;
                        case 2:
                            constraintAnchor3 = constraintWidget.mTop;
                            resolutionNode = constraintAnchor3.getResolutionNode();
                            break;
                        case 3:
                            constraintAnchor3 = constraintWidget.mBottom;
                            resolutionNode = constraintAnchor3.getResolutionNode();
                            break;
                        default:
                            resolutionNode = null;
                            break;
                    }
                    if (resolutionNode != null) {
                        this.mNodes.add(resolutionNode);
                        resolutionNode.addDependent(resolutionNode2);
                    }
                }
            }
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void resetResolutionNodes() {
        super.resetResolutionNodes();
        this.mNodes.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void resolve() {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ResolutionAnchor resolutionNode;
        int size;
        int i;
        ConstraintAnchor constraintAnchor3;
        float f = Float.MAX_VALUE;
        switch (this.mBarrierType) {
            case 0:
                constraintAnchor = this.mLeft;
                resolutionNode = constraintAnchor.getResolutionNode();
                size = this.mNodes.size();
                ResolutionAnchor resolutionAnchor = null;
                for (i = 0; i < size; i++) {
                    ResolutionAnchor resolutionAnchor2 = this.mNodes.get(i);
                    if (resolutionAnchor2.state != 1) {
                        break;
                    } else {
                        if (this.mBarrierType == 0 || this.mBarrierType == 2) {
                            if (resolutionAnchor2.resolvedOffset < f) {
                                f = resolutionAnchor2.resolvedOffset;
                                resolutionAnchor = resolutionAnchor2.resolvedTarget;
                            }
                        } else if (resolutionAnchor2.resolvedOffset > f) {
                        }
                    }
                }
                if (LinearSystem.getMetrics() != null) {
                    LinearSystem.getMetrics().barrierConnectionResolved++;
                }
                resolutionNode.resolvedTarget = resolutionAnchor;
                resolutionNode.resolvedOffset = f;
                resolutionNode.didResolve();
                switch (this.mBarrierType) {
                    case 0:
                        constraintAnchor3 = this.mRight;
                        break;
                    case 1:
                        constraintAnchor3 = this.mLeft;
                        break;
                    case 2:
                        constraintAnchor3 = this.mBottom;
                        break;
                    case 3:
                        constraintAnchor3 = this.mTop;
                        break;
                }
                constraintAnchor3.getResolutionNode().resolve(resolutionAnchor, f);
                break;
            case 1:
                constraintAnchor2 = this.mRight;
                resolutionNode = constraintAnchor2.getResolutionNode();
                f = 0.0f;
                size = this.mNodes.size();
                ResolutionAnchor resolutionAnchor3 = null;
                while (i < size) {
                }
                if (LinearSystem.getMetrics() != null) {
                }
                resolutionNode.resolvedTarget = resolutionAnchor3;
                resolutionNode.resolvedOffset = f;
                resolutionNode.didResolve();
                switch (this.mBarrierType) {
                }
                constraintAnchor3.getResolutionNode().resolve(resolutionAnchor3, f);
                break;
            case 2:
                constraintAnchor = this.mTop;
                resolutionNode = constraintAnchor.getResolutionNode();
                size = this.mNodes.size();
                ResolutionAnchor resolutionAnchor32 = null;
                while (i < size) {
                }
                if (LinearSystem.getMetrics() != null) {
                }
                resolutionNode.resolvedTarget = resolutionAnchor32;
                resolutionNode.resolvedOffset = f;
                resolutionNode.didResolve();
                switch (this.mBarrierType) {
                }
                constraintAnchor3.getResolutionNode().resolve(resolutionAnchor32, f);
                break;
            case 3:
                constraintAnchor2 = this.mBottom;
                resolutionNode = constraintAnchor2.getResolutionNode();
                f = 0.0f;
                size = this.mNodes.size();
                ResolutionAnchor resolutionAnchor322 = null;
                while (i < size) {
                }
                if (LinearSystem.getMetrics() != null) {
                }
                resolutionNode.resolvedTarget = resolutionAnchor322;
                resolutionNode.resolvedOffset = f;
                resolutionNode.didResolve();
                switch (this.mBarrierType) {
                }
                constraintAnchor3.getResolutionNode().resolve(resolutionAnchor322, f);
                break;
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mAllowsGoneWidget = z;
    }

    public void setBarrierType(int i) {
        this.mBarrierType = i;
    }
}
