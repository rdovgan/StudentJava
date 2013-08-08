package compare;

import java.util.Comparator;

import proj.Student;

public class SortedBySurname implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		String surname1 = o1.getSurname();
		String surname2 = o2.getSurname();
		int res = surname1.compareTo(surname2);
		if(res==0){
			String name1 = o1.getName();
			String name2 = o2.getName();
			return name1.compareTo(name2);
		}
		return res;
	}
	
}
