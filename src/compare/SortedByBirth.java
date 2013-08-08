package compare;

import java.util.Comparator;
import java.util.Date;

import proj.Student;

public class SortedByBirth implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		Date birth1 = o1.getBirth();
		Date birth2 = o2.getBirth();
		return birth1.compareTo(birth2);
	}

}
