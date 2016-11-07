package com.softdesign.mvplistexemple.mvp.models;

import com.softdesign.mvplistexemple.data.managers.DataManager;
import com.softdesign.mvplistexemple.di.DaggerService;
import com.softdesign.mvplistexemple.di.components.DaggerModelComponent;
import com.softdesign.mvplistexemple.di.components.ModelComponent;
import com.softdesign.mvplistexemple.di.modules.ModelModule;

import javax.inject.Inject;

/**
 * Created by Makweb on 07.11.2016.
 */

public class AbstractModel {
    @Inject
    DataManager mDataManager;

    public AbstractModel() {
        ModelComponent component = DaggerService.getComponent(ModelComponent.class);
        if (component == null) {
            component = createDaggerComponent();
            DaggerService.registerComponent(ModelComponent.class, component);
        }
        component.inject(this);

    }

    private ModelComponent createDaggerComponent() {
        return DaggerModelComponent.builder()
                .modelModule(new ModelModule())
                .build();
    }
}
