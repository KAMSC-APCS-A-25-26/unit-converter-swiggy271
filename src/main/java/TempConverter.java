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
            System.out.println("\n\nTemp Converter\n1. F ->C\n2. C -> F\n3. Exit");
            choice = scan.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("\n\nEnter degrees F :  ");
                    input = scan.nextDouble();
                    result = (input - 32) * (5/9);
                    form.format(result);
                    System.out.println("\nResult:  " + result);
                    break;
                case 2:
                    System.out.println("\n\nEnter degrees C :  ");
                    input = scan.nextDouble();
                    result = (input * (9/5)) + 32;
                    form.format(result);
                    System.out.println("\nResult:  " + result);
                    break;
                case 3:
                    System.out.println("\nGoodbye");
                    running = false;
                    break;
                default:
                    System.out.println("try again");
                    break;
            }
        }
    }
}