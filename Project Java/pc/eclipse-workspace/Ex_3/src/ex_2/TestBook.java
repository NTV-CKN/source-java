package ex_2;
import junit.framework.*;
public class TestBook extends TestCase{
	public void testBook() {
	 	Author felleisen = new Author("Matthias Felleisen", 1960);
		Book htdch = new Book(felleisen, "How to Design Class Hierarchies", 0.0, 2004);
		
		Author friedman = new Author("Daniel P. Friedman", 1939);
		Book aljafp = new Book(friedman, "A Little Java, A Few Pattern", 25.9, 1998);
		
		Author a_1 = new Author("Vu", 2005);
		Author_cont ac_1 = new Author_cont(a_1, a_1.getName(), 12.12 , 2003, "Vu", 6, 1, 2005);
		
		Author a_2 = new Author("Vu", 2003);
		Author_cont ac_2 = new Author_cont(a_2, a_2.getName(), 12.12 , 2003, "Vu", 6, 1, 2005);

		//currentBook
		assertTrue(htdch.currentBook());
		assertFalse(aljafp.currentBook());
		//currentAuthor
		assertTrue(htdch.currentAuthor());
		assertFalse(aljafp.currentAuthor());
		//thisAuthor
		assertFalse(htdch.thisAuthor("Daniel P. Friedman"));
		assertTrue(htdch.thisAuthor("Matthias Felleisen"));
		//sameAuthor
		 assertTrue(htdch.sameAuthor(htdch));
		 assertFalse(htdch.sameAuthor(aljafp));
		 //sameGeneration
		 assertTrue(htdch.sameGeneration(htdch));
		 assertFalse(aljafp.sameGeneration(htdch));
		 //equals cont
		 assertTrue(ac_1.equals(ac_2));
	}
}
