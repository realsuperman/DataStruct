package Chapter5;

public class ArrayGCD {
    public static int gcdArray(int[] a){
        if(!isPositiveInteger(a)){
            System.out.println("양의정수의 최대 공약수만 구할수 있습니다.");
            return -1;
        }
        if(a.length==1) return a[0];
        int i=0;
        int temp = gcd(a[i],a[i+1]);
        if(temp==1) return 1;
        else{
            i=i+2;
            while(i<a.length){
                temp=gcd(temp,a[i]);
                if(temp==1) return 1;
                i++;
            }
        }
        return temp;
    }
    public static int gcd(int a,int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    public static boolean isPositiveInteger(int a[]){
        for(int i=0;i<a.length;i++){
            if(a[i]<=0) return false;
        }
        return true;
    }
    public static void main(String args[]){
        int[] array = new int[2];
        array[0]=22;
        array[1]=8;

        System.out.println(gcdArray(array));
    }
}
