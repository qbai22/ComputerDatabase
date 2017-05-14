package kraev.com.naumentest.repository;

import android.support.annotation.NonNull;

import java.util.List;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kraev.com.naumentest.api.ComputersService;
import kraev.com.naumentest.content.Computer;
import kraev.com.naumentest.content.ComputersResponse;
import kraev.com.naumentest.content.InfoResponse;
import kraev.com.naumentest.content.SimilarModelsResponse;

/**
 * Created by qbai on 13.05.2017.
 */

public class DefaultComputersRepository implements ComputersRepository {

    private final ComputersService mComputersService;

    public DefaultComputersRepository(@NonNull ComputersService computersService) {
        mComputersService = computersService;
    }

    @NonNull
    @Override
    public Observable<List<Computer>> computersList(int page) {
        return mComputersService.getComputersList(page)
                .map(ComputersResponse::getComputers)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @NonNull
    @Override
    public Observable<InfoResponse> info(int modelId) {
        return null;
    }

    @NonNull
    @Override
    public Observable<SimilarModelsResponse> similarModels() {
        return null;
    }
}
