package kraev.com.naumentest.api;

import android.support.annotation.NonNull;

import kraev.com.naumentest.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by qbai on 11.05.2017.
 */

public class ApiFactory {

    private static ComputersService sComputersService;

    @NonNull
    public static ComputersService getComputersService() {
        ComputersService service = sComputersService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = sComputersService;
                if (service == null) {
                    service = sComputersService = buildRetrofit().create(ComputersService.class);
                }
            }
        }
        return service;
    }

    @NonNull
    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
