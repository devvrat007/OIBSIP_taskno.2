import java.util.Scanner;

public class ATMApp {
    private static Scanner scanner = new Scanner(System.in);
    private static int userId;
    private static int userPin;
    private static double balance = 10000.0; // assumed balance

    public static void main(String[] args) {
        authenticateUser();

        if (isAuthenticated()) {
            showMainMenu();
        } else {
            System.out.println("Authentication failed. Exiting application.");
        }
    }

    private static void authenticateUser() {
        System.out.print("Enter user ID: ");
        userId = scanner.nextInt();

        System.out.print("Enter user PIN: ");
        userPin = scanner.nextInt();
    }

    private static boolean isAuthenticated() {
       //user id 12345 and pin is 1234 default
        return (userId == 12345 && userPin == 1234);
    }

    private static void showMainMenu() {
        int choice = 0;

        while (choice != 5) {
            System.out.println("\nATM MENU");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    performWithdrawal();
                    break;
                case 3:
                    performDeposit();
                    break;
                case 4:
                    performTransfer();
                    break;
                case 5:
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void showTransactionHistory() {
        System.out.println("Transaction History:");

        //assumed transaction history
        String[] transactions = {"Your previous transaction history was ","Withdraw 100", "Deposit 200", "Transferred 50 to 6789"};

        if (transactions.length == 0) {
            System.out.println("No transactions found.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }


    private static void performWithdrawal() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Updated balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }

    private static void performDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Updated balance: $" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void performTransfer() {
        System.out.print("Enter recipient's account number: ");
        int recipientAccountNumber = scanner.nextInt();

        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            // Perform the transfer logic here
            balance -= amount;
            System.out.println("Transfer successful. Updated balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }
}
