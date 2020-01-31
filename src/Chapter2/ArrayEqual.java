package Chapter2;

import java.util.Scanner;

public class ArrayEqual {
    static void rcopy(int[] a,int[] b){
        if(a.length!=b.length){
            System.out.println("복제 불가(사이즈 에러)");
            return;
        }
        for(int i=0;i<a.length;i++){
            a[i]=b[b.length-i-1];
        }
    }
    static void copy(int[] a,int[] b){
        if(a.length!=b.length){
            System.out.println("복제 불가(사이즈 에러)");
            return;
        }
        for(int i=0;i<a.length;i++){
            a[i]=b[i];
        }
    }
    static boolean equals(int[] a,int[] b){
        if(a.length!=b.length)
            return false;
        for(int i=0;i<a.length;i++)
            if(a[i]!=b[i]) return false;
        return true;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("배열 a의 요솟수 : ");
        int na = sc.nextInt();
        int[] a=new int[na];
        for(int i=0;i<na;i++){
            System.out.print("a["+i+"] : ");
            a[i]=sc.nextInt();
        }
        System.out.print("배열 b의 요솟수");
        int nb = sc.nextInt();
        int[] b=new int[nb];
        for(int i=0;i<nb;i++){
            System.out.print("b["+i+"] : ");
            b[i]=sc.nextInt();
        }
        System.out.println("배열 a와 b는 "+(equals(a,b)?"같습니다.":"같지 않습니다."));
        //copy(a,b);
        rcopy(a,b);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
            System.out.print(b[i]+"\n");
        }
    }
}
