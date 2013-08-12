package com.dovgan.model;

import java.util.Date;


public class Student extends Person {
	private int group;
	private double mark;

	public Student() {
		super();
		group = 0;
		mark = Double.NaN;
	}

	public Student(String surname, String name, Date birth, int group,
			double mark, char sex) {
		super(surname, name, birth, sex);
		this.group = group;
		this.mark = mark;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + group;
		long temp;
		temp = Double.doubleToLongBits(mark);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (group != other.group)
			return false;
		if (Double.doubleToLongBits(mark) != Double
				.doubleToLongBits(other.mark))
			return false;
		return true;
	}

}
