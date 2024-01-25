public class Searching {

    public static void main(String[] arg) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(twoPointerApproach(arr, 5, 3));
    }

    /*Two Pointers Approach
     *to determine whether there exists a pair of integers in the array that adds up to a given target value.
     * */
    public static boolean twoPointerApproach(int[] arr, int n, int x) {

        int low = 0, high = n - 1;
        while (low < high) {
            if (arr[low] + arr[high] == x) {
                return true;
            } else if (arr[low] + arr[high] > x) {
                high--;

            } else {
                low++;
            }
        }
        return false;
    }


    //SquareRoot floor value
    public static int squareRootFloor(int x) {

        int i = 1;
        while (i * i <= x) {
            i++;
        }
        return (i - 1);
    }

    /*square root floor value using binary search*/
    public static int squareRootFloorBinaryS(int x) {
        int low = 1, high = x / 2, ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int mSq = mid * mid;
            if (mSq == x) {
                return mid;
            } else if (mSq > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;

    }


    // Function to count number of ones in the binary array
    // N: size of array
    // arr[]: input array
    public static int countOnes(int arr[], int N) {

        // Your code here
        int low = 0, high = N - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            if (arr[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /*index of first occurrence */
    public static int firstOcc(int arr[], int n, int x) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x > arr[mid]) {
                low = mid + 1;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                if (mid == 0 || arr[mid - 1] != arr[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    public static int firstOccRecur(int arr[], int low, int high, int x) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (x > arr[mid]) {
            return firstOccRecur(arr, mid + 1, high, x);
        } else if (x < arr[mid]) {
            return firstOccRecur(arr, low, mid - 1, x);

        } else {
            if (mid == 0 || arr[mid - 1] != arr[mid]) {
                return mid;
            } else {
                return firstOccRecur(arr, low, mid - 1, x);
            }

        }
    }


    public static int binarySearchRecur(int[] arr, int x, int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] < x) {
            return binarySearchRecur(arr, x, mid + 1, high);
        } else {
            return binarySearchRecur(arr, x, low, mid - 1);
        }

    }

    /*Binary search of index value in a sorted array*/
    public static int binarySearch(int[] arr, int x, int n) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    /*linear search of value in a sorted array*/
    public static int searchForIndex(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
