import java.util.Scanner;

class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMWithdrawalSystem {
    private static final int PIN = 1234;
    private static double balance = 3000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter PIN: ");
            int enteredPIN = scanner.nextInt();
            
            if (enteredPIN != PIN) {
                throw new InvalidPINException("Error: Invalid PIN.");
            }
            
            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();
            
            if (amount > balance) {
                throw new InsufficientBalanceException("Error: Insufficient balance.");
            }
            
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: " + balance);
        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println(e.getMessage() + " Current Balance: " + balance);
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            System.out.println("Final Balance: " + balance);
            scanner.close();
        }
    }
}
