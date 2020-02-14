package Chapter6;

import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int a[],int n){
        for(int i=0;i<n-1;i++){
            int index=i;
            for(int j=i+1;j<n;j++){
                if(a[index]>a[j]){
                    index=j;
                }
            }
            for(int k=0;k<index;k++){
                if(k==i) System.out.print("*"+"  ");
                System.out.print("  ");
            }
            System.out.print("\b\b\b");
            System.out.println("+");
            for(int k=0;k<n;k++){
                System.out.print(a[k]+" ");
            }
            System.out.println();
            int swap=a[i];
            a[i]=a[index];
            a[index]=swap;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("선택 정렬(버전 1)");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];
        for(int i=0;i<nx;i++){
            System.out.print("x["+i+"] : ");
            x[i]=sc.nextInt();
        }
        selectionSort(x,nx);
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<nx;i++)
            System.out.println("x["+i+"]= "+x[i]);
    }
}
