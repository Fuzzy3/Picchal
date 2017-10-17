package com.oestbalmer.android.pichal.UploadImage;


import com.oestbalmer.android.pichal.Model.User;

public interface IImageService {

    interface onImageUploaded {
        void imageUploaded();
    }

    interface onImageFethced {
        void imageFetched(String URI);
    }

    interface onImageShared {
        void imageShared();
    }


    void uploadImage(String URI, onImageUploaded listener);

    void fetchImage(String URI, onImageFethced listener);

    void shareImageWithUser(String imageURI, User otherUser, onImageShared listener);

}
