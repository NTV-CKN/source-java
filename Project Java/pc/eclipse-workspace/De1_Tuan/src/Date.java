import java.util.Objects;

public class Date {
private int day, month, year;

public Date(int day, int month, int year) {
	super();
	this.day = day;
	this.month = month;
	this.year = year;
}

@Override
public String toString() {
	return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
}

@Override
public int hashCode() {
	return Objects.hash(day, month, year);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Date other = (Date) obj;
	return day == other.day && month == other.month && year == other.year;
}
//after
public boolean after(Date that) {
	boolean boo=false;
	if(this.getYear() > that.getYear()) {
		boo = true;
	}else if(this.month > that.month && this.getYear() == that.getYear()) {
		boo = true;
	}else if(this.day > that.getDay()&&this.month == that.month && this.getYear() == that.getYear()) {
		boo = true;
	}
	return boo;
}

public int getDay() {
	return day;
}

public void setDay(int day) {
	this.day = day;
}

public int getMonth() {
	return month;
}

public void setMonth(int month) {
	this.month = month;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}
}
