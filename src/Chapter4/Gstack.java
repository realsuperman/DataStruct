package Chapter4;

import java.util.Scanner;

public class Gstack<E> {
    private int max;
    private int ptr;
    private E[] stk;
    public static class EmptyGstackException extends RuntimeException{
        public EmptyGstackException(){};
    }
    public static class OverflowGstackException extends RuntimeException{
        public OverflowGstackException(){}
    }
    public Gstack(int capacity){
        ptr=0;
        max=capacity;
        try{
            stk=(E[])new Object[max];
        }catch(OutOfMemoryError e){
            max=0;
        }
    }
    public E push(E x) throws OverflowGstackException{
        if(ptr>=max) throw new OverflowGstackException();
        return stk[ptr++]=x;
    }
    public E pop() throws EmptyGstackException {
        if(ptr<=0) throw new EmptyGstackException();
        return stk[--ptr];
    }
    public E peek() throws EmptyGstackException{
        if(ptr<=0) throw new EmptyGstackException();
        return stk[ptr-1];
    }
    public int indexOf(E x){
        for(int i=ptr-1;i>=0;i--){
            if(x.equals(stk[i])) return i;
        }
        return -1;
    }
    public void clear(){
        ptr=0;
    }
    public int capacity(){
        return max;
    }
    public int size(){
        return ptr;
    }
    public boolean isEmpty(){
        return ptr<=0;
    }
    public boolean isFull(){
        return ptr>=max;
    }
    public void dump(){
        if(ptr<=0) System.out.println("스택이 비어 있습니다.");
        else{
            for(int i=0;i<ptr;i++){
                System.out.println(stk[i]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Gstack s = new Gstack(64);
        while(true){
            System.out.println("현재 데이터 수 : "+s.size()+" / "+s.capacity());
            System.out.print("(1)푸시 (2)팝 (3) 피크 "+"(4)덤프 (5)찾기 (6)초기화 (0)종료 :");
            int menu=sc.nextInt();
            if(menu==0) break;
            int x;
            switch(menu){
                case 1 :
                    System.out.print("데이터 : ");
                    x=sc.nextInt();
                    try{
                        if(s.isFull()){
                            throw new Gstack.OverflowGstackException();
                        }
                        s.push(x);
                    }catch(Gstack.OverflowGstackException e){
                        System.out.println("스택이 가득찼습니다.");
                    }
                    break;
                case 2 :
                    try{
                        if(s.isEmpty()){
                            throw new Gstack.EmptyGstackException();
                        }
                        x= (int) s.pop();
                        System.out.println("팝한 데이터는 "+x+"입니다.");
                    }catch(Gstack.EmptyGstackException e){
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 3 :
                    try{
                        x= (int) s.peek();
                        System.out.println("피크한 데이터는 "+x+"입니다.");
                    }catch(Gstack.EmptyGstackException e){
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 4 :
                    s.dump();
                    break;
                case 5 :
                    int index = s.indexOf(sc.nextInt());
                    if(index!=-1) {
                        System.out.println("찾고자 하는 데이터는 "+index+"번째에 있습니다.");
                        break;
                    }
                    System.out.println("찾고자 하는 데이터는 없습니다.");
                    break;
                case 6 :
                    System.out.println("초기화 완료!");
                    s.clear();
                    break;
            }
        }
    }
}
