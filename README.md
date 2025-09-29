[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/jlcrjrNQ)
# Unit Converter

A Java application suite for converting between different units of measurement, including temperature, distance, and time conversions.

## Applications

### 1. TempConverter
Converts temperatures between Fahrenheit and Celsius.
- Reads Fahrenheit temperature from user input
- Converts to Celsius using the formula: C = (F - 32) × 5/9
- Shows bidirectional conversion

### 2. DistanceConverter
Converts distances between miles and kilometers with continuous menu selection.
- Presents menu options: 1) Miles to Kilometers, 2) Kilometers to Miles, 3) Exit
- Runs continuously until user chooses to exit (option 3)
- Allows multiple conversions without restarting the program
- Converts using the conversion factor: 1 mile = 1.60935 kilometers
- Handles invalid menu choices with error messages
- Provides clean exit option with goodbye message

### 3. TimeConverter
Converts time components to total seconds.
- Reads hours, minutes, and seconds from user input
- Converts to total seconds using: total = hours × 3600 + minutes × 60 + seconds
- Shows calculation breakdown



## Test Coverage

Each application includes comprehensive test suites that verify:
- Correct mathematical conversions
- Input validation and handling
- Menu functionality and user choices
- Edge cases and boundary conditions
- Scanner input functionality
- Error handling
- Loop behavior and continuous operation
