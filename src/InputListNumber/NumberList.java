package InputListNumber;

import java.util.Scanner;

public class NumberList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char choice;
        int[] numbers = new int[0];
        int totalNumbers = 0;

        do {
            // Input phase
            System.out.println("Enter numbers (enter a non-integer to finish):");

            // Temporary array to store the current round of input
            int[] tempNumbers = new int[0];
            int input;

            // Read the entire line as a string
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt();

                    // Resize the temporary array and copy elements
                    tempNumbers = resizeArray(tempNumbers, tempNumbers.length + 1);
                    tempNumbers[tempNumbers.length - 1] = input;
                } else {
                    // Consume non-integer input to prevent infinite loop
                    scanner.next();
                    break;
                }
            }

            // Resize the main array to accommodate the new numbers
            int newSize = totalNumbers + tempNumbers.length;
            numbers = resizeArray(numbers, newSize);

            // Copy elements from the temporary array to the main array
            System.arraycopy(tempNumbers, 0, numbers, totalNumbers, tempNumbers.length);

            // Update the total number count
            totalNumbers += tempNumbers.length;

            // Display phase
            System.out.println("Input numbers:");
            for (int i = 0; i < totalNumbers; i++) {
                System.out.println(numbers[i]);
            }

            // Ask the user if they want to enter more numbers
            System.out.print("Do you want to enter more numbers? (y/n): ");
            choice = scanner.next().charAt(0);

            // Consume the newline character
            scanner.nextLine();

        } while (Character.toLowerCase(choice) == 'y');

        // Close the scanner
        scanner.close();
    }

    // Function to resize the array
    private static int[] resizeArray(int[] array, int newSize) {
        int[] newArray = new int[newSize];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }
}
