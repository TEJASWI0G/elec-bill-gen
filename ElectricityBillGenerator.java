import java.util.Scanner;

public class ElectricityBillGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the user's name
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        // Get the user's electricity usage in kilowatt-hours (kWh)
        System.out.print("Enter your electricity usage in kWh: ");
        double usage = sc.nextDouble();

        // Calculate the total bill based on the electricity usage
        double rate = 0;
        if (usage <= 100) {
            rate = 1.20;
        } else if (usage <= 300) {
            rate = 2.00;
        } else if (usage <= 500) {
            rate = 3.00;
        } else {
            rate = 4.00;
        }
        double bill = usage * rate;

        // Print the electricity bill to the console
        System.out.println("\nElectricity Bill");
        System.out.println("Name: " + name);
        System.out.println("Usage: " + usage + " kWh");
        System.out.println("Rate: RM " + rate + " per kWh");
        System.out.println("Total Bill: RM " + bill);
    }
}