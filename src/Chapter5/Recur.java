package Chapter5;
import Chapter4.IntStack;
import java.util.Scanner;

public class Recur {
    static void recur(int n){
        IntStack s = new IntStack(n);
        while(true){
            if(n>0){
                s.push(n);
                n=n-1;
                continue;
            }
            if(s.isEmpty()!=true){
                n=s.pop();
                System.out.println(n);
                n=n-2;
                continue;
            }
            break;
        }

    }
    static void recur2(int n){
        if(n>0){
            recur2(n-2);
            System.out.println(n);
            recur2(n-1);
        }
    }


    static void recur4(int n){
        // 실행문장 재귀함수 재귀함수 일때
        IntStack s = new IntStack(100);
        s.push(n);
        while(s.isEmpty()!=true){
            n=s.pop();
            if(n>0){
                System.out.println(n);
                s.push(n-2);
                s.push(n-1);
            }
        }
    }

    static void recur5(int n){
        // 재귀함수 실행문장 재귀함수 일때
        IntStack s = new IntStack(100);
        while(true){
            while(n>0){
                s.push(n);
                n=n-1;
            }
            if (s.isEmpty()!=true){
                n = s.pop();
                System.out.println(n);
                n= n-2;
            }
            else{
                break;
            }
        }
    }

    static void recur3(int n){
        // 재귀함수 재귀함수 실행문장 일때
        IntStack s = new IntStack(100);
        boolean done=false;
        int t;
        while(!done){
            while(n>0){
                s.push(n);
                n=n-1;
            }
            while(s.isEmpty()!=true){
                t=n;
                n=s.pop();
                if(n-2>=0){
                    if(t==n-2){
                        System.out.println(n);
                    }else{
                        s.push(n);
                        n=n-2;
                        break;
                    }
                }else{
                    System.out.println(n);
                }
                if(s.isEmpty()){
                    done=true;
                }
            }
        }

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int x = sc.nextInt();
        recur3(x);
    }
}
