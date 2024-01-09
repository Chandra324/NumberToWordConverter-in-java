import java.util.Scanner;

public class NumbertoWord {
    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String convertToWord(long number) {
        if (number == 0) {
            return "Zero";
        }
        return convertToWordHelper(number).trim();
    }

    private static String convertToWordHelper(long number) {
        if (number < 10) {
            return units[(int) number];
        } else if (number < 20) {
            return teens[(int) (number % 10)];
        } else if (number < 100) {
            return tens[(int) (number / 10)] + " " + convertToWordHelper(number % 10);
        } else if (number < 1000) {
            return units[(int) (number / 100)] + " Hundred " + convertToWordHelper(number % 100);
        } else if (number < 1000000) {
            return convertToWordHelper(number / 1000) + " Thousand " + convertToWordHelper(number % 1000);
        } else {
            return "Number is too large for this example.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

        System.out.println(convertToWord(number));
        
        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}

