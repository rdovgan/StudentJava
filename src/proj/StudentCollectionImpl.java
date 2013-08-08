package proj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import compare.SortedByBirth;
import compare.SortedByGroup;
import compare.SortedByMark;
import compare.SortedBySurname;

public class StudentCollectionImpl implements StudentCollection {

	List<Student> list;

	public StudentCollectionImpl() {
		list = new ArrayList<Student>();
	}

	public StudentCollectionImpl(List<Student> newList) {
		list = newList;
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

	@Override
	public boolean addStudent(Student newStudent) {
		if (isCorrect(newStudent)) {
			list.add(newStudent);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeStudent(Student student) {
		if (isCorrect(student)) {
			list.remove(student);
			return true;
		}
		return false;
	}

	@Override
	public Student removeStudentById(long id) {
		for (Student temp : list) {
			if (temp.getId() == id) {
				list.remove(temp);
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean changeStudent(Student newStudent, Student oldStudent) {
		if (isCorrect(oldStudent) && isCorrect(newStudent)) {
			list.remove(oldStudent);
			list.add(newStudent);
		}
		return false;
	}

	@Override
	public boolean changeStudentById(Student newStudent, long id) {
		if (isCorrect(newStudent)) {
			removeStudentById(id);
			list.add(newStudent);
		}
		return false;
	}

	@Override
	public double getStudentMark(Student student) {
		Student temp = getStudent(student);
		return temp.getMark();
	}

	@Override
	public double getStudentMarkById(long id) {
		Student temp = getStudentById(id);
		return temp.getMark();
	}

	@Override
	public Student getStudentById(long id) {
		for (Student temp : list) {
			if (temp.getId() == id) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public Student getStudent(Student student) {
		for (Student temp : list) {
			if (student.equalsName(temp)) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public List<Student> getStudentsBySurname(String surname) {
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

	@Override
	public List<Student> getStudentsFromGroup(int group) {
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

	@Override
	public List<Student> getStudentsBySex(char sex) {
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

	@Override
	public List<Student> getStudentsAboveMark(double mark) {
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

	@Override
	public List<Student> getStudentsBeloveMark(double mark) {
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
	public boolean sortedBySurname() {
		if (list == null)
			return false;
		Collections.sort(list, new SortedBySurname());
		return true;
	}

	@Override
	public boolean sortedByMark() {
		if (list == null)
			return false;
		Collections.sort(list, new SortedByMark());
		return true;
	}

	@Override
	public boolean sortedByGroup() {
		if (list == null)
			return false;
		Collections.sort(list, new SortedByGroup());
		return true;
	}

	@Override
	public boolean sortedByBirth() {
		if (list == null)
			return false;
		Collections.sort(list, new SortedByBirth());
		return true;
	}

	@Override
	public List<Student> getList() {
		return list;
	}

}
