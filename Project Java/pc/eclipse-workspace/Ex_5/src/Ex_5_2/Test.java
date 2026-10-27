package Ex_5_2;
import junit.framework.*;
public class Test extends TestCase{
	public void testILog() {
		//khoi tao Date
		Date date1 = new Date(12, 12, 2005);
		Date date2 = new Date(9, 12, 2012);
		Date date3 = new Date(12, 11, 2024);
		//Khoi tao Entry
		Entry entry1 = new Entry(date1, 12.2, 12, "Bad");
		Entry entry2 = new Entry(date2, 22.2, 21, "Good");
		Entry entry3 = new Entry(date3, 5.0, 3, "Normal");
		//ILog
		ILog ilog1 = new ConstructLog(entry1, new ConstructLog(entry2, new ConstructLog(entry3, new EmptyLog())));
		ILog ilog2 = new EmptyLog();
		//sysout
		System.out.println(ilog1);
		System.out.println(ilog2);
	}
}
