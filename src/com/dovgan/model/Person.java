package com.dovgan.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Person {

	private static Random random = new Random();

	private long id;
	private String name;
	private String surname;
	private Date birth;
	private char sex;

	public Person() {
		id = random.nextLong();
		name = "defaultName";
		surname = "defaultSurname";
		birth = new Date();
		sex = 'm';
	}

	public Person(String surname, String name) {
		id = random.nextLong();
		this.surname = surname;
		this.name = name;
		birth = new Date();
		sex = 'm';
	}

	public Person(String surname, String name, Date birth, char sex) {
		this(surname, name);
		this.birth = birth;
		this.sex = sex;
	}

	public Person(Person p) {
		this(p.getSurname(), p.getName(), p.getBirth(), p.getSex());
	}

	public boolean isCorrectString(String str) {
		if (str == "")
			return false;
		String[] arr = str.split("\t");
		if (arr.length == 0)
			return false;
		arr = str.split(" ");
		if (arr.length == 0)
			return false;
		return true;
	}

	public boolean isCorrectBirth() {
		DateFormat format = new SimpleDateFormat("dd/mm/yy");
		if (birth == null)
			return false;
		try {
			if (birth.after(new Date())
					|| (birth.before(format.parse("31/12/1969"))))
				return false;
			return true;
		} catch (ParseException e) {
			System.out.println("Problems with date");
			e.printStackTrace();
		}
		return false;
	}

	public boolean isCorrect() {
		if (!isCorrectString(this.surname) || !isCorrectString(this.name)
				|| (!isCorrectBirth())
				|| ((this.sex != 'f') && (this.sex != 'm')))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public boolean equalsName(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sex;
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex != other.sex)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
