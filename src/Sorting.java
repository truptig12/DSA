import java.util.ArrayList;
import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
       /* insertionSort();
        int[] arr = {10, 5, 30, 15, 7};
        int l = 0, r = arr.length - 1;
        mergeSort(arr, l, r);*/
        int A[] = {27, 79, 106, 277, 401, 9896, 10002};
        int B[] = {1279, 1478, 1482, 2420};
        int C[] = {2426};
        System.out.println(merge3sorted(A, B, C));
    }

    static ArrayList<Integer> merge3sorted(int A[], int B[], int C[]) {
        // add ypur code here
        ArrayList<Integer> result = new ArrayList<>();
        int m = A.length;
        int n = B.length;
        int o = C.length;

        int i = 0, j = 0, k = 0;
        while (i < m && j < n && k < o) {
            int min = Math.min(A[i], Math.min(B[j], C[k]));
            if (min == A[i]) {
                result.add(A[i]);
                i++;
            } else if (min == B[j]) {
                result.add(B[j]);
                j++;
            } else {
                result.add(C[k]);
                k++;
            }
        }

        while (i < m) {
            result.add(A[i]);
            i++;
        }
        while (j < n) {
            result.add(B[j]);
            j++;
        }
        while (k < o) {
            result.add(C[k]);
            k++;
        }

        return result;
    }

    public static void selectionSort() {
        int[] arr = {7, 8, 3, 1, 2};

        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort() {
        int[] arr = {7, 8, 3, 1, 2};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort() {
        int[] arr = {7, 8, 3, 1, 2};
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSort(int[] arr, int l, int r) {
        if (r > l) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }

    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[i + l];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }


}
