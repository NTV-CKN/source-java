package ex6;

public class FriendShip {
	private String name;
	private boolean isFriend;

	// constructor
	public FriendShip(String name, boolean isFriend) {
		this.name = name;
		this.isFriend = isFriend;
	}

	// getter and setter
	public boolean isFriend() {
		return isFriend;
	}

	public void setFriend(boolean isFriend) {
		this.isFriend = isFriend;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "FriendShip: name: " + name;
	}
}
