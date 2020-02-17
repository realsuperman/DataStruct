package Chapter8;

import java.util.Scanner;

public class BFmatch_csh {
    static int imsi=-1;
    public static void main(String args[]){
        System.out.print("문자열 입력 : ");
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        System.out.print("패턴입력 : ");
        String match = sc.next();
        int index=-1;

        if (match.length() > value.length()) {
            System.out.println("찾고자하는 문자열이 문자열의 길이보다 길순 없음.");
            return ;
        }

        for(int i=0;i<value.length();i++){
            boolean sw = false;
            int temp=i;
            for(int j=0;j<match.length();j++){
                if(!(match.charAt(j)==value.charAt(i))){
                    sw=true;
                    break;
                }else{
                    i++;
                }
                if(i>=value.length()) break;
            }
            i=temp;
            if(!sw){
                imsi=i;
                //index=i;
                //break;
            }
        }
        index=imsi;
        if(index!=-1){
            System.out.println((index+1)+"번째에 존재함");
            return;
        }
        System.out.println("해당 문자열은 없음.");
    }
}
