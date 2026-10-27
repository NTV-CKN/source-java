package view;

import java.awt.Color;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class BubbleSortWorker extends SwingWorker<Void, Integer> {
	private int[] nums;
	private JLabel[] labels;
	private View v;

	public BubbleSortWorker(int[] nums, JLabel[] labels, View v) {
		this.nums = nums;
		this.labels = labels;
		this.v = v;
	}

	@Override
	protected Void doInBackground() throws Exception {
		int n = nums.length;
		boolean swapped;

		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					swap(j, j + 1);
					swapped = true;
				}
			}
			v.idem++;
			if (!swapped) {
				break;
			}
		}

		return null;
	}

	private void swap(int index1, int index2) throws InterruptedException {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;

		publish(index1, index2);

		// Pause for a short time to visualize the swap
		this.v.label_1.get(v.idem).setForeground(Color.RED);
		Thread.sleep(1200);

	}

	@Override
	protected void process(List<Integer> chunks) {
		int max = 0;
		for (int index : chunks) {
			labels[index].setText(String.valueOf(nums[index]));
			if (max < index) {
				max = index;
			}
		}
		labels[max].setForeground(Color.GREEN);
	}

	@Override
	protected void done() {
		// Sorting is complete, perform any necessary cleanup or UI updates
	}
}