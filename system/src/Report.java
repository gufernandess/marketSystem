import java.util.ArrayList;
import java.util.List;

public class Report {

    private List<Order> ordersList;

    public Report(List<Order> list) {
        ordersList = new ArrayList<Order>();
        if (list != null)
            ordersList.addAll(list);
    }

    private double computeTotalValue() {
    }

    private List<Order> filterOrder() {
    }

    public String toString() {
    }

}
