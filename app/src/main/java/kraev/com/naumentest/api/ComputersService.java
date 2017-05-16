package kraev.com.naumentest.api;

import java.util.List;

import io.reactivex.Observable;
import kraev.com.naumentest.content.ComputersResponse;
import kraev.com.naumentest.content.InfoResponse;
import kraev.com.naumentest.content.SimilarModelsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Vladimir Kraev
 */

public interface ComputersService {

    @GET("computers")
    Observable<ComputersResponse> getComputersList(@Query("p") int page);

    @GET("computers/{id}")
    Observable<InfoResponse> getComputerInfo(@Path("id") int id);

    @GET("computers/{id}/similar")
    Observable<List<SimilarModelsResponse>> getSimilarModels(@Path("id") int id);

}
