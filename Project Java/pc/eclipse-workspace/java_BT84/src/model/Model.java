package model;

public class Model {
private double a, b, answer;
public Model() {
	this.a = 0;
	this.b = 0;
	this.answer = 0;
}
//getter setter
public double getA() {
	return a;
}
public void setA(double a) {
	this.a = a;
}
public double getB() {
	return b;
}
public void setB(double b) {
	this.b = b;
}
public double getAnswer() {
	return answer;
}
public void setAnswer(double answer) {
	this.answer = answer;
}
//phep cong
public void plus() {
	this.answer =this.a+this.b;
}
//phep tru
public void except() {
	this.answer =this.a-this.b;
}
//phep nhan
public void mutiply() {
	this.answer =this.a*this.b;
}
//phep chia
public void divide() {
	this.answer =this.a/this.b;
}
//phep mu
public void pow() {
	this.answer = Math.pow(a, b);
}
//phep mod
public void mod() {
	this.answer =this.a%this.b;
}
}
