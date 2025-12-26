package com.a.a.d.b.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@TargetApi(19)
/* loaded from: classes.dex */
public class i implements g {
    private static final Bitmap.Config[] a = {Bitmap.Config.ARGB_8888, null};
    private static final Bitmap.Config[] b = {Bitmap.Config.RGB_565};
    private static final Bitmap.Config[] c = {Bitmap.Config.ARGB_4444};
    private static final Bitmap.Config[] d = {Bitmap.Config.ALPHA_8};
    private final b e = new b();
    private final e<a, Bitmap> f = new e<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> g = new HashMap();

    /* renamed from: com.a.a.d.b.a.i$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Bitmap.Config.values().length];

        static {
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static final class a implements h {
        private final b a;
        private int b;
        private Bitmap.Config c;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // com.a.a.d.b.a.h
        public void a() {
            this.a.a(this);
        }

        public void a(int i, Bitmap.Config config) {
            this.b = i;
            this.c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b != aVar.b) {
                return false;
            }
            if (this.c == null) {
                if (aVar.c != null) {
                    return false;
                }
            } else if (!this.c.equals(aVar.c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (31 * this.b) + (this.c != null ? this.c.hashCode() : 0);
        }

        public String toString() {
            return i.b(this.b, this.c);
        }
    }

    static class b extends com.a.a.d.b.a.b<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.a.a.d.b.a.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a(this);
        }

        public a a(int i, Bitmap.Config config) {
            a aVarC = c();
            aVarC.a(i, config);
            return aVarC;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a a(a aVar, int i, Bitmap.Config config) {
        Bitmap.Config[] configArrB = b(config);
        int length = configArrB.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            Bitmap.Config config2 = configArrB[i2];
            Integer numCeilingKey = a(config2).ceilingKey(Integer.valueOf(i));
            if (numCeilingKey == null || numCeilingKey.intValue() > i * 8) {
                i2++;
            } else if (numCeilingKey.intValue() != i || (config2 != null ? !config2.equals(config) : config != null)) {
                this.e.a(aVar);
                return this.e.a(numCeilingKey.intValue(), config2);
            }
        }
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.g.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.g.put(config, treeMap);
        return treeMap;
    }

    private void a(Integer num, Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMapA = a(config);
        Integer num2 = (Integer) navigableMapA.get(num);
        if (num2.intValue() == 1) {
            navigableMapA.remove(num);
        } else {
            navigableMapA.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Bitmap.Config[] b(Bitmap.Config config) {
        switch (AnonymousClass1.a[config.ordinal()]) {
            case 1:
                return a;
            case 2:
                return b;
            case 3:
                return c;
            case 4:
                return d;
            default:
                return new Bitmap.Config[]{config};
        }
    }

    @Override // com.a.a.d.b.a.g
    public Bitmap a() {
        Bitmap bitmapA = this.f.a();
        if (bitmapA != null) {
            a(Integer.valueOf(com.a.a.j.h.a(bitmapA)), bitmapA.getConfig());
        }
        return bitmapA;
    }

    @Override // com.a.a.d.b.a.g
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        int iA = com.a.a.j.h.a(i, i2, config);
        Bitmap bitmapA = this.f.a((e<a, Bitmap>) a(this.e.a(iA, config), iA, config));
        if (bitmapA != null) {
            a(Integer.valueOf(com.a.a.j.h.a(bitmapA)), bitmapA.getConfig());
            bitmapA.reconfigure(i, i2, bitmapA.getConfig() != null ? bitmapA.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return bitmapA;
    }

    @Override // com.a.a.d.b.a.g
    public void a(Bitmap bitmap) {
        a aVarA = this.e.a(com.a.a.j.h.a(bitmap), bitmap.getConfig());
        this.f.a(aVarA, bitmap);
        NavigableMap<Integer, Integer> navigableMapA = a(bitmap.getConfig());
        Integer num = (Integer) navigableMapA.get(Integer.valueOf(aVarA.b));
        navigableMapA.put(Integer.valueOf(aVarA.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.a.a.d.b.a.g
    public String b(int i, int i2, Bitmap.Config config) {
        return b(com.a.a.j.h.a(i, i2, config), config);
    }

    @Override // com.a.a.d.b.a.g
    public String b(Bitmap bitmap) {
        return b(com.a.a.j.h.a(bitmap), bitmap.getConfig());
    }

    @Override // com.a.a.d.b.a.g
    public int c(Bitmap bitmap) {
        return com.a.a.j.h.a(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.g.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.g.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
