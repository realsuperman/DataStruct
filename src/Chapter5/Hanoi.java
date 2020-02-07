package Chapter5;

import Chapter4.IntStack;

import java.util.Scanner;

public class Hanoi {
    public static void move(int no,int x,int y){
        if(no>1) {
            move(no - 1, x, 6 - x - y);
        }

        String name=no==1?"A":no==2?"B":"C";
        String name2=x==1?"A":x==2?"B":"C";
        String name3=y==1?"A":y==2?"B":"C";

        System.out.println(name+"기둥을 "+name2+"기둥에서 "+name3+"기둥으로 옮김");
        if(no>1){
            move(no-1,6-x-y,y);
        }
    }

    public static void move2(int no,int x,int y){
        IntStack s = new IntStack(100);
        while(true){
            while(no>=1){
                s.push(y);
                s.push(x);
                s.push(no);

                no=no-1;
                y=6-x-y;
            }
            if(s.isEmpty()!=true){
                no=s.pop();
                x=s.pop();
                y=s.pop();
                String name=no==1?"A":no==2?"B":"C";
                String name2=x==1?"A":x==2?"B":"C";
                String name3=y==1?"A":y==2?"B":"C";
                System.out.println(name+"기둥을 "+name2+"기둥에서 "+name3+"기둥으로 옮김");
                if(no>=1){
                    no=no-1;
                    x=6-x-y;
                }
            }else{
                break;
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int n = sc.nextInt();
        move2(n,1,3);
    }
}
