package org.json;

import android.support.v7.widget.ActivityChooserView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: classes.dex */
public class JSONTokener {
    private int index;
    private char lastChar;
    private Reader reader;
    private boolean useLastChar;

    public JSONTokener(Reader reader) {
        this.reader = reader.markSupported() ? reader : new BufferedReader(reader);
        this.useLastChar = false;
        this.index = 0;
    }

    public JSONTokener(String str) {
        this(new StringReader(str));
    }

    public static int dehexchar(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        if (c < 'a' || c > 'f') {
            return -1;
        }
        return c - 'W';
    }

    public void back() {
        if (this.useLastChar || this.index <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.index--;
        this.useLastChar = true;
    }

    public boolean more() {
        if (next() == 0) {
            return false;
        }
        back();
        return true;
    }

    public char next() throws JSONException, IOException {
        if (this.useLastChar) {
            this.useLastChar = false;
            if (this.lastChar != 0) {
                this.index++;
            }
            return this.lastChar;
        }
        try {
            int i = this.reader.read();
            if (i <= 0) {
                this.lastChar = (char) 0;
                return (char) 0;
            }
            this.index++;
            this.lastChar = (char) i;
            return this.lastChar;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    public char next(char c) throws JSONException, IOException {
        char next = next();
        if (next == c) {
            return next;
        }
        throw syntaxError("Expected '" + c + "' and instead saw '" + next + "'");
    }

    public String next(int i) throws JSONException, IOException {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        int i2 = 0;
        if (this.useLastChar) {
            this.useLastChar = false;
            cArr[0] = this.lastChar;
            i2 = 1;
        }
        while (i2 < i) {
            try {
                int i3 = this.reader.read(cArr, i2, i - i2);
                if (i3 == -1) {
                    break;
                }
                i2 += i3;
            } catch (IOException e) {
                throw new JSONException(e);
            }
        }
        this.index += i2;
        if (i2 < i) {
            throw syntaxError("Substring bounds error");
        }
        this.lastChar = cArr[i - 1];
        return new String(cArr);
    }

    public char nextClean() {
        char next;
        do {
            next = next();
            if (next == 0) {
                break;
            }
        } while (next <= ' ');
        return next;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0064, code lost:
    
        throw syntaxError("Unterminated string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String nextString(char c) throws JSONException, IOException {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            char next = next();
            if (next != 0 && next != '\n' && next != '\r') {
                if (next == '\\') {
                    next = next();
                    if (next == 'b') {
                        next = '\b';
                    } else if (next == 'f') {
                        next = '\f';
                    } else if (next == 'n') {
                        stringBuffer.append('\n');
                    } else if (next != 'r') {
                        if (next != 'x') {
                            switch (next) {
                                case 't':
                                    next = '\t';
                                    break;
                                case 'u':
                                    i = 4;
                                    break;
                            }
                        } else {
                            i = 2;
                        }
                        next = (char) Integer.parseInt(next(i), 16);
                    } else {
                        stringBuffer.append('\r');
                    }
                } else if (next == c) {
                    return stringBuffer.toString();
                }
                stringBuffer.append(next);
            }
        }
    }

    public String nextTo(char c) throws JSONException, IOException {
        char next;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            next = next();
            if (next == c || next == 0 || next == '\n' || next == '\r') {
                break;
            }
            stringBuffer.append(next);
        }
        if (next != 0) {
            back();
        }
        return stringBuffer.toString().trim();
    }

    public String nextTo(String str) throws JSONException, IOException {
        char next;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            next = next();
            if (str.indexOf(next) >= 0 || next == 0 || next == '\n' || next == '\r') {
                break;
            }
            stringBuffer.append(next);
        }
        if (next != 0) {
            back();
        }
        return stringBuffer.toString().trim();
    }

    public Object nextValue() {
        char cNextClean = nextClean();
        if (cNextClean != '\"') {
            if (cNextClean != '[') {
                if (cNextClean == '{') {
                    back();
                    return new JSONObject(this);
                }
                switch (cNextClean) {
                    case '\'':
                        break;
                    case '(':
                        break;
                    default:
                        StringBuffer stringBuffer = new StringBuffer();
                        while (cNextClean >= ' ' && ",:]}/\\\"[{;=#".indexOf(cNextClean) < 0) {
                            stringBuffer.append(cNextClean);
                            cNextClean = next();
                        }
                        back();
                        String strTrim = stringBuffer.toString().trim();
                        if (strTrim.equals("")) {
                            throw syntaxError("Missing value");
                        }
                        return JSONObject.stringToValue(strTrim);
                }
            }
            back();
            return new JSONArray(this);
        }
        return nextString(cNextClean);
    }

    public char skipTo(char c) throws JSONException, IOException {
        char next;
        try {
            int i = this.index;
            this.reader.mark(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            do {
                next = next();
                if (next == 0) {
                    this.reader.reset();
                    this.index = i;
                    return next;
                }
            } while (next != c);
            back();
            return next;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    public JSONException syntaxError(String str) {
        return new JSONException(str + toString());
    }

    public String toString() {
        return " at character " + this.index;
    }
}
