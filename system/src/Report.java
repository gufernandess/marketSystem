import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Report {

    private List<Order> ordersList;

    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

    public Report() {
        ordersList = new ArrayList<Order>();
    }

    private double computeTotalValue() {
        double total = 0.00;

        for(Order order : ordersList) total += order.computeBill();

        return total;
    }

    public void addOrder(Order order) { ordersList.add(order); }

    // private List<Order> filterOrder() {}

    public String toString() {
        StringBuilder orders = new StringBuilder();

        System.out.println("\n----------RELATÓRIO----------");
        System.out.println("\nID | Dados da compra | Data \n");

        for (int i = 0; i < ordersList.size(); i++) {
            orders.append(ordersList.get(i).getId() + " | ");
            orders.append(ordersList.get(i).toString() + " | ");
            orders.append(formatDate.format(ordersList.get(i).getDate()) + " | ");
        }

        orders.append("Ganho total: " + computeTotalValue());

        return orders.toString();
    }
}
