package com.example.android.advance2_lesson2_mvp.screen.data.source;

import com.example.android.advance2_lesson2_mvp.screen.data.UserRepository;
import com.example.android.advance2_lesson2_mvp.screen.data.model.UserList;
import com.example.android.advance2_lesson2_mvp.screen.data.source.remote.UserRemoteDataSource;
import retrofit2.Callback;

public class UserRepositoryImpl implements UserRepository {
    
    private UserDataSource.RemoteDataSource mRemoteDataSource;

    public UserRepositoryImpl(UserRemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    public void searchUsers(int limit, String keyWord, Callback<UserList> callback) {
        mRemoteDataSource.searchUsers(limit, keyWord, callback);
    }
}