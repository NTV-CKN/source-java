package Ex_5_5;
/**
 * trong ConsILog co 2 thuoc tinh va 3 methods duoc Override la tu ILog:
 -Entry first
 -ILog rest
 

 */
public class ConsILog extends ILog{
	private Entry first;
	private ILog rest;
	//constructor
		public ConsILog(Entry first, ILog rest) {
		this.first = first;
		this.rest = rest;
	}
	@Override
	public double miles() {
		return this.first.getDistance() + this.rest.miles();
	}
	@Override
	public double maxDistance() {
		double max = this.rest.maxDistance();
		if(this.first.getDistance() > max) {
			max = this.first.getDistance();
		}
		return max;
	}

	@Override
	public ILog getLogs(int month, int year) {
		ILog ds = null;
		if(this.first.sameMonthInAYear(month, year)) {
			ds = new ConsILog(first, rest.getLogs(month, year));
		}else {
			ds = rest.getLogs(month, year);
		}
		return ds;
	}
	@Override
	public String toString() {
		return "ConsILog [first=" + first + "\n"+", rest=" + rest + "]";
	}

}
