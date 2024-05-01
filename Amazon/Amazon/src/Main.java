import  java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("!!! Welcome to Amazon Application !!!");
        boolean rept = true;
        while(rept == true){
            System.out.println("\n 1. User Login \n 2. Admin Login \n 3. Seller Login\n 4. Exit");
            System.out.println("Enter Your Choice: ");

            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("User Portal\n");
                    System.out.println("Enter your ID: ");
                    int us_id = sc.nextInt();
                    System.out.println("Enter Password: ");
                    int us_password = sc.nextInt();

                    boolean User_verify = Login(us_id, us_password, "user");
                    if(User_verify == true){
                        System.out.println("Welcome User\n");
                        User.menucard();
                    }
                    else{
                        System.out.println("Invalid Credentials!!!");
                    }
                    break;
                case 2:
                    System.out.println("User Admin\n");
                    System.out.println("Enter your ID: ");
                    int ad_id = sc.nextInt();
                    System.out.println("Enter Password: ");
                    int ad_password = sc.nextInt();

                    boolean AdminVerify = Login(ad_id, ad_password, "admin");
                    if(AdminVerify == true){
                        System.out.println("Welcome Admin\n");
                        Admin.menucard();
                    }
                    else{
                        System.out.println("Invalid Credentials!!!");
                    }
                    break;
                case 3:
                    System.out.println("Seller Portal\n");
                    System.out.println("Enter your ID: ");
                    int sell_id = sc.nextInt();
                    System.out.println("Enter Password: ");
                    int sell_password = sc.nextInt();

                    boolean verify = Login(sell_id, sell_password, "seller");
                    if(verify == true){
                        System.out.println("Welcome User\n");
                        Seller.menucard();
                    }
                    else{
                        System.out.println("Invalid Credentials!!!");
                    }
                    break;
                case 4:
                    System.out.println("Exiting....");
                    rept = false;
                    break;
                default:
                    System.out.println("Invaid Choice");
                }
        }

    }
    public static boolean Login(int id, int pass, String type){
        if(type.equals("user")){
            boolean check = User.UserLogin(id, pass);
            if(check == true){
                System.out.println("Login Successfull");
                return true;
            }
            else{
                System.out.println("Invalid Credentials");
            }
        }
        else if(type.equals("admin")){
            boolean check = Admin.AdminLogin(id, pass);
            if(check == true){
                System.out.println("Login Successfull");
                return true;
            }
            else{
                System.out.println("Invalid Credentials");
            }
        }
        else if(type.equals("seller")){
            boolean check = Seller.SellerLogin(id, pass);
            if(check == true){
                System.out.println("Login Successfull");
                return true;
            }
            else{
                System.out.println("Invalid Credentials");
            }
        }
        else{
            System.out.println("Invalid Privilage Type");
        }
        return false;


    }

}