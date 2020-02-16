package Chapter7;

import Chapter6.BubbleSort_csh;

public class IntSortedSet {
    private int max;
    private int num;
    private int[] set;
    public IntSortedSet(int capacity){
        num=0;
        max=capacity;
        try{
            set=new int[max];
        }catch(ArrayIndexOutOfBoundsException e){
            max=0;
        }
    }
    public int capacity(){
        return max;
    }
    public int size(){
        return num;
    }
    public int indexOf(int n){
        for(int i=0;i<num;i++)
            if(set[i]==n) return i;
        return -1;
    }
    public boolean contains(int n){
        return (indexOf(n)!=-1)?true:false;
    }
    public boolean add(int n){
        if(num>=max || contains(n)==true) return false;
        else{
            set[num++]=n;
            BubbleSort_csh.bubbleSort(set,num-1);
            return true;
        }
    }
    public boolean remove(int n){
        int idx;
        if(num<=0 || (idx=indexOf(n))==-1) return false;
        else{
            set[idx]=set[--num];
            BubbleSort_csh.bubbleSort(set,num);
            return true;
        }
    }
    public void copyTo(IntSortedSet s){
        int n=(s.max<num)?s.max:num;
        for(int i=0;i<n;i++) s.set[i]=set[i];
        s.num=n;
    }
    public void copyFrom(IntSortedSet s){
        int n = (max<s.num)?max:s.num;
        for(int i=0;i<n;i++)
            set[i]=s.set[i];
        num=n;
    }
    public boolean equalTo(IntSortedSet s){
        if(num!=s.num) return false;
        for(int i=0;i<num;i++){
            int j=0;
            for(;j<s.num;j++)
                if(set[i]==s.set[j]) break;
            if(j==s.num) return false;
        }
        return true;
    }
    public void unionOf(IntSortedSet s1,IntSortedSet s2){
        copyFrom(s1);
        for(int i=0;i<s2.num;i++) add(s2.set[i]);
    }
    public String toString(){
        StringBuffer temp = new StringBuffer("{");
        for(int i=0;i<num;i++)
            temp.append(set[i]+" ");
        temp.append("}");
        return temp.toString();
    }
    public boolean isEmpty(){
        if(num<=0) return true;
        return false;
    }
    public  boolean isFull(){
        if(num>=max) return true;
        return false;
    }
    public void clear(){
        num=0;
    }
    public boolean add(IntSortedSet s){
        int sw=num;
        unionOf(this,s);
        if(sw!=num) return true;
        return false;
    }
    public boolean retain(IntSortedSet s){
        boolean sw=false;
        int size=num;
        for(int i=0;i<size;i++){
            if(!s.contains(set[i])){
                sw=true;
                remove(set[i]);
            }
        }
/*        for(int i=0;i<num;i++){
            int j=0;
            for(;j<s.num;j++){
                if(set[i]==s.set[j]) break;
            }
            if(j==s.num){
                remove(set[i]);
                sw=true;
            }
        }*/
        if(sw) return true;
        return false;
    }

    public boolean remove(IntSortedSet s){
        boolean sw=false;
        int size=num;
        for(int i=0;i<size;i++){
            if(s.contains(set[i])){
                sw=true;
                remove(set[i]);
            }
        }
/*        for(int i=0;i<num;i++){
            int j=0;
            for(;j<s.num;j++){
                if(set[i]==s.set[j]){
                    remove(set[i]);
                    sw=true;
                }
            }
        }*/
        if(sw) return true;
        return false;
    }

    boolean isSubsetOf(IntSortedSet s){
        if(num!=s.num) return false;
        for(int i=0;i<s.num;i++){
            if(!contains(s.set[i])) return false;
        }
        return true;
    }
    boolean isProperSubsetOf(IntSortedSet s){
        if(num<=s.num) return false;
        for(int i=0;i<s.num;i++){
            if(!contains(s.set[i])) return false;
        }
        return true;
    }
    public void intersectionOf(IntSortedSet s1,IntSortedSet s2){
        s1.retain(s2);
        copyFrom(s1);
    }
    public void differentceOf(IntSortedSet s1,IntSortedSet s2){
        s1.remove(s2);
        copyFrom(s1);
    }
    public static void main(String args[]){
        IntSortedSet s1 = new IntSortedSet(20);
        IntSortedSet s2 = new IntSortedSet(20);
        IntSortedSet s3 = new IntSortedSet(20);

        s1.add(10);
        s1.add(15);
        s1.add(20);
        s1.add(25);
        s1.copyTo(s2);
        s2.add(12);
        s2.remove(25);
        s3.copyFrom(s2);
        System.out.println("s1 = "+s1);
        System.out.println("s2 = "+s2);
        System.out.println("s3 = "+s3);
        System.out.println("집합 s1에 15는 "+(s1.contains(15)?"포함됩니다.":"포함되지 않습니다."));
        System.out.println("집합 s2 25는 "+(s2.contains(25)?"포함됩니다.":"포함되지 않습니다."));
        System.out.println("집합 s1과 s2는 "+(s1.equalTo(s2)?"같습니다.":"같지 않습니다."));
        System.out.println("집합 s2와 s3는 "+(s2.equalTo(s3)?"같습니다.":"같지 않습니다."));

        //s1.differentceOf(s2,s3);
        //System.out.println("s1 = "+s1);


/*        IntSortedSet s4 = new IntSortedSet(20);
        s4.add(10);
        s4.add(15);
        s4.add(25);
        s4.add(20);
        s4.add(21);
        System.out.println(s1.isProperSubsetOf(s4));*/
        //s3.unionOf(s1,s2);
        //System.out.println("집합 s1과 s2의 합집합은 "+s3+"입니다.");
        //System.out.println(s3.isSubsetOf(s2));
        //s1.remove(s2);
        //System.out.println(s1.remove(s2));
        //System.out.println(s1);
        //s1.retain(s2);
        //System.out.println(s1.retain(s2));
        //System.out.println(s1);
        //s1.add(s2);
        //System.out.println(s1.add(s2));
        //System.out.println(s1);
/*        IntSortedSet s4 = new IntSortedSet(1);
        s4.add(10);
        s3.clear();
        System.out.println(s3.isEmpty());
        System.out.println(s4.isFull());*/

    }
}
