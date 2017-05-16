package kraev.com.naumentest.di;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kraev.com.naumentest.BuildConfig;
import kraev.com.naumentest.api.ComputersService;
import kraev.com.naumentest.repository.ComputersRepository;
import kraev.com.naumentest.repository.DefaultComputersRepository;
import kraev.com.naumentest.repository.PagePreferencesHelper;
import kraev.com.naumentest.repository.SharedPreferencesHelper;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vladimir Kraev
 */

@Module
public class DataModule {

    private final Application mApplication;

    public DataModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    ComputersRepository provideComputersRepository(
            @NonNull ComputersService computersService,
            @NonNull SharedPreferencesHelper preferencesHelper) {
        return new DefaultComputersRepository(computersService, preferencesHelper);
    }

    @Provides
    @Singleton
    ComputersService provideComputersService(@NonNull Retrofit retrofit) {
        return retrofit.create(ComputersService.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    SharedPreferencesHelper provideSharedPreferencesHelper(@NonNull Context context) {
        return new PagePreferencesHelper(context);
    }
}
