package Ex_6_2;
/**
 * trong IDirectory co 2 methods:
 	public abstract PhoneDirectory whoseNumber(String phoneNumbers);
 		=> dung de xac dinh ten cua nguoi co so dien thoai dua vao va tra ve KDL PhoneDirectory
	public abstract PhoneDirectory phoneNumber(String name);
		=>dung de xac dinh so dien thoai cua ten chu so huu khi dua vao va tra ve KDL PhoneDirectory
		
 */
public abstract class IDirectory {
	public abstract PhoneDirectory whoseNumber(String phoneNumbers);
	public abstract PhoneDirectory phoneNumber(String name);
}
