import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] qb = new int[n+1];
        int fib = findFib(n,qb);
        System.out.println(fib);
    }
    public static int findFib(int n,int[] qb){
        if(n==0 || n==1){
            return n;
        }
        if(qb[n]!=0){
            return qb[n];
        }
        int nextFib = findFib(n-1,qb)+findFib(n-2,qb);
        qb[n] = nextFib;
        return nextFib;
    }
}
