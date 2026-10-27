
public class Date {
private int day, month, year;

@Override
public String toString() {
	return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
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

public Date(int day, int month, int year) {
	super();
	this.day = day;
	this.month = month;
	this.year = year;
}
//equals
public boolean checkProduceAfter(Date date) {
	boolean boo = false;
	if(this.year > date.year) {
		boo = true;
	}else if(this.year == date.year && this.month > date.month) {
		boo = true;
	}else if(this.year == date.year && this.month == date.month && this.day >= date.day) {
		boo = true;
	}
	return boo;
}
//
public boolean checkExpired() {
	boolean boo = false;
	if(this.year < 2022) {
		boo = true;
	}else if(this.year == 2022 && this.month < 12) {
		boo = true;
	}else if(this.year == 2022 && this.month == 12 && this.day<= 22) {
		boo = true;
	}
	return boo;
}
}
