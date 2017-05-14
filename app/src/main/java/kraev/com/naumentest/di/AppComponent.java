package kraev.com.naumentest.di;



import javax.inject.Singleton;

import dagger.Component;
import kraev.com.naumentest.screen.computers.ComputerListActivity;

/**
 * Created by Vladimir Kraev
 */

@Singleton
@Component(modules = {DataModule.class})
public interface AppComponent {

    void injectComputerListActivity(ComputerListActivity computerListActivity);

}
