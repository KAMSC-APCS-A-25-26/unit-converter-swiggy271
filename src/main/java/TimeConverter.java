import java.util.Scanner;
import java.text.DecimalFormat;

public class TimeConverter {
    public static void main(String[] args) {
        // TODO: Implement distance converter
        boolean running = true;
        double hrs, mins, secs, result;
        int choice;
        Scanner scan = new Scanner(System.in);
        DecimalFormat form = new DecimalFormat("#0.0");
        while (running)
        {
            System.out.println("\n\nTime converter\n\nEnter hrs:  ");
            hrs = scan.nextInt();
            System.out.println("\nEnter mins:  ");
            mins = scan.nextInt();
            System.out.println("\nEnter secs:  ");
            secs = scan.nextInt();

            System.out.println("\n\nCalculation:\n" + hrs + " hours * 3600 = " (hrs*3600) + " secs");
            System.out.println("mins " +  mins * 60 + " = " (mins * 60) + " secs");
            

        }
    }
}