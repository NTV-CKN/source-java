package Ex_6_5;
/**
 * trong EmptyILog co 3 method duoc Override lai tu ILog
 */
public class EmptyILog extends ILog{

	@Override
	public double miles() {
		return 0;
	}

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
	public ILog insertILog(Entry that) {
		return new ConsILog(that, new EmptyILog());
	}

	@Override
	public ILog sort() {
		return new EmptyILog();
	}

}
