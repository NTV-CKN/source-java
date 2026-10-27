package ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Company {
	public List<SaleAgent> listAgent;
	public List<APrize> listPrize;
	public List<Integer> statisticAgents;

	public Company() {
		listAgent = new ArrayList<SaleAgent>();
		listPrize = new ArrayList<APrize>();
		statisticAgents = new ArrayList<Integer>();
		Utils.sizeLottery = 10;
		Utils.sizePrize = 3;
		newData(Utils.sizeLottery);
		initPrize(Utils.sizePrize);
	}

	/*
	 * phuong thuc nay nhan vao 1 con so tuong ung voi so thu tu cua danh sach cac
	 * dai li ve so, vd: num = 1 se tuong ung SaleAgent1. Su dung phuong thuc nay de
	 * goi printRandomLottery theo danh sach
	 */
	public String createLottery(int number) {
		try {
			if (number >= 1 && number <= Utils.sizeLottery) {
				return listAgent.get(number - 1).printRamdomLottery();
			}
		} catch (Exception e) {
			System.err.println("KHONG HOP LE!");
		}
		return "";
	}

	public void lotteryDraw() {

	}

	private void initPrize(int sizePrize) {
		Random random = new Random();
		listPrize.add(new Prize6_45(random.nextInt((int) Math.pow(10, 7), (int) Math.pow(10, 9)), Utils.PRIZE_6_45,
				"it thi 50k, nhieu thi 5 trieu", sizePrize));
		listPrize.get(listPrize.size() - 1).setCompany(this);
		listPrize.add(new Prize6_55(random.nextInt((int) Math.pow(10, 7), (int) Math.pow(10, 9)), Utils.PRIZE_6_55,
				"it thi 50k, nhieu thi 5 trieu", sizePrize));
		listPrize.get(listPrize.size() - 1).setCompany(this);
		listPrize.add(new PrizeMega4(random.nextInt((int) Math.pow(10, 7), (int) Math.pow(10, 9)), Utils.PRIZE_MEGA,
				"it thi 50k, nhieu thi 5 trieu", sizePrize));
		listPrize.get(listPrize.size() - 1).setCompany(this);
	}

	private void newData(int size) {
		int count = 0, lotterySize = 3;
		String idSaleAgent = "SaleAgent";
		while (count < size) {
			statisticAgents.add(null);
			if (count <= (size - (size * 0.6))) {
				listAgent.add(new SaleAgent(idSaleAgent + count, "HCM", lotterySize));
				listAgent.get(listAgent.size() - 1).setCompany(this);
			} else if (count <= (size - (size * 0.3))) {
				listAgent.add(new SaleAgent(idSaleAgent + count, "HCM", lotterySize));
				listAgent.get(listAgent.size() - 1).setCompany(this);
			} else {
				listAgent.add(new SaleAgent(idSaleAgent + count, "HCM", lotterySize));
				listAgent.get(listAgent.size() - 1).setCompany(this);
			}
			count++;
		}
	}

	public void randomPrize() {
		int index = 0;
		Utils.haveSpecial = false;
		while (index < Utils.sizePrize) {
			if (index >= 0 && index < 3) {
				listPrize.get(index).draw();
			}
			index++;
		}
	}

	public String checkLotteryPrize(String number, int index) {
		APrize prize = checkPrize(number, index);
		StringBuilder strB = new StringBuilder();
		String option = "";

		if (prize == null)
			return "KHONG HOP LE";
		else {
			if (index == 0)
				option = Utils.NAME_6_45;
			if (index == 1)
				option = Utils.NAME_6_55;
			if (index == 2)
				option = Utils.NAME_MEGA;
		}
		String str = "";
		for (SaleAgent saleAgent : listAgent) {
			if (haveNumInSaleAgent(number, saleAgent)) {
				str = saleAgent.printCustomRequest(number, option);
				if (!str.equals("")) {
					strB.append(saleAgent.id + " " + str + "\n");
				}
			}
		}
		return strB.toString();
	}

	public void checkLotteryPrize(ADigitalLottery a, AResult aR, int num, int index) {
		for (String str : a.getList()) {
			checkNumber(str, aR, num, index);
		}
	}

	/*
	 * don gian tang so lan trung ve so cua 1 agent len 1 don vi neu trung tu giai 2
	 * >
	 */
	private boolean checkNumber(String number, AResult aR, int num, int index) {
		String numInput[] = number.split(", ");
		String first[] = aR.firstPrice.split(", ");
		String second[] = aR.firstPrice.split(", ");
		String special[] = aR.firstPrice.split(", ");
		int count = 0;
		// loc giai nhi
		for (int i = 0; i < second.length; i++) {
			if (numInput[i] == second[i])
				count++;
		}
		if (count >= (num - 2)) {
			statisticAgents.add(index, statisticAgents.get(index) + 1);
			return true;
		}
		// loc giai nhat
		for (int i = 0; i < first.length; i++) {
			if (numInput[i] == first[i])
				count++;
		}
		if (count >= (num - 2)) {
			statisticAgents.add(index, statisticAgents.get(index) + 1);
			return true;
		}
		// loc giai dac biet
		for (int i = 0; i < special.length; i++) {
			if (numInput[i] == special[i])
				count++;
		}
		if (count >= (num - 2)) {
			statisticAgents.add(index, statisticAgents.get(index) + 1);
			return true;
		}
		return false;
	}

	public boolean haveNumInSaleAgent(String number, SaleAgent saleA) {
		for (ADigitalLottery a : saleA.listLottery) {
			if (a != null) {
				if (a.getList().contains(number)) {
					return true;
				}
			}
		}
		return false;
	}

	public APrize checkPrize(String text, int index) {
		if (index >= 0 && index < listPrize.size()) {
			return listPrize.get(index);
		}
		return null;
	}

	/*
	 * Gia su user nhap dung dinh dang dd/mm/YYYY trong day ta loc ra danh sach
	 * agent va cac ket qua co dung date sau do tien hanh thong ke so luong trung
	 * cua moi agent trong moi ket qua cung date
	 */
	public String getResultByPrizeDate(String date, String number, String option) { // chua toi uu
		statisticAgents.clear();
		if (Utils.NAME_6_45.equals(option) || Utils.NAME_6_55.equals(option)) {
			List<AResult> results = getSameDateResult(date, option);
			List<ADigitalLottery> lotteries = getSameDateLottery(date, option);
			int indexArr = 0;
			int[] arr = new int[lotteries.size()];
			for (int i = 0; i < statisticAgents.size(); i++) {
				if (statisticAgents.get(i) != null) {
					arr[indexArr++] = i;
				}
			}
			indexArr = 0;

			for (int i = 0; i < results.size(); i++) {
				Utils.haveSpecial = false;
				for (ADigitalLottery aDigitalLottery : lotteries) {
					checkLotteryPrize(aDigitalLottery, results.get(i), 6, arr[indexArr++]);
				}
				indexArr = 0;
			}
		} else if (Utils.NAME_MEGA.equals(option)) {
			List<AResult> results = getSameDateResult(date, option);
			List<ADigitalLottery> lotteries = getSameDateLottery(date, option);
			int indexArr = 0;
			int[] arr = new int[lotteries.size()];
			for (int i = 0; i < statisticAgents.size(); i++) {
				if (statisticAgents.get(i) != null) {
					arr[indexArr++] = i;
				}
			}
			indexArr = 0;

			for (int i = 0; i < results.size(); i++) {
				Utils.haveSpecial = false;
				for (ADigitalLottery aDigitalLottery : lotteries) {
					checkLotteryPrize(aDigitalLottery, results.get(i), 4, arr[indexArr++]);
				}
				indexArr = 0;
			}
		}
		int max = Integer.MIN_VALUE, indexMax = -1;
		for (int i = 0; i < statisticAgents.size(); i++) {
			if (statisticAgents.get(i) != null) {
				if (max < statisticAgents.get(i)) {
					max = statisticAgents.get(i);
					indexMax = i;
				}
			}
		}
		if (indexMax == -1) {
			return "Khong tim thay du lieu";
		}
		return listAgent.get(indexMax).id + " co so luong ve trung nhieu nhat la: " + max;
	}

	/*
	 * Lay ra cac result cung date
	 */
	public List<AResult> getSameDateResult(String date, String nameLottery) {
		List<AResult> list = new ArrayList<AResult>();

		for (int i = 0; i < listPrize.size(); i++) {
			if (listPrize.get(i).name.equals(nameLottery)) { // xet 3 ve so
				for (AResult aResult : listPrize.get(i).listResult) { // danh sach ket qua
					if (aResult.date.equals(date)) {
						list.add(aResult);
					}
				}
			}
		}
		return list;
	}

	/*
	 * Lay ra cac agent cung date, vi tri tuong ung trong statistic
	 */
	public List<ADigitalLottery> getSameDateLottery(String date, String option) {
		List<ADigitalLottery> list = new ArrayList<ADigitalLottery>();
		int index = 0, isClass = -1;

		if (option.equals(Utils.NAME_6_45))
			isClass = 0;
		if (option.equals(Utils.NAME_6_55))
			isClass = 1;
		if (option.equals(Utils.NAME_MEGA))
			isClass = 2;

		while (index < listAgent.size()) {
			for (ADigitalLottery aResult : listAgent.get(index).listLottery) {
				if(aResult == null) continue;
				if (aResult.date.equals(date)) {
					if (isClass == 0 && aResult instanceof Lottery6_45 
							|| isClass == 1 && aResult instanceof Lottery6_55
							|| isClass == 2 && aResult instanceof LotteryMega4) {
						list.add(aResult);
						if (statisticAgents.get(index) == null) {
							statisticAgents.add(index, 0);
						}
					}
				}
			}
			index++;
		}
		return list;
	}
}
