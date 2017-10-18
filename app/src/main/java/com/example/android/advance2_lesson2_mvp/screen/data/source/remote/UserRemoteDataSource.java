package com.example.android.advance2_lesson2_mvp.screen.data.source.remote;

import com.example.android.advance2_lesson2_mvp.screen.data.model.UserList;
import com.example.android.advance2_lesson2_mvp.screen.data.source.UserDataSource;
import com.example.android.advance2_lesson2_mvp.screen.data.source.remote.api.service.NameApi;
import retrofit2.Callback;

/**
 * Created by VinhTL on 18/10/2017.
 */

public class UserRemoteDataSource extends BaseRemoteDataSource implements UserDataSource.RemoteDataSource{

    public UserRemoteDataSource(NameApi nameApi) {
        super(nameApi);
    }

    @Override
    public void searchUsers(int limit, String keyWord, Callback<UserList> callback) {
        //TODO: add observale logic
        mNameApi.searchGithubUsers(limit, keyWord).enqueue(callback);
    }
}
