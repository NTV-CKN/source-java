package Ex_5_2;

import java.util.Objects;

/**
 * trong ConstructLog co 2 thuoc tinh:
-Entry entry
-ILog iLog
	day la lop implements ILog va co constructor nhan vao 2 tham so la Entry va ILog giup 
	tao thanh 1 list
	
	vidu
			ILog ilog1 = new ConstructLog(entry1, new ConstructLog(entry2, new ConstructLog(entry3, new EmptyLog())));

 */
public class ConstructLog implements ILog{
	private Entry entry;
	private ILog iLog;
	//constructo
	public ConstructLog(Entry entry, ILog iLog) {
		this.entry = entry;
		this.iLog = iLog;
	}
	//toString
	@Override
	public String toString() {
		return "Entry: "+entry.toString() + "; " +"\n"+iLog.toString();
	}
	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConstructLog other = (ConstructLog) obj;
		return Objects.equals(entry, other.entry) && Objects.equals(iLog, other.iLog);
	}
	
}
