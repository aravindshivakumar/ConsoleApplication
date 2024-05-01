import javax.lang.model.element.QualifiedNameable;
import java.util.HashMap;
import java.util.Map;

public class PurchaseHistory {
    private static int tot_items = 0;
    private static HashMap<Integer,PurchaseHistory> History = new HashMap<>();
    private static String prodname;
    private static int prod_price;
    private static int Quantity;
    private static int amount;
    private static int Total_amt;

    public PurchaseHistory(String prodname, int prod_price, int Quantity, int amount, int Total_amt) {
        this.prodname = prodname;
        this.prod_price = prod_price;
        this.Quantity = Quantity;
        this.amount = amount;
        this.Total_amt = Total_amt;
    }

    public static String getProdName(){
        return prodname;
    }
    public static int getProdPrice(){
        return prod_price;
    }

    public static int getQuantity(){
        return Quantity;
    }

    public static int getAmount(){
        return amount;
    }

    public static int getTotalamt(){
        return Total_amt;
    }

    public static void ViewItems() {
        for(Map.Entry<Integer, PurchaseHistory> entry: History.entrySet()){
            tot_items += 1;
            System.out.println("Product Name: " + getProdName());
            System.out.println("Prodcut Price: " + getProdPrice());
            System.out.println("Quanity: " + getQuantity());
            System.out.println("Amount: " + getAmount());
            System.out.println("Total_amt: " + getTotalamt());
        }
        System.out.println("Total Products Purchased: " + tot_items);
    }
    public static void addItems(String prodname, int prod_price, int Quantity, int amount, int Total_amt){
        tot_items += 1;
        History.put(tot_items, new PurchaseHistory(prodname, prod_price, Quantity, amount, Total_amt));
    }
}
