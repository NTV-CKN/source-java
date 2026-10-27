package Ex_5_6;

import java.util.Objects;

/**
 * trong PhoneDirectory co 2 thuoc tinh:
+String name
+String phoneNumbers

 */
public class PhoneDirectory {
	public String name;//ten
	public String phoneNumber;//so dien thoai
	//constructor
	public PhoneDirectory(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return name+", "+phoneNumber;
	}


	
}
