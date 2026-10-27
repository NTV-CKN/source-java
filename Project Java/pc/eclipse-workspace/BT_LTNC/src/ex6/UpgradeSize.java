package ex6;

public class UpgradeSize {
	public static Object[] upgS(Object[] obj) {
		if (obj instanceof Post[]) {
			Post[] posts = new Post[obj.length + 5];
			for (int i = 0; i < obj.length; i++) {
				posts[i] = (Post) obj[i];
			}
			return posts;
		} else if (obj instanceof Comment[]) {
			Comment[] comments = new Comment[obj.length + 5];
			for (int i = 0; i < obj.length; i++) {
				comments[i] = (Comment) obj[i];
			}
			return comments;
		} else if (obj instanceof FriendShip[]) {
			FriendShip[] friendShips = new FriendShip[obj.length + 5];
			for (int i = 0; i < obj.length; i++) {
				friendShips[i] = (FriendShip) obj[i];
			}
			return friendShips;
		}
		return null;
	}
}
