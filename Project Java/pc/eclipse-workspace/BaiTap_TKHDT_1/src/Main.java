import model.Converter;
import model.DistanceConverter;
import view.ConvertView;

public class Main {
	public static void main(String[] args) {
		new ConvertView(new Converter(new DistanceConverter()));
	}
}
