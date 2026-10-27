package ex4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class SaleAgent {
	public String id, address;
	public List<ADigitalLottery> listLottery;
	private int size, countCreate = 0;
	private Company company = null;
	public static int numToWin = 0;
	@SuppressWarnings("unused")
	private static String prize = "";

	public SaleAgent(String id, String address, int sizeListLottery) {
		super();
		this.id = id;
		this.address = address;
		if (sizeListLottery < 0)
			size = 0;
		else
			size = sizeListLottery;
		this.listLottery = new ArrayList<ADigitalLottery>();
		for (int i = 0; i < size; i++) {
			this.listLottery.add(null);
		}
	}

	public String printCustomRequest(String text, String option) {
		Utils.first.clear();
		Utils.second.clear();
		Utils.special.clear();

		ADigitalLottery digitalLot = checkListLottery(option);
		StringBuilder strB = new StringBuilder();
		int index = 0;
		try {
			if (digitalLot == null)
				return "";
			for (String number : digitalLot.getList()) {
				if (checkNumber(number, text, numToWin)) {
					strB.append("So ban nhap: " + text + "\n" + "Giai thuong " + prize + ", voi con so: "
							+ digitalLot.getList().get(index) + "\n");
				}
				index++;
			}
		} catch (Exception e) {
			return "";
		}
		return strB.toString();
	}

	private boolean checkNumber(String number, String text, int num) {
		String numInput[] = number.split(", ");
		String numResult[] = text.split(", ");
		int count = 0;
		for (int i = 0; i < numResult.length; i++) {
			if (numInput[i] == numResult[i])
				count++;
		}

		if (count == (numToWin - 2)) { // giai nhi
			Utils.second.add(number);
			prize = "Giai nhi";
		} else if (count == (numToWin - 1)) { // giai nhat
			Utils.second.remove(number);
			Utils.first.add(number);
			prize = "Giai nhat";
		} else if (count == numToWin){ // giai dac biet nhung chua toi uu
			if (!Utils.haveSpecial) {
				Utils.first.remove(number);
				Utils.special.add(number);
				Utils.haveSpecial = true;
				prize = "Giai dac biet";
			}
		}
		return count >= (numToWin - 2) ? true : false;
	}

	private ADigitalLottery checkListLottery(String option) {
		if (Utils.NAME_6_45.equals(option)) {
			numToWin = 6;
			return listLottery.get(0);
		} else if (Utils.NAME_6_55.equals(option)) {
			numToWin = 6;
			return listLottery.get(1);
		} else if (Utils.NAME_MEGA.equals(option)) {
			numToWin = 4;
			return listLottery.get(2);
		}
		return null;
	}

	/*
	 * luu cac con so trong list cua ADigital list trong lop nay chua 3 Lottery, moi
	 * lottery kiem tra null hay khong neu null thi tao moi doi tuong va tao moi
	 * list cho doi tuong do neu khong thi goi list cua doi tuong ra va add them
	 * data vao
	 */
	public String printRamdomLottery() {
		int random = new Random().nextInt(size);
		if (random == Utils.NUM_6_45) {
			if (listLottery.get(Utils.NUM_6_45) == null) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(randomNumber(list, 6, 1, 45));
				listLottery.add(Utils.NUM_6_45, new Lottery6_45(Utils.dateToString(Calendar.getInstance().getTime()),
						Utils.NAME_6_45 + ++countCreate, id, list));
				return getLotteryStr(listLottery.get(Utils.NUM_6_45), list.get(Utils.NUM_6_45).toString());
			} else {
				List<String> list = ((Lottery6_45) listLottery.get(Utils.NUM_6_45)).getList();
				list.add(randomNumber((ArrayList<String>) list, 6, 1, 45));
				return getLotteryStr(listLottery.get(Utils.NUM_6_45), list.get(list.size() - 1).toString());
			}
		}

		if (random == Utils.NUM_6_55) {
			if (listLottery.get(Utils.NUM_6_55) == null) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(randomNumber(list, 6, 1, 55));
				listLottery.add(Utils.NUM_6_55, new Lottery6_55(Utils.dateToString(Calendar.getInstance().getTime()),
						Utils.NAME_6_55 + ++countCreate, id, list));
				return getLotteryStr(listLottery.get(Utils.NUM_6_55), list.get(list.size() - 1).toString());
			} else {
				List<String> list = ((Lottery6_55) listLottery.get(Utils.NUM_6_55)).getList();
				list.add(randomNumber((ArrayList<String>) list, 6, 1, 55));
				return getLotteryStr(listLottery.get(Utils.NUM_6_55), list.get(list.size() - 1).toString());
			}
		}

		if (random == Utils.NUM_MEGA) {
			if (listLottery.get(Utils.NUM_MEGA) == null) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(randomNumber(list, 4, 1, 24));
				listLottery.add(Utils.NUM_MEGA, new LotteryMega4(Utils.dateToString(Calendar.getInstance().getTime()),
						Utils.NAME_MEGA + ++countCreate, id, list));
				return getLotteryStr(listLottery.get(Utils.NUM_MEGA), list.get(list.size() - 1).toString());
			} else {
				List<String> list = ((LotteryMega4) listLottery.get(Utils.NUM_MEGA)).getList();
				list.add(randomNumber((ArrayList<String>) list, 4, 1, 24));
				return getLotteryStr(listLottery.get(Utils.NUM_MEGA), list.get(list.size() - 1).toString());
			}
		}
		return "N";
	}

	private String getLotteryStr(ADigitalLottery a, String num) {
		return a.toString() + "\n\tCon so la: " + num;
	}

	private String randomNumber(ArrayList<String> list, int loop, int origin, int bound) {
		String num = "";
		num = generateNum(loop, origin, bound);
		while (true) { // loi
			if (!isExist(num, list)) {
				list.add(num);
				break;
			} else {
				num = generateNum(loop, origin, bound);
			}
		}
		return num;
	}

	private String generateNum(int loop, int origin, int bound) {
		Random randomNum = new Random();
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < loop - 1; i++) {
			strB.append(randomNum.nextInt(origin, bound) + ", ");
		}
		strB.append(randomNum.nextInt(origin, bound));
		return strB.toString();
	}

	private boolean isExist(String num, ArrayList<String> list) {
		for (String string : list) {
			if (string.equals(num)) {
				return true;
			}
		}
		return false;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
