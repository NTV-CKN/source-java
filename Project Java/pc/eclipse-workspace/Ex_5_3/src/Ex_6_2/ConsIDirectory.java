package Ex_6_2;
/**
 * trong ConsIDirectory co 2 thuoc tinh va 2 methods duoc ke thua tu IDirectory:
-PhoneDirectory db
-Directory dr

 */
public class ConsIDirectory extends IDirectory{
	private PhoneDirectory first;//kieu du lieu danh ba
	private IDirectory rest;//danh sach
	//constructor
	public ConsIDirectory(PhoneDirectory first, IDirectory rest) {
		super();
		this.first = first;
		this.rest = rest;
	}
	@Override
	public PhoneDirectory whoseNumber(String phoneNumbers) {
		PhoneDirectory phoneD = null;
		if(this.first.phoneNumber.equals(phoneNumbers)) {
			phoneD = this.first;
		}else {
			phoneD = this.rest.whoseNumber(phoneNumbers);
		}
		return phoneD;
	}

	

	@Override
	public PhoneDirectory phoneNumber(String name) {
		PhoneDirectory phoneD = null;
		if(this.first.name.equals(name)) {
			phoneD = this.first;
		}else {
			phoneD = this.rest.phoneNumber(name);
		}
		return phoneD;
	}

}
