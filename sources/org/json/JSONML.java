package org.json;

import java.util.Iterator;

/* loaded from: classes.dex */
public class JSONML {
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0194, code lost:
    
        throw r7.syntaxError("Reserved attribute.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x019d, code lost:
    
        r5 = r7.nextToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01a3, code lost:
    
        if ((r5 instanceof java.lang.String) != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01ab, code lost:
    
        throw r7.syntaxError("Missing value");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
    
        throw r7.syntaxError("Expected 'CDATA['");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Object parse(XMLTokener xMLTokener, boolean z, JSONArray jSONArray) throws JSONException {
        String str;
        Object objNextToken;
        loop0: while (true) {
            Object objNextContent = xMLTokener.nextContent();
            if (objNextContent == XML.LT) {
                Object objNextToken2 = xMLTokener.nextToken();
                if (objNextToken2 instanceof Character) {
                    if (objNextToken2 == XML.SLASH) {
                        Object objNextToken3 = xMLTokener.nextToken();
                        if (objNextToken3 instanceof String) {
                            if (xMLTokener.nextToken() != XML.GT) {
                                throw xMLTokener.syntaxError("Misshaped close tag");
                            }
                            return objNextToken3;
                        }
                        throw new JSONException("Expected a closing name instead of '" + objNextToken3 + "'.");
                    }
                    if (objNextToken2 == XML.BANG) {
                        char next = xMLTokener.next();
                        if (next == '-') {
                            if (xMLTokener.next() == '-') {
                                xMLTokener.skipPast("-->");
                            }
                            xMLTokener.back();
                        } else if (next != '[') {
                            int i = 1;
                            do {
                                Object objNextMeta = xMLTokener.nextMeta();
                                if (objNextMeta == null) {
                                    throw xMLTokener.syntaxError("Missing '>' after '<!'.");
                                }
                                if (objNextMeta == XML.LT) {
                                    i++;
                                } else if (objNextMeta == XML.GT) {
                                    i--;
                                }
                            } while (i > 0);
                        } else {
                            if (!xMLTokener.nextToken().equals("CDATA") || xMLTokener.next() != '[') {
                                break;
                            }
                            if (jSONArray != null) {
                                objNextContent = xMLTokener.nextCDATA();
                                jSONArray.put(objNextContent);
                            }
                        }
                    } else {
                        if (objNextToken2 != XML.QUEST) {
                            throw xMLTokener.syntaxError("Misshaped tag");
                        }
                        xMLTokener.skipPast("?>");
                    }
                } else {
                    if (!(objNextToken2 instanceof String)) {
                        throw xMLTokener.syntaxError("Bad tagName '" + objNextToken2 + "'.");
                    }
                    String str2 = (String) objNextToken2;
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    if (z) {
                        jSONArray2.put(str2);
                        if (jSONArray != null) {
                            jSONArray.put(jSONArray2);
                        }
                    } else {
                        jSONObject.put("tagName", str2);
                        if (jSONArray != null) {
                            jSONArray.put(jSONObject);
                        }
                    }
                    while (true) {
                        Object objNextToken4 = null;
                        while (true) {
                            if (objNextToken4 == null) {
                                objNextToken4 = xMLTokener.nextToken();
                            }
                            if (objNextToken4 != null) {
                                if (objNextToken4 instanceof String) {
                                    str = (String) objNextToken4;
                                    if (!z && (str == "tagName" || str == "childNode")) {
                                        break loop0;
                                    }
                                    Object objNextToken5 = xMLTokener.nextToken();
                                    if (objNextToken5 == XML.EQ) {
                                        break;
                                    }
                                    jSONObject.accumulate(str, "");
                                    objNextToken4 = objNextToken5;
                                } else {
                                    if (z && jSONObject.length() > 0) {
                                        jSONArray2.put(jSONObject);
                                    }
                                    if (objNextToken4 == XML.SLASH) {
                                        if (xMLTokener.nextToken() != XML.GT) {
                                            throw xMLTokener.syntaxError("Misshaped tag");
                                        }
                                        if (jSONArray == null) {
                                            return z ? jSONArray2 : jSONObject;
                                        }
                                    } else {
                                        if (objNextToken4 != XML.GT) {
                                            throw xMLTokener.syntaxError("Misshaped tag");
                                        }
                                        String str3 = (String) parse(xMLTokener, z, jSONArray2);
                                        if (str3 == null) {
                                            continue;
                                        } else {
                                            if (!str3.equals(str2)) {
                                                throw xMLTokener.syntaxError("Mismatched '" + str2 + "' and '" + str3 + "'");
                                            }
                                            if (!z && jSONArray2.length() > 0) {
                                                jSONObject.put("childNodes", jSONArray2);
                                            }
                                            if (jSONArray == null) {
                                                return z ? jSONArray2 : jSONObject;
                                            }
                                        }
                                    }
                                }
                            } else {
                                throw xMLTokener.syntaxError("Misshaped tag");
                            }
                        }
                        jSONObject.accumulate(str, JSONObject.stringToValue((String) objNextToken));
                    }
                }
            } else if (jSONArray != null) {
                if (objNextContent instanceof String) {
                    objNextContent = JSONObject.stringToValue((String) objNextContent);
                }
                jSONArray.put(objNextContent);
            }
        }
    }

    public static JSONArray toJSONArray(String str) {
        return toJSONArray(new XMLTokener(str));
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener) {
        return (JSONArray) parse(xMLTokener, true, null);
    }

    public static JSONObject toJSONObject(String str) {
        return toJSONObject(new XMLTokener(str));
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener) {
        return (JSONObject) parse(xMLTokener, false, null);
    }

    public static String toString(JSONArray jSONArray) throws JSONException {
        int i;
        String string;
        StringBuffer stringBuffer = new StringBuffer();
        String string2 = jSONArray.getString(0);
        XML.noSpace(string2);
        String strEscape = XML.escape(string2);
        stringBuffer.append('<');
        stringBuffer.append(strEscape);
        Object objOpt = jSONArray.opt(1);
        if (objOpt instanceof JSONObject) {
            i = 2;
            JSONObject jSONObject = (JSONObject) objOpt;
            Iterator itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String string3 = itKeys.next().toString();
                XML.noSpace(string3);
                String strOptString = jSONObject.optString(string3);
                if (strOptString != null) {
                    stringBuffer.append(' ');
                    stringBuffer.append(XML.escape(string3));
                    stringBuffer.append('=');
                    stringBuffer.append('\"');
                    stringBuffer.append(XML.escape(strOptString));
                    stringBuffer.append('\"');
                }
            }
        } else {
            i = 1;
        }
        int length = jSONArray.length();
        if (i >= length) {
            stringBuffer.append('/');
        } else {
            stringBuffer.append('>');
            do {
                Object obj = jSONArray.get(i);
                i++;
                if (obj != null) {
                    if (obj instanceof String) {
                        string = XML.escape(obj.toString());
                    } else if (obj instanceof JSONObject) {
                        string = toString((JSONObject) obj);
                    } else if (obj instanceof JSONArray) {
                        string = toString((JSONArray) obj);
                    }
                    stringBuffer.append(string);
                }
            } while (i < length);
            stringBuffer.append('<');
            stringBuffer.append('/');
            stringBuffer.append(strEscape);
        }
        stringBuffer.append('>');
        return stringBuffer.toString();
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        String string;
        StringBuffer stringBuffer = new StringBuffer();
        String strOptString = jSONObject.optString("tagName");
        if (strOptString == null) {
            return XML.escape(jSONObject.toString());
        }
        XML.noSpace(strOptString);
        String strEscape = XML.escape(strOptString);
        stringBuffer.append('<');
        stringBuffer.append(strEscape);
        Iterator itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String string2 = itKeys.next().toString();
            if (!string2.equals("tagName") && !string2.equals("childNodes")) {
                XML.noSpace(string2);
                String strOptString2 = jSONObject.optString(string2);
                if (strOptString2 != null) {
                    stringBuffer.append(' ');
                    stringBuffer.append(XML.escape(string2));
                    stringBuffer.append('=');
                    stringBuffer.append('\"');
                    stringBuffer.append(XML.escape(strOptString2));
                    stringBuffer.append('\"');
                }
            }
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childNodes");
        if (jSONArrayOptJSONArray == null) {
            stringBuffer.append('/');
        } else {
            stringBuffer.append('>');
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                Object obj = jSONArrayOptJSONArray.get(i);
                if (obj != null) {
                    if (obj instanceof String) {
                        string = XML.escape(obj.toString());
                    } else if (obj instanceof JSONObject) {
                        string = toString((JSONObject) obj);
                    } else if (obj instanceof JSONArray) {
                        string = toString((JSONArray) obj);
                    }
                    stringBuffer.append(string);
                }
            }
            stringBuffer.append('<');
            stringBuffer.append('/');
            stringBuffer.append(strEscape);
        }
        stringBuffer.append('>');
        return stringBuffer.toString();
    }
}
