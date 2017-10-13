package com.oestbalmer.android.pichal.Services;



public interface IImageService {

    void uploadImage(String URI);

    void shareImageBetweenTwoUsers(String imageURI, String userId1, String userId2);



}
