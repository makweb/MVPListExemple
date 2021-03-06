package com.softdesign.mvplistexemple.di.modules;

import com.softdesign.mvplistexemple.data.managers.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Makweb on 04.11.2016.
 */
@Module
public class DataManagerModule {
    @Provides
    @Singleton
    DataManager provideDataManger(){
        return new DataManager();
    }
}
