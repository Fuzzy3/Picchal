package com.oestbalmer.android.pichal.Services;


import com.oestbalmer.android.pichal.IView;

public class ImageService implements IImageService {

    private IView mView;


    public ImageService(IView view) {
        mView = view;

    }


    @Override
    public void uploadImage(String URI) {

    }

    @Override
    public void shareImageBetweenTwoUsers(String imageURI, String userId1, String userId2) {

    }
}
