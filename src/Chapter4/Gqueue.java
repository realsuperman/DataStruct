package Chapter4;

import java.util.Scanner;

public class Gqueue<E> {
    private int max;
    private int front;
    private int rear;
    private int num;
    private E[] que;

    public static class EmptyGqueueException extends RuntimeException{
        public EmptyGqueueException(){}
    }

    public static class OverflowGqueueException extends RuntimeException{
        public OverflowGqueueException(){}
    }

    public Gqueue(int capacity){
        num=front=rear=0;
        max=capacity;
        try{
            que= (E[])new Object[max];
        }catch(OutOfMemoryError e){
            max=0;
        }
    }

    public E enque(E x) throws OverflowGqueueException {
        if(num>=max) throw new OverflowGqueueException();
        que[rear++]=x;
        num++;
        if(rear==max) rear=0;
        return x;
    }

    public E deque() throws EmptyGqueueException{
        if(num<=0) throw new EmptyGqueueException();
        E x= que[front++];
        num--;
        if(front==max) front=0;
        return x;
    }

    public E peek() throws EmptyGqueueException{
        if(num<=0) throw new EmptyGqueueException();
        return que[front];
    }

    public int indexOf(E x){
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

    public int search(E x){
        for(int i=0;i<num;i++){
            int idx=(i+front)%max;
            if(que[idx].equals(x)) return idx+1;
        }
        return 0;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Gqueue s = new Gqueue(64);
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
                    }catch(Gqueue.OverflowGqueueException e){
                        System.out.println("큐가 가득찼습니다.");
                    }
                    break;
                case 2:
                    try{
                        x=(int)s.deque();
                        System.out.println("디큐한 데이터는 "+x+"입니다.");
                    }catch(Gqueue.EmptyGqueueException e){
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 3 :
                    try{
                        x=(int)s.peek();
                        System.out.println("피크한 데이터는 "+x+"입니다.");
                    }catch(Gqueue.EmptyGqueueException e){
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 4 :
                    s.dump();
                    break;
                case 5 :
                    System.out.print("찾는 값 입력 : ");
                    int index=s.search(sc.nextInt());
                    if(index!=0) System.out.println("찾고자하는 녀석은 "+(index-1)+"번째에 있습니다.");
                    else System.out.println("찾고자하는 녀석은 없습니다.");
                    break;
            }
        }
    }
}
