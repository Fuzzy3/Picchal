package com.oestbalmer.android.pichal.FindFriend;


import android.util.Log;

import com.oestbalmer.android.pichal.Model.User;

import java.util.List;

public class FindFriendPresenter implements IFindFriendPresenter, IFindFriendService.onUsersFoundListener {

    IFindFriendService mFindFriendService;
    IFindFriendActivity mFindFriendActivity;

    public FindFriendPresenter(IFindFriendActivity view, IFindFriendService database) {
        mFindFriendActivity = view;
        mFindFriendService = database;
    }


    @Override
    public void onFinished(List<User> list) {
        Log.i("TEST", "FOund this many users: " + list.size());
        mFindFriendActivity.showToast(list.size() + " Users found");
        mFindFriendActivity.updateListModel(list);
    }


    @Override
    public void getAllUsers() {
        mFindFriendService.getAllUsers(this);
    }
}
