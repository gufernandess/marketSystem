import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A classe invoice (Nota fiscal) é instanciada dentro de order (Pedido).
 * Para cada pedido há uma nota fiscal correspondente.
 */

public class Invoice {

    private int id;
    private List<Item> itens;
    private double price;
    private Date date;
    private Client client;

    public Invoice(int id, List<Item> itens, double price, Date date, Client client) {
        itens = new ArrayList<Item>();
        this.id = id;
        this.itens.addAll(itens);
        this.price = price;
        this.date = date;
        this.client = client;
    }

    public String toString() {

    }
}