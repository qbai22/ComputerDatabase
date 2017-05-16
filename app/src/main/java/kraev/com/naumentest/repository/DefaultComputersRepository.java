package kraev.com.naumentest.repository;

import android.support.annotation.NonNull;

import java.util.List;


import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kraev.com.naumentest.api.ComputersService;
import kraev.com.naumentest.content.Computer;
import kraev.com.naumentest.content.ComputersResponse;
import kraev.com.naumentest.content.InfoResponse;
import kraev.com.naumentest.content.SimilarModelsResponse;

/**
 * Created by Vladimir Kraev
 */

public class DefaultComputersRepository implements ComputersRepository {

    private final ComputersService mComputersService;
    private final SharedPreferencesHelper mPreferencesHelper;

    public DefaultComputersRepository(@NonNull ComputersService computersService,
                                      SharedPreferencesHelper preferencesHelper) {
        mComputersService = computersService;
        mPreferencesHelper = preferencesHelper;
    }

    @NonNull
    @Override
    public Observable<ComputersResponse> computersList(int page) {
        return mComputersService.getComputersList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @NonNull
    @Override
    public Observable<InfoResponse> info(int modelId) {
        return mComputersService.getComputerInfo(modelId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @NonNull
    @Override
    public Observable<List<SimilarModelsResponse>> similarModels(int id) {
        return mComputersService.getSimilarModels(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    @Override
    public int getCurrentPage() {
        return mPreferencesHelper.getCurrentPage();
    }

    @Override
    public void setCurrentPage(int page) {
        mPreferencesHelper.setCurrentPage(page);
    }

    @Override
    public int getTotalPages() {
        return mPreferencesHelper.getTotalPages();
    }

    @Override
    public void setTotalPages(int total) {
        mPreferencesHelper.setTotalPages(total);
    }
}
