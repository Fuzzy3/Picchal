package com.oestbalmer.android.pichal.FindFriend;


import com.oestbalmer.android.pichal.Model.User;

import java.util.List;

public interface IFindFriendService {


    interface onUsersFoundListener {
        void onFinished(List<User> list);
    }

    void getAllUsers(onUsersFoundListener listener);


}
