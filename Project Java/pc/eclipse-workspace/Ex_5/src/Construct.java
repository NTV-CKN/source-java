/**
 * trong Construct se thuc hien hoa lai Inventory, co 2 thuoc tinh trong Construct:
-Toy toy
-Inventory inventory
vi du :
	Inventory inv1 = new Construct(new Construct(new Construct(new Empty(), toy3), toy2), toy1);
 */
public class Construct implements Inventory{
	private Inventory inventory;
	private Toy toy;
	//constructor
	public Construct(Inventory inv, Toy toy) {
		this.inventory = inv;
		this.toy = toy;
	}
	//toString
	@Override
	public String toString() {
		return toy.toString() + inventory.toString() ;
	}
}
