package kraev.com.naumentest.di;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kraev.com.naumentest.BuildConfig;
import kraev.com.naumentest.api.ComputersService;
import kraev.com.naumentest.repository.ComputersRepository;
import kraev.com.naumentest.repository.DefaultComputersRepository;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vladimir Kraev
 */

@Module
public class DataModule {

    @Provides
    @Singleton
    ComputersRepository provideComputersRepository(
            @NonNull ComputersService computersService) {
        return new DefaultComputersRepository(computersService);
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
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
