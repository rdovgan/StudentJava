package proj;

import java.util.List;

public interface StudentCollection {
	
	public void addStudent(Student student);
	public void removeStudent(String surname, String name);
	public void changeStudent(String surname, String name, Student student);
	public double getStudentMark(String surname, String name);
	public Student getStudent(String surname, String name);
	public void getStudentsFromGroup(int group);
	public void getSortedBySurname();
	public void getSortedByMark();
}
