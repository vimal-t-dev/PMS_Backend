package practice;

public class encapsulation {
	private  String name;
	private  int age;
	private char grade;
	
	public encapsulation(){
		
	}
	
	public encapsulation(String name,int age,char grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	
	public String getname() {
		return name;
	}
	
	
	public int getage() {
		return age;
	}
	
	public char getgrade() {
		return grade;
	}
	
	public void setname(String name) {
		this.name=name;
	}
	
	public void setage(int  age) {
		this.age= age;
	}
	
	public void setgrade(char grade) {
		this.grade=grade;
	}
	
	
}
