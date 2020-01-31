package Chapter2;

import java.util.Scanner;

public class ReverseArray {
    static void swap(int[] a,int idx1,int idx2){
        int t=a[idx1];
        a[idx1]=a[idx2];
        a[idx2]=t;
    }
    static void reverse(int[] a){
        for(int i=0;i<a.length/2;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(a[j]+" ");
            }
            swap(a,i,a.length-i-1);
            System.out.println("\na["+i+"]과(와) a["+(a.length-1)+"]를 교환합니다.");
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("\n역순 정렬을 마쳤습니다.");
    }
    static int sumOf(int[] a){
        int sum=0;
        for(int i : a){
            sum+=i;
        }
        return sum;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수 : ");
        int num=sc.nextInt();
        int[] x=new int[num];
        for(int i=0;i<num;i++){
            System.out.print("x["+i+"]:");
            x[i]=sc.nextInt();
        }
        reverse(x);
        System.out.println("요소를 역순으로 정렬했습니다.");
        for(int i=0;i<num;i++)
            System.out.println("x["+i+"]="+x[i]);
        System.out.println(sumOf(x));
    }
}

