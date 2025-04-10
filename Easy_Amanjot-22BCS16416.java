import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        try {
            double num = scanner.nextDouble();
            
            if (num < 0) {
                System.out.println("Error: Cannot calculate the square root of a negative number.");
            } else {
                double sqrt = Math.sqrt(num);
                System.out.println("Square root: " + sqrt);
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } finally {
            scanner.close();
        }
    }
}
