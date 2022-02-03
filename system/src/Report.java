import java.util.ArrayList;
import java.util.List;

public class Report {

    private List<Order> ordersList;

    public Report(/*List<Order> list*/) {
        ordersList = new ArrayList<Order>();
        // if (list != null) ordersList.addAll(list);
    }

    private double computeTotalValue() {
        double total = 0.00;

        for(Order order : ordersList) total += order.computeBill();

        return total;
    }

    // private List<Order> filterOrder() {}

    public String toString() {
        StringBuilder orders = new StringBuilder();

        System.out.println("\n----------RELATÓRIO----------");
        System.out.println("\nID | Itens | Preço | Data | Cliente\n");

        for (int i = 0; i < ordersList.size(); i++) {
            orders.append(ordersList.get(i).getId() + " | ");
            orders.append(ordersList.get(i).getItens() + " | ");
            orders.append(ordersList.get(i).getPrice() + " | ");
            orders.append(ordersList.get(i).getDate() + " | ");
            orders.append(ordersList.get(i).getClient() + "\n\n");
        }

        orders.append("Ganho total: " + computeTotalValue());

        return orders.toString();
    }
}
