package Chapter1;

import java.util.Scanner;

public class IntLength {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = 1;
        int c = 0;
        while(true){
            int su = a/b;
            b=b*10;
            c++;
            if(su<1) break;
        }
        System.out.println("해당 수는 "+(c-1)+"자릿수 입니다.");
    }
}
