import java.util.HashSet;
class RemoveDuplicacy2{
    public static void main(String[] args) {
        int[] a = {2,5,5,3,8,2,6,8};
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<a.length;i++){
            hs.add(a[i]);
        }
        for(int no:hs){
            System.out.print(no + " ");
        }

    }
}