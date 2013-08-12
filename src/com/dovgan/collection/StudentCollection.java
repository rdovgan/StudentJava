package com.dovgan.collection;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.dovgan.compare.SortedByBirth;
import com.dovgan.compare.SortedByGroup;
import com.dovgan.compare.SortedByMark;
import com.dovgan.compare.SortedBySurname;
import com.dovgan.model.Student;
import com.dovgan.model.StudentContainer;

public class StudentCollection implements IStudentCollection {
	StudentContainer data = null;

	public StudentCollection() {
		data = new StudentContainer();
	}

	public StudentCollection(List<Student> newList) {
		data = new StudentContainer(newList);
	}

	public static boolean isCorrect(Student student) {
		if (student == null)
			return false;
		Date dateBefore = new Date(0);
		Date dateAfter = new Date();
		if ((student.getSurname() == "") || (student.getName() == "")
				|| (student.getGroup() == 0) || (student.getMark() < 3)
				|| (student.getMark() > 5)
				|| (student.getBirth().before(dateBefore))
				|| (student.getBirth().after(dateAfter))
				|| ((student.getSex() != 'm') && (student.getSex() != 'f')))
			return false;
		return true;
	}

	public boolean add(Student newStudent) {
		return data.remove(newStudent);
	}

	public boolean remove(Student student) {
		return data.remove(student);
	}

	public Student removeById(long id) {
		return data.removeById(id);
	}

	public boolean change(Student newStudent, Student oldStudent) {
		if (isCorrect(oldStudent) && isCorrect(newStudent)) {
			data.remove(oldStudent);
			data.add(newStudent);
		}
		return false;
	}

	public boolean changeById(Student newStudent, long id) {
		if (isCorrect(newStudent)) {
			data.removeById(id);
			data.add(newStudent);
		}
		return false;
	}

	public double getMark(Student student) {
		return data.getMark(student);
	}

	public double getMarkById(long id) {
		return data.getMarkById(id);
	}

	public Student getById(long id) {
		return data.getById(id);
	}

	public Student get(Student student) {
		return data.get(student);
	}

	public List<Student> getBySurname(String surname) {
		return data.getBySurname(surname);
	}

	public List<Student> getFromGroup(int group) {
		return data.getFromGroup(group);
	}
	
	@Override
	public List<Student> getBySex(char sex) {
		return data.getBySex(sex);
	}

	public List<Student> getAboveMark(double mark) {
		return data.getAboveMark(mark);
	}

	public List<Student> getBeloveMark(double mark) {
		return data.getBeloveMark(mark);
	}

	public boolean sortedBySurname() {
		if (data == null)
			return false;
		Collections.sort(data.getList(), new SortedBySurname());
		return true;
	}

	public boolean sortedByMark() {
		if (data == null)
			return false;
		Collections.sort(data.getList(), new SortedByMark());
		return true;
	}

	public boolean sortedByGroup() {
		if (data == null)
			return false;
		Collections.sort(data.getList(), new SortedByGroup());
		return true;
	}

	public boolean sortedByBirth() {
		if (data == null)
			return false;
		Collections.sort(data.getList(), new SortedByBirth());
		return true;
	}

	public List<Student> getList() {
		return data.getList();
	}

}
