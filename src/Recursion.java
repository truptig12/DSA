public class Recursion {
    public static void main(String[] args) {
        // Calling function printFun()
        // System.out.println(fibonacci(20));
//        String str = "abba";
        System.out.println(sumOfDigits(435));
    }

    public static int sumOfDigits(int n){
        if(n == 0){
            return 0;
        }
        return sumOfDigits(n / 10)+ n % 10;
    }

    /*Palindrome check */
    public static boolean isPalindrome(String str, int start, int end) {

        if (start >= end) {
            return true;
        }
        return (str.charAt(start) == str.charAt(end)) && isPalindrome(str.substring(start, end), start + 1, end - 1);
    }

    /*sum of natural number*/
    public static int sumOfNaturalNos(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumOfNaturalNos(n - 1);
    }


    /*Factorial of n where n >= 0*/

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }


    /*Print 1 to n using recursion*/
    public static void printToN(int n) {
        if (n == 0) {
            return;
        }
        printToN(n - 1);
        System.out.println(n);

    }

    /*Fibonacci using recursion*/
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    /*Print n to 1 using recursion*/
    public static void printNNumbers(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNNumbers(n - 1);
    }

    /*
        You are given two numbers n and p. You need to find n^p.
    */
    public static int recursionPower(int n, int p) {
        if (n == 0) {
            return 0;
        }
        if (p == 0) {
            return 1;
        }

        return n * recursionPower(n, p - 1);
    }


    /*recursive fun call*/
    static void printFun(int test) {
        if (test < 1)
            return;
        else {
            System.out.print(test + " ");
            printFun(test - 1);
            System.out.print(test + " ");
            return;
        }
    }

    /* Given a number and its reverse. Find that number raised to the power of its own reverse. */
    static long power(int N, int R) {
        int mod = 1000000007;
        //Your code here
        if (N == 0) {
            return 0;
        }
        if (R == 0) {
            return 1;
        }

        long y;
        if (R % 2 == 0) {
            y = power(N, R / 2);
            y = (y * y) % mod;
        } else {
            y = N % mod;
            y = (y * power(N, R - 1) % mod) % mod;
        }
        return ((y + mod) % mod);

    }


}
