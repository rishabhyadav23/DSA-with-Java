import java.util.Scanner;

public class maxArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int max = displayMax(arr,0);
        System.out.println("Maximum of Array: "+max);
    }
    public static int displayMax(int[] arr,int indx){
        if(indx==arr.length-1){
            return arr[indx];
        }
        int ans = displayMax(arr, indx + 1);
        if(ans>arr[indx]){
            return ans;
        }else{
            return arr[indx];
        }
    }
}
