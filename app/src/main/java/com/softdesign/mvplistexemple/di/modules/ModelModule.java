package com.softdesign.mvplistexemple.di.modules;


import com.softdesign.mvplistexemple.data.managers.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Makweb on 01.11.2016.
 */
@Module
public class ModelModule {
    @Provides
    @Singleton
    DataManager provideDataManager(){
        return new DataManager();
    }
}
