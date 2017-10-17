package com.oestbalmer.android.pichal.Authenticatation;



import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.oestbalmer.android.pichal.DatabaseService;
import com.oestbalmer.android.pichal.Model.User;

public class AuthService extends DatabaseService implements IAuthService {


    @Override
    public void createUser(IAuthService.onUserCreated listener) {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser != null) {
            User user = new User(firebaseUser.getDisplayName(), firebaseUser.getUid(), firebaseUser.getEmail());
            DatabaseReference mSingleUserRef = mUsersRef.child(user.getId());
            mSingleUserRef.setValue(user);
            listener.onFinished();
        }
    }


}
