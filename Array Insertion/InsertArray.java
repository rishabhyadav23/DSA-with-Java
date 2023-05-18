class InsertArray{
    public static void main(String[] args) {
        int[] a = {2,4,7,5,9,1,0};
        int pos = 3;
        int elem = 10;
        for(int i = a.length-1; i>a[pos-1]; i--){
            a[i] = a[i-1];
        }
        a[pos-1] = elem;

        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
    }
}