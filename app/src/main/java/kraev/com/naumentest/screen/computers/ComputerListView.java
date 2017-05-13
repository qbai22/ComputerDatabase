package kraev.com.naumentest.screen.computers;

import java.util.List;

import kraev.com.naumentest.content.Computer;

/**
 * Created by qbai on 13.05.2017.
 */

public interface ComputerListView {

    void showComputers(List<Computer> computers);

    void showError();

    void showProgress();

    void hideProgress();
}
