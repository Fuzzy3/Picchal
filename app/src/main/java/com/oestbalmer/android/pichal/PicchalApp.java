package com.oestbalmer.android.pichal;

import android.app.Application;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.oestbalmer.android.pichal.Authenticatation.AuthActivity;


public class PicchalApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        checkIfUserIsLoggedIn();

    }

    private void checkIfUserIsLoggedIn() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) { //Already signed in
            Toast.makeText(this, "User is already signed in", Toast.LENGTH_SHORT).show();
        } else { //Not signed in
            Toast.makeText(this, "User is not signed in", Toast.LENGTH_SHORT).show();
            startActivity(AuthActivity.newIntent(this));
        }
    }

}
