package Chapter6;

import java.util.Scanner;

public class CocktailSort {
    static void swap(int[] a,int idx1,int idx2){
        int t=a[idx1];
        a[idx1]=a[idx2];
        a[idx2]=t;
    }
    static void bubbleSort(int[] a,int n){
        int lastChange=0;
        int lastChange2=n-1;
        for(int i=0;i<n-1;i++) {
            int value=0;
            for (int j = lastChange2; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    value=1;
                    lastChange=j-1;
                    swap(a, j - 1, j);
                }
            }
            if(value==0) break;
            for(int j=lastChange;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    value=1;
                    lastChange2=j;
                    int swap=a[j];
                    a[j]=a[j+1];
                    a[j+1]=swap;
                }
            }
            if(value==0) break;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("버블 정렬(버전 1)");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];
        for(int i=0;i<nx;i++){
            System.out.print("x["+i+"] : ");
            x[i]=sc.nextInt();
        }
        bubbleSort(x,nx);
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<nx;i++)
            System.out.println("x["+i+"]= "+x[i]);
    }
}
