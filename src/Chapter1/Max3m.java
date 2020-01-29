package Chapter1;

public class Max3m {
    static int max3(int a,int b,int c){
        int max=a;
        if(b>max) max=b;
        if(c>max) max=c;
        return max;
    }
    static int max4(int a,int b,int c,int d){
        int max=a;
        if(b>max) max=b;
        if(c>max) max=c;
        if(d>max) max=d;
        return max;
    }
    static int min3(int a,int b,int c){
        int min=a;
        if(min>b) min=b;
        if(min>c) min=c;
        return min;
    }
    static int min4(int a,int b,int c,int d){
        int min=a;
        if(b<min) min=b;
        if(c<min) min=c;
        if(d<min) min=d;
        return min;
    }
    public static void main(String args[]){
        System.out.println("max(3,2,1)= "+max3(3,2,1));
        System.out.println("max(3,2,1,10)= "+max4(3,2,1,10));
        System.out.println("min(3,2,1)= "+min3(3,2,1));
        System.out.println("min(3,2,1,10)= "+min4(3,2,1,10));
    }
}
