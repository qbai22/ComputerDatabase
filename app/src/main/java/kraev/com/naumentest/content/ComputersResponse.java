package kraev.com.naumentest.content;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by qbai on 10.05.2017.
 */

public class ComputersResponse {

    @SerializedName("items")
    List<Computer> mComputers;
    int page;
    int total;

    public List<Computer> getComputers() {
        return mComputers;
    }

    public void setComputers(List<Computer> computers) {
        mComputers = computers;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
