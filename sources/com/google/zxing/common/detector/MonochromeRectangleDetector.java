package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

@Deprecated
/* loaded from: classes.dex */
public final class MonochromeRectangleDetector {
    private static final int MAX_MODULES = 32;
    private final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0035 A[EDGE_INSN: B:65:0x0035->B:20:0x0035 BREAK  A[LOOP:1: B:12:0x001e->B:69:0x001e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x006f A[EDGE_INSN: B:82:0x006f->B:43:0x006f BREAK  A[LOOP:3: B:35:0x0059->B:87:0x0059], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] blackWhiteRange(int i, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7 = (i3 + i4) / 2;
        int i8 = i7;
        while (i8 >= i3) {
            if (!z) {
                if (!this.image.get(i, i8)) {
                    i6 = i8;
                    while (true) {
                        i6--;
                        if (i6 < i3) {
                        }
                    }
                    int i9 = i8 - i6;
                    if (i6 < i3) {
                        break;
                    }
                    break;
                    break;
                }
                i8--;
            } else if (this.image.get(i8, i)) {
                i8--;
            } else {
                i6 = i8;
                while (true) {
                    i6--;
                    if (i6 < i3) {
                        break;
                    }
                    if (z) {
                        if (this.image.get(i6, i)) {
                            break;
                        }
                    } else if (this.image.get(i, i6)) {
                        break;
                    }
                }
                int i92 = i8 - i6;
                if (i6 < i3 || i92 > i2) {
                    break;
                }
                i8 = i6;
            }
        }
        int i10 = i8 + 1;
        while (i7 < i4) {
            if (!z) {
                if (!this.image.get(i, i7)) {
                    i5 = i7;
                    while (true) {
                        i5++;
                        if (i5 >= i4) {
                        }
                    }
                    int i11 = i5 - i7;
                    if (i5 >= i4) {
                        break;
                    }
                    break;
                    break;
                }
                i7++;
            } else if (this.image.get(i7, i)) {
                i7++;
            } else {
                i5 = i7;
                while (true) {
                    i5++;
                    if (i5 >= i4) {
                        break;
                    }
                    if (z) {
                        if (this.image.get(i5, i)) {
                            break;
                        }
                    } else if (this.image.get(i, i5)) {
                        break;
                    }
                }
                int i112 = i5 - i7;
                if (i5 >= i4 || i112 > i2) {
                    break;
                }
                i7 = i5;
            }
        }
        int i12 = i7 - 1;
        if (i12 > i10) {
            return new int[]{i10, i12};
        }
        return null;
    }

    private ResultPoint findCornerFromCenter(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) throws NotFoundException {
        boolean z;
        MonochromeRectangleDetector monochromeRectangleDetector;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = i;
        int i15 = i5;
        int[] iArr = null;
        while (i15 < i8 && i15 >= i7 && i14 < i4 && i14 >= i3) {
            if (i2 == 0) {
                monochromeRectangleDetector = this;
                i10 = i15;
                i11 = i9;
                i12 = i3;
                i13 = i4;
                z = true;
            } else {
                z = false;
                monochromeRectangleDetector = this;
                i10 = i14;
                i11 = i9;
                i12 = i7;
                i13 = i8;
            }
            int[] iArrBlackWhiteRange = monochromeRectangleDetector.blackWhiteRange(i10, i11, i12, i13, z);
            if (iArrBlackWhiteRange == null) {
                if (iArr == null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (i2 == 0) {
                    int i16 = i15 - i6;
                    if (iArr[0] >= i) {
                        return new ResultPoint(iArr[1], i16);
                    }
                    if (iArr[1] > i) {
                        return new ResultPoint(iArr[i6 > 0 ? (char) 0 : (char) 1], i16);
                    }
                    return new ResultPoint(iArr[0], i16);
                }
                int i17 = i14 - i2;
                if (iArr[0] >= i5) {
                    return new ResultPoint(i17, iArr[1]);
                }
                if (iArr[1] > i5) {
                    return new ResultPoint(i17, iArr[i2 < 0 ? (char) 0 : (char) 1]);
                }
                return new ResultPoint(i17, iArr[0]);
            }
            i15 += i6;
            i14 += i2;
            iArr = iArrBlackWhiteRange;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public ResultPoint[] detect() throws NotFoundException {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = height / 2;
        int i2 = width / 2;
        int iMax = Math.max(1, height / 256);
        int iMax2 = Math.max(1, width / 256);
        int i3 = -iMax;
        int i4 = i2 / 2;
        int y = ((int) findCornerFromCenter(i2, 0, 0, width, i, i3, 0, height, i4).getY()) - 1;
        int i5 = i / 2;
        ResultPoint resultPointFindCornerFromCenter = findCornerFromCenter(i2, -iMax2, 0, width, i, 0, y, height, i5);
        int x = ((int) resultPointFindCornerFromCenter.getX()) - 1;
        ResultPoint resultPointFindCornerFromCenter2 = findCornerFromCenter(i2, iMax2, x, width, i, 0, y, height, i5);
        int x2 = ((int) resultPointFindCornerFromCenter2.getX()) + 1;
        ResultPoint resultPointFindCornerFromCenter3 = findCornerFromCenter(i2, 0, x, x2, i, iMax, y, height, i4);
        return new ResultPoint[]{findCornerFromCenter(i2, 0, x, x2, i, i3, y, ((int) resultPointFindCornerFromCenter3.getY()) + 1, i2 / 4), resultPointFindCornerFromCenter, resultPointFindCornerFromCenter2, resultPointFindCornerFromCenter3};
    }
}
