package Chapter6;

import java.util.Arrays;
import java.util.GregorianCalendar;

public class SortCalendar {
    public static void main(String[] args){
        GregorianCalendar[] x={
                new GregorianCalendar(2017,11,1),
                new GregorianCalendar(1963,10,18),
                new GregorianCalendar(1985,4,5),
        };
        Arrays.sort(x);
        for(int i=0;i<x.length;i++)
            System.out.printf("%04d년 %02d월 %02d일\n",x[i].get(1),x[i].get(2),x[i].get(5));
    }
}
