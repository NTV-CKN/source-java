package model;

import java.awt.Color;
import java.awt.ComponentOrientation;

public class Model {
	private String vuhs;
	private Color color_Text, color_BG;
	//constructor
	public Model() {
		this.vuhs = "vuhs";
//		this.color_Text = Color.PINK ;
//		this.color_BG = Color.PINK;
	}
	//setter getter
	
	
	public String getVuhs() {
		return vuhs;
	}

	public void setVuhs(String vuhs) {
		this.vuhs = vuhs;
	}


	public Color getColor_Text() {
		return color_Text;
	}


	public void setColor_Text(Color color_Text) {
		this.color_Text = color_Text;
	}


	public Color getColor_BG() {
		return color_BG;
	}


	public void setColor_BG(Color color_BG) {
		this.color_BG = color_BG;
	}

	
	//methods
	public void changeTextColor_red() {
		this.color_Text = Color.RED;
	}
	public void changeTextColor_yellow() {
		this.color_Text = Color.YELLOW;
	}
	public void changeTextColor_green() {
		this.color_Text = Color.GREEN;
	}
	public void changeBGColor_red() {
		this.color_BG = Color.RED;
	}
	public void changeBGColor_yellow() {
		this.color_BG = Color.YELLOW;
	}
	public void changeBGColor_green() {
		this.color_BG = Color.GREEN;
	}
	
}
