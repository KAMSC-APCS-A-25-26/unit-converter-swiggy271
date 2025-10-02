import java.util.Scanner;
import java.lang.String;
import java.text.DecimalFormat;

public class TimeConverter {
    public static void main(String[] args) {
        // TODO: Implement distance converter
        boolean running = true;
        double hrs, mins, secs, result;
        int choice;
        String repeat;
        Scanner scan = new Scanner(System.in);
        DecimalFormat form = new DecimalFormat("#0.0");
        while (running)
        {
            System.out.println("\n\nTime converter\n\nEnter hours:  ");
            hrs = scan.nextInt();
            System.out.println("\nEnter minutes:  ");
            mins = scan.nextInt();
            System.out.println("\nEnter seconds:  ");
            secs = scan.nextInt();

            System.out.println("\n\nCalculation:\n" + hrs + " hours * 3600 = " + (hrs*3600) + " secs");
            System.out.println( mins + "mins * 60" + " = " + (mins * 60) + " secs");
            System.out.println( secs + " secs = " + secs);
            System.out.println("Total second: " + ((hrs*3600)+(mins*60)+secs));

            System.out.println("\n\nDo you want to convert another time? (y/n): ");
            repeat = scan.next();
            if (repeat.equals("y") != true)
            {
                System.out.println("Goodbye!");
                running = false;
            }
        }
    }
}