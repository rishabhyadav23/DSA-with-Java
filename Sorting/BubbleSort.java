package Sorting;

// Bubble Sort
// Time Complexity - O(n^2) | best - O(n)
// Space Complexity - O(1);
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 3, 70, 3, 9, 5, 2, 8, 6, 40, 42, 1 };

        for(int i=1;i<arr.length;i++){
            for(int j = 1;j<=arr.length-1;j++){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i:arr){
            System.out.print(i+",");
        }
    }
}
