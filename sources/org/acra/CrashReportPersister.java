package org.acra;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.helper.ItemTouchHelper;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Map;
import org.acra.collector.CollectorUtil;
import org.acra.collector.CrashReportData;

/* loaded from: classes.dex */
final class CrashReportPersister {
    private static final int CONTINUE = 3;
    private static final int IGNORE = 5;
    private static final int KEY_DONE = 4;
    private static final String LINE_SEPARATOR = "\n";
    private static final int NONE = 0;
    private static final int SLASH = 1;
    private static final int UNICODE = 2;
    private final Context context;

    CrashReportPersister(Context context) {
        this.context = context;
    }

    private void dumpString(StringBuilder sb, String str, boolean z) {
        int i;
        String hexString;
        if (z || str.length() <= 0 || str.charAt(0) != ' ') {
            i = 0;
        } else {
            sb.append("\\ ");
            i = 1;
        }
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            switch (cCharAt) {
                case '\t':
                    hexString = "\\t";
                    sb.append(hexString);
                    break;
                case '\n':
                    hexString = "\\n";
                    sb.append(hexString);
                    break;
                case 11:
                default:
                    if ("\\#!=:".indexOf(cCharAt) >= 0 || (z && cCharAt == ' ')) {
                        sb.append('\\');
                    }
                    if (cCharAt < ' ' || cCharAt > '~') {
                        hexString = Integer.toHexString(cCharAt);
                        sb.append("\\u");
                        for (int i2 = 0; i2 < 4 - hexString.length(); i2++) {
                            sb.append("0");
                        }
                        sb.append(hexString);
                        break;
                    } else {
                        sb.append(cCharAt);
                        break;
                    }
                case '\f':
                    hexString = "\\f";
                    sb.append(hexString);
                    break;
                case '\r':
                    hexString = "\\r";
                    sb.append(hexString);
                    break;
            }
            i++;
        }
    }

    private boolean isEbcdic(BufferedInputStream bufferedInputStream) {
        byte b;
        do {
            b = (byte) bufferedInputStream.read();
            if (b == -1 || b == 35 || b == 10 || b == 61) {
                return false;
            }
        } while (b != 21);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0158 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e1 A[PHI: r4
  0x00e1: PHI (r4v13 char) = (r4v4 char), (r4v4 char), (r4v15 char) binds: [B:119:0x015a, B:122:0x015f, B:64:0x00e0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized CrashReportData load(Reader reader) {
        CrashReportData crashReportData;
        char c;
        int i;
        int i2;
        crashReportData = new CrashReportData();
        BufferedReader bufferedReader = new BufferedReader(reader, 8192);
        int i3 = 2;
        int i4 = 4;
        int i5 = -1;
        int i6 = 0;
        char[] cArr = new char[40];
        boolean z = true;
        int i7 = -1;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = bufferedReader.read();
            if (i12 != i5) {
                char c2 = (char) i12;
                if (i8 == cArr.length) {
                    char[] cArr2 = new char[cArr.length * i3];
                    System.arraycopy(cArr, i6, cArr2, i6, i8);
                    cArr = cArr2;
                }
                if (i9 != i3) {
                    if (i9 != 1) {
                        if (c2 != '\n') {
                            if (c2 != '\r') {
                                if (c2 == 'b') {
                                    c2 = '\b';
                                } else if (c2 == 'f') {
                                    c2 = '\f';
                                } else if (c2 == 'n') {
                                    c2 = '\n';
                                } else if (c2 == 'r') {
                                    c2 = '\r';
                                } else if (c2 != 133) {
                                    switch (c2) {
                                        case 't':
                                            c2 = '\t';
                                            break;
                                        case 'u':
                                            i3 = 2;
                                            i4 = 4;
                                            i5 = -1;
                                            i6 = 0;
                                            i9 = 2;
                                            i10 = 0;
                                            i11 = 0;
                                            continue;
                                    }
                                }
                                i4 = 4;
                                i2 = 0;
                            } else {
                                i3 = 2;
                                i4 = 4;
                                i5 = -1;
                                i6 = 0;
                                i9 = 3;
                            }
                        }
                        i3 = 2;
                        i4 = 4;
                        i5 = -1;
                        i6 = 0;
                        i9 = 5;
                    } else {
                        if (c2 != '\n') {
                            if (c2 != '\r') {
                                if (c2 == '!' || c2 == '#') {
                                    if (z) {
                                        while (true) {
                                            int i13 = bufferedReader.read();
                                            int i14 = (i13 == i14 || (c = (char) i13) == '\r' || c == '\n' || c == 133) ? -1 : -1;
                                        }
                                    } else {
                                        if (Character.isWhitespace(c2)) {
                                            if (i9 == 3) {
                                                i9 = 5;
                                            }
                                            if (i8 != 0 && i8 != i7) {
                                                i = 5;
                                                if (i9 != 5) {
                                                    if (i7 == -1) {
                                                        i5 = -1;
                                                        i3 = 2;
                                                        i4 = 4;
                                                        i6 = 0;
                                                        i9 = 4;
                                                    }
                                                }
                                            }
                                        } else {
                                            i = 5;
                                        }
                                        i2 = i9;
                                        if (i2 == i || i2 == 3) {
                                            i4 = 4;
                                            i2 = 0;
                                        } else {
                                            i4 = 4;
                                        }
                                    }
                                    i3 = 2;
                                    i4 = 4;
                                    i5 = -1;
                                    i6 = 0;
                                } else if (c2 == ':' || c2 == '=') {
                                    if (i7 == -1) {
                                        i7 = i8;
                                        i5 = -1;
                                        i3 = 2;
                                        i4 = 4;
                                        i6 = 0;
                                        i9 = 0;
                                    } else {
                                        if (Character.isWhitespace(c2)) {
                                        }
                                        i2 = i9;
                                        if (i2 == i) {
                                            i4 = 4;
                                            i2 = 0;
                                        }
                                    }
                                } else if (c2 == '\\') {
                                    if (i9 == 4) {
                                        i7 = i8;
                                    }
                                    i9 = 1;
                                    i3 = 2;
                                    i4 = 4;
                                    i5 = -1;
                                    i6 = 0;
                                } else if (c2 != 133) {
                                    if (Character.isWhitespace(c2)) {
                                    }
                                    i2 = i9;
                                    if (i2 == i) {
                                    }
                                }
                            }
                            i4 = 4;
                        } else {
                            i4 = 4;
                            if (i9 == 3) {
                                i9 = 5;
                                i3 = 2;
                                i5 = -1;
                                i6 = 0;
                            }
                        }
                        if (i8 > 0 || (i8 == 0 && i7 == 0)) {
                            i5 = -1;
                            if (i7 == -1) {
                                i7 = i8;
                            }
                            i9 = 0;
                            String str = new String(cArr, 0, i8);
                            crashReportData.put((CrashReportData) Enum.valueOf(ReportField.class, str.substring(0, i7)), (Enum) str.substring(i7));
                        } else {
                            i5 = -1;
                            i9 = 0;
                        }
                        z = true;
                        i7 = i5;
                        i8 = i9;
                        i6 = i8;
                        i3 = 2;
                    }
                    if (i2 != i4) {
                        i7 = i8;
                        i9 = 0;
                    } else {
                        i9 = i2;
                    }
                    cArr[i8] = c2;
                    i8++;
                    i3 = 2;
                    i5 = -1;
                    i6 = 0;
                    z = false;
                } else {
                    int iDigit = Character.digit(c2, 16);
                    if (iDigit >= 0) {
                        i11 = (i11 << 4) + iDigit;
                        i10++;
                        if (i10 < i4) {
                            i3 = 2;
                            i5 = -1;
                            i6 = 0;
                        }
                    } else if (i10 <= i4) {
                        throw new IllegalArgumentException("luni.09");
                    }
                    int i15 = i11;
                    int i16 = i8 + 1;
                    cArr[i8] = (char) i15;
                    if (c2 == '\n' || c2 == 133) {
                        i11 = i15;
                        i8 = i16;
                        i9 = 0;
                        if (i9 != 1) {
                        }
                        if (i2 != i4) {
                        }
                        cArr[i8] = c2;
                        i8++;
                        i3 = 2;
                        i5 = -1;
                        i6 = 0;
                        z = false;
                    } else {
                        i11 = i15;
                        i8 = i16;
                        i3 = 2;
                        i4 = 4;
                        i5 = -1;
                        i6 = 0;
                        i9 = 0;
                    }
                }
            } else {
                if (i9 == i3 && i10 <= i4) {
                    throw new IllegalArgumentException("luni.08");
                }
                if (i7 == i5 && i8 > 0) {
                    i7 = i8;
                }
                if (i7 >= 0) {
                    String str2 = new String(cArr, i6, i8);
                    ReportField reportField = (ReportField) Enum.valueOf(ReportField.class, str2.substring(i6, i7));
                    String strSubstring = str2.substring(i7);
                    if (i9 == 1) {
                        strSubstring = strSubstring + "\u0000";
                    }
                    crashReportData.put((CrashReportData) reportField, (ReportField) strSubstring);
                }
                CollectorUtil.safeClose(reader);
            }
        }
        return crashReportData;
    }

    public CrashReportData load(String str) throws IOException {
        FileInputStream fileInputStreamOpenFileInput = this.context.openFileInput(str);
        if (fileInputStreamOpenFileInput == null) {
            throw new IllegalArgumentException("Invalid crash report fileName : " + str);
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStreamOpenFileInput, 8192);
            bufferedInputStream.mark(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            boolean zIsEbcdic = isEbcdic(bufferedInputStream);
            bufferedInputStream.reset();
            return !zIsEbcdic ? load(new InputStreamReader(bufferedInputStream, "ISO8859-1")) : load(new InputStreamReader(bufferedInputStream));
        } finally {
            fileInputStreamOpenFileInput.close();
        }
    }

    public void store(CrashReportData crashReportData, String str) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput = this.context.openFileOutput(str, 0);
        try {
            StringBuilder sb = new StringBuilder(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStreamOpenFileOutput, "ISO8859_1");
            for (Map.Entry<ReportField, String> entry : crashReportData.entrySet()) {
                dumpString(sb, entry.getKey().toString(), true);
                sb.append('=');
                dumpString(sb, entry.getValue(), false);
                sb.append(LINE_SEPARATOR);
                outputStreamWriter.write(sb.toString());
                sb.setLength(0);
            }
            outputStreamWriter.flush();
        } finally {
            fileOutputStreamOpenFileOutput.close();
        }
    }
}
