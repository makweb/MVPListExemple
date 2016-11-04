package com.softdesign.mvplistexemple.mvp.views;

/**
 * Created by Makweb on 04.11.2016.
 */
public interface IRootView extends IView {
    void showMessage(String message);
    void showError(Throwable e);

    void showLoad();
    void hideLoad();

    void showItemList();
}
