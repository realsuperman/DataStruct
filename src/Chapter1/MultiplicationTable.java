package Chapter1;

public class MultiplicationTable {
    public static void main(String args[]){
        System.out.printf("   | 1  2  3  4  5  6  7  8  9\n");
        System.out.printf("---+-------------------\n");
        for(int i=1;i<=9;i++){
            System.out.printf("%d| ",i);
            for(int j=1;j<=9;j++){
                //System.out.printf("%3d",i*j);
                System.out.printf("%3d",i+j);
            }
            System.out.println();
        }
    }
}
