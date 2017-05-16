package kraev.com.naumentest.repository;

/**
 * Created by Vladimir Kraev
 */

public interface SharedPreferencesHelper {

    int getCurrentPage();

    void setCurrentPage(int page);

    int getTotalPages();

    void setTotalPages(int total);

}
