package proj;

import java.util.List;

public interface StudentCollection {
	
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
}
