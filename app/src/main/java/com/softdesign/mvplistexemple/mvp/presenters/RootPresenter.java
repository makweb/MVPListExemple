package com.softdesign.mvplistexemple.mvp.presenters;

import com.softdesign.mvplistexemple.mvp.views.IRootView;

/**
 * Created by Makweb on 04.11.2016.
 */
public class RootPresenter extends AbstractPresenter<IRootView>{
    @Override
    public void initView() {
        getView().showItemList();
    }
}
