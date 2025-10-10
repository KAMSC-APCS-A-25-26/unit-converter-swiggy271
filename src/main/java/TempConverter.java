import java.util.Scanner;
import java.text.DecimalFormat;

public class TempConverter {
    public static void main(String[] args) {
        // TODO: Implement distance converter
        boolean running = true;
        double input, result;
        int choice;
        Scanner scan = new Scanner(System.in);
        DecimalFormat form = new DecimalFormat("#0.0");
        while (running)
        {
            System.out.print("\n\nChoose Conversion Direction\n1. Convert Fahrenheit to Celsius\n2. Convert Celsius to Fahrenheit\n3. Exit\n\nEnter your choice (1, 2, or 3): ");
            choice = scan.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    input = scan.nextDouble();
                    result = (input - 32) * (5.0/9);
                    form.format(result);
                    System.out.print("\nConversion results:\nFahrenheit: " + input + "\nCelsius: " + result);
                    break;
                case 2:
                    System.out.print("Enter temperature in Celsius: ");
                    input = scan.nextDouble();
                    result = (input * (9.0/5)) + 32;
                    form.format(result);
                    System.out.print("\nConversion results:\nCelsius: " + input + "\nFahrenheit: " + result);
                    break;
                case 3:
                    System.out.print("\nGoodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("try again");
                    break;
            }
        }
    }
}