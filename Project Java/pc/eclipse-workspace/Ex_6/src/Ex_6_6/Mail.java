package Ex_6_6;
/**
 * trong Mail co 3 thuoc tinh va 1phuong thuc so sanh Date
 -String from
 -Date date
 -String message
 
 +boolean equalsDate(Date that)
 	=>return this.date.sS(that);
 */
public class Mail {
	private String from, message;//gui tu, tin nhan
	private Date date;//ngay thang nam cua tin nhan
	//constructor
	public Mail(String from, String message, Date date) {
		super();
		this.from = from;
		this.message = message;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Mail [from=" + from + ", message=" + message + ", date=" + date + "]";
	}
	//equalsDate(Date that)
	public boolean equalsDate(Mail that) {
		return this.date.sS(that.date);
	}
}
