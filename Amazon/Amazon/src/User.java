import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private static HashMap<Integer, User> users= new HashMap<>();
    private static int id;
    private static int pass;
    static  Scanner sc = new Scanner(System.in);

    static {
        users.put(1, new User(1234, 2222));
        users.put(2, new User(4533, 4444));
        users.put(3, new User(6363, 8282));
        users.put(4, new User(7827, 8280));
    }

    public User(int id, int pass){
        this.id = id;
        this.pass = pass;
    }
    public static int getPass(){
        return pass;
    }
    public static int getId(){
        return id;
    }

    public static boolean UserLogin(int id, int pass) {
        for (User user : users.values()) {
            if (user.getId() == id && user.getPass() == pass) {
                return true;
            }
        }
        return false;
    }
    public static void menucard(){
        System.out.println("User Menu\n");
        boolean rept = true;
        while(rept) {
            System.out.println("1. View Itemes\n 2. Cart Details\n 3. Purchase History\n 4. Exit");
            System.out.println("Enter Your Choice");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("View Items\n");
                    Products.ViewItems();
                    break;
                case 2:
                    System.out.println("Cart Details \n");
                    Cart.ViewItems();
                    break;

                case 3:
                    System.out.println("Purchase History \n");
                    PurchaseHistory.ViewItems();
                    break;
                case 4:
                    rept = false;
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Enter a valid Choice");


            }
        }

    }
}
