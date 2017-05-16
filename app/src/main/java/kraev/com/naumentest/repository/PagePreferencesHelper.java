package kraev.com.naumentest.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Inject;

/**
 * Created by Vladimir Kraev
 */

public class PagePreferencesHelper implements SharedPreferencesHelper {

    private static final String PREF_KEY_CURRENT_PAGE = "PREF_KEY_CURRENT_PAGE";
    private static final String PREF_KEY_TOTAL_PAGES = "PREF_KEY_TOTAL_PAGES";
    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_TOTAL = 1;

    private final SharedPreferences mSharedPreferences;

    public PagePreferencesHelper(Context context){
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public int getCurrentPage() {
        return mSharedPreferences.getInt(PREF_KEY_CURRENT_PAGE, DEFAULT_PAGE);
    }

    @Override
    public void setCurrentPage(int page) {
        mSharedPreferences.edit().putInt(PREF_KEY_CURRENT_PAGE, page).apply();
    }

    @Override
    public int getTotalPages() {
        return mSharedPreferences.getInt(PREF_KEY_TOTAL_PAGES, DEFAULT_TOTAL);
    }

    @Override
    public void setTotalPages(int total) {
        mSharedPreferences.edit().putInt(PREF_KEY_TOTAL_PAGES, total).apply();
    }
}
