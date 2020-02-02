package Chapter3;

public class SearchIdx {
    public static int searchIdx(int[] a,int n,int key,int[] idx){
        int index=0;
        for(int i=0;i<n;i++){
            if(a[i]==key){
                idx[index++]=i;
            }
        }
        return index;
    }
    public static void main(String args[]){
        int[] array= new int[8];
        array[0]=1;
        array[1]=9;
        array[2]=2;
        array[3]=9;
        array[4]=4;
        array[5]=6;
        array[6]=7;
        array[7]=9;
        int[] idx=new int[8];
        int cnt=searchIdx(array,8,9,idx);
        for(int i=0;i<8;i++){
            System.out.println(idx[i]);
        }
        System.out.println(cnt);
    }
}
