package ex6;

import java.util.Date;

public class Comment {
	private String comment;
	private Date date;

	// constructor
	public Comment(String comment) {
		date = new Date();
		this.comment = comment + ", time: " + date;
	}

	// getter
	public String getComment() {
		return comment;
	}

	@Override
	public String toString() {
		return "comment: " + comment + "\n";
	}
}
