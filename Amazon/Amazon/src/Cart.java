import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<Cart> cartItems = new ArrayList<>();
    //products.add(new Products("Product name", Price, Quantity, TotalAmount));

    private static String prod_name;
    private static int Price;
    private static int Quanity;
    private static int TotalAmount;

    public Cart(String prod_name, int Price, int Quantity){
        this.prod_name = prod_name;
        this.Price = Price;
        this.Quanity = Quantity;
    }

    public static String getProdName(){
            return prod_name;
    }
    public static int  getProdPrice(){
        return Price;
    }

    public static int getQuantity(){
        return Quanity;
    }

    public static int getTotalAmount(){
        int tot = 0;
        for(Cart items: cartItems){
            int price = getProdPrice();
            int quantity = getQuantity();
            tot += price * quantity;
        }
        return tot;
    }


    public static void ViewItems(){
        System.out.println("Your Cart Items");
        String prodname = getProdName();
        int prod_price = getProdPrice();
        System.out.println("Product Name: " + prodname);
        System.out.println("Product Price: " + prod_price);
        int Quantity = getQuantity();
        int amount = getTotalAmount();
        System.out.println("Quantity: " + Quantity);
        System.out.println("Amount: " + amount);
        System.out.println("GST: 18%");
        int Total_amt = ((int)((amount * 18)/100));
        System.out.println("Total Amount: " + Total_amt);

        System.out.println("Confirm Payment ? (yes/no)");
        String ch = sc.nextLine();
        if(ch.toLowerCase() == "yes"){
            PurchaseHistory.addItems(prodname, prod_price, Quantity, amount, Total_amt);
            System.out.println("Order Recieved Successfully!!!");
        }


    }
}
