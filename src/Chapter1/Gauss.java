package Chapter1;

import java.util.Scanner;

public class Gauss {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int sum=0;
        sum=a*(a+1)/2;
        System.out.println(sum);
    }
}
