package Chapter6;

import java.util.Scanner;

public class InsertSort_csh2 {
    public static int binarySearch(int a[],int end,int key){
        int left=0;
        int right=end;
        while(right>left){
            int mid=(right+left)/2;
            if(key>=a[mid]) left=mid+1;
            else right=mid;
        }
        return right;
    }
    public static void insertionSort(int a[],int n){
        for(int i=1;i<n;i++){
            int value=a[i];
            int index=binarySearch(a,i,a[i]);
            for(int j=i;j>index;j--){
                a[j]=a[j-1];
            }
            a[index]=value;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];
        for(int i=0;i<nx;i++){
            System.out.print("x["+i+"] : ");
            x[i]=sc.nextInt();
        }
        insertionSort(x,nx);
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<x.length;i++)
            System.out.println("x["+i+"]= "+x[i]);
    }
}
