package kraev.com.naumentest.repository;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;
import kraev.com.naumentest.content.Computer;
import kraev.com.naumentest.content.ComputersResponse;
import kraev.com.naumentest.content.InfoResponse;
import kraev.com.naumentest.content.SimilarModelsResponse;

/**
 * Created by Vladimir Kraev
 */

public interface ComputersRepository {

    @NonNull
    Observable<ComputersResponse> computersList(int page);

    @NonNull
    Observable<InfoResponse> info(int modelId);

    @NonNull
    Observable<List<SimilarModelsResponse>> similarModels(int id);

    int getCurrentPage();

    void setCurrentPage(int page);

    int getTotalPages();

    void setTotalPages(int total);

}
