package Chapter2;

public class PrimeNumber3 {
    public static void main(String args[]){
        int counter=0;
        int ptr=0;
        int[] prime=new int[500];
        prime[ptr++]=2;
        prime[ptr++]=3;
        for(int n=5;n<=1000;n=n+2){
            boolean flag=false;
            for(int i=1;prime[i]*prime[i]<=n;i++) {
                counter = counter + 2;
                if (n % prime[i] == 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                prime[ptr++]=n;
                counter++;
            }
        }
        for(int i=0;i<ptr;i++)
            System.out.println(prime[i]);
        System.out.println("나눗셈을 수행한 횟수 : "+counter);
        primeNumber();
    }
    static void primeNumber(){
        for(int i=3;i<=1000;i=i+2){
            boolean on=false;
            for(int j=3;j<Math.sqrt(i);j++){
                if(i%j==0){
                    on=true;
                    break;
                }
            }
            if(!on){
                System.out.println(i+"는 소수다.");
            }
        }
    }
}
