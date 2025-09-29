# DistanceConverter

A Java application for converting distances between miles and kilometers with continuous menu selection and flexible formatting.

## Overview

The DistanceConverter application provides a user-friendly interface for converting distances between miles and kilometers. It features a continuous menu system that allows users to perform multiple conversions without restarting the program, making it ideal for batch conversions or iterative calculations.

## Features

- **Continuous Operation**: Runs continuously until user chooses to exit
- **Bidirectional Conversion**: Convert miles to kilometers or kilometers to miles
- **Menu-Driven Interface**: Clear menu options with user choice validation
- **Multiple Conversions**: Perform unlimited conversions in a single session
- **Flexible Formatting**: Accepts any reasonable output formatting approach
- **Error Handling**: Graceful handling of invalid menu choices
- **Mathematical Accuracy**: Uses precise conversion factor (1 mile = 1.60935 km)

## Conversion Formula

The application uses the standard distance conversion factor:

- **Miles to Kilometers**
- **Kilometers to Miles**

## Usage


### Example Session

```
Choose conversion direction:
1. Convert Miles to Kilometers
2. Convert Kilometers to Miles
3. Exit

Enter your choice (1, 2, or 3): 1
Enter distance in miles: 5.0

Conversion Results:
Miles: 5.0
Kilometers: 8.04675

Choose conversion direction:
1. Convert Miles to Kilometers
2. Convert Kilometers to Miles
3. Exit

Enter your choice (1, 2, or 3): 2
Enter distance in kilometers: 10.0

Conversion Results:
Kilometers: 10.0
Miles: 6.21371

Choose conversion direction:
1. Convert Miles to Kilometers
2. Convert Kilometers to Miles
3. Exit

Enter your choice (1, 2, or 3): 3
Goodbye!
```

## Menu Options

1. **Convert Miles to Kilometers**: Enter miles, get kilometers equivalent
2. **Convert Kilometers to Miles**: Enter kilometers, get miles equivalent  
3. **Exit**: Clean program termination with goodbye message

## Test Cases

The application includes comprehensive test coverage for:

- **Menu Functionality**: All three menu options work correctly
- **Mathematical Accuracy**: Verifies correct conversion calculations (flexible formatting)
- **Continuous Operation**: Tests multiple conversions in sequence
- **Loop Behavior**: Validates continuous menu display
- **Input Validation**: Handles invalid menu choices gracefully
- **Scanner Input**: Validates user input handling
- **Exit Functionality**: Proper program termination

## Error Handling

The application handles various scenarios:
- Invalid menu choices (e.g., entering 4 instead of 1-3)
- Zero distance values
- Normal decimal distance inputs (e.g., 2.5 miles)
- Normal large distance values
- Non-numeric input (handled by Scanner)


