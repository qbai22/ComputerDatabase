package kraev.com.naumentest.screen.info;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import kraev.com.naumentest.AppDelegate;
import kraev.com.naumentest.R;
import kraev.com.naumentest.content.SimilarModelsResponse;
import kraev.com.naumentest.repository.ComputersRepository;

/**
 * Created by Vladimir Kraev
 */

public class InfoActivity extends AppCompatActivity
        implements InfoView {

    public static final String ITEM_ID = "item id";

    @BindView(R.id.info_company_text_view)
    TextView mCompanyTextView;

    @BindView(R.id.info_description_text_view)
    TextView mDescriptionTextView;

    @BindView(R.id.info_image_view)
    ImageView mImageView;

    @BindView(R.id.info_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.info_progressBar)
    ProgressBar mProgressBar;

    @BindView(R.id.similar_items_linear_layout)
    LinearLayout mSimilarsLinearLayout;

    @Inject
    ComputersRepository mRepository;

    private int mId;
    private InfoPresenter mPresenter;



    public static void start(@NonNull Activity activity, int id) {
        Intent intent = new Intent(activity, InfoActivity.class);
        intent.putExtra(ITEM_ID, id);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mId = getIntent().getIntExtra(ITEM_ID, 1);
        AppDelegate.getAppComponent().injectInfoActivity(this);
        mPresenter = new InfoPresenter(this, mRepository);
        mPresenter.getItemCard(mId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateToolbar(String computerName) {
        getSupportActionBar().setTitle(computerName);
    }

    @Override
    public void updateCompany(String companyName) {
        mCompanyTextView.setVisibility(View.VISIBLE);
        mCompanyTextView.setText(companyName);
    }

    @Override
    public void updateDescription(String description) {
        mDescriptionTextView.setVisibility(View.VISIBLE);
        mDescriptionTextView.setText(description);
    }

    @Override
    public void updateImage(String imageUrl) {
        mImageView.setVisibility(View.VISIBLE);
        Glide.with(this).load(imageUrl).into(mImageView);
    }

    @Override
    public void showSimilar(SimilarModelsResponse similarItem) {
        SimilarTextView similarView = new SimilarTextView(this, similarItem.getId(), similarItem.getName());
        similarView.setOnClickListener(v -> onSimilarClick(similarItem.getId()));
        mSimilarsLinearLayout.addView(similarView);
    }

    @Override
    public void onSimilarClick(int id) {
        mPresenter.getItemCard(id);
    }

    @Override
    public void clearSpace() {
        mSimilarsLinearLayout.removeAllViews();
    }


    @Override
    public void showError() {
        Toast.makeText(this, R.string.error_toast, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showProgress() {
        mProgressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(ProgressBar.GONE);
    }


}
