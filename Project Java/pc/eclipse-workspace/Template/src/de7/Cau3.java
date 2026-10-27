package de7;

import java.util.ArrayList;
import java.util.List;

public class Cau3 {
	static List<ArtObject> list = new ArrayList<ArtObject>();

	public static void createArray() {
		list.add(new Painting("Leonardo Da Vinci", "The Announciaton", 1473, "Son dau", "Hien dai"));
		list.add(new Painting("Leonardo Da Vinci", "The Baptism of  Christ", 1476, "Son dau", "Co dien"));
		list.add(new Painting("Leonardo Da Vinci", "Madonna of the Carnation", 1475, "Son dau", "Hien dai"));
		list.add(new Painting("Vincent Vangogh", "Text of the Origional Cherry", 0, "Son dau", "Co dien"));
		list.add(new Painting("Botero", "Botero beat oil painting", 0, "Son dau", "Co dien"));
	}

	public static List<ArtObject> getList() {
		return list;
	}

	public static void setList(List<ArtObject> list) {
		Cau3.list = list;
	}
}
