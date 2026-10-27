package Ex_6_6;
/**
 * trong EmptyMail chi chua 2 phuong thuc duoc Override lai tu IMail
 */
public class EmptyMail extends IMail{

	@Override
	public IMail insert(Mail that) {
		return new ConsMail(that, new EmptyMail());
	}

	@Override
	public IMail sort() {
		return new EmptyMail();
	}

	@Override
	public String toString() {
		return "";
	}

}
