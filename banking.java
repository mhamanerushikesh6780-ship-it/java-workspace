import java.util.*;

public class BankingApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int BankBalance = 10000;

        System.out.print("Enter your username: ");
        String usrname = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        if (usrname.equals("rushi") && password.equals("1234")) {

            System.out.println("Username and password verified");

            int generatedOTP = random.nextInt(9000) + 1000;
            System.out.println("Your OTP is " + generatedOTP);

            System.out.print("Enter your OTP: ");
            int otp = sc.nextInt();

            if (otp == generatedOTP) {

                System.out.println("============= Welcome to Banking App =============");

                while (true) {

                    System.out.println("\n1. Check balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Exit");

                    System.out.print("Enter your choice: ");
                    int choice = sc.nextInt();

                    if (choice == 1) {
                        System.out.println("Your balance is Rs " + BankBalance);
                    }

                    else if (choice == 2) {
                        System.out.print("Enter deposit amount: ");
                        int amount = sc.nextInt();

                        if (amount > 0) {
                            BankBalance += amount;

                            System.out.println("Deposit successful");
                            System.out.println("After deposit your balance is Rs " + BankBalance);
                        } else {
                            System.out.println("Invalid amount ❌");
                        }
                    }

                    else if (choice == 3) {
                        System.out.print("Enter withdraw amount: ");
                        int withdraw = sc.nextInt();

                        if (withdraw > 0) {
                            if (withdraw <= BankBalance) {
                                BankBalance -= withdraw;

                                System.out.println("Withdraw successful ✅");
                                System.out.println("After withdraw your balance is Rs " + BankBalance);
                            } else {
                                System.out.println("Insufficient balance ");
                            }
                        } else {
                            System.out.println("Invalid amount ❌");
                        }
                    }

                    else if (choice == 4) {
                        System.out.println("Thank you for banking with us!");
                        break;
                    }

                    else {
                        System.out.println("Invalid choice ❌");
                    }
                }

            } else {
                System.out.println("Incorrect OTP ❌");
            }

        } else {
            System.out.println("Incorrect username or password ❌");
        }
    }
}
