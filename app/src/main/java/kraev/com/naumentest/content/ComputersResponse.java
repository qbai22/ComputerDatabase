package kraev.com.naumentest.content;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vladimir Kraev
 */

public class ComputersResponse {

    @SerializedName("items")
    List<Computer> mComputers;
    int page;
    @SerializedName("total")
    int totalItems;

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

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}
