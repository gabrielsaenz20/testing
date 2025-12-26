package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class CodaBarWriter extends OneDimensionalCodeWriter {
    private static final char[] START_END_CHARS = {'A', 'B', 'C', 'D'};
    private static final char[] ALT_START_END_CHARS = {'T', 'N', '*', 'E'};
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = {'/', ':', '+', '.'};
    private static final char DEFAULT_GUARD = START_END_CHARS[0];

    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f0  */
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean[] encode(String str) {
        StringBuilder sb;
        int i;
        int i2;
        int i3;
        if (str.length() >= 2) {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean zArrayContains = CodaBarReader.arrayContains(START_END_CHARS, upperCase);
            boolean zArrayContains2 = CodaBarReader.arrayContains(START_END_CHARS, upperCase2);
            boolean zArrayContains3 = CodaBarReader.arrayContains(ALT_START_END_CHARS, upperCase);
            boolean zArrayContains4 = CodaBarReader.arrayContains(ALT_START_END_CHARS, upperCase2);
            if (zArrayContains) {
                if (!zArrayContains2) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (!zArrayContains3) {
                if (zArrayContains2 || zArrayContains4) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
                sb = new StringBuilder();
            } else if (!zArrayContains4) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            }
            int i4 = 20;
            for (i = 1; i < str.length() - 1; i++) {
                if (Character.isDigit(str.charAt(i)) || str.charAt(i) == '-' || str.charAt(i) == '$') {
                    i4 += 9;
                } else {
                    if (!CodaBarReader.arrayContains(CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, str.charAt(i))) {
                        throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i) + '\'');
                    }
                    i4 += 10;
                }
            }
            boolean[] zArr = new boolean[i4 + (str.length() - 1)];
            int i5 = 0;
            for (i2 = 0; i2 < str.length(); i2++) {
                char upperCase3 = Character.toUpperCase(str.charAt(i2));
                if (i2 == 0 || i2 == str.length() - 1) {
                    if (upperCase3 == '*') {
                        upperCase3 = 'C';
                    } else if (upperCase3 == 'E') {
                        upperCase3 = 'D';
                    } else if (upperCase3 == 'N') {
                        upperCase3 = 'B';
                    } else if (upperCase3 == 'T') {
                        upperCase3 = 'A';
                    }
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= CodaBarReader.ALPHABET.length) {
                        i3 = 0;
                        break;
                    }
                    if (upperCase3 == CodaBarReader.ALPHABET[i6]) {
                        i3 = CodaBarReader.CHARACTER_ENCODINGS[i6];
                        break;
                    }
                    i6++;
                }
                int i7 = 0;
                boolean z = true;
                int i8 = i5;
                int i9 = 0;
                while (i9 < 7) {
                    zArr[i8] = z;
                    i8++;
                    if (((i3 >> (6 - i9)) & 1) == 0 || i7 == 1) {
                        z = !z;
                        i9++;
                        i7 = 0;
                    } else {
                        i7++;
                    }
                }
                if (i2 < str.length() - 1) {
                    zArr[i8] = false;
                    i8++;
                }
                i5 = i8;
            }
            return zArr;
        }
        sb = new StringBuilder();
        sb.append(DEFAULT_GUARD);
        sb.append(str);
        sb.append(DEFAULT_GUARD);
        str = sb.toString();
        int i42 = 20;
        while (i < str.length() - 1) {
        }
        boolean[] zArr2 = new boolean[i42 + (str.length() - 1)];
        int i52 = 0;
        while (i2 < str.length()) {
        }
        return zArr2;
    }
}
