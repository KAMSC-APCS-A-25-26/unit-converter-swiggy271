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
            System.out.println("\n\nDistance Converter\n1. M ->km\n2. km -> M\n3. Exit");
            choice = scan.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("\n\nEnter # miles :  ");
                    input = scan.nextDouble();
                    result = input * 1.60935;
                    form.format(result);
                    System.out.println("\nResult:  " + result);
                    break;
                case 2:
                    System.out.println("\n\nEnter # kilometers :  ");
                    input = scan.nextDouble();
                    result = input / 1.60935;
                    form.format(result);
                    System.out.println("\nResult:  " + result);
                    break;
                case 3:
                    System.out.println("\nGoodbye");
                    running = false;
                    break;
                default:
                    System.out.println("try again idiot");
                    break;
            }
        }
    }
}