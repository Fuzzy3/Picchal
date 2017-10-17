package com.oestbalmer.android.pichal.FindFriend;

import com.oestbalmer.android.pichal.Model.User;

import java.util.List;



public interface IFindFriendActivity {

    void showToast(String msg);

    void updateListModel(List<User> list);

}
