package com.dovgan.compare;

import java.util.Comparator;

import com.dovgan.model.Person;


public class SortedBySurname implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
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
