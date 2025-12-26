package com.a.a.d.a;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class i extends g<InputStream> {
    private static final UriMatcher a = new UriMatcher(-1);

    static {
        a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        a.addURI("com.android.contacts", "contacts/#/photo", 2);
        a.addURI("com.android.contacts", "contacts/#", 3);
        a.addURI("com.android.contacts", "contacts/#/display_photo", 4);
    }

    public i(Context context, Uri uri) {
        super(context, uri);
    }

    @TargetApi(14)
    private InputStream a(ContentResolver contentResolver, Uri uri) {
        return Build.VERSION.SDK_INT < 14 ? ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri) : ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    private InputStream a(Uri uri, ContentResolver contentResolver, int i) throws FileNotFoundException {
        if (i != 1 && i != 3) {
            return contentResolver.openInputStream(uri);
        }
        if (i == 1 && (uri = ContactsContract.Contacts.lookupContact(contentResolver, uri)) == null) {
            throw new FileNotFoundException("Contact cannot be found");
        }
        return a(contentResolver, uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.d.a.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InputStream b(Uri uri, ContentResolver contentResolver) {
        return a(uri, contentResolver, a.match(uri));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.d.a.g
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }
}
