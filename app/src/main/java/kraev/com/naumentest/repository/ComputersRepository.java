package kraev.com.naumentest.repository;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;
import kraev.com.naumentest.content.Computer;
import kraev.com.naumentest.content.InfoResponse;
import kraev.com.naumentest.content.SimilarModelsResponse;

/**
 * Created by qbai on 13.05.2017.
 */

public interface ComputersRepository {

    @NonNull
    Observable<List<Computer>> computersList(int page);

    @NonNull
    Observable<InfoResponse> info(int modelId);

    @NonNull
    Observable<SimilarModelsResponse> similarModels();

}
