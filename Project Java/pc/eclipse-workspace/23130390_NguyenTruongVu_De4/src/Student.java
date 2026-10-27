
public class Student {
public ScoreBoard rest;

public Student(ScoreBoard rest) {
	super();
	this.rest = rest;
}

@Override
public String toString() {
	return "Student [rest=" + rest + "]";
}
//gradeAverage
public double gradeAverage() {
	return this.rest.rest.resultAverage();
}
}
