package com.oestbalmer.android.pichal.Authenticatation;


public interface IAuthService {

    interface onUserCreated {
        void onFinished();
    }

    void createUser(IAuthService.onUserCreated listener);

}
