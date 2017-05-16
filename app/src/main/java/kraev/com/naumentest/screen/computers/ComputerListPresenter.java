package kraev.com.naumentest.screen.computers;

import android.support.annotation.NonNull;

import kraev.com.naumentest.content.Computer;
import kraev.com.naumentest.content.ComputersResponse;
import kraev.com.naumentest.repository.ComputersRepository;

/**
 * Created by Vladimir Kraev
 */

public class ComputerListPresenter {

    private final static String TAG = "ComputerListPresenter";

    private final ComputerListView mView;
    private final ComputersRepository mRepository;

    public ComputerListPresenter(@NonNull ComputerListView view,
                                 @NonNull ComputersRepository repository) {
        mView = view;
        mRepository = repository;
    }

    public void init() {

        int page = mRepository.getCurrentPage();
        mRepository.computersList(page)
                .doOnSubscribe(disposable -> mView.showProgress())
                .doOnTerminate(mView::hideProgress)
                .map(computersResponse -> {
                    mRepository.setTotalPages(calculateTotalPages(computersResponse.getTotalItems()));
                    return computersResponse;
                })
                .map(ComputersResponse::getComputers)
                .subscribe(mView::showComputers, throwable -> mView.showError());

    }

    public void onNext(){
        int page = mRepository.getCurrentPage();
        page++;
        mRepository.setCurrentPage(page);



    }

    public void itemClicked(@NonNull Computer computer) {
        mView.navigateToInfoActivity(computer.getId());
    }

    private int calculateTotalPages(int totalItems) {
        if (totalItems % 10 == 0) return totalItems / 10;
        else return (totalItems / 10) + 1;
    }
}
