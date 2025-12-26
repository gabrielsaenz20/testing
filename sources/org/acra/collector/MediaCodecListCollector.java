package org.acra.collector;

import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* loaded from: classes.dex */
public class MediaCodecListCollector {
    private static final String COLOR_FORMAT_PREFIX = "COLOR_";
    private static Class<?> codecCapabilitiesClass;
    private static Field colorFormatsField;
    private static Method getCapabilitiesForTypeMethod;
    private static Method getCodecInfoAtMethod;
    private static Method getNameMethod;
    private static Method getSupportedTypesMethod;
    private static Method isEncoderMethod;
    private static Field levelField;
    private static Class<?> mediaCodecInfoClass;
    private static Class<?> mediaCodecListClass;
    private static Field profileField;
    private static Field profileLevelsField;
    private static final String[] MPEG4_TYPES = {"mp4", "mpeg4", "MP4", "MPEG4"};
    private static final String[] AVC_TYPES = {"avc", "h264", "AVC", "H264"};
    private static final String[] H263_TYPES = {"h263", "H263"};
    private static final String[] AAC_TYPES = {"aac", "AAC"};
    private static SparseArray<String> mColorFormatValues = new SparseArray<>();
    private static SparseArray<String> mAVCLevelValues = new SparseArray<>();
    private static SparseArray<String> mAVCProfileValues = new SparseArray<>();
    private static SparseArray<String> mH263LevelValues = new SparseArray<>();
    private static SparseArray<String> mH263ProfileValues = new SparseArray<>();
    private static SparseArray<String> mMPEG4LevelValues = new SparseArray<>();
    private static SparseArray<String> mMPEG4ProfileValues = new SparseArray<>();
    private static SparseArray<String> mAACProfileValues = new SparseArray<>();

    private enum CodecType {
        AVC,
        H263,
        MPEG4,
        AAC
    }

