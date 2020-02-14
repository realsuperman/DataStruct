package Chapter6;

import Chapter4.IntStack;

import java.util.Scanner;

public class QuickSort2 {
    static void swap(int[] a,int idx1,int idx2){
        int t=a[idx1];
        a[idx1]=a[idx2];
        a[idx2]=t;
    }
    static void quickSort(int[] a,int left,int right){
        IntStack lstack = new IntStack(right-left+1);
        IntStack rstack = new IntStack(right-left+1);
        lstack.push(left);
        rstack.push(right);
        while(lstack.isEmpty()!=true){
            int size=0;
            int size2=0;
            int pl=left=lstack.pop();
            int pr=right=rstack.pop();
            //if(pr-pl<=4){
            //    InsertSort_csh.insertionSort(a,pr-pl);
            //    continue;
            //}

            if(a[pl]>a[pr]){
                int swap=a[pl];
                a[pl]=a[pr];
                a[pr]=swap;
            }
            int center=(pl+pr)/2;
            if(a[center]<a[pl]){
                int swap=a[center];
                a[center]=a[pl];
                a[pl]=swap;
            }
            if(a[center]>a[pr]){
                int swap=a[center];
                a[center]=a[pr];
                a[pr]=swap;
            }
            //int x = a[pr-1];
            int swap=a[pr-1];
            a[pr-1]=a[center];
            a[center]=swap;
            int x = a[pr-1];
            pl=pl+1;
            pr=pr-2;
            System.out.println(pl+" "+pr);
            do{
                if(pl>=0) while(a[pl]<x) pl++;
                if(pr>=0) while(a[pr]>x) pr--;
                if(pl<=pr) swap(a,pl++,pr--);
            }while(pl<=pr);
            if(left<pr){
                size=pr-left;
            }
            if(pl<right){
                size2=right-pl;
            }

            if(size>size2){
                if(size2!=0) {
                    System.out.println("push 하는 녀석은 : "+pl+" "+right);
                    lstack.push(pl);
                    rstack.push(right);
                }
                if(size!=0){
                    System.out.println("push 하는 녀석은 : "+left+" "+pr);
                    lstack.push(left);
                    rstack.push(pr);
                }
            }else{
                if(size!=0) {
                    System.out.println("push 하는 녀석은 : "+left+" "+pr);
                    lstack.push(left);
                    rstack.push(pr);
                }
                if(size2!=0){
                    System.out.println("push 하는 녀석은 : "+pl+" "+right);
                    lstack.push(pl);
                    rstack.push(right);
                }
            }
        }
    }
    static void quickSort(int[] a,int n){
        quickSort(a,0,n);
    }
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        System.out.print("배열을 나눕니다.");
        int nx=sc.nextInt();
        int[] x= new int[nx];
        for(int i=0;i<nx;i++){
            System.out.print("x["+i+"] :");
            x[i]=sc.nextInt();
        }
        quickSort(x,nx-1);
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<nx;i++)
            System.out.println("x["+i+"] = "+x[i]);
    }
}
