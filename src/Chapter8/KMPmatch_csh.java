package Chapter8;

import java.util.Scanner;

public class KMPmatch_csh {
    public static int kmpMatch(String txt,String pat){
        int[] fail = new int[pat.length()];
        int num=0;
        for(int i=1;i<pat.length();i++){
            for(int j=0;j<pat.length();j++){
                if(pat.charAt(i)==pat.charAt(j)){
                    fail[i]=++num;
                    i++;
                    if(i>=pat.length()) break;
                }else{
                    num=0;
                    break;
                }
            }
        }
        for(int i=0;i<fail.length;i++) System.out.print(fail[i]+" ");

        if (pat.length() > txt.length()) {
            System.out.println("찾고자하는 문자열이 문자열의 길이보다 길순 없음.");
            return -1;
        }

        for(int i=0;i<txt.length();i++){
            int cnt=0;
            int temp=i;
            for(int j=0;j<pat.length();j++){
                if(!(pat.charAt(j)==txt.charAt(i))){
                    break;
                }else{
                    i++;
                    cnt++;
                }
                if(i>=txt.length()) break;
            }
            if(cnt>=pat.length()) return temp;
            i=temp+fail[cnt];
        }
        return -1;


    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("텍스트 : ");
        String s1 = sc.next();
        System.out.print("패턴 : ");
        String s2 = sc.next();
        int result = kmpMatch(s1, s2);
        System.out.println(result);
    }
}
