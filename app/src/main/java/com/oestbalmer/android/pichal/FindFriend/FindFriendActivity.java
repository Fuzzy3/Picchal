package com.oestbalmer.android.pichal.FindFriend;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.oestbalmer.android.pichal.Model.User;
import com.oestbalmer.android.pichal.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindFriendActivity extends AppCompatActivity implements IFindFriendActivity {

    @BindView(R.id.user_list_recycleview) RecyclerView mUserRecyclerView;
    private UserListAdapter mAdapter;
    private List<User> mAllUsers;
    private IFindFriendPresenter mFindFriendPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_friend);
        mFindFriendPresenter = new FindFriendPresenter(this, new FindFriendService());
        setupView();
    }

    private void setupView() {
        ButterKnife.bind(this);
        mAllUsers = new ArrayList<>();
        mFindFriendPresenter.getAllUsers();
    }

    private void updateUI() {
        if(mAdapter == null) {
            mUserRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mAdapter = new UserListAdapter();
            mUserRecyclerView.setAdapter(mAdapter);
        }
        mAdapter.setAllUsersList(mAllUsers);
        mAdapter.notifyDataSetChanged();
    }


    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, FindFriendActivity.class);
        return i;
    }

    @Override
    public void updateListModel(List<User> userList) {
        mAllUsers = userList;
        updateUI();
    }


    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.text_view_user_name) TextView usernameView;
        private String mUserId;

        public UserViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
        }

        public void bindUserViewHolder(String userId, String name) {
            mUserId = userId;
            usernameView.setText(name);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(FindFriendActivity.this, usernameView.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {
        List<User> allUsers;

        @Override
        public UserViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);

            return new UserViewHolder(view);
        }

        @Override
        public void onBindViewHolder(UserViewHolder userViewHolder, int i) {
            userViewHolder.bindUserViewHolder(allUsers.get(i).getId(), allUsers.get(i).getFullName());
        }

        public void setAllUsersList(List<User> users) {
            allUsers = users;
        }

        @Override
        public int getItemCount() {
            return allUsers.size();
        }
    }
}
