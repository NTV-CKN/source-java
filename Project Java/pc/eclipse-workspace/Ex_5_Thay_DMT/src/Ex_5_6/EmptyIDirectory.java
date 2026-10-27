package Ex_5_6;
/**
 * trong EmptyIDirectory co 2 methods duoc ke thua tu IDirectory
 */
public class EmptyIDirectory extends IDirectory{

	@Override
	public PhoneDirectory whoseNumber(String phoneNumbers) {
		return null;
	}

	@Override
	public PhoneDirectory phoneNumber(String name) {
		return null;
	}

}
