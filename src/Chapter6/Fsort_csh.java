package Chapter6;

import java.util.Scanner;

public class Fsort_csh {
    public static void fSort(int[] array,int size,int max){
        int[] f=new int[max+1];
        int[] b=new int[size];
        for(int i=0;i<size;i++){
            f[array[i]]++;
            System.out.print(f[array[i]]+" ");
        }
        System.out.println();
        for(int i=1;i<=max;i++){
            f[i]=f[i]+f[i-1];
            System.out.print(f[i-1]+" ");
        }
        System.out.println();
        for(int i=size-1;i>=0;i--){
            b[--f[array[i]]]=array[i];
            System.out.print(b[f[array[i]]]+" ");
        }
        System.out.println();
        for(int i=0;i<size;i++){
            array[i]=b[i];
        }
    }

    public static void fSort(int[] array,int size,int min,int max){
        int[] f=new int[max+Math.abs(min)+1];
        int[] b=new int[size];
        for(int i=0;i<size;i++){
            int index=array[i]+Math.abs(min);
            f[index]++;
        }
        for(int i=1;i<=max+Math.abs(min);i++){
            f[i]=f[i]+f[i-1];
        }
        for(int i=size-1;i>=0;i--){
            int index=array[i]+Math.abs(min);
            b[--f[index]]=array[i];
        }
        for(int i=0;i<size;i++){
            array[i]=b[i];
        }
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("도수 정렬");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];
        for(int i=0;i<nx;i++){
            System.out.print("x["+i+"] : ");
            x[i]=sc.nextInt();
        }
        int max=x[0];
        for(int i=1;i<nx;i++)
            if(x[i]>max) max=x[i];
        int min=x[0];
        for(int i=1;i<nx;i++)
            if(x[i]<min) min=x[i];
        fSort(x,nx,min,max);
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<nx;i++)
            System.out.println("x["+i+"] = "+x[i]);
    }
}
