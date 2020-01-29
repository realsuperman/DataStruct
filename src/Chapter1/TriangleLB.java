package Chapter1;

import java.util.Scanner;

public class TriangleLB {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        /*int n;
        System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");
        do{
            System.out.print("몇 단 삼각형 입니까?");
            n=sc.nextInt();
        }while(n<=0);
        triangleLB(n);
        System.out.println();
        triangleLu(n);
        System.out.println();
        triangleRu(n);
        System.out.println();
        triangleRb(n);
         */
        //System.out.println();
        //spira(3);
        npira(3);
    }
    public static void triangleLB(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void triangleLu(int n){
        int c=n;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=c;j++){
                System.out.print("*");
            }
            c--;
            System.out.println();
        }
    }
    static void triangleRu(int n){
        int c=n;
        for(int i=1;i<=n;i++){
            for(int k=1;k<i;k++){
                System.out.print(" ");
            }
            for(int j=1;j<=c;j++){
                System.out.print("*");
            }
            c--;
            System.out.println();
        }
    }
    static void triangleRb(int n){
        for(int i=1;i<=n;i++){
            for(int k=5;k>i;k--){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void spira(int n){
        if(n==1) return;
        int c=1;
        int star=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=((n-c));j++){ // 좌측 공백
                System.out.print(" ");
            }
            for(int j=1;j<=star;j++){
                System.out.print("*");
            }
            for(int j=1;j<=((n-c));j++){ // 우측 공백
                System.out.print(" ");
            }
            c++;
            star=star+2;
            System.out.println();
        }
    }
    static void npira(int n){
        if(n==1) return;
        int c=1;
        int star=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=((n-c));j++){ // 좌측 공백
                System.out.print(" ");
            }
            for(int j=1;j<=star;j++){
                System.out.print(c);
            }
            for(int j=1;j<=((n-c));j++){ // 우측 공백
                System.out.print(" ");
            }
            c++;
            star=star+2;
            System.out.println();
        }
    }
}
