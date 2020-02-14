package Chapter6;

import java.util.Scanner;

public class ShellSort_csh {
    static void shellSort(int[] a,int n){
        for(int h=n/2;h>0;h/=2){
            for(int i=h;i<n;i++){
                int value=a[i];
                int j;
                for(j=i-h;j>=0&&a[j]>value;j=j-h)
                     a[j+h]=a[j];
                a[j+h]=value;
                for(int k=0;k<n;k++)
                    System.out.print(a[k]+" ");
                System.out.println();
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("셸 정렬(버전 1)");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];
        for(int i=0;i<nx;i++){
            System.out.print("x["+i+"] : ");
            x[i]=sc.nextInt();
        }
        shellSort(x,nx);
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<nx;i++)
            System.out.println("x["+i+"]= "+x[i]);
    }
}
