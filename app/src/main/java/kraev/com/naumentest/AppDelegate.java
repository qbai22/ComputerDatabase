package kraev.com.naumentest;

import android.app.Application;

import dagger.internal.DaggerCollections;
import kraev.com.naumentest.di.AppComponent;
import kraev.com.naumentest.di.DaggerAppComponent;
import kraev.com.naumentest.di.DataModule;

/**
 * Created by Vladimir Kraev
 */

public class AppDelegate extends Application {

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = DaggerAppComponent.builder()
                .dataModule(new DataModule())
                .build();

    }

    public static AppComponent getAppComponent(){
        return sAppComponent;
    }
}
