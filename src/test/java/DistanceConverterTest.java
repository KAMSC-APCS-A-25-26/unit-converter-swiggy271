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

public class DistanceConverterTest {

    private String runProgramWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream origOut = System.out;
        java.io.InputStream origIn = System.in;

        System.setIn(in);
        System.setOut(new PrintStream(outBytes));
        try {
            DistanceConverter.main(new String[]{});
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
    public void testOneMileConversion() {
        String input = "1\n1.0\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("1.0") || output.contains("1"), 
            "❌ Should display input miles!");
        
        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectKilometers = false;
        for (Double d : doubles) {
            if (Math.abs(d - 1.60935) < 0.0001) {
                hasCorrectKilometers = true;
                break;
            }
        }
        assertTrue(hasCorrectKilometers, "❌ 1 mile should convert to approximately 1.60935 kilometers!");
    }

    @Test
    public void testTenMilesConversion() {
        String input = "1\n10.0\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("10.0") || output.contains("10"), 
            "❌ Should display input miles!");
        
        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectKilometers = false;
        for (Double d : doubles) {
            if (Math.abs(d - 16.0935) < 0.0001) {
                hasCorrectKilometers = true;
                break;
            }
        }
        assertTrue(hasCorrectKilometers, "❌ 10 miles should convert to approximately 16.0935 kilometers!");
    }

    @Test
    public void testHalfMileConversion() {
        String input = "1\n0.5\n3\n";
        String output = runProgramWithInput(input);

        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectKilometers = false;
        for (Double d : doubles) {
            if (Math.abs(d - 0.804675) < 0.0001) {
                hasCorrectKilometers = true;
                break;
            }
        }
        assertTrue(hasCorrectKilometers, "❌ 0.5 miles should convert to approximately 0.804675 kilometers!");
    }

    @Test
    public void testConversionFormula() {
        String input = "1\n5.0\n3\n";
        String output = runProgramWithInput(input);

        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectKilometers = false;
        for (Double d : doubles) {
            if (Math.abs(d - 8.04675) < 0.0001) {
                hasCorrectKilometers = true;
                break;
            }
        }
        assertTrue(hasCorrectKilometers, "❌ 5 miles should convert to 8.04675 kilometers!");
    }

    @Test
    public void testBidirectionalConversion() {
        String input = "1\n2.0\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Miles:") || output.contains("miles:"), 
            "❌ Should display miles input!");
        assertTrue(output.contains("Kilometers:") || output.contains("kilometers:"), 
            "❌ Should display kilometers conversion!");
        
        String input2 = "2\n3.2187\n3\n";
        String output2 = runProgramWithInput(input2);
        assertTrue(output2.contains("Kilometers:") || output2.contains("kilometers:"), 
            "❌ Should display kilometers input!");
        assertTrue(output2.contains("Miles:") || output2.contains("miles:"), 
            "❌ Should display miles conversion!");
    }

    @Test
    public void testDecimalInputHandling() {
        String input = "1\n1.5\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("1.5") || output.contains("1"), 
            "❌ Should handle decimal distance inputs!");
        
        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectKilometers = false;
        for (Double d : doubles) {
            if (Math.abs(d - 2.414025) < 0.0001) {
                hasCorrectKilometers = true;
                break;
            }
        }
        assertTrue(hasCorrectKilometers, "❌ 1.5 miles should convert to approximately 2.414025 kilometers!");
    }


    @Test
    public void testHundredMilesConversion() {
        String input = "1\n100.0\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("100.0") || output.contains("100"), 
            "❌ Should display input miles!");
        
        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectKilometers = false;
        for (Double d : doubles) {
            if (Math.abs(d - 160.935) < 0.0001) {
                hasCorrectKilometers = true;
                break;
            }
        }
        assertTrue(hasCorrectKilometers, "❌ 100 miles should convert to approximately 160.935 kilometers!");
    }

    @Test
    public void testNoCompilationErrors() {
        String input = "1\n7.5\n3\n";
        String output = runProgramWithInput(input);

        assertFalse(output.contains("Exception"), "❌ Program should not throw exceptions!");
        assertFalse(output.contains("Error"), "❌ Program should not display error messages!");
        assertTrue(output.length() > 50, "❌ Program should produce meaningful output!");
    }

    @Test
    public void testScannerUsage() {
        String input = "1\n2.5\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("2.5") || output.contains("2"), 
            "❌ Program should read and use scanner input!");
    }

    @Test
    public void testConversionConstant() {
        String input = "1\n1.0\n3\n";
        String output = runProgramWithInput(input);

        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectConstant = false;
        for (Double d : doubles) {
            if (Math.abs(d - 1.60935) < 0.0001) {
                hasCorrectConstant = true;
                break;
            }
        }
        assertTrue(hasCorrectConstant, "❌ Should use the correct conversion constant 1.60935!");
    }

    @Test
    public void testMathematicalAccuracy() {
        String input = "1\n5.0\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("5.0") || output.contains("5"), 
            "❌ Should handle decimal distance!");
        
        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectKilometers = false;
        for (Double d : doubles) {
            if (Math.abs(d - 8.04675) < 0.0001) {
                hasCorrectKilometers = true;
                break;
            }
        }
        assertTrue(hasCorrectKilometers, "❌ 5 miles should equal 8.04675 kilometers!");
    }

    @Test
    public void testKilometersToMilesConversion() {
        String input = "2\n1.60935\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("1.60935"), 
            "❌ Should display input kilometers!");
        
        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectMiles = false;
        for (Double d : doubles) {
            if (Math.abs(d - 1.0) < 0.0001) {
                hasCorrectMiles = true;
                break;
            }
        }
        assertTrue(hasCorrectMiles, "❌ 1.60935 kilometers should convert to approximately 1 mile!");
    }

    @Test
    public void testKilometersToMilesFormula() {
        String input = "2\n5.0\n3\n";
        String output = runProgramWithInput(input);

        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectMiles = false;
        for (Double d : doubles) {
            if (Math.abs(d - 3.10686) < 0.0001) {
                hasCorrectMiles = true;
                break;
            }
        }
        assertTrue(hasCorrectMiles, "❌ 5 kilometers should convert to approximately 3.10686 miles!");
    }



    @Test
    public void testMultipleConversions() {
        String input = "1\n2.0\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Miles: 2.0"), 
            "❌ Should perform first conversion!");
        
        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectKilometers = false;
        for (Double d : doubles) {
            if (Math.abs(d - 3.2187) < 0.0001) {
                hasCorrectKilometers = true;
                break;
            }
        }
        assertTrue(hasCorrectKilometers, "❌ Should show correct conversion result!");
        assertTrue(output.contains("Goodbye!"), 
            "❌ Should exit after conversion!");
    }

    @Test
    public void testLoopBehavior() {
        String input = "1\n1.0\n2\n1.60935\n3\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Miles: 1.0"), 
            "❌ Should perform miles to km conversion!");
        assertTrue(output.contains("Kilometers: 1.60935"), 
            "❌ Should perform km to miles conversion!");
        
        List<Double> doubles = extractDoubles(output);
        boolean hasCorrectMilesToKm = false;
        boolean hasCorrectKmToMiles = false;
        
        for (Double d : doubles) {
            if (Math.abs(d - 1.60935) < 0.0001) {
                hasCorrectMilesToKm = true;
            }
            if (Math.abs(d - 1.0) < 0.0001) {
                hasCorrectKmToMiles = true;
            }
        }
        
        assertTrue(hasCorrectMilesToKm, "❌ Should show correct miles to km conversion!");
        assertTrue(hasCorrectKmToMiles, "❌ Should show correct km to miles conversion!");
        assertTrue(output.contains("Goodbye!"), 
            "❌ Should exit after both conversions!");
    }

    @Test
    public void testLoopingFunctionality() {
        String input = "1\n5.0\n1\n10.0\n3\n";
        String output = runProgramWithInput(input);

        List<Double> doubles = extractDoubles(output);
        assertTrue(doubles.size() >= 4, "❌ Should perform multiple conversions in loop!");
        
        assertTrue(output.contains("5.0") || output.contains("5"), 
            "❌ Should handle first conversion!");
        assertTrue(output.contains("10.0") || output.contains("10"), 
            "❌ Should handle second conversion!");
    }


}
