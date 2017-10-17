package com.oestbalmer.android.pichal;


import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public abstract class StorageService {

    protected StorageReference mStorageRef;
    protected StorageReference mPhotosRef;


    public StorageService() {
        mStorageRef = FirebaseStorage.getInstance().getReference();
        mPhotosRef = mStorageRef.child("Photos");
    }


}
