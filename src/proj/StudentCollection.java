package proj;

import java.util.List;

public interface StudentCollection {
	
<<<<<<< HEAD
	public boolean addStudent(Student newStudent);
	public boolean removeStudent(Student student);
	public Student removeStudentById(long id);
	public boolean changeStudent(Student newStudent, Student oldStudent);
	public boolean changeStudentById(Student newStudent, long id);
	public double getStudentMark(Student student);
	public double getStudentMarkById(long id);
	public Student getStudentById(long id);
	public Student getStudent(Student student);
	public List<Student> getStudentsBySurname(String surname);
	public List<Student> getStudentsFromGroup(int group);
	public List<Student> getStudentsBySex(char sex);
	public List<Student> getStudentsAboveMark(double mark);
	public List<Student> getStudentsBeloveMark(double mark);
	public boolean sortedBySurname();
	public boolean sortedByMark();
	public boolean sortedByGroup();
	public boolean sortedByBirth();
	public List<Student> getList();
=======
	public void addStudent(Student student);
	public void removeStudent(String surname, String name);
	public void changeStudent(String surname, String name, Student student);
	public double getStudentMark(String surname, String name);
	public Student getStudent(String surname, String name);
	public void getStudentsFromGroup(int group);
	public void getSortedBySurname();
	public void getSortedByMark();
>>>>>>> e900f4d2a43c63821d28f0e45a7cbbe485428e17
}
