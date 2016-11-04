package com.softdesign.mvplistexemple.mvp.presenters;

import android.support.annotation.Nullable;

import com.softdesign.mvplistexemple.mvp.views.IView;


/**
 * Created by Makweb on 25.10.2016.
 */

public abstract class AbstractPresenter<T extends IView> {
    private T mView;

    public void takeView(T view) {
        mView = view;
    }

    public void dropView() {
        mView = null;
    }

    public abstract void initView();

    @Nullable
    public T getView() {
        return mView;
    }
}
