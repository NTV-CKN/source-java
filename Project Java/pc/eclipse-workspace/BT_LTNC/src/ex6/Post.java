package ex6;

import java.util.Arrays;
import java.util.Objects;

public class Post {
	private String text;
	private Comment[] comments = new Comment[1];
	private int iComment = 0;

	// constructor
	public Post(String text, Comment[] comments) {
		this.text = text;
		for (int i = 0; i < comments.length; i++) {
			if (comments[i] == null) {
				return;
			}
			if (this.comments[this.comments.length - 1] != null) {
				this.comments = (Comment[]) UpgradeSize.upgS(this.comments);
			}
			this.comments[i] = comments[i];
			iComment++;
		}
	}

	// add comment
	public void addComment(String comment) {
		if (this.comments[this.comments.length - 1] != null) {
			this.comments = (Comment[]) UpgradeSize.upgS(comments);
		}
		this.comments[iComment++] = new Comment(comment);
	}

	@Override
	public String toString() {
		return "Post:\ntext: " + text + "\ncomments:\n" + Arrays.toString(comments);
	}

	// getter and setter
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
