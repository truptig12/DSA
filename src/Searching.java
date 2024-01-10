public class Searching {

    public static void main(String[] arg) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        System.out.println(binarySearchRecur(arr, 5, 0, arr.length - 1));
    }


    /*index of first occurrence */

    public static int firstOcc(int arr[], int low, int high, int x) {
        if (low > high) {
            return -1;
        }


        int mid = (low + high) / 2;
        if (x > arr[mid]) {
            return firstOcc(arr, mid + 1, high, x);
        } else if (x < arr[mid]) {
            return firstOcc(arr, low, mid - 1, x);

        } else {
            if (mid == 0 || arr[mid - 1] != arr[mid]) {
                return mid;
            } else {
                return firstOcc(arr, low, mid - 1, x);
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
