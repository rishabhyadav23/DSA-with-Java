import java.util.*;
public class XpowN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int xn = solution(x,n);
        System.out.println(xn);
    }
    public static int solution(int x,int n){
        if(n==0){
            return 1;
        }
        int xp = solution(x, n/2);
        int xn = xp * xp;
        if(n%2==1){
            xn = xn*x;
        }
        return xn;
    }
}
