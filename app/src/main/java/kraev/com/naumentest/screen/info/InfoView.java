package kraev.com.naumentest.screen.info;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import kraev.com.naumentest.content.SimilarModelsResponse;
import kraev.com.naumentest.screen.general.ProgressView;

/**
 * Created by Vladimir Kraev
 */

public interface InfoView extends ProgressView {

    void showInfo(@NonNull String modelName,
                  @Nullable String company,
                  @Nullable String description,
                  @Nullable String imageUrl);

    void showError();

    void showSimilar(SimilarModelsResponse similarItem);

    void onSimilarClick(int id);

    void showCard(int id);
}
