package Chapter9;

import java.util.Comparator;

public class DblLinkedList<E> {
    class Node<E>{
        private E data;
        private Node<E> prev;
        private Node<E> next;
        Node(){
            data=null;
            prev=next=this;
        }
        Node(E obj,Node<E> prev, Node<E> next){
            data=obj;
            this.prev=prev;
            this.next=next;
        }
    }
    private Node<E> head;
    private Node<E> crnt;
    public DblLinkedList(){
        head=crnt=new Node<E>();
    }
    public boolean isEmpty(){
        return head.next==head;
    }
    public E search(E obj, Comparator<? super E> c){
        Node<E> ptr = head.next;
        while(ptr!=head){
            if(c.compare(obj,ptr.data)==0){
                crnt=ptr;
                return ptr.data;
            }
            ptr=ptr.next;
        }
        return null;
    }
    public void printCurrentNode(){
        if(isEmpty()) System.out.println("선택 노드가 없습니다.");
        else System.out.println(crnt.data);
    }
    public void dump(){
        Node<E> ptr=head.next;
        while(ptr!=head){
            System.out.println(ptr.data);
            ptr=ptr.next;
        }
    }
    public void dumpReverse(){
        Node<E> ptr = head.prev;
        while(ptr!=head){
            System.out.println(ptr.data);
            ptr=ptr.prev;
        }
    }
    public boolean next(){
        if(isEmpty() || crnt.next == head)
            return false;
        crnt=crnt.next;
        return true;
    }
    public boolean prev(){
        if(isEmpty() || crnt.prev == head) return false;
        crnt=crnt.prev;
        return true;
    }
    public void add(E obj){
        Node<E> node = new Node<E>(obj,crnt,crnt.next);
        crnt.next=crnt.next.prev=node;
        crnt=node;
    }
    public void addFirst(E obj){
        crnt=head;
        add(obj);
    }
    public void addLast(E obj){
        crnt=head.prev;
        add(obj);
    }
    public void removeCurrentNode(){
        if(!isEmpty()){
            crnt.prev.next=crnt.next;
            crnt.next.prev=crnt.prev;
            crnt=crnt.prev;
            if(crnt==head) crnt=head.next;
        }
    }
    public void remove(Node p){
        Node<E> ptr=head.next;
        while(ptr!=head){
            if(ptr==p){
                crnt=p;
                removeCurrentNode();
                break;
            }
            ptr=ptr.next;
        }
    }
    public void removeFirst(){
        crnt=head.next;
        removeCurrentNode();
    }
    public void removeLast(){
        crnt=head.prev;
        removeCurrentNode();;
    }
    public void clear(){
        while(!isEmpty()) removeFirst();
    }
    public void purge(Comparator<? super E> c){
        Node<E> ptr = head.next;
        Node<E> temp = null;
        while(true) {
            boolean sw=false;
            E data = ptr.data; //find data
            Node<E> ptr2 = ptr.next;

            while (ptr2 != head) {
                if (c.compare(data, ptr2.data) == 0) {
                    temp = ptr2;
                    sw=true;
                }
                ptr2 = ptr2.next;
            }
            if(sw) break;
            ptr=ptr.next;
            if(ptr==head) break;
        }
        if(temp!=null){
            while(ptr!=temp){
                crnt=ptr;
                ptr=ptr.next;
            }
            if(ptr==head){
                //crnt.next=null;
            }else{
                crnt.next=ptr.next;
                ptr.next.prev=crnt;
            }

        }
    }
    public E retrieve(int n){
        Node<E> ptr=head.next;
        int cnt=0;
        if(n<0) return null;
        else if(n==0) return ptr.data;
        else{
            while(ptr.next!=head){
                ptr=ptr.next;
                cnt++;
            }
            if(cnt<n) return null;
            ptr=head.next;
            while(n>0){
                ptr=ptr.next;
                n--;
            }
        }
        return ptr.data;
    }
}
