package java_BT58;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class main {
public static void main(String[] args) {

	//system.currentTimeMillis
	long t1 = System.currentTimeMillis();
	//timeUnit
	int day = 100;
	System.out.println("100 day to millis= " +TimeUnit.DAYS.toMillis(day));

	//java.util.Date
	Date x = new Date(System.currentTimeMillis());
	System.out.println("Thoi diem hien tai: "+ x.getDate()+"-"+(x.getMonth()+1)+"-"+(x.getYear()+1900));
	
	//calendar
	 Calendar cal = Calendar.getInstance();
	 java.util.Date date = cal.getTime();
	 System.out.println(date);
     System.out.println("Gio hom nay: "+cal.getTime().getHours());
     System.out.println("Gio hom nay: "+cal.get(Calendar.HOUR_OF_DAY));
     System.out.println("Gio hom nay: "+cal.get(Calendar.HOUR));
     System.out.println("Thang nay la: "+(cal.get(Calendar.MONTH )+1));
     System.out.println("Nam nay la: " + cal.get(Calendar.YEAR ));
     
     System.out.println("Doi nam 2023 thanh 2018: ");
     cal.set(Calendar.YEAR, 2018);
     System.out.println(cal.get(Calendar.YEAR));
    cal.add((Calendar.MONTH), 3);
     System.out.println(cal.get(Calendar.MONTH)+1);
  
     cal.roll(Calendar.DAY_OF_MONTH, false);
     System.out.println(cal.get(Calendar.DAY_OF_MONTH));
     System.out.println(cal.get(Calendar.ZONE_OFFSET));
     
     //SimpleDateFormat
     SimpleDateFormat v = new SimpleDateFormat("yyyy.MMM''MMMM''M.dd GGG hh:mm a 'at' ");
     System.out.println(v.format(cal.getTime()));
     //system.currentTimeMillis
     long t2 = System.currentTimeMillis();
     long tong = (t2 - t1)/1000;
     long tong1 = (t2-t1);
     System.out.println("So mls thuc thi toan bo chuong trinh: "+tong1+"mls");
     System.out.println("So giay thuc thi toan bo chuong trinh: "+tong+"s");
     
}
}
