package com.dovgan.compare;

import java.util.Comparator;

import com.dovgan.model.Student;


public class SortedByMark implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		double mark0 = arg0.getMark();
		double mark1 = arg1.getMark();
		if (mark0 < mark1)
			return 1;
		else if (mark0 > mark1)
			return -1;
		return 0;
	}

}
