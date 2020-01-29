package Chapter1;

public class Sumof {
    public static void main(String args[]){
        System.out.println(sumof(100,1));
    }
    public static int sumof(int a,int b){
        int sum=0;
        if(a>b){
            for(int i=b;i<=a;i++){
                sum+=i;
            }
            return sum;
        }
        for(int i=a;i<=b;i++){
            sum+=i;
        }
        return sum;
    }
}
