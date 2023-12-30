import java.util.Arrays;

public class ArraysEx {

    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 8, 8};
        int size = 6;
        int ele = 90;
        int index = 2;
        long[] arr1 = {1, 2, 0, 0, 5};
        //System.out.println(Arrays.toString(moveZerosToTheEndEff(arr, 5)));
        System.out.println(majorityEle(arr, 5));
    }

    /*majority element*/
    public static int majorityEle(int[] arr, int n){


        for(int i = 0; i< n ; i++){
            int count = 1;
            for(int j = i+1; j < n; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > (n/2)){
              return i;
            }
        }

        return -1;
    }


    /*maximum length even -odd sub-array */
    public static int maxEvenOdd(int[] arr, int n) {
        int res = 1;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
                curr++;
                res = Math.max(res, curr);
            } else {
                curr = 1;
            }
        }
        return res;
    }

    /*maximum sub-array sum */
    public static int subArraySum(int[] arr, int n) {
        int maxSum = arr[0];
        int maxEnd = arr[0];
        for (int i = 1; i < n; i++) {
            maxEnd = Math.max(maxEnd + arr[i], arr[i]);
            maxSum = Math.max(maxSum, maxEnd);
        }
        return maxSum;
    }

    /*maximum circular sub-array sum */
    public static int circularSubArraySum(int[] arr, int n) {
        int maxNormal = subArraySum(arr, n);
        if (maxNormal < 0) {
            return maxNormal;
        }
        int arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
            arr[i] = -arr[i];
        }
        int maxCircular = arrSum + subArraySum(arr, n);

        return Math.max(maxCircular, maxNormal);
    }


    /*maximum consecutive 1's in a binary array*/
    public static int consecutiveOne(int[] arr, int n) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
                if (max < count) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }


    /*frequency of a number*/
    public static void freq(int[] arr, int n) {
        int freq = 1, i = 1;
        while (i < n) {
            while (i < n && arr[i] == arr[i - 1]) {
                freq++;
                i++;
            }
            System.out.println(arr[i - 1] + " " + freq);
            i++;
            freq = 1;
        }
        if (n == 1 || arr[n - 1] != arr[n - 2]) {
            System.out.println(arr[n - 1] + " " + 1);
        }

    }

    public static void maximumDiff(int[] arr, int n) {
        int maxDiff = arr[1] - arr[0];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[j] - arr[i]) > maxDiff) {
                    maxDiff = (arr[j] - arr[i]);
                }
            }
        }
        System.out.println(maxDiff);

    }

    public static void maximumDiffEff(int[] arr, int n) {
        int maxDiff = arr[1] - arr[0];
        int minValue = arr[0];
        for (int j = 1; j < n; j++) {
            maxDiff = Math.max(maxDiff, arr[j] - minValue);
            minValue = Math.min(minValue, arr[j]);
        }
        System.out.println(maxDiff);

    }

    /*leaders in an array*/
    public static void leadersInArray(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                System.out.println(arr[i]);

            }
        }
    }

    public static void leadersInArrayEff(int[] arr, int n) {

        int curr = arr[n - 1];
        System.out.println(curr);
        for (int i = n - 2; i >= 0; i--) {
            if (curr < arr[i]) {
                curr = arr[i];
                System.out.println(curr);
            }
        }

    }

    /*Left Rotate an array by d*/
    static void leftRotateByD(int arr[], int n, int d) {
        // your code here
        if (n == d) {
            System.out.print(Arrays.toString(arr));
        } else {

            for (int i = 0; i < d; i++) {
                leftRotate(arr, 5);
            }
        }


    }

    /*Left Rotate an array by 1*/
    static void leftRotate(int arr[], int n) {
        // your code here
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
        System.out.print(Arrays.toString(arr));

    }

    /*Function to rearrange an array so that arr[i] becomes arr[arr[i]]*/
    static void arrange(long arr[], int n) {
        // your code here
        for (int i = 0; i < n; i++) {
            int temp = (int) arr[i];
            arr[i] = arr[temp];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(Arrays.toString(arr));
        }
    }


    /*remove duplicates from sorted array*/

    public static int removeDuplicates(int[] arr, int n) {
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[count - 1] != arr[i]) {
                arr[count] = arr[i];
                count++;
            }
        }
        return count;
    }

    /*move zeros to the end*/
    public static int[] moveZerosToTheEnd(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] != 0) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }

            }
        }
        return arr;
    }


    /*move zeros to the end efficiently*/
    public static int[] moveZerosToTheEndEff(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }

        }
        return arr;
    }

    /*Array is sorted or not*/
    public static boolean isSorted(int[] arr) {


        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    /*return the largest element index*/
    public static int largestElementIndex(int arr[]) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    /*return the largest element*/
    public static int largestElement(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void insertAtIndex(int arr[], int sizeOfArray, int index, int element) {
        //Your code here, Geeks
        if (index == sizeOfArray - 1) {
            arr[index] = element;
            return;
        }
        arr[sizeOfArray - 1] = -1;
        for (int i = sizeOfArray - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
    }


    /*delete the given element from the array*/
    public static int deleteElement(int[] arr, int ele, int n) {
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] == ele) {
                break;
            }
        }
        if (i == n) {
            return n;
        }
        for (int j = i; j < n; j++) {
            arr[j] = arr[j + 1];
        }
        return n - 1;

    }
}
