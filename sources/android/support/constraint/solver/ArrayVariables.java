package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ArrayVariables {
    private static final boolean DEBUG = false;
    private final Cache mCache;
    private final ArrayRow mRow;
    int currentSize = 0;
    private int ROW_SIZE = 8;
    private int[] mArrayIndices = new int[this.ROW_SIZE];
    private float[] mArrayValues = new float[this.ROW_SIZE];
    private boolean[] mArrayValid = new boolean[this.ROW_SIZE];

    ArrayVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.mClientEquationsCount <= 1;
    }

    final void add(SolverVariable solverVariable, float f, boolean z) {
        if (f == 0.0f) {
            return;
        }
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                float[] fArr = this.mArrayValues;
                fArr[i] = fArr[i] + f;
                return;
            }
        }
        if (this.currentSize >= this.mArrayIndices.length) {
            this.ROW_SIZE *= 2;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayValid = Arrays.copyOf(this.mArrayValid, this.ROW_SIZE);
        }
        this.mArrayIndices[this.currentSize] = solverVariable.id;
        float[] fArr2 = this.mArrayValues;
        int i2 = this.currentSize;
        fArr2[i2] = fArr2[i2] + f;
        this.mArrayValid[this.currentSize] = true;
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        if (this.mArrayValues[this.currentSize] == 0.0f) {
            solverVariable.usageInRowCount--;
            solverVariable.removeFromRow(this.mRow);
            this.mArrayValid[this.currentSize] = false;
        }
        this.currentSize++;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0094 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    SolverVariable chooseSubject(LinearSystem linearSystem) {
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        boolean zIsNew = false;
        boolean zIsNew2 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayValid[i]) {
                float f3 = this.mArrayValues[i];
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if (f3 < 0.0f) {
                    if (f3 > -0.001f) {
                        this.mArrayValues[i] = 0.0f;
                        this.mArrayValid[i] = false;
                        solverVariable3.removeFromRow(this.mRow);
                        f3 = 0.0f;
                    }
                    if (f3 != 0.0f) {
                        if (solverVariable3.mType == SolverVariable.Type.UNRESTRICTED) {
                            if (solverVariable == null || f > f3) {
                                zIsNew = isNew(solverVariable3, linearSystem);
                                f = f3;
                            } else if (!zIsNew && isNew(solverVariable3, linearSystem)) {
                                f = f3;
                                zIsNew = true;
                            }
                            solverVariable = solverVariable3;
                        } else if (solverVariable == null && f3 < 0.0f) {
                            if (solverVariable2 == null || f2 > f3) {
                                zIsNew2 = isNew(solverVariable3, linearSystem);
                                f2 = f3;
                            } else if (!zIsNew2 && isNew(solverVariable3, linearSystem)) {
                                f2 = f3;
                                zIsNew2 = true;
                            }
                            solverVariable2 = solverVariable3;
                        }
                    }
                } else {
                    if (f3 < 0.001f) {
                        this.mArrayValues[i] = 0.0f;
                        this.mArrayValid[i] = false;
                        solverVariable3.removeFromRow(this.mRow);
                        f3 = 0.0f;
                    }
                    if (f3 != 0.0f) {
                    }
                }
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    public final void clear() {
        for (int i = 0; i < this.currentSize; i++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
        }
        this.currentSize = 0;
    }

    final boolean containsKey(SolverVariable solverVariable) {
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayValid[i] && this.mArrayIndices[i] == solverVariable.id) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        SolverVariable variable;
        int i = this.currentSize;
        System.out.print("{ ");
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mArrayValid[i2] && (variable = getVariable(i2)) != null) {
                System.out.print(variable + " = " + getVariableValue(i2) + " ");
            }
        }
        System.out.println(" }");
    }

    void divideByAmount(float f) {
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayValid[i]) {
                float[] fArr = this.mArrayValues;
                fArr[i] = fArr[i] / f;
            }
        }
    }

    public final float get(SolverVariable solverVariable) {
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayValid[i] && this.mArrayIndices[i] == solverVariable.id) {
                return this.mArrayValues[i];
            }
        }
        return 0.0f;
    }

    SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = null;
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayValid[i] && this.mArrayValues[i] < 0.0f) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if (solverVariable == null || solverVariable.strength < solverVariable2.strength) {
                    solverVariable = solverVariable2;
                }
            }
        }
        return solverVariable;
    }

    SolverVariable getPivotCandidate(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayValid[i] && this.mArrayValues[i] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if ((zArr == null || !zArr[solverVariable3.id]) && solverVariable3 != solverVariable && (solverVariable3.mType == SolverVariable.Type.SLACK || solverVariable3.mType == SolverVariable.Type.ERROR)) {
                    float f2 = this.mArrayValues[i];
                    if (f2 < f) {
                        solverVariable2 = solverVariable3;
                        f = f2;
                    }
                }
            }
        }
        return solverVariable2;
    }

    final SolverVariable getVariable(int i) {
        if (i < this.currentSize) {
            return this.mCache.mIndexedVariables[this.mArrayIndices[i]];
        }
        return null;
    }

    final float getVariableValue(int i) {
        if (i < this.currentSize) {
            return this.mArrayValues[i];
        }
        return 0.0f;
    }

    boolean hasAtLeastOnePositiveVariable() {
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayValid[i] && this.mArrayValues[i] > 0.0f) {
                return true;
            }
        }
        return false;
    }

    void invert() {
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayValid[i]) {
                float[] fArr = this.mArrayValues;
                fArr[i] = fArr[i] * (-1.0f);
            }
        }
    }

    public final void put(SolverVariable solverVariable, float f) {
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                this.mArrayValues[i] = f;
                if (f == 0.0f) {
                    this.mArrayValid[i] = false;
                    solverVariable.removeFromRow(this.mRow);
                    return;
                }
                return;
            }
        }
        if (this.currentSize >= this.mArrayIndices.length) {
            this.ROW_SIZE *= 2;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayValid = Arrays.copyOf(this.mArrayValid, this.ROW_SIZE);
        }
        this.mArrayIndices[this.currentSize] = solverVariable.id;
        this.mArrayValues[this.currentSize] = f;
        this.mArrayValid[this.currentSize] = true;
        if (f == 0.0f) {
            solverVariable.removeFromRow(this.mRow);
            this.mArrayValid[this.currentSize] = false;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        this.currentSize++;
    }

    public final float remove(SolverVariable solverVariable, boolean z) {
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                float f = this.mArrayValues[i];
                this.mArrayValues[i] = 0.0f;
                this.mArrayValid[i] = false;
                if (z) {
                    solverVariable.usageInRowCount--;
                    solverVariable.removeFromRow(this.mRow);
                }
                return f;
            }
        }
        return 0.0f;
    }

    int sizeInBytes() {
        return 0 + (3 * this.mArrayIndices.length * 4) + 36;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayValid[i] && this.mArrayValues[i] != 0.0f) {
                str = ((str + " -> ") + this.mArrayValues[i] + " : ") + this.mCache.mIndexedVariables[this.mArrayIndices[i]];
            }
        }
        return str;
    }

    final void updateFromRow(ArrayRow arrayRow, ArrayRow arrayRow2, boolean z) {
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayValid[i] && this.mArrayIndices[i] == arrayRow2.variable.id) {
                float f = this.mArrayValues[i];
                if (f != 0.0f) {
                    this.mArrayValues[i] = 0.0f;
                    this.mArrayValid[i] = false;
                    if (z) {
                        arrayRow2.variable.removeFromRow(this.mRow);
                    }
                    ArrayVariables arrayVariables = (ArrayVariables) arrayRow2.variables;
                    for (int i2 = 0; i2 < arrayVariables.currentSize; i2++) {
                        add(this.mCache.mIndexedVariables[arrayVariables.mArrayIndices[i2]], arrayVariables.mArrayValues[i2] * f, z);
                    }
                    arrayRow.constantValue += arrayRow2.constantValue * f;
                    if (z) {
                        arrayRow2.variable.removeFromRow(arrayRow);
                    }
                }
            }
        }
    }

    void updateFromSystem(ArrayRow arrayRow, ArrayRow[] arrayRowArr) {
        for (int i = 0; i < this.currentSize; i++) {
            if (this.mArrayValid[i]) {
                SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if (solverVariable.definitionId != -1) {
                    float f = this.mArrayValues[i];
                    this.mArrayValues[i] = 0.0f;
                    this.mArrayValid[i] = false;
                    solverVariable.removeFromRow(this.mRow);
                    ArrayRow arrayRow2 = arrayRowArr[solverVariable.definitionId];
                    if (!arrayRow2.isSimpleDefinition) {
                        ArrayVariables arrayVariables = (ArrayVariables) arrayRow2.variables;
                        for (int i2 = 0; i2 < arrayVariables.currentSize; i2++) {
                            add(this.mCache.mIndexedVariables[arrayVariables.mArrayIndices[i2]], arrayVariables.mArrayValues[i2] * f, true);
                        }
                    }
                    arrayRow.constantValue += arrayRow2.constantValue * f;
                    arrayRow2.variable.removeFromRow(arrayRow);
                }
            }
        }
    }
}
