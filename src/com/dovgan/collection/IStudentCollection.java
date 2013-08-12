package com.dovgan.collection;
import java.util.List;

import com.dovgan.model.Student;

public interface IStudentCollection{
	public boolean add(Student newStudent);

	public boolean remove(Student student);

	public Student removeById(long id);

	public boolean change(Student newStudent, Student oldStudent);

	public boolean changeById(Student newStudent, long id);

	public double getMark(Student student);

	public double getMarkById(long id);

	public Student getById(long id);

	public Student get(Student student);

	public List<Student> getBySurname(String surname);

	public List<Student> getFromGroup(int group);

	public List<Student> getBySex(char sex);

	public List<Student> getAboveMark(double mark);

	public List<Student> getBeloveMark(double mark);

	public boolean sortedBySurname();

	public boolean sortedByMark();

	public boolean sortedByGroup();

	public boolean sortedByBirth();

	public List<Student> getList();
}
