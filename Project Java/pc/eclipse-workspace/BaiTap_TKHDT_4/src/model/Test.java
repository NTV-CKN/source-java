package model;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Test extends JFrame {

	public void display() {
		Tour tour1 = new DomesticTour("DaLat", "Da lat 3 ngay 2 dem", 3, 2555555);
		Tour tour2 = new OverseaTour("Japan", "Nhat Ban 5 ngay 5 dem", 5, 15000000, "Japanese", 1000000);
		Tour tour3 = new DomesticTour("DongNai", "Dong Nai 2 ngay 1 dem", 2, 1000000);
		Tour tour4 = new OverseaTour("ThaiLand", "Thai lan 3 ngay 2 dem", 3, 10000000, "Thailand", 2000000);

		String[] col = { "name", "description", "days", "basePrice", "country", "visaSurtax" };
		String[][] rows = {
				{ tour1.getName(), tour1.getDescription(), tour1.getDays() + "", tour1.getPrice() + "", "", "" },
				{ tour2.getName(), tour2.getDescription(), tour2.getDays() + "", tour2.getPrice() + "",
						((OverseaTour) tour2).getNameCountry(), ((OverseaTour) tour2).getVisaSurtax() + "" },
				{ tour3.getName(), tour3.getDescription(), tour3.getDays() + "", tour3.getPrice() + "", "", "" },
				{ tour4.getName(), tour4.getDescription(), tour4.getDays() + "", tour4.getPrice() + "",
						((OverseaTour) tour4).getNameCountry(), ((OverseaTour) tour4).getVisaSurtax() + "" } };

		JTable jtb = new JTable(rows, col);
		JScrollPane jScrollPane = new JScrollPane(jtb);
		this.add(jScrollPane);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("");
		this.setLocationRelativeTo(null);
		this.setSize(900, 400);
	}

	public static void main(String[] args) {
		new Test().display();
	}
}
