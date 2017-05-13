package kraev.com.naumentest.screen.computers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kraev.com.naumentest.R;
import kraev.com.naumentest.content.Computer;

/**
 * Created by qbai on 13.05.2017.
 */

public class ComputerHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_computer_name_text_view)
    TextView mNameTextView;

    @BindView(R.id.item_company_text_view)
    TextView mCompanyTextView;

    public ComputerHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(@NonNull Computer computer){
        mNameTextView.setText(computer.getName());
        boolean hasCompany = computer.getCompany() != null;
        if(hasCompany) {
            mCompanyTextView.setVisibility(View.VISIBLE);
            mCompanyTextView.setText(computer.getCompany().getName());
        }
    }
}
