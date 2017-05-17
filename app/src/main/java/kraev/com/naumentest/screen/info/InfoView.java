package kraev.com.naumentest.screen.info;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import kraev.com.naumentest.content.SimilarModelsResponse;
import kraev.com.naumentest.screen.general.ProgressView;

/**
 * Created by Vladimir Kraev
 */

public interface InfoView extends ProgressView {


    void updateToolbar(String computerName);

    void updateCompany(String companyName);

    void updateDescription(String description);

    void updateImage(String imageUrl);

    void showError();

    void showSimilar(SimilarModelsResponse similarItem);

    void onSimilarClick(int id);

    void clearSpace();

}
