package kraev.com.naumentest.screen.computers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kraev.com.naumentest.R;
import kraev.com.naumentest.content.Computer;

public class ComputerListActivity extends AppCompatActivity
        implements ComputerListView {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_list);
        ButterKnife.bind(this);

        View v = new View(this);
        v.setOnClickListener(v1 -> {

        });
    }

    @Override
    public void showComputers(List<Computer> computers) {

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
}
