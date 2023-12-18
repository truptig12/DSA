import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Mathematics {
    public static void main(String[] args) {
        // System.out.println(isPrimeOptimised(10));
        int[] arr = {4, 4, 7, 4, 8, 7, 7, 8, 7, 8};
        twoOddOccHash(arr);
    }

    public static int oneOddOccur(int[] arr) {
        int x = arr[0];
        for (int i = 1; i < arr.length; i++) {
            x = x ^ arr[i];
        }
        return x;
    }

    public static void twoOddOccHash(int [] arr){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i< arr.length; i++){
           if(map.containsKey(arr[i])){
               map.put(arr[i], map.get(arr[i]) + 1);
           }else{
               map.put(arr[i], 1);
           }
        }
        for( int key: map.keySet()){
            int val = map.get(key);
            if( val % 2 != 0){
                System.out.println(key);
            }
        }
    }

    public static void twoOddOccur(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                System.out.println(arr[i]);
            }

        }
    }

    public static void twoOddOccurOpti(int[] arr) {
        int x = arr[0];
        for (int i = 1; i < arr.length; i++) {
            x = x ^ arr[i];
        }

        int k = (x & (~(x-1)));
        int res1=0, res2=0;
        for(int i = 0; i< arr.length; i++){
            if((arr[i] & k) !=0 ){
                res1 = res1 ^ arr[i];
            }else{
                res2 = res2 ^ arr[i];
            }
        }
        System.out.println(res1);
        System.out.println(res2);

    }


    public static boolean isPowerOf2(int n) {
        if (n == 0) {
            return false;
        }
        while (n != 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;

        }
        return true;
    }

    public static boolean isPowerOf2BrianAlgorithm(int n) {
        if (n == 0) {
            return false;
        }
        return ((n & (n - 1)) == 0);
    }

    public static int countSetBits(int n) {

        int count = 0;
        while (n > 0) {
            count = count + (n & 1);
            n = n / 2;
        }
        return count;
    }

    public static int countSetBitsEfficient(int n) {

        int count = 0;
        while (n > 0) {
            count = count + (n & 1);
            n = n / 2;
        }
        return count;
    }

    public static int countSetBitsWithBrianAlgorithm(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static int iterativePower(int x, int n) {
        int res = 1;
        while (n > 0) {
            if (x % 2 != 0) {
                res *= x;
            }
            x = x * x;
            n = n / 2;
        }
        return res;
    }

    public static void computingPower(int x, int n) {
        int res = 1;
        while (n > 0) {
            res *= x;
            n--;
        }
        System.out.println(res);
    }

    public static int computingPowerEfficient(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int temp = computingPowerEfficient(x, n / 2);
        temp = temp * temp;
        if (n % 2 == 0) {
            return temp;
        } else {
            return temp * x;
        }

    }


    public static void allPrimeNumbers(int n) {
        if (n <= 0) {
            return;
        }
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j <= n; j = j + i) {
                    isPrime[j] = false;
                }
            }

        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }


    }

    public static void divisors(int n) {
        if (n == 0) {
            return;
        }
        int i;
        for (i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
        for (; i > 1; ) {
            i--;
            if (i != (n / i) && n % i == 0) {
                System.out.println(n / i);
            }
        }
    }

    public static int exactly2Divisors(int N) {
        int counter = 0;
        for (int i = 1; i * i <= N; i++) {
            if (isPrime(i)) {
                counter++;
            }
        }
        return counter;
    }

    public static void primeFactors(int n) {
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                int x = i;
                while (n % x == 0) {
                    System.out.println(i);
                    x = x * i;
                }
            }
        }
    }

    public static void primeFactorsEfficient(int n) {
        if (n <= 1) {
            return;
        }
        while (n % 2 == 0) {
            System.out.println(2);
            n = n / 2;
        }
        while (n % 3 == 0) {
            System.out.println(3);
            n = n / 3;
        }
        for (int i = 5; i * i <= n; i = i + 6) {
            while (n % i == 0) {
                System.out.println(i);
                n = n / i;
            }
            while (n % (i + 2) == 0) {
                System.out.println(i + 2);
                n = n / (i + 2);
            }
        }
        if (n > 3) {
            System.out.println(n);
        }
    }


    private static int absoluteValue(int i) {
        if (i < 0) {
            return i * -1;
        }
        return i;
    }

    private static int absoluteValueDirect(int i) {
        return Math.abs(i);
    }

    private static int countOfDigits(long x) {
        int res = 0;
        while (x > 0) {
            x = x / 10;
            res++;
        }

        return res;
    }

    private static boolean isPalindromic(int n) {
        int rev = 0;
        int temp = n;
        while (temp != 0) {
            int ld = temp % 10;
            rev = rev * 10 + ld;
            temp = temp / 10;

        }
        return (rev == n);
    }

    private static int factorial(int n) {
        int factorial = 1;
        while (n > 0) {
            factorial = factorial * n;
            n--;
        }
        return factorial;
    }

    private static int factorialRec(int n) {

        if (n == 0) {
            return 1;
        }
        return n * factorialRec(n - 1);
    }

    public static int digitsInFactorial(int N) {
        // code here
        double sum = 0.0;
        for (int i = 1; i <= N; i++) {
            sum += Math.log10(i);
        }

        return (int) (1 + Math.floor(sum));

    }

    public static int trailingZeros(int N) {
        if (N < 0) {
            return -1;
        }

        int res = 0;
        for (int i = 5; i <= N; i = i * 5) {
            res += (N / i);
        }
        return res;
    }

    public static int GCD(int a, int b) {
        int res = Math.min(a, b);
        while (res > 0) {
            if (a % res == 0 && b % res == 0) {
                break;
            }
            res--;
        }
        return res;

    }

    public static int GCDEuclidean(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a == b) {
            return a;
        }
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static int GCDOptimised(int a, int b) {
        if (b == 0) {
            return a;
        } else return GCDOptimised(b, a % b);

    }

    public static int LCM(int a, int b) {
        int res = Math.max(a, b);
        while (true) {
            if (res % a == 0 && res % b == 0) {
                return res;
            }
            res++;
        }
    }

    public static int lcmEfficient(int a, int b) {
        return (a * b) / GCDOptimised(a, b);
    }

    public static boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

    public static boolean isPrimeOptimised(int n) {

        if (n == 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;

    }

}
