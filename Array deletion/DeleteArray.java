class DeleteArray{
    public static void main(String[] args) {
        int[] a = {2,4,5,98,34,1};
        int element = 98;
        for(int i=0;i<a.length;i++){
            if(element == a[i]){
                for(int j=i;j<a.length-1;j++){
                    a[j]=a[j+1];
                }
                break;
            }
        }
        for(int i=0;i<a.length-1;i++){
            System.out.print(a[i] + " ");
        }
    }
}