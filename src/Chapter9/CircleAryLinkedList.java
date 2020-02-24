package Chapter9;

import java.util.Comparator;

public class CircleAryLinkedList<E> {
    class Node<E> {
        private E data;
        private int next;
        private int dnext;

        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node<E>[] n;
    private int size;
    private int max;
    private int head;
    private int tail;
    private int crnt;
    private int deleted;
    private static final int NULL=-1;

    public CircleAryLinkedList(int capacity){
        head=tail=crnt=max=deleted=NULL;
        try{
            n = new Node[capacity];
            for(int i=0;i<capacity;i++) n[i]=new Node<>();
            size=capacity;
        }catch(OutOfMemoryError e){
            size=0;
        }
    }
    private int getInsertIndex(){
        if(deleted==NULL) {
            if (max < size)
                return ++max;
            else return NULL;
        }else{
            int rec=deleted;
            deleted=n[rec].dnext;
            return rec;
        }
    }
    private void deleteIndex(int idx){
        if(deleted==NULL){
            deleted=idx;
            n[idx].dnext=NULL;
        }
    }
    public E search(E obj,Comparator<? super E> c){
        int ptr =head;
        while(ptr!=NULL){
            if(c.compare(obj,n[ptr].data)==0){
                crnt=ptr;
                return n[ptr].data;
            }
            ptr=n[ptr].next;
        }
        return null;
    }
    public void addFirst(E obj){
        int ptr=head;
        int rec=getInsertIndex();
        if(rec!=NULL){
            head=crnt=rec;
            n[head].set(obj,ptr);
        }
        if(tail==NULL) tail=crnt;
    }
    public void addLast(E obj){
        if(head==NULL) addFirst(obj);
        else{
            int ptr=tail;
            //while(n[ptr].next!=NULL) ptr=n[ptr].next;
            int rec=getInsertIndex();
            if(rec!=NULL){
                n[ptr].next=crnt=rec;
                n[rec].set(obj,NULL);
                tail=crnt;
            }
        }
    }
    public void removeFirst(){
        if(head!=NULL){
            int ptr=n[head].next;
            deleteIndex(head);
            head=crnt=ptr;
        }
        if(n[tail].next==NULL) tail=crnt;
    }
    public void removeLast(){
        if(head!=NULL){
            if(n[head].next==NULL){
                removeFirst();
                tail=crnt;
            }
            else{
                int ptr=head;
                int pre=head;
                while(n[ptr].next!=NULL){
                    pre=ptr;
                    ptr=n[ptr].next;
                }
                n[pre].next=NULL;
                deleteIndex(pre);
                tail=crnt=pre;
            }
        }
    }
    public void remove(int p){
        if(head!=NULL){
            if(p==head) removeFirst();
            else{
                int ptr=head;
                while(n[ptr].next!=p){
                    ptr=n[ptr].next;
                    if(ptr==NULL) return;
                }
                n[ptr].next=NULL;
                deleteIndex(ptr);
                n[ptr].next=n[p].next;
                crnt=ptr;
            }
        }
    }
    public void removeCurrentNode(){
        remove(crnt);
    }
    public void clear(){
        while(head!=NULL) removeFirst();
        crnt=NULL;
    }
    public boolean next(){
        if(crnt==NULL || n[crnt].next == NULL)
            return false;
        crnt=n[crnt].next;
        return true;
    }
    public void printCurrentNode(){
        if(crnt==NULL) System.out.println("선택 노드가 없습니다.");
        else System.out.println(n[crnt].data);
    }
    public void dump(){
        int ptr=head;
        while(ptr!=NULL){
            System.out.println(n[ptr].data);
            ptr=n[ptr].next;
        }
    }

    public void purge(Comparator<? super E> c){
        int ptr = head;
        int temp = -1;

        while(true) {
            boolean sw=false;
            E data = n[ptr].data; //find data
            int ptr2 = n[ptr].next;

            while (ptr2 != NULL) {
                if (c.compare(data, n[ptr2].data) == 0) {
                    temp = ptr2;
                    sw=true;
                }
                ptr2=n[ptr2].next;
            }
            if(sw) break;
            ptr=n[ptr].next;
            if(ptr==NULL) break;
        }
        if(temp!=-1){
            while(ptr!=temp){
                crnt=ptr;
                ptr=n[ptr].next;
            }
            if(ptr==NULL) n[crnt].next=-1; //crnt.next=null;
            else n[crnt].next=n[temp].next; //crnt.next=temp.next;
        }
    }

    public E retrieve(int size){
        int ptr = head;
        int cnt=0;
        if(size<0) return null;
        else if(size==0) return n[head].data;
        else{
            while(n[ptr].next!=NULL){
                ptr=n[ptr].next;
                cnt++;
            }
            if(cnt<size) return null;
            ptr=head;
            while(size>0){
                ptr=n[ptr].next;
                size--;
            }
        }
        return n[ptr].data;
    }
}
