package com.softdesign.mvplistexemple.di.components;

import com.softdesign.mvplistexemple.data.managers.DataManger;
import com.softdesign.mvplistexemple.di.modules.DataManagerModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Makweb on 04.11.2016.
 */
@Component(/*dependencies = App.Component.class,*/ modules = DataManagerModule.class)
@Singleton
public interface DataManagerComponent {
    void inject (DataManger dataManager);
}
