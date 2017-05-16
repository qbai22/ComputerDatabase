package kraev.com.naumentest.screen.computers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import kraev.com.naumentest.AppDelegate;
import kraev.com.naumentest.R;
import kraev.com.naumentest.content.Computer;
import kraev.com.naumentest.repository.ComputersRepository;
import kraev.com.naumentest.screen.info.InfoActivity;

public class ComputerListActivity extends AppCompatActivity
        implements ComputerListView, ComputersListAdapter.OnComputerClickListener {

    @BindView(R.id.computers_list_recycler_view)
    RecyclerView mComputersRecyclerView;

    @BindView(R.id.previous_button)
    Button mPreviousButton;

    @BindView(R.id.next_button)
    Button mNextButton;

    @BindView(R.id.current_page_text_view)
    TextView mCurrentPageTextView;

    @BindView(R.id.pages_total_text_view)
    TextView mTotalPagesTextView;

    @BindView(R.id.list_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.computers_progressBar)
    ProgressBar mProgressBar;

    @Inject
    ComputersRepository mRepository;

    private ComputerListPresenter mPresenter;
    private ComputersListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_list);
        ButterKnife.bind(this);

        mToolbar.setTitle(R.string.list_toolbat_title);
        setSupportActionBar(mToolbar);

        mPreviousButton.setOnClickListener(b -> previousButtonClicked());
        mNextButton.setOnClickListener(b -> nextButtonClicked());

        mComputersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ComputersListAdapter(new ArrayList<>());
        mAdapter.setOnClickListener(this);
        mComputersRecyclerView.setAdapter(mAdapter);

        AppDelegate.getAppComponent().injectComputerListActivity(this);
        mPresenter = new ComputerListPresenter(this, mRepository);
        mPresenter.init();

    }

    @Override
    public void showComputers(List<Computer> computers) {
        mAdapter.changeDataSet(computers);
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

    @Override
    public void navigateToInfoActivity(int id) {
        InfoActivity.start(this, id);
    }

    @Override
    public void onItemClick(@NonNull Computer computer) {
        mPresenter.itemClicked(computer);
    }

    @Override
    public void nextButtonClicked() {
        mPresenter.onNext();
    }

    @Override
    public void previousButtonClicked() {
        mPresenter.onPrevious();
    }

    @Override
    public void updatePages(int currentPage, int totalPages) {
        mCurrentPageTextView.setText(getString(R.string.current_page_text, currentPage));
        mTotalPagesTextView.setText(getString(R.string.total_pages_text, totalPages));
    }


}
