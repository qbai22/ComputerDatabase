package kraev.com.naumentest.screen.info;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kraev.com.naumentest.content.Company;
import kraev.com.naumentest.content.InfoResponse;
import kraev.com.naumentest.content.SimilarModelsResponse;
import kraev.com.naumentest.repository.ComputersRepository;

/**
 * Created by Vladimir Kraev
 */

public class InfoPresenter {

    private static final String TAG = "InfoPresenter";

    private final InfoView mView;
    private final ComputersRepository mRepository;

    public InfoPresenter(@NonNull InfoView view, @NonNull ComputersRepository repository) {
        mView = view;
        mRepository = repository;
    }

    public void getItemCard(int id){

        mRepository.info(id)
                .doOnSubscribe(disposable -> mView.showProgress())
                .doOnTerminate(mView::hideProgress)
                .subscribe(infoResponse -> {
                    String name = infoResponse.getName();
                    Company company = infoResponse.getCompany();
                    String companyName = null;
                    if(company != null) companyName = company.getName();
                    String description = infoResponse.getDescription();
                    String url = infoResponse.getImageUrl();
                    mView.showInfo(name,companyName,description,url);
                });

        mRepository.similarModels(id)
                .flatMap(Observable::fromIterable)
                .subscribe(mView::showSimilar);

    }


}
