package com.oestbalmer.android.pichal.Authenticatation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.oestbalmer.android.pichal.R;
import com.oestbalmer.android.pichal.UploadImage.ImageActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthActivity extends AppCompatActivity implements IAuthActivity {

    @BindView(R.id.auth_button) Button mAuthButton;

    private static final int AUTHENTICATION_CODE = 1234;
    private IAuthPresenter mAuthPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        mAuthPresenter = new AuthPresenter(this, new AuthService());
        ButterKnife.bind(this);
    }


    @OnClick(R.id.auth_button)
    public void onAuthButtonClicked() {
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), AUTHENTICATION_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == AUTHENTICATION_CODE) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                mAuthPresenter.createCurrentUser();
                return;
            } else {
                if(response == null) {
                    Toast.makeText(this, "Authentication was canceled", Toast.LENGTH_SHORT).show();
                }
                if (response.getErrorCode() == ErrorCodes.NO_NETWORK) {
                    Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(response.getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                    Toast.makeText(this, "Some error occured, try again", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }
    }


    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, AuthActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return i;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void authenticated() {
        startActivity(ImageActivity.newIntentClearActivityHistory(this));
        finish();
    }
}
