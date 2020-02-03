package Chapter4;

import java.util.Scanner;

public class IntStackUpgrade {
    private int max;
    private int ptr;
    private int ptr2;
    private int[] stk;
    public static class EmptyIntStackUpgradeException extends RuntimeException{
        public EmptyIntStackUpgradeException(){};
    }
    public static class OverflowIntStackUpgradeException extends RuntimeException{
        public OverflowIntStackUpgradeException(){}
    }
    public IntStackUpgrade(int capacity){
        ptr=0;
        max=capacity;
        ptr2=max/2;
        try{
            stk=new int[max];
        }catch(OutOfMemoryError e){
            max=0;
        }
    }
    public int push(int choice,int x) throws OverflowIntStackUpgradeException{
        if(choice==1) { // 1번 스택 사용
            if(ptr>=max/2) throw new OverflowIntStackUpgradeException();
            return stk[ptr++]=x;
        }
        if(ptr2>=max) throw new OverflowIntStackUpgradeException();
        return stk[ptr2++]=x;
    }
    public int pop(int choice) throws EmptyIntStackUpgradeException {
        if(choice==1){ // 1번 스택 사용
            if(ptr<=0) throw new EmptyIntStackUpgradeException();
            return stk[--ptr];
        }
        if(ptr2<=max/2) throw new EmptyIntStackUpgradeException();
        return stk[--ptr2];
    }
    public int peek(int choice) throws EmptyIntStackUpgradeException{
        if(choice==1){ // 1번 스택 사용
            if(ptr<=0) throw new EmptyIntStackUpgradeException();
            return stk[ptr-1];
        }
        if(ptr2<=max/2) throw new EmptyIntStackUpgradeException();
        return stk[ptr2-1];
    }
    public int indexOf(int choice,int x){
        int start;
        int end;
        if(choice==1) { // 1번 스택 사용
            start=ptr;
            end=0;
        }else{
            start=ptr2;
            end=max/2;
        }
        for(int i=start-1;i>=end;i--){
            if(stk[i]==x) return i;
        }
        return -1;
    }
    public void clear(int choice){
        if(choice==1){
            ptr=0;
        }else{
            ptr2=max/2;
        }
    }
    public int capacity(int choice){
        if(choice==1) return max/2;
        return max;
    }
    public int size(int choice){
        if(choice==1) return ptr;
        else return ptr2;
    }
    public boolean isEmpty(int choice){
        if(choice==1) return ptr<=0;
        return ptr2 <= max/2;
    }
    public boolean isFull(int choice){
        if(choice==1) return ptr>=max/2;
        return ptr2>=max;
    }
    public void dump(int choice){
        if(choice==1) {
            if (ptr <= 0) System.out.println("스택이 비어 있습니다.");
            else{
                for(int i=0;i<ptr;i++){
                    System.out.println(stk[i]+" ");
                }
                System.out.println();
            }
        }else{
            if(ptr2<=max/2) System.out.println("스택이 비어 있습니다.");
            else{
                for(int i=max/2;i<ptr2;i++){
                    System.out.println(stk[i]+" ");
                }
                System.out.println();
            }
        }

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        IntStackUpgrade s = new IntStackUpgrade(64); // 짝수 권장
        while(true){
            System.out.print("1번 2번 스택중 선택 : ");
            int choice = sc.nextInt();
            System.out.println("현재 데이터 수 : "+s.size(choice)+" / "+s.capacity(choice));
            System.out.print("(1)푸시 (2)팝 (3) 피크 "+"(4)덤프 (5)찾기 (6)초기화 (0)프로그램 종료 :");
            int menu=sc.nextInt();
            if(menu==0) break;
            int x;
            switch(menu){
                case 1 :
                    System.out.print("데이터 : ");
                    x=sc.nextInt();
                    try{
                        if(s.isFull(choice)){
                            throw new IntStackUpgrade.OverflowIntStackUpgradeException();
                        }
                        s.push(choice,x);
                    }catch(IntStackUpgrade.OverflowIntStackUpgradeException e){
                        System.out.println("스택이 가득찼습니다.");
                    }
                    break;
                case 2 :
                    try{
                        if(s.isEmpty(choice)){
                            throw new IntStackUpgrade.EmptyIntStackUpgradeException();
                        }
                        x=s.pop(choice);
                        System.out.println("팝한 데이터는 "+x+"입니다.");
                    }catch(IntStackUpgrade.EmptyIntStackUpgradeException e){
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 3 :
                    try{
                        x=s.peek(choice);
                        System.out.println("피크한 데이터는 "+x+"입니다.");
                    }catch(IntStackUpgrade.EmptyIntStackUpgradeException e){
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 4 :
                    s.dump(choice);
                    break;
                case 5 :
                    System.out.print("찾는 데이터 입력 : ");
                    int index = s.indexOf(choice,sc.nextInt());
                    if(index!=-1) {
                        System.out.println("찾고자 하는 데이터는 "+index+"번째에 있습니다.");
                        break;
                    }
                    System.out.println("찾고자 하는 데이터는 없습니다.");
                    break;
                case 6 :
                    System.out.println("초기화 완료!");
                    s.clear(choice);
                    break;
            }
        }
    }
}
