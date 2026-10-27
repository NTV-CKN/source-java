package Ex_5_5;
/**
 * trong EmptyILog co 3 method duoc Override lai tu ILog
 */
public class EmptyILog extends ILog{


	@Override
	public double maxDistance() {
		return 0;
	}

	@Override
	public ILog getLogs(int month, int year) {
		return new EmptyILog();
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public double miles(Date date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ILog insert(Entry that) {
		return new ConsILog(that, new EmptyILog());
	}

	@Override
	public ILog sortByDuration() {
		return new EmptyILog();
	}

}
