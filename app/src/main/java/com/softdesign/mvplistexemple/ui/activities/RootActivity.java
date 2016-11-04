package com.softdesign.mvplistexemple.ui.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.softdesign.mvplistexemple.BuildConfig;
import com.softdesign.mvplistexemple.R;
import com.softdesign.mvplistexemple.di.DaggerService;
import com.softdesign.mvplistexemple.di.scope.RootScope;
import com.softdesign.mvplistexemple.mvp.presenters.RootPresenter;
import com.softdesign.mvplistexemple.mvp.views.IRootView;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.Provides;

public class RootActivity extends AppCompatActivity implements IRootView, View.OnClickListener {
    @BindView(R.id.coordinator_container)
    CoordinatorLayout mCoordinatorLayout;

    @Inject
    RootPresenter mRootPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        Component component = DaggerService.getComponent(Component.class);
        if (component == null) {
            component = createDaggerComponent();
        }
        component.inject(this);
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showError(Throwable e) {
        if (BuildConfig.DEBUG) {
            showMessage(e.getMessage());
            e.printStackTrace();
        } else {
            showMessage(getString(R.string.error_message));
            // TODO: 17.10.2016 send error stacktrace to crashlytics
        }
    }

    @Override
    public void showLoad() {

    }

    @Override
    public void hideLoad() {

    }

    @Override
    public void showItemList() {

    }

    private Component createDaggerComponent() {
        return DaggerRootActivity_Component.builder()
                .module(new Module())
                .build();
    }

    @Override
    public void onClick(View v) {

    }

    @dagger.Component(modules = Module.class)
    @RootScope
    public interface Component {
        void inject(RootActivity activity);
    }

    @dagger.Module
    public class Module {
        @Provides
        @RootScope
        RootPresenter provideRootPresenter() {
            return new RootPresenter();
        }
    }


}
