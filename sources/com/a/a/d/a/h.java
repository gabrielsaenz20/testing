package com.a.a.d.a;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class h extends a<InputStream> {
    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.d.a.a
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.d.a.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InputStream a(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}
