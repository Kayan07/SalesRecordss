package Q1;

import java.util.Scanner;

public class SalesRecords {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask how many sales
        System.out.print("Enter number of sales: ");
        int numSales = input.nextInt();
        input.nextLine(); // clear enter

        // Arrays to store sales
        String[] customers = new String[numSales];
        String[] products = new String[numSales];
        double[] prices = new double[numSales];
        double[] vats = new double[numSales];
        double[] commissions = new double[numSales];
        double[] totals = new double[numSales];

        // Capture each sale
        for (int i = 0; i < numSales; i++) {
            System.out.println("\n--- Sale " + (i + 1) + " ---");

            System.out.print("Enter customer name: ");
            customers[i] = input.nextLine();

            System.out.println("Select product:");
            System.out.println("1. Cozy Nights Monarch");
            System.out.println("2. Restonic Barbados");
            System.out.println("3. Sealy Phuket");
            System.out.print("Enter choice (1-3): ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                products[i] = "Cozy Nights Monarch";
            } else if (choice == 2) {
                products[i] = "Restonic Barbados";
            } else {
                products[i] = "Sealy Phuket";
            }

            System.out.print("Enter price: ");
            prices[i] = input.nextDouble();
            input.nextLine();

            // Calculations - same as Q2
            vats[i] = prices[i] * 0.15;
            commissions[i] = prices[i] * 0.05;
            totals[i] = prices[i] + vats[i] + commissions[i];
        }

        // Display all sales
        System.out.println("\n========== SALES REPORT ==========");
        for (int i = 0; i < numSales; i++) {
            System.out.println("Customer: " + customers[i]);
            System.out.println("Product: " + products[i]);
            System.out.println("Price: R " + prices[i]);
            System.out.println("VAT: R " + vats[i]);
            System.out.println("Commission: R " + commissions[i]);
            System.out.println("Total: R " + totals[i]);
            System.out.println("---------------------------------");
        }

        input.close();
    }
}
