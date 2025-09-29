import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConverterTest {

    private String runProgramWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream origOut = System.out;
        java.io.InputStream origIn = System.in;

        System.setIn(in);
        System.setOut(new PrintStream(outBytes));
        try {
            TimeConverter.main(new String[]{});
        } finally {
            System.setOut(origOut);
            System.setIn(origIn);
        }

        return outBytes.toString(StandardCharsets.UTF_8);
    }

    private static List<Integer> extractIntegers(String output) {
        Pattern p = Pattern.compile("\\b(\\d+)\\b");
        Matcher m = p.matcher(output);
        List<Integer> numbers = new ArrayList<>();
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group(1)));
        }
        return numbers;
    }

    @Test
    public void testProgramStructure() {
        String input = "1\n28\n42\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Convert time to total seconds"), 
            "❌ Should display time converter description!");
        assertTrue(output.contains("hours") || output.contains("Hours"), 
            "❌ Should mention hours!");
        assertTrue(output.contains("minutes") || output.contains("Minutes"), 
            "❌ Should mention minutes!");
        assertTrue(output.contains("seconds") || output.contains("Seconds"), 
            "❌ Should mention seconds!");
        assertTrue(output.contains("Enter hours"), 
            "❌ Should prompt for hours input!");
        assertTrue(output.contains("Do you want to convert another time?"), 
            "❌ Should ask if user wants to go again!");
    }

    @Test
    public void testExampleConversion() {
        String input = "1\n28\n42\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("1") && output.contains("28") && output.contains("42"), 
            "❌ Should display input time components!");
        assertTrue(output.contains("5322"), 
            "❌ 1 hour, 28 minutes, 42 seconds should equal 5322 seconds!");
    }

    @Test
    public void testOneHourConversion() {
        String input = "1\n0\n0\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("1") && output.contains("0"), 
            "❌ Should display input time!");
        assertTrue(output.contains("3600"), 
            "❌ 1 hour should equal 3600 seconds!");
    }

    @Test
    public void testOneMinuteConversion() {
        String input = "0\n1\n0\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("1"), 
            "❌ Should display input time!");
        assertTrue(output.contains("60"), 
            "❌ 1 minute should equal 60 seconds!");
    }

    @Test
    public void testOneSecondConversion() {
        String input = "0\n0\n1\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("1"), 
            "❌ Should display input time!");
        assertTrue(output.contains("Total seconds: 1"), 
            "❌ 1 second should equal 1 second!");
    }

    @Test
    public void testComplexTimeConversion() {
        String input = "2\n15\n30\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("2") && output.contains("15") && output.contains("30"), 
            "❌ Should display input time components!");
        assertTrue(output.contains("8130"), 
            "❌ 2 hours, 15 minutes, 30 seconds should equal 8130 seconds!");
    }

    @Test
    public void testCalculationBreakdown() {
        String input = "1\n28\n42\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Calculation:"), 
            "❌ Should show calculation breakdown!");
        assertTrue(output.contains("3600"), 
            "❌ Should show hours × 3600 calculation!");
        assertTrue(output.contains("1680"), 
            "❌ Should show minutes × 60 calculation (28 × 60 = 1680)!");
        assertTrue(output.contains("42"), 
            "❌ Should show seconds value!");
    }

    @Test
    public void testInputPrompts() {
        String input = "1\n28\n42\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Enter hours"), 
            "❌ Should prompt for hours!");
        assertTrue(output.contains("Enter minutes"), 
            "❌ Should prompt for minutes!");
        assertTrue(output.contains("Enter seconds"), 
            "❌ Should prompt for seconds!");
    }

    @Test
    public void testOutputFormatting() {
        String input = "1\n28\n42\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("hour") || output.contains("Hour"), 
            "❌ Should format hours correctly!");
        assertTrue(output.contains("minute") || output.contains("Minute"), 
            "❌ Should format minutes correctly!");
        assertTrue(output.contains("second") || output.contains("Second"), 
            "❌ Should format seconds correctly!");
        assertTrue(output.contains("Total seconds:"), 
            "❌ Should have 'Total seconds:' label!");
    }

    @Test
    public void testLargeTimeConversion() {
        String input = "5\n30\n45\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("5") && output.contains("30") && output.contains("45"), 
            "❌ Should display input time!");
        assertTrue(output.contains("19845"), 
            "❌ 5 hours, 30 minutes, 45 seconds should equal 19845 seconds!");
    }

    @Test
    public void testNoCompilationErrors() {
        String input = "1\n28\n42\nn\n";
        String output = runProgramWithInput(input);

        assertFalse(output.contains("Exception"), "❌ Program should not throw exceptions!");
        assertFalse(output.contains("Error"), "❌ Program should not display error messages!");
        assertTrue(output.length() > 50, "❌ Program should produce meaningful output!");
    }

    @Test
    public void testScannerUsage() {
        String input = "2\n15\n30\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("2") && output.contains("15") && output.contains("30"), 
            "❌ Program should read and use scanner input!");
    }

    @Test
    public void testMathematicalAccuracy() {
        String input = "0\n59\n59\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("59"), 
            "❌ Should display input time!");
        assertTrue(output.contains("3599"), 
            "❌ 0 hours, 59 minutes, 59 seconds should equal 3599 seconds!");
    }

    @Test
    public void testTimeConversionFormula() {
        String input = "3\n20\n10\nn\n";
        String output = runProgramWithInput(input);

        List<Integer> integers = extractIntegers(output);
        boolean hasCorrectTotal = integers.contains(12010);
        assertTrue(hasCorrectTotal, "❌ 3 hours, 20 minutes, 10 seconds should equal 12010 seconds!");
    }

    @Test
    public void testLoopingFunctionality() {
        String input = "1\n0\n0\ny\n2\n0\n0\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("3600"), "❌ First conversion should show 3600 seconds!");
        assertTrue(output.contains("7200"), "❌ Second conversion should show 7200 seconds!");
        assertTrue(output.contains("Do you want to convert another time?"), 
            "❌ Should ask if user wants to go again!");
        assertTrue(output.contains("Goodbye!"), "❌ Should say goodbye when exiting!");
    }

    @Test
    public void testExitFunctionality() {
        String input = "1\n28\n42\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Do you want to convert another time?"), 
            "❌ Should ask if user wants to go again!");
        assertTrue(output.contains("Goodbye!"), "❌ Should say goodbye when exiting!");
    }

    @Test
    public void testMultipleConversions() {
        String input = "0\n1\n0\ny\n0\n0\n1\ny\n1\n0\n0\nn\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("60"), "❌ First conversion should show 60 seconds!");
        assertTrue(output.contains("1"), "❌ Second conversion should show 1 second!");
        assertTrue(output.contains("3600"), "❌ Third conversion should show 3600 seconds!");
    }
}
