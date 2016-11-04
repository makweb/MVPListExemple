package com.softdesign.mvplistexemple;

import android.app.Application;

/**
 * Created by Makweb on 04.11.2016.
 */

public class App extends Application{
    //private static App.Component sComponent;

   /* public static Component getComponent() {
        return sComponent;
    }*/

    @Override
    public void onCreate() {
        super.onCreate();
        //createAppComponent();
    }

   /* private void createAppComponent() {
        sComponent = DaggerApp_Component.builder().build();
    }

    @dagger.Component
    //@AppScope
    public interface Component {
    }

    @dagger.Module
    public class AppModule {
        Context mContext;

        public AppModule(Context context) {
            mContext = context;
        }

        @Provides
        //@AppScope
        Context provideContext(){
            return mContext;
        }
    }
*/
}
