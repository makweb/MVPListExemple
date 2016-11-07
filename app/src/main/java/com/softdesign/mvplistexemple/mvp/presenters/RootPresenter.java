package com.softdesign.mvplistexemple.mvp.presenters;

import com.softdesign.mvplistexemple.di.DaggerService;
import com.softdesign.mvplistexemple.di.scope.RootScope;
import com.softdesign.mvplistexemple.mvp.models.UserModel;
import com.softdesign.mvplistexemple.mvp.views.IRootView;

import javax.inject.Inject;

import dagger.Provides;

/**
 * Created by Makweb on 04.11.2016.
 */
public class RootPresenter extends AbstractPresenter<IRootView> {

    @Inject
    protected UserModel mUserModel;


    public RootPresenter() {
        Component component = DaggerService.getComponent(Component.class);
        if (component == null){
            component = createUserComponent();
        }
        component.inject(this);
    }

    @Override
    public void initView() {
        if (getView() != null) {
            getView().showItemList(mUserModel.getUsersList());
        }
    }

    public void clickOnAbbreviation(int position) {
        if (getView() != null) {
            getView().showMessage("Click on User Avatar " + mUserModel.getUserByPosition(position).getFullName());
        }
    }

    public void clickOnUserText(int position) {
        if (getView() != null) {
            getView().showMessage("Click on User Text " + mUserModel.getUserByPosition(position).getFullName());
        }
    }





    //region ======================== DI ========================
    @dagger.Module
    public class Module {
        @Provides
        @RootScope
        UserModel provideUserModel() {
            return new UserModel();
        }
    }

    @dagger.Component(modules = Module.class)
    @RootScope
    public interface Component {
        void inject(RootPresenter presenter);
    }

    private Component createUserComponent() {
        return DaggerRootPresenter_Component.builder()
                .module(new Module())
                .build();
    }
    //endregion

}
