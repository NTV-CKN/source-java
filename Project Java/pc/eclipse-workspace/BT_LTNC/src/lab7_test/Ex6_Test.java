package lab7_test;

import ex6.Comment;
import ex6.FriendShip;
import ex6.Post;
import ex6.User;
import junit.framework.TestCase;

public class Ex6_Test extends TestCase {
	public void testEx6() {
		FriendShip friendShips[] = { new FriendShip("Vu", true), new FriendShip("Ba", true) };
		Comment[] comments = { new Comment("Dong tinh"), new Comment("Dong y") };
		Post[] posts = { new Post("Day la bai qua nhieu van de de suy nghi!", comments) };
		User user = new User("Vux", posts, friendShips);

		StringBuilder strB = new StringBuilder();
		strB.append(user.toString());
		// add post
		user.createPost("Post 1: Bai nay cang nghi thi cang nghi nhieu hon");
		assertFalse(strB.toString().equals(user.toString()));
		strB.append(user.toString());
		// add comment
		user.commentOnPost("Post 1: Bai nay cang nghi thi cang nghi nhieu hon", "Dong y 2 tay");
		assertFalse(strB.toString().equals(user.toString()));
		strB.append(user.toString());
		// add friend
		user.addFriend(new FriendShip("Tuan", true));
		assertFalse(strB.toString().equals(user.toString()));
	}
}
