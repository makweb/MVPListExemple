package com.softdesign.mvplistexemple.data.managers;

import com.softdesign.mvplistexemple.data.models.dto.UserDto;
import com.softdesign.mvplistexemple.di.DaggerService;
import com.softdesign.mvplistexemple.di.components.DaggerDataManagerComponent;
import com.softdesign.mvplistexemple.di.components.DataManagerComponent;
import com.softdesign.mvplistexemple.di.modules.DataManagerModule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makweb on 04.11.2016.
 */

public class DataManager {
    private List<UserDto> mUserList = new ArrayList<>();

    public DataManager() {
        DataManagerComponent component = DaggerService.getComponent(DataManagerComponent.class);
        if (component == null) {
            component = createDaggercomponent();
            DaggerService.registerComponent(DataManagerComponent.class, component);
        }
        component.inject(this);

        generateData();
    }

    private DataManagerComponent createDaggercomponent() {
        return DaggerDataManagerComponent.builder().dataManagerModule(new DataManagerModule()).build();
    }

    private List<UserDto> generateData() {
        mUserList.add(new UserDto(1, "Михаил", "Макеев", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "));
        mUserList.add(new UserDto(2, "Елена", "Космова", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "));
        mUserList.add(new UserDto(3, "Иван", "Золотарев", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "));
        mUserList.add(new UserDto(4, "Михаил", "Резниченко", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "));
        mUserList.add(new UserDto(5, "Дмитрий", "Сбродов", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "));
        mUserList.add(new UserDto(6, "Михаил", "Тетерин", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "));
        mUserList.add(new UserDto(7, "Александр", "Селезнев", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "));
        mUserList.add(new UserDto(8, "Сергей", "Куприн", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "));
        mUserList.add(new UserDto(9, "Владимир", "Полховцев", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "));
        mUserList.add(new UserDto(10, "Никита", "Иолас", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "));

        return mUserList;
    }

    public List<UserDto> getItemList() {

        return mUserList;
    }
}
