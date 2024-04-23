

import java.util.Scanner;
public class MainClass {
    public static void main(String[] args) {
        Process process = new Process();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("*** Banking System Application ***");
            System.out.println("----------------------------------------------------------------");
            System.out.println("1. Create a new account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit the amount");
            System.out.println("4. Withdraw the amount");
            System.out.println("5. Display Demo Account");
            System.out.println("6. Exit");
            System.out.println("----------------------------------------------------------------");
            System.out.print("ENTER YOUR CHOICE: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    process.openAccount();
                    break;
                case 2:
                    process.checkBalance();
                    break;
                case 3:
                    process.deposit();
                    break;
                case 4:
                    process.withdraw();
                    break;
                case 5:
                    process.displayDemoAccount();
                    break;
                case 6:
                    System.out.println("THANKS FOR USING OUR BANK APPLICATION");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}