package com.oestbalmer.android.pichal;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public abstract class DatabaseService {


    protected FirebaseDatabase mDatabase;
    protected DatabaseReference mUsersRef;

    public DatabaseService() {
        mDatabase = FirebaseDatabase.getInstance();
        mUsersRef = mDatabase.getReference().child("users");
    }

}
