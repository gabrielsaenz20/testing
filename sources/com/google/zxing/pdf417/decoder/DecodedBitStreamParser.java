package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes.dex */
final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        EXP900[1] = bigIntegerValueOf;
        for (int i = 2; i < EXP900.length; i++) {
            EXP900[i] = EXP900[i - 1].multiply(bigIntegerValueOf);
        }
    }

    private DecodedBitStreamParser() {
    }

    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        char c;
        char c2;
        int i4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = MACRO_PDF417_TERMINATOR;
        int i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
        int i7 = 928;
        int i8 = NUMERIC_COMPACTION_MODE_LATCH;
        long j = 900;
        if (i == BYTE_COMPACTION_MODE_LATCH) {
            int[] iArr2 = new int[6];
            int i9 = iArr[i2];
            int i10 = 0;
            i3 = i2 + 1;
            long j2 = 0;
            boolean z = false;
            while (i3 < iArr[0] && !z) {
                int i11 = i10 + 1;
                iArr2[i10] = i9;
                j2 = (j2 * j) + i9;
                int i12 = i3 + 1;
                i9 = iArr[i3];
                if (i9 == TEXT_COMPACTION_MODE_LATCH || i9 == BYTE_COMPACTION_MODE_LATCH || i9 == NUMERIC_COMPACTION_MODE_LATCH || i9 == BYTE_COMPACTION_MODE_LATCH_6 || i9 == 928 || i9 == i6 || i9 == i5) {
                    i3 = i12 - 1;
                    i10 = i11;
                    z = true;
                    i5 = MACRO_PDF417_TERMINATOR;
                    i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                    j = 900;
                } else if (i11 % 5 != 0 || i11 <= 0) {
                    i10 = i11;
                    i3 = i12;
                    i5 = MACRO_PDF417_TERMINATOR;
                    i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                    j = 900;
                } else {
                    int i13 = 0;
                    while (i13 < 6) {
                        byteArrayOutputStream.write((byte) (j2 >> ((5 - i13) * 8)));
                        i13++;
                        i5 = MACRO_PDF417_TERMINATOR;
                        i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                    }
                    i3 = i12;
                    i10 = 0;
                    j = 900;
                    j2 = 0;
                }
            }
            if (i3 != iArr[0] || i9 >= TEXT_COMPACTION_MODE_LATCH) {
                i4 = i10;
            } else {
                i4 = i10 + 1;
                iArr2[i10] = i9;
            }
            for (int i14 = 0; i14 < i4; i14++) {
                byteArrayOutputStream.write((byte) iArr2[i14]);
            }
        } else if (i == BYTE_COMPACTION_MODE_LATCH_6) {
            i3 = i2;
            boolean z2 = false;
            int i15 = 0;
            long j3 = 0;
            while (i3 < iArr[0] && !z2) {
                int i16 = i3 + 1;
                int i17 = iArr[i3];
                if (i17 < TEXT_COMPACTION_MODE_LATCH) {
                    i15++;
                    j3 = (j3 * 900) + i17;
                    i3 = i16;
                    c = 924;
                } else {
                    if (i17 == TEXT_COMPACTION_MODE_LATCH || i17 == BYTE_COMPACTION_MODE_LATCH || i17 == i8) {
                        c = 924;
                    } else {
                        c = 924;
                        if (i17 != BYTE_COMPACTION_MODE_LATCH_6 && i17 != i7) {
                            if (i17 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                                if (i17 != MACRO_PDF417_TERMINATOR) {
                                    i3 = i16;
                                }
                            }
                            i3 = i16 - 1;
                            z2 = true;
                        }
                        i3 = i16 - 1;
                        z2 = true;
                    }
                    i3 = i16 - 1;
                    z2 = true;
                }
                if (i15 % 5 != 0 || i15 <= 0) {
                    c2 = 6;
                } else {
                    c2 = 6;
                    for (int i18 = 0; i18 < 6; i18++) {
                        byteArrayOutputStream.write((byte) (j3 >> ((5 - i18) * 8)));
                    }
                    i15 = 0;
                    j3 = 0;
                }
                i7 = 928;
                i8 = NUMERIC_COMPACTION_MODE_LATCH;
            }
        } else {
            i3 = i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int iByteCompaction;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charsetForName = DEFAULT_ENCODING;
        int i = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        int i2 = 2;
        while (i2 < iArr[0]) {
            if (i != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                switch (i) {
                    case TEXT_COMPACTION_MODE_LATCH /* 900 */:
                        iByteCompaction = textCompaction(iArr, i2, sb);
                        break;
                    case BYTE_COMPACTION_MODE_LATCH /* 901 */:
                        iByteCompaction = byteCompaction(i, iArr, charsetForName, i2, sb);
                        break;
                    case NUMERIC_COMPACTION_MODE_LATCH /* 902 */:
                        iByteCompaction = numericCompaction(iArr, i2, sb);
                        break;
                    default:
                        switch (i) {
                            case MACRO_PDF417_TERMINATOR /* 922 */:
                            case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                                throw FormatException.getFormatInstance();
                            case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                                break;
                            case ECI_USER_DEFINED /* 925 */:
                                iByteCompaction = i2 + 1;
                                break;
                            case ECI_GENERAL_PURPOSE /* 926 */:
                                iByteCompaction = i2 + 2;
                                break;
                            case ECI_CHARSET /* 927 */:
                                iByteCompaction = i2 + 1;
                                charsetForName = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i2]).name());
                                break;
                            case 928:
                                iByteCompaction = decodeMacroBlock(iArr, i2, pDF417ResultMetadata);
                                break;
                            default:
                                i2--;
                                iByteCompaction = textCompaction(iArr, i2, sb);
                                break;
                        }
                }
            } else {
                iByteCompaction = i2 + 1;
                sb.append((char) iArr[i2]);
            }
            if (iByteCompaction >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            i2 = iByteCompaction + 1;
            i = iArr[iByteCompaction];
        }
        if (sb.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        DecoderResult decoderResult = new DecoderResult(null, sb.toString(), null, str);
        decoderResult.setOther(pDF417ResultMetadata);
        return decoderResult;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) != '1') {
            throw FormatException.getFormatInstance();
        }
        return string.substring(1);
    }

    private static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i2 = i;
        int i3 = 0;
        while (i3 < 2) {
            iArr2[i3] = iArr[i2];
            i3++;
            i2++;
        }
        pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int iTextCompaction = textCompaction(iArr, i2, sb);
        pDF417ResultMetadata.setFileId(sb.toString());
        if (iArr[iTextCompaction] != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
            if (iArr[iTextCompaction] != MACRO_PDF417_TERMINATOR) {
                return iTextCompaction;
            }
            pDF417ResultMetadata.setLastSegment(true);
            return iTextCompaction + 1;
        }
        int i4 = iTextCompaction + 1;
        int[] iArr3 = new int[iArr[0] - i4];
        boolean z = false;
        int i5 = 0;
        while (i4 < iArr[0] && !z) {
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i7 < TEXT_COMPACTION_MODE_LATCH) {
                iArr3[i5] = i7;
                i4 = i6;
                i5++;
            } else {
                if (i7 != MACRO_PDF417_TERMINATOR) {
                    throw FormatException.getFormatInstance();
                }
                pDF417ResultMetadata.setLastSegment(true);
                i4 = i6 + 1;
                z = true;
            }
        }
        pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i5));
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        if (r6 == com.google.zxing.pdf417.decoder.DecodedBitStreamParser.TEXT_COMPACTION_MODE_LATCH) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        if (r6 == com.google.zxing.pdf417.decoder.DecodedBitStreamParser.TEXT_COMPACTION_MODE_LATCH) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
    
        if (r6 == com.google.zxing.pdf417.decoder.DecodedBitStreamParser.TEXT_COMPACTION_MODE_LATCH) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008f, code lost:
    
        if (r6 == com.google.zxing.pdf417.decoder.DecodedBitStreamParser.TEXT_COMPACTION_MODE_LATCH) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ab, code lost:
    
        if (r6 == com.google.zxing.pdf417.decoder.DecodedBitStreamParser.TEXT_COMPACTION_MODE_LATCH) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00cc, code lost:
    
        if (r6 == com.google.zxing.pdf417.decoder.DecodedBitStreamParser.TEXT_COMPACTION_MODE_LATCH) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        char c;
        int i2;
        int i3;
        Mode mode;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = Mode.ALPHA;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = iArr[i4];
            switch (mode2) {
                case ALPHA:
                    if (i5 < 26) {
                        i3 = i5 + 65;
                        c = (char) i3;
                        break;
                    } else {
                        if (i5 != 26) {
                            if (i5 != 27) {
                                if (i5 != 28) {
                                    if (i5 != 29) {
                                        if (i5 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                            i2 = iArr2[i4];
                                            sb.append((char) i2);
                                            c = 0;
                                            break;
                                        }
                                    }
                                    mode = Mode.PUNCT_SHIFT;
                                    mode3 = mode2;
                                    mode2 = mode;
                                    c = 0;
                                }
                                mode = Mode.MIXED;
                                mode2 = mode;
                                c = 0;
                            }
                            mode = Mode.LOWER;
                            mode2 = mode;
                            c = 0;
                        }
                        c = ' ';
                        break;
                    }
                case LOWER:
                    if (i5 < 26) {
                        i3 = i5 + 97;
                        c = (char) i3;
                        break;
                    } else {
                        if (i5 != 26) {
                            if (i5 == 27) {
                                mode = Mode.ALPHA_SHIFT;
                                mode3 = mode2;
                                mode2 = mode;
                                c = 0;
                                break;
                            } else {
                                if (i5 != 28) {
                                    if (i5 != 29) {
                                        if (i5 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                            i2 = iArr2[i4];
                                            sb.append((char) i2);
                                            c = 0;
                                        }
                                    }
                                    mode = Mode.PUNCT_SHIFT;
                                    mode3 = mode2;
                                    mode2 = mode;
                                    c = 0;
                                }
                                mode = Mode.MIXED;
                                mode2 = mode;
                                c = 0;
                            }
                        }
                        c = ' ';
                        break;
                    }
                case MIXED:
                    if (i5 < 25) {
                        c = MIXED_CHARS[i5];
                        break;
                    } else if (i5 == 25) {
                        mode = Mode.PUNCT;
                        mode2 = mode;
                        c = 0;
                        break;
                    } else {
                        if (i5 != 26) {
                            if (i5 != 27) {
                                if (i5 != 28) {
                                    if (i5 != 29) {
                                        if (i5 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                            i2 = iArr2[i4];
                                            sb.append((char) i2);
                                            c = 0;
                                        }
                                    }
                                    mode = Mode.PUNCT_SHIFT;
                                    mode3 = mode2;
                                    mode2 = mode;
                                    c = 0;
                                }
                                mode = Mode.ALPHA;
                                mode2 = mode;
                                c = 0;
                            }
                            mode = Mode.LOWER;
                            mode2 = mode;
                            c = 0;
                        }
                        c = ' ';
                        break;
                    }
                    break;
                case PUNCT:
                    if (i5 < 29) {
                        c = PUNCT_CHARS[i5];
                        break;
                    } else {
                        if (i5 != 29) {
                            if (i5 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                i2 = iArr2[i4];
                                sb.append((char) i2);
                                c = 0;
                                break;
                            }
                        }
                        mode = Mode.ALPHA;
                        mode2 = mode;
                        c = 0;
                    }
                    break;
                case ALPHA_SHIFT:
                    if (i5 < 26) {
                        c = (char) (i5 + 65);
                        mode2 = mode3;
                        break;
                    } else if (i5 == 26) {
                        mode2 = mode3;
                        c = ' ';
                        break;
                    }
                    break;
                case PUNCT_SHIFT:
                    if (i5 < 29) {
                        c = PUNCT_CHARS[i5];
                        mode2 = mode3;
                        break;
                    } else {
                        if (i5 != 29) {
                            if (i5 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                sb.append((char) iArr2[i4]);
                            }
                            mode2 = mode3;
                            c = 0;
                            break;
                        }
                        mode = Mode.ALPHA;
                        mode2 = mode;
                        c = 0;
                    }
                    break;
                default:
                    c = 0;
                    break;
            }
            if (c != 0) {
                sb.append(c);
            }
        }
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i2] = i4;
                i2++;
            } else if (i4 == TEXT_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH_6 || i4 == 928 || i4 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i4 == MACRO_PDF417_TERMINATOR) {
                i3--;
                z = true;
            }
            if ((i2 % 15 == 0 || i4 == NUMERIC_COMPACTION_MODE_LATCH || z) && i2 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0034. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0037. Please report as an issue. */
    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i) << 1];
        int[] iArr3 = new int[(iArr[0] - i) << 1];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i4 != 928) {
                    switch (i4) {
                        case TEXT_COMPACTION_MODE_LATCH /* 900 */:
                            iArr2[i2] = TEXT_COMPACTION_MODE_LATCH;
                            i2++;
                            break;
                        case BYTE_COMPACTION_MODE_LATCH /* 901 */:
                        case NUMERIC_COMPACTION_MODE_LATCH /* 902 */:
                            break;
                        default:
                            switch (i4) {
                            }
                    }
                }
                i = i3 - 1;
                z = true;
            } else {
                iArr2[i2] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
        }
        decodeTextCompaction(iArr2, iArr3, i2, sb);
        return i;
    }
}
