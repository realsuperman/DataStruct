package Chapter4;

import java.util.Scanner;

public class IntQueue {
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] que;

    public static class EmptyIntQueueException extends RuntimeException{
        public EmptyIntQueueException(){}
    }

    public static class OverflowIntQueueException extends RuntimeException{
        public OverflowIntQueueException(){}
    }

    public IntQueue(int capacity){
        num=front=rear=0;
        max=capacity;
        try{
            que=new int[max];
        }catch(OutOfMemoryError e){
            max=0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException {
        if(num>=max) throw new OverflowIntQueueException();
        que[rear++]=x;
        num++;
        if(rear==max) rear=0;
        return x;
    }

    public int deque() throws EmptyIntQueueException{
        if(num<=0) throw new EmptyIntQueueException();
        int x= que[front++];
        num--;
        if(front==max) front=0;
        return x;
    }

    public int peek() throws EmptyIntQueueException{
        if(num<=0) throw new EmptyIntQueueException();
        return que[front];
    }

    public int indexOf(int x){
        for(int i=0;i<num;i++){
            int idx=(i+front)%max;
            if(que[idx]==x) return idx;
        }
        return -1;
    }

    public void clear(){
        num=front=rear=0;
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return num;
    }

    public boolean isEmpty(){
        return num<=0;
    }

    public boolean isFull(){
        return num>=max;
    }

    public void dump(){
        if(num<=0) System.out.println("큐가 비어 있습니다.");
        else{
            for(int i=0;i<num;i++) System.out.println(que[(i+front)%max]+" ");
            System.out.println();
        }
    }

    public int search(int x){
        for(int i=0;i<num;i++){
            int idx=(i+front)%max;
            if(que[idx]==x) return idx+1;
        }
        return 0;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        IntQueue s = new IntQueue(64);
        while(true){
            System.out.println("현재 데이터 수 : "+s.size()+" / "+s.capacity());
            System.out.print("(1)인큐 (2)디큐 (3)피크 "+"(4)덤프 (5)찾기 (0)종료 : ");
            int menu=sc.nextInt();
            if(menu==0) break;
            int x;
            switch (menu){
                case 1:
                    System.out.print("데이터 : ");
                    x=sc.nextInt();
                    try{
                        s.enque(x);
                    }catch(IntQueue.OverflowIntQueueException e){
                        System.out.println("큐가 가득찼습니다.");
                    }
                    break;
                case 2:
                    try{
                        x=s.deque();
                        System.out.println("디큐한 데이터는 "+x+"입니다.");
                    }catch(IntQueue.EmptyIntQueueException e){
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 3 :
                    try{
                        x=s.peek();
                        System.out.println("피크한 데이터는 "+x+"입니다.");
                    }catch(IntQueue.EmptyIntQueueException e){
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 4 :
                    s.dump();
                    break;
                case 5 :
                    int index=s.search(10);
                    if(index!=0) System.out.println("찾고자하는 녀석은 "+(index-1)+"번째에 있습니다.");
                    else System.out.println("찾고자하는 녀석은 없습니다.");
                    break;
            }
        }
    }
}
