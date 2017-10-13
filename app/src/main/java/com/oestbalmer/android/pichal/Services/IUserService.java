package com.oestbalmer.android.pichal.Services;


import com.oestbalmer.android.pichal.Model.User;

import java.util.List;

public interface IUserService {

    void updateUserById(String id);

    void createOrUpdateUserById(User user);

    void getUserById(String id);

    boolean userExistById(String id);

    void deleteUserById(String id);

    public void createUser();

    List<User> getUsersWithName(String name);

    List<User> getAllUsers();

    void createCurrentUser();

}
