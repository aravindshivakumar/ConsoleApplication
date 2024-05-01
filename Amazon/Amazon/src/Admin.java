import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Scanner;

public class Admin {
    private static HashMap<Integer, Admin> admin = new HashMap<>();
    static int tot_adm = 1;
    static {
        admin.put(1, new Admin(1242, 9393));
    }
    private static int id;
    private static int password;

    public Admin(int id, int password){
        this.id = id;
        this.password = password;
    }

    public static int getID(){
        return id;
    }
    public static int getPass(){
        return password;
    }

    public static boolean AdminLogin(int id, int pass) {
        for (Admin user : admin.values()) {
            if (Admin.getID() == id && Admin.getPass() == pass) {
                return true;
            }
        }
        return false;
    }



    public static void menucard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("User Menu\n");
        boolean rept = true;
        while(rept) {
            System.out.println("1. Add Seller \n 2. Remove Seller\n 3. Purchase History\n 4. Exit");
            System.out.println("Enter Your Choice");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Add Seller\n");
                    System.out.println("Enter Seller id: ");
                    int seller_id = sc.nextInt();
                    System.out.println("Enter Seller pass: ");
                    int seller_pass = sc.nextInt();

                    System.out.println("Enter Seller name: ");
                    String seller_name = sc.nextLine();

                    Seller.AddSeller(seller_id, seller_pass, seller_name);
                    break;
                case 2:
                    System.out.println(" Remove Seller \n");
                    System.out.println("Enter Seller id: ");
                    int seller_Id = sc.nextInt();
                    System.out.println("Enter Seller pass: ");
                    int seller_Pass = sc.nextInt();
                    Seller.RemoveSeller(seller_Id, seller_Pass);
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
