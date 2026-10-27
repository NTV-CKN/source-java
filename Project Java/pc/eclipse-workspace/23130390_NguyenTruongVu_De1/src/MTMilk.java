
public class MTMilk extends IMilk{

	@Override
	public IMilk sortByVolumn() {
		return new MTMilk();
	}

	@Override
	public IMilk insert(Milk that) {
		return new ConsMilk(that, new MTMilk());
	}

	@Override
	public String listSameManufactor(Manufactor that) {
		return "";
	}

	@Override
	public IMilk deleteExpired() {
		return new MTMilk();
	}

}
