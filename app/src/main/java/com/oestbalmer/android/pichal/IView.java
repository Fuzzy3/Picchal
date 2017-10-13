package com.oestbalmer.android.pichal;


import com.oestbalmer.android.pichal.Model.User;

import java.util.List;

public interface IView {

    void modelUpdated();

    public interface FindFriendInterface {
        void updateListModel(List<User> userList);
    }


}
