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
	public double miles(Date date) {
	double save = 0;
		if(this.first.checkDate(date)) {
		save = this.first.getDistance() + this.rest.miles(date);
		}else {
		save = this.rest.miles(date);
		}
		return save;
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
	//this >=
	@Override
	public ILog insert(Entry that) {
		ILog ds = null;
		if(that.checkDuration(this.first)) {
			ds = new ConsILog(that, this);
		}else {
			ds = new ConsILog(this.first, this.rest.insert(that));
		}
		return ds;
	}
	@Override
	public ILog sortByDuration() {
		return this.rest.sortByDuration().insert(first);
	}

}
