package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.SharedData;
import model.Thread1;
import model.Thread2;

public class View extends JFrame {
	public int idem = 0;
	public JPanel north_Layout, south_Layout, center_Layout;
	public JTextField jtext_Search_Sort, jtext_Array;
	public JButton jbut_Search, jbut_Accept, jbut_Start_Sort;
	public List<JLabel> label_1 = new ArrayList<JLabel>();
	public List<JLabel> label_2 = new ArrayList<JLabel>();
//	Map<JLabel, JLabel> list_Jbut_Jlab = new HashMap<JLabel, JLabel>();
	public int[] nums = null;
	private JButton jbut_Display;

	public View() {
		this.simulate();
	}

	public void simulate() {
		this.setTitle("Sorting");
		this.setSize(2000, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ac
		Controller ac = new Controller(this);

		// north_Layout
		north_Layout = new JPanel(new GridLayout(2, 2));

		// JTextField
		jtext_Search_Sort = new JTextField("");
		jtext_Array = new JTextField("");

		// JButton
		jbut_Search = new JButton("Search");
		jbut_Accept = new JButton("Accept");

		// set ac JButton of North
		jbut_Accept.addActionListener(ac);
		jbut_Search.addActionListener(ac);

		// setBackground, setForeground
		jbut_Search.setForeground(Color.YELLOW);
		jbut_Search.setBackground(Color.BLACK);
		jbut_Accept.setForeground(Color.YELLOW);
		jbut_Accept.setBackground(Color.BLACK);

		// add north_Layout
		north_Layout.add(jtext_Search_Sort);
		north_Layout.add(jbut_Search);
		north_Layout.add(jtext_Array);
		north_Layout.add(jbut_Accept);

		// south_Layout
		south_Layout = new JPanel(new GridLayout(1, 2));

		// add south_Layout
		jbut_Start_Sort = new JButton("Start");
		jbut_Display = new JButton("Display/Reset");

		// setbackground fore
		jbut_Start_Sort.setForeground(Color.YELLOW);
		jbut_Start_Sort.setBackground(Color.DARK_GRAY);
		jbut_Display.setForeground(Color.YELLOW);
		jbut_Display.setBackground(Color.DARK_GRAY);

		jbut_Display.addActionListener(ac);
		jbut_Start_Sort.addActionListener(ac);

		// add south_Layout
		south_Layout.add(jbut_Display);
		south_Layout.add(jbut_Start_Sort);

		// add thislayout
		this.setLayout(new BorderLayout());
		this.add(north_Layout, BorderLayout.NORTH);
		this.add(south_Layout, BorderLayout.SOUTH);
//		this.add(center_Layout, BorderLayout.CENTER);

		// setBackground Jpanel
		south_Layout.setBackground(Color.DARK_GRAY);
		north_Layout.setBackground(Color.LIGHT_GRAY);

		this.setVisible(true);
	}

	// split
	public void splitJText_Array(String str) {
		String arrString[] = str.split("(, |,| )");
		nums = new int[arrString.length];
		for (int i = 0; i < arrString.length; i++) {
			nums[i] = Integer.parseInt(arrString[i]);
		}
	}

	public void displayArray() {
		this.center_Layout = new JPanel(new GridLayout(3, nums.length));
		this.center_Layout.setBackground(Color.darkGray);
		Font font_To = new Font("Arial", Font.BOLD, 30);

		JLabel jlabel_1_Index = new JLabel("Loop i: ", JLabel.CENTER);
		jlabel_1_Index.setFont(font_To);
		jlabel_1_Index.setForeground(Color.YELLOW);
		this.center_Layout.add(jlabel_1_Index);

		for (int i = 0; i < nums.length; i++) {
			JLabel jlabel_1 = new JLabel("" + i, JLabel.CENTER);
			jlabel_1.setFont(font_To);
			jlabel_1.setForeground(Color.WHITE);
			label_1.add(jlabel_1);
			this.center_Layout.add(jlabel_1);
		}
		JLabel jlabel_2_Array = new JLabel("Array: ", JLabel.CENTER);
		jlabel_2_Array.setFont(font_To);
		jlabel_2_Array.setForeground(Color.yellow);
		this.center_Layout.add(jlabel_2_Array);

		for (int i = 0; i < nums.length; i++) {
			JLabel jlabel_2 = new JLabel("" + nums[i], JLabel.CENTER);
			jlabel_2.setFont(font_To);
			jlabel_2.setForeground(Color.BLACK);
			label_2.add(jlabel_2);
			this.center_Layout.add(jlabel_2);
		}
		this.add(center_Layout, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public void startArrayV2(int i) {
		SharedData.setIndex(i);
	}

	public void startArray(int[] nums) throws InterruptedException {
		// bubble sort
		int count = 0;
		boolean boo = true;
		for (int i = 0; i < nums.length; i++) {
			// set mau vong lap thu i
			label_1.get(i).setForeground(Color.RED);
			// trao doi data
			SharedData.getData();
			SharedData.sendData(i, nums.length);
			Thread t1 = new Thread();
			t1.start();
			for (int j = 0; j < nums.length - 1; j++) {
				SharedData.sendStringLabel(label_2.get(j).getText(), label_2.get(j + 1).getText());

				if (nums[j] > nums[j + 1]) {
					int swap = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = swap;
					boo = false;

				}
			}
			label_2.get(count + 1).setForeground(Color.GREEN);
			label_2.get(count).setForeground(Color.BLACK);
			if (boo) {
				break;
			}
			label_1.get(i).setForeground(Color.WHITE);
		}
		for (int i = 0; i < nums.length; i++) {
			SharedData.setJ(i);
			label_2.get(i).setForeground(Color.GREEN);
		}
	}

	public void startArrayV2(int[] nums) {
		JLabel[] numberLabels = new JLabel[nums.length];
		JLabel jlb = new JLabel("Sorted: ");
		Font font_To = new Font("Arial", Font.BOLD, 30);
		jlb.setFont(font_To);
		jlb.setForeground(Color.YELLOW);
		center_Layout.add(jlb);
		for (int i = 0; i < nums.length; i++) {
			numberLabels[i] = new JLabel(String.valueOf(nums[i]), JLabel.CENTER);
			numberLabels[i].setFont(new Font("Arial", Font.BOLD, 30));
			numberLabels[i].setForeground(Color.CYAN);
			center_Layout.add(numberLabels[i]);
		}
		BubbleSortWorker bubbleSortWorker = new BubbleSortWorker(nums, numberLabels, this);
		bubbleSortWorker.execute();

//	    this.label_1.get(idem).setForeground(Color.RED);
		this.setVisible(true);
	}

	// main thread
	public static void main(String[] args) {
		View v = new View();

	}
}
