package kraev.com.naumentest.screen.computers;

import android.support.annotation.NonNull;

import kraev.com.naumentest.content.Computer;
import kraev.com.naumentest.content.ComputersResponse;
import kraev.com.naumentest.repository.ComputersRepository;

/**
 * Created by Vladimir Kraev
 */

class ComputerListPresenter {

    private final static String TAG = "ComputerListPresenter";

    private final ComputerListView mView;
    private final ComputersRepository mRepository;

    ComputerListPresenter(@NonNull ComputerListView view,
                          @NonNull ComputersRepository repository) {
        mView = view;
        mRepository = repository;
    }

    void init() {
        int page = mRepository.getCurrentPage();
        loadPage(page);
    }

    void onNext() {
        int page = mRepository.getCurrentPage();
        int total = mRepository.getTotalPages();
        if (page >= total - 1) return; //мы на последней странице
        page++;
        loadPage(page);
    }

    void onPrevious() {
        int page = mRepository.getCurrentPage();
        if (page == 0) return; //мы на первой странице странице
        page--;
        loadPage(page);
    }

    private void loadPage(int page) {

        mRepository.computersList(page)
                .doOnSubscribe(disposable -> mView.showProgress())
                .doOnTerminate(mView::hideProgress)
                .map(computersResponse -> {
                    int currentPage = computersResponse.getPage();
                    int totalPages = calculateTotalPages(computersResponse.getTotalItems());
                    mRepository.setCurrentPage(currentPage);
                    mRepository.setTotalPages(totalPages); //обновляем значение если база увеличилась
                    mView.updatePages(currentPage + 1, totalPages); //добавляем единицу чтобы нумерация не шла с 0
                    return computersResponse;
                })
                .map(ComputersResponse::getComputers)
                .subscribe(mView::showComputers, throwable -> mView.showError());

    }

    void itemClicked(@NonNull Computer computer) {
        mView.navigateToInfoActivity(computer.getId());
    }

    private int calculateTotalPages(int totalItems) {
        if (totalItems % 10 == 0) return (totalItems / 10);
        else return (totalItems / 10) + 1;
    }

}
