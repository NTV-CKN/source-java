package ex4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Utils {
	public final static String NAME_6_45 = "Lottery 6_45";
	public final static String NAME_6_55 = "Lottery 6_56";
	public final static String NAME_MEGA = "Lottery mega";
	public final static int NUM_6_45 = 0;
	public final static int NUM_6_55 = 1;
	public final static int NUM_MEGA = 2;
	public final static String PRIZE_6_45 = "Prize 6_45";
	public final static String PRIZE_6_55 = "Prize 6_55";
	public final static String PRIZE_MEGA = "Prize mega 4";
	public static int sizeLottery, sizePrize, countDraw6_45 = 0, countDraw6_55 = 0, countDrawMega4 = 0;
	public static List<String> special = new ArrayList<String>(), first = new ArrayList<String>(),
			second = new ArrayList<String>();
	public static boolean haveSpecial = false;

//	public static int[] get6_45() {
//		int[] arr = new int[3];
//		arr[0] = 6; // loop 
//		arr[1] = 1; //origin
//		arr[2] = 45; //bound
//		return arr;
//	}

	public static String dateToString(Date date) {
		DateFormat format = new SimpleDateFormat("dd/mm/YYYY");
		return format.format(date);
	}
}
