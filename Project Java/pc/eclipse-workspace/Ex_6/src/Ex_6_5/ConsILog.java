package Ex_6_5;
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
		return "ConsILog [first="+"\n" + first + "\n"+" rest=" + rest + "]";
	}
	//this>=that
	@Override
	public ILog insertILog(Entry that) {
		ILog ds = null;
		if(that.equals(this.first)) {
			ds = new ConsILog(that, this);
		}else {
			ds = new ConsILog(this.first, this.rest.insertILog(that));
		}
		return ds;
	}
	@Override
	public ILog sort() {
		return this.rest.sort().insertILog(this.first);
	}

}
