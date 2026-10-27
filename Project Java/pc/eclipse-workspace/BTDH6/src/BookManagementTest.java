import junit.framework.TestCase;
public class BookManagementTest extends TestCase{
	//testAuthorConstructor
	public void testAuthorConstructor() {
	  Author a =	new Author("Daniel Defoe,", 1660);
	}
	//testBookManagementConstructor
	public void testBookManagementConstructor() {
	  BookManagement bm = new BookManagement("Robinson Crusoe,", 15, 1719, new Author("Daniel Defoe,", 1660));
	}
}
