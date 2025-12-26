package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int decodeCode(BitArray bitArray, int[] iArr, int i) throws NotFoundException {
        recordPattern(bitArray, i, iArr);
        float f = MAX_AVG_VARIANCE;
        int i2 = -1;
        for (int i3 = 0; i3 < CODE_PATTERNS.length; i3++) {
            float fPatternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i3], MAX_INDIVIDUAL_VARIANCE);
            if (fPatternMatchVariance < f) {
                i2 = i3;
                f = fPatternMatchVariance;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        boolean z = false;
        int i = 0;
        int i2 = nextSet;
        while (nextSet < size) {
            if (bitArray.get(nextSet) ^ z) {
                iArr[i] = iArr[i] + 1;
            } else {
                if (i == 5) {
                    float f = MAX_AVG_VARIANCE;
                    int i3 = -1;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float fPatternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i4], MAX_INDIVIDUAL_VARIANCE);
                        if (fPatternMatchVariance < f) {
                            i3 = i4;
                            f = fPatternMatchVariance;
                        }
                    }
                    if (i3 >= 0 && bitArray.isRange(Math.max(0, i2 - ((nextSet - i2) / 2)), i2, false)) {
                        return new int[]{i2, nextSet, i3};
                    }
                    i2 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, 4);
                    iArr[4] = 0;
                    iArr[5] = 0;
                    i--;
                } else {
                    i++;
                }
                iArr[i] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d0, code lost:
    
        if (r5 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0113, code lost:
    
        if (r5 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0115, code lost:
    
        r5 = false;
        r10 = false;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x00ae. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:70:0x00f9. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bb A[PHI: r19
  0x00bb: PHI (r19v17 boolean) = (r19v5 boolean), (r19v19 boolean) binds: [B:74:0x0103, B:48:0x00b9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c2 A[PHI: r19
  0x00c2: PHI (r19v16 boolean) = (r19v5 boolean), (r19v19 boolean) binds: [B:74:0x0103, B:48:0x00b9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011d A[PHI: r19
  0x011d: PHI (r19v9 boolean) = (r19v5 boolean), (r19v19 boolean) binds: [B:70:0x00f9, B:44:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0126 A[PHI: r19
  0x0126: PHI (r19v7 boolean) = (r19v5 boolean), (r19v19 boolean) binds: [B:69:0x00f7, B:43:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.zxing.oned.OneDReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        char c;
        char c2;
        boolean z;
        boolean z2;
        int i2;
        boolean z3 = map != null && map.containsKey(DecodeHintType.ASSUME_GS1);
        int[] iArrFindStartPattern = findStartPattern(bitArray);
        int i3 = iArrFindStartPattern[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i3));
        switch (i3) {
            case 103:
                c = 'e';
                break;
            case 104:
                c = 'd';
                break;
            case 105:
                c = 'c';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        StringBuilder sb = new StringBuilder(20);
        int i4 = iArrFindStartPattern[0];
        int i5 = iArrFindStartPattern[1];
        int i6 = 6;
        int[] iArr = new int[6];
        boolean z4 = false;
        boolean z5 = false;
        int i7 = 0;
        int i8 = 0;
        int i9 = i3;
        int i10 = i4;
        boolean z6 = true;
        boolean z7 = false;
        boolean z8 = false;
        char c3 = c;
        int i11 = 0;
        while (!z7) {
            int iDecodeCode = decodeCode(bitArray, iArr, i5);
            arrayList.add(Byte.valueOf((byte) iDecodeCode));
            if (iDecodeCode != 106) {
                z6 = true;
            }
            if (iDecodeCode != 106) {
                i7++;
                i9 += i7 * iDecodeCode;
            }
            int i12 = i5;
            for (int i13 = 0; i13 < i6; i13++) {
                i12 += iArr[i13];
            }
            switch (iDecodeCode) {
                case 103:
                case 104:
                case 105:
                    throw FormatException.getFormatInstance();
                default:
                    switch (c3) {
                        case 'c':
                            c2 = 'd';
                            if (iDecodeCode >= 100) {
                                if (iDecodeCode != 106) {
                                    z6 = false;
                                }
                                if (iDecodeCode != 106) {
                                    switch (iDecodeCode) {
                                        case 100:
                                            z = z4;
                                            c3 = 'd';
                                            break;
                                        case 101:
                                            z = z4;
                                            c3 = 'e';
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append((char) 29);
                                                }
                                            }
                                        default:
                                            z = z4;
                                            break;
                                    }
                                    z2 = false;
                                    break;
                                } else {
                                    z = z4;
                                    z2 = false;
                                    z7 = true;
                                    break;
                                }
                            } else {
                                if (iDecodeCode < 10) {
                                    sb.append('0');
                                }
                                sb.append(iDecodeCode);
                            }
                            z = z4;
                            z2 = false;
                        case 'd':
                            if (iDecodeCode < 96) {
                                i2 = z4 == z5 ? iDecodeCode + 32 : iDecodeCode + 32 + 128;
                                sb.append((char) i2);
                                z2 = false;
                                c2 = 'd';
                                z = false;
                                break;
                            } else {
                                if (iDecodeCode != 106) {
                                    z6 = false;
                                }
                                if (iDecodeCode != 106) {
                                    switch (iDecodeCode) {
                                        case 98:
                                            z = z4;
                                            c3 = 'e';
                                            z2 = true;
                                            c2 = 'd';
                                            break;
                                        case 99:
                                            z = z4;
                                            c3 = 'c';
                                            z2 = false;
                                            c2 = 'd';
                                            break;
                                        case 100:
                                            if (z5 || !z4) {
                                                if (z5) {
                                                }
                                                z2 = false;
                                                c2 = 'd';
                                                z = true;
                                                break;
                                            }
                                            z2 = false;
                                            z5 = true;
                                            c2 = 'd';
                                            z = false;
                                            break;
                                        case 101:
                                            z = z4;
                                            c3 = 'e';
                                            z2 = false;
                                            c2 = 'd';
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                    break;
                                                } else {
                                                    sb.append((char) 29);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    z7 = true;
                                }
                                z = z4;
                                z2 = false;
                                c2 = 'd';
                            }
                            break;
                        case 'e':
                            if (iDecodeCode < 64) {
                                i2 = z4 == z5 ? iDecodeCode + 32 : iDecodeCode + 32 + 128;
                            } else if (iDecodeCode < 96) {
                                i2 = z4 == z5 ? iDecodeCode - 64 : iDecodeCode + 64;
                            } else {
                                if (iDecodeCode != 106) {
                                    z6 = false;
                                }
                                if (iDecodeCode != 106) {
                                    switch (iDecodeCode) {
                                        case 98:
                                            z = z4;
                                            c3 = 'd';
                                            z2 = true;
                                            c2 = 'd';
                                            break;
                                        case 100:
                                            z = z4;
                                            c3 = 'd';
                                            z2 = false;
                                            c2 = 'd';
                                            break;
                                        case 101:
                                            if (z5 || !z4) {
                                                if (z5) {
                                                }
                                                z2 = false;
                                                c2 = 'd';
                                                z = true;
                                                break;
                                            }
                                            z2 = false;
                                            z5 = true;
                                            c2 = 'd';
                                            z = false;
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                }
                                            }
                                            break;
                                    }
                                }
                                z = z4;
                                z2 = false;
                                c2 = 'd';
                            }
                            sb.append((char) i2);
                            z2 = false;
                            c2 = 'd';
                            z = false;
                            break;
                        default:
                            c2 = 'd';
                            z = z4;
                            z2 = false;
                            break;
                    }
                    if (z8) {
                        c3 = c3 == 'e' ? c2 : 'e';
                    }
                    z8 = z2;
                    z4 = z;
                    i6 = 6;
                    int i14 = i11;
                    i11 = iDecodeCode;
                    i10 = i5;
                    i5 = i12;
                    i8 = i14;
                    break;
            }
            while (!z7) {
            }
        }
        int i15 = i5 - i10;
        int nextUnset = bitArray.getNextUnset(i5);
        if (!bitArray.isRange(nextUnset, Math.min(bitArray.getSize(), ((nextUnset - i10) / 2) + nextUnset), false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i16 = i8;
        if ((i9 - (i7 * i16)) % 103 != i16) {
            throw ChecksumException.getChecksumInstance();
        }
        int length = sb.length();
        if (length == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (length > 0 && z6) {
            sb.delete(c3 == 'c' ? length - 2 : length - 1, length);
        }
        float f = (iArrFindStartPattern[1] + iArrFindStartPattern[0]) / 2.0f;
        float f2 = i10 + (i15 / 2.0f);
        int size = arrayList.size();
        byte[] bArr = new byte[size];
        for (int i17 = 0; i17 < size; i17++) {
            bArr[i17] = ((Byte) arrayList.get(i17)).byteValue();
        }
        float f3 = i;
        return new Result(sb.toString(), bArr, new ResultPoint[]{new ResultPoint(f, f3), new ResultPoint(f2, f3)}, BarcodeFormat.CODE_128);
    }
}
