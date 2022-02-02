import java.text.SimpleDateFormat;
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

    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

    public Invoice(int id, List<Item> itens, double price, Date date, Client client) {
        this.id = id;
        itens = new ArrayList<Item>();
        this.itens.addAll(itens);
        this.price = price;
        this.date = date;
        this.client = client;
    }

    public String toString() {
        StringBuilder invoice = new StringBuilder();

        System.out.println("----------NOTA FISCAL----------");
        System.out.println("\nID | Itens | Preço | Data | Cliente\n");

        invoice.append(this.id + " | ");
        invoice.append(this.itens + " | ");
        invoice.append(this.price + " | ");
        invoice.append(formatDate.format(this.date) + " | ");
        invoice.append(this.client + "\n");

        return invoice.toString();
    }
}