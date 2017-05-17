package kraev.com.naumentest.screen.info;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import kraev.com.naumentest.content.Company;
import kraev.com.naumentest.repository.ComputersRepository;

/**
 * Created by Vladimir Kraev
 */

public class InfoPresenter {

    private static final String TAG = "InfoPresenter";

    private final InfoView mView;
    private final ComputersRepository mRepository;

    InfoPresenter(@NonNull InfoView view, @NonNull ComputersRepository repository) {
        mView = view;
        mRepository = repository;
    }

    void getItemCard(int id) {

        mView.clearSpace();

        mRepository.info(id)
                .doOnSubscribe(disposable -> mView.showProgress())
                .doOnTerminate(mView::hideProgress)
                .subscribe(infoResponse -> {
                            String name = infoResponse.getName();
                            mView.updateToolbar(name);
                            Company company = infoResponse.getCompany();
                            if (company != null) {
                                mView.updateCompany(company.getName());
                            }
                            String description = infoResponse.getDescription();
                            if (description != null) {
                                mView.updateDescription(description);
                            }
                            String url = infoResponse.getImageUrl();
                            if (url != null) {
                                mView.updateImage(url);
                            }
                        },
                        throwable -> mView.showError());

        mRepository.similarModels(id)
                .flatMap(Observable::fromIterable)
                .subscribe(mView::showSimilar, throwable -> mView.showError());

    }


}
