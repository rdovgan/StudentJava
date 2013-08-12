package com.dovgan.compare;

import java.util.Comparator;
import java.util.Date;

import com.dovgan.model.Person;


public class SortedByBirth implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		Date birth1 = o1.getBirth();
		Date birth2 = o2.getBirth();
		return birth1.compareTo(birth2);
	}

}
