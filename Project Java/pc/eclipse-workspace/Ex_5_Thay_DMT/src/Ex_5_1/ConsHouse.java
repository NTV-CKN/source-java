package Ex_5_1;
/**
 * trong ConsHouse co 2 thuoc tinh:
private House first
private IHouse rest

day la lop implements lai tu IHouse dung de them House va tao them 1 vi tri cho thanh phan tiep theo
 */
public class ConsHouse implements IHouse{
	private House first;
	private IHouse rest;
	//constructor
	public ConsHouse(House first, IHouse rest) {
		super();
		this.first = first;
		this.rest = rest;
	}
	@Override
	public String toString() {
		return "ConsHouse [first=" + first + ", rest=" + rest + "]";
	}
	
}
