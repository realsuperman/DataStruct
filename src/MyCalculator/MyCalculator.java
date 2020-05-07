/*
요구사항

1. 수식은 괄호가 있을 수 있고, 띄어쓰기가 ' '되어 있다고 가정해도 됩니다.
    operator는 +, -, *, / 네 가지로 하고 operand는 양수로만 하고 실수형
    (정수형이 아님)으로 할 것

2. 잘못 입력 된 수식이 경우 에러 메시지를 출력하고 가능한 모든 에러 상황들을
    확인 할 수 있어야 함

3. 사용자 인터페이스는 자율적으로 정하면 됨

예시 : (5 + 3) * 2 -> 53+2*
 */
package MyCalculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyCalculator {
    public static String[] array={"+","-","/","*","(",")"};
    public static ArrayList<Integer> parseLocation = new ArrayList<>();

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("====== MyCalculator =======");
        System.out.println("MyCalculator 사용을 환영합니다.");
        System.out.println();

        while(true){
            String yn;

            System.out.println("Infix로 수식을 입력하시오.");
            String val = parseString(sc.nextLine());

            System.out.println("Postfix로 변환 : "+val);
            System.out.println("계산을 시작할까요? (Y/N)");
            yn=sc.next();
            if(yn.equalsIgnoreCase("y")){
                double sum = calculator(val);
                System.out.println("계산 값 : "+sum);
            }

            System.out.println("계속하시겠습니까? (Y/N)");
            yn = sc.next();
            if(yn.equalsIgnoreCase("n")){
                System.out.println("사용해주셔서 감사합니다.");
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
    public static String parseString(String str){
        StringStack st = new StringStack(100);
        StringBuilder temp = new StringBuilder("");
        int index=0;

        for(int i=0;i<str.length();i++){
            int sw=0;

            for(String j : array){
                if(j.equals(String.valueOf(str.charAt(i)))){
                    sw=1;
                    if(j.equals("(")){
                       pushStack(st,null,j);
                    }else if(j.equals(")")){
                        popStack(st,temp);
                    }else{
                        pushStack(st,temp,j);
                    }
                }
            }

            if(sw==0){
                index++;
                temp.append(str.charAt(i));
            }else{ // 숫자가 아닌 기호나 괄호를 만난경우에 해당된다.
                if(index>0){
                    parseLocation.add(index-1);
                    //System.out.println(index-1);
                }
                index=0;
            }
        }
        if(index>0){
            parseLocation.add(index-1);
            //System.out.println(index-1);
        }

        while(!st.isEmpty()){
            temp.append(st.pop());
        }
        return temp.toString();
    }
    public static void pushStack(StringStack st,StringBuilder temp,String value){
        if(st.isEmpty() || value.equals("(")) st.push(value);
        else{
            int length = st.size();

            if(value.equals("+")||value.equals("-")){
                if(st.getIndex(length-1).equals("(")){
                    st.push(value);
                }else{
                    temp.append(st.pop());
                    st.push(value);
                }

            }else if(value.equals("*")||value.equals("/")){
                if(st.getIndex(length-1).equals("+")||st.getIndex(length-1).equals("-")){
                    st.push(value);
                }else{
                    if(st.getIndex(length-1).equals("(")){
                        st.push(value);
                    }else {
                        temp.append(st.pop());
                        st.push(value);
                    }
                }
            }
        }
    }

    public static void popStack(StringStack st,StringBuilder str){
        for(;;){
            if(st.isEmpty()) break;
            String a = st.pop();
            if(a.equals("(")) break;
            str.append(a);
        }
    }

    public static double calculator(String str){
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        DoubleStack st = new DoubleStack(100);
        String temp="";

        for(int i=0;i<str.length();i++){
            int sw=0;
            for(int j=0;j<4;j++){
                if(array[j].equals(String.valueOf(str.charAt(i)))){
                    sw=1;
                }
            }

            if(sw==0){
                st.push(Double.parseDouble(String.valueOf(str.charAt(i))));
            }else{ // 연산자를 만난경우
                double a,b;
                b=st.pop();
                a=st.pop();

                try {
                    String sum=Double.toString(a);
                    sum+=String.valueOf(str.charAt(i));
                    sum+=Double.toString(b);
                    st.push((Double) engine.eval(sum));
                }catch(ScriptException e) {

                }

            }
        }
        return st.pop();
    }
}
