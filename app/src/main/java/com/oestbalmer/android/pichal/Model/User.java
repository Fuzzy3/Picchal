package com.oestbalmer.android.pichal.Model;


public class User {

    private String mFullName;
    private String mId;
    private String mEmail;
    private String mSharedImageURI;
    private static final String mDefaultURI = "gs://pichal-63fbe.appspot.com/Photos/image:60834";

    public User (String fullname, String id, String email) {
        mFullName = fullname;
        mId = id;
        mEmail = email;
        if (mSharedImageURI == null) {
            mSharedImageURI = mDefaultURI;
        }
    }

    public User() {

    }

    public String getSharedImageURI() {
        return mSharedImageURI;
    }

    public void setSharedImageURI(String sharedImageURI) {
        mSharedImageURI = sharedImageURI;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }
}
