package kraev.com.naumentest.screen.computers;

import java.util.List;

import kraev.com.naumentest.content.Computer;
import kraev.com.naumentest.screen.general.ProgressView;

/**
 * Created by Vladimir Kraev
 */

public interface ComputerListView extends ProgressView{

    void showComputers(List<Computer> computers);

    void showError();

    void navigateToInfoActivity(int id);

    void nextButtonClicked();

    void previousButtonClicked();
}
