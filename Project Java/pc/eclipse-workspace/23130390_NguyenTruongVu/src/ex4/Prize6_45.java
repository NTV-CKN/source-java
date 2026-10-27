package ex4;

import java.util.Calendar;
import java.util.Random;

public class Prize6_45 extends APrize {
	private String name;

	public Prize6_45(double amount, String name, String rule, int size) {
		super(amount, name, rule, size);
		name = Utils.PRIZE_6_45;
	}

	public String getName() {
		return name;
	}

	@Override
	public void draw() {
		Random random = new Random();
		StringBuilder strB = new StringBuilder();
		listResult.add(new AResult(Utils.dateToString(Calendar.getInstance().getTime()), null, null, null));
		int indexCur = 0, prize = 0; // prize = 0 DB, 1 nhat, 2 nhi
		// giai dac biet
		while (prize < super.listResult.size()) {
			while (indexCur < 5) {
				strB.append(random.nextInt(1, 45) + ", ");
				indexCur++;
			}
			strB.append(random.nextInt(1, 45));
			indexCur = 0;
			System.out.println("Prize 6_45 giai " + prize + " co so: " + strB.toString());
			
			if (prize == 0) {
				listResult.get(listResult.size() - 1).setSpecialPrice(strB.toString());
				strB.delete(0, strB.length());
			} else if (prize == 01) {
				listResult.get(listResult.size() - 1).setSpecialPrice(strB.toString());
				strB.delete(0, strB.length());
			} else if (prize == 2) {
				listResult.get(listResult.size() - 1).setSpecialPrice(strB.toString());
				strB.delete(0, strB.length());
			}
			prize++;
		}
	}
}
