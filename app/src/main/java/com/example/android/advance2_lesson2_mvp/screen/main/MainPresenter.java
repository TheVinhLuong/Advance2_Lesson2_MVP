package com.example.android.advance2_lesson2_mvp.screen.main;

import android.util.Log;
import com.example.android.advance2_lesson2_mvp.screen.data.UserRepository;
import com.example.android.advance2_lesson2_mvp.screen.data.model.UserList;
import com.example.android.advance2_lesson2_mvp.screen.data.source.remote.api.error.BaseException;
import com.example.android.advance2_lesson2_mvp.screen.data.source.remote.api.error.Type;
import com.example.android.advance2_lesson2_mvp.screen.data.source.remote.api.response
        .ErrorResponse;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Listens to user actions from the UI ({@link MainActivity}), retrieves the data and updates
 * the UI as required.
 */
final class MainPresenter implements MainContract.Presenter {
    private static final String TAG = MainPresenter.class.getSimpleName();

    private UserRepository mUserRepository;
    private MainContract.View mView;

    public MainPresenter(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    @Override
    public void setView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

//    @Override
//    public boolean validateKeywordInput(String keyword) {
//        return false;
//    }
//
//    @Override
//    public boolean validateLimitNumberInput(String limit) {
//        return false;
//    }
//
//    @Override
//    public boolean validateDataInput(String keyword, String limit) {
//        return false;
//    }

    @Override
    public void searchUsers(int limit, String keyWord) {
        mUserRepository.searchUsers(limit, keyWord, new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, new Gson().toJson(response.body().getItems()));
                    mView.onSearchUsersSuccess(response.body().getItems());
                }else{
                    mView.onSearchError(new BaseException(Type.SERVER, new ErrorResponse("Lỗi server")));
                }
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                mView.onSearchError(new BaseException(Type.NETWORK, new ErrorResponse("Lỗi mạng")));
            }
        });
    }
}
