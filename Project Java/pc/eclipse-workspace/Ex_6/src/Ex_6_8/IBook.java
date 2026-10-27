package Ex_6_8;
/**
 * trong IBook co 2 phuong thuc:
+IBook thisAuthor(Record that)
	=>return ve 1 danh sach cac cuon sach co cung ten voi tac gia
+IBook insert(Record that)
	=>return ve 1 kdl IBook dung de them 1 thang first vao trong danh sach cua sortByTitle truoc do tra ve
+IBook sortByTitle()
	=>return ve 1 kdl IBook cac thanh phan da duoc sap xep theo kieu String 
 */
public abstract class IBook {
	public abstract IBook thisAuthor(Record that);
	public abstract IBook insert(Record that);
	public abstract IBook sortByTitle();
	
}
