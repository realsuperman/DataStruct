package Chapter4;

public class IntAryQueue {
    private int max; // 큐 용량
    private int num; // 현재 데이터 수
    private int front;
    private int[] que; // 큐 본체

    public IntAryQueue(int capacity){ // 큐 생성자
        max=capacity;
        num=0;
        front=0;
        try{
            que=new int[max];
        }catch(OutOfMemoryError e){
            e.printStackTrace();
        }
    }

    public void insertQue(int x) throws QueueSizeFullException {
        if(num==max){
            QueueSizeFullException e = new QueueSizeFullException();
            throw e;
        }
        que[num++]=x;
    }

    public void deleteQue() throws QueueSizeEmptyException {
        if(num==0){
            QueueSizeEmptyException e = new QueueSizeEmptyException();
            throw e;
        }
        //int index=-1;
/*        for(int i=num-1;i>=0;i--){
            if(que[i]==x) {
                index = i;
                break;
            }
        }*/
        //int index = front++;
        //System.out.println(index);
        //if(index!=-1){
        for(int i=0;i<max-1;i++){
            que[i]=que[i+1];
        }
        num--;
        //}
    }
    public static void main(String args[]) throws QueueSizeFullException, QueueSizeEmptyException {
        IntAryQueue queue = new IntAryQueue(10);
        queue.insertQue(19);
        queue.insertQue(22);
        queue.insertQue(37);
        queue.insertQue(53);
        queue.insertQue(24);
        queue.deleteQue();
        queue.deleteQue();
        queue.deleteQue();
        queue.deleteQue();
        queue.deleteQue();

        for(int i=0;i<10;i++){
            if(queue.que[i]==0) break;
            System.out.println(queue.que[i]);
        }
    }
}

class QueueSizeFullException extends Exception{ }
class QueueSizeEmptyException extends Exception { }