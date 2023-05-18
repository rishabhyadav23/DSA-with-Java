import java.util.Scanner;

public class PrintZicZac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number:");
        int n = sc.nextInt();
        solve(n);
    }
    public static void solve(int n){
        if(n==0){
            return;
        }
        System.out.println("Pre" + " "+ n);
        solve( n-1);
        System.out.println("In" +" "+ n);
        solve(n-1);
        System.out.println("Post" +" "+ n);
    }
}
