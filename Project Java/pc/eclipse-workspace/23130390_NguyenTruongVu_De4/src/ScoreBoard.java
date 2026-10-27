
public class ScoreBoard {
public String name, clasS;
public IGradeRecord rest;
@Override
public String toString() {
	return "ScoreBoard [name=" + name + ", clasS=" + clasS + "\n"+", rest=" + rest + "]";
}
public ScoreBoard(String name, String clasS, IGradeRecord rest) {
	super();
	this.name = name;
	this.clasS = clasS;
	this.rest = rest;
}
//greaterThanList
public String greaterThanList(double save) {
	return this.rest.getGreater(save);
}
}
