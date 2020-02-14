package Chapter6;

import java.util.Scanner;

public class InsertSort_csh {
    public static void insertionSort(int a[],int n){
        for(int i=1;i<=n;i++){
            int value=a[i];
            int index=i;
            for(int j=i-1;j>=0;j--){
                if(a[j]>value){
                    a[index]=a[j];
                    index=j;
                }
            }
            a[index]=value;
        }
    }
    public static void insertionSort2(int a[],int n){
        a[0]=-1;
        for(int i=2;i<=n;i++){
            int value=a[i];
            int index=i;
            for(int j=i-1;j>0;j--){
                if(a[j]>value){
                    a[index]=a[j];
                    index=j;
                }
            }
            a[index]=value;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx+1];
        for(int i=0;i<nx;i++){
            System.out.print("x["+i+"] : ");
            x[i+1]=sc.nextInt();
        }
        insertionSort(x,nx);
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=1;i<x.length;i++)
            System.out.println("x["+i+"]= "+x[i]);
    }
}
