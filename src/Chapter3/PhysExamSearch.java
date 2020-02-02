package Chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {
    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision=vision;
        }
        public String toString(){
            return name+" "+height+" "+vision;
        }
        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
        private static class HeightOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1,PhyscData d2){
                //System.out.println(d1.vision+" "+d2.vision);
                //return (d1.height > d2.height) ? 1:(d1.height<d2.height)?-1:0;
                return (d1.vision < d2.vision) ? 1:(d1.vision>d2.vision)?-1:0;
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PhyscData[] x={
                new PhyscData("이나령",162,1.5),
                new PhyscData("김한결",169,1.0),
                new PhyscData("홍준기",171,0.8),
                new PhyscData("전서현",173,0.7),
                new PhyscData("이호연",174,0.5),
                new PhyscData("이수민",175,0.3),
        };
        //System.out.print("몇 cm인 사람을 찾고 있나요? : ");
        //int height=sc.nextInt();
        System.out.print("시력 몇을 찾으시나요? ");
        double vision=sc.nextDouble();
        int idx= Arrays.binarySearch(x,new PhyscData("",0,vision),PhyscData.HEIGHT_ORDER);
        if(idx<0) System.out.println("요소가 없습니다.");
        else{
            System.out.println("x["+idx+"]에 있습니다.");
            System.out.println("찾은 데이터 : "+x[idx]);
        }
    }
}
