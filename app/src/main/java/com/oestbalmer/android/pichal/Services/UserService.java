package com.oestbalmer.android.pichal.Services;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.oestbalmer.android.pichal.Model.User;

import java.util.ArrayList;
import java.util.List;
/*
public class UserService {

    //private IView mView;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mUsersRef;


    public UserService() {

        mDatabase = FirebaseDatabase.getInstance();
        mUsersRef = mDatabase.getReference().child("users");
    }

    @Override
    public void updateUserById(String id) {
        DatabaseReference mSingleUserRef = mUsersRef.child(id);

    }

    @Override
    public void createOrUpdateUserById(User user) {
        DatabaseReference mSingleUserRef = mUsersRef.child(user.getId());
        mSingleUserRef.setValue(user);
    }

    @Override
    public void getUserById(String id) {

    }


    @Override
    public boolean userExistById(String id) {
        return false;
    }

    @Override
    public void deleteUserById(String id) {

    }

    @Override
    public void createUser() {

    }

    @Override
    public List<User> getUsersWithName(String name) {
        Query query = mUsersRef.orderByChild("fullName").startAt(name);
        final List<User> userList = new ArrayList<>();
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()) {
                    User user = data.getValue(User.class);
                    userList.add(user);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return userList;
    }

    /*@Override
    public void createCurrentUser() {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser != null) {
            User user = new User(firebaseUser.getDisplayName(), firebaseUser.getUid(), firebaseUser.getEmail());
            createOrUpdateUserById(user);
        }
        mView.modelUpdated();
    }*/
/*
    @Override
    public List<User> getAllUsers() {
        final List<User> listOfAllUsers = new ArrayList<>();
        mUsersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()) {
                    User user = data.getValue(User.class);
                    listOfAllUsers.add(user);
                }

            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

        return listOfAllUsers;
    }
}
*/