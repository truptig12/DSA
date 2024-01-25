import java.util.Arrays;
import java.util.Scanner;

public class BitManipulation {

    public static void main(String[] args) {

        // updateBit();
        int arr[] = {1, 2, 3, 2, 1, 4};
        //System.out.println(Arrays.toString(singleNumber(arr)));
//        System.out.println(isPowerofTwo(8));
        /*String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));*/
        // Example BCD date and time: 23rd April 2021, 15:45:30
        byte[] bcdDateTime = {0x21, 0x04, 0x23, 0x15, 0x45, 0x30};

        String dateTime = formatDateTime(bcdDateTime);
        System.out.println("Date and Time: " + dateTime);
    }

    // Function to convert a BCD byte to decimal
    private static int bcdToDecimal(byte bcd) {
        int tens = (bcd / 16);  // Divide by 16 to get the tens place digit
        int units = (bcd % 16); // Modulo by 16 to get the units place digit
        return tens * 10 + units;
    }

    // Function to format date and time from BCD values
    public static String formatDateTime(byte[] bcdDateTime) {
        int year = bcdToDecimal(bcdDateTime[0]);
        int month = bcdToDecimal(bcdDateTime[1]);
        int day = bcdToDecimal(bcdDateTime[2]);
        int hour = bcdToDecimal(bcdDateTime[3]);
        int minute = bcdToDecimal(bcdDateTime[4]);
        int second = bcdToDecimal(bcdDateTime[5]);

        return String.format("%02d/%02d/%02d %02d:%02d:%02d", day, month, year, hour, minute, second);
    }

    public static void updateBit() {
        Scanner scanner = new Scanner(System.in);
        int updateBitTo = scanner.nextInt();

        int n = 5;
        int pos = 0;
        int bitmask = 1 << pos;

        if (updateBitTo == 1) {
            System.out.println(bitmask | n);
        } else {
            bitmask = ~bitmask;
            System.out.println(bitmask & n);
        }
    }

    public static int countOnes(int n) {

        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static String convertDecimalToBinary(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            int remainder = n % 2;
            stringBuilder.insert(0, remainder);
            n /= 2;
        }
        return stringBuilder.toString();
    }

    public static int convertBinaryToDecimal(String n) {
        int decimal = 0;
        int power = 0;
        for (int i = n.length() - 1; i >= 0; i--) {
            char bit = n.charAt(i);
            if (bit == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }

    public static int[] singleNumber(int[] nums) {
        // Code here

        int diff = 0;
        for (int i : nums)
            diff = i ^ diff;
        // Get its last set bit
        diff &= -diff;
        // Pass 2 :
        int rets[] = {0, 0}; // this vector stores the two numbers we will return
        for (int num : nums) {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            } else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        if (rets[0] > rets[1]) {
            int temp = rets[0];
            rets[0] = rets[1];
            rets[1] = temp;
        }
        return rets;

    }

    public static boolean isPowerOfTwo(long n) {

        // Your code here
        if (n == 0) {
            return false;
        }
        return ((n & (n - 1)) == 0);

    }

    public static boolean isPalindrome(String s) {

        String str = s.replaceAll("[, :]", "").toLowerCase();

        StringBuilder newStr = new StringBuilder(str);

        for (int i = 0; i < newStr.length() / 2; i++) {

            int front = i;
            int back = newStr.length() - 1 - i;
            char frontChar = newStr.charAt(front);
            char backChar = newStr.charAt(back);
            newStr.setCharAt(front, backChar);
            newStr.setCharAt(back, frontChar);
        }
        if (str.equals(newStr.toString())) {
            return true;
        }
        return false;
    }
}
