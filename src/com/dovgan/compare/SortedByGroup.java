package com.dovgan.compare;

import java.util.Comparator;

import com.dovgan.model.Student;


public class SortedByGroup implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int group1 = o1.getGroup();
		int group2 = o2.getGroup();
		if (group1 > group2)
			return 1;
		else if (group1 < group2)
			return -1;
		else {
			String surname1 = o1.getSurname();
			String surname2 = o2.getSurname();
			int res = surname1.compareTo(surname2);
			if (res == 0) {
				String name1 = o1.getName();
				String name2 = o2.getName();
				return name1.compareTo(name2);
			} else
				return res;
		}
	}

}
