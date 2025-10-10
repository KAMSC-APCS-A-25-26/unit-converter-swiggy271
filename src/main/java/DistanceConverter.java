import java.util.Scanner;
import java.text.DecimalFormat;

public class DistanceConverter {
    public static void main(String[] args) {
        // TODO: Implement distance converter
        boolean running = true;
        double input, result;
        int choice;
        Scanner scan = new Scanner(System.in);
        DecimalFormat form = new DecimalFormat("0.00000");
        while (running)
        {
            System.out.print("\n\nChoose conversion direction:\n1. Convert Miles to Kilometers\n2. Convert Kilometers to Miles\n3. Exit\n\nEnter your choice (1, 2, or 3): ");
            choice = scan.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("\nEnter distance in miles: ");
                    input = scan.nextDouble();
                    result = input * 1.60935;
                    form.format(result);
                    System.out.println("\nConversion results:\nMiles: " + input + "\nKilometers: " + result);
                    break;
                case 2:
                    System.out.println("Enter distance in kilometers: ");
                    input = scan.nextDouble();
                    result = input / 1.60935;
                    form.format(result);
                    System.out.println("\nConversion results:\nKilometers: " + input + "\nMiles: " + result);
                    break;
                case 3:
                    System.out.println("\nGoodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("try again idiot");
                    break;
            }
        }
    }
}