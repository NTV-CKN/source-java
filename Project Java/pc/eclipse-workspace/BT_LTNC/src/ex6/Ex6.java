package ex6;

import java.util.Arrays;

public class Ex6 {
	public static void main(String[] args) {
		FriendShip friendShips[] = { new FriendShip("Vu", true), new FriendShip("Ba", true) };
		Comment[] comments = { new Comment("Dong tinh"), new Comment("Dong y") };
		Post[] posts = { new Post("Day la bai qua nhieu van de de suy nghi!", comments) };
		System.out.println(Arrays.toString(comments));
		User user = new User("Vux", posts, friendShips);

		System.out.println(user);
		System.out.println("=====================================");
		// add post
		user.createPost("Post 1: Bai nay cang nghi thi cang nghi nhieu hon");
		System.out.println(user);
		// add comment
		user.commentOnPost("Post 1: Bai nay cang nghi thi cang nghi nhieu hon", "Dong y 2 tay");
		System.out.println(user);
		// add friend
		user.addFriend(new FriendShip("Tuan", true));
		System.out.println(user);
	}
}
