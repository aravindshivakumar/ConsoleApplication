import java.util.*;

class Accounts {
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Bank> banks = new ArrayList<>();

    static {
        users.add(new User(1234, 2222, 5000, 1));
        users.add(new User(4533, 4444, 10000, 1));
        users.add(new User(6363, 8282, 1000, 2));
        users.add(new User(7827, 8280, 100, 3));

        admins.add(new Admin(8373, 9330));
        admins.add(new Admin(9933, 9393));
        admins.add(new Admin(3939, 0303));
        admins.add(new Admin(0333, 3939));

        banks.add(new Bank(1111, 9939));
        banks.add(new Bank(2222, 9373));
        banks.add(new Bank(3333, 9893));
        banks.add(new Bank(4444, 9678));

    }
}

class User {
    private int account_no;
    private int password;
    private int balance;
    private int branch_id;
    Scanner sc = new Scanner(System.in);

    public User(int acc_no, int pass, int bal, int bran) {
        this.account_no = acc_no;
        this.password = pass;
        this.balance = bal;
        this.branch_id = bran;
    }

    public int getAccountNo() {
        return account_no;
    }

    public int getBalance() {
        return balance;
    }

    public int getBranchId() {
        return branch_id;
    }

    public int getPassword() {
        return password;
    }

    public void  setPassword(int new_pass){
        this.password = new_pass;
    }

    public void deposit() {
        System.out.println("Enter Amount");
        int depositAmount = sc.nextInt();
        balance += depositAmount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw() {
        System.out.println("Enter Amount to Withdraw");
        int withdrawAmount = sc.nextInt();
        if (balance - withdrawAmount < 0) {
            System.out.println("Insufficient Fund");
        } else {
            balance -= withdrawAmount;
            System.out.println("Withdraw successful. New balance: " + balance);
        }
    }


    public void Pinchange(){
        System.out.println("Enter Acc No: ");
        int acc_no = sc.nextInt();
        System.out.println("Enter old Password: ");
        int old_pass = sc.nextInt();
        for(User user: Accounts.users){
            if(user.getAccountNo() == acc_no && user.getPassword() == old_pass){
                System.out.println("Enter new Password: ");
                int new_pass = sc.nextInt();
                user.setPassword(new_pass);
                System.out.println("Password Updated Successfully");
                break;
            }
            else{
                System.out.println("Invalid Account or password");
            }
        }


    }

    public void Balance(int user_id, int pass){
        for(User user: Accounts.users){
            if(user.getAccountNo() == user_id && user.getPassword() == pass){
                System.out.println("Account id: " + user.getAccountNo());
                System.out.println("Your Balance: " + user.getBalance());
            }
        }
    }
}

class Admin {
    static Scanner sc = new Scanner(System.in);
    private int acc_no;
    private int pass;

    public Admin(int acc_no, int pass){
        this.acc_no = acc_no;
        this.pass = pass;
    }
    public int getPassword(){
        return  pass;
    }

    public int getAccountNo(){
        return  acc_no;
    }

    public static void removeBank(){
        System.out.println("Enter Bank ID: ");
        int id = sc.nextInt();
        System.out.println("Enter Bank Password: ");
        int pass = sc.nextInt();

        for (int i = 0; i < Accounts.banks.size(); i++) {
            Bank bank = Accounts.banks.get(i);
            if (bank.getAccountNo() == id && bank.getPassword() == pass) {
                Accounts.banks.remove(i);
                System.out.println("Bank removed successfully.");
                break;
            }
        }
        System.out.println("Bank not found or invalid credentials.");
    }

    public static void AddBank(){
        System.out.println("Enter Bank ID: ");
        int id = sc.nextInt();
        System.out.println("Enter Bank Password: ");
        int pass = sc.nextInt();
        Accounts.banks.add(new Bank(id, pass));
        System.out.println("Bank Added Successfully");
    }
    public  static void viewBank(){
        int i = 0;
        for(Bank bank : Accounts.banks){
            System.out.println("Bank " + i);
            System.out.println(i + "Bank ID: " + Accounts.banks);
            System.out.println(i + "Bank Pass: " + Accounts.banks);
            i += 1;
        }
        System.out.println("Total Banks: " + i);
    }
}

class Bank {
    private int account_no;
    private int password;

    public Bank(int account_no, int password){
        this.account_no = account_no;
        this.password = password;
    }

    public int getPassword(){
        return password;
    }

    public  int getAccountNo(){
        return account_no;
    }

