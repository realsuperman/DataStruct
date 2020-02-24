package Chapter9;

import java.util.Comparator;

public class LinkedList<E> {
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
    public LinkedList(){
        head=tail=crnt=null;
    }
    public E search(E obj, Comparator<? super E> c){
        Node<E> ptr = head;
        while(ptr!=null){
            if(c.compare(obj,ptr.data)==0){
                crnt=ptr;
                return ptr.data;
            }
            ptr=ptr.next;
        }
        return null;
    }
    public void addFirst(E obj){
        Node<E> ptr=head;
        head=crnt=new Node<E>(obj,ptr);
        if(tail==null) tail=crnt;
    }
    public void addLast(E obj){
        if(head==null){
            addFirst(obj);
            //tail=crnt;
        }
        else{
            Node<E> ptr=tail;
            tail=ptr.next=crnt=new Node<E>(obj,null);
        }
    }
    public void removeFirst(){
        if(head!=null) head=crnt=head.next;
        if(tail.next==null) tail=crnt;
    }
    public void removeLast(){
        if(head!=null){
            if(head.next==null){
                removeFirst();
                tail=crnt;
            }
            else{
                Node<E> ptr = head;
                Node<E> pre = head;
                while(ptr.next!=null){
                    pre=ptr;
                    ptr=ptr.next;
                }
                pre.next=null;
                tail=crnt=pre;
            }
        }
    }
    public void remove(Node p){
        if(head!=null){
            if(p==head) removeFirst();
            else{
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
        if(crnt==null || crnt.next==null) return false;
        crnt=crnt.next;
        return true;
    }
    public void printCurrentNode(){
        if(crnt==null) System.out.println("선택한 노드가 없습니다.");
        else System.out.println(crnt.data);
    }
    public void dump(){
        Node<E> ptr = head;
        while(ptr!=null){
            System.out.println(ptr.data);
            ptr=ptr.next;
        }
    }
    public void purge(Comparator<? super E> c){
        Node<E> ptr = head;
        Node<E> temp = null;
        while(true) {
            boolean sw=false;
            E data = ptr.data; //find data
            Node<E> ptr2 = ptr.next;

            while (ptr2 != null) {
                if (c.compare(data, ptr2.data) == 0) {
                    temp = ptr2;
                    sw=true;
                }
                ptr2 = ptr2.next;
            }
            if(sw) break;
            ptr=ptr.next;
            if(ptr==null) break;
        }
        if(temp!=null){
            while(ptr!=temp){
                crnt=ptr;
                ptr=ptr.next;
            }
            if(ptr==null) crnt.next=null;
            else crnt.next=temp.next;

        }
    }
    public E retrieve(int n){
        Node<E> ptr=head;
        int cnt=0;
        if(n<0) return null;
        else if(n==0) return head.data;
        else{
            while(ptr.next!=null){
                ptr=ptr.next;
                cnt++;
            }
            if(cnt<n) return null;
            ptr=head;
            while(n>0){
                ptr=ptr.next;
                n--;
            }
        }
        return ptr.data;
    }

}
