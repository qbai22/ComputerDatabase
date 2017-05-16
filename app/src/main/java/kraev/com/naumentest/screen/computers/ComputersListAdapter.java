package kraev.com.naumentest.screen.computers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kraev.com.naumentest.R;
import kraev.com.naumentest.content.Computer;

/**
 * Created by Vladimir Kraev
 */

public class ComputersListAdapter extends RecyclerView.Adapter<ComputerHolder> {

    private final List<Computer> mItems = new ArrayList<>();

    @Nullable
    private OnComputerClickListener mOnComputerClickListener;

    private final View.OnClickListener mIternalClickListener = view -> {
        if (mOnComputerClickListener != null) {
            int position = (int) view.getTag();
            Computer computer = mItems.get(position);
            mOnComputerClickListener.onItemClick(computer);
        }
    };


    public ComputersListAdapter(List<Computer> items) {
        mItems.addAll(items);
    }

    public void add(@NonNull Computer item) {
        mItems.add(item);
        notifyDataSetChanged();
    }

    public void changeDataSet(@NonNull List<Computer> values) {
        mItems.clear();
        mItems.addAll(values);
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    public Computer getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public ComputerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_computer_list, parent, false);
        return new ComputerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ComputerHolder holder, int position) {
        Computer item = mItems.get(position);
        holder.bind(item);
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(mIternalClickListener);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setOnClickListener(OnComputerClickListener listener) {
        mOnComputerClickListener = listener;
    }

    public interface OnComputerClickListener {

        void onItemClick(@NonNull Computer computer);

    }

}
