import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File inputFile = new File("items.txt");
        File outputFile = new File("total.txt");

        try {
            Scanner scanner = new Scanner(inputFile);
            PrintWriter writer = new PrintWriter(outputFile);

            double subTotal = 0;
            double tax;
            double total;

            while (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                subTotal += value;
            }

            tax = subTotal * 0.053;
            total = subTotal + tax;

            writer.printf("The sub-total is $%.2f%n", subTotal);
            writer.printf("The tax is $%.2f%n", tax);
            writer.printf("The total is $%.2f%n", total);

            scanner.close();
            writer.close();

            System.out.println("Calculation completed. Check total for the results.");

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}