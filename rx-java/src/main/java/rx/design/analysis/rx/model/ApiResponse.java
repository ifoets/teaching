package rx.design.analysis.rx.model;

import rx.design.analysis.rx.record.Item;

import java.util.List;

public class ApiResponse {

    public List<Item> items;
    public boolean hasNextPage;
    public ApiResponse(List<Item> items, boolean hasNextPage) {
        this.items = items;
        this.hasNextPage = hasNextPage;
    }
}
