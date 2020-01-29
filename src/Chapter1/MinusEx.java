package Chapter1;

import java.util.Scanner;

public class MinusEx {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("a의 값 : ");
        int a=sc.nextInt();
        System.out.print("b의 값 : ");
        int b=sc.nextInt();
        while(b<=a){
            System.out.println("a보다 큰 값을 입력하세요 !");
            b=sc.nextInt();
        }
        System.out.println("b-a는"+(b-a)+"입니다.");
    }
}
