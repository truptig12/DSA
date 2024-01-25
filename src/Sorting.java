import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        insertionSort();
    }

    public static void selectionSort(){
        int[] arr ={7,8,3,1,2};

        for(int i = 0; i< arr.length; i++){
            int smallest = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[smallest]){
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(){
        int[] arr = {7,8,3,1,2};
        for(int i =0; i< arr.length-1; i++){
            for(int j = 0; j< arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(){
        int[] arr = {7,8,3,1,2};
        for(int i = 1; i< arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while(j >=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(){

    }


}
