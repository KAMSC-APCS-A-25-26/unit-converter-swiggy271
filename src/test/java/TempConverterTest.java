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

public class TempConverterTest {

    private String runProgramWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream origOut = System.out;
        java.io.InputStream origIn = System.in;

        System.setIn(in);
        System.setOut(new PrintStream(outBytes));
        try {
            TempConverter.main(new String[]{});
        } finally {
            System.setOut(origOut);
            System.setIn(origIn);
        }

        return outBytes.toString(StandardCharsets.UTF_8);
    }

    private static List<Double> extractDoubles(String output) {
        Pattern p = Pattern.compile("(\\d+\\.\\d+)");
        Matcher m = p.matcher(output);
        List<Double> numbers = new ArrayList<>();
        while (m.find()) {
            numbers.add(Double.parseDouble(m.group(1)));
        }
        return numbers;
    }


    @Test
    public void testFahrenheitToCelsiusConversion() {
        String input = "1\n32.0\n3\n";
        String output = runProgramWithInput(input);

        // 32°F should equal 0°C
        assertTrue(output.contains("32.0") || output.contains("32"), 
            "❌ Should display input Fahrenheit temperature!");
        assertTrue(output.contains("0.00") || output.contains("0.0"), 
            "❌ 32°F should convert to 0°C!");
    }

    @Test
    public void testBoilingPointConversion() {
        String input = "1\n212.0\n3\n";
        String output = runProgramWithInput(input);

        // 212°F should equal 100°C
        assertTrue(output.contains("212.0") || output.contains("212"), 
            "❌ Should display input Fahrenheit temperature!");
        assertTrue(output.contains("100.00") || output.contains("100.0"), 
            "❌ 212°F should convert to 100°C!");
    }

    @Test
    public void testRoomTemperatureConversion() {
        String input = "1\n68.0\n3\n";
        String output = runProgramWithInput(input);

        // 68°F should equal approximately 20°C
        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectCelsius = false;
        for (Double d : doubles) {
            if (Math.abs(d - 20.0) < 1.0) {
                hasCorrectCelsius = true;
                break;
            }
        }
        assertTrue(hasCorrectCelsius, "❌ 68°F should convert to approximately 20°C!");
    }

    @Test
    public void testNegativeTemperatureConversion() {
        String input = "1\n-40.0\n3\n";
        String output = runProgramWithInput(input);

        // -40°F should equal -40°C
        assertTrue(output.contains("-40.0") || output.contains("-40"), 
            "❌ Should handle negative temperatures!");
        assertTrue(output.contains("-40.00") || output.contains("-40.0"), 
            "❌ -40°F should convert to -40°C!");
    }

    @Test
    public void testConversionFormula() {
        String input = "1\n50.0\n3\n";
        String output = runProgramWithInput(input);

        // 50°F should equal 10°C (50-32)*5/9 = 10
        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectCelsius = false;
        for (Double d : doubles) {
            if (Math.abs(d - 10.0) < 0.1) {
                hasCorrectCelsius = true;
                break;
            }
        }
        assertTrue(hasCorrectCelsius, "❌ 50°F should convert to 10°C!");
    }

    @Test
    public void testBidirectionalConversion() {
        String input = "1\n86.0\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Fahrenheit: 86.0"), 
            "❌ Should display Fahrenheit input!");
        assertTrue(output.contains("Celsius: 30.0"), 
            "❌ Should display Celsius conversion!");
    }

    @Test
    public void testDecimalPrecision() {
        String input = "1\n98.6\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("98.6") || output.contains("98"), 
            "❌ Should handle decimal temperature inputs!");
        
        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectCelsius = false;
        for (Double d : doubles) {
            if (Math.abs(d - 37.0) < 1.0) {
                hasCorrectCelsius = true;
                break;
            }
        }
        assertTrue(hasCorrectCelsius, "❌ 98.6°F should convert to approximately 37°C!");
    }


    @Test
    public void testNoCompilationErrors() {
        String input = "1\n100.0\n3\n";
        String output = runProgramWithInput(input);

        assertFalse(output.contains("Exception"), "❌ Program should not throw exceptions!");
        assertFalse(output.contains("Error"), "❌ Program should not display error messages!");
        assertTrue(output.length() > 50, "❌ Program should produce meaningful output!");
    }

    @Test
    public void testScannerUsage() {
        String input = "1\n25.5\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("25.5") || output.contains("25"), 
            "❌ Program should read and use scanner input!");
    }

    @Test
    public void testMathematicalAccuracy() {
        String input = "1\n0.0\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("-17.77"), 
            "❌ 0°F should convert to approximately -17.78°C!");
    }

    @Test
    public void testCelsiusToFahrenheitConversion() {
        String input = "2\n0.0\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("0.0"), 
            "❌ Should display input Celsius!");
        assertTrue(output.contains("32.0"), 
            "❌ 0°C should convert to 32°F!");
    }

    @Test
    public void testCelsiusToFahrenheitFormula() {
        String input = "2\n100.0\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("100.0"), 
            "❌ Should display input Celsius!");
        assertTrue(output.contains("212.0"), 
            "❌ 100°C should convert to 212°F!");
    }

    @Test
    public void testExitOption() {
        String input = "3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Goodbye!"), 
            "❌ Should display goodbye message when exiting!");
    }


    @Test
    public void testMultipleConversions() {
        String input = "1\n32.0\n2\n0.0\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Fahrenheit: 32.0"), 
            "❌ Should perform Fahrenheit to Celsius conversion!");
        assertTrue(output.contains("Celsius: 0.0"), 
            "❌ Should perform Celsius to Fahrenheit conversion!");
        assertTrue(output.contains("Goodbye!"), 
            "❌ Should exit after both conversions!");
    }

    @Test
    public void testLoopingFunctionality() {
        String input = "1\n32.0\n2\n0.0\n3\n";
        String output = runProgramWithInput(input);

        List<Double> doubles = extractDoubles(output);
        assertTrue(doubles.size() >= 4, "❌ Should perform multiple conversions in loop!");
        
        assertTrue(output.contains("32.0") || output.contains("32"), 
            "❌ Should handle first conversion!");
        assertTrue(output.contains("0.0") || output.contains("0"), 
            "❌ Should handle second conversion!");
    }
}
