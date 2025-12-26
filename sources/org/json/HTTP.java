package org.json;

import java.util.Iterator;

/* loaded from: classes.dex */
public class HTTP {
    public static final String CRLF = "\r\n";

    /* JADX WARN: Removed duplicated region for block: B:10:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0053  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0053 -> B:5:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject toJSONObject(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        HTTPTokener hTTPTokener = new HTTPTokener(str);
        String strNextToken = hTTPTokener.nextToken();
        if (strNextToken.toUpperCase().startsWith("HTTP")) {
            jSONObject.put("HTTP-Version", strNextToken);
            jSONObject.put("Status-Code", hTTPTokener.nextToken());
            jSONObject.put("Reason-Phrase", hTTPTokener.nextTo((char) 0));
            hTTPTokener.next();
            if (hTTPTokener.more()) {
                String strNextTo = hTTPTokener.nextTo(':');
                hTTPTokener.next(':');
                jSONObject.put(strNextTo, hTTPTokener.nextTo((char) 0));
                hTTPTokener.next();
                if (hTTPTokener.more()) {
                    return jSONObject;
                }
            }
        } else {
            jSONObject.put("Method", strNextToken);
            jSONObject.put("Request-URI", hTTPTokener.nextToken());
            jSONObject.put("HTTP-Version", hTTPTokener.nextToken());
            if (hTTPTokener.more()) {
            }
        }
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        String string;
        Iterator itKeys = jSONObject.keys();
        StringBuffer stringBuffer = new StringBuffer();
        if (jSONObject.has("Status-Code") && jSONObject.has("Reason-Phrase")) {
            stringBuffer.append(jSONObject.getString("HTTP-Version"));
            stringBuffer.append(' ');
            stringBuffer.append(jSONObject.getString("Status-Code"));
            stringBuffer.append(' ');
            string = "Reason-Phrase";
        } else {
            if (!jSONObject.has("Method") || !jSONObject.has("Request-URI")) {
                throw new JSONException("Not enough material for an HTTP header.");
            }
            stringBuffer.append(jSONObject.getString("Method"));
            stringBuffer.append(' ');
            stringBuffer.append('\"');
            stringBuffer.append(jSONObject.getString("Request-URI"));
            stringBuffer.append('\"');
            stringBuffer.append(' ');
            string = "HTTP-Version";
        }
        while (true) {
            stringBuffer.append(jSONObject.getString(string));
            stringBuffer.append(CRLF);
            while (itKeys.hasNext()) {
                string = itKeys.next().toString();
                if (string.equals("HTTP-Version") || string.equals("Status-Code") || string.equals("Reason-Phrase") || string.equals("Method") || string.equals("Request-URI") || jSONObject.isNull(string)) {
                }
            }
            stringBuffer.append(CRLF);
            return stringBuffer.toString();
            stringBuffer.append(string);
            stringBuffer.append(": ");
        }
    }
}
