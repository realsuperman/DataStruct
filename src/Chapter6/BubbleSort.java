package Chapter6;

import java.util.Scanner;

public class BubbleSort {
    static int swap=0;
    static int compare=0;
    static void swap(int[] a,int idx1,int idx2){
        swap++;
        int t=a[idx1];
        a[idx1]=a[idx2];
        a[idx2]=t;
    }
    static void bubbleSort(int[] a,int n){
        int lastChange=0;
        for(int i=0;i<n-1;i++) {
            int value=0;
            System.out.println("패스"+(i+1)+":");
            for (int j = n - 1; j > i; j--) {
                compare++;
                if (a[j - 1] > a[j]) {
                    for(int k=0;k<j;k++){
                        System.out.print(a[k]+" ");
                    }
                    System.out.print("+ "+a[j]+" ");
                    for(int k=j+1;k<n;k++){
                        System.out.print(a[k]+" ");
                    }
                    value=1;
                    lastChange=j-1;
                    swap(a, j - 1, j);
                }else{
                    for(int k=0;k<j;k++){
                        System.out.print(a[k]+" ");
                    }
                    System.out.print("- "+a[j]+" ");
                    for(int k=j+1;k<n;k++){
                        System.out.print(a[k]+" ");
                    }
                }
                System.out.println();
            }
            for(int k=0;k<n;k++) System.out.print(a[k]+" ");
            System.out.println();
            if(value==0) break;
            i=lastChange;
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
        System.out.println("비교를 "+compare+"회 했습니다.");
        System.out.println("교환을 "+swap+"회 했습니다.");
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<nx;i++)
            System.out.println("x["+i+"]= "+x[i]);
    }
}
