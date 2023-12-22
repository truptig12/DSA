public class Recursion {
    public static void main(String[] args) {
        // Calling function printFun()
        //System.out.println(fibonacci(20));
//        String str = "abba";
        //  System.out.println(ropeCutting(5, 2, 5, 1));

        /*int N = 5, A = 2, B = 5, C = 1;
        int result = maximizeCuts(N, A, B, C);

        if (result == -1) {
            System.out.println("It is impossible to make cuts.");
        } else {
            System.out.println("Maximum number of cuts: " + result);
        }*/

        //  subsetOfString("abc", "", 0);
      //  System.out.println(singleDigit(99));
        int n = 3, arr[]= {10, 20, 15}, sum = 25;
        permutation("abc", "");

    }

    /*Printing all Permutations*/
    public static void permutation(String str, String perm){

        if(str.length() == 0){
            System.out.println(perm);
            return;
        }
      for(int i = 0; i< str.length(); i++){

          char curr = str.charAt(i);
          String newS = str.substring(0, i)+ str.substring(i+1);
          permutation(newS, perm+curr);
      }


    }



    /*Subset Sum Problem*/
    static int countSubsets(int arr[], int n, int sum){

        if(n == 0){
            return sum ==0 ? 1:0;
        }
       return countSubsets(arr, n-1, sum) + countSubsets(arr, n-1, sum -arr[n-1]);
    }


    /*Josephus Problem*/
    public static int jos(int n , int k){
        if(n ==1){
            return 1;
        }else{
            return (jos(n-1, k) + k-1)%n+1;
        }

    }


    /*You are given a number n. You need to find the digital root of n. DigitalRoot of a number is the recursive sum of its digits until we get a single digit number.*/
    public static int singleDigit(int n) {
        if (n / 10 == 0) {
            return n;
        } else {
            return singleDigit(digitalRoot(n));
        }
    }

    public static int digitalRoot(int n) {
        if (n / 10 == 0) {
            return n;
        } else {
            return n % 10 + digitalRoot(n / 10);
        }
    }


    public static void subsetOfString(String abc, String curr, int i) {


        if (i == abc.length()) {
            System.out.println(curr);
            return;
        }
        subsetOfString(abc, curr + abc.charAt(i), i + 1);
        subsetOfString(abc, curr, i + 1);


    }


    public static int ropeCutting(int n, int a, int b, int c) {

        if (n == 0) {
            return 0;
        }
        if (n < 0) return -1;
        int res = Math.max(Math.max(ropeCutting(n - a, a, b, c), ropeCutting(n - b, a, b, c)), ropeCutting(n - c, a, b, c));

        if (res == -1) {
            return -1;
        }
        return res + 1;
    }


    public static int maximizeCuts(int N, int A, int B, int C) {
        // Base case: If the rope length is 0, no more cuts are needed
        if (N == 0) {
            return 0;
        }

        // Initialize the result to a value that represents impossible cuts
        int result = -1;

        // Check if making a cut of size A is possible
        if (N - A >= 0) {
            int cutsWithA = maximizeCuts(N - A, A, B, C);
            if (cutsWithA != -1) {
                result = Math.max(result, cutsWithA + 1);
            }
        }

        // Check if making a cut of size B is possible
        if (N - B >= 0) {
            int cutsWithB = maximizeCuts(N - B, A, B, C);
            if (cutsWithB != -1) {
                result = Math.max(result, cutsWithB + 1);
            }
        }

        // Check if making a cut of size C is possible
        if (N - C >= 0) {
            int cutsWithC = maximizeCuts(N - C, A, B, C);
            if (cutsWithC != -1) {
                result = Math.max(result, cutsWithC + 1);
            }
        }

        // If it's impossible to make cuts, return -1
        if (result == -1) {
            return -1;
        }

        return result;
    }


    /*Sum of n digits*/
    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return sumOfDigits(n / 10) + n % 10;
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

    /*print the fibonacci sequence till nth term*/
    public static void printFibonacci(int n, int a, int b) {

        if (n < 2) {
            return;
        }
        System.out.print(b + " ");
        printFibonacci(n - 1, b, a + b);


    }


    /*Fibonacci using recursion find the nth term*/
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


    /*Print x ^ n (Stack height = log n)*/
    public static int calPower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }

        if (n % 2 == 0) {
            return calPower(x, n / 2) * calPower(x, n / 2);
        } else {
            return x * calPower(x, n / 2) * calPower(x, n / 2);
        }
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