    public static void UserDetails(){
        int i = 0;
        for(User user: Accounts.users){
            System.out.println("Account Holder" + (int)i+1);
            System.out.println("Account Number: " + user.getAccountNo());
            System.out.println("Account Balance: " + user.getBalance());
            System.out.println("Account Branch ID: " + user.getBranchId());
            i += 1;
        }
        System.out.println("Total Accounts: " + i);
    }
}

public class ATM {
    static Scanner sc = new Scanner(System.in);

    public static boolean login(int id, int pass) {
        for (User user : Accounts.users) {
            if (user.getAccountNo() == id && user.getPassword() == pass) {
                System.out.println("Login Successful");
                return true;
            }
        }
        System.out.println("Invalid account number or password.");
        return false;
    }

    public static boolean bank_login(int id, int pass){
        for(Bank b: Accounts.banks){
            if(b.getAccountNo() == id && b.getPassword() == pass){
                System.out.println("Login Successfull");
                return true;
            }
        }
        System.out.println("Invalid account number or password");
        return false;
    }

    public static boolean Admin_login(int id, int pass){
        for(Admin A: Accounts.admins){
            if(A.getAccountNo() == id && A.getPassword() == pass){
                System.out.println("Login Successfull");
                return true;
            }
        }
        System.out.println("Invalid account number or password");
        return false;
    }

    public static void main(String[] args) {
        System.out.println("\t !!! Welcome !!!");
        boolean flag = true;
        while (flag) {
            System.out.println("Enter Your Choice\n 1. Login as Admin \n 2. Login as User \n 3. Login as Bank \n 4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Admin Login");
                    System.out.println("Enter Account Id: ");
                    int AdminId = sc.nextInt();
                    System.out.println("Enter Password");
                    int AdmonPass = sc.nextInt();
                    boolean check = Admin_login(AdminId, AdmonPass);
                    if(check == true) {
                        boolean admin_flag = true;
                        while (admin_flag == true) {
                            System.out.println("Enter Your Choice: \n 1. Add Bank \n 2. Remove Bank \n 3. View Bank \n 4.Exit");
                            int ch = sc.nextInt();
                            switch (ch) {
                                case 1:
                                    Admin.AddBank();
                                    break;
                                case 2:
                                    Admin.removeBank();
                                    break;
                                case 3:
                                    Admin.viewBank();
                                    break;
                                case 4:
                                    admin_flag = false;
                                    break;
                                default:
                                    System.out.println("Enter a valid Choice");
                            }
                        }
                    }
                    
                    break;
                case 2:
                    System.out.println("User Login");
                    System.out.println("Enter Account Id: ");
                    int userId = sc.nextInt();
                    System.out.println("Enter Password");
                    int userPass = sc.nextInt();
                    if (login(userId, userPass)) {
                        User user = Accounts.users.stream().filter(u -> u.getAccountNo() == userId).findFirst().orElse(null);
                        if (user != null) {
                            boolean userFlag = true;
                            while (userFlag == true) {
                                System.out.println("Enter Your Choice\n 1. Deposit \n 2. Withdraw \n 3. PinChange \n 4. Balance \n 5. Exit");
                                int userChoice = sc.nextInt();
                                switch (userChoice) {
                                    case 1:
                                        user.deposit();
                                        break;
                                    case 2:
                                        user.withdraw();
                                        break;
                                    case 3:
                                        user.Pinchange();
                                        break;
                                    case 4:
                                        user.Balance(userId, userPass);
                                    case 5:
                                        userFlag = false;
                                        break;
                                    default:
                                        System.out.println("Please Enter a valid choice");
                                        break;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Bank Login");
                    System.out.println("Enter BankID: ");
                    int bank_id = sc.nextInt();
                    System.out.println("Enter BankPass: ");
                    int bank_pass = sc.nextInt();
                    boolean bank_check = bank_login(bank_id, bank_pass);
                    if(bank_check == true){
                        boolean bank_flag = true;
                        while(bank_flag == true) {
                            System.out.println("Enter Your Choice: \n 1. View User Details");
                            int ch = sc.nextInt();
                            switch (ch) {
                                case 1:
                                    Bank.UserDetails();
                                    break;
                                case 2:
                                    bank_flag = false;
                                    break;
                                default:
                                    System.out.println("Enter a valid Choice");
                            }
                        }
                    }
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Please Enter a valid choice");
            }
        }
        sc.close();
    }
}
