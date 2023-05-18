import java.util.Scanner;
public class printRevArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        displayRevArr(arr,arr.length-1);
    }
    public static void displayRevArr(int[] arr,int indx){
        if(indx<0){
            return;
        }
        System.out.print(arr[indx]+"-> ");
        displayRevArr(arr, indx -1);
    }
}
