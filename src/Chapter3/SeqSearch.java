package Chapter3;

import java.util.Scanner;

public class SeqSearch {
    static int seqSearch(int[] a,int n,int key){
        /*while(true){
            if(i==n) return -1;
            if(a[i]==key) return i;
            i++;
        }*/
        System.out.print("   | ");
        for(int i=0;i<n;i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("---+----------------");
        for(int i=0;i<n;i++){
            System.out.print("   |");
            for(int k=0;k<i;k++){
                System.out.print("  ");
            }
            System.out.printf("%c\n",'*');
            System.out.print(i+"  |");
            for(int j=0;j<n;j++){
                System.out.print(a[j]+" ");
            }
            System.out.println();
            if(a[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수 : ");
        int num=sc.nextInt();
        int[] x=new int[num];
        for(int i=0;i<num;i++){
            System.out.print("x["+i+"] :");
            x[i]=sc.nextInt();
        }
        System.out.print("검색할 값 : ");
        int ky=sc.nextInt();
        int idx=seqSearch(x,num,ky);
        if(idx==-1) System.out.println("그 값의 요소가 없습니다.");
        else System.out.println(ky+"은(는) x["+idx+"]에 있습니다.");
    }
}
