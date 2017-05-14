package kraev.com.naumentest.screen.computers;

import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;

import java.util.List;
import java.util.function.Consumer;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kraev.com.naumentest.content.Computer;
import kraev.com.naumentest.repository.ComputersRepository;

/**
 * Created by qbai on 13.05.2017.
 */

public class ComputerListPresenter {

    ComputerListView mView;
    ComputersRepository mRepository;

    public ComputerListPresenter(@NonNull ComputerListView view,
                                 @NonNull ComputersRepository repository){
        mView = view;
        mRepository = repository;
    }

    public void init(){
        mRepository.computersList(1)
                .doOnSubscribe(disposable -> mView.showProgress())
                .doOnTerminate(() -> mView.hideProgress())
                .subscribe(computers -> mView.showComputers(computers));
    }
}
