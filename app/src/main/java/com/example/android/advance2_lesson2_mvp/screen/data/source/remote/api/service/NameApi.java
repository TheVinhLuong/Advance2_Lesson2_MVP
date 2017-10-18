package com.example.android.advance2_lesson2_mvp.screen.data.source.remote.api.service;

import com.example.android.advance2_lesson2_mvp.screen.data.model.User;
import com.example.android.advance2_lesson2_mvp.screen.data.model.UserList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by VinhTL on 18/10/2017.
 */

public interface NameApi {
    @GET("/search/users")
    Call<UserList> searchGithubUsers(@Query("per_page") int limit,
            @Query("q") String searchTerm);
    
    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
}
