package Chapter9;

import java.util.Comparator;

public class CircleLinkedList<E> {
    class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E data,Node<E> next){
            this.data=data;
            this.next=next;
        }
    }
    private Node<E> head;
    private Node<E> crnt;
    private Node<E> tail;
    public CircleLinkedList(){
        head=tail=crnt=null;
    }
    public E search(E obj, Comparator<? super E> c){
        if(head.next==null){
            if(c.compare(obj,head.data)==0){
                crnt=head;
                return head.data;
            }else{
                return null;
            }
        }

        Node<E> ptr = head;
        do{
            if(c.compare(obj,ptr.data)==0){
                crnt=ptr;
                return ptr.data;
            }
            ptr=ptr.next;
        }while(ptr!=head);
        return null;
    }
    public void addFirst(E obj){
        Node<E> ptr=head;
        head=crnt=new Node<E>(obj,ptr);
        if(tail==null) tail=crnt;
        else{ //tail 존재시
            if(tail.next==null) {
                Node<E> pre = head;
                while (pre.next != null) {
                    pre = pre.next;
                }
                pre.next=head;
                tail=pre;
            }else{
                Node<E> pre2 = tail;
                pre2.next=head;
            }
        }
    }
    public void addLast(E obj){
        if(head==null){
            addFirst(obj);
        }
        else{
            Node<E> ptr=tail;
            tail=ptr.next=crnt=new Node<E>(obj,head);
        }
    }
    public void removeFirst(){
        Node<E> ptr = head;
        if(ptr==tail){
            head=null;
            tail=null;
            crnt=null;
        }else{
            head=crnt=ptr.next;
            tail.next=head;
        }
    }
    public void removeLast(){
        if(head!=null){
            if(head==tail){
                removeFirst();
            }
            else{
                Node<E> ptr = head;
                Node<E> pre;
                do{
                    pre=ptr;
                    ptr=ptr.next;
                }while(ptr.next!=head);

                pre.next=head;
                tail=crnt=pre;
                //if(head==pre.next) pre.next=null;
            }
        }
    }
    public void remove(Node p){
        if(head!=null){
            if(p==head) removeFirst();
            else if(head==tail){
                removeLast();
            }else{
                Node<E> ptr = head;
                while(ptr.next != p){
                    ptr=ptr.next;
                    if(ptr==null) return;
                }
                ptr.next=p.next;
                crnt=ptr;
            }
        }
    }
    public void removeCurrentNode(){
        remove(crnt);
    }
    public void clear(){
        while(head!=null) removeFirst();
        crnt=null;
    }
    public boolean next(){
        //if(crnt==null || crnt.next==null) return false;
        if(crnt==null) return false;
        crnt=crnt.next;
        return true;
    }
    public void printCurrentNode(){
        if(crnt==null) System.out.println("선택한 노드가 없습니다.");
        else System.out.println(crnt.data);
    }
    public void dump(){
        if(head==null) return;
        if(head.next==null){
            System.out.println(head.data);
            return;
        }

        Node<E> ptr = head;
        do{
            System.out.println(ptr.data);
            ptr = ptr.next;
        }while(ptr!=head);
    }
    public void purge(Comparator<? super E> c){
        if(head.next==null) return;
        Node<E> ptr = head;
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
            if(crnt.next==tail){
                tail=crnt;
            }
            if(ptr==head){
                crnt.next=null;
            }
            else{
                crnt.next=temp.next;
            }
        }
    }
    public E retrieve(int n){
        Node<E> ptr=head;
        int cnt=0;
        if(n<0) return null;
        else if(n==0) return head.data;
        else{
            do{
                ptr=ptr.next;
                cnt++;
            }while(ptr!=head);
            if(cnt<=n) return null;

            ptr=head;
            while(n>0){
                ptr=ptr.next;
                n--;
            }
        }
        return ptr.data;
    }

}
