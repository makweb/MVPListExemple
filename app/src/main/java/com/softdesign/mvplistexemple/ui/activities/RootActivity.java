package com.softdesign.mvplistexemple.ui.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.softdesign.mvplistexemple.BuildConfig;
import com.softdesign.mvplistexemple.R;
import com.softdesign.mvplistexemple.data.models.dto.UserDto;
import com.softdesign.mvplistexemple.di.DaggerService;
import com.softdesign.mvplistexemple.di.scope.RootScope;
import com.softdesign.mvplistexemple.mvp.presenters.RootPresenter;
import com.softdesign.mvplistexemple.mvp.views.IRootView;
import com.softdesign.mvplistexemple.ui.adapters.ItemsAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Provides;

public class RootActivity extends AppCompatActivity implements IRootView{
    @BindView(R.id.coordinator_container)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.item_list)
    RecyclerView mItemList;

    @Inject
    RootPresenter mRootPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        ButterKnife.bind(this);
        Component component = DaggerService.getComponent(Component.class);
        if (component == null) {
            component = createDaggerComponent();
        }
        component.inject(this);
        mRootPresenter.takeView(this);
        mRootPresenter.initView();
    }

    @Override
    protected void onDestroy() {
        mRootPresenter.dropView();
        super.onDestroy();
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
    public void showItemList(List<UserDto> usersList) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        ItemsAdapter adapter = new ItemsAdapter(usersList, new ItemsAdapter.ItemViewHolder.ICustomClickListener() {
            @Override
            public void onItemClicked(int position, View view) {
                switch (view.getId()) {
                    case R.id.text_wrapper:
                        mRootPresenter.clickOnUserText(position);
                        break;
                    case R.id.abbreviation_txt:
                        mRootPresenter.clickOnAbbreviation(position);
                        break;
                }
            }
        });
        mItemList.setLayoutManager(llm);
        mItemList.setAdapter(adapter);
    }

    private Component createDaggerComponent() {
        return DaggerRootActivity_Component.builder()
                .module(new Module())
                .build();
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
