package Lession1;

public class CustomException extends Exception{
float x,y;
public CustomException(float x, float y) {
this.x=x; this.y=y; }

@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Loi chia khong: "+x+"/"+y;
	}

}
