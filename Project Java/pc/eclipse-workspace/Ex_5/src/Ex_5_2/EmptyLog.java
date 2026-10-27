package Ex_5_2;
/**
 * trong EmptyLog implements lai Interface ILog va constructor cua EmptyLog la rong
 vi du
 ILog ilog2 = new EmptyLog();
 */
public class EmptyLog implements ILog{
	//constructor
	public EmptyLog() {
	}
	//toString
	@Override
	public String toString() {
		return "";
	}
}
