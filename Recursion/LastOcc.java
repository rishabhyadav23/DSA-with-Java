import java.util.Scanner;

public class LastOcc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter element of array");
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter value to find");
        int value = sc.nextInt();
        int ans = solve(arr,arr.length-1,value);
        System.out.println(ans);
    }
    public static int solve(int[] arr,int indx,int value){
        if(indx < 0){
            return -1;
        }
        if(arr[indx]==value){
            return indx;
        }else{
        int next = solve(arr, indx-1, value);
        return next;
        }

    }
}
