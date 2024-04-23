import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Random;

public class Process {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, BankInfo> accounts = new HashMap<>();

    public void openAccount() {
        try {
            System.out.print("Enter Full Name: ");
            sc.nextLine(); // Consume newline character
            String name = sc.nextLine();
            if (name.trim().isEmpty() || !name.matches("[a-zA-Z ]+")) {
                throw new IllegalArgumentException("Invalid name. Please enter a full name with alphabets only.");
            }

            System.out.print("Enter Aadhar No (12 digits): ");
            String aadhar = sc.next();
            if (aadhar.length() != 12 || !aadhar.matches("\\d{12}")) {
                throw new IllegalArgumentException("Invalid Aadhar number. Please enter a 12-digit number.");
            }

            System.out.print("Enter Account type: ");
            String acc_type = sc.next();

            Random random = new Random();
            String accno = String.format("%012d", random.nextInt(1000000000));
            System.out.println("Your account number: " + accno);

            System.out.print("Set Password (4 digits): ");
            String password = sc.next();
            if (password.length() != 4 || !password.matches("\\d{4}")) {
                throw new IllegalArgumentException("Invalid password. Please enter a 4-digit number.");
            }

            System.out.print("Enter Initial Deposit (minimum 500): ");
            long balance = sc.nextLong();
            if (balance < 500) {
                throw new IllegalArgumentException("Initial deposit must be at least 500.");
            }

            BankInfo account = new BankInfo(accno, name, acc_type, balance, aadhar, password);
            accounts.put(accno, account);
            System.out.println("------YOUR ACCOUNT DETAILS IS -------");
            System.out.println("Name of account holder :: " + name);
            System.out.println("Account no             :: " + accno);
            System.out.println("Account type           :: " + acc_type);
            System.out.println("Balance                :: " + balance);
        } catch (NoSuchElementException | IllegalStateException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine(); // Consume the invalid input
        }
    }

    public void deposit() {
        try {
            System.out.print("Enter Account No: ");
            String accno = sc.next();
            BankInfo account = accounts.get(accno);
            if (account != null) {
                System.out.print("Enter the Amount you want to deposit: ");
                long deposit = sc.nextLong();
                if (deposit <= 0) {
                    throw new IllegalArgumentException("Deposit amount must be greater than zero.");
                }
                long newBalance = account.getBalance() + deposit;
                account.setBalance(newBalance);
                System.out.println(deposit + " is deposited into your Account");
                System.out.println("Current Available Balance is Rs  ::" + account.getBalance());
            } else {
                System.out.println("Account not found.");
            }
        } catch (NoSuchElementException | IllegalStateException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine(); // Consume the invalid input
        }
    }

    public void withdraw() {
        try {
            System.out.print("Enter Account No: ");
            String accno = sc.next();
            BankInfo account = accounts.get(accno);
            if (account != null) {
                System.out.print("Enter Password (4 digits): ");
                String passwordAttempt = sc.next();
                if (passwordAttempt.equals(account.getPassword())) {
                    System.out.print("Enter the Amount you want to withdraw: ");
                    long withdraw = sc.nextLong();
                    if (withdraw <= 0) {
                        throw new IllegalArgumentException("Withdraw amount must be greater than zero.");
                    }
                    if (withdraw <= account.getBalance()) {
                        account.setBalance(account.getBalance() - withdraw);
                        System.out.println(withdraw + " is withdrawn from your Account");
                        System.out.println("Current Available Balance is Rs  ::" + account.getBalance());
                    } else {
                        System.out.println("Low Balance");
                        System.out.println("Current Available Balance is Rs  ::" + account.getBalance());
                    }
                } else {
                    System.out.println("Incorrect Password.");
                }
            } else {
                System.out.println("Account not found.");
            }
        } catch (NoSuchElementException | IllegalStateException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine(); // Consume the invalid input
        }
    }

    public void checkBalance() {
        try {
            System.out.print("Enter Account No: ");
            String accno = sc.next();
            BankInfo account = accounts.get(accno);
            if (account != null) {
                System.out.print("Enter Password (4 digits): ");
                String passwordAttempt = sc.next();
                if (passwordAttempt.equals(account.getPassword())) {
                    System.out.println("Your name is           :: " + account.getName());
                    System.out.println("Account no             :: " + account.getAccno());
                    System.out.println("Account type           :: " + account.getAcc_type());
                    System.out.println("Balance                :: " + account.getBalance());
                    System.out.println("THANKS FOR BALANCE CHECKING ");
                } else {
                    System.out.println("Incorrect Password.");
                }
            } else {
                System.out.println("Account not found.");
            }
        } catch (NoSuchElementException | IllegalStateException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine(); // Consume the invalid input
        }
    }

    public void displayDemoAccount() {
        BankInfo demoAccount = new BankInfo("8529637412", "Demo User", "demo", 50000, "", "");
        System.out.println("------DEMO ACCOUNT DETAILS -------");
        System.out.println("Name of account holder :: " + demoAccount.getName());
        System.out.println("Account no             :: " + demoAccount.getAccno());
        System.out.println("Account type           :: " + demoAccount.getAcc_type());
        System.out.println("Balance                :: " + demoAccount.getBalance());
    }

}
