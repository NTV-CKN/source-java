package ex6;

import java.util.Arrays;

public class User {
	private String name;
	private Post[] listPost = new Post[1];
	private FriendShip[] listFriend = new FriendShip[1];
	private int iPost = 0, iFriend = 0;

	// constructor
	public User(String name, Post[] listPost, FriendShip[] listFriend) {
		this.name = name;
		for (int i = 0; i < listPost.length; i++) {
			if (this.listPost[this.listPost.length - 1] != null) {
				this.listPost = (Post[]) UpgradeSize.upgS(this.listPost);
			}
			this.listPost[i] = listPost[i];
			iPost++;
		}

		for (int i = 0; i < listFriend.length; i++) {
			if (this.listFriend[this.listFriend.length - 1] != null) {
				this.listFriend = (FriendShip[]) UpgradeSize.upgS(this.listFriend);
			}
			this.listFriend[i] = listFriend[i];
			iFriend++;
		}
	}

	// create a post
	public void createPost(String text) {
		if (this.listPost[this.listPost.length - 1] != null) {
			this.listPost = (Post[]) UpgradeSize.upgS(this.listPost);
		}
		this.listPost[iPost++] = new Post(text, new Comment[5]);
	}

	// comment on post
	public void commentOnPost(String text, String comment) {
		for (int i = 0; i < listPost.length; i++) {
			if (this.listPost[i] == null) {
				break;
			}
			if (this.listPost[i].getText().equals(text)) {
				this.listPost[i].addComment(comment);
				break;
			}
		}
	}

	// add friend
	public void addFriend(FriendShip friend) {
		if (this.listFriend[this.listFriend.length - 1] != null) {
			this.listFriend = (FriendShip[]) UpgradeSize.upgS(this.listFriend);
		}
		this.listFriend[iFriend++] = friend;
	}

	// view time line
	public String viewTL() {
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < listPost.length; i++) {
			strB.append(listPost[i].toString() + "\n");
		}
		return strB.toString();
	}

	@Override
	public String toString() {
		return "User: name: " + name + "\nlistPost: \n" + Arrays.toString(listPost) + "\nlistFriend: \n"
				+ Arrays.toString(listFriend);
	}

}
