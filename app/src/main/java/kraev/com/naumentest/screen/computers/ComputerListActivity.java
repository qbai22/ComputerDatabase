package kraev.com.naumentest.screen.computers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import kraev.com.naumentest.AppDelegate;
import kraev.com.naumentest.R;
import kraev.com.naumentest.content.Computer;
import kraev.com.naumentest.repository.ComputersRepository;

public class ComputerListActivity extends AppCompatActivity
        implements ComputerListView, ComputersListAdapter.OnComputerClickListener {

    @BindView(R.id.computers_list_recycler_view)
    RecyclerView mComputersRecyclerView;

    @BindView(R.id.previous_button)
    Button mPreviousButton;

    @BindView(R.id.next_button)
    Button mNextButton;

    @BindView(R.id.pages_text_view)
    TextView mPagesTextView;

    @BindView(R.id.progressBar)
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

        mComputersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ComputersListAdapter(new ArrayList<>());
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

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onItemClick(@NonNull Computer computer) {

    }
}
