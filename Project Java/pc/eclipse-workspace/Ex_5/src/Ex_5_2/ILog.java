package Ex_5_2;
/**
 * trong ILog la mot Interface rong, va no co 2 lop implements lai de tao thanh list
 vidu
 	ILog ilog1 = new ConstructLog(entry1, new ConstructLog(entry2, new ConstructLog(entry3, new EmptyLog())));
	ILog ilog2 = new EmptyLog();

		System.out.println(ilog1);
		System.out.println(ilog2);
 */
public interface ILog {

}
