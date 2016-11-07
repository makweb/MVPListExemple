package com.softdesign.mvplistexemple.di.components;


import com.softdesign.mvplistexemple.di.modules.ModelModule;
import com.softdesign.mvplistexemple.mvp.models.AbstractModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Makweb on 01.11.2016.
 */

@Component(modules = ModelModule.class)
@Singleton
public interface ModelComponent {
    void inject(AbstractModel abstractModel);
}
