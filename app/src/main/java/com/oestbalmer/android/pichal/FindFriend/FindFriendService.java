package com.oestbalmer.android.pichal.FindFriend;


import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.ValueEventListener;
import com.oestbalmer.android.pichal.DatabaseService;
import com.oestbalmer.android.pichal.Model.User;

import java.util.ArrayList;
import java.util.List;

public class FindFriendService extends DatabaseService implements IFindFriendService {

    private final String TAG = getClass().getCanonicalName();


    @Override
    public void getAllUsers(final onUsersFoundListener listener) {
        Log.i(TAG, "GETTING ALL USERS");
        final List<User> listOfAllUsers = new ArrayList<>();
        mUsersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()) {
                    User user = data.getValue(User.class);
                    listOfAllUsers.add(user);
                }
                listener.onFinished(listOfAllUsers);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }
}
