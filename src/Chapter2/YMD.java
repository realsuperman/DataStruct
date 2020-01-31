package Chapter2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class YMD {
    int y;
    int m;
    int d;

    public YMD(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    public void after(int n) {
        String date = y + "" + m + "" + d;
        if(date.length()<8){
            date=y + "0" + m + "" + d;
        }
        try{
            date=addDate(date,0,0,n);
            System.out.println(date);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void before(int n) {
        String date = y + "" + m + "" + d;
        if(date.length()<8){
            date=y + "0" + m + "" + d;
        }
        try{
            date=addDate(date,0,0,-n);
            System.out.println(date);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static String addDate(String dt, int y, int m, int d) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        Date date = format.parse(dt);
        cal.setTime(date);
        cal.add(Calendar.YEAR, y);
        cal.add(Calendar.MONTH, m);
        cal.add(Calendar.DATE, d);
        return format.format(cal.getTime());
    }
    public static void main(String args[]){
        YMD ymd = new YMD(2020,1,31);
        ymd.after(10);
        ymd.before(10);
    }

}
