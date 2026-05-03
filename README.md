# OASIS Task 2 - Guess the Number

This is a Java dialog-box based number guessing game. The computer generates a random number and the player has to guess it within a limited number of attempts.

## Features

- Random number generation from 1 to 100
- User input through `JOptionPane` dialog boxes
- Higher or lower hints after each wrong guess
- Limited attempts per round
- Multiple rounds
- Score calculation based on attempts used
- Final score display

## Game Rules

- The number is between 1 and 100.
- Each round gives 7 attempts.
- There are 3 rounds in total.
- Fewer attempts earn more points.

## Files

- `GuessTheNumber.java` - main Java source file

## How to Run

Open a terminal in this folder and run:

```bash
javac GuessTheNumber.java
java GuessTheNumber
```

## Requirements

- Java JDK 8 or later
- Desktop environment that supports Java Swing dialogs
