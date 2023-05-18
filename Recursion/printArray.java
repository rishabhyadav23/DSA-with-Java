import java.util.Scanner;

class printArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        displayArr(arr,0);
    }

    public static void displayArr(int[] arr, int n){
        if(n==arr.length){
            return;
        }
        System.out.print(arr[n]+"-> ");
        displayArr(arr, n+1);
    }
}