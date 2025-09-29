# TimeConverter

A Java application that converts time components (hours, minutes, seconds) into total seconds with interactive looping functionality.

## Overview

The TimeConverter application prompts users to enter time values in hours, minutes, and seconds, then calculates and displays the equivalent total seconds. The application includes a calculation breakdown showing how the conversion is performed and allows users to perform multiple conversions in a single session.

## Features

- **Interactive Input**: Prompts for hours, minutes, and seconds
- **Total Seconds Calculation**: Converts time components to total seconds
- **Calculation Breakdown**: Shows step-by-step conversion process
- **Continuous Operation**: Allows multiple conversions until user chooses to exit
- **Flexible Formatting**: Focuses on mathematical accuracy over specific formatting


### Example Session

```
Convert time to total seconds

Enter hours: 1
Enter minutes: 28
Enter seconds: 42

Time Conversion:
Input: 1 hour, 28 minute, and 42 second
Total seconds: 5322 seconds

Calculation:
1 hours × 3600 = 3600 seconds
28 minutes × 60 = 1680 seconds
42 seconds = 42 seconds
Total: 5322 seconds

Do you want to convert another time? (y/n): y

Convert time to total seconds

Enter hours: 2
Enter minutes: 15
Enter seconds: 30

Time Conversion:
Input: 2 hour, 15 minute, and 30 second
Total seconds: 8130 seconds

Calculation:
2 hours × 3600 = 7200 seconds
15 minutes × 60 = 900 seconds
30 seconds = 30 seconds
Total: 8130 seconds

Do you want to convert another time? (y/n): n
Goodbye!
```

## Conversion Formula

Use the standard time conversion formula, you should know this!


## Test Cases

The application includes comprehensive test coverage:

- **Program Structure**: Validates proper prompts and looping functionality
- **Example Conversion**: Tests the standard 1 hour, 28 minutes, 42 seconds example
- **Unit Conversions**: Tests individual hour, minute, and second conversions
- **Complex Conversions**: Tests multi-component time values
- **Calculation Breakdown**: Verifies step-by-step calculation display
- **Input Prompts**: Validates proper user input prompts
- **Output Formatting**: Checks flexible output formatting
- **Large Time Values**: Tests larger time conversions
- **Mathematical Accuracy**: Verifies correct calculations
- **Looping Functionality**: Tests continuous operation and exit behavior
- **Multiple Conversions**: Validates multiple conversions in sequence
