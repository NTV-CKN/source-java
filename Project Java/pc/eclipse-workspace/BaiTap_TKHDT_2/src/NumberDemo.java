import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Number;
import model.strategy.DectToBin;
import model.strategy.DectToHex;
import model.strategy.DectToOct;

class NumberDemo {
	@Test
	void test() {
		Number num = new Number(13, new DectToBin());
		assertEquals("1101", num.convert());
		
		num.setStrategy(new DectToHex());
		assertEquals("D", num.convert());
		
		num.setStrategy(new DectToOct());
		assertEquals("15", num.convert());
	}

}
