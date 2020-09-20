package com.example.myapplication;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import java.util.List;

public class UserPositionalDataSource extends PositionalDataSource<User> {

    public static final String TAG = UserPositionalDataSource.class.getSimpleName();
    private UserStorage userStorage;

    public UserPositionalDataSource(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<User> callback) {
        List<User> users = userStorage.getData(params.requestedStartPosition, params.requestedLoadSize);
        Log.d(TAG, "loadInitial: start position = " + params.requestedStartPosition +
                " loadSize = " + params.requestedLoadSize);
        callback.onResult(users, 0);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<User> callback) {
        List<User> users = userStorage.getData(params.startPosition,params.loadSize);
        Log.d(TAG, "loadInitial: start position = " + params.startPosition +
                " loadSize = " + params.loadSize);
        callback.onResult(users);
    }
}
