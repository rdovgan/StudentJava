package proj;

public class Student {
	
	private String name;
	private String surname;
	private int group;
	private double mark;
	//add date of birth
	
	public Student(){
		name = "defaultName";
		surname = "defaultSurname";
		group = 0;
		mark = 0;
	}
	
	public Student(String name, String surname, int group, double mark){
		this.name = name;
		this.surname = surname;
		this.group = group;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}
	
	
}
