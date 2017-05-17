package kraev.com.naumentest.screen.computers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kraev.com.naumentest.R;
import kraev.com.naumentest.content.Computer;

/**
 * Created by Vladimir Kraev
 */

public class ComputerHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_computer_name_text_view)
    TextView mNameTextView;

    @BindView(R.id.item_company_text_view)
    TextView mCompanyTextView;

    @BindView(R.id.item_company_linear_container)
    LinearLayout mCompanyContainer;

    public ComputerHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(@NonNull Computer computer){
        mNameTextView.setText(computer.getName());
        boolean hasCompany = computer.getCompany() != null;
        if(hasCompany) {
            mCompanyContainer.setVisibility(View.VISIBLE);
            mCompanyTextView.setText(computer.getCompany().getName());
        }
    }
}
