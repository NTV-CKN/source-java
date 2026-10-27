package Ex_5_3_5_9;
/**
 * trong IGrade khong co method, day la interface de tao ra vi tri de them thanh phan vao
vidu
		IGrade ds1 = new ConsIGrade(gr3, new MTIGrade());
		IGrade ds2 = new ConsIGrade(gr2, new ConsIGrade(gr3, new MTIGrade()));
		IGrade ds3 = new ConsIGrade(gr1, new MTIGrade());
 */
public interface IGrade {
public int howManyCredits();
public double gradeAverage();
public double sum();
public IGrade insert(GradeRecord that);
public IGrade sortByGradeDec();
public IGrade greaterThanList(double number);
}
