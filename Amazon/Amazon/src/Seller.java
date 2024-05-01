import java.util.*;

public class Seller {
    private static HashMap<Integer, Seller> sellers = new HashMap<>();
    static  int tot_sell_acc = 5;
    static  Scanner sc = new Scanner(System.in);
    static {
        sellers.put(1,new Seller(1232, "Ashwin", 3333));
        sellers.put(2,new Seller(2232, "Aravind", 2222));
        sellers.put(3,new Seller(3232, "Akhilesh", 1111));
        sellers.put(4,new Seller(4232, "Kumar", 9999));
        sellers.put(5,new Seller(5232, "Prem", 6666));
    }

    private static int id;
    private static String name;
    private static int password;

    public Seller(int id, String name, int password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public static int getID(){
        return id;
    }

    public static String getName(){
        return name;
    }

    public static int getPass(){
        return password;
    }

    public static boolean SellerLogin(int id, int pass) {
        for (Seller user : sellers.values()) {
            if (Seller.getID() == id && Seller.getPass() == pass) {
                return true;
            }
        }
        return false;
    }

    public static void AddSeller(int id, int password, String name){
        tot_sell_acc += 1;
        sellers.put(tot_sell_acc, new Seller(id, name, password));
        System.out.println("Seller with ID " + id + " Added successfully.");
    }

    public static void RemoveSeller(int id, int password) {
        Iterator<Map.Entry<Integer, Seller>> iterator = sellers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Seller> entry = iterator.next();
            if (entry.getKey() == id && entry.getValue().getPass() == password) {
                iterator.remove(); // Remove the seller from the HashMap
                System.out.println("Seller with ID " + id + " removed successfully.");
                tot_sell_acc -= 1;
                return;
            }
        }
        System.out.println("Seller with ID " + id + " not found or invalid password.");
    }


    public static void menucard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Seller Menu\n");
        boolean rept = true;
        while(rept) {
            System.out.println("1. View Products\n 2. Add Products\n 3. Remove Products\n 4. Purchase History\n 5. View Profit\n 6. Exit");
            System.out.println("Enter Your Choice");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("View Products\n");
                    Products.ViewProducts();
                    break;
                case 2:
                    System.out.println("Add Products \n");
                    Products.AddProducts();
                    break;

                case 3:
                    System.out.println("Remove Products \n");
                    Products.RemoveProducts();
                    break;

                case 6:
                    rept = false;
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Enter a valid Choice");


            }
        }

    }

}

class Products{
    static  Scanner sc = new Scanner(System.in);
    private static ArrayList<Products> products = new ArrayList<>();
    static {

        products.add(new Products(1232, 0001, "SamsungTV", 70000, 100000));
        products.add(new Products(2232, 0002, "MI-TV", 67000, 8000));
        products.add(new Products(3232, 0003, "Redmi Note 10 pro", 30000,780000));
        products.add(new Products(4232, 0004, "Iphone 16", 130000, 800000));
        products.add(new Products(5232, 0005, "Samsung s12", 50000, 90000));
    }
    private static int sellerid;
    public static int prodid;
    public static String prodname;
    public static int price;
    public static int quantity;


    public Products(int sellerid, int prodid, String prodname, int price, int quantity){
        this.sellerid = sellerid;
        this.prodid = prodid;
        this.prodname = prodname;
        this.price = price;
        this.quantity = quantity;
    }

    public static String getname(){
        return prodname;
    }
    public static int getprice(){
        return price;
    }

    public static int getQuantity(){
        return quantity;
    }

    public static int getSellerID(){
        return sellerid;
    }

    public static int getProdID(){
        return prodid;

    }
    public static void ViewProducts(){
        for(Products prod: Products.products){
            System.out.println("Product Details\n");
            System.out.println("Product ID: " + getProdID());
            System.out.println("Seller ID: " + getSellerID());
            System.out.println("Product Name: " + getname());
            System.out.println("Product Price: " + getprice());
            System.out.println("Total Quantity: " + getQuantity());
        }
    }
    public static void ViewItems(){
        System.out.println("Items Available\n");
        for(Products prods: Products.products){
            System.out.println(prods.getname());
            System.out.println(prods.getprice());
        }

    }

    public static void AddProducts(){
        System.out.println("Enter Seller ID: ");
        int sell_id = sc.nextInt();
        System.out.println("Enter Product ID: ");
        int prod_id = sc.nextInt();
        System.out.println("Enter Product Name: ");
        String prod_name = sc.nextLine();
        System.out.println("Enter Product Price: ");
        int prod_price = sc.nextInt();
        System.out.println("Enter Product Quantity");
        int prod_quantity = sc.nextInt();

        for(Products prod: Products.products){
            if(prod.getProdID() == prod_id){
                System.out.println("Product Already Exist");
                break;
            }
            else{
                products.add(new Products(sell_id, prod_id, prod_name, prod_price, prod_quantity));
                System.out.println("Product Added Successfully");
            }
        }
    }

    public static void RemoveProducts(){
        System.out.println("Enter Product id: ");
        boolean check = true;
        int prodid = sc.nextInt();
        for(Products prod: products){
            if(prod.getProdID() == prodid){
                products.remove(prod);
                check = false;
                System.out.println("Product Removed Successfully");
                break;
            }
        }
        if(check){
            System.out.println("Product Id dosent Exist!!!");
        }
    }
}























