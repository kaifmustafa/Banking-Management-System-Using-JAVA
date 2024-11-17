import java.util.Scanner;

public class Bank {
  static double balance = 0;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int option = 0;
    while (option != 4) {
      System.out.println("Welcome to the Bank of Java");
      System.out.println("1. Check Balance");
      System.out.println("2. Deposit");
      System.out.println("3. Withdraw");
      System.out.println("4. Exit");
      System.out.print("Enter an option: ");
      try {
        option = scanner.nextInt();

        switch (option) {
          case 1:
            checkBalance();
            break;
          case 2:
            deposit(scanner);
            break;
          case 3:
            withdraw(scanner);
            break;
          case 4:
            exit();
            break;
          default:
            System.out.println("Invalid option. Try again.");
            break;
        }
      } catch (Exception e) {
        System.out.println("Invalid input. Please enter a number.");
        scanner.next();  // clear the invalid input
      }
    }
    scanner.close();
  }

  public static void checkBalance() {
    System.out.println("Your current balance is $" + balance);
  }

  public static void deposit(Scanner scanner) {
    System.out.print("Enter the amount to deposit: $");
    try {
      double amount = scanner.nextDouble();
      if (amount < 0) {
        System.out.println("Deposit amount must be positive.");
      } else {
        balance += amount;
        System.out.println("$" + amount + " has been deposited to your account.");
        checkBalance();
      }
    } catch (Exception e) {
      System.out.println("Invalid amount. Please enter a number.");
      scanner.next();  // clear the invalid input
    }
  }

  public static void withdraw(Scanner scanner) {
    System.out.print("Enter the amount to withdraw: $");
    try {
      double amount = scanner.nextDouble();
      if (amount < 0) {
        System.out.println("Withdrawal amount must be positive.");
      } else if (amount > balance) {
        System.out.println("Insufficient funds.");
      } else {
        balance -= amount;
        System.out.println("$" + amount + " has been withdrawn from your account.");
        checkBalance();
      }
    } catch (Exception e) {
      System.out.println("Invalid amount. Please enter a number.");
      scanner.next();  // clear the invalid input
    }
  }

  public static void exit() {
    System.out.println("Thank you for banking with us. Have a great day!");
  }
}