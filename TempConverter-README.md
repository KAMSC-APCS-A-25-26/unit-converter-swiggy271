# TempConverter

A Java application for converting temperatures between Fahrenheit and Celsius with continuous menu selection and flexible formatting.

## Overview

The TempConverter application provides a user-friendly interface for converting temperatures between Fahrenheit and Celsius scales. It features a continuous menu system that allows users to perform multiple conversions without restarting the program, making it ideal for batch conversions or iterative calculations.

## Features

- **Continuous Operation**: Runs continuously until user chooses to exit
- **Bidirectional Conversion**: Convert Fahrenheit to Celsius or Celsius to Fahrenheit
- **Menu-Driven Interface**: Clear menu options with user choice validation
- **Multiple Conversions**: Perform unlimited conversions in a single session
- **Flexible Formatting**: Accepts any reasonable output formatting approach
- **Error Handling**: Graceful handling of invalid menu choices
- **Mathematical Accuracy**: Uses standard conversion formulas

## Menu Options

1. **Convert Fahrenheit to Celsius**: Enter Fahrenheit temperature, get Celsius equivalent
2. **Convert Celsius to Fahrenheit**: Enter Celsius temperature, get Fahrenheit equivalent  
3. **Exit**: Clean program termination with goodbye message

## Conversion Formula

The application uses the standard temperature conversion formulas:

- **Fahrenheit to Celsius**: `C = (F - 32) × 5/9`
- **Celsius to Fahrenheit**: `F = C × 9/5 + 32`

## Usage

### Running the Application

```bash
mvn exec:java -Dexec.mainClass="TempConverter"
```

### Example Session

```
Choose conversion direction:
1. Convert Fahrenheit to Celsius
2. Convert Celsius to Fahrenheit
3. Exit

Enter your choice (1, 2, or 3): 1
Enter temperature in Fahrenheit: 68.0

Conversion Results:
Fahrenheit: 68.0
Celsius: 20.0

Choose conversion direction:
1. Convert Fahrenheit to Celsius
2. Convert Celsius to Fahrenheit
3. Exit

Enter your choice (1, 2, or 3): 2
Enter temperature in Celsius: 0.0

Conversion Results:
Celsius: 0.0
Fahrenheit: 32.0

Choose conversion direction:
1. Convert Fahrenheit to Celsius
2. Convert Celsius to Fahrenheit
3. Exit

Enter your choice (1, 2, or 3): 3
Goodbye!
```

## Test Cases

The application includes comprehensive test coverage for:

- **Basic Conversions**: 32F = 0C, 212F = 100C
- **Room Temperature**: 68F ≈ 20C
- **Negative Temperatures**: -40F = -40C
- **Decimal Precision**: Handles decimal inputs like 98.6F
- **Mathematical Accuracy**: Verifies correct formula application (flexible formatting)
- **Output Formatting**: Checks for proper display format (flexible symbols)
- **Scanner Input**: Validates user input handling
- **Menu Functionality**: Tests all menu options and continuous operation
- **Exit Functionality**: Validates proper program termination


