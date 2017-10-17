package com.oestbalmer.android.pichal.Authenticatation;



public class AuthPresenter implements IAuthPresenter, IAuthService.onUserCreated {

    private IAuthActivity mAuthActivity;
    private IAuthService mAuthService;

    public AuthPresenter(AuthActivity authActivity, AuthService authService) {
        mAuthActivity = authActivity;
        mAuthService = authService;
    }

    @Override
    public void createCurrentUser() {
        mAuthService.createUser(this);
    }

    @Override
    public void onFinished() {
        mAuthActivity.authenticated();
    }
}
