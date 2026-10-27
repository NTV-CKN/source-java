
public class MTProduce extends ListProduce{

	@Override
	public String toString() {
		return "";
	}

	@Override
	public boolean checkProduce(Produce that) {
		return false;
	}

	@Override
	public String getDS(Produce that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListProduce sortByTitle() {
		return new MTProduce();
	}

	@Override
	public ListProduce insert(Produce that) {
		return new ConsProduce(that, new MTProduce());
	}

	@Override
	public double totalSL(String allocate) {
		return 0;
	}

	@Override
	public String pLSP(String allocate) {
		return "";
	}

}
