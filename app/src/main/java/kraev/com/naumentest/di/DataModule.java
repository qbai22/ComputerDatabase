package kraev.com.naumentest.di;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kraev.com.naumentest.api.ComputersService;
import kraev.com.naumentest.repository.ComputersRepository;
import kraev.com.naumentest.repository.DefaultComputersRepository;

/**
 * Created by qbai on 13.05.2017.
 */

@Module
public class DataModule {

    @Provides
    @Singleton
    ComputersRepository provideComputersRepository(
            @NonNull ComputersService computersService) {
        return new DefaultComputersRepository(computersService);
    }

}
