package Chapter4;

import java.util.Scanner;

public class IntDeque {
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

    public IntDeque(int capacity){
        num=front=rear=0;
        max=capacity;
        try{
            que=new int[max];
        }catch(OutOfMemoryError e){
            max=0;
        }
    }

    public int enque(int choice,int x) throws OverflowIntQueueException {
        if(num>=max) throw new OverflowIntQueueException();
        if(choice==1){ // rear에다가 추가
            que[rear++]=x;
            if(rear==max) rear=0;
        }else{ // front에다가 추가
            for(int i=num;i>0;i--){
                que[((front+i)%max)]=que[((front+i)%max)-1];
            }
            que[(front)%max]=x;
            rear++;
        }
        num++;
        return x;
    }

    public int deque(int choice) throws EmptyIntQueueException{
        if(num<=0) throw new EmptyIntQueueException();
        int x;
        if(choice==2){ // rear에다가 빼기
            x= que[front++];
            if(front==max) front=0;
            num--;
            return x;
        }
        int point=--rear;
        if(point==-1){ // 이전으로 돌아가야함
            rear=max-1;
        }
        x=que[rear];
        num--;
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
        IntDeque s = new IntDeque(4);
        while(true){
            System.out.print("데큐기능 구현 1번은 rear에서 2번은 front에서 작업 수행 진행 ");
            int choice=sc.nextInt();
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
                        s.enque(choice,x);
                    }catch(IntDeque.OverflowIntQueueException e){
                        System.out.println("큐가 가득찼습니다.");
                    }
                    break;
                case 2:
                    try{
                        x=s.deque(choice);
                        System.out.println("디큐한 데이터는 "+x+"입니다.");
                    }catch(IntDeque.EmptyIntQueueException e){
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 3 :
                    try{
                        x=s.peek();
                        System.out.println("피크한 데이터는 "+x+"입니다.");
                    }catch(IntDeque.EmptyIntQueueException e){
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
