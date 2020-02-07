package Chapter5;

public class QueenEx {
    static int[] pos = new int[8];
    static int[] max = new int[8];
    static int[] min = new int[8];

    static void print(){
        for(int i=0;i<8;i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }
    static void set(int i){
        for(int j=0;j<8;j++){
            int sw=0;
            for(int k=0;k<i;k++){
                if(j==pos[k]){
                    sw=1;
                }
            }
            if(sw==0){
                int sum=j+i;
                int sum2=i-j;
                for(int k=0;k<i;k++){
                    if(sum==max[k] || sum2==min[k]) sw=1;
                }
            }
            if(sw==1) continue;
            pos[i]=j;
            max[i]=i+j;
            min[i]=i-j;
            if(i==7) print();
            else{
                set(i+1);
            }
        }
    }
    public static void main(String args[]){
        set(0);
    }
}
