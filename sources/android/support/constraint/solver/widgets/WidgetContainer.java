package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.v7.widget.ActivityChooserView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class WidgetContainer extends ConstraintWidget {
    protected ArrayList<ConstraintWidget> mChildren;

    public WidgetContainer() {
        this.mChildren = new ArrayList<>();
    }

    public WidgetContainer(int i, int i2) {
        super(i, i2);
        this.mChildren = new ArrayList<>();
    }

    public WidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mChildren = new ArrayList<>();
    }

    public static Rectangle getBounds(ArrayList<ConstraintWidget> arrayList) {
        Rectangle rectangle = new Rectangle();
        if (arrayList.size() == 0) {
            return rectangle;
        }
        int size = arrayList.size();
        int x = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int y = Integer.MAX_VALUE;
        int right = 0;
        int bottom = 0;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = arrayList.get(i);
            if (constraintWidget.getX() < x) {
                x = constraintWidget.getX();
            }
            if (constraintWidget.getY() < y) {
                y = constraintWidget.getY();
            }
            if (constraintWidget.getRight() > right) {
                right = constraintWidget.getRight();
            }
            if (constraintWidget.getBottom() > bottom) {
                bottom = constraintWidget.getBottom();
            }
        }
        rectangle.setBounds(x, y, right - x, bottom - y);
        return rectangle;
    }

    public void add(ConstraintWidget constraintWidget) {
        this.mChildren.add(constraintWidget);
        if (constraintWidget.getParent() != null) {
            ((WidgetContainer) constraintWidget.getParent()).remove(constraintWidget);
        }
        constraintWidget.setParent(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006d A[PHI: r3
  0x006d: PHI (r3v5 android.support.constraint.solver.widgets.WidgetContainer) = 
  (r3v8 android.support.constraint.solver.widgets.WidgetContainer)
  (r3v9 android.support.constraint.solver.widgets.WidgetContainer)
 binds: [B:26:0x006b, B:17:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.support.constraint.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.support.constraint.solver.widgets.ConstraintWidget] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConstraintWidget findWidget(float f, float f2) {
        WidgetContainer widgetContainer;
        int drawX = getDrawX();
        int drawY = getDrawY();
        WidgetContainer widgetContainer2 = (f < ((float) drawX) || f > ((float) (getWidth() + drawX)) || f2 < ((float) drawY) || f2 > ((float) (getHeight() + drawY))) ? null : this;
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof WidgetContainer) {
                ?? FindWidget = ((WidgetContainer) constraintWidget).findWidget(f, f2);
                widgetContainer = FindWidget;
                if (FindWidget != 0) {
                    widgetContainer2 = widgetContainer;
                }
            } else {
                int drawX2 = constraintWidget.getDrawX();
                int drawY2 = constraintWidget.getDrawY();
                int width = constraintWidget.getWidth() + drawX2;
                int height = constraintWidget.getHeight() + drawY2;
                if (f >= drawX2 && f <= width && f2 >= drawY2) {
                    widgetContainer = constraintWidget;
                    if (f2 <= height) {
                    }
                }
            }
        }
        return widgetContainer2;
    }

    public ArrayList<ConstraintWidget> findWidgets(int i, int i2, int i3, int i4) {
        ArrayList<ConstraintWidget> arrayList = new ArrayList<>();
        Rectangle rectangle = new Rectangle();
        rectangle.setBounds(i, i2, i3, i4);
        int size = this.mChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i5);
            Rectangle rectangle2 = new Rectangle();
            rectangle2.setBounds(constraintWidget.getDrawX(), constraintWidget.getDrawY(), constraintWidget.getWidth(), constraintWidget.getHeight());
            if (rectangle.intersects(rectangle2)) {
                arrayList.add(constraintWidget);
            }
        }
        return arrayList;
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidget parent = getParent();
        ConstraintWidgetContainer constraintWidgetContainer = this instanceof ConstraintWidgetContainer ? (ConstraintWidgetContainer) this : null;
        while (parent != null) {
            ConstraintWidget parent2 = parent.getParent();
            if (parent instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) parent;
            }
            parent = parent2;
        }
        return constraintWidgetContainer;
    }

    public void layout() {
        updateDrawPosition();
        if (this.mChildren == null) {
            return;
        }
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget).layout();
            }
        }
    }

    public void remove(ConstraintWidget constraintWidget) {
        this.mChildren.remove(constraintWidget);
        constraintWidget.setParent(null);
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void resetSolverVariables(Cache cache) {
        super.resetSolverVariables(cache);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).resetSolverVariables(cache);
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void setOffset(int i, int i2) {
        super.setOffset(i, i2);
        int size = this.mChildren.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mChildren.get(i3).setOffset(getRootX(), getRootY());
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void updateDrawPosition() {
        super.updateDrawPosition();
        if (this.mChildren == null) {
            return;
        }
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            constraintWidget.setOffset(getDrawX(), getDrawY());
            if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                constraintWidget.updateDrawPosition();
            }
        }
    }
}
