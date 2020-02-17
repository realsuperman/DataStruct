package Chapter8;

import java.util.Scanner;

public class BFmatch {
    static int cnt=0;
    static int count=0;
    static int bfMatch(String txt,String pat){
        int pt=0;
        int pp=0;
        int sw=0;
        while(pt!=txt.length()&&pp!=pat.length()){
            count++;
            sw=0;
            System.out.print(cnt+" ");
            for(int i=0;i<txt.length();i++){
                System.out.print(txt.charAt(i));
            }
            System.out.println();
            System.out.print("  ");
            for(int i=0;i<cnt;i++) System.out.print(" ");
            for(int i=0;i<pp;i++) System.out.print(" ");
            if(txt.charAt(pt)==pat.charAt(pp)){
                System.out.print("+");
                pt++;
                pp++;
            }else{
                System.out.print("|");
                pt=pt-pp+1;
                pp=0;
                sw=1;
            }
            System.out.println();
            System.out.print("  ");
            for(int i=0;i<cnt;i++) System.out.print(" ");
            for(int i=0;i<pat.length();i++){
                System.out.print(pat.charAt(i));
            }
            System.out.println();
            if(sw==1) cnt++;
        }
        if(pp==pat.length()) return pt-pp;
        return -1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("텍스트 : ");
        String s1=sc.next();
        System.out.print("패턴 : ");
        String s2=sc.next();
        int idx = bfMatch(s1,s2);
        if(idx==-1) System.out.println("텍스트에 패턴이 없습니다.");
        else{
            System.out.println("비교는 "+count+"회였습니다.");
            int len=0;
            for(int i=0;i<idx;i++)
                len+=s1.substring(i,i+1).getBytes().length;
            len+=s2.length();
            System.out.println((idx+1)+"번째 문자부터 일치합니다.");
            System.out.println("텍스트 : "+s1);
            System.out.printf(String.format("패턴 : %%%ds\n",len),s2);
        }
    }
}
