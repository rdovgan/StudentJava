package com.dovgan.model;

import java.util.ArrayList;
import java.util.List;

public class StudentContainer {

	List<Student> list = null;

	public StudentContainer() {
		list = new ArrayList<Student>();
	}

	public StudentContainer(List<Student> newList) {
		if (newList != null)
			list = newList;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public boolean add(Student student) {
		return list.add(student);
	}

	public boolean remove(Student student) {
		return list.remove(student);
	}

	public Student removeById(long id) {
		for (Student temp : list) {
			if (temp.getId() == id) {
				list.remove(temp);
				return temp;
			}
		}
		return null;
	}

	public Student getById(long id) {
		for (Student temp : list) {
			if (temp.getId() == id) {
				return temp;
			}
		}
		return null;
	}

	public Student get(Student student) {
		for (Student temp : list) {
			if (student.equalsName(temp)) {
				return temp;
			}
		}
		return null;
	}

	public double getMark(Student student) {
		Student temp = get(student);
		return temp.getMark();
	}

	public double getMarkById(long id) {
		Student temp = getById(id);
		return temp.getMark();
	}

	public List<Student> getBySurname(String surname) {
		List<Student> newList = null;
		for (Student temp : list) {
			if (temp.getSurname() == surname) {
				if (newList == null)
					newList = new ArrayList<Student>();
				newList.add(temp);
			}
		}
		return newList;
	}

	public List<Student> getFromGroup(int group) {
		List<Student> newList = null;
		for (Student temp : list) {
			if (temp.getGroup() == group) {
				if (newList == null)
					newList = new ArrayList<Student>();
				newList.add(temp);
			}
		}
		return newList;
	}

	public List<Student> getBySex(char sex) {
		List<Student> newList = null;
		for (Student temp : list) {
			if (temp.getSex() == sex) {
				if (newList == null)
					newList = new ArrayList<Student>();
				newList.add(temp);
			}
		}
		return newList;
	}
	public List<Student> getAboveMark(double mark) {
		List<Student> newList = null;
		for (Student temp : list) {
			if (temp.getMark() > mark) {
				if (newList == null)
					newList = new ArrayList<Student>();
				newList.add(temp);
			}
		}
		return newList;
	}

	public List<Student> getBeloveMark(double mark) {
		List<Student> newList = null;
		for (Student temp : list) {
			if (temp.getMark() < mark) {
				if (newList == null)
					newList = new ArrayList<Student>();
				newList.add(temp);
			}
		}
		return newList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		StudentContainer other = (StudentContainer) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

}