    static {
        SparseArray<String> sparseArray;
        int i;
        try {
            mediaCodecListClass = Class.forName("android.media.MediaCodecList");
            getCodecInfoAtMethod = mediaCodecListClass.getMethod("getCodecInfoAt", Integer.TYPE);
            mediaCodecInfoClass = Class.forName("android.media.MediaCodecInfo");
            getNameMethod = mediaCodecInfoClass.getMethod("getName", new Class[0]);
            isEncoderMethod = mediaCodecInfoClass.getMethod("isEncoder", new Class[0]);
            getSupportedTypesMethod = mediaCodecInfoClass.getMethod("getSupportedTypes", new Class[0]);
            getCapabilitiesForTypeMethod = mediaCodecInfoClass.getMethod("getCapabilitiesForType", String.class);
            codecCapabilitiesClass = Class.forName("android.media.MediaCodecInfo$CodecCapabilities");
            colorFormatsField = codecCapabilitiesClass.getField("colorFormats");
            profileLevelsField = codecCapabilitiesClass.getField("profileLevels");
            for (Field field : codecCapabilitiesClass.getFields()) {
                if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()) && field.getName().startsWith(COLOR_FORMAT_PREFIX)) {
                    mColorFormatValues.put(field.getInt(null), field.getName());
                }
            }
            Class<?> cls = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
            for (Field field2 : cls.getFields()) {
                if (Modifier.isStatic(field2.getModifiers()) && Modifier.isFinal(field2.getModifiers())) {
                    if (field2.getName().startsWith("AVCLevel")) {
                        sparseArray = mAVCLevelValues;
                        i = field2.getInt(null);
                    } else if (field2.getName().startsWith("AVCProfile")) {
                        sparseArray = mAVCProfileValues;
                        i = field2.getInt(null);
                    } else if (field2.getName().startsWith("H263Level")) {
                        sparseArray = mH263LevelValues;
                        i = field2.getInt(null);
                    } else if (field2.getName().startsWith("H263Profile")) {
                        sparseArray = mH263ProfileValues;
                        i = field2.getInt(null);
                    } else if (field2.getName().startsWith("MPEG4Level")) {
                        sparseArray = mMPEG4LevelValues;
                        i = field2.getInt(null);
                    } else if (field2.getName().startsWith("MPEG4Profile")) {
                        sparseArray = mMPEG4ProfileValues;
                        i = field2.getInt(null);
                    } else if (field2.getName().startsWith("AAC")) {
                        sparseArray = mAACProfileValues;
                        i = field2.getInt(null);
                    }
                    sparseArray.put(i, field2.getName());
                }
            }
            profileField = cls.getField("profile");
            levelField = cls.getField("level");
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException unused) {
        }
    }

    public static String collecMediaCodecList() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        StringBuilder sb = new StringBuilder();
        if (mediaCodecListClass != null && mediaCodecInfoClass != null) {
            try {
                int iIntValue = ((Integer) mediaCodecListClass.getMethod("getCodecCount", new Class[0]).invoke(null, new Object[0])).intValue();
                for (int i = 0; i < iIntValue; i++) {
                    sb.append("\n");
                    Object objInvoke = getCodecInfoAtMethod.invoke(null, Integer.valueOf(i));
                    sb.append(i);
                    sb.append(": ");
                    sb.append(getNameMethod.invoke(objInvoke, new Object[0]));
                    sb.append("\n");
                    sb.append("isEncoder: ");
                    sb.append(isEncoderMethod.invoke(objInvoke, new Object[0]));
                    sb.append("\n");
                    String[] strArr = (String[]) getSupportedTypesMethod.invoke(objInvoke, new Object[0]);
                    sb.append("Supported types: ");
                    sb.append(Arrays.toString(strArr));
                    sb.append("\n");
                    for (String str : strArr) {
                        sb.append(collectCapabilitiesForType(objInvoke, str));
                    }
                    sb.append("\n");
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String collectCapabilitiesForType(Object obj, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        SparseArray<String> sparseArray;
        String str2;
        StringBuilder sb = new StringBuilder();
        Object objInvoke = getCapabilitiesForTypeMethod.invoke(obj, str);
        int[] iArr = (int[]) colorFormatsField.get(objInvoke);
        if (iArr.length > 0) {
            sb.append(str);
            sb.append(" color formats:");
            for (int i = 0; i < iArr.length; i++) {
                sb.append(mColorFormatValues.get(iArr[i]));
                if (i < iArr.length - 1) {
                    sb.append(',');
                }
            }
            sb.append("\n");
        }
        Object[] objArr = (Object[]) profileLevelsField.get(objInvoke);
        if (objArr.length > 0) {
            sb.append(str);
            sb.append(" profile levels:");
            for (int i2 = 0; i2 < objArr.length; i2++) {
                CodecType codecTypeIdentifyCodecType = identifyCodecType(obj);
                int i3 = profileField.getInt(objArr[i2]);
                int i4 = levelField.getInt(objArr[i2]);
                if (codecTypeIdentifyCodecType == null) {
                    sb.append(i3);
                    sb.append('-');
                    sb.append(i4);
                }
                switch (codecTypeIdentifyCodecType) {
                    case AVC:
                        sb.append(i3);
                        sb.append(mAVCProfileValues.get(i3));
                        sb.append('-');
                        sparseArray = mAVCLevelValues;
                        str2 = sparseArray.get(i4);
                        break;
                    case H263:
                        sb.append(mH263ProfileValues.get(i3));
                        sb.append('-');
                        sparseArray = mH263LevelValues;
                        str2 = sparseArray.get(i4);
                        break;
                    case MPEG4:
                        sb.append(mMPEG4ProfileValues.get(i3));
                        sb.append('-');
                        sparseArray = mMPEG4LevelValues;
                        str2 = sparseArray.get(i4);
                        break;
                    case AAC:
                        str2 = mAACProfileValues.get(i3);
                        break;
                    default:
                        if (i2 >= objArr.length - 1) {
                            sb.append(',');
                        }
                }
                sb.append(str2);
                if (i2 >= objArr.length - 1) {
                }
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    private static CodecType identifyCodecType(Object obj) {
        String str = (String) getNameMethod.invoke(obj, new Object[0]);
        for (String str2 : AVC_TYPES) {
            if (str.contains(str2)) {
                return CodecType.AVC;
            }
        }
        for (String str3 : H263_TYPES) {
            if (str.contains(str3)) {
                return CodecType.H263;
            }
        }
        for (String str4 : MPEG4_TYPES) {
            if (str.contains(str4)) {
                return CodecType.MPEG4;
            }
        }
        for (String str5 : AAC_TYPES) {
            if (str.contains(str5)) {
                return CodecType.AAC;
            }
        }
        return null;
    }
}
