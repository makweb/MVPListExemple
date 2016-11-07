package com.softdesign.mvplistexemple.mvp.views;

import com.softdesign.mvplistexemple.data.models.dto.UserDto;

import java.util.List;

/**
 * Created by Makweb on 04.11.2016.
 */
public interface IRootView extends IView {
    void showMessage(String message);
    void showError(Throwable e);

    void showLoad();
    void hideLoad();

    void showItemList(List<UserDto> usersList);
}
