package com.oestbalmer.android.pichal.Model;


public class User {

    private String mFullName;
    private String mId;
    private String mEmail;

    public User (String fullname, String id, String email) {
        mFullName = fullname;
        mId = id;
        mEmail = email;
    }

    public User() {

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
