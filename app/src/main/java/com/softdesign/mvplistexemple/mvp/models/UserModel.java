package com.softdesign.mvplistexemple.mvp.models;

import com.softdesign.mvplistexemple.data.models.dto.UserDto;

import java.util.List;

/**
 * Created by Makweb on 07.11.2016.
 */

public class UserModel extends AbstractModel{
    private List<UserDto> mUsersList;

    public List<UserDto> getUsersList() {
        mUsersList = mDataManager.getItemList();
        return mUsersList;
    }

    public UserDto getUserByPosition(int position) {
        return mUsersList.get(position);
    }
}
